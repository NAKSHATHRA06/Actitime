package com.actitime.generic;

import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitme.pom.EnterTimeTrackPage;
import com.actitme.pom.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	
	
	@BeforeTest
	public void openBrowser() {
		Reporter.log("openbrowser",true);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
	@AfterTest
	public void closeBrowser() {
		Reporter.log("closebrowser",true);
		driver.close();
			
		}
	@BeforeMethod
	public void login() throws IOException {
	Reporter.log("login",true);
	FileLib f= new FileLib();
	String url= f.getPropertData("url");
	String un= f.getPropertData("username");
	String pw= f.getPropertData("password");
	driver.get(url);
	LoginPage l=new LoginPage(driver);
	l.setLogin(un,pw);
	}
	@AfterMethod
	public void logout() {
	Reporter.log("logout",true);
	EnterTimeTrackPage e= new EnterTimeTrackPage(driver);
	e.setLogout();
		
	}


}
