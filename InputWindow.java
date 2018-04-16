import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.Container;
import java.awt.Component;
import java.awt.Color;
import java.util.*;

public class InputWindow extends JFrame {

  //String[] for ComboBoxes
  private String[] passengersList = {
      "1",
      "2",
      "3",
      "4",
      "5",
      "6",
      "7",
      "8",
      "9"
  };

  private String[] states = {
      "State",
      "Alabama",
      "Alaska",
      "Arizona",
      "Arkansas",
      "California",
      "Colorado",
      "Connecticut",
      "Delaware",
      "District Of Colombia",
      "Florida",
      "Georgia",
      "Hawaii",
      "Idaho",
      "Illinois",
      "Indiana",
      "Iowa",
      "Kansas",
      "Kentucky",
      "Louisiana",
      "Maine",
      "Maryland",
      "Massachusetts",
      "Michigan",
      "Minnesota",
      "Mississippi",
      "Missouri",
      "Montana",
      "Nebraska",
      "Nevada",
      "New Hampshire",
      "New Jersey",
      "New Mexico",
      "New York",
      "North Carolina",
      "North Dakota",
      "Ohio",
      "Oklahoma",
      "Oregon",
      "Pennsylvania",
      "Rhode Island",
      "South Carolina",
      "South Dakota",
      "Tennessee",
      "Texas",
      "Utah",
      "Vermont",
      "Virginia",
      "Washington",
      "West Virginia",
      "Wisconsin",
      "Wyoming"
  };


  private String[] alabamaAirports = {
    "Birmingham (BHM)",
    "Dothan (DHN)",
    "Huntsville (HSV)",
    "Mobile (MOB)",
    "Montgomery (MGM)"
  };

  private String[] alaskaAirports = {
    "Anchorage (ANC)",
    "Fairbanks (FAI)",
    "Juneau (JNU)",
    "Ketchikan (KTN)",
    "Sitka (SIT)"
  };

  private String[] arizonaAirports = {
    "Phoenix (PHX)",
    "Prescott (PRC)",
    "Tucson (TUS)"
  };

  private String[] arkansasAirports = {
    "Fayetteville-NW (XNA)",
    "Fort Smith (FSM)",
    "Little Rock (LIT)"
  };

  private String[] californiaAirports = {
    "Burbank (BUR)",
    "Fresno (FAT)",
    "Long Beach (LGB)",
    "Los Angeles (LAX)",
    "Monterey (MRY)",
    "Oakland (OAK)",
    "Ontario (ONT)",
    "Orange County (SNA)",
    "Palm Springs (PSP)",
    "Sacramento (SMF)",
    "San Diego (SAN)",
    "Sanfrancisco (SFO)",
    "San Jose (SJC)",
    "Santa Barbara (SBA)",
    "Santa Rosa (STS)"
  };

  private String[] coloradoAirports = {
    "Aspen (ASE)",
    "Colorado Springs (COS)",
    "Denver (DEN)",
    "Grand Junction (GJT)",
    "Hayden (HDN)",
    "Montrose (MTJ)",
    "Vail (EGE)"
  };

  private String[] connecticutAirports = {
    "Hartford/Springfield (BDL)"
  };

  private String[] districtAirports = {
    "Washington Area (WAS)",
    "Washington-Dulles (IAD)",
    "Washington-Reagan National (DCA)"
  };

  private String[] floridaAirports = {
    "Daytona Beach (DAB)",
    "Destin-Fort Walton Beach (VPS)",
    "Fort Lauderdale (FLL)",
    "Fort Myers (RSW)",
    "Gainesville (GNV)",
    "Jacksonville (JAX)",
    "Key West (EYW)",
    "Melbourne (MLB)",
    "Miami (MIA)",
    "Orlando (MCO)",
    "Panama City (ECP)",
    "Pensacola (PNS)",
    "Sarasota-Bradenton (SRQ)",
    "Tallahassee (TLH)",
    "Tampa (TPA)",
    "West Palm Beach (PBI)"
  };

  private String[] georgiaAirports = {
    "Albany (ABY)",
    "Atlanta (ATL)",
    "Augusta (AGS)",
    "Brunswick-Golden Isles (BQK)",
    "Columbus (CSG)",
    "Savannah (SAV)",
    "Valdosta (VLD)"
  };

  private String[] hawaiiAirports = {
    "Hilo (ITO)",
    "Honolulu (HNL)",
    "Kahului (OGG)",
    "Kapalua (JHM)",
    "Kona (KOA)",
    "Lihue (LIH)"
  };

  private String[] idahoAirports = {
    "Boise (BOI)",
    "Idaho Falls (IDA)",
    "Lewiston (LWS)",
    "Pocatello (PIH)",
    "Sun Valley (SUN)",
    "Twin Falls (TWF)"
  };

  private String[] illinoisAirports = {
    "Bloomington (BMI)",
    "Chicago Area (CHI)",
    "Chicago-Midway (MDW)",
    "Chicago-Ohare (ORD)",
    "Moline-Quad (MLI)",
    "Peoria (PIA)"
  };

  private String[] indianaAirports = {
    "Evansville (EVV)",
    "Fort Wayne (FWA)",
    "Indianapolis (IND)",
    "South Bend (SBN)"
  };

  private String[] iowaAirports = {
    "Cedar Rapids (CID)",
    "Des Moines (DSM)"
  };

  private String[] kansasAirports = {
    "Wichita (ICT)"
  };

  private String[] kentuckyAirports = {
    "Lexington (LEX)",
    "Louisville (SDF)"
  };

  private String[] louisianaAirports = {
    "Alexandria (AEX)",
    "Baton Rouge (BTR)",
    "Lafayette (LFT)",
    "Monroe (MLU)",
    "New Orleans (MSY)",
    "Shreveport (SHV)"
  };

  private String[] maineAirports = {
    "Bangor (BGR)",
    "Portland (PWM)"
  };

  private String[] marylandAirports = {
    "Baltimore (BWI)"
  };

  private String[] massachusettsAirports = {
    "Boston (BOS)",
    "Marthas Vineyard (MVY)",
    "Nantucket (ACK)"
  };

  private String[] michiganAirports = {
    "Alpena (APN)",
    "Bay City (MBS)",
    "Detroit (DTW)",
    "Escanaba (ESC)",
    "Flint (FNT)",
    "Grand Rapids (GRR)",
    "Iron Mountain (IMT)",
    "Kalamazoo (AZO)",
    "Lansing (LAN)",
    "Marquette (MQT)",
    "Pellstone (PLN)",
    "Sault Ste Marie (CIU)",
    "Traverse City (TVC)"
  };

  private String[] minnesotaAirports = {
    "Bernidji (BJI)",
    "Brainerd (BRD)",
    "Duluth (DLH)",
    "Hibbing (HIB)",
    "International Falls (INL)",
    "Minneapolis/St Pail (MSP)",
    "Rochester (RST)",
    "Thief River Falls (TVR)"
  };

  private String[] mississippiAirports = {
    "Columbus (GTR)",
    "GulfPort (GPT)",
    "Jackson (JAN)"
  };

  private String[] missouriAirports = {
    "Kansas City (MCI)",
    "Springfield (SGF)",
    "St. Louis (STL)"
  };

  private String[] montanaAirports = {
    "Billings (BIL)",
    "Bozeman (BZN)",
    "Butte (BTM)",
    "Great Falls (GTF)",
    "Helena (HLN)",
    "Kalispell (FCA)",
    "Missoula (MSO)",
    "West Yellowstone (WYS)"
  };

  private String[] nebraskaAirports = {
    "Lincoln (LNK)",
    "Omaha (OMA)"
  };

  private String[] nevadaAirports = {
    "Elko (EKO)",
    "Las Vegas (LAS)",
    "Reno (RNO)"
  };

  private String[] newhampshireAirports = {
    "Manchester (MHT)"
  };

  private String[] newjerseyAirports = {
    "Newark (EWR)"
  };

  private String[] newmexicoAirports = {
    "Albuquerque (ABQ)"
  };

  private String[] newyorkAirports = {
    "Albany (ALB)",
    "Binghamton (BGM)",
    "Buffalo (BUF)",
    "Elmira (ELM)",
    "Ithaca (ITH)",
    "NYC Area (NYC)",
    "New York-Kennedy (JFK)",
    "New York-La Guardia (LGA)",
    "Newburgh (SWF)",
    "Rochester (ROC)",
    "Saranac Lake (SLK)",
    "Syracuse (SYR)",
    "White Plains (HPN)"
  };

  private String[] northcarolinaAirports = {
    "Asheville (AVL)",
    "Charlotte (CLT)",
    "Fayetteville (FAY)",
    "Greensboro (GSO)",
    "Jacksonville (OAJ)",
    "New Bern (EWN)",
    "Railegh/Durham (RDU)",
    "Wilmington (ILM)"
  };

  private String[] northdakotaAirports = {
    "Bismark (BIS)",
    "Fargo (FAR)",
    "Grand Forks (GFK)",
    "Minot (MOT)",
    "Williston (ISN)"
  };

  private String[] ohioAirports = {
    "Akron (CAK)",
    "Cincinnati (CVG)",
    "Cleveland-Hopkins (CLE)",
    "Columbus (CMH)",
    "Daytona (DAY)"
  };

  private String[] oklahomaAirports = {
    "Oklahoma City (OKC)",
    "Tulsa (TUL)"
  };

  private String[] oregonAirports = {
    "Eugune (EUG)",
    "Medford (MFR)",
    "Portland (PDX)",
    "Redmond (RDM)"
  };

  private String[] pennsylvaniaAirports = {
    "Allentown (ABE)",
    "Erie (ERI)",
    "Harrisburg (MDT)",
    "Philadelphia (PHL)",
    "Pittsburgh (PIT)",
    "State College (SCE)",
    "Wilkes-Barre/Scranton (AVP)"
  };

  private String[] rhodeislandAirports = {
    "Providence (PVD)"
  };

  private String[] southcarolinaAirports = {
    "Charleston (CHS)",
    "Columbia (CAE)",
    "Greensville/Spartanburg (GSP)",
    "Myrtle Beach (MYR)"
  };

  private String[] southdakotaAirports = {
    "Aberdeen (ABR)",
    "Rapid City (RAP)",
    "Sioux Falls (FSD)"
  };

  private String[] tennesseeAirports = {
    "Chattanooga (CHA)",
    "Knoxville (TYS)",
    "Memphis (MEM)",
    "Nashville (BNA)",
    "Tri City (TRI)"
  };

  private String[] texasAirports = {
    "Austin (AUS)",
    "Dallas-Fort Worth (DFW)",
    "Dallas-Love Field (DAL)",
    "El Paso (ELP)",
    "Harlingen-South Padre (HRL)",
    "Houston-Bush Intercontl (IAH)",
    "Houston-Hobby (HOU)",
    "Killeen (GRK)",
    "San Antonio (SAT)"
  };

  private String[] utahAirports = {
    "Cedar City (CDC)",
    "Salt Lake City (SLC)",
    "ST. George (SGU)"
  };

  private String[] vermontAirports = {
    "Burlington (BTV)"
  };

  private String[] virginiaAirports = {
    "Charlottesville (CHO)",
    "Newport News (PHF)",
    "Norfolk (ORF)",
    "Richmond (RIC)",
    "Roanoke (ROA)"
  };

  private String[] washingtonAirports = {
    "Bellingham (BLI)",
    "Pasco/Kennewick (PSC)",
    "Pullman (PUW)",
    "Seattle (SEA)",
    "Spokane (GEG)",
    "Walla Walla (ALW)",
    "Wenatchee (EAT)",
    "Yakima (YKM)"
  };

  private String[] westvirginiaAirports = {
    "Charleston (CRW)"
  };

  private String[] wisconsinAirports = {
    "Appleton (ATW)",
    "Green Bay (GRB)",
    "La Crosse (LSE)",
    "Madison (MSN)",
    "Milwaukee (MKE)",
    "Rhinelander (RHI)",
    "Wausau (CWA)"
  };

  private String[] wyomingAirports = {
    "Casper (CPR)",
    "Cody (COD)",
    "Gillette (GCC)",
    "Jackson Hole (JAC)"
  };
  //Used in calendar
  private String[] headers = {
    "Sun",
    "Mon",
    "Tue",
    "Wed",
    "Thu",
    "Fri",
    "Sat"
  };

  //Data used to change Flight/Customer
  private boolean way;
  private int passengers;
  private String fromAirCode;
  private String toAirCode;

  //Locks
  private boolean lock;
  private boolean show;
  private boolean show2;

  private Customer[] customerArray; //Keep track of people on flight
  private Flight[] flightArray; //Keep track of planes to and from if twoway

  //Panels
  private JPanel topPanel;
  private JPanel botPanel;
  private JPanel calendarPanel;
  private JPanel calendarPanel2;

  //Container
  private Container pane;

  //Buttons
  private JButton exitButton;
  private JButton nextButton;
  private JButton flipButton;
  private JButton departButton;
  private JButton returnButton;
  //Calendar
  private JButton prevButt;
  private JButton nextButt;
  private JButton prevButt2;
  private JButton nextButt2;

  //calendarTable
  private JTable calendarTable;
  private JTable calendarTable2;
  private DefaultTableModel mCalendarTable;
  private DefaultTableModel mCalendarTable2;

  //Calendar JScrollPane
  private JScrollPane stblCalendar;
  private JScrollPane stblCalendar2;


  //RadioButons
  private JRadioButton onewayButton;
  private JRadioButton twowayButton;
  private ButtonGroup flightGroup;

  //Labels
  private JLabel passengersLabel;
  private JLabel titleLabel;
  private JLabel fromLabel;
  private JLabel toLabel;
  private JLabel airportLabel;
  private JLabel airportLabel2;
  private JLabel departLabel;
  private JLabel returnLabel;
  private JLabel errorLabel;
  //Calendar
  private JLabel monthLabel;
  private JLabel monthLabel2;
  private JLabel yearLabel;
  private JLabel yearLabel2;

  //TextFields
  private JTextField departField; //Switch to FormattedTextField
  private JTextField returnField;

  //ComboBoxes
  private JComboBox<String> passengersBox;
  private JComboBox<String> fromBox;
  private JComboBox<String> toBox;
  private JComboBox<String> airportBox;
  private JComboBox<String> airportBox2;
  //Calendar
  private JComboBox<String> yearBox;
  private JComboBox<String> yearBox2;


  //Width/Length
  final int FRAME_WIDTH;
  final int FRAME_LENGTH;

  //Calendar variables
  private int realDay, realMonth, realYear, currentMonth, currentYear, currentDay;
  private int currentMonth2, currentYear2, currentDay2;
  private String departDate;
  private String returnDate;
  private GregorianCalendar cal;


  public InputWindow() {

    FRAME_WIDTH = 800;
    FRAME_LENGTH = 750;

    //Setting look and feel
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (ClassNotFoundException e) {
      System.out.println("Error 1");
    }
    catch (InstantiationException e) {
      System.out.println("Error 2");
    }
    catch (IllegalAccessException e) {
      System.out.println("Error 3");
    }
    catch (UnsupportedLookAndFeelException e) {
      System.out.println("Error 4");
    }

    lock = true;
    show = true;
    show2 = true;

    /***
      *
      *   Top Panel Component
      *
    ***/

    topPanel = new JPanel(null);
    topPanel.setBounds(0, 0, 800, 350);
    topPanel.setBackground(new Color(255, 220, 220));

    onewayButton = new JRadioButton("One-Way");
    onewayButton.setBounds(50, 50, 100, 25);

    twowayButton = new JRadioButton("Round-Trip", true);
    twowayButton.setBounds(200, 50, 120, 25);
    way = true; //Because it is initially selected

    flightGroup = new ButtonGroup();
    flightGroup.add(onewayButton);
    flightGroup.add(twowayButton);

    flipButton = new JButton("Flip");
    flipButton.setBounds(350, 150, 75, 25);

    passengersBox = new JComboBox<String>(passengersList);
    passengersBox.setBounds(600, 50, 125, 25);
    passengersBox.setEditable(false);
    passengers = 1;

    fromBox = new JComboBox<String>(states);
    fromBox.setBounds(125, 150, 125, 25);
    fromBox.setEditable(false);

    toBox = new JComboBox<String>(states);
    toBox.setBounds(600, 150, 125, 25);
    toBox.setEditable(false);

    airportBox = new JComboBox<String>();
    airportBox.setBounds(125, 200, 125, 25);
    airportBox.setEditable(false);

    airportBox2 = new JComboBox<String>();
    airportBox2.setBounds(600, 200, 125, 25);
    airportBox2.setEditable(false);

    airportLabel = new JLabel("Airport:");
    airportLabel.setBounds(50, 200, 100, 25);

    airportLabel2 = new JLabel("Airport:");
    airportLabel2.setBounds(500, 200, 100, 25);

    passengersLabel = new JLabel("Passengers:");
    passengersLabel.setBounds(500, 50, 100, 25);

    fromLabel = new JLabel("From:");
    fromLabel.setBounds(50, 150, 100, 25);

    toLabel = new JLabel("To:");
    toLabel.setBounds(500, 150, 100, 25);

    titleLabel = new JLabel("BOOK A TRIP");
    titleLabel.setBounds(350, 0, 100, 25);

    errorLabel = new JLabel("Select Airports");
    errorLabel.setBounds(350, 250, 150, 25);
    errorLabel.setVisible(false);

    departLabel = new JLabel("Depart Date:");
    departLabel.setBounds(50, 250, 100, 25);

    returnLabel = new JLabel("Return Date:");
    returnLabel.setBounds(500, 250, 100, 25);

    departField = new JTextField("YYYY/DD/MM");
    departField.setBounds(45, 300, 110, 25); // 353 to fit button looks better
    departField.setEditable(false);

    returnField = new JTextField("YYYY/DD/MM");
    returnField.setBounds(495, 300, 110, 25);
    returnField.setEditable(false);

    departButton = new JButton();
    departButton.setBounds(160, 295, 40, 30);
    departButton.setIcon(new ImageIcon("calendar.png"));

    returnButton = new JButton();
    returnButton.setBounds(610, 295, 40, 30);
    returnButton.setIcon(new ImageIcon("calendar.png"));

    /***
      *
      *   Bottom Panel Component
      *
    ***/

    botPanel = new JPanel(null);
    botPanel.setBounds(0, 350, 800, 400);
    botPanel.setBackground(new Color(220, 220, 255));

    exitButton = new JButton("Exit");
    exitButton.setBounds(40, 325, 100, 30); // Sets bounds on frame with x,y,width,height

    nextButton = new JButton("Next");
    nextButton.setBounds(620, 325, 100, 30);

    /***
      *
      * First CALENDAR
      *
    ***/
    monthLabel = new JLabel("January");
    monthLabel.setBounds(100, 25, 100, 25);

    yearLabel = new JLabel("Change Year: ");
    yearLabel.setBounds(10, 270, 100, 25);

    yearBox = new JComboBox<String>();
    yearBox.setBounds(140, 270, 80, 30);

    prevButt = new JButton("<<");
    prevButt.setBounds(10, 25, 50, 25);

    nextButt = new JButton(">>");
    nextButt.setBounds(180, 25, 50, 25);

    mCalendarTable = new DefaultTableModel(){
      public boolean isCellEditable(int rowIndex, int mColIndex){
        return false;
      }
    };

    calendarTable = new JTable(mCalendarTable);

    stblCalendar = new JScrollPane(calendarTable);
    stblCalendar.setBounds(10, 50, 220, 220);

    calendarPanel = new JPanel(null);
    calendarPanel.setBounds(50, 10, 240, 300);

    cal = new GregorianCalendar();
    realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //get day
    realMonth = cal.get(GregorianCalendar.MONTH);
    realYear = cal.get(GregorianCalendar.YEAR);

    currentMonth = realMonth;
    currentYear = realYear;
    currentDay = realDay;

    for (int i = 0; i < 7; i++){ //Adding headers to table
      mCalendarTable.addColumn(headers[i]);
    }

    calendarTable.getParent().setBackground(calendarTable.getBackground()); //Strange but needed

    calendarTable.getTableHeader().setResizingAllowed(false);
    calendarTable.getTableHeader().setReorderingAllowed(false);

    //Single Cell Seletion
    calendarTable.setColumnSelectionAllowed(true);
    calendarTable.setRowSelectionAllowed(true);
    calendarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    //Set row/column Count
    calendarTable.setRowHeight(38);
    mCalendarTable.setColumnCount(7);
    mCalendarTable.setRowCount(6);

    for (int i = realYear; i<=realYear+1; i++){ //Populate combobox
      yearBox.addItem(String.valueOf(i));
    }

    refreshCalendar(currentMonth, currentYear);

    calendarPanel.setBorder(BorderFactory.createTitledBorder("Depart Calendar")); //Set Border

    /***
      *
      * CALENDAR 2
      *
    ***/

    monthLabel2 = new JLabel("January");
    monthLabel.setBounds(100, 25, 100, 25);

    yearLabel2 = new JLabel("Change Year: ");
    yearLabel2.setBounds(10, 270, 100, 25);

    yearBox2 = new JComboBox<String>();
    yearBox2.setBounds(140, 270, 80, 30);

    prevButt2 = new JButton("<<");
    prevButt2.setBounds(10, 25, 50, 25);

    nextButt2 = new JButton(">>");
    nextButt2.setBounds(180, 25, 50, 25);

    mCalendarTable2 = new DefaultTableModel(){
      public boolean isCellEditable(int rowIndex, int mColIndex){
        return false;
      }
    };

    calendarTable2 = new JTable(mCalendarTable2);

    stblCalendar2 = new JScrollPane(calendarTable2);
    stblCalendar2.setBounds(10, 50, 220, 220);

    calendarPanel2 = new JPanel(null);
    calendarPanel2.setBounds(500, 10, 240, 300);


    currentMonth2 = currentMonth;
    currentYear2 = currentYear;
    currentDay2 = currentDay;

    for (int i = 0; i < 7; i++){ //Adding headers to table
      mCalendarTable2.addColumn(headers[i]);
    }

    calendarTable2.getParent().setBackground(calendarTable2.getBackground()); //Strange but needed

    calendarTable2.getTableHeader().setResizingAllowed(false);
    calendarTable2.getTableHeader().setReorderingAllowed(false);

    //Single Cell Seletion
    calendarTable2.setColumnSelectionAllowed(true);
    calendarTable2.setRowSelectionAllowed(true);
    calendarTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    //Set row/column Count
    calendarTable2.setRowHeight(38);
    mCalendarTable2.setColumnCount(7);
    mCalendarTable2.setRowCount(6);

    for (int i = realYear; i<=realYear+1; i++){ //Populate combobox
      yearBox2.addItem(String.valueOf(i));
    }

    refreshCalendar2(currentMonth2, currentYear2);

    calendarPanel2.setBorder(BorderFactory.createTitledBorder("Depart Calendar")); //Set Border

    pane = getContentPane();
    pane.setLayout(null);

    /***
      *
      * ADDING ACTION LISTENERS
      *
    ***/

    exitButton exitListener = new exitButton();
    exitButton.addActionListener(exitListener);

    nextButton nextListener = new nextButton();
    nextButton.addActionListener(nextListener);

    flipButton flipListener = new flipButton();
    flipButton.addActionListener(flipListener);

    onewayButton onewayListener = new onewayButton();
    onewayButton.addActionListener(onewayListener);

    twowayButton twowayListener = new twowayButton();
    twowayButton.addActionListener(twowayListener);

    calendarButtonOne departButtonListener = new calendarButtonOne();
    departButton.addActionListener(departButtonListener);

    calendarButtonTwo returnButtonListener = new calendarButtonTwo();
    returnButton.addActionListener(returnButtonListener);

    passengersBoxChange passengersBoxListener = new passengersBoxChange();
    passengersBox.addActionListener(passengersBoxListener);

    fromBoxChange fromBoxListener = new fromBoxChange();
    fromBox.addActionListener(fromBoxListener);

    toBoxChange toBoxListener = new toBoxChange();
    toBox.addActionListener(toBoxListener);

    airportBoxChange airportBoxListener = new airportBoxChange();
    airportBox.addActionListener(airportBoxListener);

    airportBox2Change airportBox2Listener = new airportBox2Change();
    airportBox2.addActionListener(airportBox2Listener);

    /***
      *
      * CALENDAR ACTION BUTTONS
      *
    ***/

    prevButt_Action prevListener = new prevButt_Action();
    prevButt.addActionListener(prevListener);

    nextButt_Action nextAction = new nextButt_Action();
    nextButt.addActionListener(nextAction);

    yearBox_Action yearListener = new yearBox_Action();
    yearBox.addActionListener(yearListener);

    mouse_Action mlistener = new mouse_Action();
    calendarTable.addMouseListener(mlistener);

    /***
      *
      * CALENDAR2 ACTION BUTTONS
      *
    ***/

    prevButt2_Action prevListener2 = new prevButt2_Action();
    prevButt2.addActionListener(prevListener2);

    nextButt2_Action nextAction2 = new nextButt2_Action();
    nextButt2.addActionListener(nextAction2);

    yearBox2_Action yearListener2 = new yearBox2_Action();
    yearBox2.addActionListener(yearListener2);

    mouse2_Action mlistener2 = new mouse2_Action();
    calendarTable2.addMouseListener(mlistener2);

    pane.add(topPanel);
    pane.add(botPanel);

    // ***Adding to top panel***
    topPanel.add(onewayButton);
    topPanel.add(twowayButton);
    topPanel.add(flipButton);
    topPanel.add(passengersBox);
    topPanel.add(fromBox);
    topPanel.add(toBox);
    topPanel.add(airportBox);
    topPanel.add(airportBox2);
    topPanel.add(airportLabel);
    topPanel.add(airportLabel2);
    topPanel.add(passengersLabel);
    topPanel.add(fromLabel);
    topPanel.add(toLabel);
    topPanel.add(titleLabel);
    topPanel.add(errorLabel);
    topPanel.add(departButton);
    topPanel.add(returnButton);
    topPanel.add(departField);
    topPanel.add(returnField);
    topPanel.add(departLabel);
    topPanel.add(returnLabel);

    // ***Adding to Bottom Panel***
    botPanel.add(exitButton);
    botPanel.add(nextButton);

    // Calendar Panel
    calendarPanel.add(monthLabel);
    calendarPanel.add(yearLabel);
    calendarPanel.add(yearBox);
    calendarPanel.add(prevButt);
    calendarPanel.add(nextButt);
    calendarPanel.add(stblCalendar);
    botPanel.add(calendarPanel);
    calendarPanel.setVisible(false);

    // Calendar Panel 2
    calendarPanel2.add(monthLabel2);
    calendarPanel2.add(yearLabel2);
    calendarPanel2.add(yearBox2);
    calendarPanel2.add(prevButt2);
    calendarPanel2.add(nextButt2);
    calendarPanel2.add(stblCalendar2);
    botPanel.add(calendarPanel2);
    calendarPanel2.setVisible(false);



    setLayout(null);
    setTitle("Delta Terminal Reservation System");
    setSize(FRAME_WIDTH, FRAME_LENGTH);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(true);
    setLocationRelativeTo(null);

    setVisible(true);
  }

  /***
    *
    * DEFINING ACTION LISTENERS
    *
  ***/

  private class exitButton implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      System.exit(0);
    }
  }

  private class twowayButton implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      way = twowayButton.isSelected();
      returnLabel.setVisible(true);
      returnField.setVisible(true);
      returnButton.setVisible(true);
      //Code to make return date not editable
    }
  }

  private class onewayButton implements ActionListener {
      public void actionPerformed (ActionEvent e){
        way = !onewayButton.isSelected();
        returnLabel.setVisible(false);
        returnField.setVisible(false);
        returnButton.setVisible(false);
        calendarPanel2.setVisible(false);
        //Code to make return date editable
      }
  }

  private class flipButton implements ActionListener {
    public void actionPerformed (ActionEvent e){
      int selected = toBox.getSelectedIndex();
      int selected2 = fromBox.getSelectedIndex();
      int airSelected = airportBox.getSelectedIndex();
      int airSelected2 = airportBox2.getSelectedIndex();

      if (selected == -1 || selected2 == -1 || airSelected == -1 || airSelected2 == -1){
        System.out.println("How? and good thing I caught this");
      }
      else {
        toBox.setSelectedIndex(selected2);
        fromBox.setSelectedIndex(selected);

        airportBox.setSelectedIndex(airSelected2);
        airportBox2.setSelectedIndex(airSelected);
      }
    }
  }

  private class calendarButtonOne implements ActionListener {
    public void actionPerformed (ActionEvent e){
      if (show){
        calendarPanel.setVisible(true);
        show = false;
      }
      else {
        calendarPanel.setVisible(false);
        show = true;
      }
    }
  }

  private class calendarButtonTwo implements ActionListener {
    public void actionPerformed (ActionEvent e){
      if (departDate == null){
        errorLabel.setText("Depart First");
        errorLabel.setVisible(true);
      }
      else if (show2){
        errorLabel.setVisible(false);
        calendarPanel2.setVisible(true);
        show2 = false;
      }
      else {
        calendarPanel2.setVisible(false);
        show2 = true;
      }
    }
  }
  // NextButton does all the heavy lifting when creating objects
  // Add error check for empty fields
  private class nextButton implements ActionListener {
    public void actionPerformed (ActionEvent e){
      if (fromAirCode == null || toAirCode == null || fromAirCode.equals(toAirCode)) { //Error checking for null and same to and from destination
        errorLabel.setVisible(true);
      }
      else if (departDate == null){
        if (returnDate == null && way){
          errorLabel.setText("Missing Return Date");
          errorLabel.setVisible(true);
        }
        errorLabel.setText("Missing Date");
        System.out.println("Depart Date"+departDate);
        errorLabel.setVisible(true);
      }
      else {
        if (lock){ //Lock for multiple clicks
          errorLabel.setVisible(false);
          customerArray = new Customer[passengers]; //Initializing our array of Customers to pass through gui's
          for (int i = 0; i < customerArray.length; i++){
            Customer test = new Customer();
            customerArray[i] = test;
          }
          if (way){ //Different action if one or roundtrip is selected. True = roundtrip
            flightArray = new Flight[2]; //Initializing our array of flights (Round trip will always be two flights)
            for (int i = 0; i < flightArray.length; i++){ //Flight at 0 will be the go and flight at 1 will be the back
              Flight test = new Flight();
              flightArray[i] = test;
              if (i == 0){
                test.setToAirCode(toAirCode);
                test.setFromAirCode(fromAirCode);
                test.setDepartDate(departDate);
              }
              else {
                test.setToAirCode(fromAirCode);
                test.setFromAirCode(toAirCode);
                test.setDepartDate(returnDate);
              }
            }
            System.out.println("Way: "+way);
            System.out.println("Lock: "+lock);
            System.out.println("Customer first name: "+customerArray[0].getFirstName());
            System.out.println("Passangers: "+passengers);
            System.out.println("Customer array length: "+customerArray.length);
            System.out.println("Flight array length: "+flightArray.length);
            System.out.println("First flight toAirCode: "+flightArray[0].getToAirCode());
            System.out.println("First flight fromAirCode: "+flightArray[0].getFromAirCode());
            System.out.println("Second flight toAirCode: "+flightArray[1].getToAirCode());
            System.out.println("Second flight fromAirCode: "+flightArray[1].getFromAirCode());
            System.out.println("Depart Date: "+flightArray[0].getDepartDate());
            System.out.println("Return Date: "+flightArray[1].getDepartDate());
          }
          else {
            flightArray = new Flight[1];
            Flight test = new Flight();
            flightArray[0] = test;
            test.setToAirCode(toAirCode);
            test.setFromAirCode(fromAirCode);
            test.setDepartDate(departDate);
            System.out.println("Way: "+way);
            System.out.println("Lock: "+lock);
            System.out.println("Customer first name: "+customerArray[0].getFirstName());
            System.out.println("Passangers: "+passengers);
            System.out.println("Customer array length: "+customerArray.length);
            System.out.println("Flight array length: "+flightArray.length);
            System.out.println("Flight toAirCode: "+flightArray[0].getToAirCode());
            System.out.println("Flight fromAirCode: "+flightArray[0].getFromAirCode());
            System.out.println("Depart Date: "+departDate);
            System.out.println("Depart Date from flight: "+flightArray[0].getDepartDate());
          }
          FlightWindow myFlight = new FlightWindow(customerArray, flightArray);
          lock = false;
        }
        else{
          System.out.println("No more");
          lock = true;
        }
      }
    }
  }

  private class passengersBoxChange implements ActionListener{
    public void actionPerformed(ActionEvent e){
      String temp = (String) passengersBox.getSelectedItem();
      passengers = Integer.parseInt(temp);
    }
  }

  private class fromBoxChange implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      String selection = (String) fromBox.getSelectedItem();
      airportBox.removeAllItems();
      switch (selection){
        case "Alabama":
          for (int i = 0; i < alabamaAirports.length; i++){
            airportBox.addItem(alabamaAirports[i]);
          }
          break;
        case "Alaska":
          for (int i = 0; i < alaskaAirports.length; i++){
            airportBox.addItem(alaskaAirports[i]);
          }
          break;
        case "Arizona":
          for (int i = 0; i < arizonaAirports.length; i++){
            airportBox.addItem(arizonaAirports[i]);
          }
          break;
        case "Arkansas":
          for (int i = 0; i < arkansasAirports.length; i++){
            airportBox.addItem(arkansasAirports[i]);
          }
          break;
        case "California":
          for (int i = 0; i < californiaAirports.length; i++){
            airportBox.addItem(californiaAirports[i]);
          }
          break;
        case "Colorado":
          for (int i = 0; i < coloradoAirports.length; i++){
            airportBox.addItem(coloradoAirports[i]);
          }
          break;
        case "Connecticut":
          for (int i = 0; i < connecticutAirports.length; i++){
            airportBox.addItem(connecticutAirports[i]);
          }
          break;
        case "District Of Colombia":
          for (int i = 0; i < districtAirports.length; i++){
            airportBox.addItem(districtAirports[i]);
          }
          break;
        case "Florida":
          for (int i = 0; i < floridaAirports.length; i++){
            airportBox.addItem(floridaAirports[i]);
          }
          break;
        case "Georgia":
          for (int i = 0; i < georgiaAirports.length; i++){
            airportBox.addItem(georgiaAirports[i]);
          }
          break;
        case "Hawaii":
          for (int i = 0; i < hawaiiAirports.length; i++){
            airportBox.addItem(hawaiiAirports[i]);
          }
          break;
        case "Idaho":
          for (int i = 0; i < idahoAirports.length; i++){
            airportBox.addItem(idahoAirports[i]);
          }
          break;
        case "Illinois":
          for (int i = 0; i < illinoisAirports.length; i++){
            airportBox.addItem(illinoisAirports[i]);
          }
          break;
        case "Indiana":
          for (int i = 0; i < indianaAirports.length; i++){
            airportBox.addItem(indianaAirports[i]);
          }
          break;
        case "Iowa":
          for (int i = 0; i < iowaAirports.length; i++){
            airportBox.addItem(iowaAirports[i]);
          }
          break;
        case "Kansas":
          for (int i = 0; i < kansasAirports.length; i++){
            airportBox.addItem(kansasAirports[i]);
          }
          break;
        case "Kentucky":
          for (int i = 0; i < kentuckyAirports.length; i++) {
            airportBox.addItem(kentuckyAirports[i]);
          }
          break;
        case "Louisiana":
          for (int i = 0; i < louisianaAirports.length; i++){
            airportBox.addItem(louisianaAirports[i]);
          }
          break;
        case "Maine":
          for (int i = 0; i < maineAirports.length; i++){
            airportBox.addItem(maineAirports[i]);
          }
          break;
        case "Maryland":
          for (int i = 0; i < marylandAirports.length; i++){
            airportBox.addItem(marylandAirports[i]);
          }
          break;
        case "Massachusetts":
          for (int i = 0; i < massachusettsAirports.length; i++){
            airportBox.addItem(massachusettsAirports[i]);
          }
          break;
        case "Michigan":
          for (int i = 0; i < michiganAirports.length; i++){
            airportBox.addItem(michiganAirports[i]);
          }
          break;
        case "Minnesota":
          for (int i = 0; i < minnesotaAirports.length; i++){
            airportBox.addItem(minnesotaAirports[i]);
          }
          break;
        case "Mississippi":
          for (int i = 0; i < mississippiAirports.length; i++){
            airportBox.addItem(mississippiAirports[i]);
          }
          break;
        case "Missouri":
          for (int i = 0; i < missouriAirports.length; i++){
            airportBox.addItem(missouriAirports[i]);
          }
          break;
        case "Montana":
          for (int i = 0; i < montanaAirports.length; i++){
            airportBox.addItem(montanaAirports[i]);
          }
          break;
        case "Nebraska":
          for (int i = 0; i < nebraskaAirports.length; i++){
            airportBox.addItem(nebraskaAirports[i]);
          }
          break;
        case "Nevada":
          for (int i = 0; i < nevadaAirports.length; i++){
            airportBox.addItem(nevadaAirports[i]);
          }
          break;
        case "New Hampshire":
          for (int i = 0; i < newhampshireAirports.length; i++){
            airportBox.addItem(newhampshireAirports[i]);
          }
          break;
        case "New Jersey":
          for (int i = 0; i < newjerseyAirports.length; i++){
            airportBox.addItem(newjerseyAirports[i]);
          }
          break;
        case "New Mexico":
          for (int i = 0; i < newmexicoAirports.length; i++){
            airportBox.addItem(newmexicoAirports[i]);
          }
          break;
        case "New York":
          for (int i = 0; i < newyorkAirports.length; i++){
            airportBox.addItem(newyorkAirports[i]);
          }
          break;
        case "North Carolina":
          for (int i = 0; i < northcarolinaAirports.length; i++){
            airportBox.addItem(northcarolinaAirports[i]);
          }
          break;
        case "North Dakota":
          for (int i = 0; i < northdakotaAirports.length; i++){
            airportBox.addItem(northdakotaAirports[i]);
          }
          break;
        case "Ohio":
          for (int i = 0; i < ohioAirports.length; i++){
            airportBox.addItem(ohioAirports[i]);
          }
          break;
        case "Oklahoma":
          for (int i = 0; i < oklahomaAirports.length; i++){
            airportBox.addItem(oklahomaAirports[i]);
          }
          break;
        case "Oregon":
          for (int i = 0; i < oregonAirports.length; i++){
            airportBox.addItem(oregonAirports[i]);
          }
          break;
        case "Pennsylvania":
          for (int i = 0; i < pennsylvaniaAirports.length; i++ ) {
            airportBox.addItem(pennsylvaniaAirports[i]);
          }
          break;
        case "Rhode Island":
          for (int i = 0; i < rhodeislandAirports.length; i++) {
            airportBox.addItem(rhodeislandAirports[i]);
          }
          break;
        case "South Carolina":
          for (int i = 0; i < southcarolinaAirports.length; i++) {
            airportBox.addItem(southcarolinaAirports[i]);
          }
          break;
        case "South Dakota":
          for (int i = 0; i < southdakotaAirports.length; i++) {
            airportBox.addItem(southdakotaAirports[i]);
          }
          break;
        case "Tennessee":
          for (int i = 0; i < tennesseeAirports.length; i++) {
            airportBox.addItem(tennesseeAirports[i]);
          }
          break;
        case "Texas":
          for (int i = 0; i < texasAirports.length; i++) {
            airportBox.addItem(texasAirports[i]);
          }
          break;
        case "Utah":
          for (int i = 0; i < utahAirports.length; i++) {
            airportBox.addItem(utahAirports[i]);
          }
          break;
        case "Vermont":
          for (int i = 0; i < vermontAirports.length; i++) {
            airportBox.addItem(vermontAirports[i]);
          }
          break;
        case "Virginia":
          for (int i = 0; i < virginiaAirports.length; i++) {
            airportBox.addItem(virginiaAirports[i]);
          }
          break;
        case "Washington":
          for (int i = 0; i < washingtonAirports.length; i++) {
            airportBox.addItem(washingtonAirports[i]);
          }
          break;
        case "West Virginia":
          for (int i = 0; i < westvirginiaAirports.length; i++) {
            airportBox.addItem(westvirginiaAirports[i]);
          }
          break;
        case "Wisconsin":
          for (int i = 0; i < wisconsinAirports.length; i++) {
            airportBox.addItem(wisconsinAirports[i]);
          }
          break;
        case "Wyoming":
          for (int i = 0; i < wyomingAirports.length; i++) {
            airportBox.addItem(wyomingAirports[i]);
          }
          break;
        default:
          System.out.println("No Available Airports");
          break;
      }
    }
  }

  private class airportBoxChange implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      try {
        // Gets the code for the selected airport
        String selection = (String) airportBox.getSelectedItem();
        char[] test = selection.toCharArray();
        char[] code = {'A', 'B', 'C'};
        int length = test.length - 2;
        int i = code.length - 1;
        while (i >= 0){
          code[i] = test[length];
          length--;
          i--;
        }
        fromAirCode = new String(code);
      }
      catch(NullPointerException er) {
        System.out.println("Caught one boss!");
      }
    }
  }

  private class toBoxChange implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      String selection = (String) toBox.getSelectedItem();
      airportBox2.removeAllItems();
      switch (selection){
        case "Alabama":
          for (int i = 0; i < alabamaAirports.length; i++){
            airportBox2.addItem(alabamaAirports[i]);
          }
          break;
        case "Alaska":
          for (int i = 0; i < alaskaAirports.length; i++){
            airportBox2.addItem(alaskaAirports[i]);
          }
          break;
        case "Arizona":
          for (int i = 0; i < arizonaAirports.length; i++){
            airportBox2.addItem(arizonaAirports[i]);
          }
          break;
        case "Arkansas":
          for (int i = 0; i < arkansasAirports.length; i++){
            airportBox2.addItem(arkansasAirports[i]);
          }
          break;
        case "California":
          for (int i = 0; i < californiaAirports.length; i++){
            airportBox2.addItem(californiaAirports[i]);
          }
          break;
        case "Colorado":
          for (int i = 0; i < coloradoAirports.length; i++){
            airportBox2.addItem(coloradoAirports[i]);
          }
          break;
        case "Connecticut":
          for (int i = 0; i < connecticutAirports.length; i++){
            airportBox2.addItem(connecticutAirports[i]);
          }
          break;
        case "District Of Colombia":
          for (int i = 0; i < districtAirports.length; i++){
            airportBox2.addItem(districtAirports[i]);
          }
          break;
        case "Florida":
          for (int i = 0; i < floridaAirports.length; i++){
            airportBox2.addItem(floridaAirports[i]);
          }
          break;
        case "Georgia":
          for (int i = 0; i < georgiaAirports.length; i++){
            airportBox2.addItem(georgiaAirports[i]);
          }
          break;
        case "Hawaii":
          for (int i = 0; i < hawaiiAirports.length; i++){
            airportBox2.addItem(hawaiiAirports[i]);
          }
          break;
        case "Idaho":
          for (int i = 0; i < idahoAirports.length; i++){
            airportBox2.addItem(idahoAirports[i]);
          }
          break;
        case "Illinois":
          for (int i = 0; i < illinoisAirports.length; i++){
            airportBox2.addItem(illinoisAirports[i]);
          }
          break;
        case "Indiana":
          for (int i = 0; i < indianaAirports.length; i++){
            airportBox2.addItem(indianaAirports[i]);
          }
          break;
        case "Iowa":
          for (int i = 0; i < iowaAirports.length; i++){
            airportBox2.addItem(iowaAirports[i]);
          }
          break;
        case "Kansas":
          for (int i = 0; i < kansasAirports.length; i++){
            airportBox2.addItem(kansasAirports[i]);
          }
          break;
        case "Kentucky":
          for (int i = 0; i < kentuckyAirports.length; i++) {
            airportBox2.addItem(kentuckyAirports[i]);
          }
          break;
        case "Louisiana":
          for (int i = 0; i < louisianaAirports.length; i++){
            airportBox2.addItem(louisianaAirports[i]);
          }
          break;
        case "Maine":
          for (int i = 0; i < maineAirports.length; i++){
            airportBox2.addItem(maineAirports[i]);
          }
          break;
        case "Maryland":
          for (int i = 0; i < marylandAirports.length; i++){
            airportBox2.addItem(marylandAirports[i]);
          }
          break;
        case "Massachusetts":
          for (int i = 0; i < massachusettsAirports.length; i++){
            airportBox2.addItem(massachusettsAirports[i]);
          }
          break;
        case "Michigan":
          for (int i = 0; i < michiganAirports.length; i++){
            airportBox2.addItem(michiganAirports[i]);
          }
          break;
        case "Minnesota":
          for (int i = 0; i < minnesotaAirports.length; i++){
            airportBox2.addItem(minnesotaAirports[i]);
          }
          break;
        case "Mississippi":
          for (int i = 0; i < mississippiAirports.length; i++){
            airportBox2.addItem(mississippiAirports[i]);
          }
          break;
        case "Missouri":
          for (int i = 0; i < missouriAirports.length; i++){
            airportBox2.addItem(missouriAirports[i]);
          }
          break;
        case "Montana":
          for (int i = 0; i < montanaAirports.length; i++){
            airportBox2.addItem(montanaAirports[i]);
          }
          break;
        case "Nebraska":
          for (int i = 0; i < nebraskaAirports.length; i++){
            airportBox2.addItem(nebraskaAirports[i]);
          }
          break;
        case "Nevada":
          for (int i = 0; i < nevadaAirports.length; i++){
            airportBox2.addItem(nevadaAirports[i]);
          }
          break;
        case "New Hampshire":
          for (int i = 0; i < newhampshireAirports.length; i++){
            airportBox2.addItem(newhampshireAirports[i]);
          }
          break;
        case "New Jersey":
          for (int i = 0; i < newjerseyAirports.length; i++){
            airportBox2.addItem(newjerseyAirports[i]);
          }
          break;
        case "New Mexico":
          for (int i = 0; i < newmexicoAirports.length; i++){
            airportBox2.addItem(newmexicoAirports[i]);
          }
          break;
        case "New York":
          for (int i = 0; i < newyorkAirports.length; i++){
            airportBox2.addItem(newyorkAirports[i]);
          }
          break;
        case "North Carolina":
          for (int i = 0; i < northcarolinaAirports.length; i++){
            airportBox2.addItem(northcarolinaAirports[i]);
          }
          break;
        case "North Dakota":
          for (int i = 0; i < northdakotaAirports.length; i++){
            airportBox2.addItem(northdakotaAirports[i]);
          }
          break;
        case "Ohio":
          for (int i = 0; i < ohioAirports.length; i++){
            airportBox2.addItem(ohioAirports[i]);
          }
          break;
        case "Oklahoma":
          for (int i = 0; i < oklahomaAirports.length; i++){
            airportBox2.addItem(oklahomaAirports[i]);
          }
          break;
        case "Oregon":
          for (int i = 0; i < oregonAirports.length; i++){
            airportBox2.addItem(oregonAirports[i]);
          }
          break;
        case "Pennsylvania":
          for (int i = 0; i < pennsylvaniaAirports.length; i++ ) {
            airportBox2.addItem(pennsylvaniaAirports[i]);
          }
          break;
        case "Rhode Island":
          for (int i = 0; i < rhodeislandAirports.length; i++) {
            airportBox2.addItem(rhodeislandAirports[i]);
          }
          break;
        case "South Carolina":
          for (int i = 0; i < southcarolinaAirports.length; i++) {
            airportBox2.addItem(southcarolinaAirports[i]);
          }
          break;
        case "South Dakota":
          for (int i = 0; i < southdakotaAirports.length; i++) {
            airportBox2.addItem(southdakotaAirports[i]);
          }
          break;
        case "Tennessee":
          for (int i = 0; i < tennesseeAirports.length; i++) {
            airportBox2.addItem(tennesseeAirports[i]);
          }
          break;
        case "Texas":
          for (int i = 0; i < texasAirports.length; i++) {
            airportBox2.addItem(texasAirports[i]);
          }
          break;
        case "Utah":
          for (int i = 0; i < utahAirports.length; i++) {
            airportBox2.addItem(utahAirports[i]);
          }
          break;
        case "Vermont":
          for (int i = 0; i < vermontAirports.length; i++) {
            airportBox2.addItem(vermontAirports[i]);
          }
          break;
        case "Virginia":
          for (int i = 0; i < virginiaAirports.length; i++) {
            airportBox2.addItem(virginiaAirports[i]);
          }
          break;
        case "Washington":
          for (int i = 0; i < washingtonAirports.length; i++) {
            airportBox2.addItem(washingtonAirports[i]);
          }
          break;
        case "West Virginia":
          for (int i = 0; i < westvirginiaAirports.length; i++) {
            airportBox2.addItem(westvirginiaAirports[i]);
          }
          break;
        case "Wisconsin":
          for (int i = 0; i < wisconsinAirports.length; i++) {
            airportBox2.addItem(wisconsinAirports[i]);
          }
          break;
        case "Wyoming":
          for (int i = 0; i < wyomingAirports.length; i++) {
            airportBox2.addItem(wyomingAirports[i]);
          }
          break;
        default:
          System.out.println("No Airports Available");
          break;
      }
    }
  }

  private class airportBox2Change implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      try {
        // Gets the code for the selected airportBox2
        String selection = (String) airportBox2.getSelectedItem();
        char[] test = selection.toCharArray();
        char[] code = {'A', 'B', 'C'};
        int length = test.length - 2;
        int i = code.length - 1;
        while (i >= 0){
          code[i] = test[length];
          length--;
          i--;
        }
        toAirCode = new String(code);
      }
      catch(NullPointerException er) {
        System.out.println("Caught one boss!");
      }
    }
  }

  /***
    *
    *
    * CALENDAR METHODS
    *
    *
  ***/
  public void refreshCalendar(int month, int year){
    String[] months = {
      "January",
      "February",
      "March",
      "April",
      "May",
      "June",
      "July",
      "August",
      "September",
      "October",
      "November",
      "December"
    };

    int nod, som; //Number of Days, Start of MONTH
    prevButt.setEnabled(true);
    nextButt.setEnabled(true);
    if (month == 0 && year <= realYear){ //too early
      prevButt.setEnabled(false);
    }
    if (month == 11 & year >= realYear+5){ //too late
      nextButt.setEnabled(false);
    }

    monthLabel.setText(months[month]); //Refreshe month label
    monthLabel.setBounds(100, 25, 180, 25); //Realign with calendar

    yearBox.setSelectedItem(String.valueOf(year));

    //Get Number of days and start of month
    GregorianCalendar cal = new GregorianCalendar(year, month, 1);
    nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
    som = cal.get(GregorianCalendar.DAY_OF_WEEK);

    //Clear Table
    for (int i = 0; i < 6; i++){
      for (int j = 0; j < 7; j++){
        mCalendarTable.setValueAt(null, i, j);
      }
    }

    for (int i = 1; i <= nod; i++){
      int row = ((i+som-2)/7);
      int column = (i+som-2)%7;
      mCalendarTable.setValueAt(i, row, column);
    }

    calendarTable.setDefaultRenderer(calendarTable.getColumnClass(0), new tblCalendarRenderer()); //Apply Render

  }

  private class prevButt_Action implements ActionListener{
    public void actionPerformed (ActionEvent e){
      if (currentMonth == 0){ //Back one year
        currentMonth = 11;
        currentYear -=1;
      }
      else { //Back one month
        currentMonth -= 1;
      }
      refreshCalendar(currentMonth, currentYear);
    }
  }

  private class nextButt_Action implements ActionListener{
    public void actionPerformed (ActionEvent e){
      if (currentMonth == 11){ //Foward one year
        currentMonth = 0;
        currentYear += 1;
      }
      else{ //Foward one month
        currentMonth += 1;
      }
      refreshCalendar(currentMonth, currentYear);
    }
  }

  private class yearBox_Action implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (yearBox.getSelectedItem() != null){
        String b = yearBox.getSelectedItem().toString();
        currentYear = Integer.parseInt(b);
        refreshCalendar(currentMonth, currentYear);
      }
    }
  }

  private class mouse_Action implements MouseListener{
    public void mousePressed(MouseEvent e){
      click();
      calendarTable.setDefaultRenderer(calendarTable.getColumnClass(0), new tblCalendarRenderer()); //Apply Render
    }
    public void mouseReleased(MouseEvent e){
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e){
    }
    public void mouseClicked(MouseEvent e){
      click();
      setDepartDate();
    }
  }

  private void setDepartDate(){
    departDate = "";
    departDate = departDate.concat(String.valueOf(currentYear));
    departDate = departDate.concat("/");
    if (currentMonth < 10){
      String test = String.valueOf(currentMonth);
      String correct = "0"+test;
      departDate = departDate.concat(correct);
      departDate = departDate.concat("/");
    }
    else {
      departDate = departDate.concat(String.valueOf(currentMonth));
      departDate = departDate.concat("/");
    }
    if (currentDay < 10){
      String test2 = String.valueOf(currentDay);
      String correct2 = "0"+test2;
      departDate = departDate.concat(correct2);
    }
    else {
      departDate = departDate.concat(String.valueOf(currentDay));
    }
    departField.setText(departDate);

  }

  private void click(){
    try {
      int row = calendarTable.getSelectedRow();
      int col = calendarTable.getSelectedColumn();
      currentDay = (int) calendarTable.getValueAt(row, col);
    }
    catch(NullPointerException er){
      System.out.println("Caught one boss");
    }
  }


  private class tblCalendarRenderer extends DefaultTableCellRenderer{
    public Component getTableCellRendererComponent (JTable table, Object value,
  boolean selected, boolean focused, int row, int column){
      super.getTableCellRendererComponent(table, value, selected, focused, row, column);
      if (column == 0 || column == 6) {
        setBackground(new Color(255, 220, 220));
      }
      else {//DAY_OF_WEEK
        setBackground(new Color(255, 255, 255));
      }
      if (value != null){
        if (Integer.parseInt(value.toString()) == currentDay) {//Today
          setBackground(new Color(220, 220, 255));
        }
      }
      setBorder(null);
      setForeground(Color.black);
      return this;
    }
  }

  /***
    *
    * CALENDAR 2 METHODS
    *
  ***/
  public void refreshCalendar2(int month, int year){
    String[] months = {
      "January",
      "February",
      "March",
      "April",
      "May",
      "June",
      "July",
      "August",
      "September",
      "October",
      "November",
      "December"
    };

    int nod, som; //Number of Days, Start of MONTH
    prevButt2.setEnabled(true);
    nextButt2.setEnabled(true);
    if (month == 0 && year <= realYear){ //too early
      prevButt2.setEnabled(false);
    }
    if (month == 11 & year >= realYear+5){ //too late
      nextButt2.setEnabled(false);
    }

    monthLabel2.setText(months[month]); //Refreshe month label
    monthLabel2.setBounds(100, 25, 180, 25); //Realign with calendar

    yearBox2.setSelectedItem(String.valueOf(year));

    //Get Number of days and start of month
    GregorianCalendar cal2 = new GregorianCalendar(year, month, 1);
    nod = cal2.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
    som = cal2.get(GregorianCalendar.DAY_OF_WEEK);

    //Clear Table
    for (int i = 0; i < 6; i++){
      for (int j = 0; j < 7; j++){
        mCalendarTable2.setValueAt(null, i, j);
      }
    }

    for (int i = 1; i <= nod; i++){
      int row = ((i+som-2)/7);
      int column = (i+som-2)%7;
      mCalendarTable2.setValueAt(i, row, column);
    }

    calendarTable2.setDefaultRenderer(calendarTable2.getColumnClass(0), new tblCalendarRenderer2()); //Apply Render

  }

  private class prevButt2_Action implements ActionListener{
    public void actionPerformed (ActionEvent e){
      if (currentMonth2 == 0){ //Back one year
        currentMonth2 = 11;
        currentYear2 -=1;
      }
      else { //Back one month
        currentMonth2 -= 1;
      }
      refreshCalendar2(currentMonth2, currentYear2);
    }
  }

  private class nextButt2_Action implements ActionListener{
    public void actionPerformed (ActionEvent e){
      if (currentMonth2 == 11){ //Foward one year
        currentMonth2 = 0;
        currentYear2 += 1;
      }
      else{ //Foward one month
        currentMonth2 += 1;
      }
      refreshCalendar2(currentMonth2, currentYear2);
    }
  }

  private class yearBox2_Action implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (yearBox2.getSelectedItem() != null){
        String b = yearBox2.getSelectedItem().toString();
        currentYear = Integer.parseInt(b);
        refreshCalendar2(currentMonth2, currentYear2);
      }
    }
  }

  private class mouse2_Action implements MouseListener{
    public void mousePressed(MouseEvent e){
      click2();
      calendarTable2.setDefaultRenderer(calendarTable2.getColumnClass(0), new tblCalendarRenderer2()); //Apply Render
    }
    public void mouseReleased(MouseEvent e){
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e){
    }
    public void mouseClicked(MouseEvent e){
      click2();
      setReturnDate();
    }
  }

  private void setReturnDate(){
    returnDate = "";
    returnDate = returnDate.concat(String.valueOf(currentYear2));
    returnDate = returnDate.concat("/");
    if (currentMonth2 < 10){
      String test = String.valueOf(currentMonth2);
      String correct = "0"+test;
      returnDate = returnDate.concat(correct);
      returnDate = returnDate.concat("/");
    }
    else {
      returnDate = returnDate.concat(String.valueOf(currentMonth2));
      returnDate = returnDate.concat("/");
    }
    if (currentDay2 < 10){
      String test2 = String.valueOf(currentDay2);
      String correct2 = "0"+test2;
      returnDate = returnDate.concat(correct2);
    }
    else {
      returnDate = returnDate.concat(String.valueOf(currentDay2));
    }
    returnField.setText(returnDate);
  }

  private void click2(){
    try {
      int row = calendarTable2.getSelectedRow();
      int col = calendarTable2.getSelectedColumn();
      currentDay2 = (int) calendarTable2.getValueAt(row, col);
    }
    catch(NullPointerException er){
      System.out.println("Caught one boss");
    }
  }


  private class tblCalendarRenderer2 extends DefaultTableCellRenderer{
    public Component getTableCellRendererComponent (JTable table, Object value,
  boolean selected, boolean focused, int row, int column){
      super.getTableCellRendererComponent(table, value, selected, focused, row, column);
      if (column == 0 || column == 6) {
        setBackground(new Color(255, 220, 220));
      }
      else {//DAY_OF_WEEK
        setBackground(new Color(255, 255, 255));
      }
      if (value != null){
        if (Integer.parseInt(value.toString()) == currentDay2) {//Today
          setBackground(new Color(220, 220, 255));
        }
      }
      setBorder(null);
      setForeground(Color.black);
      return this;
    }
  }
}
