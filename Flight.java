public class Flight{
  private String toAirCode;
  private String fromAirCode;
  private int planeNumber;
  private String boardingTime;
  private String departTime;
  private String arrivalTime;
  private String gate;
  private String departDate;
  private String arrivalDate;

  public Flight(){ //Explicit Empty Constructor
    toAirCode = "";
    fromAirCode = "";
    planeNumber = 0;
    boardingTime = "";
    departTime = "";
    arrivalTime = "";
    gate = "";
    departDate = "";
    arrivalDate = "";
  }

  public Flight(String toAirCode, String fromAirCode, int planeNumber, String boardingTime, String departTime, String arrivalTime, String gate, String departDate, String arrivalDate){
    this.toAirCode = toAirCode;
    this.fromAirCode = fromAirCode;
    this.planeNumber = planeNumber;
    this.boardingTime = boardingTime;
    this.departTime = departTime;
    this.arrivalTime = arrivalTime;
    this.gate = gate;
    this.departDate = departDate;
    this.arrivalDate = arrivalDate;
  }

  public Flight(Flight f){ //Copy Constructor
    toAirCode = f.getToAirCode();
    fromAirCode = f.getFromAirCode();
    planeNumber = f.getPlaneNumber();
    boardingTime = f.getBoardingTime();
    departTime = f.getDepartTime();
    arrivalTime = f.getArrivalTime();
    gate = f.getGate();
    departDate = f.getDepartDate();
    arrivalDate = f.getArrivalDate();
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

  public void setBoardingTime(String boardingTime){
    this.boardingTime = boardingTime;
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

  public void setArrivalDate(String arrivalDate){
    this.arrivalDate = arrivalDate;
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

  public String getBoardingTime(){
    return boardingTime;
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

  public String getArrivalDate(){
    return arrivalDate;
  }

}