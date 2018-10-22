package com.dmgmori;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTLS {
	private static final String MAIL_PROPERTIES = "mail.properties";
	
	private String username;
	private String password;
	private String smtpHost;
	private String smtpPort;
	private String fromMail;
	private String toMail;
	private String subject;
	private StringBuilder messageText = new StringBuilder();
	
	private boolean error = false;
	
	private Session session;
		
	public SendMailTLS() {
		loadProperties();
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "false");
		props.put("mail.smtp.starttls.enable", "false");
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", smtpPort);

		session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
	}

	public void send() {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromMail));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(toMail));
			message.setSubject(subject);
			message.setText(messageText.toString());

			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void loadProperties() {
		Properties properties = new Properties();

		try {
			BufferedInputStream stream = new BufferedInputStream(new FileInputStream("src/main/config/" + MAIL_PROPERTIES));
			properties.load(stream);
			
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			smtpHost = properties.getProperty("smtpHost");
			smtpPort = properties.getProperty("smtpPort");
			fromMail = properties.getProperty("fromMail");
			toMail = properties.getProperty("toMail");
			subject = properties.getProperty("subject");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void appendMessageText(String msg) {
		messageText.append(msg);
	}
	
	public String getMessageText() {
		return messageText.toString();
	}
	
	public void setErrorFlag(boolean bool) {
		error = bool;
	}
	
	public boolean getErrorFlag() {
		return error;
	}
}