package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features ="C:\\Users\\vijay\\eclipse-workspace\\Sampleframework\\featurefiles\\forgottenpassword.feature",
		
		glue={"Stepdefinitions","Hooks"},
		monochrome=true
	//dryRun=true
		)
public class ResetpasswordRunner extends AbstractTestNGCucumberTests  {
	

	



}
