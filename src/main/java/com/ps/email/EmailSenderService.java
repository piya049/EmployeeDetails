package com.ps.email;


import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendSimpleEmail(String toEmail, String body, String subject) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("piyushshende1996@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		System.out.println("<<<<<.............Email is sent to respected email address...>>>>");
	}
public void sendEmailWithAttachment(String toEmail, 
		String body, String subject, String attachment) throws MessagingException{
	
	//mimsghelper is used to add any attachment to it:
	
    MimeMessage mimemessage = mailSender.createMimeMessage();
	
	MimeMessageHelper helper = new MimeMessageHelper(mimemessage, true);
	helper.setFrom("piyushshende1996@gmail.com");
	helper.setTo(toEmail);
	helper.setText(body);
	helper.setSubject(subject);
	
	FileSystemResource resource =new FileSystemResource(new File(attachment));
	
	helper.addAttachment(resource.getFilename(), resource);
	
	mailSender.send(mimemessage);
	System.out.println("Mail sent to>>...."+toEmail);
	
}
}
