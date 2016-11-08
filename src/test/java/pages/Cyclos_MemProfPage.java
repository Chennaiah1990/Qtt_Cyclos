package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Cyclos_MemProfPage 
{
	WebDriver driver;
	
	public Cyclos_MemProfPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='groupText']")
	WebElement perm_grmp_name;
	
	@FindBy(how=How.XPATH, using="//input[@id='loginText']")
	WebElement last_login;
	
	@FindBy(how=How.CSS, using=".medium.InputBoxDisabled.required")
	WebElement mem_login;
	
	@FindBy(how=How.XPATH, using=".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/input")
	WebElement mem_name;
	
	@FindBy(how=How.XPATH, using=".//*[@id='tdContents']/form/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/input")
	WebElement email;
	
	@FindBy(how=How.XPATH, using=".//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[8]/td/fieldset/table/tbody/tr[1]/td[4]/input")
	WebElement grantLoan_button;
	
	public String readPermissionGroup()
	{
		return perm_grmp_name.getAttribute("value");
	}
	

	public String readLastLogin()
	{
		return last_login.getAttribute("value");
	}
	
	public String readMemberLogin()
	{
		return mem_login.getAttribute("value");
	}
	
	public String readMemberName()
	{
		return mem_name.getAttribute("value");
	}
	
	public String readEmail()
	{
		return email.getAttribute("value");
	}
	
	public void clickOnGrantLoanButton()
	{
		grantLoan_button.click();
	}
	
}
