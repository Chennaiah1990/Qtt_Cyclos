package testcases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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
import pages.CatalogPage;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPage 
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp()
	{
		report = new ExtentReports("./Reports/VerifyLoginPage.html");		
		logger = report.startTest("Verify Login Page");
		
		driver = BrowserFactory.getBrowser("firefox");		
		driver.get(DataProviderFactory.getConfig().getAppUrl());
		logger.log(LogStatus.INFO, "Application is up & running");
	}
	
	
	@Test
	public void testHomePage() throws Exception
	{		
		HomePage home_pg = PageFactory.initElements(driver, HomePage.class);
		
		Assert.assertTrue(home_pg.getPageTitle().contains("GCR Shop"));		
		logger.log(LogStatus.PASS, "Page Title Veified");
		
		home_pg.clickOnLogIn();
		logger.log(LogStatus.INFO, "clicked on Log In Button");
		
		//System.out.println("Test Case Passed");
		
		LoginPage login_pg = PageFactory.initElements(driver, LoginPage.class);		
		login_pg.typeUserName("rahman1237@gmail.com");		
		login_pg.typePassword("abcd123");		
		login_pg.clickOnSigIn();		
		logger.log(LogStatus.INFO, "Loged in successfully");
		
		CatalogPage Cat_pg = PageFactory.initElements(driver, CatalogPage.class);
		
		Assert.assertTrue(Cat_pg.isLogOffLinkPresent());
		logger.log(LogStatus.PASS, logger.addScreenCapture(Utility.captureScreenShot(driver, "LoginVerified")));
		//logger.log(LogStatus.PASS, "Login Verified" );
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path = Utility.captureScreenShot(driver, result.getName());
			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}

}
