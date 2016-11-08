package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Cyclos_UserHomePage 
{
	WebDriver driver;
	
	public Cyclos_UserHomePage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	@FindBy(how=How.XPATH,using="//ul[@id='menuContainer']/li[7]/span[2]")
	WebElement logout;
	
	@FindBy(how=How.XPATH, using="//ul[@id='menuContainer']/li[3]/span[2]")
	WebElement account_tab;
	
	@FindBy(how=How.XPATH, using="//li[@id='submenu2.3']/span[text()='Loans']")
	WebElement loans_tab;
	
	public void clickOnAccountTab()
	{
		account_tab.click();
	}
	
	public void clickOnLoansTab()
	{
		loans_tab.click();
	}
	
	public boolean isLogoutPresent()
	{
		return logout.isDisplayed();
	}
}
