package activities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity3_LoggingIn {
  @Test
  public void loggingIn() {
	  
	  WebDriver driver=new FirefoxDriver();
	  driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
	  WebElement username=driver.findElement(By.xpath("//input[@id='txtUsername']"));
	  WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
	  username.sendKeys("orange");
      password.sendKeys("orangepassword123");
	  WebElement loginBtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
	  loginBtn.click();
	  WebElement welcomeLink=driver.findElement(By.xpath("//a[@id='welcome']"));
	  Assert.assertTrue(welcomeLink.isDisplayed());
	  System.out.println("Login successful: Home page opened.");
	  driver.quit();	  
	  
  }
}
