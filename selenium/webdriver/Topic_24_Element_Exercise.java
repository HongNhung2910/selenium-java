package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24_Element_Exercise {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Disable_Enable_Selected()
    {
        driver.get("https://www.fahasa.com/customer/account/create");

        //Kiểm tra element hiển thị
        Assert.assertTrue(driver.findElement(By.cssSelector("input#register_phone")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#register_phone_otp")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("button.fhs-btn-register")).isDisplayed());

        //Kiểm tra element nhìn thấy được
        Assert.assertTrue(driver.findElement(By.cssSelector("input#register_phone")).isEnabled());

        Assert.assertFalse(driver.findElement(By.cssSelector("input#register_phone_otp")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("input#register_password")).isDisplayed());

        //Kiểm tra element được chọn
        driver.get("https://live.techpanda.org/index.php/customer/account/create");
        Assert.assertFalse(driver.findElement(By.cssSelector("input.checkbox")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input.checkbox")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input.checkbox")).isDisplayed());
    }

    @Test
    public void TC_02_Mailchimp()
    {
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.cssSelector("input#email")).sendKeys("Nhung.do12@gmail.com");

        //Nhập ký tự viết thường
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("acbdef");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        //Nhập kí tự viết hoa
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("ABCDEF");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        //Nhập số
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        //Nhập kí tự đặc biệt
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("!@#");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        //Nhập 8 kí tự, có số, chữ thường, kí tự đặc biệt
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("abc@123456");
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

    }
    @Test
    public void TC_03_Login_Empty(){
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(),"This is a required field");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(),"This is a required field");
    }

    @Test
    public void TC_03_Login_Invalid_Email(){
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        driver.findElement(By.cssSelector("input#email")).sendKeys("123123@123.123");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("121212a");
        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");

    }

    @Test
    public void TC_03_Login_Invalid_Pass(){
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        driver.findElement(By.cssSelector("input#email")).clear();
        driver.findElement(By.cssSelector("input#pass")).clear();
        driver.findElement(By.cssSelector("input#email")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("121");
        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");


    }

    @Test
    public void TC_03_Login_Incorrect(){
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        driver.findElement(By.cssSelector("input#email")).clear();
        driver.findElement(By.cssSelector("input#pass")).clear();
        driver.findElement(By.cssSelector("input#email")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("121123");
        driver.findElement(By.cssSelector("button#send2")).click();





    }



    @AfterClass
    public void afterClass(){

        driver.quit();
    }
}
