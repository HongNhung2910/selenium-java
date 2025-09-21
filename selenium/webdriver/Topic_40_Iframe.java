package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_40_Iframe {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_WordPress(){
        driver.get("https://toidicodedao.com/");

        //Switch qua iframe
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title *='Facebook Social Plugin']")));

        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Tôi đi code dạo']/parent::div/following-sibling::div")).getText(),
                "396,055 followers");

        //Quay lại trang chứa iframe
        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("div#content-sidebar input.search-field")).sendKeys("puppeteer");
        driver.findElement(By.cssSelector("div#content-sidebar input.search-field")).sendKeys(Keys.ENTER);

    }

    @Test
    public void TC_02_FormSite() throws InterruptedException {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        driver.findElement(By.cssSelector("div#imageTemplateContainer>img")).click();
        Thread.sleep(4000);

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='details__form-preview-wrapper' " +
                "and contains(string(), 'Interactive form loaded. Try filling out below.')]")).isDisplayed());

        //switch vào iframe
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#formTemplateContainer>iframe")));

        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Senior");
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-3"))).selectByVisibleText("South Dorm");
        driver.findElement(By.xpath("//label[text()='Female']")).click();

        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("a[title='Get this form']")).click();
    }

    @Test
    public void TC_03_HDFC() throws InterruptedException {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");

        driver.switchTo().frame("login_page");

        driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("nhung");
        driver.findElement(By.cssSelector("a.login-btn")).click();
        Thread.sleep(4000);

        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("input#keyboard")).sendKeys("nhung");
        driver.findElement(By.cssSelector("a#loginBtn")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("p.error-msg")).getText(),"Customer ID/IPIN (Password) is invalid. Please try again.");
    }

    @AfterClass
    public void afterClass(){
      //  driver.quit();
    }

}
