package io.maestrano.marlin3.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import io.maestrano.marlin3.page.base.BasePage;
import io.maestrano.marlin3.utils.Constants;



public class MarketplacePage extends BasePage {

	public MarketplacePage(WebDriver baseTestDriver) {

		driver = baseTestDriver;
	}

	@FindBy(xpath = Constants.DASHBOARD_XPATH)
	private WebElement dashboardLink;

	@FindAll(@FindBy(how = How.XPATH, using = Constants.ALLAPPS_XPATH))
	private List<WebElement> allApps;
	
	@FindBy(xpath=Constants.PROCEED_XPATH)
	private WebElement Proceedbtn;
	
	@FindBy(xpath="//input[@name='Email']")
	private WebElement emailtxtfield;
	
	@FindBy(xpath="//input[@name='Password']")
	private WebElement pwdtxtfield;
	
	
	@FindBy(xpath="//button[@name='SignIn']")
	private WebElement siginbtn;
	
	// on marketplace click on dashboard link/button
	public void gotoDashboard() {
		dashboardLink.click();
	}
	
	public void clickProceedbtn() {
		Proceedbtn.click();
	}
	
	
	
	public void doLogin(String uName, String pWord) {
		emailtxtfield.sendKeys(uName);
		pwdtxtfield.sendKeys(pWord);
		siginbtn.click();
	}
	
	/**
	 * checking how many apps are available on page and comparing it to data in excel.
	 * @param numberOfAppsExcel
	 */
	public void verifyNoUnlinkedApps(String numberOfAppsExcel) {

		int numberOfApps = allApps.size();
		if (!(Integer.parseInt(numberOfAppsExcel) == numberOfApps)) {
			Assert.fail("Total number of application do not match");
		}
	}
	
	/**
	 * clicking on the specific app mentioned on excel sheet.
	 * @param appToClick
	 */
	public void clickOnUnlinkedApp(String appToClick) {
		for (WebElement iterable_element : allApps) {
			String appInfo = iterable_element.getText();
			if (appInfo.startsWith(appToClick)) {
				iterable_element.findElements(By.tagName("a")).get(0).click();
			}
		}
	}

}
