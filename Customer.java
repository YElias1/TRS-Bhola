public class Customer {
  private String firstName;
  private String lastName;
  private int luggage;
  private String email;
  private String seat;
  private String seatR; //RETURN FLIGHT SEAT IF NEEDED
  private int birthDay;
  private int birthMonth;
  private int birthYear;

  public Customer(){ //Explicit empty Constructor
    firstName = "";
    lastName = "";
    luggage = 0;
    email = "";
    seat = "";
    seatR = "";
    birthDay = 0;
    birthMonth = 0;
    birthYear = 0;

  }

  public Customer(String firstName, String lastName, int luggage, String email, String seat, String seatR, int birthDay, int birthMonth, int birthYear){
    this.firstName = firstName;
    this.lastName = lastName;
    this.luggage = luggage;
    this.email = email;
    this.seat = seat;
    this.seatR = seatR;
    this.birthDay = birthDay;
    this.birthMonth = birthMonth;
    this.birthYear = birthYear;

  }

  public Customer(Customer c){ //Copy Constructor
    firstName = c.getFirstName();
    lastName = c.getLastName();
    luggage = c.getLuggage();
    email = c.getEmail();
    seat = c.getSeat();
    seatR = c.getSeatR();
    birthDay = c.getBirthDay();
    birthMonth = c.getBirthMonth();
    birthYear = c.getBirthYear();
  }

  //Accessor methods-Setters

  public void setFirstName(String firstName){
    this.firstName = firstName;
  }

  public void setLastName(String lastName){
    this.lastName = lastName;
  }

  public void setLuggage(int luggage){
    this.luggage = luggage;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public void setSeat(String seat){
    this.seat = seat;
  }

  public void setSeatR(String seatR){
    this.seatR = seatR;
  }

  public void setBirthDay(int birthDay){
    this.birthDay = birthDay;
  }

  public void setBirthMonth(int birthMonth){
    this.birthMonth = birthMonth;
  }

  public void setBirthYear(int birthYear){
    this.birthYear = birthYear;
  }

  //Accessor Methods- getters

  public String getFirstName(){
    return firstName;
  }

  public String getLastName(){
    return lastName;
  }

  public int getLuggage(){
    return luggage;
  }

  public String getEmail(){
    return email;
  }

  public String getSeat(){
    return seat;
  }

  public String getSeatR(){
    return seatR;
  }

  public int getBirthDay(){
    return birthDay;
  }

  public int getBirthMonth(){
    return birthMonth;
  }

  public int getBirthYear(){
    return birthYear;
  }
}
