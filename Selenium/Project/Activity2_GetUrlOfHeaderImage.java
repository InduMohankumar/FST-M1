package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity2_GetUrlOfHeaderImage {
	
	@Test
	public void getUrlOfHeaderImage() {
		WebDriver driver=new FirefoxDriver();
		 driver.get("http://alchemy.hguy.co/orangehrm");
		 WebElement headerImg=driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		 String imageUrl=headerImg.getAttribute("src");
		 System.out.println("**ImageUrl**:"+imageUrl);
		 driver.quit();
			
	}

}
