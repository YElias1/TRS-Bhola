public class Flight{
  private String toAirCode;
  private String fromAirCode;
  private int planeNumber;
  private String departTime;
  private String arrivalTime;
  private String gate;
  private String departDate;

  public Flight(){ //Explicit Empty Constructor
    toAirCode = "";
    fromAirCode = "";
    planeNumber = 0;
    departTime = "";
    arrivalTime = "";
    gate = "";
    departDate = "";
  }

  public Flight(String toAirCode, String fromAirCode, int planeNumber, String departTime, String arrivalTime, String gate, String departDate){
    this.toAirCode = toAirCode;
    this.fromAirCode = fromAirCode;
    this.planeNumber = planeNumber;
    this.departTime = departTime;
    this.arrivalTime = arrivalTime;
    this.gate = gate;
    this.departDate = departDate;
  }

  public Flight(Flight f){ //Copy Constructor
    toAirCode = f.getToAirCode();
    fromAirCode = f.getFromAirCode();
    planeNumber = f.getPlaneNumber();
    departTime = f.getDepartTime();
    arrivalTime = f.getArrivalTime();
    gate = f.getGate();
    departDate = f.getDepartDate();
  }

  //Accessor Methods- Setters

  public void setToAirCode(String toAirCode){
    this.toAirCode = toAirCode;
  }

  public void setFromAirCode(String fromAirCode){
    this.fromAirCode = fromAirCode;
  }

  public void setPlaneNumber(int planeNumber){
    this.planeNumber = planeNumber;
  }

  public void setDepartTime(String departTime){
    this.departTime = departTime;
  }

  public void setArrivalTime(String arrivalTime){
    this.arrivalTime = arrivalTime;
  }

  public void setGate(String gate){
    this.gate = gate;
  }

  public void setDepartDate(String departDate){
    this.departDate = departDate;
  }


  //Accessor Methods- Getters

  public String getToAirCode(){
    return toAirCode;
  }

  public String getFromAirCode(){
    return fromAirCode;
  }

  public int getPlaneNumber(){
    return planeNumber;
  }

  public String getDepartTime(){
    return departTime;
  }

  public String getArrivalTime(){
    return arrivalTime;
  }

  public String getGate(){
    return gate;
  }

  public String getDepartDate(){
    return departDate;
  }
}
