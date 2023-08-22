package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase 
{

	String os=System.getProperty("os.name").toLowerCase();


	public static WebDriver driver;
	@BeforeSuite(groups = "regression")
	@Parameters({"browser"})
	public void StartDriver(@Optional("firefox") String browserName )
	{

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
         
		String URL = "https://oyn-adminportal-qc-demo.salmonsky-\r\n"
				+ "1edff179.westeurope.azurecontainerapps.io";
		driver.navigate().to(URL);
		driver.manage().window().maximize();
	}

	@AfterSuite(groups = "regression")
	public void CloseDriver()
	{
		driver.quit();
	}

}