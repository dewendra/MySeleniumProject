package com.procam.utils;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailUtils {
	public static void sendTestReport(String reportPath) {
		final String senderEmail = "selenium4demo@gmail.com";
		final String appPassword = "xtuxlpvphskribiq";
		final String receipentEmail = "selenium4demo@gmail.com";
		// SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port", "587");

		// Create a session with authentication
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, appPassword);
			}
		});
		session.setDebug(true);

		try {
			// Create email message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receipentEmail));
			message.setSubject("Test email from Java with attachment");
			// message.setText("Hello,\n\n This is a test email from java \n\n Regards\n QA
			// Team");

			// Email body part
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText("Hello,\n\n This is a test email from java \n\n Regards\n QA Team");

			// Attachment part
			MimeBodyPart attachmentPart = new MimeBodyPart();
			//String filePath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
			System.out.println("Attachment file path is: " + reportPath);
			attachmentPart.attachFile(new File(reportPath));

			// Combine the email body and attachment part
			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(textPart);
			multipart.addBodyPart(attachmentPart);
			message.setContent(multipart);

			// send email
			Transport.send(message);
			System.out.println("Email sent successfully..");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
