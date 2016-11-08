package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='bodyContent']//input[@name='email_address']" )
	WebElement username;
	
	@FindBy(how=How.XPATH, using="//div[@id='bodyContent']//input[@name='password']")
	WebElement password;
	
	@FindBy(how=How.XPATH, using="//button[@id='tdb5']")
	WebElement signInButton;
	
	public void typeUserName(String user)
	{
		if(username.isDisplayed())
		{
			if(username.isEnabled())
			{
				username.clear();
				username.sendKeys(user);
			}
		}
	}
	
	public void typePassword(String pass)
	{
		if(password.isDisplayed())
		{
			if(password.isEnabled())
			{
				password.clear();
				password.sendKeys(pass);
			}
		}
	}
	
	public void clickOnSigIn()
	{
		if(signInButton.isDisplayed())
		{
			if(signInButton.isEnabled())
			{
				signInButton.click();
			}
		}
	}
}
