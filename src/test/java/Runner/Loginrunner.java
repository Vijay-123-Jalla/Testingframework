package Runner;

import Hooks.BaseTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features ="C://Users//vijay//eclipse-workspace//Sampleframework//featurefiles//login.feature",
		
		glue={"Stepdefinitions","Hooks"},
		monochrome=true
		//dryRun=true
		)

public class Loginrunner extends AbstractTestNGCucumberTests{

	}






