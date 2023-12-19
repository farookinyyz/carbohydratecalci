package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SettingsStepDef extends BaseClass {

    @Then("user verifies the options displayed under settings")
    public void userVerifiesTheOptionsDisplayedUnderSettings() {
        boolean formulaContent = driver.findElement(By.xpath("//div[@id=\"ccsettingcontent\"]/div/b")).isDisplayed();
        Assert.assertTrue(formulaContent,"BMR estimation formula is displayed");
        boolean firstRadioBtn = driver.findElement(By.xpath("//div/label[@for=\"cformula1\"]")).isDisplayed();
        Assert.assertTrue(firstRadioBtn,"First radio button is displayed");
    }

    @And("used clicks on {string} radio button")
    public void usedClicksOnRadioButton(String arg0) {
        boolean secondRadioBtn = driver.findElement(By.xpath("//div/label[@for=\"cformula2\"]")).isDisplayed();
        Assert.assertTrue(secondRadioBtn,"Second radio button is displayed");
        driver.findElement(By.xpath("//div/label[@for=\"cformula2\"]")).click();
        System.out.println("Katch-McArdle option is selected");
    }
}
