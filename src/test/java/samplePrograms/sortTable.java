package samplePrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sortTable extends BaseClass {
	
	@Test
	public void sortTable() {

		driver.get("http://www.leafground.com/pages/sorttable.html");
		
		int colCount = driver.findElements(By.xpath("//table//th")).size();
		int rowCount = driver.findElements(By.xpath("//table//tr")).size();
		driver.findElement(By.xpath("//table//th[2]")).click();
		driver.findElement(By.xpath("//table//th[2]")).click();
		String order = driver.findElement(By.xpath("//table//th[2]")).getAttribute("aria-sort");
		List<String> n1=new ArrayList<String>();
		List<String> n2=new ArrayList<String>();
		List<String> n3=new ArrayList<String>();
		for (int i=1;i<rowCount;i++) {
				n1.add(driver.findElement(By.xpath("//table//tr["+i+"]/td[2]")).getText());	
				n2.add(driver.findElement(By.xpath("//table//tr["+i+"]/td[2]")).getText());	
				n3.add(driver.findElement(By.xpath("//table//tr["+i+"]/td[2]")).getText());	
			}		
		System.out.println(n1);
		Collections.sort(n2);
		Collections.sort(n3,Collections.reverseOrder());
		
		if(order.equalsIgnoreCase("ascending")&&(n1.equals(n2))) {
			System.out.println("Names are sorted in ascending order");
			Assert.assertTrue(true);
		}else if(order.equalsIgnoreCase("descending")&&(n1.equals(n3))) {
			System.out.println("Names are sorted in descending order");
			Assert.assertTrue(true);
		}else {
			System.out.println("Names are NOT sorted in ascending or descending order");
			Assert.assertTrue(false);
		}
	}
}
