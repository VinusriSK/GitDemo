package com.execution;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gss.BaseUtils;
import com.pageobject.LoginDetails;
import com.pageobject.NewRegistration;

public class MultipleData extends BaseUtils {
	@BeforeMethod
	public void Demo1() {
		browserLaunch();
		getUrl("https://adactinhotelapp.com/");
	}

	@Test(dataProvider = "data")
	public void Demo2(String username, String password, String confirmpassword, String fullname, String email) {
		try {
			LoginDetails log = new LoginDetails(driver);
			clkButton(log.getNewreg());
			NewRegistration nr = new NewRegistration(driver);
			inputText(nr.getRusername(), username);
			inputText(nr.getRpassword(), password);
			inputText(nr.getRconfirmpassword(), confirmpassword);
			inputText(nr.getRfullname(), fullname);
			inputText(nr.getRemail(), email);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider(name = "data")
	public String[][] mulInput() {
		String[][] input = new String[2][5];
		input[0][0] = "Vithya";
		input[0][1] = "vinu";
		input[0][2] = "vinu";
		input[0][3] = "Vithyasri";
		input[0][4] = "vinu1023@gmail.com";

		 input[1][0]="vinothini"; input[1][1]="vinu"; input[1][2]="vinu";
		input[1][3]="Vinothini Vinoth"; input[1][4]="vinothini@gmail.com";
		
		return input;

	}
}
