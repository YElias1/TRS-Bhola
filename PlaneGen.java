//package terminal;
import java.io.*;
import java.text.*;
import java.util.*;
//import java.util.concurrent.*;

/*
 * TODO: CATCH BAD USER INPUTS *
 */


public class PlaneGen {


	static ArrayList<Plane> makePlane(){
		ArrayList<Plane> a = new ArrayList<Plane>();
		return a;
	}
	static int numGen(int size) {
		int s = size+1;
		Random g = new Random();
		int i = g.nextInt(s);
		return i;
	}
	static void addPlane(ArrayList<Plane> plane, ArrayList<AirportList> Airport, ArrayList<PlaneType> PlaneType ) throws IOException {
		int x = numGen(10000);
		String Fn = String.valueOf(x);
		x = numGen(PlaneType.size() -1);
		String Type = PlaneType.get(x).getType();     // me setting variables here b/c no like giant one line codes
		int Cap = PlaneType.get(x).getCapacity();
		int Speed = PlaneType.get(x).getSpeed();
		x = numGen(PlaneType.size()-1);
		String Start = Airport.get(x).getname();
		Double sx = Airport.get(x).getxcoord();
		Double sy = Airport.get(x).getycoord();
		boolean test = false;
		int x1 =-1;
		while (test == false) {
			x1 = numGen(Airport.size()-1);//RANDOM GENERATOR HERE to select airports
			if (x1 != x) {
				test = true;
			}
		}
		String End = Airport.get(x1).getname();
		Double ex = Airport.get(x1).getxcoord();
		Double ey = Airport.get(x1).getycoord();

		String Date = dateGen();
		String Time = timeGen(Date);
		String EfTime = arGen(sx,sy,ex,ey,Speed);
		plane.add(new Plane(Fn, Type, Cap, 0, Start, End, Date, Time, EfTime));// can you see how big this one line would have been?
			Collections.sort(plane, new Comparator<Plane>() {
		    public int compare(Plane one, Plane other) {
		        return one.getFlNum().compareTo(other.getFlNum());
		    }
		});
		PlaneGen.writeArray(plane);
	}
	private static String arGen(Double sx, Double sy, Double ex, Double ey,int speed) {
		String art = null;
		String add = "";
		int h =0;
		//T=D/V
		Double xdist = Math.abs((ex-sx));
		Double ydist = Math.abs((ey-sy));
		System.out.println(xdist+" "+ydist);
		Double HypD = Math.sqrt((xdist*xdist)+(ydist*ydist));
		int elt = (int) (HypD/Double.valueOf(speed)*60);
		elt = Math.round(elt);
		while(elt>=60) {
			elt = elt-60;
			h++;
		}
		if (elt<10){
			add = "0";
		}
		art = String.valueOf(h)+":"+add+String.valueOf(elt);
		return art;

	}
	private static String timeGen(String Date) {
		Date d = new Date();
		DateFormat currentdate = new SimpleDateFormat("yyyy/MM/dd");
		DateFormat currentHour = new SimpleDateFormat("HH");
		DateFormat currentMin = new SimpleDateFormat("mm");
		String CD = currentdate.format(d);
		String Time = null;
		if(Date.equals(CD)) {
			int t1 = numGen(23-Integer.valueOf(currentHour.format(d)))+Integer.valueOf(currentHour.format(d));
			int t2 = numGen(58-Integer.valueOf(currentMin.format(d)))+1+Integer.valueOf(currentMin.format(d));
			 Time = String.format("%02d", t1)+":"+String.format("%02d", t2); // combined into format HH:MM 24h format
		}
		else {
			int t1 = numGen(22)+1; // random departure time generated here HOURS
			int t2 = numGen(58)+1; // minutes
			 Time = String.format("%02d", t1)+":"+String.format("%02d", t2); // combined into format HH:MM 24h format
		}
		return Time;
	}
	private static String dateGen() {
		String s = null;
		DateFormat datey = new SimpleDateFormat("yyyy");
		DateFormat datem = new SimpleDateFormat("MM");     //making dates is hard...
		DateFormat dated = new SimpleDateFormat("dd");
		Date date = new Date();
			int Year = -1, Month = -1, Day = -1;
					Year = numGen(1)+Integer.valueOf(datey.format(date)); // setting this or next year
					int m =Integer.valueOf(datem.format(date));
					if (Integer.valueOf(datey.format(date)) == Year) {		//
						Month = numGen(12-(m))+m;						//
					}														//code to determine how month will be set if this or
					else {													// next year
						Month = numGen((m-1))+1;
					}
					if (Month == 1||Month == 3||Month == 5||Month == 7||Month == 8||Month == 10||Month == 12) {
						if(Month == Integer.valueOf(datem.format(date))) {
							if (Year == Integer.valueOf(datey.format(date))) {
								Day = numGen(31-Integer.valueOf(dated.format(date)))+Integer.valueOf(dated.format(date));
							}
							else {					// ditto for days, next year's date will always be one behind the current date
								Day = numGen(Integer.valueOf(dated.format(date))-2)+1;
							}
						}
						else {
							Day = numGen(30)+1;
						}
					}
					else if (Month == 2) {
						if (Year % 4 == 0 && Year % 400 != 0) {
							if(Month == Integer.valueOf(datem.format(date))) {
								if (Year == Integer.valueOf(datey.format(date))) {
									Day = numGen(29-Integer.valueOf(dated.format(date)))+Integer.valueOf(dated.format(date));
								}
								else {
									Day = numGen(Integer.valueOf(dated.format(date))-2)+1;
								}
							}
							else {
								Day = numGen(28)+1;
							}
						}
						else {

							if(Month == Integer.valueOf(datem.format(date))) {
								if (Year == Integer.valueOf(datey.format(date))) {
									Day = numGen(28-Integer.valueOf(dated.format(date)))+Integer.valueOf(dated.format(date));
								}
								else {//ditto
									Day = numGen(Integer.valueOf(dated.format(date))-2)+1;
								}
							}
							else {
								Day = numGen(27)+1;
							}
						}
					}
					else {
						if (Year == Integer.valueOf(datey.format(date))) {
							Day = numGen(30-Integer.valueOf(dated.format(date)))+Integer.valueOf(dated.format(date));
						}
						else {//ditto
							Day = numGen(Integer.valueOf(dated.format(date))-2)+1;
						}
					}
					String Months = String.valueOf(Month);
					String Days = String.valueOf(Day);
					if(Days.length()<2) {
						Days = "0"+Days;
					}
					if(Months.length()<2) {
						Months = "0"+Months;
					}
					s = Year+"/"+Months+"/"+Days;
					return s;
				}
	static void remove(ArrayList<Plane> a, int i) throws IOException {
		a.remove(i);
		PlaneGen.writeArray(a); // automated removal used by the inflightgen method
	}
	static void removeU(ArrayList<Plane> a, Scanner console) throws IOException {
		boolean test = false;
		int value = -1;
		while (test == false) { //user removal method
			System.out.println("Please enter the Flight Number you wish to remove");
			String id = console.nextLine().toLowerCase();
			for (int in = 0; in<a.size();) {
				String x = (a.get(in).getFlNum().toLowerCase());
					if (id.equals(x)) {
						value = in;
						test = true;
						a.remove(value);
						PlaneGen.writeArray(a);
					}
				in++;
			}
			if(test == false) {
				System.out.println("error no plane found, returning to submenu");
				console.reset();
				return;
			}
		}
		console.reset();
	}
	static String setNAME(Scanner console, String s) {
		System.out.println("please enter "+s);
		String y = console.nextLine(); // we meet again setname
		console.reset();
		return y;
	}
	static void printArray(ArrayList<Plane> a) {
		for(int in = 0; in<a.size();) {// and you too, printArray
			System.out.println("["+a.get(in++).toString()+"]");}
		}
	static void writeArray(ArrayList<Plane> a) throws IOException  {
		int l = a.size();
		boolean run = false;
		while( run == false){
			String loc = "Plane.txt";//SSDD. values changed
			File newTextFile = new File(loc);
			BufferedWriter fw;
				fw = new BufferedWriter(new FileWriter(newTextFile));

			for(int in =0; in<l;) {
				String test = a.get(in++).toString();
				fw.write(test);
				fw.newLine();
			}
			fw.close();
			run = true;

		}

	}
	static void readArray(ArrayList<Plane> a) {
		try {
			String output = null;
			String loc = "Plane.txt";
			FileReader i = new FileReader(loc);
			BufferedReader abc = new BufferedReader(i);
			while((output = abc.readLine()) != null){
				String[] parts = output.split("\t");
				String l0 = parts[0];
				String l1 = parts[1];
				int l2 = Integer.valueOf(parts[2]);//SSDD number of strings changed b/c of different array sizes
				int l3 = Integer.valueOf(parts[3]);
				String l4 = parts[4];
				String l5 = parts[5];
				String l6 = parts[6];
				String l7 = parts[7];
				String l8 = parts[8];
				a.add(new Plane(l0,l1,l2,l3,l4,l5,l6,l7,l8));
			}
			abc.close();
		}
		catch (IOException e) {
			System.out.println("Error file does not exist, file will be written by program, if we feel like it");//catch if file does not exist
		}
	}
	static void editArray(ArrayList<Plane> a, Scanner console) throws IOException {
		boolean test = false;
		int value = -1;
		while (test == false) {
			System.out.println("Please enter the flight number you wish to edit");
			String id = console.nextLine();
			for (int in = 0; in<a.size();) {
				String x = (a.get(in).getFlNum());
					if (id.equals(x)) {
						value = in;
						test = true;
						int col = detCol(console);//allows user to edit shit for testing
						String val = null;
						if (col <5) {
						val = setNAME(console, "value");
						}
						if (col == 1) {
							a.get(value).setFlNum(val);
						}
						else if (col == 2) {
							a.get(value).setCap(Integer.valueOf(val));
						}
						else if (col == 3) {
							a.get(value).setNumPass(Integer.valueOf(val));
						}
						else if (col == 4) {
							a.get(value).setEndLoc(val);
						}
						else if (col == 5) {
							String time = TimeSet(console);
							a.get(value).setdepartTime(time);
						}
						else if (col == 6) {
							String date = DateSet(console);
							a.get(value).setDDate(date);
						}

					}
				in++;
			}
			if(test == false) {
				System.out.println("error no airport found, returning to submenu");
				console.reset();
				return;
			}
		}
	PlaneGen.writeArray(a);
	console.reset();
	}
	private static String DateSet(Scanner console) {
		boolean test = false;
		String comb = null;
		while (test == false) {
			System.out.println("Enter Year");
			int y = console.nextInt();
			System.out.println("enter Month"); // allows me to manually set the date for testing purposes
			int m = console.nextInt();
			System.out.println("enter Day");
			int d = console.nextInt();
			if (y<9999 && m <12 && d<31 ) {
				comb = String.format("%04d", y)+"/"+String.format("%02d", m)+"/"+String.format("%02d", d);
				test = true;
			}
		}
		return comb;

	}
	private static String TimeSet(Scanner console) {
		boolean test = false;
		String comb = null;
		while (test == false) {
			System.out.println("Enter Hour");
			int s = console.nextInt();
			System.out.println("enter minute"); // allows me to set the time for testing purposes
			int s1 = console.nextInt();
			if (s<24 && s1 <60) {
				comb = String.format("%02d", s)+":"+String.format("%02d", s1);
				test = true;
			}
		}
		return comb;
	}
	private static int detCol(Scanner console) {
			int i =-1;
			boolean test = false;
			while (test == false) {
				console.reset();
				System.out.println("do you wish to edit FN, CAP, Numpass, Dest, DEPtime, or DEPdate,");
				String s = console.nextLine().toLowerCase();
				if (s.equals("fn")) {
					i = 1;
					test = true;
				}
				else if (s.equals("cap")) {
					i = 2;
					test = true;
				}
				else if (s.equals("numpass")) { // the actual selection screen
					i = 3;
					test = true;
				}
				else if (s.equals("dest")) {
					i = 4;
					test = true;
				}
				else if (s.equals("deptime")) {
					i = 5;
					test = true;
				}
				else if (s.equals("depdate")) {
					i = 6;
					test = true;
				}
				else {
					System.out.println("error bad input");
				}
			}
	console.reset();
	return i;
	}
	public static void main(String[] args) throws IOException {
		ArrayList<Plane> plane = PlaneGen.makePlane();
		ArrayList<AirportList> AL = AirListGen.makeAirList();
		ArrayList<PlaneType> PT = PlaneTypeGen.makePlaneList();
		AirListGen.readArray(AL);
		PlaneTypeGen.readArray(PT);
		//PlaneGen.readArray(plane);
		/*Scanner console = new Scanner(System.in);
		Runnable test = new Runnable() {						// me testing shit...
			public void run() {
				for(int i = 0; i<10; i++) {
					PlaneGen.addPlane(plane, AL, PT, console);
					PlaneGen.printArray(plane);
					PlaneGen.writeArray(plane);
				}
			}
		};
		ScheduledExecutorService exe = Executors.newScheduledThreadPool(1);
		exe.scheduleAtFixedRate(test, 3, 3, TimeUnit.SECONDS);*/
		for (int i=0; i<PT.size(); i++) {
		System.out.println(PT.get(i).getSpeed());}

	}




}
