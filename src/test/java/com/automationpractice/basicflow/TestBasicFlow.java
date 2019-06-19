package com.automationpractice.basicflow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
		Assert.assertTrue(driver.getCurrentUrl().contains("index.php"));
		products.mouseHover.moveToElement(products.headerTabHover).build().perform();
		products.waitTillElementIsClickable(products.linkSummerDress);
		products.linkSummerDress.click();
		Assert.assertTrue(driver.getCurrentUrl().contains("controller=category"));
		products.mouseHover.moveToElement(products.imageContainerChifforDressHover).build().perform();
		products.buttonAjaxQuickView.click();
		driver.switchTo().frame(products.iframeFancyBoxLayer);
		products.waitTillElementIsClickable(products.buttonAddToCart);
		products.selectDDOptionByValue(products.dropDownDressSize, "2");
		Assert.assertTrue(driver.getTitle().contains("Summer Dresses - My Store"));
		products.waitTillElementIsClickable(products.buttonAddToCart);
		products.mouseHover.moveToElement(products.buttonAddToCart).click().perform();
		driver.switchTo().defaultContent();
		products.waitTillElementIsVisible(products.linkContinueShoppingLayer.get(0));
		products.mouseHover.moveToElement(products.linkContinueShoppingLayer.get(0)).clickAndHold().click();
		products.waitTillElementIsVisible(products.linkShoppingcartBlockHover);
		products.mouseHover.moveToElement(products.linkShoppingcartBlockHover).build().perform();
		products.mouseHover.moveToElement(products.linkShoppingcartBlockHover).moveToElement(products.buttonCheckOut)
				.click().perform();
		// some times it didn't click on checkout button cause it's disappears when
		// driver mouse hover to the button so for safe side implemented if loop
		if (driver.getTitle().contains("controller=order") != true) {
			products.mouseHover.moveToElement(products.linkShoppingcartBlockHover).build().perform();
			products.mouseHover.moveToElement(products.linkShoppingcartBlockHover)
					.moveToElement(products.buttonCheckOut).click().perform();
		}
		products.waitTillElementIsClickable(products.buttonProceedToCheckout);
		Assert.assertTrue(driver.getCurrentUrl().contains("controller=order"));
		products.buttonProceedToCheckout.click();
		accounts.textBoxEmailAddressCreateAccount.clear();
		accounts.textBoxEmailAddressCreateAccount.sendKeys(person.getEmail());
		accounts.mouseHover.moveToElement(accounts.buttonCreateAnAccount).build().perform();
		accounts.buttonCreateAnAccount.click();
		accounts.waitTillElementIsClickable(accounts.btnRegister);
		Assert.assertTrue(driver.getTitle().contains("Login - My Store"));
		accounts.textBoxFirstNamePersonalInfo.clear();
		accounts.textBoxFirstNamePersonalInfo.sendKeys(person.getFirstName());
		accounts.textBoxLastNamePersonalInfo.sendKeys(person.getLastName());
		accounts.textBoxAddress.sendKeys(person.getAddress().toString());
		accounts.textBoxCity.sendKeys("NewYork");
		accounts.selectDDOptionByValue(accounts.dropDownState, "32");
		accounts.textBoxZipCode.sendKeys(person.getAddress().getPostalCode());
		accounts.textBoxMobileNumber.sendKeys(person.getTelephoneNumber());
		accounts.textBoxPasswordPersonalInfo.clear();
		accounts.textBoxPasswordPersonalInfo.sendKeys(person.getPassword());
		accounts.mouseHover.moveToElement(accounts.btnRegister).click().build().perform();
		accounts.waitTillElementIsClickable(accounts.buttonProcessAddress);
		Assert.assertTrue(driver.getTitle().contains("Order - My Store"));
		accounts.mouseHover.moveToElement(accounts.buttonProcessAddress).click().perform();
		accounts.waitTillElementIsClickable(accounts.buttonProcessCarrier);
		accounts.mouseHover.moveToElement(accounts.checkBoxTermsNService).click().perform();
		accounts.mouseHover.moveToElement(accounts.buttonProcessCarrier).click().perform();
		products.waitTillElementIsClickable(products.linkPayByBankWire);
		Assert.assertEquals(products.titleProductOrderName.getText(), "Printed Chiffon Dress");
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
