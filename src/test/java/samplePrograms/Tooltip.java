package samplePrograms;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Tooltip extends BaseClass {
	
	@Test
	public void verifyTooltip() {
		driver.get("http://www.leafground.com/pages/tooltip.html");
		String tooltip=driver.findElement(By.id("age")).getAttribute("title");
		System.out.println("Tooltip of the text box is: "+tooltip);
	}
}
