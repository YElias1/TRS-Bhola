//package terminal;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Tracker {
	static void testo() {
		double x =4.0;
		double elt = 1;
		double ydist = 3;
		double xdist = -2;
		double add=0;
		if (xdist>0&&ydist<0||xdist<0&&ydist<0) {
			add = Math.PI;
			System.out.println("adding");
		}
		Double newx = x+ elt*Math.sin(Math.atan(ydist/xdist)+add);
		System.out.println(newx);
	}
	static double elapsedTime(ArrayList<Inflight> Inf, int i){
		Date d = new Date();
		SimpleDateFormat currenttimem = new SimpleDateFormat("mm");
		String curtm = currenttimem.format(d);
		String intm = Inf.get(i).getToLC().split(":")[1];
		Double elt = Double.valueOf(curtm)-Double.valueOf(intm);
		if(elt<0) {
			elt = 60-Math.abs(elt);
		}
		return elt;
	}

	static void coordediter(ArrayList<Inflight> Inf, ArrayList<AirportList> Airport) throws IOException {
	double x,y,endx=0,endy=0,xdist,ydist,add=0,elt;
	Date d = new Date();
	SimpleDateFormat ct = new SimpleDateFormat("HH:mm");
	String finc;
	for (int i=0; i<Inf.size(); i++) {
		System.out.println(i);
		x = Inf.get(i).getXcoord();
		y = Inf.get(i).getYcoord();
		finc = Inf.get(i).getEndLoc();
		for (int j=0; j<Airport.size(); j++) {
			if (Airport.get(j).getname().contains(finc)){
				endx = Airport.get(j).getxcoord();
				endy = Airport.get(j).getycoord();
				break;
			}
		}
	    elt = elapsedTime(Inf, i);
	    System.out.println(elt);
		if (endx>0&&x<0) {
			xdist = -1*(endx-x);
		}
		else {
			xdist = endx-x;
		}
		if (endy>0&&x<0) {
			ydist = -1*(endx-x);
		}
		else {
		ydist = endy-y;
		}
		System.out.println(xdist+" x"+ydist+" y");
		if (xdist<0&&ydist<0||ydist>0&&xdist<0) {
			add = Math.PI;
			System.out.println("adding");
		}
		//Double newx = x+ Inf.get(i).getSpeed()*elt*Math.sin(Math.atan(ydist/xdist)+add);
		//Double newy = y+ Inf.get(i).getSpeed()*elt*Math.cos(Math.atan(ydist/xdist)+add);
		Double newx = x+ 1*Math.cos(Math.atan(ydist/xdist)+add);
		Double newy = y+ 1*Math.sin(Math.atan(ydist/xdist)+add);
		System.out.println(newx+" "+newy);
		if (x<endx&&newx>=endx||x>endx&&newx<=endx) {
			System.out.println("removing flight "+Inf.get(i).getFlightNum());
			remove(Inf,i);
		}
		else {
			System.out.println("adjusting plane coordinates");
			String s = ct.format(d);
			Inf.get(i).setXcoord(newx);
			Inf.get(i).setYcoord(newy);
			Inf.get(i).setToLC(s);
		}
	}
	}
	static void remove(ArrayList<Inflight> Inf, int i) throws IOException {
		Inf.remove(i);
		InflightGen.writeArray(Inf); // automated removal used by the Tracker method
		}

	public static void main(String[] args) {
		testo();
	}

}
