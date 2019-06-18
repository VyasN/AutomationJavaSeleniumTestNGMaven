/**
 * 
 */
package com.automationpractice.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author nartan.vyas
 *
 */

//Page which contains methods and elements which may be used by all page classes
public class PageSetup {

	public WebDriver driver;
	public Actions mouseHover;
	public WebDriverWait wait;

	public PageSetup(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.mouseHover = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Wait for element to be present/visible
	 * 
	 * @param element WebElement
	 * @throws InterruptedException
	 */
	public void waitTillElementIsVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Wait for element to be click-able
	 * 
	 * @param element WebElement
	 * @throws InterruptedException
	 */
	public void waitTillElementIsClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Check element is display or enabled if yes then return else wait for 500
	 * milliseconds, again it will check as above.
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitTillelementIsDisplayedOrEnabled(WebElement element) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			Thread.sleep(500);
			if (element.isDisplayed() || element.isEnabled()) {
				break;
			}
		}

	}
}
