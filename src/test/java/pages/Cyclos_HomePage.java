package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Cyclos_HomePage 
{
	WebDriver driver;
	
	public Cyclos_HomePage(WebDriver ldriver)
	{
		driver = ldriver;
	}

	@FindBy(how=How.CSS, using="#menu15 > span.menuText")
	WebElement logout_ele;
	
	@FindBy(how=How.ID, using="memberName")
	WebElement mem_prof_fname;
	
	public boolean isLogoutPresent()
	{
		return logout_ele.isDisplayed();
	}
	
	public void typeMemberFName(String name)
	{
		mem_prof_fname.sendKeys(name);
	}
}
