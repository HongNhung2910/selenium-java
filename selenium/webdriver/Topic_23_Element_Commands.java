package webdriver;

import org.openqa.selenium.*;
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
        driver.get("https://live.techpanda.org/index.php/customer/account/login");
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
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getAttribute("placeholder"), "Search entire store here...");

        //Lấy ra giá trị của thuộc tính trong Document Object Model
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getDomProperty("value"),"Automation");
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getDomProperty("placeholder"),"Search entire store here...");

        //Lấy ra giá trị Css
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getCssValue("background-color"),"");
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getCssValue("font-size"),"13px");

        //Lấy ra chiều rộng, chiều cao
        Dimension loginButtonSize=  driver.findElement(By.cssSelector("")).getSize();
        loginButtonSize.getHeight();
        loginButtonSize.getWidth();

        //Lấy ra vị trí element so với màn hình
        Point LoginButtonLocation =driver.findElement(By.cssSelector("")).getLocation();
        LoginButtonLocation.getX();
        LoginButtonLocation.getY();

        //Bao gồm cả size và location
        Rectangle loginButtonRectangle= driver.findElement(By.cssSelector("")).getRect();
        loginButtonRectangle.getY();
        loginButtonRectangle.getY();
        loginButtonRectangle.getHeight();
        loginButtonRectangle.getWidth();

        loginButtonSize=loginButtonRectangle.getDimension();
        LoginButtonLocation= loginButtonRectangle.getPoint();


        driver.findElement(By.cssSelector("")).getTagName();

        driver.findElement(By.cssSelector("")).getShadowRoot();
        driver.findElement(By.cssSelector("")).submit();






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
