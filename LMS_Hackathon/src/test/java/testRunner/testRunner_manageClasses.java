package testRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
monochrome=true,
features="src\\test\\resources\\Features\\manageClasses.feature",
glue="stepDefinitionsforManageClasses",
dryRun=true,

plugin= {"pretty","html:target/HTML_Reports/manageClasses.html"}
)


public class testRunner_manageClasses {

}
