package programs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public File f;
	public WebDriver driver;
	public FileInputStream fis;
	public String fPath;


	public Properties loadPropertyFile() {
		fPath = System.getProperty("user.dir")+"/config.properties";;
		f = new File(fPath);
		Properties pro=null;
		try {
			fis = new FileInputStream(f);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());		
		}
		return pro;				
	}

	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void setUp(String br) {
		//String brName = loadPropertyFile().getProperty("browser");
		if(br.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void getScreenShot(String name, WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File srcF = ts.getScreenshotAs(OutputType.FILE);
		File f= new File(System.getProperty("user.dir")+"/Screenshots/"+name+".png");
		try {
			FileUtils.copyFile(srcF, f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
