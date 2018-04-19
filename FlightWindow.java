import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.Container;
import java.awt.Component;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class FlightWindow extends JFrame{

  private Customer[] customerArray;
  private Flight[] flightArray;

  private JPanel tablePanel;
  private JPanel bottPanel;

  private Container pane;

  private JTable testTable, testTable2;
  private DefaultTableModel mTestTable, mTestTable2;

  private JScrollPane testPane, testPane2;

  private JLabel selectLabel, selectLabel2, customerLabel, customerLabel2, errorLabel;

  private JRadioButton mainButton, mainButton2; //Main Cabin
  private JRadioButton deltaButton, deltaButton2; //Delta+ Comfort
  private JRadioButton firstButton, firstButton2; //FirstClass
  private ButtonGroup seatGroup, seatGroup2;

  private JTextField seatField,seatField2;
  private JButton seatButton, seatButton2, confirmButton, backButton;

  final int FRAME_WIDTH;
  final int FRAME_LENGTH;

  private final String newline = "\n";
  private File file, file2;
  private FileReader fileReader, fileReader2;
  private BufferedReader bufferedReader, bufferedReader2;
  private StringBuffer stringBuffer, stringBuffer2;
  private StringBuffer selectedBuffer, selectedBuffer2;
  private String line, line2;


  private int min, max;
  private String departTime, returnTime;

  private String[] headers = {
    "From: ",
    "To: ",
    "Date: ",
    "Time: "
  };

  private String[][] data;
  private String[][] data2;

  public FlightWindow(Customer[] customerArray, Flight[] flightArray){
    this.customerArray = customerArray;
    this.flightArray = flightArray;
    min = 0;
    max = customerArray.length;

    FRAME_WIDTH = 800;
    FRAME_LENGTH = 750;

    if (flightArray.length == 1){ //One way flight has one flight
      try {
        file = new File("Plane.txt");
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        stringBuffer = new StringBuffer();
        selectedBuffer = new StringBuffer();
        while ((line = bufferedReader.readLine()) != null){
          if (line.contains(flightArray[0].getFromAirCode()) && line.contains(flightArray[0].getToAirCode()) && line.contains(flightArray[0].getDepartDate())){
            stringBuffer.append(line);
            int index = stringBuffer.indexOf(flightArray[0].getFromAirCode());
            selectedBuffer.append(stringBuffer.substring(index, stringBuffer.length()-4));
            stringBuffer.delete(0, stringBuffer.length());
          }
        }
        fileReader.close();
        //table stuff
        data = new String[5][4];
        String[] split = selectedBuffer.toString().split("\t");
        int x = 0;

        for (int i = 0; i < data.length; i++){
          for (int j = 0; j < data[0].length; j++){
            if (x > split.length - 1){
              break;
            }
            data[i][j] = split[x];
            x++;
          }
        }
      }
      catch(IOException e){
        e.printStackTrace();
      }
    }
    else {  //Two way flight has two flight
      try{
        file = new File("Plane.txt");
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        stringBuffer = new StringBuffer();
        selectedBuffer = new StringBuffer();
        while ((line = bufferedReader.readLine()) != null){
          if (line.contains(flightArray[0].getFromAirCode()) && line.contains(flightArray[0].getToAirCode()) && line.contains(flightArray[0].getDepartDate())){
            stringBuffer.append(line);
            int index = stringBuffer.indexOf(flightArray[0].getFromAirCode());
            selectedBuffer.append(stringBuffer.substring(index, stringBuffer.length()-4));
            stringBuffer.delete(0, stringBuffer.length());
          }
        }
        fileReader.close();
        //table stuff
        data = new String[5][4];
        String[] split = selectedBuffer.toString().split("\t");
        int x = 0;

        for (int i = 0; i < data.length; i++){
          for (int j = 0; j < data[0].length; j++){
            if (x > split.length - 1){
              break;
            }
            data[i][j] = split[x];
            x++;
          }
        }

        file2 = new File("Plane.txt");
        fileReader2 = new FileReader(file2);
        bufferedReader2 = new BufferedReader(fileReader2);
        stringBuffer2 = new StringBuffer();
        selectedBuffer2 = new StringBuffer();
        while ((line2 = bufferedReader2.readLine()) != null){
          if (line2.contains(flightArray[1].getFromAirCode()) && line2.contains(flightArray[1].getToAirCode()) && line2.contains(flightArray[1].getDepartDate())){
            stringBuffer2.append(line2);
            int index = stringBuffer2.indexOf(flightArray[1].getFromAirCode());
            selectedBuffer2.append(stringBuffer2.substring(index, stringBuffer2.length()-4));
            stringBuffer2.delete(0, stringBuffer2.length());
          }
        }
        fileReader2.close();
        //table stuff
        data2 = new String[5][4];
        String[] split2 = selectedBuffer2.toString().split("\t");
        x = 0;
        for (int i = 0; i < data2.length; i++){
          for (int j = 0; j < data2[0].length; j++){
            if (x > split2.length - 1){
              break;
            }
            data2[i][j] = split2[x];
            x++;
          }
        }
      }
    catch(IOException e){
        e.printStackTrace();
      }
  }

    //TOP PANEL
    tablePanel = new JPanel(null);
    tablePanel.setBounds(0, 0, 800, 350);
    tablePanel.setBackground(new Color(255, 220, 220));

    selectLabel = new JLabel("Select First Flight: ");
    selectLabel.setBounds(400, 20, 150, 25);

    customerLabel = new JLabel("Seat for Customer #1");
    customerLabel.setBounds(25, 15, 150, 25);

    errorLabel = new JLabel();
    errorLabel.setBounds(400, 250, 150, 25);
    errorLabel.setVisible(false);

    mainButton = new JRadioButton("MAIN CABIN");
    mainButton.setBounds(25, 50, 150, 50);

    deltaButton = new JRadioButton("DELTA COMFORT+");
    deltaButton.setBounds(25, 100, 150, 50);

    firstButton = new JRadioButton("FIRST CLASS");
    firstButton.setBounds(25, 150, 150, 50);

    seatGroup = new ButtonGroup();
    seatGroup.add(mainButton);
    seatGroup.add(deltaButton);
    seatGroup.add(firstButton);

    seatField = new JTextField("SEAT #");
    seatField.setBounds(25, 250, 100, 25);
    seatField.setEditable(false);

    seatButton = new JButton("SELECT SEAT");
    seatButton.setBounds(125, 240, 100, 50);



    mTestTable = new DefaultTableModel(data, headers){
      public boolean isCellEditable(int rowIndex, int mColIndex){
        return false;
      }
    };
    testTable = new JTable(data, headers);
    testTable.setModel(mTestTable);

    testPane = new JScrollPane(testTable);
    testPane.setBounds(400, 50, 400, 150);

    testTable.getParent().setBackground(testTable.getBackground()); //Strange but needed

    testTable.getTableHeader().setResizingAllowed(false);
    testTable.getTableHeader().setReorderingAllowed(false);

    //Single Cell Seletion
    testTable.setColumnSelectionAllowed(true);
    testTable.setRowSelectionAllowed(true);
    testTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    //Set row/column Count
    testTable.setRowHeight(35);



    /***
      *
      * BOTTOM PANEL STUFF
      *
    ***/

    bottPanel = new JPanel(null);
    bottPanel.setBounds(0, 350, 800, 400);
    bottPanel.setBackground(new Color(220, 220, 255));

    selectLabel2 = new JLabel("Select Return Flight: ");
    selectLabel2.setBounds(400, 20, 200, 25);

    customerLabel2 = new JLabel("Seat for Customer #1");
    customerLabel2.setBounds(25, 15, 150, 25);

    mainButton2 = new JRadioButton("MAIN CABIN");
    mainButton2.setBounds(25, 50, 150, 50);

    deltaButton2 = new JRadioButton("DELTA COMFORT+");
    deltaButton2.setBounds(25, 100, 150, 50);

    firstButton2 = new JRadioButton("FIRST CLASS");
    firstButton2.setBounds(25, 150, 150, 50);

    seatGroup2 = new ButtonGroup();
    seatGroup2.add(mainButton2);
    seatGroup2.add(deltaButton2);
    seatGroup2.add(firstButton2);

    seatField2 = new JTextField("SEAT #");
    seatField2.setBounds(25, 250, 100, 25);
    seatField2.setEditable(false);

    seatButton2 = new JButton("SELECT SEAT");
    seatButton2.setBounds(125, 240, 100, 50);

    confirmButton = new JButton("Confirm");
    confirmButton.setBounds(650, 275, 100, 25);

    backButton = new JButton("Back");
    backButton.setBounds(400, 275, 100, 25);


    mTestTable2 = new DefaultTableModel(data2, headers){
      public boolean isCellEditable(int rowIndex, int mColIndex){
        return false;
      }
    };
    testTable2 = new JTable(data2, headers);
    testTable2.setModel(mTestTable2);

    testPane2 = new JScrollPane(testTable2);
    testPane2.setBounds(400, 50, 400, 150);

    testTable2.getParent().setBackground(testTable2.getBackground()); //Strange but needed

    testTable2.getTableHeader().setResizingAllowed(false);
    testTable2.getTableHeader().setReorderingAllowed(false);

    //Single Cell Seletion
    testTable2.setColumnSelectionAllowed(true);
    testTable2.setRowSelectionAllowed(true);
    testTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    //Set row/column Count
    testTable2.setRowHeight(35);


    /***
      *
      * ACTION LISTENERS
      *
    ***/

    backButton backListener = new backButton();
    backButton.addActionListener(backListener);

    confirmButton confirmListener = new confirmButton();
    confirmButton.addActionListener(confirmListener);

    mainButton mainListener = new mainButton();
    mainButton.addActionListener(mainListener);

    deltaButton deltaListener = new deltaButton();
    deltaButton.addActionListener(deltaListener);

    firstButton firstListener = new firstButton();
    firstButton.addActionListener(firstListener);

    tableAction testListener = new tableAction();
    testTable.addMouseListener(testListener);

    mainButton2 main2Listener = new mainButton2();
    mainButton2.addActionListener(main2Listener);

    deltaButton2 delta2Listener = new deltaButton2();
    deltaButton2.addActionListener(delta2Listener);

    firstButton2 first2Listener = new firstButton2();
    firstButton2.addActionListener(first2Listener);

    tableAction2 test2Listener = new tableAction2();
    testTable2.addMouseListener(test2Listener);


    pane = getContentPane();

    pane.setLayout(null);

    pane.add(tablePanel);
    pane.add(bottPanel);

    tablePanel.add(testPane);
    tablePanel.add(selectLabel);
    tablePanel.add(customerLabel);
    tablePanel.add(mainButton);
    tablePanel.add(deltaButton);
    tablePanel.add(firstButton);
    tablePanel.add(seatField);
    tablePanel.add(seatButton);
    tablePanel.add(errorLabel);

    bottPanel.add(testPane2);
    testPane2.setVisible(false);

    bottPanel.add(selectLabel2);
    selectLabel2.setVisible(false);

    bottPanel.add(customerLabel2);
    customerLabel2.setVisible(false);

    bottPanel.add(mainButton2);
    mainButton2.setVisible(false);

    bottPanel.add(deltaButton2);
    deltaButton2.setVisible(false);

    bottPanel.add(firstButton2);
    firstButton2.setVisible(false);

    bottPanel.add(seatField2);
    seatField2.setVisible(false);

    bottPanel.add(seatButton2);
    seatButton2.setVisible(false);

    bottPanel.add(confirmButton);
    bottPanel.add(backButton);

    if (flightArray.length == 2){
      testPane2.setVisible(true);
      selectLabel2.setVisible(true);
      mainButton2.setVisible(true);
      deltaButton2.setVisible(true);
      firstButton2.setVisible(true);
      seatField2.setVisible(true);
      seatButton2.setVisible(true);
      customerLabel2.setVisible(true);
    }

    setLayout(null);
    setTitle("Flight Window");
    setSize(FRAME_WIDTH, FRAME_LENGTH);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null);

    setVisible(true);

  }

  private class backButton implements ActionListener{
    public void actionPerformed (ActionEvent e){
      setVisible(false);
      dispose();
    }
  }

  private class confirmButton implements ActionListener{
    public void actionPerformed (ActionEvent e){
      if (departTime == null || returnTime == null){
        errorLabel.setText("SELECT FLIGHT FIRST");
        errorLabel.setVisible(true);
      }
      else{
        errorLabel.setVisible(false);
        if (min == 0){
          flightArray[0].setDepartTime(departTime);
          if (flightArray.length == 2){
            flightArray[1].setDepartTime(returnTime);
            System.out.println("Selected Return Time: "+flightArray[1].getDepartTime());
          }
        }
        if (min < max){
          System.out.println("Current Min: "+min);
          System.out.println("Selected departTime: "+flightArray[0].getDepartTime());
          System.out.println("Selected Return Time: "+flightArray[1].getDepartTime());
          System.out.println("Customer "+min+" Seat #: "+customerArray[min].getSeat());
          System.out.println("Customer "+min+" Return seat #: "+customerArray[min].getSeatR());
          if (min+1 != max){ //Displaying the window
            customerLabel.setText("Seat for Customer #"+String.valueOf(min+2)+": ");
            customerLabel2.setText("Seat for Customer #"+String.valueOf(min+2)+": ");
          }
          seatGroup.clearSelection();
          seatField.setText("");
          seatGroup2.clearSelection();
          seatField2.setText("");
          min++;
          //CODE TO GO TO NEXT SCEEN
        }
      }
      if (min == max){
        CustomerInfoWindow test = new CustomerInfoWindow(customerArray, flightArray);
      }
      //CODE TO SET VARIABLE AND PASS
    }
  }

  private int seatGen(int max, int min){
    Random rand = new Random();
    int n = rand.nextInt(max) + min;
    return n;
  }

  private char rowGen(int max, int min){
    if (max == 3 && min == 1){
      String row1 = "ABCDEF";
      Random rand = new Random();
      int x = rand.nextInt(row1.length());
      return row1.charAt(x);
    }

    String row = "ABCDEFG";
    Random r = new Random();
    int n = r.nextInt(row.length());
    return row.charAt(n);
  }

  private class mainButton implements ActionListener{
    public void actionPerformed (ActionEvent e){
      int n = seatGen(43, 25);
      char r = rowGen(43, 25);
      String seat = String.valueOf(r);
      seat = seat.concat(String.valueOf(n));
      if (min < max){
        customerArray[min].setSeat(seat);
        seatField.setText(seat);
      }
    }
  }

  private class deltaButton implements ActionListener{
    public void actionPerformed (ActionEvent e){
      int n = seatGen(18, 10);
      char r = rowGen(18, 10);
      String seat = String.valueOf(r);
      seat = seat.concat(String.valueOf(n));
      if (min < max){
        customerArray[min].setSeat(seat);
        seatField.setText(seat);
      }
    }
  }

  private class firstButton implements ActionListener{
    public void actionPerformed (ActionEvent e){
      int n = seatGen(3, 1);
      char r = rowGen(3, 1);
      String seat = String.valueOf(r);
      seat = seat.concat(String.valueOf(n));
      if (min < max){
        customerArray[min].setSeat(seat);
        seatField.setText(seat);
      }
    }
  }

  private class tableAction implements MouseListener{
    public void mousePressed(MouseEvent e){
      try {
        int row = testTable.getSelectedRow();
        int col = 3;
        Object v = testTable.getValueAt(row, col);
        departTime = v.toString();
      }
      catch (NullPointerException er){
        System.out.println("How? idk");
      }
    }
    public void mouseReleased(MouseEvent e){
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e){
    }
    public void mouseClicked(MouseEvent e){
      try {
        int row = testTable.getSelectedRow();
        int col = 3;
        Object v = testTable.getValueAt(row, col);
        departTime = v.toString();
      }
      catch (NullPointerException er){
        System.out.println("How? idk");
      }
    }
  }

  /***
    *
    * BOTTPANEL ACTION LISTENERS
    *
  ***/

  private class mainButton2 implements ActionListener{
    public void actionPerformed (ActionEvent e){
      int n = seatGen(43, 25);
      char r = rowGen(43, 25);
      String seat = String.valueOf(r);
      seat = seat.concat(String.valueOf(n));
      if (min < max){
        customerArray[min].setSeatR(seat);
        seatField2.setText(seat);
      }
    }
  }

  private class deltaButton2 implements ActionListener{
    public void actionPerformed (ActionEvent e){
      int n = seatGen(18, 10);
      char r = rowGen(18, 10);
      String seat = String.valueOf(r);
      seat = seat.concat(String.valueOf(n));
      if (min < max){
        customerArray[min].setSeatR(seat);
        seatField2.setText(seat);
      }
    }
  }

  private class firstButton2 implements ActionListener{
    public void actionPerformed (ActionEvent e){
      int n = seatGen(3, 1);
      char r = rowGen(3, 1);
      String seat = String.valueOf(r);
      seat = seat.concat(String.valueOf(n));
      if (min < max){
        customerArray[min].setSeatR(seat);
        seatField2.setText(seat);
      }
    }
  }

  private class tableAction2 implements MouseListener{
    public void mousePressed(MouseEvent e){
      try {
        int row = testTable2.getSelectedRow();
        int col = 3;
        Object v = testTable2.getValueAt(row, col);
        returnTime = v.toString();
      }
      catch (NullPointerException er){
        System.out.println("How? idk");
      }
    }
    public void mouseReleased(MouseEvent e){
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e){
    }
    public void mouseClicked(MouseEvent e){
      try {
        int row = testTable2.getSelectedRow();
        int col = 3;
        Object v = testTable2.getValueAt(row, col);
        returnTime = v.toString();
      }
      catch (NullPointerException er){
        System.out.println("How? idk");
      }
    }
  }

}
