package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Hooks.Hooks;

public class Loginpage {
	WebDriver driver;
	public Loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	private @FindBy(xpath = "//input[@placeholder='Username']") WebElement login;
	private @FindBy(xpath = "//input[@placeholder='Password']") WebElement password;
	private @FindBy(xpath = "//button[text()=' Login ']") WebElement clickbutton;
	private @FindBy(xpath = "//p[text()='Invalid credentials']") WebElement invalidmessage;
    public WebElement login() 
    {
    	WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(login));
    	return login;
    }
    public WebElement password()
    {
    	WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(password));
    	return password;
    			}
    public WebElement clickbutton()
    {
//    	WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(clickbutton));
    	return clickbutton;
    			}
    public WebElement invalidmsg()
    {
    	return invalidmessage;
    }
    
	}






