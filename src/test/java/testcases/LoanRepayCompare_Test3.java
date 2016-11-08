package testcases;

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
import pages.Cyclos_MyLoansPage;
import pages.Cyclos_UserHomePage;

public class LoanRepayCompare_Test3 
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp()
	{		
		report = new ExtentReports("./Reports/LoanRepayTest.html");
		logger = report.startTest("Data Validation Test Case Report");
		driver = BrowserFactory.getBrowser("firefox");		
		driver.get(DataProviderFactory.getConfig().getAppUrl());
		logger.log(LogStatus.INFO, "Application started");
	}
	
	@Test
	public void testLoanAmountValidation() throws Exception
	{		
		Cyclos_LoginPage home_pg = PageFactory.initElements(driver, Cyclos_LoginPage.class);		
		home_pg.loginToCyclos("32780", "ravi");
		
		Cyclos_UserHomePage usrhm_pg = PageFactory.initElements(driver, Cyclos_UserHomePage.class);		
		Assert.assertTrue(usrhm_pg.isLogoutPresent());
		
		logger.log(LogStatus.INFO, "Login Successful");
		Thread.sleep(2000);
		usrhm_pg.clickOnAccountTab();
		Thread.sleep(2000);
		usrhm_pg.clickOnLoansTab();
		
		Cyclos_MyLoansPage myloan_pg = PageFactory.initElements(driver, Cyclos_MyLoansPage.class);
		myloan_pg.clickSearchImgButton();
		
		Thread.sleep(2000);
		myloan_pg.typeLoanRepayAmount("200");
		myloan_pg.clickOnRepaySubmitButton();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, logger.addScreenCapture(Utility.captureScreenShot("Loan Repay Successful")));		
				
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
