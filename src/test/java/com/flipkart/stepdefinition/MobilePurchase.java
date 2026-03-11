package com.flipkart.stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class MobilePurchase {
	@DataProvider(name="mobile")
	public Object[] mobileName() {
		return new Object [][] {{"realme"}};
		}
	static long start;
	static WebDriver driver;

    @BeforeClass(groups="default")
    public void browserLaunch() {
    	
    System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\eclipse-workspace\\SeleniumJar\\library\\msedgedriver.exe");        System.out.println("Browser Launch");
    driver=new EdgeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    System.out.println("launch");}

    @AfterClass(groups="default")
    public void browserQuit() {
        System.out.println("Browser Quit");
    }

    @BeforeMethod(groups="default")
    public void startTime() {
        start = System.currentTimeMillis();
    }

    @AfterMethod(groups="default")
    public void endTime() {
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start));
    }
@Parameters("URL")
    @Test(priority = 1)
    public void login(String url) {
        System.out.println("Login");
        driver.get(url);
    }

    @Test(priority = 2, dataProvider="mobile")
    public void search(String name) {
   driver.findElement(By.xpath("//span[@role=\"button\"]")).click();
   
    WebElement search=driver.findElement(By.name("q"));
   search.sendKeys(name,Keys.ENTER);
        System.out.println("Search");
    }

    @Test(priority = 3)
    public void windowsHandling() {
        System.out.println("Windows Handling");
    }

    @Test(priority = 4)
    public void screenshot() {
        System.out.println("Screenshot");
    }
}