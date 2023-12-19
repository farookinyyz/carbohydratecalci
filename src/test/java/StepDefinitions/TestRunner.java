package StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="classpath:Features",
        glue={"StepDefinitions"},
        plugin = {"pretty","html:target/CucumberReport.html","json:target/cucumber.json"},
        monochrome = true,
        tags = ("@test1 or @test2 or @test3") )
public class TestRunner {

}
