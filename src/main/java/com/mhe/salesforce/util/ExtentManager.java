package com.mhe.salesforce.util;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;
	public static String fileName;
	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d = new Date();
			fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
			String reportPath =WebConnector.REPORTS_PATH + fileName;
			extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir") + "//ReportsConfig.xml"));
			extent.addSystemInfo("Selenium Version", "4.1.1").addSystemInfo("Environment", "US_UAT")
					.addSystemInfo("Browser", "Chrome 103.0.5060.114");
		}
			
		return extent;
	}
}
