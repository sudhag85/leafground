package programs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Images extends BaseClass{
	
	@Test
	public void image() {
		driver.navigate().to("http://www.leafground.com/pages/Image.html");
		
		//1.Click on this image to go home page
		driver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[1]//img")).click();
		Assert.assertEquals(driver.getTitle(), "TestLeaf - Selenium Playground");
		
		//2.Am I Broken Image?
		driver.navigate().back();
		String imgBroken = driver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[2]//img")).getAttribute("naturalWidth");
		Assert.assertTrue(imgBroken.equals("0"), "Image is broken image");
		
		WebElement img = driver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[3]//img"));
		//img.sendKeys(Keys.ENTER);
		
		Actions action=new Actions(driver);
		action.click(img).build().perform();
		getScreenShot("image", driver);
	}

}
