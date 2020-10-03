package samplePrograms;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Upload extends BaseClass{
	
	@Test
	public void uploadFile() throws AWTException {
		driver.get("http://www.leafground.com/pages/upload.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement btn=driver.findElement(By.name("filename"));
		btn.click();
	//	btn.sendKeys("C:\\Users\\65838\\Downloads\\info.txt");
		
/*		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btn);*/
		/*WebDriverWait wait=new WebDriverWait(driver,20);
		
		WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("filename")));*/
		/*btn.click();
		String filePath="C:\\Users\\65838\\Downloads\\info.txt";
		Robot robot=new Robot();
		robot.setAutoDelay(3000);
		StringSelection ss=new StringSelection(filePath); 
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);*/
	}

}
