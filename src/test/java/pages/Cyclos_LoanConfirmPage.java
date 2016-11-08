package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Cyclos_LoanConfirmPage 
{
	WebDriver driver;
	
	public Cyclos_LoanConfirmPage(WebDriver ldriver)
	{
		this.driver = ldriver;		
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='tdContents']//input[@type='submit']")
	WebElement submit_button;
	
	public void clickOnSubmitButton()
	{
		submit_button.click();
	}
}
