package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDetails {

	@FindBy (linkText = "New User Register Here")
	private WebElement newreg;

	@FindBy (xpath="//*[text()='Adactin Launches The Adactin Hotel App! ']")
	private WebElement title;

	public WebElement getTitle() {
		return title;
	}
	public WebElement getNewreg() {
		return newreg;
	} 
	public LoginDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
}
}