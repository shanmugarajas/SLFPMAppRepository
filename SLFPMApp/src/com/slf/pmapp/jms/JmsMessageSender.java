package com.slf.pmapp.jms;

import java.util.Map;
import org.springframework.jms.core.JmsTemplate;

public class JmsMessageSender {

private final JmsTemplate jmsTemplate;

public JmsMessageSender(final JmsTemplate jmsTemplate) {

this.jmsTemplate = jmsTemplate;

}

public void send(final Map map) {

System.out.println("JMS sending the message");	
jmsTemplate.convertAndSend(map);

}
}