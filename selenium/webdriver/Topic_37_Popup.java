package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_37_Popup {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_In_HTML() throws InterruptedException {
        driver.get("http://www.kmplayer.com/");
        Thread.sleep(3000);

        By popup= By.cssSelector("div[class='pop-container']");

        //1- Nếu popup hiển thị: click vào CLose
        //2- Nếu k hiển thị: click vào FAG link

        if (driver.findElement(popup).isDisplayed()){
            System.out.println("=== Popup hien thi ===");
            driver.findElement(By.cssSelector("div.close")).click();
            Thread.sleep(3000);
        }
        System.out.println("=== Popup khong hien thi ===");
        Assert.assertFalse(driver.findElement(popup).isDisplayed());

        driver.findElement(By.xpath("//a[text()='FAQ']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='KMPlayer FAQ']")).isDisplayed());
    }

    @Test
    public void TC_02_Not_In_HTML() throws InterruptedException {
        driver.get("https://tienganhcomaiphuong.vn/");
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        Thread.sleep(3000);

        By popup= By.cssSelector("div[class *= 'custom-dialog-paper']");

        Assert.assertTrue(driver.findElement(popup).isDisplayed());

        driver.findElement(By.cssSelector("input[placeholder='Tài khoản đăng nhập']")).sendKeys("");
        driver.findElement(By.cssSelector("input[placeholder='Mật khẩu']")).sendKeys("");
        driver.findElement(By.xpath("//form//button[text()='Đăng nhập']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#notistack-snackbar")).getText(),"Bạn đã nhập sai tài khoản hoặc mật khẩu!");

        driver.findElement(By.cssSelector("h2>button.close-btn")).click();
        Thread.sleep(2000);

        //set lại timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertEquals(driver.findElements(popup).size(),0);
    }

    @Test
    public void TC_03_Tiki() throws InterruptedException {
        driver.get("https://tiki.vn");

        By bundlePopup = By.cssSelector("div#VIP_BUNDLE");

        if (driver.findElements(bundlePopup).size()>0 && driver.findElements(bundlePopup).get(0).isDisplayed()){
            //click close
            driver.findElement(By.cssSelector("picture.webpimg-container >img[alt='close-icon']")).click();
        }
        //CLick đăng nhập/đăng ký
        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();

        //popup dạng fix cứng
        By loginPopup = By.cssSelector("div[class*='ReactModal__Content']");

        //Verify đang hiển thị
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("p.login-with-email")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Email không được để trống']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Mật khẩu không được để trống']")).isDisplayed());

        driver.findElement(By.cssSelector("button>img.close-img")).click();
        Thread.sleep(1000);

        //Verify không hiển thị
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertEquals(driver.findElements(loginPopup).size(),0);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
