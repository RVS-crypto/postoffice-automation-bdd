package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",glue = {"StepDefinitions","restAssuredTests"}, tags="@apitag2")


public class TestRunner {

}
