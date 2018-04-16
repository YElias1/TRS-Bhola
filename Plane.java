//package terminal;

public class Plane {
	private String flightNum;
	private String type;
	private int capacity;
	private int numPass;
	private String startLoc;
	private String endLoc;

	private String departTime;
	private String departDate;
	private String Fltime;



	public Plane(String flightNum, String type, int capacity, int numPass, String startLoc, String endLoc, String departDate, String departTime, String Fltime) {
		this.flightNum=flightNum;
		this.type=type;
		this.capacity=capacity;
		this.numPass=numPass;
		this.startLoc=startLoc;
		this.endLoc=endLoc;
		this.departDate=departDate;
		this.departTime=departTime;
		this.Fltime=Fltime;

	 }
	public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",flightNum, type, capacity, numPass, startLoc, endLoc, departDate, departTime,Fltime );
    }
	 void arrTime(String Fltime) {
		 this.Fltime=Fltime;
	 }
	 void setFlNum(String flightNum) {
		 this.flightNum=flightNum;
	 }
	 void setType(String type) {
		 this.type=type;
	 }
	 void setDDate(String departDate) {
		 	this.departDate=departDate;
	 }
	 void setCap(int capacity) {
		 this.capacity=capacity;
	 }
	 void setNumPass(int numPass) {
		 this.numPass=numPass;
	 }
	 void setStartLoc(String startLoc) {
		 this.startLoc=startLoc;
	 }
	 void setEndLoc(String endLoc) {
		 this.endLoc=endLoc;
	 }
	 void setdepartTime(String departTime) {
		 this.departTime=departTime;
	 }
	 public String getFlTime() {
		 return Fltime;
	 }
	 public String getFlNum() {
		 return flightNum;
	 }
	 public String getDDate() {
		 return departDate;
	 }
	 public String getType() {
		 return type;
	 }
	 public int getCap() {
		 return capacity;
	 }
	 public int getNumPass() {
		 return numPass;
	 }
	 public String getSloc() {
		 return startLoc;
	 }
	 public String getEloc() {
		 return endLoc;
	 }
	 public String getDept() {
		 return departTime;
	 }

}
