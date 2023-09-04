package com.execution;

import java.io.FileInputStream;

import java.io.IOException;

import com.beust.jcommander.Parameter;
import com.gss.BaseUtils;
import com.pageobject.LoginDetails;
import com.pageobject.NewRegistration;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExecutionClass extends BaseUtils{
	
	@BeforeSuite
	public void Step1() {
		System.out.println("Execution Started");
	}
	@BeforeMethod
	public void Step2() {
	browserLaunch();
	getUrl("https://adactinhotelapp.com/");
	}
	@Test(dataProvider = "data")
	
	public void Step3(String username, String password, String confirmpass, String fullname, String email) {
		try {
	LoginDetails login = new LoginDetails(driver);
	clkButton(login.getNewreg());
	NewRegistration nr = new NewRegistration(driver);
	inputText(nr.getRusername(), username);
	inputText(nr.getRpassword(), password);
	inputText(nr.getRconfirmpassword(), confirmpass);
	inputText(nr.getRfullname(), fullname);
	inputText(nr.getRemail(),email);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@DataProvider(name = "data")
	public Object[][] stpe3Details() throws IOException {
		Object[][] details = excelInput();
		return details;
	}
	public String[][] excelInput() throws IOException{
		FileInputStream file = new FileInputStream("C:\\Users\\Aadhav\\Desktop\\Project class\\DataFile1.xls"); 
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheet("Sheet1");
		int rows = sheet.getPhysicalNumberOfRows();
		int col = sheet.getRow(0).getPhysicalNumberOfCells();
		String data[][] = new String[rows-1][col];
		HSSFCell cell;
		for(int i = 1; i<rows; i++)
			{
			for(int j=0; j<col; j++)
			{
				cell = sheet.getRow(i).getCell(j);
				String cellvalue = cell.getStringCellValue();
				data[i-1][j] = cellvalue;
			}
			
			
		}
		
		workbook.close();
		file.close();
		return data;

	}
	@AfterMethod
	public void Step4() throws IOException {
	
	implicitWait();
	screenShot();
}
	
}
