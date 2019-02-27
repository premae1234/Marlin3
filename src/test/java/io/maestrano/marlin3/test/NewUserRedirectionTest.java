package io.maestrano.marlin3.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.maestrano.marlin3.page.LoginPage;
import io.maestrano.marlin3.page.MarketplacePage;
import io.maestrano.marlin3.page.QuickBooksLoginPage;
import io.maestrano.marlin3.test.base.BaseTest;
import io.maestrano.marlin3.utils.Constants;
import io.maestrano.marlin3.utils.DataUtil;

public class NewUserRedirectionTest extends BaseTest {
	String testName = "NewUserRedirectionTest";

	@Test(dataProvider = "getData")
	public void doLogin(Hashtable<String, String> data) throws InterruptedException {
		test = extent.createTest(testName);
		if (DataUtil.isTestExecutable(xls, testName) || data.get("Runmode").equals("N")) {
			throw new SkipException("runmode is set N");
		}
		openBrowser("chrome");
		navigate(Constants.URL_KEY);

		// logging in
		LoginPage loginPage = new LoginPage(driver);
		PageFactory.initElements(driver, loginPage);
		boolean actualResult = loginPage.doLogin(data.get("username"), data.get("password"));
		if (!actualResult) {
			AssertJUnit.fail("Login Failed");
		}

		// going to dashboard
		MarketplacePage marketplacePage = new MarketplacePage(driver);
		PageFactory.initElements(driver, marketplacePage);

		marketplacePage.verifyNoUnlinkedApps(data.get("TotalNoApps"));

		marketplacePage.clickOnUnlinkedApp(data.get("ApptoConnect"));

		marketplacePage.clickProceedbtn();

		Thread.sleep(3000);
		QuickBooksLoginPage quickbooksSigninPage = new QuickBooksLoginPage(driver);
		PageFactory.initElements(driver, quickbooksSigninPage);
		quickbooksSigninPage.loginToQuickbooks("prema.eddyam+auto+newuser@maestrano.com", "Password1!");

	}

	@DataProvider
	public Object[][] getData() {
		return DataUtil.getData(xls, testName);
	}
}
