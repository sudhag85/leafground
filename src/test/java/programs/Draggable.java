package programs;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Draggable extends BaseClass{

	@Test(groups= {"Regression"})
	public void dragg() {
		driver.get("http://www.leafground.com/pages/drag.html");
		Actions action=new Actions(driver);
		WebElement src = driver.findElement(By.id("draggable"));
		action.dragAndDropBy(src, 200, 100).build().perform();
		getScreenShot("dragg", driver);
	}
	
}
