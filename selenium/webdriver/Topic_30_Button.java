package webdriver;

import org.openqa.selenium.support.Color;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class Topic_30_Button {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01(){
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();

        By loginButton= By.cssSelector("button.fhs-btn-login");
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());
        /*
        String loginButtonColorRGBA= driver.findElement(loginButton).getCssValue("background-color");
        Color loginButtonColor= Color.fromString(loginButtonColorRGBA);
        String loginButtonHexa= loginButtonColor.asHex();
        */
        Assert.assertEquals(Color.fromString(driver.findElement(By.cssSelector("button.fhs-btn-login"))
                .getCssValue("background-color")).asHex().toUpperCase(),"#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("nhunghong@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("12345678");

        Assert.assertTrue(driver.findElement(loginButton).isEnabled());
        Assert.assertEquals(Color.fromString(driver.findElement(By.cssSelector("button.fhs-btn-login"))
                .getCssValue("background-color")).asHex().toUpperCase(),"#C92127");

    }

    @Test
    public void TC_02(){

    }



    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
