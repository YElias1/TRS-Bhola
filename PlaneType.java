//package terminal;

public class PlaneType {
	private String type;
	private int capacity;
	private int speed;

	public PlaneType(String type, int capacity, int speed) {
		this.type=type;
		this.capacity=capacity;
		this.setSpeed(speed);

	 }
	public String toString() {
        return String.format("%s\t%s\t%s",type, capacity, speed);
    }
	 void setType(String type) {
		 this.type=type;
	 }
	 void setCapacity(int capacity) {
		 this.capacity=capacity;
	 }

	 public String getType() {
		 return type;
	 }
	 public int  getCapacity() {
		 return capacity;

	 }
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
