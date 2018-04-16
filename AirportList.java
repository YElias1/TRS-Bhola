//package terminal;

public class AirportList {
	private String name;
	private Double xcoord;
	private Double ycoord;

	public AirportList(String name, Double xcoord, Double ycoord) {
		this.name=name;
		this.xcoord=xcoord;
		this.ycoord=ycoord;
	 }
	public String toString() {
        return String.format("%s\t%s\t%s",name, xcoord, ycoord);
    }
	 void setname(String name) {
		 this.name=name;
	 }
	 void setxcoord(Double xcoord) {
		 this.xcoord=xcoord;
	 }
	 void setycoord(Double ycoord) {
		 this.ycoord=ycoord;
	 }
	 public String getname() {
		 return name;
	 }
	 public Double  getxcoord() {
		 return xcoord;
	 }
	 public Double getycoord() {
		 return ycoord;
	 }
}
