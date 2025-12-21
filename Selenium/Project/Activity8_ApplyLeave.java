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

public class Activity8_ApplyLeave {

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
	public void applyLeave() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement dashboard = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_dashboard_index")));
		new Actions(driver).moveToElement(dashboard).perform();
		dashboard.click();
		WebElement applyLeaveLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/span[text()='Apply Leave']")));
		applyLeaveLink.click();
		Select leavetypeDropdown = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
		leavetypeDropdown.selectByContainsVisibleText("DayOff");
		WebElement leaveFromDate = wait.until(ExpectedConditions.elementToBeClickable(By.id("applyleave_txtFromDate")));
		leaveFromDate.clear();
		leaveFromDate.click();
		leaveFromDate.sendKeys("2026-01-25");
		WebElement leaveToDate = wait.until(ExpectedConditions.elementToBeClickable(By.id("applyleave_txtToDate")));
		leaveToDate.clear();
		leaveToDate.click();
		leaveToDate.sendKeys("2026-01-25");
		WebElement leaveApplyBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("applyBtn")));
		leaveApplyBtn.click();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
