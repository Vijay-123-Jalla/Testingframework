package Hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Generic_methods.GenericKeywords;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseTest  {
	public static ExtentSparkReporter htmlReporter;
	public static  ExtentReports extent;
	public static ExtentTest extentLoggerECP;
	public static ExtentTest parentExtentLogger;
	
	GenericKeywords key = new GenericKeywords();
	public ExtentTest childExtentLogger;
    Logger log=LogManager.getLogger(BaseTest.class.getName());
@BeforeSuite
public void setupReports() 
{
	
	log.debug("setupReports method");
	String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" + key.dateformat() + ".html";
	htmlReporter = new ExtentSparkReporter(reportPath);
	htmlReporter.config().setReportName("Automation Test Results");
	htmlReporter.config().setDocumentTitle("Extent Report");
     extent = new ExtentReports();
     extent.attachReporter(htmlReporter);
     extent.setSystemInfo("QA Engineer", "Vijay");
     extent.setSystemInfo("Environment", "QA");
	}
 


@AfterSuite
public void endReports() 
{
	log.debug("endReports method");
    extent.flush();	


}  


	
	
	
	
}
