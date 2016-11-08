package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Cyclos_MyLoansPage 
{
WebDriver driver;
	
	public Cyclos_MyLoansPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[4]/img")
	WebElement search_imgbutton;
	
	@FindBy(how=How.XPATH, using="//input[@id='amountText']")
	WebElement loanrepay_amt;
	
	@FindBy(how=How.XPATH, using="//*[@id='repayForm']//input[@type='submit']")
	WebElement loanrepay_submit;
	
	

	public void clickSearchImgButton()
	{
		search_imgbutton.click();
	}
	
	public void typeLoanRepayAmount(String amt)
	{
		loanrepay_amt.clear();
		loanrepay_amt.sendKeys(amt);
	}

	public void clickOnRepaySubmitButton()
	{
		loanrepay_submit.click();
	}
}
