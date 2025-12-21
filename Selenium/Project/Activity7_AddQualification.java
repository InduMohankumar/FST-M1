package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7_AddQualification {
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
  public void addQualification() {
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement myinfoLink=wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails")));
		new Actions(driver).moveToElement(myinfoLink).perform();
		myinfoLink.click();	
		myinfoLink.click();	
		WebElement qualificationLink=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Qualifications'])[2]")));
		qualificationLink.click();
		WebElement addWork=wait.until(ExpectedConditions.elementToBeClickable(By.id("addWorkExperience")));
		addWork.click();
		WebElement companyName=wait.until(ExpectedConditions.elementToBeClickable(By.id("experience_employer")));
		companyName.sendKeys("IBM India");
		WebElement jobTitle=wait.until(ExpectedConditions.elementToBeClickable(By.id("experience_jobtitle")));
		jobTitle.sendKeys("Full Stack Tester");
		WebElement expFromDate=wait.until(ExpectedConditions.elementToBeClickable(By.id("experience_from_date")));
		expFromDate.clear();
		expFromDate.click();
		expFromDate.sendKeys("2010-11-01");
		WebElement expToDate=wait.until(ExpectedConditions.elementToBeClickable(By.id("experience_to_date")));
		expToDate.clear();
		expToDate.click();
		expToDate.sendKeys("2020-11-01");
		WebElement btnWorkExpSave=wait.until(ExpectedConditions.elementToBeClickable(By.id("btnWorkExpSave")));
		btnWorkExpSave.click();	
		
  }
  @AfterClass
	 public void tearDown() 
	 { 
		driver.quit(); 
	 }
}

