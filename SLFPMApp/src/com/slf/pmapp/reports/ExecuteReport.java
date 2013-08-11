package com.slf.pmapp.reports;

import java.io.IOException;

import org.drools.io.ResourceFactory;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.eclipse.birt.report.model.elements.olap.Level;


public class ExecuteReport {
	
public void executeReport() throws EngineException
{

IReportEngine engine=null;
EngineConfig config = null;

try{
	config = new EngineConfig( );			
	config.setBIRTHome("D:\\Birt\\birt-runtime-4_3_0\\ReportEngine");
	//config.setLogConfig("\\", java.util.logging.Level.FINEST);
	Platform.startup( config );
	IReportEngineFactory factory = (IReportEngineFactory) Platform.createFactoryObject( IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY );
	engine = factory.createReportEngine( config );		

	IReportRunnable design = null;
	//Open the report design
	design = engine.openReportDesign("\\sunlifetracks.rptdesign"); 
	IRunAndRenderTask task = engine.createRunAndRenderTask(design); 		
	task.setParameterValue("ordParam", (new Integer(10101)));
	task.validateParameters();
			
	HTMLRenderOption options = new HTMLRenderOption();		
	options.setOutputFileName("\\report.html");
	options.setOutputFormat("html");
	options.setEmbeddable(true);
	options.setHtmlRtLFlag(false);	
	//options.setImageDirectory("\\");

//	PDFRenderOption options = new PDFRenderOption();
//	options.setOutputFileName("test.pdf");
//	options.setOutputFormat("pdf");

	task.setRenderOption(options);
	task.run();
	task.close();
	engine.destroy();
	//Program.launch("\\report.html");
	try {
		Process p =
		Runtime.getRuntime().exec("RunDLL32.EXE shell32.dll,ShellExec_RunDLL "	+ "D:\\report.html");
		}
		catch( IOException e ){
		}


}catch( Exception ex){
	ex.printStackTrace();
}		
finally
{
       Platform.shutdown( );
}

}}