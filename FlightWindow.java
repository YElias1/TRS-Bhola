import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FlightWindow extends JFrame{

  private Customer[] customerArray;
  private Flight[] flightArray;

  private JTextArea flights;
  private JScrollPane flightsScroll;

  final int FRAME_WIDTH;
  final int FRAME_LENGTH;

  private final String newline = "\n";
  private File file;
  private FileReader fileReader;
  private BufferedReader bufferedReader;
  private StringBuffer stringBuffer;
  private String line;

  public FlightWindow(Customer[] customerArray, Flight[] flightArray){
    this.customerArray = customerArray;
    this.flightArray = flightArray;

    FRAME_WIDTH = 825;
    FRAME_LENGTH = 600;

    try {
      file = new File("airTest.txt");
      fileReader = new FileReader(file);
      bufferedReader = new BufferedReader(fileReader);
      stringBuffer = new StringBuffer();
      while ((line = bufferedReader.readLine()) != null){
        stringBuffer.append(line);
        stringBuffer.append(newline);
      }
      fileReader.close();
    }
    catch(IOException e){
      e.printStackTrace();
    }

    flights = new JTextArea(stringBuffer.toString());
    flights.setEditable(false);

    flightsScroll = new JScrollPane(flights);
    flightsScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    flightsScroll.setBounds(500,50,300,100);

    add(flightsScroll);

    setLayout(null);
    setTitle("Flight Window");
    setSize(FRAME_WIDTH, FRAME_LENGTH);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);

    setVisible(true);

  }

  public static void main(String[] args){
    Customer[] c = new Customer[1];
    Flight[] f = new Flight[1];
    FlightWindow myFlight = new FlightWindow(c, f);
  }
}
