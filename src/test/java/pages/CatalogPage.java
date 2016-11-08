package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage 
{
	WebDriver driver;
	
	public CatalogPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	@FindBy(how=How.XPATH, using="//a[@id='tdb4']/span")
	WebElement logOffLink;
	
	public boolean isLogOffLinkPresent()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(logOffLink));
		
		return logOffLink.isEnabled();
	}

}
