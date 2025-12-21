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

public class Activity5_EditEmp {
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
	public void editEmployeeDetails() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement myinfoLink=wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails")));
		new Actions(driver).moveToElement(myinfoLink).perform();
		myinfoLink.click();	
		myinfoLink.click();	
		WebElement editBtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Edit']")));
		editBtn.click();
		WebElement firstNameEdit=driver.findElement(By.id("personal_txtEmpFirstName"));
		firstNameEdit.click();
		firstNameEdit.clear();
		firstNameEdit.sendKeys("STACEY");
		WebElement lastNameEdit=driver.findElement(By.id("personal_txtEmpLastName"));
		lastNameEdit.click();
		lastNameEdit.clear();
		lastNameEdit.sendKeys("STUART");
		WebElement genderMale=driver.findElement(By.xpath("//input[@id='personal_optGender_1']"));
		genderMale.click();
		Select dropdown = new Select(driver.findElement(By.id("personal_cmbNation")));
		dropdown.selectByVisibleText("Algerian");
		WebElement dateInput=driver.findElement(By.id("personal_DOB"));
		dateInput.click();
		dateInput.clear();
		dateInput.sendKeys("2000-03-26");
	
		
		WebElement saveBtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Save']")));
		saveBtn.click();
		
		
	}
	
	@AfterClass
	 public void tearDown() 
	 { 
		driver.quit(); 
	 }

}
