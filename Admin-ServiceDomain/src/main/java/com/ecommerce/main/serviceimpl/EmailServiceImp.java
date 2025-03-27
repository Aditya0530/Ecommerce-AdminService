package com.ecommerce.main.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ecommerce.main.service.EmailService;
@Service
public class EmailServiceImp implements EmailService{

	@Value("${spring.mail.username}")private String FROM_MAIL;
	@Autowired private JavaMailSender sender;
	
	@Override
		public void sendSimpleMail(String to,String subject,String text) {
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setFrom(FROM_MAIL);
		mail.setTo(to);
		mail.setSubject(subject);
		mail.setText(text);
		sender.send(mail);
		
		}
		
	}


