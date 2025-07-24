package Stepdefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import Generic_methods.Base;
import Generic_methods.GenericKeywords;
import Hooks.Hooks;
import Pages.PasswordResetpage;
import Utility.ReadingConfigfiles;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResetStepdefinition 
{
	PasswordResetpage page=new PasswordResetpage(Hooks.driver);
	GenericKeywords key=new GenericKeywords();
	Base base=new Base();
	ReadingConfigfiles file = new ReadingConfigfiles();
	Logger log=LogManager.getLogger(ResetStepdefinition.class.getName());	
	@Given("User is able to open the browser")
	public void user_is_able_to_open_the_browser() {
	    
		log.debug("User is able to open the browser");
		//System.out.println("Given method");
		Assert.assertNotNull(Hooks.driver);
	}
	@Given("User is able to enter the URL")
	public void user_is_able_to_enter_the_url() throws IOException {
		log.debug("Orangehrm gotlaunched");
		Hooks.driver.get(file.getLink());
	    //System.out.println("Orangehrm gotlaunched");
	}
	@Given("Forgotten link should be displayed")
	public void forgotten_link_should_be_displayed() {
		log.debug("link isDisplayed");
		Assert.assertTrue(key.isDisplayed(page.forgottenlink()));
//		System.out.println(key.isDisplayed(page.forgottenlink()));
	   System.out.println("link isDisplayed"+key.isDisplayed(page.forgottenlink()));
	}
	@Given("Forgotten link should be enabled")
	public void forgotten_link_should_be_enabled() {
		
		log.debug("Forgotten link should be enabled");
		 Assert.assertTrue(key.isEnabled(page.forgottenlink()));
		   System.out.println("link is enabled"+key.isEnabled(page.forgottenlink()));
	}
	@When("User clicks on the forgotten link")
	public void user_clicks_on_the_forgotten_link() {
		log.debug("User clicks on the forgotten link");
		key.clickElement(page.forgottenlink());
		System.out.println("User able to click on link");
//		  JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
//		    js.executeScript("arguments[0].click();", page.forgottenlink());
	}
	@Then("Input field should be displayed")
	public void input_field_should_be_displayed() {
		log.debug("Input field should be displayed");
	//	System.out.println("Input field should be displayed"+key.isDisplayed(page.usernamefied()));
		Assert.assertTrue(key.isDisplayed(page.usernamefied()));
	} 
	@Then("Input field should be enabled")
	public void input_field_should_be_enabled() {
		//System.out.println("Input field should be isenabled"+key.isEnabled(page.usernamefied()));
		log.debug("Input field should be enabled");
		Assert.assertTrue(key.isEnabled(page.usernamefied()));
	}
	@Then("Cancel button should be displayed")
	public void cancel_button_should_be_displayed() {
		//System.out.println("Input field should be displayed"+key.isDisplayed(page.cancelButton()));
		log.debug("Cancel button should be displayed");
		Assert.assertTrue(key.isDisplayed(page.cancelButton()));
	}
	@Then("Cancel button should be enabled")
	public void cancel_button_should_be_enabled() {
		//System.out.println("Input field should be isenabled"+key.isEnabled(page.cancelButton()));
		log.debug("cancel_button_should_be_enabled");
		Assert.assertTrue(key.isEnabled(page.cancelButton()));
	}
	@Then("Reset password button should be displayed")
	public void reset_password_button_should_be_displayed() {
		//System.out.println("Input field should be displayed"+key.isDisplayed(page.ResetButton()));
		
		log.debug("Reset password button should be displayed");
		Assert.assertTrue(key.isDisplayed(page.ResetButton()));
	}
	@Then("Reset password button should be enabled")
	public void reset_password_button_should_be_enabled() {
		//System.out.println("Input field should be isEnabled"+key.isEnabled(page.ResetButton()));
		log.debug("Reset password button should be enabled");
		Assert.assertTrue(key.isEnabled(page.ResetButton()));
	}
	
	@When("User enters the {string}")
	public void user_enters_the(String string) {
		log.debug("User enters the "+string);
		  key.enterText(page.usernamefied(), string);
	}
	@When("User clicks on the Reset password button")
	public void user_clicks_on_the_reset_password_button() {
		log.debug("User clicks on the Reset password button");
		 key.clickElement(page.ResetButton());
	}
	@Then("Mail should be triggered to the user")
	public void mail_should_be_triggered_to_the_user() {
		log.debug("Mail should be triggered to the user");
		//System.out.println(page.emailTriggered().getText());
		Assert.assertEquals("Reset Password link sent successfully",page.emailTriggered().getText());
		 //.out.println("mail_got_triggered_to_the_user");
	}
	@When("User remembers the details and clicks on cancel button")
	public void user_remembers_the_details_and_clicks_on_cancel_button() {
		key.clickElement(page.cancelButton());
		log.debug("User remembers the details and clicks on cancel button");
		//System.out.println("Clicked on cancel button");
	}
	@When("No details are entered in the username field")
	public void no_details_are_entered_in_the_username_field() {
		log.debug("No details are entered in the username field");
		 key.enterText(page.usernamefied(),"");
		 //System.out.println("no test entered");
	}
	
	@Then("Please enter username message should be displayed")
	public void please_enter_username_message_should_be_displayed() {
		log.debug("Please enter username message should be displayed");
		 key.clickElement(page.ResetButton());
		Assert.assertEquals("Required", page.Requirednametext().getText());
	}


	

	
	



}
