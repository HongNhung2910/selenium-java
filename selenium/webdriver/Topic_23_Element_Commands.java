package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_23_Element_Commands {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
        driver.get("https://live.techpanda.org/");
    }

    @Test
    public void TC_01()
    {
        driver.findElement(By.xpath("")).click();

        driver.findElement(By.cssSelector("")).clear();
        driver.findElement(By.cssSelector("")).sendKeys();
        driver.findElement(By.cssSelector("")).findElement(By.cssSelector(""));

        //kiểm tra enable hoặc disable
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("")).isEnabled());

        //Kiểm tra element hiển thị
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("")).isDisplayed());

        //Kiểm tra element được chọn
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("")).isSelected());

        //Lấy dữ liệu text
        driver.findElement(By.cssSelector("")).getText();
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getText(), "This is a required field.");

        //Lấy ra giá trị thuộc tính HTML
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getAttribute("placeholder"), "");



    }

    @Test
    public void TC_02()
    {

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
