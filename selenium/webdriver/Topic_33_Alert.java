package webdriver;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v139.network.Network;
import org.openqa.selenium.devtools.v139.network.model.Headers;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Topic_33_Alert {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Accept_Alert(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.accept();

        By textResult = By.cssSelector("p#result");
        Assert.assertEquals(driver.findElement(textResult).getText(),"You clicked an alert successfully");

    }
    @Test
    public void TC_02_Confirm_Alert(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.dismiss();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked: Cancel");

    }

    @Test
    public void TC_03_Prompt_Alert(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(),"I am a JS prompt");

        String text="Alert Prompt";
        alert.sendKeys(text);
        alert.accept();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You entered: "+text);
    }

    @Test
    public void TC_04_Accept_Alert() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//button[text()='Search']")).click();
        Thread.sleep(2000);

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(),"Please enter some search keyword");
        driver.switchTo().alert().accept();

        driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Macbook");
        driver.findElement(By.xpath("//button[text()='Search']")).click();
    }

    @Test
    public void TC_05_Authentication_Alert_1(){
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        //truyền thêm user pass //http://user:pass@url

        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(),
                "Congratulations! You must have the proper credentials.");
    }

    @Test
    public void TC_06_Authentication_Alert_2(){
        driver.get("http://the-internet.herokuapp.com/");
        String url =  driver.findElement(By.xpath("//a[text()='Basic Auth']")).getDomProperty("href");

        String username = "admin";
        String password = "admin";

        String[] urlArr = url.split("//");
        url = urlArr[0] + "//" + username + ":" + password + "@" + urlArr[1];
        driver.get(url);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(),
                "Congratulations! You must have the proper credentials.");

    }

    @Test
    public void TC_07(){
        driver.get("http://the-internet.herokuapp.com/");

        // Get DevTool object
        DevTools devTools = ((HasDevTools) driver).getDevTools();

        // Start new session
        devTools.createSession();

        // Enable the Network domain of devtools
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(),Optional.of(true)));

        // Encode username/ password
        Map<String, Object> headers = new HashMap<String, Object>();
        String basicAuthen = "Basic " + new String(new Base64().encode(String.format("%s:%s", "admin", "admin").getBytes()));
        headers.put("Authorization", basicAuthen);

        // Set to Header
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        driver.get("https://the-internet.herokuapp.com/basic_auth");

        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(),
                "Congratulations! You must have the proper credentials.");
    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }
}
