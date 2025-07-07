package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_15_Selenium_Locator {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://live.techpanda.org/index.php/customer/account/login");
    }

    @Test
    public void TC_01_ID()
    {
        driver.findElement(By.id("email"));
        driver.findElement(By.id("pass"));
        driver.findElement(By.id("newsletter"));
    }
    @Test
    public void TC_02_Class()
    {
    driver.findElement(By.className("validate-email"));
    driver.findElement(By.className("validate-password"));
    }
    @Test
    public void TC_03_Name()
    {
    driver.findElement(By.name("login[username]"));
    driver.findElement(By.name("login[password]"));
    driver.findElement(By.name("send"));
    }
    @Test
    public void TC_04_TagName()
    {
    int inputNumber=  driver.findElements(By.tagName("input")).size();
    System.out.println("Số lượng thẻ input="+inputNumber);

    int buttonNumber=  driver.findElements(By.tagName("button")).size();
    System.out.println("Số lượng thẻ button="+buttonNumber);
    }
    @Test
    public void TC_05_LinkTest()
    {
        driver.findElement(By.linkText("ABOUT US"));
        driver.findElement(By.linkText("CONTACT US"));
        driver.findElement(By.linkText("CUSTOMER SERVICE"));
        driver.findElement(By.linkText("PRIVACY POLICY"));
        driver.findElement(By.linkText("SITE MAP"));
        driver.findElement(By.linkText("SEARCH TERMS"));
        driver.findElement(By.linkText("ADVANCED SEARCH"));
        driver.findElement(By.linkText("MY ACCOUNT"));
        driver.findElement(By.linkText("ORDERS AND RETURNS"));
        driver.findElement(By.linkText("Forgot Your Password?"));
    }
    @Test
    public void TC_06_Partial_LinkTest()
    {
    driver.findElement(By.partialLinkText("ABOUT"));
    driver.findElement(By.partialLinkText("ACCOUNT"));
    driver.findElement(By.partialLinkText("Password?"));
    }
    @Test
    public void TC_07_Css()
    {
        //ID
        driver.findElement(By.cssSelector("input[id='email']"));
        driver.findElement(By.cssSelector("#email"));
        driver.findElement(By.cssSelector("input#email"));

        //Class
        driver.findElement(By.cssSelector("div[class='account-login']"));
        driver.findElement(By.cssSelector(".account-login"));
        driver.findElement(By.cssSelector("div.account-login"));


        //Name
        driver.findElement(By.cssSelector("input[name='login[username]']"));
        driver.findElement(By.cssSelector("input[name='login[password]']"));
        driver.findElement(By.cssSelector("button[name='send']"));

        //TagName
        driver.findElement(By.cssSelector("input"));

        //link
        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/customer/account/']"));
        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/sales/guest/form/']"));

        //PartialLink
        driver.findElement(By.cssSelector("a[href*='/customer/account/']"));
        driver.findElement(By.cssSelector("a[href*='/sales/guest/form/']"));
    }
    @Test
    public void TC_08_Xpath()
    {
       driver.findElement(By.xpath("//input[@id='email']"));

        driver.findElement(By.xpath("//div[@class='account-login']"));
        driver.findElement(By.xpath("//div[@class='col-2 registered-users']"));

        driver.findElement(By.xpath("//input[@name='login[username]']"));
        driver.findElement(By.xpath("//input[@name='login[password]']"));
        driver.findElement(By.xpath("//button[@name='send']"));

        driver.findElement(By.xpath("//input"));

        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/customer/account/']"));
        driver.findElement(By.xpath("//a[text()='My Account']"));

        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/sales/guest/form/']"));
        driver.findElement(By.xpath("//a[text()='Orders and Returns']"));

        driver.findElement(By.xpath("//a[contains(@href,'customer/account')]"));
        driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));

        driver.findElement(By.xpath("//a[contains(@href,'/sales/guest/form/')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Orders and Returns')]"));
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
