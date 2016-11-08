package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Cyclos_LoginPage 
{
	WebDriver driver;
	
	public Cyclos_LoginPage(WebDriver ldriver) 
	{
		this.driver = ldriver;
	}
	
	@FindBy(how=How.XPATH, using ="//input[@id='cyclosUsername']")
	WebElement login_name;
	
	@FindBy(how=How.ID, using="cyclosPassword")
	WebElement login_password;
	
	@FindBy(how=How.XPATH, using="//table[@class='nested']//input[@class='button']")
	WebElement login_btton;
	
	public void typeUserName(String uname)
	{
		login_name.sendKeys(uname);
	}
	
	public void typePassword(String pass)
	{
		login_password.sendKeys(pass);
	}
	
	public void clickOnLoginButton()
	{
		login_btton.click();
	}
	
	public void loginToCyclos(String uname, String pass)
	{
		login_name.sendKeys(uname);
		login_password.sendKeys(pass);
		login_btton.click();
	}
	
}
