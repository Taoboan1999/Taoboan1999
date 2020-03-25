package com.st.tju;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test {
	public static void main(String[] args) throws IOException {
		String driverPath = System.getProperty("user.dir") + "/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		String firefoxPath = "E:\\Mozilla Firefox\\firefox.exe";
		System.setProperty("webdriver.firefox.bin", firefoxPath); 
		WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://103.120.226.190/selenium-demo/git-repo";
        driver.get(baseUrl);
        File filepath = new File(System.getProperty("user.dir") + "/Selenium Lab2020.xlsx");
        FileInputStream input = new FileInputStream(filepath);
        @SuppressWarnings("resource")
		XSSFWorkbook check_web = new XSSFWorkbook(input);
        XSSFSheet xSheet = check_web.getSheet("Sheet1");
        int row = xSheet.getLastRowNum();
        for(int i = 0; i < row; i++) {
        	XSSFRow r = xSheet.getRow(i);
        	if(r != null) {
        		XSSFCell id = r.getCell(1);
        		XSSFCell password = r.getCell(2);
        		driver.get(baseUrl);
        		WebElement userName = driver.findElement(By.name("user_number"));
        		userName.sendKeys(String.valueOf(id.getStringCellValue()));
        		WebElement passWord = driver.findElement(By.name("password"));
        		passWord.sendKeys(String.valueOf(password.getStringCellValue()));
        		WebElement submitName = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[3]/input"));
        		submitName.click();
        		WebElement text = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]/code"));
        		String ans = text.getText();
        		if(String.valueOf(password.getStringCellValue()).equals(ans)) {
        			System.out.println("Success");
        		}else {
        			System.out.println("Failure");
        		}
        	}
        	else
        		break;
       	}
       	driver.close();
	}
}
