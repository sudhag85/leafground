package programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hyperlinks extends BaseClass{
	
	@Test
	public void hyperlinks() {
		
		driver.navigate().to("http://www.leafground.com/pages/Link.html");
		//1.Go to Home Page
		driver.findElement(By.partialLinkText("Home Page")).click();
		Assert.assertEquals(driver.getTitle(), "TestLeaf - Selenium Playground");
		
		//2.Find where am supposed to go without clicking me?
		driver.navigate().back();
		String url=driver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[2]//a")).getAttribute("href");
		System.out.println("Your supposed to go to: "+ url);
		
		//3.Verify am I broken?
		driver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[3]//a")).click();
		Assert.assertTrue(driver.getTitle().contains("404"));
		
		driver.navigate().back();
		
		//4.How many links are available in this page?
		int linksCnt = driver.findElements(By.xpath("//a")).size();
		System.out.println("Total no. of links displayed on the page is: "+linksCnt);
		getScreenShot("hyperlinks", driver);
	}

}
