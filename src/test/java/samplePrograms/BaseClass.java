package samplePrograms;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		
		HashMap<String,Object> pref=new HashMap<String, Object>();
		pref.put("Profile.default_content_settings.popups", 0);
		pref.put("download.prompt_for_download", false);
		pref.put("download.default_directory", "C:\\Sudha\\Downloads");
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", pref);
		options.addArguments("--start-maximized");
		driver=new ChromeDriver(options);
	}

	//@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
