//package terminal;

public class Inflight {
	private String flightNum;
	private int Speed;
	private int numPass;
	private String startLoc;
	private String endLoc;
	private Double xcoord;
	private Double ycoord;
	private String depTime;
	public Inflight(String flightNum, int Speed, int numPass, String startLoc, String endLoc, Double xcoord, Double ycoord, String depTime) {
		this.flightNum=flightNum;
		this.Speed=Speed;
		this.numPass=numPass;
		this.startLoc=startLoc;
		this.endLoc=endLoc;
		this.xcoord=xcoord;
		this.ycoord=ycoord;
		this.depTime = depTime;
	}
	public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",flightNum, Speed, numPass, startLoc, endLoc, xcoord, ycoord, depTime);
    }
	public String getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	public void setToLC(String depTime) {
		this.depTime=depTime;
	}
	public String getToLC() {
		return depTime;
	}
	public int getSpeed() {
		return Speed;
	}
	public void setSpeed(int speed) {
		this.Speed = speed;
	}
	public int getNumPass() {
		return numPass;
	}
	public void setNumPass(int numPass) {
		this.numPass = numPass;
	}
	public String getStartLoc() {
		return startLoc;
	}
	public void setStartLoc(String startLoc) {
		this.startLoc = startLoc;
	}
	public String getEndLoc() {
		return endLoc;
	}
	public void setEndLoc(String endLoc) {
		this.endLoc = endLoc;
	}
	public Double getXcoord() {
		return xcoord;
	}
	public void setXcoord(Double xcoord) {
		this.xcoord = xcoord;
	}
	public Double getYcoord() {
		return ycoord;
	}
	public void setYcoord(Double ycoord) {
		this.ycoord = ycoord;
	}

}
