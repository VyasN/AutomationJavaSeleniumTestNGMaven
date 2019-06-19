/**
 * 
 */
package com.automationpractice.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationpractice.base.PageSetup;

/**
 * @author nartan.vyas
 *
 */
public class Accounts extends PageSetup {

	public Accounts(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

//All Web Elements to create an account

	@FindBy(id = "email_create")
	public WebElement textBoxEmailAddressCreateAccount;

	@FindBy(id = "SubmitCreate")
	public WebElement buttonCreateAnAccount;

	@FindBy(id = "customer_lastname")
	public WebElement textBoxLastNamePersonalInfo;

	@FindBy(id = "customer_firstname")
	public WebElement textBoxFirstNamePersonalInfo;

	@FindBy(xpath = "//input[@id='passwd']")
	public WebElement textBoxPasswordPersonalInfo;

	@FindBy(id = "firstname")
	public WebElement textBoxFirstNameAddress;

	@FindBy(id = "lastname")
	public WebElement textBoxLastNameAddress;

	@FindBy(id = "address1")
	public WebElement textBoxAddress;

	@FindBy(id = "city")
	public WebElement textBoxCity;

	@FindBy(id = "postcode")
	public WebElement textBoxZipCode;

	@FindBy(id = "phone_mobile")
	public WebElement phoneNumber;

	@FindBy(xpath = "//button[contains(.,'Register')]")
	public WebElement btnRegister;

	@FindBy(xpath = "//select[@id='id_state']")
	public WebElement dropDownState;

	@FindBy(id = "phone_mobile")
	public WebElement textBoxMobileNumber;

	@FindBy(xpath = "//button[@name='processAddress']")
	public WebElement buttonProcessAddress;

	@FindBy(xpath = "//input[@type='checkbox' and @name='cgv']")
	public WebElement checkBoxTermsNService;

	@FindBy(xpath = "//button[@name='processCarrier']")
	public WebElement buttonProcessCarrier;
}
