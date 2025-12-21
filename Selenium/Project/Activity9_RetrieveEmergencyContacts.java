package activities;

import java.time.Duration;
import java.util.List;

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

public class Activity9_RetrieveEmergencyContacts {

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
	public void retrieveEmergency() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement myinfoLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails")));
		new Actions(driver).moveToElement(myinfoLink).perform();
		myinfoLink.click();

		WebElement emergContactlink = driver.findElement(By.xpath("//a[text()='Emergency Contacts']"));
		emergContactlink.click();

		WebElement table = driver.findElement(By.id("emgcontact_list"));
		List<WebElement> rows = table.findElements(By.xpath(".//tr[td]"));
		for (WebElement row : rows) {
			List<WebElement> columns = row.findElements(By.tagName("td"));

			for (WebElement column : columns) {
				System.out.print(column.getText() + " | ");
			}
			System.out.println(); // new line after each row
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
