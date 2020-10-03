package programs;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Buttons extends BaseClass {
	
	@Test(groups= {"Sanity","Smoke"})
	public void buttons() {
		
		driver.navigate().to("http://www.leafground.com/pages/Button.html");
				
		//1.Click button to go to home page
		driver.findElement(By.id("home")).click();
		Assert.assertEquals(driver.getTitle(), "TestLeaf - Selenium Playground");
		driver.navigate().back();
		
		//2.Find position of button (x,y)
		Point point = driver.findElement(By.id("position")).getLocation();
		int x=point.getX();
		int y=point.getY();
		System.out.println("Position of button x: "+x+" and y is: "+y);
		
		String btnColor = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println(btnColor);
		
		Dimension dim = driver.findElement(By.id("size")).getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		System.out.println("Height of the button is: "+height+" and "+" width is: "+width);
		
		getScreenShot("buttons", driver);
	}

}
