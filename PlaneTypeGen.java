//package terminal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PlaneTypeGen {
	static ArrayList<PlaneType> makePlaneList(){
		ArrayList<PlaneType> a = new ArrayList<PlaneType>();
		return a;
	}
	static void addPlaneType(ArrayList<PlaneType> a, Scanner console ) throws IOException {
		a.add(new PlaneType(setNAME(console, "Type"),Integer.valueOf(setNAME(console, "capacity")),Integer.valueOf(setNAME(console, "Speed"))));
			Collections.sort(a, new Comparator<PlaneType>() {
		    public int compare(PlaneType one, PlaneType other) {
		        return one.getType().compareTo(other.getType());
		    }
		});
		console.reset();
		PlaneTypeGen.writeArray(a);
	}
	static void remove(ArrayList<PlaneType> a, Scanner console) throws IOException {
		boolean test = false;
		int value = -1;
		while (test == false) {
			System.out.println("Please enter the plane type you wish to remove");
			String id = console.nextLine();
			for (int in = 0; in<a.size();) {
				String x = (a.get(in).getType());
					if (id.equals(x)) {
						value = in;
						test = true;
						a.remove(value);
					}
				in++;
			}
			if(test == false) {
				System.out.println("error no type found, returning to submenu");
				console.reset();
				return;
			}
		}
		console.reset();
		PlaneTypeGen.writeArray(a);
	}
	static String setNAME(Scanner console, String s) {
		System.out.println("please enter "+s);
		String y = console.nextLine();
		console.reset();
		return y;
	}
	static void printArray(ArrayList<PlaneType> a) {
		for(int in = 0; in<a.size();) {
			System.out.println(a.get(in++).toString());}
		}
	static void writeArray(ArrayList<PlaneType> a) throws IOException {
		int l = a.size();
		boolean run = false;
		while( run == false){
			String loc = "PlaneType.txt";
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
	static void readArray(ArrayList<PlaneType> a) {
		try {
			String output = null;
			String loc = "PlaneType.txt";
			FileReader i = new FileReader(loc);
			BufferedReader reader = new BufferedReader(i);
			while((output = reader.readLine()) != null){
				String[] parts = output.split("\t");
				String l0 = parts[0];
				int l1 = Integer.valueOf(parts[1]);
				int l2 = Integer.valueOf(parts[2]);
				a.add(new PlaneType(l0,l1,l2));
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Error file does not exist, file will be written upon exit");//catch if file does not exist
		}
	}
	static void editArray(ArrayList<PlaneType> a, Scanner console) throws IOException {
		boolean test = false;
		int value = -1;
		while (test == false) {
			System.out.println("Please enter the planeType name you wish to edit");
			String id = console.nextLine();
			for (int in = 0; in<a.size();) {
				String x = (a.get(in).getType());
					if (id.equals(x)) {
						value = in;
						test = true;
						int col = detCol(console);
						String val = setNAME(console, "value");
						if (col == 1) {
							a.get(value).setType(val);
						}
						else if (col == 2) {
							a.get(value).setCapacity(Integer.valueOf(val));
						}
						else if (col == 3) {
							a.get(value).setSpeed(Integer.valueOf(val));
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
	console.reset();
	PlaneTypeGen.writeArray(a);
	}
	private static int detCol(Scanner console) {
			int i =-1;
			boolean test = false;
			while (test == false) {
				console.reset();
				System.out.println("do you wish to edit TYPE, Capacity or speed");
				String s = console.nextLine().toLowerCase();
				if (s.equals("type")) {
					i = 1;
					test = true;
				}
				else if (s.equals("capacity")) {
					i = 2;
					test = true;
				}
				else if (s.equals("speed")) {
					i = 3;
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
		//Scanner console = new Scanner(System.in);
		//ArrayList<PlaneType> a = makePlaneList();
		//readArray(a);
		//addPlaneType(a, console);
		//addPlaneType(a,console);
		//printArray(a);
		//editArray(a, console);
		//printArray(a);
		//remove(a, console);
		//printArray(a);
		//writeArray(a);
	}
}
