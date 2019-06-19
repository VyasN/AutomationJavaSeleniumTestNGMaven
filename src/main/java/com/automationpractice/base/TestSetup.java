/**
 * 
 */
package com.automationpractice.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automationpractice.pagefactory.Accounts;
import com.automationpractice.pagefactory.Products;
//import com.github.javafaker.Faker;
import com.google.common.io.Files;

/**
 * @author nartan.vyas
 *
 */

//TestSetup contains common methods and elements which may be used by all or most of the test cases or suites

public class TestSetup {

	public static ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<WebDriver>();;
	public static String resultPath = Paths.get(System.getProperty("user.dir"), "results").toString();
	// If you are using Virtual Machine please pass IP address of VM instead local
	// host
	public String url = System.getenv("URL") != null ? System.getenv("URL") : "http://automationpractice.com";
	public WebDriver driver;
	public WebDriverWait wait;
	public Credential credential;
	public Products products;
	public Accounts accounts;

	public String currentTime() {
		return Long.toString(System.currentTimeMillis());
	}

	/**
	 * @return the {WebDriver} for the current thread
	 */
	public synchronized static WebDriver getDriver() {
		return threadSafeDriver.get();
	}

	/**
	 * Creates a web driver that is thread safe check if grid is running on given
	 * URL if not execute chrome driver
	 * 
	 * @return getDriver()
	 */
	public WebDriver createDriver() {
		String grid = System.getenv("GRID");
		if (grid != null) {
			try {
				URL node = new URL("http://selenium.grid.com/wd/hub");
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.LINUX);
				threadSafeDriver.set(new RemoteWebDriver(node, cap));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else {
			threadSafeDriver.set(new ChromeDriver());
		}

		return getDriver();
	}

	/**
	 * Kill the browser if exist
	 */
	public void quitBrowser() {
		if (getDriver() != null) {
			getDriver().quit();
		} else {
			driver.quit();
		}
	}

	/**
	 * Take screenshot without providing a filename. Uses current time as filename
	 * 
	 * @return the location of the screenshot
	 */
	public static String takeScreenshot() {
		return takeScreenshot(Long.toString(System.currentTimeMillis()));
	}

	/**
	 * Take screenshot
	 * 
	 * @param filename filename you wanted for the screenshot
	 * @return the location of the screenshot
	 */
	public static String takeScreenshot(String filename) {
		File destFile = Paths.get(resultPath, filename + ".png").toFile();

		try {
			File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			Files.copy(srcFile, destFile);
		} catch (IOException e) {

		}

		return destFile.toString();
	}

}
