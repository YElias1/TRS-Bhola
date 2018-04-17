import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Ticket {

	Customer customer; // Customer Object for pulling data from the Customer class.
	Flight flight; // Plane Object for pulling data from the Plane class.

	// Constructor method
	public Ticket(Customer customer, Flight flight) {
		this.customer = customer;
		this.flight = flight;
		
	}

	// Create the pdf file
	public void createPdf(String pdfName) {

		// Getter values from flight class
		Document document = new Document();
		String toAirCode = flight.getToAirCode();
		String fromAirCode = flight.getFromAirCode();
		int planeNumber = flight.getPlaneNumber();
		String boardingTime = flight.getBoardingTime();
		String departTime = flight.getDepartTime();
		String arrivalTime = flight.getArrivalTime();
		String departDate = flight.getDepartDate();
		String arrivalDate = flight.getArrivalDate();

		try {

			PdfWriter.getInstance(document, new FileOutputStream(pdfName));
			document.open();

			// Airtinery Logo
			Font font = FontFactory.getFont(FontFactory.COURIER_BOLD, 54, BaseColor.BLACK);
			Chunk c1 = new Chunk("Airtinery", font);
			c1.setBackground(BaseColor.BLUE);
			Paragraph p = new Paragraph(c1);
			document.add(p);

			// Flight Number
			Font font2 = FontFactory.getFont(FontFactory.COURIER_BOLD, 22, BaseColor.BLACK);
			Chunk c2 = new Chunk("\nFlight #" + planeNumber, font2);
			Paragraph p2 = new Paragraph(c2);
			document.add(p2);

			// Flight destination
			Font f3 = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.GRAY);
			Chunk c3 = new Chunk("Depart Date: " + departDate + "\n\nTo: " + toAirCode + "\t      From: " + fromAirCode + "\nBoarding Time: " + boardingTime, f3);
			Paragraph p3 = new Paragraph(c3);
			document.add(p3);

			// Flight times
			Font f4 = FontFactory.getFont(FontFactory.COURIER_BOLD, 22, BaseColor.BLACK);
			Chunk c4 = new Chunk("Depart Time: " + departTime, f4);
			//c4.setBackground(BaseColor.LIGHT_GRAY);
			Paragraph p4 = new Paragraph(c4);
			document.add(p4);
			

			document.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * The emailing method uses the javax.mail JAR file and the JavaMail API. You
	 * need to add this to the class's build path if you don't have it yet. The
	 * email is sent to the customer from our designated sending gmail account,
	 * BholaProject123@gmail.com. This emailing method currently email's an attached
	 * text file which is the ticket for the user.
	 */
	public void sendMail2() throws IOException { // with out para
		
		createPdf("Boarding_Pass1");
		String userEmail = customer.getEmail();
		String userFirst = customer.getFirstName();
		String userLast = customer.getLastName();

		final String username = "BholaProject123@gmail.com"; // The sender's email goes here.
		final String password = "airport12345";// The sender's password goes here.

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Name of sender's email
			message.setFrom(new InternetAddress(username));

			// Name of receiver's email
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));

			// Name of email subject
			message.setSubject("Airtinery");

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Now set the actual message
			messageBodyPart.setText("Hello " + userFirst + " " + userLast + "!"
					+ " Thank you for your purchase. You can see your ticket information in the attachment below.");

			// Create a multipar message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();

			// pdf attachment
			MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			String filename = "C:\\Users\\Noah\\eclipse-workspace\\Ticket_System\\Boarding_Pass.pdf";
			attachmentBodyPart.attachFile(new File(filename), "application/pdf", null);
			multipart.addBodyPart(attachmentBodyPart);

			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));

			// name of the attachment, in this case "Boarding Pass".
			messageBodyPart.setFileName("Boarding Pass");
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	/*public static void main(String args[]) throws IOException {

		// All these objects will be generated in Yoel's code. This is for testing purposes only
		
		// Customer setters for email information
		Customer user = new Customer();
		user.setEmail("");
		user.setFirstName("");
		user.setLastName("");

		// Flight setters for Ticket information
		Flight f = new Flight();
		f.setToAirCode("");
		f.setFromAirCode("");
		f.setPlaneNumber(0);
		f.setBoardingTime("");
		f.setDepartTime("");
		f.setArrivalTime("");
		f.setGate("");
		f.setDepartDate("");
		f.setArrivalDate("");
		f.setArrivalDate("");

		Ticket test = new Ticket(user, f);
		test.sendMail2();

	}*/
}
