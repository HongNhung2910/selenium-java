package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_45_Wait_PartI_Status {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
        explicitWait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    @Test
    public void TC_01_Visible(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login");
        driver.findElement(By.cssSelector("button#send")).click();

        //ĐK1- Element có hiển thị trên UI và có trong DOM/cây HTML
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#advice-required-entry-email")));

    }
    @Test
    public void TC_02_Invisible_In_HTML(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login");
        driver.findElement(By.cssSelector("button#send")).click();

        driver.findElement(By.cssSelector("input#email")).sendKeys("nhung@gmail.com");
        driver.findElement(By.cssSelector("button#send2")).click();

        //ĐK2- Element ko hiển thị trên UI và có trong DOM/cây HTML
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#advice-required-entry-email")));
    }

    @Test
    public void TC_02_Invisible_Not_In_HTML(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login");
        driver.findElement(By.cssSelector("input#email")).sendKeys("nhung@gmail.com");
        driver.findElement(By.cssSelector("button#send2")).click();

        //ĐK3- Element ko hiển thị trên UI và ko có trong DOM
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#advice-required-entry-email")));
    }

    @Test
    public void TC_03_Presence(){

        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.cssSelector("button#send2")).click();

        //ĐK 1
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#advice-required-entry-email")));

        driver.findElement(By.cssSelector("input#email")).sendKeys("oanhtt@gmail.com");
        driver.findElement(By.cssSelector("button#send2")).click();

        //ĐK 2
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#advice-required-entry-email")));
    }

    @Test
    public void TC_04_Staless(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.cssSelector("button#send2")).click();

        WebElement emailErrorMessage = driver.findElement(By.cssSelector("div#advice-required-entry-email"));

        driver.navigate().refresh();

        explicitWait.until(ExpectedConditions.stalenessOf(emailErrorMessage));
    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
