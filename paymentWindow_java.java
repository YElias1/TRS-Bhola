import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JPanel.*;
import javax.swing.JTextField.*;
import javax.swing.JPasswordField.*;
import java.awt.event.*;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;


public class paymentWindow extends JFrame {

	String[] exMonth = {
		"Month",
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
		"12"
	};

	String[] exYear = {
		"Year",
		"2030",
		"2029",
		"2028",
		"2027",
		"2026",
		"2025",
		"2024",
		"2023",
		"2022",
		"2021",
		"2020",
		"2019",
		"2018"
	};

	String[] Country = {
		"Afghanistan",
		"Albania",
		"Algeria",
		"Andorra",
		"Angola",
		"Anguilla",
		"Antigua",
		"Argentina",
		"Armenia",
		"Aruba",
		"Australia",
		"Austria",
		"Azerbaijan",
		"Bahamas",
		"Bahrain",
		"Bangladesh",
		"Barbados",
		"Belarus",
		"Belgium",
		"Belize",
		"Benin",
		"Bermuda",
		"Bhutan",
		"Bolivia",
		"Bosnia And Herzegovina",
		"Botswana",
		"Brazil",
		"British Virgin Islands",
		"Brunel",
		"Bulgaria",
		"Burkina Faso",
		"Burundi",
		"Cambodia",
		"Cameroon",
		"Canada",
		"Cape Verde",
		"Cayman Islands",
		"Central African Republic",
		"Chad",
		"Chile",
		"China",
		"Colombia",
		"Comoros",
		"Congo",
		"Costa Rica",
		"Croatia",
		"Cyprus",
		"Czech Republic",
		"Denmark",
		"Djibouti",
		"Dominica",
		"Dominican Republic",
		"Ecuador",
		"Egypt",
		"El Salvador",
		"Eritrea",
		"Estonia",
		"Ethipia",
		"Fiji",
		"Finland",
		"France",
		"Gabon",
		"Gambia",
		"Georgia",
		"Germany",
		"Ghana",
		"Gibraltar",
		"Greece",
		"Greenland",
		"Grenada",
		"Guadeloupe",
		"Guatemala",
		"Guinea",
		"Guyana",
		"Haiti",
		"Honduras",
		"Hungary",
		"Iceland",
		"India",
		"Indonesia",
		"Iraq",
		"Ireland",
		"Israel",
		"Italy",
		"Ivory Coast",
		"Jamaica",
		"Japan",
		"Jordan",
		"Kazakhstan",
		"Kenya",
		"Kuwait",
		"Kyrgyzstan",
		"Loas",
		"Latvia",
		"Lebanon",
		"Liberia",
		"Libya",
		"Liechtenstien",
		"Lithuania",
		"Macau",
		"Macedonia",
		"Madagascar",
		"Malawi",
		"Malaysia",
		"Maldives",
		"Mali",
		"Malta",
		"Martinique",
		"Mauritania",
		"Mauritius",
		"Mayotte",
		"Mexico",
		"Moldova",
		"Monaco",
		"Mongolia",
		"Montenegro",
		"Morocco",
		"Mozambique",
		"Maynmar",
		"Nambia",
		"Nauru",
		"Nepal",
		"Netherlands",
		"New Caledonia",
		"New Zealand",
		"Nicaragua",
		"Niger",
		"Nigeria",
		"Niue",
		"Norway",
		"Oman",
		"Pakistan",
		"Panama",
		"Paraguay",
		"Peru",
		"Philippines",
		"Poland",
		"Portugal",
		"Qatar",
		"Romania",
		"Russia",
		"Rwanda",
		"Saint Lucia",
		"Samao",
		"San Marino",
		"Saudi Arabia",
		"Senegal",
		"Serbia",
		"Slovakia",
		"Slovenia",
		"Somalia",
		"South Africa",
		"South Korea",
		"Spain",
		"Sweden",
		"Switzerland",
		"Syria",
		"Taiwan",
		"Tajikstan",
		"Tanzania",
		"Thailand",
		"Togo",
		"Tonga",
		"Trinidad and Tobago",
		"Tunisia",
		"Turkey",
		"Turkmenistan",
		"Uganda",
		"Ukraine",
		"United Arab Emirates",
		"United Kingdom",
		"United States",
		"Uruguay",
		"Uzbekistan",
		"Vanuatu",
		"Venezuela",
		"Vietnam",
		"Yemen",
		"Zambia",
		"Zimbabwe"
	};

	String[] states = {
		"Alabama",
		"Alaska",
		"Arizona",
		"Arkansas",
		"California",
		"Colorado",
		"Connecticut",
		"Delaware",
		"Florida",
		"Georgia",
		"Hawaii",
		"Idaho",
		"Illinois",
		"Indiana",
		"Iowa",
		"Kansas",
		"Kentucky",
		"Louisana",
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


		String[] cardType = {
			"Visa", //VI
			"Master Card", //MC
			"American Express", //AE
			"Discover",	//DI
		};

	private JButton backButton;
	private JButton nextButton;

	private JRadioButton visaButton;
	private JRadioButton mcButton;
	private JRadioButton amexButton;
	private JRadioButton discoverButton;
	private JRadioButton otherButton;
	private ButtonGroup cardGroup;

	private JLabel titleLabel;
	private JLabel star;

	private JLabel nameOnCardLabel;
	private JLabel cardNumLabel;
	private JLabel exDateLabel;
	private JLabel securityLabel;
	private JLabel cardTypeLabel;

	private JComboBox<String> stateBox;

	private JLabel billingHeadLabel;
	private JLabel countryLabel;
	private JLabel addLabel;
	private JLabel cityLabel;
	private JLabel stateLabel;
	private JLabel zipLabel;

	private JComboBox<String> monthBox;
	private JComboBox<String> yearBox;

	private JTextField nameOnCard;
	private JTextField cardNumber;
	private JTextField securityCode;
	private JTextField add1;
	private JTextField add2;
	private JTextField city;
	private JTextField other;
	private JTextField zip;

	private Customer[] customerArray;
	private Flight[] flightArray;

	public paymentWindow(Customer[] customerArray, Flight[] flightArray) {

		this.customerArray = customerArray;
		this.flightArray = flightArray;

		titleLabel = new JLabel("Payment Information");
		titleLabel.setBounds(185, 10, 150, 50);
		add(titleLabel);

		star = new JLabel("Fields with (*) are required");
		star.setBounds(165, 30, 200, 50);
		add(star);


		backButton = new JButton("Back");
		backButton.setBounds(50, 520, 100, 25);
		add(backButton);

		nextButton = new JButton("Next");
		nextButton.setBounds(350, 520, 100, 25);
		add(nextButton);



		nameOnCardLabel = new JLabel("Name as appears on the card:*");
		nameOnCardLabel.setBounds(50, 100, 210, 20);
		add(nameOnCardLabel);

		nameOnCard = new JTextField(50);
		nameOnCard.setBounds(50, 125, 195, 20);
		add(nameOnCard);

		nameOnCard.addKeyListener(new KeyAdapter() {
						public void keyTyped(KeyEvent ev) {
							char cardName = ev.getKeyChar();

								if (nameOnCard.getText().length() == 50) {
										ev.consume();
								}
								if (!Character.isLetter(cardName)) {
									ev.consume();
									nameOnCardLabel.setForeground(Color.RED);
								}
								if (Character.isLetter(cardName)) {
									nameOnCardLabel.setForeground(Color.BLACK);
								}
							}
						});


		cardNumLabel = new JLabel("Card number:*");
		cardNumLabel.setBounds(270, 100, 210, 20);
		add(cardNumLabel);

		cardNumber = new JTextField(50);
		cardNumber.setBounds(270, 125, 195, 20);
		add(cardNumber);

		cardNumber.addKeyListener(new KeyAdapter() {
						public void keyTyped(KeyEvent ev) {
							char num = ev.getKeyChar();

								if (cardNumber.getText().length() == 16) {
										ev.consume();
								}
								if (!Character.isDigit(num)) {
									ev.consume();
									cardNumLabel.setForeground(Color.RED);
								}
								if (Character.isDigit(num)) {
									cardNumLabel.setForeground(Color.BLACK);
								}
						}
				});



		exDateLabel = new JLabel("Expiration Date:*");
		exDateLabel.setBounds(50, 160, 125, 20);
		add(exDateLabel);

		monthBox = new JComboBox<String> (exMonth);
		monthBox.setBounds(165,145,100,50);
		monthBox.setEditable(false);
		add(monthBox);

		yearBox = new JComboBox<String> (exYear);
		yearBox.setBounds(270,145,100,50);
		yearBox.setEditable(false);
		add(yearBox);



		cardTypeLabel = new JLabel("Choose card type:*");
		cardTypeLabel.setBounds(50, 190, 130, 25);
		add(cardTypeLabel);

		visaButton = new JRadioButton("Visa");
		visaButton.setBounds(50, 225, 100, 25);
		add(visaButton);

		mcButton = new JRadioButton("Master Card");
		mcButton.setBounds(140, 225, 130, 25);
		add(mcButton);

		amexButton = new JRadioButton("American Express");
		amexButton.setBounds(140, 255, 155, 25);
		add(amexButton);

		discoverButton = new JRadioButton("Discover");
		discoverButton.setBounds(50, 255, 100, 25);
		add(discoverButton);

		otherButton = new JRadioButton("Other");
		otherButton.setBounds(50, 285, 100, 25);
		add(otherButton);

		other = new JTextField(50);
		other.setBounds(120, 288, 130, 20);
		other.setVisible(false);
		add(other);

		otherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {

				if (otherButton.isSelected()) {
					other.setVisible(true);
				}
				if (visaButton.isSelected() || mcButton.isSelected() || amexButton.isSelected() || discoverButton.isSelected()) {
					other.setVisible(false);
				}
			}
		});

		cardGroup = new ButtonGroup();
		cardGroup.add(visaButton);
		cardGroup.add(mcButton);
		cardGroup.add(amexButton);
		cardGroup.add(discoverButton);
		cardGroup.add(otherButton);


		 securityLabel = new JLabel("Security Code:*");
		 securityLabel.setBounds(50, 320, 110, 20);
		 add(securityLabel);

		securityCode = new JPasswordField(5);
		securityCode.setBounds(149, 320, 75, 20);
		add(securityCode);

		// Limit the text field characters
		securityCode.addKeyListener(new KeyAdapter() {
						public void keyTyped(KeyEvent ev) {
							char sc = ev.getKeyChar();

								if (securityCode.getText().length() == 4) {
										ev.consume();
								}
								if (!Character.isDigit(sc)) {
									ev.consume();
									securityLabel.setForeground(Color.RED);
								}
								if (Character.isDigit(sc)) {
									securityLabel.setForeground(Color.BLACK);
								}
						}
				});


		billingHeadLabel = new JLabel("Billing Information");
		billingHeadLabel.setBounds(185, 350, 150, 50);
		add(billingHeadLabel);

		addLabel = new JLabel("Address:*");
		addLabel.setBounds(50, 385, 130, 25);
		add(addLabel);

		add1 = new JTextField(30);
		add1.setBounds(50, 410, 150, 20);
		add(add1);

		add2 = new JTextField(30);
		add2.setBounds(196, 410, 150, 20);
		add(add2);

		cityLabel = new JLabel("City:*");
		cityLabel.setBounds(50, 435, 75, 20);
		add(cityLabel);

		city = new JTextField(20);
		city.setBounds(50, 458, 75, 20);
		add(city);

		stateLabel = new JLabel("State:*");
		stateLabel.setBounds(140, 435, 75, 20);
		add(stateLabel);

		stateBox = new JComboBox<String> (states);
		stateBox.setBounds(140, 458, 150, 20);
		add(stateBox);

		zipLabel = new JLabel("Zip Code:*");
		zipLabel.setBounds(310, 435, 100, 20);
		add(zipLabel);

		zip = new JTextField(5);
		zip.setBounds(310, 458, 75, 20);
		add(zip);
		// limits the input
		zip.addKeyListener(new KeyAdapter() {
						public void keyTyped(KeyEvent ev) {
							char zipcode = ev.getKeyChar();

								if (zip.getText().length() == 5) {
										ev.consume();
								}
								if (!Character.isDigit(zipcode)) {
									ev.consume();
									zipLabel.setForeground(Color.RED);
								}
								if (Character.isDigit(zipcode)) {
									zipLabel.setForeground(Color.BLACK);
								}
						}
				});


		backButtonListener backButtonL = new backButtonListener();
		backButton.addActionListener(backButtonL);

		nextButtonListener nextButtonL = new nextButtonListener();
		nextButton.addActionListener(nextButtonL);


		setSize(500,600);
		setLayout(null);
		setTitle("Payment Information");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		setVisible(true);

	}

	//backButton listener
	private class backButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			CustomerInfoWindow cusWin = new CustomerInfoWindow();
			paymentWindow.this.setVisible(false);
			//opens paymentWindow when clicked
		}
	}
	//nextButtonListener
	private class nextButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			String cardN = cardNumber.getText();
			String Cardtype;
			if (visaButton.isSelected()){
				Cardtype = "VI";
			}
			if (mcButton.isSelected()){
				Cardtype = "MC";
			}
			if (amexButton.isSelected()){
				Cardtype = "AE";
			}
			if (discoverButton.isSelected()){
				Cardtype = "DI";
			}
			Card_Real test = new Card_Real();
			test.Cardnum(cardN, Cardtype);
			if (test.RealN && test.Real){
				Ticket y = new (customerArray[0], flightArray[0]);
				y.createPdf();
				y.sendMail2();
				if (flightArray.length == 2){
					Ticket x = new (customerArray[0], flightArray[1]);
					x.createPdf();
					x.sendMail2();
				}
			}

			System.exit(0);
			//exits when clicked
		}
	}

}
