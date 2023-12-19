package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MetricUnits extends BaseClass {

    @Given("launch the browser")
    public void browserLaunch() {
         driver= new ChromeDriver();
         driver.manage().window().maximize();
        System.out.println("chrome browser is launched");
    }
    @And("load the url")
    public void urlLoad() {
        driver.get("https://www.calculator.net/carbohydrate-calculator.html");
        System.out.println("URL is opened");
    }
    @Given("user is present on the metric units page by default")
    public void verifyMetricUnitsPage() {
        boolean b=driver.findElement(By.xpath("//*[@id=\"menuon\"]/a")).isEnabled();
        Assert.assertTrue(  b,"Metrics unit is displayed");
        System.out.println("Metrics unit is displayed to the user");
    }
    @And("user clicks on {string} button")
    public void clickButton(String string) throws InterruptedException {
        if (string.equals("clear")){
            driver.findElement(By.xpath("//input[@value=\"Clear\"]")).click();
            System.out.println("User clicks clear");
    }
        else if (string.equals("calculate")) {
            driver.findElement(By.xpath("//input[@value=\"Calculate\"]")).click();
            System.out.println("User clicks on calculate");
            Thread.sleep(3000);
        }else if (string.equals("settings")){
            driver.findElement(By.xpath("//div[@id=\"ccsettingtitle\"]/b/a")).click();
            System.out.println("User clicks on settings");
        }
    }

    @Then("user enters the {int} in the {string} field")
    public void userInputs(Integer value, String string) throws InterruptedException {
        if(string.equals("age")) {
            driver.findElement(By.xpath("//input[@id=\"cage\"]")).click();
            driver.findElement(By.xpath("//input[@id=\"cage\"]")).sendKeys(value.toString());
            System.out.println("Age is entered");
        } else if (string.equals("height")) {
            driver.findElement(By.xpath("//input[@id=\"cheightmeter\"]")).click();
            driver.findElement(By.xpath("//input[@id=\"cheightmeter\"]")).sendKeys(value.toString());
            System.out.println("Height is entered");
        } else if (string.equals("weight")) {
            driver.findElement(By.xpath("//input[@id=\"ckg\"]")).click();
            driver.findElement(By.xpath("//input[@id=\"ckg\"]")).sendKeys(value.toString());
            System.out.println("Weight is entered");
        } else if (string.equals("body fat")) {
            driver.findElement(By.xpath("//input[@name=\"cfatpct\"]")).click();
            driver.findElement(By.xpath("//input[@name=\"cfatpct\"]")).sendKeys(value.toString());
            Thread.sleep(3000);
            System.out.println("Weight is entered");

        }
    }

    @Then("user selects the {double} in the activity field")
    public void selectActivity(Double double1) {
        Select activity= new Select(driver.findElement(By.id("cactivity")));
        activity.selectByValue(double1.toString());
        System.out.println("Activity is selected");
    }

    @Then("user is displayed with detailed results")
    public void verifyResults() {
        WebElement content = driver.findElement(By.xpath("//*[@id=\"content\"]/h2"));
        String contentValue = content.getText();
        Assert.assertEquals(contentValue,"Result");
        System.out.println("Results are verified");
        driver.quit();
    }

    @Then("user verifies the {string} for not entering {string}")
    public void validateEmptyFields(String errorMessage, String field) {
        if(field.equals("age")){
            String actual = driver.findElement(By.xpath("//div/font[contains(text(),\"18 and 80\")]")).getText();
            Assert.assertEquals(actual,errorMessage,"age error is matching");
        } else if (field.equals("height")) {
            String actual = driver.findElement(By.xpath("//div/font[contains(text(),\"height value\")]")).getText();
            Assert.assertEquals(actual,errorMessage,"height error is matching");
        } else if (field.equals("weight")) {
            String actual = driver.findElement(By.xpath("//div/font[contains(text(),\"weight value\")]")).getText();
            Assert.assertEquals(actual,errorMessage,"weight error is matching");
        }
        System.out.println("Errors are displayed as expected");
    }
}
