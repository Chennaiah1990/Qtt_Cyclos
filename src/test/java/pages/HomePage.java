package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage 
{
	WebDriver driver;
	
	public HomePage(WebDriver ldriver)
	{
		driver = ldriver;
	}
	
	@FindBy(how=How.XPATH, using="//a[@id='tdb1']/span[text()='Cart']")
	WebElement cartLink; 
	
	@FindBy(how=How.XPATH, using="//a[@id='tdb2']/span[text()='Checkout']")
	WebElement checkoutLink;

	@FindBy(how=How.XPATH, using="//a[@id='tdb3']/span[text()='My Account']")
	WebElement myAccountLink;
	
	@FindBy(how=How.XPATH, using="//div[@class='contentText']//u[text()='login']")
	WebElement logInLink;
	
	public void clickOnCartLink()
	{
		if(cartLink.isDisplayed())
		{
			if(cartLink.isEnabled())
			{
				cartLink.click();
			}
		}
	}
	
	public void clickOnCeckOutLink()
	{
		if(checkoutLink.isDisplayed())
		{
			if(checkoutLink.isEnabled())
			{
				checkoutLink.click();
			}
		}
	}
	
	public void clickOnMyAccount()
	{
		if(myAccountLink.isDisplayed())
		{
			if(myAccountLink.isEnabled())
			{
				myAccountLink.click();
			}
		}
	}
	
	public void clickOnLogIn()
	{
		if(logInLink.isDisplayed())
		{
			if(logInLink.isEnabled())
			{
				logInLink.click();
			}
		}
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}

}
