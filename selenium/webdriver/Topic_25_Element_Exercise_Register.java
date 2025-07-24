package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_25_Element_Exercise_Register {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();

    }

    @Test
    public void TC_01_Empty()
    {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("");

        driver.findElement(By.cssSelector("button.btn_pink_sm.fs16")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");
    }

    @Test
    public void TC_02_Invalid_Email()
    {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Do Hong Nhung");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("adadad@a@");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("adadad@a@");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0989898989");

        driver.findElement(By.cssSelector("button.btn_pink_sm.fs16")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCEmail-error")).getText(),"Vui lòng nhập email hợp lệ");

    }

    @Test
    public void TC_03_Incorrect_Confrim_Email()
    {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Do Hong Nhung");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("abc@gmail.vn");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0989898989");

        driver.findElement(By.cssSelector("button.btn_pink_sm.fs16")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCEmail-error")).getText(),"Email nhập lại không đúng");
    }

    @Test
    public void TC_04_Invalid_Pass()
    {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Do Hong Nhung");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("12345");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("12345");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0989898989");

        driver.findElement(By.cssSelector("button.btn_pink_sm.fs16")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
    }

    @Test
    public void TC_05_Incorrect_Confrim_Pass()
    {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Do Hong Nhung");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123457");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0989898989");

        driver.findElement(By.cssSelector("button.btn_pink_sm.fs16")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");
    }

    @Test
    public void TC_06_Invalid_Phone_Number()
    {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Do Hong Nhung");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("09898");

        driver.findElement(By.cssSelector("button.btn_pink_sm.fs16")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

        driver.findElement(By.cssSelector("input#txtPhone")).clear();
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("098988888888");
        driver.findElement(By.cssSelector("button.btn_pink_sm.fs16")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

        driver.findElement(By.cssSelector("input#txtPhone")).clear();
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0678989899");
        driver.findElement(By.cssSelector("button.btn_pink_sm.fs16")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");

        driver.findElement(By.cssSelector("input#txtPhone")).clear();
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("abcd");
        driver.findElement(By.cssSelector("button.btn_pink_sm.fs16")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPhone-error")).getText(),"Vui lòng nhập con số");
    }
    @AfterClass
    public void afterClass(){

        driver.quit();
    }
}
