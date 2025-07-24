package Generic_methods;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GenericKeywords {
	

	Logger log=LogManager.getLogger(GenericKeywords.class.getName());
	public void clickElement(WebElement element) {
		log.debug("clickElement method of GenericKeywords");
		element.click();
	}
	public boolean isDisplayed(WebElement element) {
		
		log.debug("isDisplayed method of GenericKeywords");
		return element.isDisplayed(); 
	}
	public boolean isEnabled(WebElement element) {
		log.debug("isDisplayed method of GenericKeywords");

		return element.isEnabled();
	}

	
	public void enterText(WebElement element, String text) {
		log.debug("enterText method of GenericKeywords");
	    element.clear();
	    element.sendKeys(text);
	}

	public String getText(WebElement element) {
		log.debug("getText method of GenericKeywords");
	    return element.getText();
	
	}


	public void selectByVisibleText(WebElement dropdown, String text) {
		log.debug("selectByVisibleText method of GenericKeywords");
	    Select select=new Select(dropdown);
	    		select.selectByVisibleText(text);
	}

	
	public void selectByIndex(WebElement dropdown, int index) {
		log.debug("selectByIndex method of GenericKeywords");
		Select select= new Select(dropdown);
		select.selectByIndex(index);
	}

	
	public void switchToWindowByTitle(WebDriver driver, String title) {
		log.debug("switchToWindowByTitle method of GenericKeywords");
	    for (String handle : driver.getWindowHandles()) {
	        driver.switchTo().window(handle);
	        if (driver.getTitle().equals(title)) {
	            break;
	        }
	    }
	}
	public String dateformat()
	{
		log.debug("dateformat method of GenericKeywords");
		Date date=new Date();
		SimpleDateFormat specificdate=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		return specificdate.format(date);
	}
	public void explicitWait(WebDriver driver, WebElement element, long timeoutInSeconds) {
		log.debug("explicitWait method of GenericKeywords");
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	public void implicitwait(WebDriver driver,long timeoutInSeconds) {
		log.debug("implicitwait method of GenericKeywords");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSeconds));
	}
	public void fluentWaits(WebDriver driver,long timeoutInSeconds,WebElement element,long pollingtime) {
		log.debug("fluentWaits method of GenericKeywords");
		new FluentWait<>(driver)
         .withTimeout(Duration.ofSeconds(timeoutInSeconds))
         .pollingEvery(Duration.ofSeconds(pollingtime))
         .ignoring(Exception.class)
         .until(ExpectedConditions.visibilityOf(element));
	}
	
	
	}
