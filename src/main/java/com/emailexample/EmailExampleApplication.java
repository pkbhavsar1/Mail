package com.emailexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class EmailExampleApplication {

	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(EmailExampleApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void triggerMail(){
//		senderService.SendSimpleEmail("pkbhavsar1@gmail.com", "HelloWorld", "Hello");
//	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		senderService.sendEmailWithAttachment("pkbhavsar1@gmail.com","Hello World", "Hello", "C:\\Users\\pkbha\\Desktop\\PP Doc\\ALL.pdf");
		System.out.println("Mail Sent");
	}
}
