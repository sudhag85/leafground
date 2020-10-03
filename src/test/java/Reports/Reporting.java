package Reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext tc) {
		
		Date date =new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss");
		String formattedDate = dateFormat.format(date);
		String reportName = "Report-"+formattedDate+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+reportName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent =new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Sudha");
		
		htmlReporter.config().setDocumentTitle("Automation Reports");
		htmlReporter.config().setReportName("LeafGround Automation Reports");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
				
	}
	
	

	
	public void onTestSuccess(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		String fPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f=new File(fPath);
		if(f.exists()) {
			try {
				test.pass("Screenshot is below: "+test.addScreenCaptureFromPath(fPath));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void onTestFailure(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String fPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f=new File(fPath);
		if(f.exists()) {
			try {
				test.fail("Screenshot is below: "+test.addScreenCaptureFromPath(fPath));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	public void onTestSkipped(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext tc) {
		extent.flush();	
	}
	
}
