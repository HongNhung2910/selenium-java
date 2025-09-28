package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.regex.Pattern;

public class Topic_47_Wait_PartV_Explicit_Function {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void TC_01(){
        // Alert present
        explicitWait.until(ExpectedConditions.alertIsPresent());

        // Element visible (cho 1/cho nhiều/tham số là gì)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));

        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(""))));

        explicitWait.until(ExpectedConditions.visibilityOfAllElements(
                driver.findElement(By.cssSelector("input#id")),
                driver.findElement(By.cssSelector("input#email")),
                driver.findElement(By.cssSelector("input#password"))
        ));

        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("input[type='text']"))));

        // Element invisible
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        // Element presence
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        // Element Staleness
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));

        // Element clickable
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));

        // Element selected
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));

        // Element có số lượng bằng bao nhiêu (ít hơn/ bằng/ nhiều hơn)
        explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(""),5));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector(""),5));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(""),5));

        // Kết hợp 2 điều kiện (AND/OR/NOT)
        // AND
        explicitWait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")),
                ExpectedConditions.elementToBeClickable(By.cssSelector(""))));

        //OR
        explicitWait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")),
                ExpectedConditions.elementToBeClickable(By.cssSelector(""))));

        // Phủ định
        explicitWait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        //URL/Title/Text
        explicitWait.until(ExpectedConditions.urlToBe(""));
        explicitWait.until(ExpectedConditions.urlContains(""));
        explicitWait.until(ExpectedConditions.urlMatches(""));

        explicitWait.until(ExpectedConditions.titleIs(""));
        explicitWait.until(ExpectedConditions.titleContains(""));

        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector(""),"Automation"));
        explicitWait.until(ExpectedConditions.textMatches(By.cssSelector(""), Pattern.compile("")));

        // Attribute/ DOM Property/ Frame
        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector(""),"class", "email"));

        explicitWait.until(ExpectedConditions.domPropertyToBe(driver.findElement(By.cssSelector("")),"textContent", "Hello World!"));
        explicitWait.until(ExpectedConditions.domAttributeToBe(driver.findElement(By.cssSelector("")),"id", "finish"));

        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("")));
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector(""))));
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("facebook"));
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
