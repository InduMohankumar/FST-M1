package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class Activity4_AddEmp {
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
	public void addEmp() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Click PIM menu
		WebElement pimMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewPimModule")));
		new Actions(driver).moveToElement(pimMenu).perform();
		pimMenu.click();
		//employee list
		WebElement empList = wait.until(
		        ExpectedConditions.elementToBeClickable(
		                By.id("menu_pim_viewEmployeeList")));
		empList.click();
		System.out.println("You are in Employee list");
		// Click Add button
		WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAdd")));
		new Actions(driver).moveToElement(addBtn).click().build().perform();

		// Wait for Add Employee heading
		WebElement addFormHeading = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Add Employee')]")));
		Assert.assertTrue(addFormHeading.isDisplayed());
		System.out.println("You are in Add Employee form");

		// Fill employee details
		driver.findElement(By.id("firstName")).sendKeys("Abcdef");
		driver.findElement(By.id("lastName")).sendKeys("X");
		driver.findElement(By.id("btnSave")).click();

		// Wait for personal details page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employee-details")));
		System.out.println("Employee details saved.");
		//
		WebElement empList1 = wait.until(
		        ExpectedConditions.elementToBeClickable(
		                By.id("menu_pim_viewEmployeeList")));
		empList1.click();
		
		// Wait for input to be clickable (visible and enabled)
		WebElement empName = wait.until(
		        ExpectedConditions.elementToBeClickable(
		                By.id("empsearch_employee_name_empName"))
		);

		// Clear existing text (important for autocomplete inputs)
		empName.click();
		empName.clear();
		empName.clear();

		// Enter new text
		empName.sendKeys("Abcdef X");
		
		WebElement suggestion=driver.findElement(By.xpath("//li[@class='ac_even ac_over']"));
		suggestion.click();
		
		WebElement srchBtn=driver.findElement(By.cssSelector("input#searchBtn"));
		srchBtn.click();
		
		
	}



	@AfterClass
	 public void tearDown() 
	 { 
		driver.quit(); 
	 }

}
