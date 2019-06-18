/**
 * 
 */
package com.automationpractice.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author nartan.vyas
 *
 */
public class Credential extends PageSetup {

	public Credential(WebDriver driver, WebDriverWait wait) {
		// TODO Auto-generated constructor stub
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

// Add methods and elements which we are using to login and log out
// Sometimes with multiple users	
}
