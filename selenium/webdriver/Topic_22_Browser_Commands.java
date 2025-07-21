package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_22_Browser_Commands {
    WebDriver driver;
    String nopCommerceUrt="https://demo.nopcommerce.com/";

    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
    }

    @Test
    public void TC_01(){
        driver.get(nopCommerceUrt);

        driver.findElement(By.cssSelector(""));

        driver.findElements(By.cssSelector(""));

        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");

        Assert.assertTrue(driver.getPageSource().contains(""));

        driver.getTitle();//Trả title của page hiện tại

        driver.getWindowHandle();// Trả về ID của tab/page hiện tại

        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().setSize(new Dimension(1920,1890));
        driver.manage().window().setPosition(new Point(15,20));

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.manage().getCookies();//Lấy ra cookie theo tên

        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        



    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
