package io.maestrano.marlin3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.maestrano.marlin3.page.base.BasePage;
import io.maestrano.marlin3.utils.Constants;



public class QuickBooksLoginPage extends BasePage{

	public QuickBooksLoginPage(WebDriver baseTestDriver) {
		
		driver = baseTestDriver;
	}
	@FindBy(id = Constants.QUICKBOOKSUSERNAME_ID)
	private WebElement username;
	
	@FindBy(id = Constants.QUICKBOOKSPASSWORD_ID)
	private WebElement password;
	
	@FindBy(id = Constants.QUICKBOOKSSIGNINBTN_ID)
	private WebElement signin;
	
	
	//click on marketplace button
	public void loginToQuickbooks(String user, String pass) {
		
		explicit_id(Constants.QUICKBOOKSUSERNAME_ID, 50);
		
		//Set<String> windows = driver.getWindowHandles();

		//String secondWindow = new ArrayList<>(windows).;
		//driver.switchTo().window(secondWindow);
		username.sendKeys(user);
		password.sendKeys(pass);
		
		signin.click();
		
	}
}