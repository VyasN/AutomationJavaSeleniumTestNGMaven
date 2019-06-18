package com.automationpractice.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationpractice.base.PageSetup;

//Contains all the WebElemets for products
public class Products extends PageSetup {
	public Products(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[.='Women']")
	public WebElement headerTabHover;

	@FindBy(xpath = "//ul[not(contains(@class,'first-in-line-xs'))]/li/a[.='Summer Dresses']")
	public WebElement linkSummerDress;

	@FindBy(xpath = "//img[contains(@title,'Printed Chiffon Dress') and @width]")
	public WebElement imageContainerChifforDressHover;

	@FindBy(xpath = "//a[@title='Printed Chiffon Dress']/..//span[.='Quick view']")
	public WebElement buttonAjaxQuickView;

	@FindBy(xpath = "//p[@id='add_to_cart']/button")
	public WebElement buttonAddToCart;
}
