package com.pop.controller;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pop.model.MailVO;

@Controller
public class MailController {
	@Autowired
	private	JavaMailSender mailSender;
	
	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@RequestMapping(value="mail",method=RequestMethod.GET)
	public void mailSendingGet() {
		logger.info("mail.jsp 실행.");
	}
	
	@RequestMapping(value="mail",method=RequestMethod.POST)
	public void mailSending(MailVO mail) {
		logger.info("tomail"+mail.getTomail());
		logger.info("title"+mail.getTitle());
		logger.info("content"+mail.getContent());
		logger.info("from"+mail.getFrom());
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
			
			messageHelper.setFrom(mail.getFrom());
			messageHelper.setTo(mail.getTomail());
			messageHelper.setSubject(mail.getTitle());
			messageHelper.setText(mail.getContent());
			
			mailSender.send(message);	// 최종적으로 메세지를 보낸다.
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	// mailSending
}	//MailController
