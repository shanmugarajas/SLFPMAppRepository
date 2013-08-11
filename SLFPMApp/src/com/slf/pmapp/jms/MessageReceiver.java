package com.slf.pmapp.jms;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.eclipse.birt.report.engine.api.EngineException;

import com.slf.pmapp.reports.ExecuteReport;
 
public class MessageReceiver implements MessageListener {
	
	private ExecuteReport reportExec = new ExecuteReport();
 
public void onMessage(final Message message) {
if (message instanceof MapMessage) {

final MapMessage mapMessage = (MapMessage) message;
// do something
System.out.println("Received the message to report");

try {
	reportExec.executeReport();
} catch (EngineException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

System.out.println("Report generation is completed");
}

}

}