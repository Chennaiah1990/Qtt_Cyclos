package testcases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

import org.apache.xmlbeans.impl.jam.mutable.MMember;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import helper.Utility;
import pages.Cyclos_LoginPage;
import pages.Cyclos_HomePage;
import pages.Cyclos_MemProfPage;


public class Data_Validation_Test1 
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp()
	{
		report = new ExtentReports("./Reports/DataValidation.html");
		logger = report.startTest("Data Validation Test Case Report");
		driver = BrowserFactory.getBrowser("firefox");		
		driver.get(DataProviderFactory.getConfig().getAppUrl());
		logger.log(LogStatus.INFO, "Application started");
	}
	
	
	@Test
	public void testDataValidation() throws Exception
	{		
		
		Cyclos_LoginPage home_pg = PageFactory.initElements(driver, Cyclos_LoginPage.class);		
		home_pg.loginToCyclos("admin", "admin");
		
		Cyclos_HomePage login_pg = PageFactory.initElements(driver, Cyclos_HomePage.class);
		Assert.assertTrue(login_pg.isLogoutPresent());
		logger.log(LogStatus.INFO, "Login Successful");			
		
		login_pg.typeMemberFName("Ravikishor");
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);		
		
		Cyclos_MemProfPage memProf_pg = PageFactory.initElements(driver, Cyclos_MemProfPage.class);
		Thread.sleep(3000);
		
		logger.log(LogStatus.PASS, logger.addScreenCapture(Utility.captureScreenShot("Test Data Validated")));
		/*ResultSet rs = Utility.executeSQLQuery("select name, email from members where id=591");		
		
		while(rs.next())
		{
			if(rs.getString("name")==memProf_pg.readMemberName())
			{
				if(rs.getString("email")==memProf_pg.readEmail())
				{
					System.out.println("Name From App. : "+memProf_pg.readMemberLogin());
					System.out.println("Name From DB : "+rs.getString("name"));
					System.out.println("Email From App. : "+memProf_pg.readEmail());
					System.out.println("Email From DB : "+rs.getString("email"));
					break;
				}
			}			
		}*/
				
	}
	
	@AfterMethod
	
	public void tearDown(ITestResult result)
	{
		if (result.getStatus()==ITestResult.FAILURE) 
		{
			Utility.captureScreenShot(driver, result.getName());
		}
		BrowserFactory.closeBrowser(driver);
		
		report.endTest(logger);
		report.flush();
	}
}
