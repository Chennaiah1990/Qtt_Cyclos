package testcases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;

public class VerifyHomePage 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver = BrowserFactory.getBrowser("firefox");
		
		driver.get(DataProviderFactory.getConfig().getAppUrl());
	}
	
	
	@Test
	public void testHomePage()
	{		
		HomePage home_pg = PageFactory.initElements(driver, HomePage.class);
		
		Assert.assertTrue(home_pg.getPageTitle().contains("GCR Shop"));
		
		//System.out.println("Test Case Passed");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}

}
