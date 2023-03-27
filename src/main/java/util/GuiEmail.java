package util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.mail.Authenticator;
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

public class GuiEmail {
	
	public static void GuiMail(String to, String tieude, String noidung) {
		final String from = "dothanhcong1932002@gmail.com";
		final String pass = "flrvpsuddoqzubej";
		

		Properties propsProperties = new Properties();
		propsProperties.put("mail.smtp.host", "smtp.gmail.com");
		propsProperties.put("mail.smtp.port", "587");
		propsProperties.put("mail.smtp.auth", "true");
		propsProperties.put("mail.smtp.starttls.enable", "true");

		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, pass);
			}
		};

		try {
			Session session = Session.getInstance(propsProperties, auth);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(tieude);
			message.setContent(noidung, "text/html");
			// Đính kèm tệp tin
//			MimeBodyPart mimeBodyPart = new MimeBodyPart();
//			mimeBodyPart.attachFile(new File("path/to/attachment"));

			// Tạo đối tượng MimeMultipart
			MimeMultipart mimeMultipart = new MimeMultipart();
//			mimeMultipart.addBodyPart(mimeBodyPart);

			// Thêm nội dung email
			MimeBodyPart textBodyPart = new MimeBodyPart();

			mimeMultipart.addBodyPart(textBodyPart);

			// Đặt nội dung email vào message
//			message.setContent(mimeMultipart);
			
			// Gửi email
			Transport.send(message);
		} catch (MessagingException e) {
			System.out.println(1);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(2);
			e.printStackTrace();
		}
	}
}
