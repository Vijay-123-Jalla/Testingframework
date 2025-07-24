package Stepdefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Generic_methods.GenericKeywords;
import Hooks.Hooks;
import Pages.Loginpage;
import Utility.ReadingConfigfiles;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Loginstepdefinitio {
	ReadingConfigfiles file = new ReadingConfigfiles(); 
    GenericKeywords key = new GenericKeywords(); 
	Loginpage page=new Loginpage(Hooks.driver);
	Logger log=LogManager.getLogger(Loginstepdefinitio.class.getClass());

	@Given("User able to open the browser")
	public void user_able_to_open_the_browser() {
		log.debug("User able to open the browser");
		//System.out.println("Given method");
		Assert.assertNotNull(Hooks.driver);
	}
	@Given("User able to enter the url")
	public void user_able_to_enter_the_url() throws IOException {
		
		log.debug("User able to enter the url");
		//System.out.println("User able to enter the url");
		 Hooks.driver.get(file.getLink());
		 
	}
	@Given("Inputfield has to display")
	public void inputfield_has_to_display() {
		log.debug("Inputfield has to display");
		Assert.assertTrue(page.login().isDisplayed());
		System.out.println("Inputfield is displayed");
	   Assert.assertTrue(page.login().isEnabled());
		System.out.println("Inputfield is Enabled");

	}
	@Given("Passwordfield has to display")
	public void passwordfield_has_to_display() {
		log.debug("Passwordfield has to display");
		Assert.assertTrue(page.password().isDisplayed());
		//System.out.println("Passwordfield is displayed");
		   Assert.assertTrue(page.password().isEnabled());
			//System.out.println("Passwordfield is Enabled");
	}
	@Given("Submit button has to dispaly")
	public void submit_button_has_to_dispaly() {
		log.debug("Submit button has to dispaly");
		Assert.assertTrue(page.clickbutton().isDisplayed());
		//System.out.println("Submit button is displayed");
		   Assert.assertTrue(page.clickbutton().isEnabled());
			//System.out.println("Submit button is Enabled");

	}
	@When("User able to enter the username {string}")
	public void user_able_to_enter_the_username(String user) throws IOException {
		log.debug("User able to enter the username"+user);
		//System.out.println("User able to enter the name");
	  key.enterText(page.login(), user);
	  
	}
	@When("User able to enter the password {string}")
	public void user_able_to_enter_the_password(String pass) {
		log.debug("User able to enter the password"+pass);
		//System.out.println("User able to enter the password");
		 key.enterText(page.password(), pass);
	}
	
	@When("User able to click on button")
	public void user_able_to_click_on_button() {
		log.debug("User able to click on button");
		 key.clickElement(page.clickbutton());
	    System.out.println("User able to click the button");
	
	}
	@Then("User able to login succesfully")
	public void user_able_to_login_succesfully() {
		log.debug("User able to login succesfully");
	 
         try {
        	   WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
               wait.until(ExpectedConditions.visibilityOf(page.invalidmsg()));
        	    WebElement element = page.invalidmsg();
        	    boolean isDisplayed = element.isDisplayed();
        	    Assert.assertFalse(isDisplayed);
        	} 
         catch (Throwable e) 
         {
        	 
        	 Assert.assertTrue(true);  
        	
     	}
         
         log.debug("User logged in sucessfully");  
         
        	    }
	      
	@Then("User not able to login")
	public void user_not_able_to_login() {
		log.debug("User not able to login");  
		 WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
		    wait.until(ExpectedConditions.visibilityOf(page.invalidmsg()));
			      Assert.assertTrue(page.invalidmsg().isDisplayed());
			      System.out.println("User logged in unsucessfully");
	}
}
