package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends PageBase {

	public Login_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Login Page Element Locators//
	@FindBy(id = "mat-input-0")
	WebElement Email_TxtField;
	
	@FindBy(id="mat-input-1")
	WebElement Password_TxtField;
	
	@FindBy(css =".block")
	WebElement Signin_btn;
	
	//Login Function//
	public void SiginProcess(String Email, String Pass)
	{
		
		SetText(Email_TxtField, Email);
		SetText(Password_TxtField, Pass);
		click_button(Signin_btn);
	}

}
