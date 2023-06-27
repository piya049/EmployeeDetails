package com.ps;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.ps.email.EmailSenderService;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class EmployeeDetailsApplication {

	@Autowired
	private EmailSenderService service;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeDetailsApplication.class, args);	
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws IOException, MessagingException {
//		service.sendSimpleEmail("hsdhsh@hotmail.com", 
//				"Hi Pavan, this is body for normal email", 
//				"Subject");
		
		
		service.sendEmailWithAttachment("shendepiyush049@gmail.com", 
				"Hi Piyush, Hope you are doing good, this is email regarding the excel file generation...", "Regarding new API", 
				"C:\\Piyush\\employees.xlsx");

	}
		
}
