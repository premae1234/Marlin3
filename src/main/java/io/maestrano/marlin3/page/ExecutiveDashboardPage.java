package io.maestrano.marlin3.page;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.maestrano.marlin3.page.base.BasePage;
import io.maestrano.marlin3.utils.Constants;


public class ExecutiveDashboardPage extends BasePage {

	public ExecutiveDashboardPage(WebDriver baseTestDriver) {

		driver = baseTestDriver;
	}

	@FindBy(xpath = Constants.MARKETPLACE_XPATH)
	private WebElement marketplaceLink;

	@FindBy(xpath = Constants.DASHBOARD_NAV_XPATH)
	private WebElement dashboardNav;

	@FindBy(xpath = Constants.ADDDASHBOARD_XPATH)
	private WebElement addDashboard;

	@FindBy(xpath = Constants.ADDDASHBOARDNAME_XPATH)
	private WebElement addDashboardName;

	@FindBy(xpath = Constants.ADDDASHBOARDBTN_XPATH)
	private WebElement addDashboardBtn;

	@FindBy(xpath = Constants.GETSTARTEDDASHBOARD_XPATH)
	private WebElement getStartedDashboard;

	@FindBy(xpath = Constants.ADDMODULESDASHBOARD_XPATH)
	private WebElement addModules;

	@FindAll(@FindBy(how = How.XPATH, using = Constants.SELECTMODULES_XPATH))
	private List<WebElement> selectModules;

	@FindBy(xpath = Constants.ADDSELECTEDMODULES_XPATH)
	private WebElement addSelectedModules;

	@FindBy(xpath = Constants.HIDEADDMODULES_XPATH)
	private WebElement hideModules;

	@FindBy(xpath = Constants.ADDKPI_XPATH)
	private WebElement addKpi;

	@FindAll(@FindBy(how = How.XPATH, using = Constants.ALLKPI_XPATH))
	private List<WebElement> allKpi;

	@FindBy(xpath = Constants.DONEKPI_XPATH)
	private WebElement doneKPI;

	@FindBy(xpath = Constants.SAVE_XPATH)
	private WebElement saveModules;

	@FindBy(name = Constants.KPITIMEPERIOD_NAME)
	private WebElement kpiTimePeriod;

	@FindBy(xpath = Constants.SETTINGSICON_XPATH)
	private WebElement settingsIcon;

	@FindBy(xpath = Constants.DASHBOARDOPTIONS_XPATH)
	private WebElement dashboartOptions;

	@FindBy(xpath = Constants.DELETEDASHBOARD_XPATH)
	private WebElement deleteDashboard;

	@FindBy(xpath = Constants.HIDEBUSINESSMETRIC_XPATH)
	private WebElement hidebusinessmetric;

	@FindBy(xpath = Constants.EDITDASHBOARD_XPATH)
	private WebElement editdashboard;

	@FindBy(xpath = Constants.SELECTEDKPI_XPATH)
	private WebElement kpitodelete;

	@FindBy(xpath = Constants.SIGNOUT_XPATH)
	private WebElement signOut;

	@FindBy(xpath = Constants.CASHONHANDVALUE_XPATH)
	private WebElement cashValue;

	@FindBy(xpath = Constants.ALLDASHBOARDS_XPATH)
	private WebElement alldashboards;

	public void displayAllDashboards() {

		List<WebElement> dashboardCount = driver.findElements(By.xpath("//a[contains(@data-pt-name,'dashboardnav')]"));
		System.out.println(dashboardCount.size());

		for (WebElement dashboardname : dashboardCount) {

			System.out.println(dashboardname.getText());

			/*
			 * if (!dashboardname.equals("Invoices")) { //Thread.sleep(3000);
			 * dashboardname.click(); }
			 */
		}

	}

	public void displayAllKPIs() {

		List<WebElement> allKPIs = driver.findElements(By.xpath("//div[contains(@class,'kpi-item d-flex ')]"));

		System.out.println(allKPIs.size());

		for (WebElement dashboardname : allKPIs) {

			System.out.println(dashboardname.getText());

		}

	}

	public void compareCashValue(String Cash) {

		System.out.println(cashValue.getText());

		// System.out.println(Cash);

		if (cashValue.getText().equals(Cash)) {

			System.out.println(true);

		}
	}

	public void deleteDashboard() {

		Actions act = new Actions(driver);
		act.moveToElement(dashboartOptions);
		act.moveToElement(deleteDashboard);
		act.click(deleteDashboard).build().perform();

	}

	public void deleteKPI() throws InterruptedException {

		Actions act = new Actions(driver);
		act.moveToElement(dashboartOptions);
		act.moveToElement(editdashboard);
		act.click(editdashboard).build().perform();
		Thread.sleep(7000);
		kpitodelete.click();

	}

	public void hideBusinessMetric() {

		Actions act = new Actions(driver);
		act.moveToElement(dashboartOptions);
		act.moveToElement(hidebusinessmetric);
		act.click(hidebusinessmetric).build().perform();

	}

	// click on marketplace button
	public void gotoMarketplace() {
		marketplaceLink.click();
	}

	public void addDashboard(String name) {

		addDashboard.click();
		addDashboardName.sendKeys(name);
		addDashboardBtn.click();

	}

	public void addModulesDashboard() {

		getStartedDashboard.click();
		addModules.click();

	}

	public void goToSettings() {

		explicit_xpath(Constants.SETTINGSICON_XPATH, 15);
		settingsIcon.click();
	}

	public void addtoSelectDashboard(String ModuleName, String KPIName, String timePeriod) throws InterruptedException {

		for (WebElement webElement : selectModules) {

			if (webElement.getText().equals(ModuleName)) {
				webElement.click();
				addSelectedModules.click();
				break;
			}

		}
		hideModules.click();

		addKpi.click();
		Thread.sleep(3000);

		for (WebElement webElement : allKpi) {
			System.out.println(webElement.getText());
			if (webElement.getText().contains(KPIName)) {
				Thread.sleep(3000);
				webElement.click();

				kpiTimePeriod.sendKeys(timePeriod);
				Thread.sleep(2000);
				doneKPI.click();
				break;
			}
		}

		saveModules.click();
	}

	public void signOut() {
		signOut.click();
	}

}
