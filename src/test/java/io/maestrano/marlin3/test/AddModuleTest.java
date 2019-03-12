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
import io.maestrano.marlin3.test.base.BaseTest;
import io.maestrano.marlin3.utils.Constants;
import io.maestrano.marlin3.utils.DataUtil;



public class AddModuleTest extends BaseTest {
	String testName = "AddModuleTest";

	@Test(dataProvider = "getData")
	public void doLogin(Hashtable<String, String> data) throws Exception {
		
		test = extent.createTest(testName);
		
		
		if (DataUtil.isTestExecutable(xls, testName) || data.get("Runmode").equals("N")) {
			throw new SkipException("runmode is set N");
		}
		openBrowser("chrome");
		navigate(Constants.URL_KEY);
		
		//loging in
		LoginPage loginPage = new LoginPage(driver);
		PageFactory.initElements(driver, loginPage);
		boolean actualResult = loginPage.doLogin(data.get("username"), data.get("password"));
		if (!actualResult) {
			AssertJUnit.fail("Login Failed");
		}
		                              
		ExecutiveDashboardPage exedashPage = new ExecutiveDashboardPage(driver);
		PageFactory.initElements(driver, exedashPage);
		
		
		
		exedashPage.addDashboard(data.get("DashboardName"));
		Thread.sleep(2000);
		exedashPage.addModulesDashboard();
	    Thread.sleep(2000);                                                                    
		exedashPage.addtoSelectDashboard(data.get("ModuleName"),data.get("KPIName"),data.get("TimePeriod"),data.get("ComparisonTime"));
		 

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = DataUtil.getData(xls, testName);

		return data;
	}

}
