import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.Container;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.*;
import java.util.*;

public class Calendar extends JFrame{
  //Class values

  private String[] headers = {
    "Sun",
    "Mon",
    "Tue",
    "Wed",
    "Thu",
    "Fri",
    "Sat"
  };

  private JLabel monthLabel;
  private JLabel yearLabel;

  private JButton prevButton;
  private JButton nextButton;

  private JTable calendarTable;

  private JComboBox<String> yearBox;

  private Container pane;
  private DefaultTableModel mCalendarTable;

  private JScrollPane stblCalendar;

  private JPanel calendarPanel;

  private int realDay, realMonth, realYear, currentMonth, currentYear, currentDay;

  private String date;

  private GregorianCalendar cal;

  final int FRAME_WIDTH;
  final int FRAME_LENGTH;

  public Calendar() {

    FRAME_WIDTH = 330;
    FRAME_LENGTH = 375;

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

    monthLabel = new JLabel("January");
    monthLabel.setBounds(160-monthLabel.getPreferredSize().width/2, 25, 100, 25);

    yearLabel = new JLabel("Change Year: ");
    yearLabel.setBounds(10, 305, 100, 25);

    yearBox = new JComboBox<String>();
    yearBox.setBounds(230, 305, 80, 20);

    prevButton = new JButton("<<");
    prevButton.setBounds(10, 25, 50, 25);

    nextButton = new JButton(">>");
    nextButton.setBounds(260, 25, 50, 25);

    mCalendarTable = new DefaultTableModel(){
      public boolean isCellEditable(int rowIndex, int mColIndex){
        return false;
      }
    };

    calendarTable = new JTable(mCalendarTable);

    stblCalendar = new JScrollPane(calendarTable);
    stblCalendar.setBounds(10, 50, 300, 250);

    calendarPanel = new JPanel(null);
    calendarPanel.setBounds(0, 0, 320, 335);

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

    for (int i = realYear; i<=realYear+5; i++){ //Populate combobox
      yearBox.addItem(String.valueOf(i));
    }

    ListSelectionModel calendarSelection = calendarTable.getSelectionModel();

    pane = getContentPane();

    pane.setLayout(null);
    refreshCalendar(currentMonth, currentYear);

    calendarPanel.setBorder(BorderFactory.createTitledBorder("Calendar")); //Set Border

    //Action listeners
    prevButton_Action prevListener = new prevButton_Action();
    prevButton.addActionListener(prevListener);

    nextButton_Action nextListener = new nextButton_Action();
    nextButton.addActionListener(nextListener);

    yearBox_Action boxListener = new yearBox_Action();
    yearBox.addActionListener(boxListener);

    mouse_Action mlistener = new mouse_Action();
    calendarTable.addMouseListener(mlistener);

    pane.add(calendarPanel);

    calendarPanel.add(monthLabel);
    calendarPanel.add(yearLabel);
    calendarPanel.add(yearBox);
    calendarPanel.add(prevButton);
    calendarPanel.add(nextButton);
    calendarPanel.add(stblCalendar);


    setSize(FRAME_WIDTH, FRAME_LENGTH);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setResizable(false);
    setVisible(true);


  }

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
    prevButton.setEnabled(true);
    nextButton.setEnabled(true);
    if (month == 0 && year <= realYear){ //too early
      prevButton.setEnabled(false);
    }
    if (month == 11 & year >= realYear+5){ //too late
      nextButton.setEnabled(false);
    }

    monthLabel.setText(months[month]); //Refreshe month label
    monthLabel.setBounds(160-monthLabel.getPreferredSize().width/2, 25, 180, 25); //Realign with calendar

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

  private class prevButton_Action implements ActionListener{
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

  private class nextButton_Action implements ActionListener{
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
      System.out.println(date);
    }
  }

  public void setDate(){
    date = "";
    date = date.concat(String.valueOf(currentYear));
    date = date.concat("/");
    date = date.concat(String.valueOf(currentDay));
    date = date.concat("/");
    date = date.concat(String.valueOf(currentMonth));
  }
  public String getDate(){
    return date;
  }

  public void click(){
    try {
      int row = calendarTable.getSelectedRow();
      int col = calendarTable.getSelectedColumn();
      currentDay = (int) calendarTable.getValueAt(row, col);
      setDate();
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
}
