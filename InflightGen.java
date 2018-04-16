//package terminal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

public class InflightGen {
	static ArrayList<Inflight> makefly(){
		ArrayList<Inflight> a = new ArrayList<Inflight>();
		return a;
	}
	private static void MovePlaneToFlight(ArrayList<Inflight> Inflight, ArrayList<Plane> plane, ArrayList<AirportList> AirportList, ArrayList<PlaneType> PlaneType, int i) throws IOException {
		int speed =-1;
		String s = plane.get(i).getType();
		for(int t=0; t<PlaneType.size();t++) {
			String s1 = PlaneType.get(t).getType();//this block of code pulls the speed data entry from plane class
			if(s.equals(s1)) {						//using the known type from the array
				speed = PlaneType.get(t).getSpeed();
				break;
			}
		}
		double xcoord =-1;
		double ycoord =-1;
		String startloc = plane.get(i).getSloc();
		for(int t=0; t<AirportList.size();t++) {
			String s1 = AirportList.get(t).getname();//exact same thing here, except this time its x+y coord
			if(startloc.equals(s1)) {				//from airport array
				xcoord = AirportList.get(t).getxcoord();
				ycoord = AirportList.get(t).getycoord();
				break;
			}
		}
		Inflight.add(new Inflight(plane.get(i).getFlNum(), speed, 0, plane.get(i).getSloc(), plane.get(i).getEloc(), xcoord, ycoord,plane.get(i).getDept()));
		Collections.sort(Inflight, new Comparator<Inflight>() {
	    public int compare(Inflight one, Inflight other) {				//add all the entries to the array flight number
	        return one.getFlightNum().compareTo(other.getFlightNum());
	    } // sorting the entry as it is added to the arraylist
	});
		System.out.println("Adding array");
		InflightGen.writeArray(Inflight);

	}
	static void CheckifNeedMove(ArrayList<Plane> plane,ArrayList<Inflight> Inflight,ArrayList<AirportList> AirportList, ArrayList<PlaneType> PlaneType) throws IOException {
		Date d = new Date();
		DateFormat datey = new SimpleDateFormat("yyyy/MM/dd");
		DateFormat timey = new SimpleDateFormat("HH:mm");   //setting up the format to check against here
		String s = datey.format(d);
		String t = timey.format(d);

		for(int i=0; i<plane.size(); i++) {
			String date = plane.get(i).getDDate();//GRABBING the departure date and dep time from the plane array
			String time = plane.get(i).getDept();
			if(date.equals(s)&&time.equals(t)) {// for if loop that will transfer the plane over to the inflight array if date
				MovePlaneToFlight(Inflight, plane, AirportList, PlaneType, i);//lines up... used with scheduled executor service
				PlaneGen.remove(plane, i);
				break;
			}
		}
	}
	static void printArray(ArrayList<Inflight> a) {
		for(int in = 0; in<a.size();) {							// print out the array to screen
			System.out.println("["+a.get(in++).toString()+"]");}
		}
	static void writeArray(ArrayList<Inflight> a) throws IOException {
		int l = a.size();
		boolean run = false;						//writes/overwrites file to plain TXT file in program directory
		while( run == false){				// entries separated by tabs
			String loc = "Inflight.txt";
			File newTextFile = new File(loc);
			BufferedWriter fw = new BufferedWriter(new FileWriter(newTextFile));
			for(int in =0; in<l;) {
				String test = a.get(in++).toString();
				fw.write(test);
				fw.newLine();
			}
			fw.close();
			run = true;
		}
	}
	static void readArray(ArrayList<Inflight> a) {
		try {
			String output = null;
			String loc = "Inflight.txt";			//pulls up file
			FileReader i = new FileReader(loc);
			BufferedReader abc = new BufferedReader(i);
			while((output = abc.readLine()) != null){
				String[] parts = output.split("\t");// each entry is read and placed into proper position
				String l0 = parts[0];
				int l1 = Integer.valueOf(parts[1]);
				int l2 = Integer.valueOf(parts[2]);
				String l3 = parts[3];
				String l4 = parts[4];
				Double l5 = Double.valueOf(parts[5]);
				Double l6 = Double.valueOf(parts[6]);
				String l7 = parts[7];
				a.add(new Inflight(l0,l1,l2,l3,l4,l5,l6,l7));//each line is read, and then added.
			}
			abc.close();
		}
		catch (IOException e) {
			System.out.println("Error file does not exist, don't worry, we can fix that");//catch if file does not exist
		}
	}
	public static void main(String[] args) throws IOException {
		//I Scanner console = new Scanner(System.in);
		ArrayList<Plane> plane = PlaneGen.makePlane();
		ArrayList<AirportList> AL = AirListGen.makeAirList(); // me testing shit here.
		ArrayList<PlaneType> PT = PlaneTypeGen.makePlaneList();
		ArrayList<Inflight> IL = InflightGen.makefly();
		AirListGen.readArray(AL);
		PlaneTypeGen.readArray(PT);
		PlaneGen.readArray(plane);
		InflightGen.readArray(IL);
		InflightGen.printArray(IL);
		for(int i = 0; i<1; i++) {
			PlaneGen.addPlane(plane, AL, PT);
		}
		PlaneGen.printArray(plane);
		//I PlaneGen.editArray(plane, console);
		//I console.nextLine();
		//I PlaneGen.editArray(plane, console);
		//InflightGen.CheckifNeedMove(plane, IL, AL, PT);
		//printArray(IL);
		//Tracker.coordediter(IL, AL);
		Runnable test = new Runnable() {
			public void run() {

					try {
						InflightGen.CheckifNeedMove(plane, IL, AL, PT);


				Tracker.coordediter(IL, AL);
					} catch (IOException e) {
						e.printStackTrace();
					}
				InflightGen.printArray(IL);
			}
		};
		ScheduledExecutorService exe = Executors.newScheduledThreadPool(1);
		exe.scheduleAtFixedRate(test, 3, 10, TimeUnit.SECONDS);
		}


}
