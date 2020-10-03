package programs;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDown extends BaseClass{

	@Test(groups= {"Regression"})
	public void dropdown() {
		driver.get("http://www.leafground.com/pages/Dropdown.html");

		//1.Select using index
		WebElement dd1=driver.findElement(By.id("dropdown1"));
		Select select1=new Select(dd1);
		for(int i=0;i<select1.getOptions().size();i++) {
			select1.selectByIndex(i);
		}

		//2.Select using Text
		WebElement dd2=driver.findElement(By.name("dropdown2"));
		Select select2=new Select(dd2);
		List<WebElement> options = select2.getOptions();
		for (WebElement option : options) {
			select2.selectByVisibleText(option.getText());
		}
		
		//3.Select using value
		WebElement dd3=driver.findElement(By.id("dropdown3"));
		Select select3=new Select(dd3);
		for(int i=0;i<select3.getOptions().size();i++) {
			select3.selectByValue(String.valueOf(i));;
		}
		
		//4.No. of dropdown options
		WebElement dd4 = driver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[4]/select"));
		Select select4=new Select(dd4);
		System.out.println("Total no. of dropdown options are: "+select4.getOptions().size());
		
		driver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[5]/select")).sendKeys("Selenium");
		
		WebElement dd5=driver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[6]/select"));
		Select select5=new Select(dd5);
		List<WebElement> opts = select5.getOptions();
		
		for (WebElement opt : opts) {
			select5.selectByVisibleText(opt.getText());
		}
		//action.build().perform();
		
		getScreenShot("dropdown", driver);
		
		
	}

}
