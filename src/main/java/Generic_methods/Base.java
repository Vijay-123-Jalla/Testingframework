package Generic_methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;

	
	Logger log;
	public WebDriver browserLaunch(String browserName)
	{
		log = LogManager.getLogger(Base.class.getName());
		  //System.out.println("Launching browser: " + browserName);
		 if (browserName.equalsIgnoreCase("chrome")) {
			 log.debug("Launch the Chrome browser");
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("--headless=new");
			 options.addArguments("--no-sandbox");
			 options.addArguments("--disable-dev-shm-usage");
			 WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        } 
		 else if (browserName.equalsIgnoreCase("firefox")) 
		 {
				
			 log.debug("Launch the Firefox browser");
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	        } 
		 else if (browserName.equalsIgnoreCase("edge")) 
		 {
			 log.debug("Launch the edge browser");
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	        } 
		 else 
		 {
	            System.out.println("Invalid browser: " + browserName);
	        }
		 driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        return driver;

	}

}
