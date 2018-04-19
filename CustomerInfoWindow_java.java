	import javax.swing.*;
	import javax.swing.event.*;
	import java.awt.event.*;
	import java.awt.Color;
	import java.awt.Font;
	import javax.swing.JTextField;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	public class CustomerInfoWindow extends JFrame {

		String[] birthDay = {
			"Day",
			"1",
			"2",
			"3",
			"4",
			"5",
			"6",
			"7",
			"8",
			"9",
			"10",
			"11",
			"12",
			"13",
			"14",
			"15",
			"16",
			"17",
			"18",
			"19",
			"20",
			"21",
			"22",
			"23",
			"24",
			"25",
			"26",
			"27",
			"28",
			"29",
			"30",
			"31"
		};

		String[] birthMonth = {
			"Month",
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

		String[] birthYear = {
			"Year",
			"2018",
			"2017",
			"2016",
			"2015",
			"2014",
			"2013",
			"2012",
			"2011",
			"2010",
			"2009",
			"2008",
			"2007",
			"2006",
			"2005",
			"2004",
			"2003",
			"2002",
			"2001",
			"1999",
			"1998",
			"1997",
			"1996",
			"1995",
			"1994",
			"1993",
			"1992",
			"1991",
			"1990",
			"1989",
			"1988",
			"1987",
			"1986",
			"1985",
			"1984",
			"1983",
			"1982",
			"1981",
			"1980",
			"1979",
			"1978",
			"1977",
			"1976",
			"1975",
			"1974",
			"1973",
			"1972",
			"1971",
			"1970",
			"1969",
			"1968",
			"1967",
			"1966",
			"1965",
			"1964",
			"1963",
			"1962",
			"1961",
			"1960",
			"1959",
			"1958",
			"1957",
			"1956",
			"1955",
			"1954",
			"1953",
			"1952",
			"1951",
			"1950",
			"1949",
			"1948",
			"1947",
			"1946",
			"1945",
			"1944",
			"1943",
			"1942",
			"1941",
			"1940",
			"1939",
			"1938",
			"1937",
			"1936",
			"1935",
			"1934",
			"1933",
			"1932",
			"1931",
			"1930",
			"1929",
			"1928",
			"1927",
			"1926",
			"1925",
			"1924",
			"1923",
			"1922",
			"1921",
			"1920",
			"1919",
			"1918",
			"1917",
			"1916",
			"1915",
			"1914",
			"1913",
			"1912",
			"1911",
			"1910",
		};

		String[] type = {
			"Cell",
			"Work",
			"Home"
		};

		private JButton backButton, nextButton, emVal;

		private JRadioButton mButton, fButton;
		private ButtonGroup genderGroup;

		private JLabel customerLabel, genderLabel, titleLabel, nameLabel, nameError, dob, star, contact, ctype, phoneNum, em, emco, emerror, conerror, phoneerror, nameerror;

		private JComboBox<String> dayBox, monthBox, yearBox, typeBox;

		private JTextField fullName, phone, email, emailcon;

		private Boolean nameCheck, genderCheck, phoneCheck, emailCheck, emailconCheck;

		private Customer[] customerArray;
		private Flight[] flightArray;

		private int max, current;

		public CustomerInfoWindow(Customer[] customerArray, Flight[] flightArray) {

			this.customerArray = customerArray;
			this.flightArray = flightArray;

			max = customerArray.length;
			current = 0;

			genderCheck = false;
			emailCheck = false;
			emailconCheck = false;

			titleLabel = new JLabel("Personal Information");
			titleLabel.setBounds(145, 10, 400, 50);
			titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));

			star = new JLabel("Fields with (*) are required");
			star.setBounds(175, 30, 200, 50);
			star.setFont(new Font("Times New Roman", Font.PLAIN, 15));

			customerLabel = new JLabel("Customer #1");
			customerLabel.setBounds(50, 55, 100, 20);

			nameLabel = new JLabel("Full Name:*");
			nameLabel.setBounds(50, 100, 80, 20);
			nameLabel.setForeground(Color.BLACK);

			fullName = new JTextField(30);
			fullName.setBounds(140, 100, 150, 20);

			fullName.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent ev) {
						char name1 = ev.getKeyChar();

						if (fullName.getText().length() == 50) {
							ev.consume();
						}
						if (!Character.isAlphabetic(name1)) {
							ev.consume();
							nameLabel.setForeground(Color.RED);
							nameCheck = false;
						}
						else {
							nameLabel.setForeground(Color.BLACK);
							nameCheck = true;
						}
					}
				});


			genderLabel = new JLabel("Gender:*");
			genderLabel.setBounds(50, 120, 100, 50);

			mButton = new JRadioButton("Male");
			mButton.setBounds(130, 132, 100, 25);

			fButton = new JRadioButton("Female");
			fButton.setBounds(250, 132, 100, 25);

			genderGroup = new ButtonGroup();
			genderGroup.add(mButton);
			genderGroup.add(fButton);

			mButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {

				if (mButton.isSelected()) {
					mButton.setForeground(Color.BLACK);
					genderCheck = true;
		 	  }
				if (!mButton.isSelected()) {
					mButton.setForeground(Color.RED);
		 	  }
	  	 }
		 });

		  fButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent ev) {

			  if (fButton.isSelected()) {
				 fButton.setForeground(Color.BLACK);
				 genderCheck = true;
			  }
				if (!fButton.isSelected()) {
				 fButton.setForeground(Color.RED);
			  }
			 }
		 });



			contact = new JLabel("Contact Information");
			contact.setBounds(50, 200, 150, 50);

			ctype = new JLabel("Type:");
			ctype.setBounds(50, 230, 70, 50);

			typeBox = new JComboBox<String> (type);
			typeBox.setBounds(90, 233, 80, 50);

			phoneNum = new JLabel("Phone:*");
			phoneNum.setBounds(50, 265, 55, 50);

			phone = new JTextField();
			phone.setBounds(100, 275, 100, 25);

			phone.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent ev) {
						char phone1 = ev.getKeyChar();

						if (phone.getText().length() == 10) {
							ev.consume();
							phoneNum.setForeground(Color.BLACK);
						}

						if (Character.isDigit(phone1)) {
							phoneNum.setForeground(Color.BLACK);
							phoneCheck = true;
						}
						else if (!Character.isDigit(phone1)) {
							ev.consume();
							phoneNum.setForeground(Color.RED);
							phoneCheck = false;
						}
					}
				});


			em = new JLabel("Email address:*");
			em.setBounds(50, 300, 130, 50);

			email = new JTextField(50);
			email.setBounds(150, 310, 130, 25);

			emco = new JLabel("Confirm Email address:*");
			emco.setBounds(50, 335, 170, 50);

			emailcon = new JTextField(50);
			emailcon.setBounds(205, 348, 130, 25);

			emerror = new JLabel("Invalid Email");
			emerror.setBounds(285, 310, 130, 25);
			emerror.setForeground(Color.RED);
			emerror.setVisible(false);

			conerror = new JLabel("Emails don't match");
			conerror.setBounds(340, 348, 130, 25);
			conerror.setForeground(Color.RED);
			conerror.setVisible(false);

			email.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent ev) {
					EmailValidator emailVal = new EmailValidator();

					String email1 = email.getText().trim();

					System.out.println("upstairs = " + email1);

					// if email pattern matches
					if (emailVal.validate(email1)){
						emerror.setVisible(false);
						em.setForeground(Color.BLACK);
						System.out.println("This");
						emailCheck = true;
					  } else { // if email entered doesn't match the email pattern
						emerror.setVisible(true); // show error line
						em.setForeground(Color.RED);
						System.out.println("Is");
						emailCheck = false;
					}
						System.out.println("downstairs = " + email1);
				 }
			});

			emailcon.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent ev) {
					EmailValidator emailVal = new EmailValidator();

					String email2 = emailcon.getText().trim();
					String email1 = email.getText().trim();

					System.out.println("upstairs = " + email1);
					System.out.println("upstairs = " + email2);

					if (email2.equals(email1)) { // if email confimation does not match the first email entered
						conerror.setVisible(false);
						emco.setForeground(Color.BLACK);
						System.out.println("Bull");
						emailCheck = true;
				  	} else { // if email confimation does not match the first email entered
						conerror.setVisible(true); // show error line
						emco.setForeground(Color.RED);
						System.out.println("shit");
						emailCheck = false;
					}

					if (emailVal.validate(email2)) {
						conerror.setVisible(false);
						emco.setForeground(Color.BLACK);
						System.out.println("Fucking");
						emailCheck = true;
					  } else { // if email confimation does not match the first email entered
							conerror.setVisible(true); // show error line
							emco.setForeground(Color.RED);
							System.out.println("Bhola");
							emailCheck = false;
						}
						System.out.println("downstairs = " + email1);
						System.out.println("downstairs = " + email2);
				}
			});


			dob = new JLabel("Date of Birth:*");
			dob.setBounds(50, 170, 100, 20);

			monthBox = new JComboBox<String> (birthMonth);
			monthBox.setBounds(140,155,100,50);
			monthBox.setEditable(false);

			dayBox = new JComboBox<String> (birthDay);
			dayBox.setBounds(236,155,100,50);
			dayBox.setEditable(false);

			yearBox = new JComboBox<String> (birthYear);
			yearBox.setBounds(332,155,100,50);
			yearBox.setEditable(false);



			backButton = new JButton("Back");
			backButton.setBounds(50, 400, 100, 25);

			nextButton = new JButton("Next");
			nextButton.setBounds(350, 400, 100, 25);



			nextButtonListener nextButtonL = new nextButtonListener();
			nextButton.addActionListener(nextButtonL);

			backButtonListener backButtonL = new backButtonListener();
			backButton.addActionListener(backButtonL);

			monthBoxChange monthChange = new monthBoxChange();
			monthBox.addActionListener(monthChange);



			add(titleLabel);
			add(star);

			add(customerLabel);

			add(genderLabel);
			add(mButton);
			add(fButton);

			add(contact);
			add(ctype);
			add(typeBox);
			add(phoneNum);
			add(phone);
			add(em);
			add(email);
			add(emco);
			add(emailcon);
			add(emerror);
			add(conerror);

			add(dob);
			add(monthBox);
			add(dayBox);
			add(yearBox);

			add(nameLabel);
			add(fullName);

			add(backButton);
			add(nextButton);


			setSize(500,460);
			setLayout(null);
			setTitle("Personal Information");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setResizable(false);

			setVisible(true);

		}

// THIS SHIIIIIIIIT

		//nextButton listener
		private class nextButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent ev) {

						customerArray[current].setFirstName(fullName.getText());
						customerArray[current].setEmail(emailcon.getText());
						customerArray[current].setBirthDay(Integer.valueOf(dayBox.getSelectedItem().toString()));
						customerArray[current].setBirthMonth(monthBox.getSelectedIndex()-1);
						customerArray[current].setBirthYear(Integer.valueOf(yearBox.getSelectedItem().toString()));
						customerLabel.setText("Customer #"+current+1);
						current++;
						if (current == max){
						paymentWindow payWin = new paymentWindow();
						CustomerInfoWindow.this.setVisible(false);
					}
			}
		}



		// backButton listener
		private class backButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				FlightWindow flightWin = new FlightWindow();
				CustomerInfoWindow.this.setVisible(false);
				//exits when clicked
			}
		}


		// selecting dates (ie feb)
		private class monthBoxChange implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String selection = (String) monthBox.getSelectedItem();

				// Creating switch cases that changes the list for different months
				switch (selection){
					case "February":
						dayBox.removeAllItems(); // Clears the list when February is chosen
						for (int i = 0; i < birthDay.length - 3; i++) { // deletes three items from the list
							dayBox.addItem(birthDay[i]); // adds the new list that contains 28 days to the dayBox
						}
						break;

					case "April":
						dayBox.removeAllItems();
						for (int i = 0; i < birthDay.length -1; i++) {
							dayBox.addItem(birthDay[i]);
						}
						break;

					case "June":
						dayBox.removeAllItems();
						for (int i = 0; i < birthDay.length -1; i++) {
							dayBox.addItem(birthDay[i]);
					}
					break;

					case "September":
						dayBox.removeAllItems();
						for (int i = 0; i < birthDay.length -1; i++) {
							dayBox.addItem(birthDay[i]);
					}
					break;

					case "November":
						dayBox.removeAllItems();
						for (int i = 0; i < birthDay.length -1; i++) {
							dayBox.addItem(birthDay[i]);
					}
					break;

					default:
						System.out.println("Not Done yet");
						break;
				}

			}
		}


		// email pattern validation
		public class EmailValidator {
	    private Pattern pattern; // email pattern and what should contain
	    private Matcher matcher; // checks if the input matches the pattern
			// setting the right email pattern
	    private static final String EMAIL_PATTERN =
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	    public EmailValidator() {
	        pattern = Pattern.compile(EMAIL_PATTERN);
	    }
	    public boolean validate(final String hex) {
	        matcher = pattern.matcher(hex);
	        return matcher.matches();
	    }
		}
}
