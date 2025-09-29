package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_48_Wait_PartV_Explicit {
    WebDriver driver;
    WebDriverWait explicitWait;
    String uploadFilePath = System.getProperty("user.dir") + "\\uploadFiles\\";

    String mountainFile = "mountain.png";
    String riverFile = "River.png";
    String treeFile = "Tree.png";

    String mountainFilePath = uploadFilePath + mountainFile;
    String riverFilePath = uploadFilePath + riverFile;
    String treeFilePath = uploadFilePath + treeFile;

    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TC_01(){
        explicitWait= new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        //Chờ loading Icon invisible
        //1 Chờ step trước hoàn thành rồi mới qua step sau
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading"))));

        //Chờ cho Text là   Visible
        //2- Sau khi step trước bắt đầu -> Chờ cho 1 đt của step sau xuất hiện

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4"))).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4"))).getText();

        driver.findElement(By.cssSelector("div#finish>h4")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World");
    }

    @Test
    public void TC_02_Ajax(){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        // Chờ trong x giây để Date Picker hiển thị
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1")));

        // CHờ cho text đc xuất hiện trong 30s
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),
                "No Selected Dates to display.")));

        // Chờ cho element được phép click và sau đó sẽ click vào
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/a[text()='18']"))).click();

        // Chờ cho icon loading biến mất
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div:not([style = 'display:none;'])>div.raDiv")));

        // Chờ cho text được cập nhật lên trang
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),
                "Thursday, September 18, 2025")));
    }

    @Test
    public void TC_03_Upload() {
        driver.get("https://gofile.io/?t=uploadFiles");

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Chờ cho tất cả các icon loading trên trang biến mất
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(
                driver.findElements(By.cssSelector("div.animate-spin")))));

        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")))
                .sendKeys(mountainFilePath + "\n" + riverFilePath + "\n" + treeFilePath);

        //Chờ cho tất cả các upload progress bar biến mất
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(
                driver.findElements(By.cssSelector("div.file-progressbar"))));

        String uploadUrl = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.linkSuccessCard"))).getDomProperty("href");
        driver.get(uploadUrl);

        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(
                driver.findElements(By.cssSelector("div.animate-spin")))));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//a[contains(@class,'tem_open') and text()='" + mountainFile + "']")));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//a[contains(@class,'tem_open') and text()='" + riverFile + "']")));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//a[contains(@class,'tem_open') and text()='" + treeFile + "']")));
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
