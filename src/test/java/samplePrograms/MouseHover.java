package samplePrograms;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover extends BaseClass {
	
	@BeforeMethod
	public void launchURL() {
		driver.get("http://www.leafground.com/pages/mouseOver.html");
	}
	
	@Test(enabled=true)
	public void test1() {
		Actions action=new Actions(driver);
		WebElement testLeaf = driver.findElement(By.xpath("//a[text()='TestLeaf Courses']"));
		action.moveToElement(testLeaf).build().perform();
		List<WebElement> courses = driver.findElements(By.xpath("//a[text()='TestLeaf Courses']//following::li/a"));
		for (WebElement wbcourse : courses) {
			System.out.println(wbcourse.getText());
		}		
	}
	
	@Test
	public void test2() {
		Actions action=new Actions(driver);
		WebElement testLeaf = driver.findElement(By.xpath("//a[text()='TestLeaf Courses']"));
		action.moveToElement(testLeaf).build().perform();
		driver.findElement(By.xpath("//a[text()='RPA']")).click();
		driver.switchTo().alert().accept();
		System.out.println("Handled alert");
		Assert.assertTrue(true);
		/*driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Selenium']")).click();
*/
	}

}
