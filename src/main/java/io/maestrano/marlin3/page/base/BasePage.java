package io.maestrano.marlin3.page.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage  {
	protected WebDriver driver;

	public boolean isElementPresent(String locator) {

		int element = driver.findElements(By.xpath(locator)).size();

		if (element > 0) {
			return true;
		} else {
			return false;
		}

	}

	public void explicit_id(String locator, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);

		wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));

	}

	public void explicit_xpath(String locator, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));

	}

}
