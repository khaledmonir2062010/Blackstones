package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page extends PageBase {

	public Home_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = ".user > img")
	WebElement Profile_icon;

	
	@FindBy(css = ".dropdown > li:nth-child(3)")
	WebElement Logout_link;
	
	public void OpenProfilemenu()
	{
		
		click_button(Profile_icon);
	}
	
	public void Logout()
	{
		
		click_button(Logout_link);
	}
}
