package activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity1_VerifyWebsiteTitle {

	@Test
	public void verifyWebsiteTitle() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.get("http://alchemy.hguy.co/orangehrm");
		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Title:" + actualTitle);
		driver.quit();

	}

}
