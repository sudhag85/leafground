package samplePrograms;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Download extends BaseClass {
	
	//@Test
	public void verifyDownload() throws FileNotFoundException, InterruptedException {
		driver.get("http://www.leafground.com/pages/download.html");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Download Excel']")).click();
		Thread.sleep(8000);
		File f=new File("C:/Sudha/Downloads/testleaf.xlsx");
		if (f.exists()) {
		System.out.println("File downloaded");	
		}else {
			System.out.println("File not downloaded");
		}
	}
	
	
	@Test
	public void verifyPdfDownload() throws InterruptedException, IOException {
		driver.get("http://www.leafground.com/pages/download.html");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Download PDF']")).click();
		URL url =new URL(driver.getCurrentUrl());
		
		System.out.println(url);
		String read = url.toString();
		
		WebElement ele = driver.findElement(By.xpath("//*[@id='download']"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
		InputStream is = url.openStream();
		BufferedInputStream bis=new BufferedInputStream(is);
		PDDocument document=PDDocument.load(bis);
		String pdfContent = new PDFTextStripper().getText(document);
		System.out.println(pdfContent);
		//ReadPDF rd=new ReadPDF();
		
		/*Thread.sleep(8000);
		File f=new File("C:/Sudha/Downloads/testleaf.xlsx");
		if (f.exists()) {
		System.out.println("File downloaded");	
		}else {
			System.out.println("File not downloaded");
		}*/
	}

}
