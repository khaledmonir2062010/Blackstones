package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page extends PageBase {

	public Home_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Element For Dash board Header//
	@FindBy(css=".breadcrumb > p")
	public WebElement DashboardHeader;
	
	//Element For The profile Icon//
	@FindBy(css = ".user > img")
	WebElement Profile_icon;

	//Element For the logout link//
	@FindBy(css = ".dropdown > li:nth-child(3)")
	WebElement Logout_link;
	
	
	
	//Method for clicking on the profile menu//
	public void OpenProfilemenu()
	{
		
		click_button(Profile_icon);
	}
	
	
	//Method for logging out/	
	public void Logout()
	{
		
		click_button(Logout_link);
	}
}
