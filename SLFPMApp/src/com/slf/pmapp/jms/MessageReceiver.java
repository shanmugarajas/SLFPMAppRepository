package com.slf.pmapp.jms;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
 
public class MessageReceiver implements MessageListener {
 
public void onMessage(final Message message) {
if (message instanceof MapMessage) {

final MapMessage mapMessage = (MapMessage) message;
// do something

}

}

}