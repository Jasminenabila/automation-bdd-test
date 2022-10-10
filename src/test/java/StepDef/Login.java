package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    WebDriver driver;
    @Given(": User Open Browser")
    public void userOpenWebsite() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver 5");
        driver = new ChromeDriver();

    }

    @When(": User Access Tools QA")
    public void userAccess() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
    }

    @When(": User Fill Form Login valid and registered")
    public void userFillFormLoginValidAndRegistered() {
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
    }

    @And(": User Click button Login")
    public void userClickButtonLogin() {
        driver.findElement(By.id("btn-login")).click();
    }

    @Then(": Successfully Login")
    public void successfullyLogin() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#appointment > div > div > div > h2")).isDisplayed());
    }


    @And("User logout")
    public void userLogout() {
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.cssSelector("#sidebar-wrapper > ul > li:nth-child(6) > a")).click();
        driver.close();
        driver.quit();
    }


}
