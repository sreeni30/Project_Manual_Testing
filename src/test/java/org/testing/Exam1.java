package org.testing;

import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utilities.BaseClass;
import org.utilities.LoginPojo;


public class Exam1 extends BaseClass {
	@BeforeClass
	private void browserLaunch() {
		launchChrome();
		winMax();

	}

	@AfterClass
	private void browserClose() {
//		closeBrowser();

	}

	@BeforeMethod
	private void startTime() {
		openUrl("https://www.facebook.com/");
		Date d = new Date();
		System.out.println("Start Time:" + d);
	}

	@AfterMethod
	private void endTime() {
		Date d = new Date();
		System.out.println("End Time:" + d);

	}

	@Test
	private void tc1() {
		LoginPojo l = new LoginPojo();
		fill(l.getTxtUser(), "Mathi");
		fill(l.getTxtPass(), "Mathi@123");
		btnClick(l.getBtnLogin());
		System.out.println("Success");
	}
}
