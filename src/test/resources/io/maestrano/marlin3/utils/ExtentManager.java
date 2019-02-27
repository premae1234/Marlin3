package io.maestrano.marlin3.utils;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
 

public class ExtentManager {
	private static ExtentReports extent;
	private static ExtentHtmlReporter htmlReporter;

	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d = new Date();
			String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
			String reportPath = Constants.REPORTS_PATH + fileName;

			htmlReporter = new ExtentHtmlReporter(reportPath);
			
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			
			
		}
		return extent;
	}
}
