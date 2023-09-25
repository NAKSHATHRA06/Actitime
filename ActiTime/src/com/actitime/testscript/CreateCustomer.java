package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitme.pom.EnterTimeTrackPage;
import com.actitme.pom.TaskListPage;
@Listeners(com.actitime.generic.ListenersImplimentation.class)
public class CreateCustomer extends BaseClass {

@Test 
	public void createCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("createcustomer",true);
		FileLib f= new FileLib();
		String customerName = f.getExcelData("CreateCustomer", 1, 2);
		String customerDesc = f.getExcelData("CreateCustomer", 1, 3);
		EnterTimeTrackPage e= new EnterTimeTrackPage(driver);
		Thread.sleep(5000);
		e.setTaskTab();
		Thread.sleep(5000);
		TaskListPage t= new TaskListPage(driver);
		t.getAddnewbtn().click();
		t.getNewCustomerOption().click();
		t.getEnterCustNameTbx().sendKeys(customerName);
		t.getEnterCustDescriptionTbx().sendKeys(customerDesc);
		t.getSelectCustomerDD().click();
		t.getBigBangCompanyTx().click();
		t.getCreateCustomerBtn().click();
		Thread.sleep(5000);
		String actualCustomerText = t.getActualCustomer().getText();
		Assert.assertEquals(actualCustomerText, customerName);
		
				
		
		
		}
}
