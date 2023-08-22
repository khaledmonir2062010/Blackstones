package tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home_Page;
import pages.Login_Page;

public class TC_1 extends TestBase{
	
	Login_Page Loginobj;
	Home_Page Homeobj;
	
	String Expected_HomePageURL=
			"https://oyn-adminportal-qc-demo.salmonsky-1edff179.westeurope.azurecontainerapps.io/admin/dashboard";

	@Test(priority = 1)
	public void Successfull_Login() throws InterruptedException {
		
		//Step_1: Enter the email and password to login
		Loginobj=new Login_Page(driver);
		Loginobj.SiginProcess("store@admin.com", "P@ssw0rd");
		
		//Step_2: Wait for the dash board to be displayed
		Homeobj =new Home_Page(driver);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOf(Homeobj.DashboardHeader));
		
		//Step_3: Assertion to check the redirected page is displayed correctly per business flow
		Assert.assertEquals(Expected_HomePageURL, driver.getCurrentUrl());
		System.out.println("Page Title is " + driver.getTitle());
		
	}
	
	
	String Expected_LoginPage="https://oyn-adminportal-qc-demo.salmonsky-1edff179.westeurope.azurecontainerapps.io/identity/login";
	@Test(priority = 2,dependsOnMethods = {"Successfull_Login"})
	public void Successfull_Logout() throws InterruptedException {
		Homeobj=new Home_Page(driver);
		
		//Step_1: Click on profile
		Homeobj.OpenProfilemenu();
		
		//Step_2: Click on Logout link
		Homeobj.Logout();
		
		Loginobj=new Login_Page(driver);
		
		//Step_3: Waiting Condition to wait for the success message to be displayed
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(Loginobj.successLogoutMsg));
		
		//Step_4: Assertion to check the redirected page is displayed correctly per business flow
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals(Expected_LoginPage, driver.getCurrentUrl());
	}

}
