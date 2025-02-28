package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {


	public static ExtentReports getReport() 
	{
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	     reporter.config().setReportName("Web Automation Testing");
	     reporter.config().setDocumentTitle("Test results");
          
	     ExtentReports extent = new ExtentReports();
	   //attaching the spark class with main class
	     extent.attachReporter(reporter); 
	     extent.setSystemInfo("Tester", "Lalit Singh");
		return extent;
	     
	}
}
