package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_35_Action_II {
    WebDriver driver;
    Actions actions;
    String osName=System.getProperty("os.name");
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        actions =new Actions(driver);
        jsExecutor = (JavascriptExecutor) driver;

    }

    @Test
    public void TC_01_Click_And_Hold_Block(){
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allItems=driver.findElements(By.cssSelector("ol#selectable>li"));

        actions.clickAndHold(allItems.getFirst()).moveToElement(allItems.get(11)).release().perform();
        Assert.assertEquals(driver.findElements(By.cssSelector("ol#selectable>li.ui-selected")).size(),12);

    }
    @Test
    public void TC_02_Click_And_Hold_Random(){
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> allItems=driver.findElements(By.cssSelector("ol#selectable>li"));

        Keys keys=null;
        if (osName.contains("Windows")){
            keys=Keys.CONTROL;
        }
        keys=Keys.COMMAND;

        //Nhấn phím Ctrl
        actions.keyDown(keys).perform();

        //Chọn từ 3,5,7,9...
        actions.click(allItems.get(2))
                .click(allItems.get(4))
                .click(allItems.get(6))
                .click(allItems.get(8))
                .click(allItems.get(16))
                .perform();

        //Nhả phím Ctrl
        actions.keyUp(keys).perform();
        actions.pause(Duration.ofSeconds(2)).perform();

        Assert.assertEquals(driver.findElements(By.cssSelector("ol#selectable>li.ui-selected")).size(),5);
    }

    @Test
    public void TC_03_Double_Click(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.xpath("//button[text()='Double click me']")));

        actions.pause(Duration.ofSeconds(3)).perform();

        actions.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
        actions.pause(Duration.ofSeconds(2)).perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(),"Hello Automation Guys!");

    }

    @Test
    public void TC_04_Right_Click(){
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

        actions.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
        actions.pause(Duration.ofSeconds(2)).perform();

        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
