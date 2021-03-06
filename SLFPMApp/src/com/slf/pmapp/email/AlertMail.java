package com.slf.pmapp.email;

import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AlertMail {
	private JavaMailSender mailsender;
    //setter getters
	
	public JavaMailSender getMailsender(){
		return mailsender;
	}
	
	public void setMailsender(JavaMailSender mailsender){
		this.mailsender = mailsender;
	}
	
    public MimeMessage getMailMessage(String id, Date date) throws MessagingException {
    	final MimeMessage mimeMessage = this.mailsender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false);
        helper.setFrom("venkatesan.rajagopal@gmail.com");
        helper.setTo("venkatesan.rajagopal@ebix.com");
        helper.setTo("venkatesan.rajagopal@gmail.com");
        helper.setCc("venkatesan.rajagopal@gmail.com");
        helper.setSubject("Request raised in iPM for your attention");

        ApplicationContext xmlBeanFactory = new ClassPathXmlApplicationContext("classpath*:/applicationContext.xml");
		
		TemplateEmailer templateEmailer = (TemplateEmailer) xmlBeanFactory.getBean("templateEmailer");
	    final Map<String, Object> paramMap = new HashMap<String, Object>();
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		String userRole = userDetails.getUsername().trim();
		String newline = "\n";
		
	    paramMap.put("user", userRole);
	    paramMap.put("requestid", id);
	    paramMap.put("requestdate", date);
	    paramMap.put("newline", newline);
	    
	    System.out.println(templateEmailer.getMessage("requestAlertTemplate.vm", paramMap));
	    mimeMessage.setText(templateEmailer.getMessage("requestAlertTemplate.vm", paramMap));
	    
	    return mimeMessage;
    }
    
    public void sendMail(String id, Date date) throws MailException, MessagingException {
    	        mailsender.send(getMailMessage(id, date));
    }
}
