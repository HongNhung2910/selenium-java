package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_31_Default_Checkbox_Radio {
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01(){
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");

        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");
        By leatherTrimCheckbox = By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input");
        By towBarCheckbox = By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input");
        By petrol2Radio = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");

     // Click chọn
        if (!driver.findElement(dualZoneCheckbox).isSelected()){
            //scroll
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("div.demo-section")));
            driver.findElement(dualZoneCheckbox).click();
        }

        //Kiểm tra
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());

        Assert.assertFalse(driver.findElement(leatherTrimCheckbox).isEnabled());
        Assert.assertTrue(driver.findElement(leatherTrimCheckbox).isSelected());

        Assert.assertFalse(driver.findElement(towBarCheckbox).isEnabled());
        Assert.assertFalse(driver.findElement(towBarCheckbox).isSelected());

        //CLick bỏ chọn
        if (driver.findElement(dualZoneCheckbox).isSelected()){
           driver.findElement(dualZoneCheckbox).click();
        }

        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());

        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        if (!driver.findElement(petrol2Radio).isSelected()){
            driver.findElement(petrol2Radio).click();
        }
        Assert.assertTrue(driver.findElement(petrol2Radio).isSelected());
    }

    @Test
    public void TC_02(){
        driver.get("https://material.angular.io/components/radio/examples");

        By summer = By.xpath("//label[text()='Summer']/preceding-sibling::div/input");
        By checked = By.xpath("//label[text()='Checked']/preceding-sibling::div/input");
        By indeterminate = By.xpath("//label[text()='Indeterminate']/preceding-sibling::div/input");

        if (!driver.findElement(summer).isSelected()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("div.docs-example-viewer-body")));
            driver.findElement(summer).click();
        }
        Assert.assertTrue(driver.findElement(summer).isSelected());

        driver.get("https://material.angular.io/components/checkbox/examples");
        if (!driver.findElement(checked).isSelected()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("div.docs-example-viewer-body")));
            driver.findElement(checked).click();
        }
        Assert.assertTrue(driver.findElement(checked).isSelected());

        if (!driver.findElement(indeterminate).isSelected()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("div.docs-example-viewer-body")));
            driver.findElement(indeterminate).click();
        }
        Assert.assertTrue(driver.findElement(indeterminate).isSelected());

    }

    @Test
    public void TC_03(){

        driver.get("https://automationfc.github.io/multiple-fields/");

        List<WebElement> everhadCheckboxes = driver.findElements(By.xpath(
                "//label[contains(text(),'Have you ever had')]/following-sibling::div//input[@type='checkbox']"));

        for (WebElement checkbox : everhadCheckboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
            Assert.assertTrue(checkbox.isSelected());
        }

        for (WebElement checkbox : everhadCheckboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
            Assert.assertFalse(checkbox.isSelected());
        }
        for (WebElement checkbox : everhadCheckboxes) {
            if (!checkbox.isSelected() && checkbox.getDomAttribute("value").equals("Heart Attack")) {
                checkbox.click();
                break;
            }
            Assert.assertFalse(driver.findElement(By.xpath("//label[text()=' Heart Attack ']/preceding-sibling::input")).isSelected());
        }
    }

    @Test
    public void TC_04() throws InterruptedException {
        driver.get("https://login.ubuntu.com/");

        //Dùng thẻ input để vừa click và verify
        By newUser= By.cssSelector("input#id_new_user");
        By checkboxUser= By.cssSelector("input#id_accept_tos");

        jsExecutor.executeScript("arguments[0].click();", driver.findElement(newUser));
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(newUser).isSelected());

        jsExecutor.executeScript("arguments[0].click();", driver.findElement(checkboxUser));
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(checkboxUser).isSelected());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
