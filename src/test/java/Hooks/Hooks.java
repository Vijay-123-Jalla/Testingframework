package Hooks;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Generic_methods.Base;
import Generic_methods.GenericKeywords;
import Utility.ReadingConfigfiles;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;


public class Hooks  extends BaseTest{
	public static WebDriver driver;
	public ReadingConfigfiles file=new ReadingConfigfiles();
	public Base key=new Base();
	public GenericKeywords generic=new GenericKeywords();
	BaseTest test=new BaseTest();
	Logger log=LogManager.getLogger(Hooks.class.getName());
@Before
public void beforeScenario() throws IOException 
{
	log.debug("Before Scenario");
	driver=key.browserLaunch(file.getBrowsername());
	BaseTest.htmlReporter.config().setDocumentTitle("Searching functinalFlow"); 
	BaseTest.htmlReporter.config().setReportName("Automation Report ");
	BaseTest.htmlReporter.config().setTheme(Theme.STANDARD);
	BaseTest.parentExtentLogger = BaseTest.extent.createTest(this.getClass().getSimpleName());
	
	}
@BeforeStep
public void beforeStep(Scenario scenario)
{
	log.debug("beforeStep is invoked");
	 System.out.println("Running before step: " + scenario.getName());
}
@AfterStep()
public void AfterStep(Scenario scenario) throws IOException
{
	log.debug("Afterstep is invoked");
	  if (scenario.isFailed()) {
		   
		   TakesScreenshot tShot=(TakesScreenshot) driver;
		   File source=tShot.getScreenshotAs(OutputType.FILE);
		   String screenshotPath = "screenshots/" + generic.dateformat() + ".png";
		   File target = new File(System.getProperty("user.dir") + "/" + screenshotPath);
		    FileUtils.copyFile(source, target);
		    test.childExtentLogger = test.parentExtentLogger.createNode(scenario.getName());
			test.childExtentLogger.log(Status.FAIL,MarkupHelper.createLabel(" - Test Case failed", ExtentColor.RED));
			test.childExtentLogger.fail("",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	  }

	  }
	
//@After
//public void afterscenario() {
//log.debug("After Scenario invoked");
//	  driver.close();
//}

//public void implicitwait(long second)
//{
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
//}
//public void Explicitwait(long second,WebElement element)
//{
//	
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
//	 wait.until(ExpectedConditions.visibilityOf(element));
//
//}
}



