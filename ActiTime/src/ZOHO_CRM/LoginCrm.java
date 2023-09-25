package ZOHO_CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginCrm {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver= new ChromeDriver();
driver.get("http://192.168.48.128:8080/crm/HomePage.do");
driver.findElement(By.id("userName")).sendKeys("rashmi@dell.com");
driver.findElement(By.id("passWord")).sendKeys("123456");
driver.findElement(By.xpath("//input[@title='Sign In']")).click();
Thread.sleep(4000);
driver.findElement(By.partialLinkText("Logout")).click();
driver.quit();
	}

}
