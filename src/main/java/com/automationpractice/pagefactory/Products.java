package com.automationpractice.pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationpractice.base.PageSetup;

//Contains all the WebElemets to select product and check out from cart

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

	@FindBy(xpath = "//span[.='Add to cart']/parent::button")
	public WebElement buttonAddToCart;

	@FindBy(xpath = "//iframe[contains(@id,'fancybox-frame')]")
	public WebElement iframeFancyBoxLayer;

	@FindBy(id = "group_1")
	public WebElement dropDownDressSize;

	@FindBy(xpath = "//a[contains(.,'Proceed to checkout')]")
	public WebElement linkProccedToCheckoutLayer;

	@FindBy(xpath = "//span[contains(@class,'btn') and contains(.,'Continue shopping')]")
	public List<WebElement> linkContinueShoppingLayer;

	@FindBy(xpath = "//a[@title='View my shopping cart']")
	public WebElement linkShoppingcartBlockHover;

	@FindBy(xpath = "//span[contains(.,'Check out')]/parent::a[@id='button_order_cart']")
	public WebElement buttonCheckOut;

	@FindBy(xpath = "//p[@class='cart_navigation clearfix']/a[contains(.,'Proceed to checkout')]")
	public WebElement buttonProceedToCheckout;

}
