package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6_DirMenu {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://alchemy.hguy.co/orangehrm");
		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";
		Assert.assertEquals(actualTitle, expectedTitle);
		WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		username.sendKeys("orange");
		password.sendKeys("orangepassword123");
		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
		loginBtn.click();
		WebElement welcomeLink = driver.findElement(By.xpath("//a[@id='welcome']"));
		Assert.assertTrue(welcomeLink.isDisplayed());
		System.out.println("Login successful: Home page opened.");
	}
	@Test
	public void directoryMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement dirMenu=wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_directory_viewDirectory")));
		new Actions(driver).moveToElement(dirMenu).perform();
		dirMenu.click();	
		dirMenu.click();	
		WebElement dirMenuHeading=driver.findElement(By.xpath("//div[@class='head']/h1"));
		String dirMenuTitle=dirMenuHeading.getText();
		String expectedTitle="Search Directory";
		Assert.assertEquals(dirMenuTitle, expectedTitle);
		
		
	}
	
	@AfterClass
	 public void tearDown() 
	 { 
		driver.quit(); 
	 }
}
