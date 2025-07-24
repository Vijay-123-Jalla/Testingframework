package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_methods.GenericKeywords;
import Hooks.Hooks;

public class PasswordResetpage {
	WebDriver driver;
	public PasswordResetpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//p[text()='Forgot your password? ']") WebElement forgottenlink;
	@FindBy(xpath = "//input[@placeholder='Username']") WebElement usernamefied;

	@FindBy(xpath = "//button[text()=' Cancel ']") WebElement cancelButton;
	@FindBy(xpath = "//button[text()=' Reset Password ']") WebElement ResetButton;
	@FindBy(xpath="//span[text()='Required']") WebElement Requirednametext;
	@FindBy(xpath="//h6[text()='Reset Password link sent successfully']") WebElement emailTriggered;
	GenericKeywords key=new GenericKeywords();
	public WebElement forgottenlink()
	{
		key.explicitWait(Hooks.driver, forgottenlink, 20);
		return forgottenlink;
	}
	public WebElement usernamefied()
	{
		key.explicitWait(Hooks.driver, usernamefied, 20);
		return usernamefied;
	}
	public WebElement cancelButton()
	{
		
		key.explicitWait(driver, cancelButton, 20);

		return cancelButton;
	}
	public WebElement ResetButton()
	{		
		key.explicitWait(driver, ResetButton, 20);

		return ResetButton;
	}

	public WebElement Requirednametext()
	{
		key.explicitWait(driver, Requirednametext, 20);
		return Requirednametext;
	}
	public WebElement emailTriggered()
	{
		
		key.explicitWait(driver, emailTriggered, 20);
		return emailTriggered;
	
	}

}
