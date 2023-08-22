package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

	protected WebDriver driver;

	public PageBase(WebDriver driver)
	{

		PageFactory.initElements(driver, this);

	}

	protected static void click_button(WebElement button)
	{
		button.click();
	}

	protected String getText(WebElement element) { return element.getText(); }

	public String getAttribute(WebElement element) { return element.getAttribute("value"); }


	//Method for set text
	protected static void SetText(WebElement textElement, String value)
	{
		textElement.sendKeys(value);
	}

	//Method for clear Text
	public void clearText(WebElement element) 
	{
		element.clear();
	}

}