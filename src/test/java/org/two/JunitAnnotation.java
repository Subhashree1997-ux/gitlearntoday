package org.two;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JunitAnnotation extends BaseClass {
	@BeforeClass
	public static void tc01() {
		try{
			initBrowser("Chrome");
			System.out.println("Browser Launced Successfully");
			}
		catch(Exception e) {
			System.out.println("Browser not Launced Successfully");
		}	
	}
	@Before
	public void tc02() {
		try {
			getURL("https://adactinhotelapp.com/");
			System.out.println("Application Launced Successfully");
		}
		catch(Exception e) {
			System.out.println("Application not Launced Successfully");
		}
	}
	@Test
	public void tc03() {
		try {
			WebElement element = driver.findElement(By.id("username"));
			element.sendKeys("Suba@1997");
			WebElement element2 = driver.findElement(By.id("password"));
			element2.sendKeys("12345");
			System.out.println("Login credentials are successfully entered");
		}
		catch(Exception e) {
			System.out.println("Login credentials are not successfully entered");
		}
	}
	@After
	public void tc04() {
		try {
			WebElement element3 = driver.findElement(By.id("login"));
			element3.click();
			System.out.println("Login Button Clicked Successfully");
		}
		catch(Exception e){
			System.out.println("Login Button not Clicked Successfully");
		}
	}
	@AfterClass
	public static void tc05() {
		try {
			String expectedErrorMessage="Invalid Login details or Your Password might have expired. Click here to reset your password";
			WebElement element = driver.findElement(By.xpath("//b[contains(text(),'Invalid')]"));
			String actualErrorMessage = element.getText();
			System.out.println(actualErrorMessage);
			if(expectedErrorMessage.equalsIgnoreCase(actualErrorMessage)) {
				System.out.println("Error message displayed Successfully");
			}else {
				System.out.println("Error message not displayed Successfully");
			}
			
		}
		catch(Exception e) {
			System.out.println("Error message not 1displayed Successfully");
		}
	}

}
