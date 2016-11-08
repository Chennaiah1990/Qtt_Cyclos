package testcases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

import org.openqa.selenium.JavascriptExecutor;
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
import pages.Cyclos_GrantLoan_Page;
import pages.Cyclos_HomePage;
import pages.Cyclos_LoanConfirmPage;
import pages.Cyclos_MemProfPage;

public class LoanAmountValidation_Test2 
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp()
	{		
		report = new ExtentReports("./Reports/LoanAmountTest.html");
		logger = report.startTest("Data Validation Test Case Report");
		driver = BrowserFactory.getBrowser("firefox");		
		driver.get(DataProviderFactory.getConfig().getAppUrl());
		logger.log(LogStatus.INFO, "Application started");
	}
	
	
	@Test
	public void testLoanAmountValidation() throws Exception
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
		logger.log(LogStatus.INFO, "Successfully navigated to Member Profile");
		
		Cyclos_MemProfPage memProf_pg = PageFactory.initElements(driver, Cyclos_MemProfPage.class);
		memProf_pg.clickOnGrantLoanButton();
		logger.log(LogStatus.INFO, "Loan Granted Successfully");
		
		Thread.sleep(2000);
		
		Cyclos_GrantLoan_Page grantLoan_pg  = PageFactory.initElements(driver, Cyclos_GrantLoan_Page.class);
		grantLoan_pg.typeLoanAmount("100000");
		grantLoan_pg.typeIdentifier("Stuart");
		grantLoan_pg.typeRepayDate("26");
		grantLoan_pg.typeDescription("Housing Loan");
		grantLoan_pg.clickOnSubmitButton();
		
		Thread.sleep(3000);
		
		Cyclos_LoanConfirmPage loanconfrm_pg = PageFactory.initElements(driver, Cyclos_LoanConfirmPage.class);
		loanconfrm_pg.clickOnSubmitButton();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, logger.addScreenCapture(Utility.captureScreenShot("Loan Granted Successfully")));
		
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
