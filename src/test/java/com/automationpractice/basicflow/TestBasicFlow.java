package com.automationpractice.basicflow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationpractice.base.Credential;
import com.automationpractice.base.TestSetup;
import com.automationpractice.pagefactory.Accounts;
import com.automationpractice.pagefactory.Products;
import com.automationpractice.pagefactory.fakerData;

//Test cases 
public class TestBasicFlow extends TestSetup implements fakerData {
	@Test()
	public void selectChiffonDress() throws InterruptedException {
		products.waitTillElementIsVisible(products.headerTabHover);
		products.mouseHover.moveToElement(products.headerTabHover).build().perform();
		products.waitTillElementIsClickable(products.linkSummerDress);
		products.linkSummerDress.click();
		products.waitTillelementIsDisplayedOrEnabled(products.imageContainerChifforDressHover);
		products.mouseHover.moveToElement(products.imageContainerChifforDressHover).build().perform();
		products.buttonAjaxQuickView.click();
		driver.switchTo().frame(products.iframeFancyBoxLayer);
		products.waitTillElementIsClickable(products.buttonAddToCart);
		products.selectDDOptionByValue(products.dropDownDressSize, "2");
		products.waitTillElementIsClickable(products.buttonAddToCart);
		products.mouseHover.moveToElement(products.buttonAddToCart).click().perform();
		driver.switchTo().defaultContent();
		products.waitTillElementIsVisible(products.linkContinueShoppingLayer.get(0));
		products.mouseHover.moveToElement(products.linkContinueShoppingLayer.get(0)).clickAndHold().click();

		products.waitTillElementIsVisible(products.linkShoppingcartBlockHover);
		products.mouseHover.moveToElement(products.linkShoppingcartBlockHover).build().perform();

		products.mouseHover.moveToElement(products.linkShoppingcartBlockHover).moveToElement(products.buttonCheckOut)
				.click().perform();
		products.waitTillElementIsClickable(products.buttonProceedToCheckout);
		products.buttonProceedToCheckout.click();
		accounts.textBoxEmailAddressCreateAccount.clear();
		accounts.textBoxEmailAddressCreateAccount.sendKeys(person.getEmail());
		accounts.mouseHover.moveToElement(accounts.buttonCreateAnAccount).build().perform();
		accounts.buttonCreateAnAccount.click();
		accounts.

	}

	@BeforeClass
	public void callDriver() {
		driver = createDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
		credential = new Credential(driver, wait);
		products = new Products(driver, wait);
		accounts = new Accounts(driver, wait);
		driver.navigate().to(url);
	}

	@AfterClass(alwaysRun = true)
	public void quitDriver() {
		quitBrowser();
	}
}
