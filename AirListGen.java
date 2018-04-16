//package terminal;

import java.io.*;
import java.util.*;
/*
 * TODO: Catch bad user inputs!
 */
public class AirListGen {
	static ArrayList<AirportList> makeAirList(){
		ArrayList<AirportList> a = new ArrayList<AirportList>(); // basic make array here
		return a;
	}
	static void addAirport(ArrayList<AirportList> a, Scanner console ) throws IOException {
		a.add(new AirportList(setNAME(console, "AIRPORT NAME"),Double.valueOf(setNAME(console, "XCOORD")),Double.valueOf(setNAME(console, "YCOORD"))));
			Collections.sort(a, new Comparator<AirportList>() {
		    public int compare(AirportList one, AirportList other) { // allows user to add their own entries to the program while
		        return one.getname().compareTo(other.getname()); // it is still running
		    }
		});
		console.reset();
		AirListGen.writeArray(a);//console is acting a bit buggy, this fixes most of the issues.
	}// issues persist in other areas still... working on it
	static void remove(ArrayList<AirportList> a, Scanner console) throws IOException {
		boolean test = false;
		int value = -1;		// this allows a user to remove an entry while program is still up
		while (test == false) {
			System.out.println("Please enter the airport name you wish to remove");
			String id = console.nextLine().toLowerCase();
			for (int in = 0; in<a.size();) {
				String x = (a.get(in).getname().toLowerCase());
					if (id.equals(x)) {
						value = in;
						test = true;
						a.remove(value);
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
		AirListGen.writeArray(a);
	}
	static String setNAME(Scanner console, String s) {
		System.out.println("please enter "+s);
		String y = console.nextLine(); // basic setter for pretty much everyone. just copypasta'd into every method b/c lazy
		console.reset();
		return y;
	}
	static void printArray(ArrayList<AirportList> a) {
		for(int in = 0; in<a.size();) {// ditto here its a print method...
			System.out.println(a.get(in++).toString());}
		}
	static void writeArray(ArrayList<AirportList> a) throws IOException {
		int l = a.size();
		boolean run = false;
		while( run == false){
			String loc = "AirportList.txt";// another file writer... woot
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
	static void readArray(ArrayList<AirportList> a) {
		try {
			String output = null;
			String loc = "AirportList.txt";
			FileReader i = new FileReader(loc);
			BufferedReader abc = new BufferedReader(i);
			while((output = abc.readLine()) != null){
				String[] parts = output.split("\t");
				String l0 = parts[0];// another file reader, reads each entry on line. adds to array
				Double l1 = Double.valueOf(parts[1]); // each entry separated by tabs
				Double l2 = Double.valueOf(parts[2]);
				a.add(new AirportList(l0,l1,l2));
			}
			abc.close();
		}
		catch (IOException e) {
			System.out.println("Error file does not exist, file will be written upon exit");//catch if file does not exist
		}
	}
	static void editArray(ArrayList<AirportList> a, Scanner console) {
		boolean test = false;
		int value = -1;
		while (test == false) {
			System.out.println("Please enter the airport name you wish to edit");
			String id = console.nextLine();
			for (int in = 0; in<a.size();) {// issues with console here. if you run this method right after itself. fixed by
				String x = (a.get(in).getname());// placing console.nextline() in main between the two.
					if (id.equals(x)) {
						value = in;
						test = true;
						int col = detCol(console);
						String val = setNAME(console, "value");
						if (col == 1) {
							a.get(value).setname(val);
						}
						else if (col == 2) {
							a.get(value).setxcoord(Double.valueOf(val));//for loop to determine what column you are editing
						}
						else if (col == 3) {
							a.get(value).setycoord(Double.valueOf(val));
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
	AirListGen.printArray(a);
	}
	private static int detCol(Scanner console) {
			int i =-1;
			boolean test = false;
			while (test == false) {
				console.reset();
				System.out.println("do you wish to edit NAME, X or Y");
				String s = console.nextLine().toLowerCase();
				if (s.equals("name")) {
					i = 1;
					test = true;
				}
				else if (s.equals("x")) {
					i = 2;// the actual column editing selection part lol
					test = true;
				}
				else if (s.equals("y")) {
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
		ArrayList<AirportList> a = makeAirList();
		//readArray(a);
		//addAirport(a, console);
		//printArray(a);
		//editArray(a, console);
		//printArray(a);
		//remove(a, console);
		//printArray(a);
		writeArray(a);
	}
}
