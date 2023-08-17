package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/Features/opencart.feature",
                 glue="stepdefinition",
                 tags="@cart",
                 plugin="html:reports/opencart"
                )
public class run {
}
