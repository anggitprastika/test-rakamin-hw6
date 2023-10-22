package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Login {
    WebDriver driver;
    @Given("I open browser")
    public void iOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @And("Open website saucedemo")
    public void openWebsiteSaucedemo() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        Thread.sleep(1000);
    }

    @And("Located on saucedemo website")
    public void locatedOnSaucedemoWebsite() {
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @When("I input valid username")
    public void iInputValidUsername() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @And("I input valid password")
    public void iInputValidPassword() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    }

    @Then("I go to homepage")
    public void iGoToHomepage() throws InterruptedException {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).isDisplayed();
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}