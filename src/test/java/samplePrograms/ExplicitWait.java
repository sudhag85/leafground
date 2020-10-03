package samplePrograms;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitWait extends BaseClass {

	//alertIsPresent
	@Test(enabled=false)
	public void chkForAlertPresence(){
		driver.get("http://www.leafground.com/pages/alertappear.html");
		driver.findElement(By.xpath("//button[@id='alert']")).click();
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert is displayed");
		driver.switchTo().alert().accept();
		System.out.println("Accepted the alert");
		driver.switchTo().defaultContent();
	}

	//textToBePresentInElement
	@Test(enabled=false)
	public void chkForButtonTextChanges(){
		driver.get("http://www.leafground.com/pages/TextChange.html");
		WebElement btn = driver.findElement(By.id("btn"));
		WebDriverWait wait=new WebDriverWait(driver,30);
		boolean status =	wait.until(ExpectedConditions.textToBePresentInElement(btn, "Click ME!"));
		if (status==true) {
			btn.click();
			String alerttxt = driver.switchTo().alert().getText();
			Assert.assertEquals(alerttxt, "Click ME!");
		}
	}

	//visibilityOfAllElementsLocatedBy
	@Test(enabled=false)
	public void chkForBtnText() {
		driver.get("http://www.leafground.com/pages/appear.html");
		List<WebElement> btnDetails = driver.findElements(By.xpath("//div[@class='flex']/button"));
		int firstBtnCnt = btnDetails.size();
		String[] firstNames=new String[firstBtnCnt];
		for(int i=0;i<firstBtnCnt;i++) {
			firstNames[i] = btnDetails.get(i).getText().toString();
		}
		System.out.println(Arrays.toString(firstNames));		

		WebDriverWait wait=new WebDriverWait(driver,20);
		List<WebElement> totalBtn = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='flex']/button")));
		System.out.println("Button changed to 5");
		String[] lastNames=new String[totalBtn.size()];
		for(int i=0;i<totalBtn.size();i++) {
			lastNames[i] = totalBtn.get(i).getText().toString();
		}
		System.out.println(Arrays.toString(lastNames));		
		for(int i=0;i<lastNames.length;i++) {
			if(!(firstNames[i].equals(lastNames[i]))) {
				System.out.println("Disappered text on form load is: "+lastNames[i]);
				break;
			}
		}
	}
	
	//invisibility of
	@Test
	public void verifyBtnDisappearance() {
		driver.get("http://www.leafground.com/pages/disapper.html");
		WebElement btn=driver.findElement(By.xpath("//button[@id='btn']"));
		WebDriverWait wait=new WebDriverWait(driver,20);
		boolean btnStatus = wait.until(ExpectedConditions.invisibilityOf(btn));
		if(btnStatus) {
			System.out.println("Button disappered.......");
			Assert.assertTrue(true);
		}
		
		String shownText = driver.findElement(By.xpath("//div[@id='show']//strong")).getText();
		Assert.assertEquals(shownText.trim(), "I know you can do it! Button is disappeared!");
	}
}


