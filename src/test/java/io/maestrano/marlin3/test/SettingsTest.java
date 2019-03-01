package io.maestrano.marlin3.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.maestrano.marlin3.page.ExecutiveDashboardPage;
import io.maestrano.marlin3.page.LoginPage;
import io.maestrano.marlin3.page.SettingsPage;
import io.maestrano.marlin3.test.base.BaseTest;
import io.maestrano.marlin3.utils.Constants;
import io.maestrano.marlin3.utils.DataUtil;

public class SettingsTest extends BaseTest {
	String testName = "SettingsTest";

	@Test(dataProvider = "getData")
	public void settingsTest(Hashtable<String, String> data) throws Exception {
		test = extent.createTest(testName);
		if (DataUtil.isTestExecutable(xls, testName) || data.get("Runmode").equals("N")) {
			throw new SkipException("runmode is set N");
		}
		openBrowser("chrome");
		navigate(Constants.URL_KEY);

		// loging in
		LoginPage loginPage = new LoginPage(driver);
		PageFactory.initElements(driver, loginPage);
		boolean actualResult = loginPage.doLogin(data.get("username"), data.get("password"));
		if (!actualResult) {
			Assert.fail("Login Failed");
		}

		ExecutiveDashboardPage exeDashboardPage = new ExecutiveDashboardPage(driver);
		
		PageFactory.initElements(driver, exeDashboardPage);
		exeDashboardPage.goToSettings();

		Thread.sleep(6000);
		
		SettingsPage settingspage = new SettingsPage(driver);
		
		PageFactory.initElements(driver, settingspage);
		settingspage.goToManageDashboard();
		settingspage.clickOnAddDashboardLink();
		//settingspage.clickonnextbutton();
		Thread.sleep(5000);
		settingspage.clickonnextbutton();
		Thread.sleep(2000);
		settingspage.clickonSavebutton();
		//settingspage.deletedashboardfromSettings();
		
	}

	@DataProvider
	public Object[][] getData() {
		return DataUtil.getData(xls, testName);
	}
}
