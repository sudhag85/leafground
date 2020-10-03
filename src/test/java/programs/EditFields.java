package programs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFields extends BaseClass {

	@Test(groups= {"Smoke"})
	public void editmethods() {
		//WebDriver driver=new HtmlUnitDriver();	
		driver.get("http://www.leafground.com/pages/Edit.html");

		//1.SendKeys
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");

		//2.AppendText
		WebElement txtAppend = driver.findElement(By.xpath("//section[@class='innerblock']/div[2]//input"));
		txtAppend.click();
		txtAppend.sendKeys("hi"+Keys.TAB);
		String appendedTxt=txtAppend.getText();
		System.out.println(appendedTxt);

		//3.GetText
		String txtDefault= driver.findElement(By.xpath("//section[@class='innerblock']/div[3]//input")).getText();
		System.out.println(txtDefault);

		//4.ClearText
		WebElement clrText = driver.findElement(By.xpath("//section[@class='innerblock']/div[4]//input"));
		clrText.clear();
		System.out.println(clrText);

		//5.txtbox status
		boolean txtStatus = driver.findElement(By.xpath("//section[@class='innerblock']/div[5]//input")).isEnabled();
		//System.out.println(txtStatus);	
		Assert.assertTrue(txtStatus==false);
		getScreenShot("editmethods", driver);
	}
}