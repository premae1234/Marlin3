package io.maestrano.marlin3.utils;

public class Constants {

public static final String URL_KEY = "https://cbi.chase.com/user/login";

// loginPage
public static final String EMAIL_NAME = "email";
public static final String PASS_NAME = "password";
public static final String LOGIN_XPATH = "//form[@name='form']/div[3]/button";

public static final String SIGNOUT_XPATH = "//*[@data-pt-name='bb_hd_signout']";

// marketplace
public static final String DASHBOARD_XPATH = "//*[@data-pt-name='bb_hd_dashboard']";
public static final String PROCEED_XPATH = "//button[contains(text(),'Proceed')]";
public static final String ALLAPPS_XPATH = "//div/article";

// dashboard
public static final String MARKETPLACE_XPATH = "//*[@data-pt-name='bb_hd_marketplace']";
public static final String DASHBOARD_NAV_XPATH = "//*[@class=\"dashboard-nav\"]";
public static final String ADDDASHBOARD_XPATH = "//*[@data-pt-name=\"bb_hd_close_create_dash\"]";
public static final String ADDDASHBOARDNAME_XPATH = "//*[@placeholder=\"Dashboard's name\"]";
public static final String ADDDASHBOARDBTN_XPATH = "//*[@data-pt-name=\"bb_hd_confirmAddDashboard\"]";
public static final String GETSTARTEDDASHBOARD_XPATH = "//*[@data-pt-name=\"bb_lnk_getstarted\"]";
public static final String ADDMODULESDASHBOARD_XPATH = "//a[contains(text(),'Add module')]";
public static final String SELECTMODULES_XPATH = "//*[@class=\"tile\"]";
public static final String ADDSELECTEDMODULES_XPATH = "//*[text()='Add to dashboard']";
public static final String HIDEADDMODULES_XPATH = "//*[@data-pt-name=\"bb_ft_collapseaddmodule\"]";
public static final String ADDKPI_XPATH = "//*[@data-pt-name=\"bb_mm_more_dashboard_kpi\"]";
public static final String ALLKPI_XPATH = "//li/ul/li[@class=\"ng-star-inserted\"]";
public static final String KPITIMEPERIOD_NAME = "timePeriod";
public static final String DONEKPI_XPATH = "//*[text()='Done']";
public static final String SAVE_XPATH = "//*[text()='Save']";
public static final String SETTINGSICON_XPATH = "//a[@data-pt-name=\"bb_hd_settings\"]";

//all dashboards path

public static final String ALLDASHBOARDS_XPATH = "//nav[contains(@class,'dash-nav')]";


// dashboard options
public static final String DASHBOARDOPTIONS_XPATH = "//*[@data-pt-name=\"bb_mm_more\"]";
public static final String HIDEBUSINESSMETRIC_XPATH = "//a[@data-pt-name='bb_mm_more_hidemetrics']";

public static final String EDITDASHBOARD_XPATH = "//a[contains(@class,'px-3 py-3  d-block pointer chaseanalytics')]";

public static final String SELECTEDKPI_XPATH =("(//*[@data-icon='minus-circle'])[2]");

public static final String DELETEDASHBOARD_XPATH = "//*[@data-pt-name=\"MarlinDashboardDelete\"]";
public static final String DELETEDASHBOARDCONFIRM_XPATH = "//*[contains(text(),'Delete \"${dashboardname}\"')]";


public static final String DASHBOARDNAME_XPATH = "//*[contains(text(),'${dashboardname}')]";


public static final String CASHONHAND_XPATH = "//*[@class=\"kpi-name\"]";
public static final String CASHONHANDVALUE_XPATH = "//*[@class=\"kpi-value\"]";


// quickbooks login
public static final String QUICKBOOKSUSERNAME_ID = "ius-userid";
public static final String QUICKBOOKSPASSWORD_ID = "ius-password";
public static final String QUICKBOOKSSIGNINBTN_ID = "ius-sign-in-submit-btn";

// Settings


public static final String MANAGEDASHBOARDS_XPATH = "//p[text()='Manage my dashboard']";
		//"//*[@data-pt-name=\"bb_hd_dashboardmanagement\"]/p";
public static final String ADDDASHBOARD2_XPATH ="//p[contains(text(),'Add dashboard')]";

// "(//nav[@class='utility-nav ml-auto d-flex justify-content-end
// align-items-center']//span[@class='ng-star-inserted'])";

// config
public static String REPORTS_PATH = System.getProperty("user.dir") + "/Reports/";
public static String DATA_XLS_PATH = System.getProperty("user.dir") + "/Data.xlsx";
public static String CHROMEDRIVER_EXE = "/Users/premalathaeddyam/eclipse-workspace/chromedriver";
public static String DATA_XLS_SHEET = "Data";
public static String TESTCASE_XLS_SHEET = "Testcases";
public static String RUNMODE_XLS = "Runmode";
public static String TESTCASENAME_XLS = "TestCaseName";

}
