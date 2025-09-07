package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_39_Shadow_DOM {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Home_Shop(){
            driver.get("https://shop.polymer-project.org/");

            WebElement shopAppShadowHost = driver.findElement(By.cssSelector("shop-app"));
            SearchContext shopAppShadowRoot = shopAppShadowHost.getShadowRoot();

            WebElement shopHomeShadowHost = shopAppShadowRoot.findElement(By.cssSelector("iron-pages>shop-home"));
            SearchContext shopHomeShadowRoot = shopHomeShadowHost.getShadowRoot();

            shopHomeShadowRoot.findElement(By.cssSelector("shop-button>a[href *='mens_outerwear']")).click();
    }

    @Test
    public void TC_02(){
        driver.get("https://automationfc.github.io/shadow-dom/");

        Assert.assertEquals(driver.findElement(By.xpath("//a")).getText(),"scroll.html");
        Assert.assertEquals(driver.findElements(By.xpath("//a")).size(),1);

        WebElement firstShadowHost= driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext firstShadowRoot= firstShadowHost.getShadowRoot();

        //Thao tác với shadow đầu tiền
        Assert.assertEquals(firstShadowRoot.findElement(By.cssSelector("span#shadow_content>span")).getText(),"some text");
        Assert.assertEquals(firstShadowRoot.findElements(By.cssSelector("a")).size(),1);
        Assert.assertEquals(firstShadowRoot.findElement(By.cssSelector("a")).getText(),"nested scroll.html");

        //Switch qua
        WebElement secondShadowHost = firstShadowRoot.findElement(By.cssSelector("div#nested_shadow_host"));
        SearchContext secondShadowRoot = secondShadowHost.getShadowRoot();

        //THao tác với Shadow thứ hai
        Assert.assertEquals(secondShadowRoot.findElement(By.cssSelector("div#nested_shadow_content>div")).getText(),"nested text");
    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
