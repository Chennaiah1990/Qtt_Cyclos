package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Cyclos_GrantLoan_Page 
{
	WebDriver driver;
	
	public Cyclos_GrantLoan_Page(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='amount']")
	WebElement amount_field;
	
	@FindBy(how=How.XPATH, using="//input[@class='small InputBoxEnabled']")
	WebElement identifier_field;

	@FindBy(how=How.XPATH, using="//input[starts-with(@id,'_id14784')]")
	WebElement repay_date_field;
	
	@FindBy(how=How.XPATH, using="//textarea[@id='description']")
	WebElement desc_field;
	
	@FindBy(how=How.XPATH, using="//img[@id='calendarTrigger0']")
	WebElement calen_icon;
	
	@FindBy(how=How.XPATH, using="//table[@class='defaultTable']//input[@value='Submit']")
	WebElement submit_button;
	
	
	public void typeLoanAmount(String amt)
	{
		amount_field.sendKeys(amt);
	}
	
	public void typeIdentifier(String iden_name)
	{
		amount_field.sendKeys(iden_name);
	}
	
	public void typeDescription(String desc)
	{
		desc_field.sendKeys(desc);
	}
	
	public void clickOnSubmitButton()
	{
		submit_button.click();
	}
	public void typeRepayDate(String date)
	{
		try
		{
			calen_icon.click();
			Thread.sleep(2000);
			List<WebElement> alldates = driver.findElements(By.xpath("//body[@class='main']/div[5]//td"));
			
			for(WebElement dt : alldates)
			{
				if(dt.getText().contentEquals(date))
				{
					dt.click();
					break;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	
}
