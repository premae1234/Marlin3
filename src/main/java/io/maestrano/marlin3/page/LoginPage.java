package io.maestrano.marlin3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.maestrano.marlin3.page.base.BasePage;
import io.maestrano.marlin3.utils.Constants;



public class LoginPage extends BasePage {

	public LoginPage(WebDriver baseTestDriver) {

		driver = baseTestDriver;
	}

	@FindBy(name = Constants.EMAIL_NAME)
	private WebElement emailEle;

	@FindBy(name = Constants.PASS_NAME)
	private WebElement passEle;

	@FindBy(xpath = Constants.LOGIN_XPATH)
	private WebElement loginBtn;

	public boolean doLogin(String uName, String pWord) {
		emailEle.sendKeys(uName);
		passEle.sendKeys(pWord);
		loginBtn.click();

		boolean elementPrt = isElementPresent(Constants.SIGNOUT_XPATH);

		return elementPrt;

	}

}
