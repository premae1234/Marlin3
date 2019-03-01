package io.maestrano.marlin3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.maestrano.marlin3.page.base.BasePage;
import io.maestrano.marlin3.utils.Constants;

public class SettingsPage extends BasePage {

	public SettingsPage(WebDriver baseTestDriver) {

		driver = baseTestDriver;
	}

	@FindBy(xpath = Constants.MANAGEDASHBOARDS_XPATH)
	private WebElement manageDashboard;
	

	@FindBy(xpath = Constants.ADDDASHBOARD2_XPATH)
	private WebElement adddashboard2;

	@FindBy(xpath = Constants.DELETEDASHBOARD1_XPATH)
	private WebElement deletedashboardfromsetting;

	@FindBy(xpath = Constants.NEXTBUTTON_XPATH)
	private WebElement nextbutton;

	
	@FindBy(xpath = Constants.SAVE1_XPATH)
	private WebElement savebutton;
	
	
	public void goToManageDashboard() {

		explicit_xpath(Constants.MANAGEDASHBOARDS_XPATH, 50);
		manageDashboard.click();

	}
	public void clickOnAddDashboardLink() {

		explicit_xpath(Constants.ADDDASHBOARD2_XPATH, 50);
		adddashboard2.click();


}
	
	public void clickonnextbutton() {
		nextbutton.click();
	}
	
	public void clickonSavebutton() {
		savebutton.click();
	}
	
	/*public void deletedashboardfromSettings() {
		deletedashboardfromsetting.click();
		
	
}*/
}