package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewRegistration {
		@FindBy (id="username")
		private WebElement rusername;
		@FindBy (id="password")
		private WebElement rpassword;
		@FindBy (id="re_password")
		private WebElement rconfirmpassword;
		@FindBy (id="full_name")
		private WebElement rfullname;
		@FindBy (id="email_add")
		private WebElement remail;
		public WebElement getRusername() {
			return rusername;
		}
		public WebElement getRpassword() {
			return rpassword;
		}
		public WebElement getRconfirmpassword() {
			return rconfirmpassword;
		}
		public WebElement getRfullname() {
			return rfullname;
		}
		public WebElement getRemail() {
			return remail;
		}
		public NewRegistration(WebDriver _driver) {
			PageFactory.initElements(_driver, this);
		}
		}


