package com.sele.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;


 
public class Seleniumscript {
@SuppressWarnings("deprecation")
public static void main(String[] args) throws InterruptedException{
System.setProperty("webdriver.chrome.driver", "C:\\Users\\nsingh2\\Downloads\\Chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
WebElement annualincome=driver.findElement(By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q2q1']"));
annualincome.sendKeys("80000");
WebElement otherincome=driver.findElement(By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q2q2']"));
otherincome.sendKeys("10000");
WebElement monthlyexpense=driver.findElement(By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q1']"));
monthlyexpense.sendKeys("500");

WebElement otherhomerepayment=driver.findElement(By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q3']"));
otherhomerepayment.sendKeys("100");
WebElement e4=driver.findElement(By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q5']"));
e4.sendKeys("10000");

WebElement e5=driver.findElement(By.xpath("//button[@id='btnBorrowCalculater']"));
System.out.println(e5.isEnabled());
e5.click();
WebElement borrowresult=driver.findElement(By.xpath("//span[@id='borrowResultTextAmount']"));
driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
        ,borrowresult);
Thread.sleep(5000);
String e6=borrowresult.getText();
System.out.println(e6);
Assert.assertEquals("$451,000", e6);
//clicking on start over------------------------------------------------------------------------------------------------------------
WebElement startover=driver.findElement(By.xpath("//span[@class='icon icon_restart'][1]"));
startover.click();
Thread.sleep(3000);
((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
        ,annualincome);
// Verifying borrow error
WebElement monthlyexpense1=driver.findElement(By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q1']"));
monthlyexpense.sendKeys("1");
e5.click();
WebElement borrowerrortext=driver.findElement(By.xpath("//div[@class='borrow__error__text']"));
String s1=borrowerrortext.getText();
System.out.println(s1);
Assert.assertEquals("Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.", s1);
driver.close();


} 
}