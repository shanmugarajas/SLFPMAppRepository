package com.slf.pmapp.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class AlertMail {
	private JavaMailSender mailsender;
    //setter getters
	
	public JavaMailSender getMailsender(){
		return mailsender;
	}
	
	public void setMailsender(JavaMailSender mailsender){
		this.mailsender = mailsender;
	}
	
    public MimeMessage getMailMessage() throws MessagingException {
        final MimeMessage mimeMessage = this.mailsender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false);
        helper.setFrom("iPM-RequestAlert@gmail.com");
        helper.setTo("venkatesan.rajagopal@ebix.com");
        helper.setCc("venkatesan.rajagopal@gmail.com");
        helper.setSubject("Request raised in iPM for your attention");
        helper.setText("A request has been raised in iPM. It could either be assigned to you or could be a notification." +
        		"Please login to your iPM account and check. Thank you." +
        		"This is a system generated email, please don't reply to this.",true);
        return mimeMessage;
    }
    
    public void sendMail() throws MailException, MessagingException {
        mailsender.send(getMailMessage());
    }
}
