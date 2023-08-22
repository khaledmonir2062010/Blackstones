package tests;

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
		Loginobj=new Login_Page(driver);
		Loginobj.SiginProcess("store@admin.com", "P@ssw0rd");
		Thread.sleep(8000);
		Assert.assertEquals(Expected_HomePageURL, driver.getCurrentUrl());
		System.out.println("Page Title is " + driver.getTitle());
		
	}
	
	
	String Expected_LoginPage="https://oyn-adminportal-qc-demo.salmonsky-1edff179.westeurope.azurecontainerapps.io/identity/login";
	@Test(priority = 2,dependsOnMethods = {"Successfull_Login"})
	public void Successfull_Logout() throws InterruptedException {
		Homeobj=new Home_Page(driver);
		Homeobj.OpenProfilemenu();
		Thread.sleep(3000);
		Homeobj.Logout();
		Assert.assertEquals(Expected_LoginPage, driver.getCurrentUrl());
	}

}
