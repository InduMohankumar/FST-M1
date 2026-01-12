package examples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity3 {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Create Firefox driver
        driver = new FirefoxDriver();

        // Open login page
        driver.get("https://training-support.net/webelements/login-form");
    }

    @Test
    public void loginTest() {
        // Find username field and enter value
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");

        // Find password field and enter value
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password");

        // Click login button
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Get heading text after login
        String heading = driver.findElement(By.tagName("h1")).getText();
        System.out.println("Heading after login: " + heading);

        // Assert successful login message
        Assert.assertEquals(heading, "Welcome Back, Admin!");
    }

    @AfterTest
    public void tearDown() {
        // Close browser
        driver.quit();
    }
}
