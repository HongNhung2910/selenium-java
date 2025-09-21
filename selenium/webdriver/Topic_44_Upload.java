package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_44_Upload {
    WebDriver driver;
    String uploadFilePath=System.getProperty("user.dir")+"\\uploadFiles\\";
    String anh1="anh1.jpg";
    String anh2="anh2.jpg";
    String anh3="anh3.jpg";

    String uploadAnh1Path= uploadFilePath+anh1;
    String uploadAnh2Path= uploadFilePath+anh2;
    String uploadAnh3Path= uploadFilePath+anh3;

    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Single_File() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadFile= By.cssSelector("input[type='file']");

        //Tải file
        driver.findElement(uploadFile).sendKeys(uploadAnh1Path);
        driver.findElement(uploadFile).sendKeys(uploadAnh2Path);
        driver.findElement(uploadFile).sendKeys(uploadAnh3Path);
        Thread.sleep(4000);

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+anh1+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+anh2+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+anh3+"']")).isDisplayed());

        //Click upload
        List<WebElement> startUploadButton= driver.findElements(By.cssSelector("table button.start"));
        for (WebElement startButton:startUploadButton){
            startButton.click();
            Thread.sleep(1000);
        }

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+anh1+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+anh2+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+anh3+"']")).isDisplayed());
    }

    @Test
    public void TC_01_Multiple_File() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadFile= By.cssSelector("input[type='file']");

        //Tải file
        driver.findElement(uploadFile).sendKeys(uploadAnh1Path +"\n"+ uploadAnh2Path + "\n"+ uploadAnh3Path);
        Thread.sleep(4000);

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+anh1+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+anh2+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+anh3+"']")).isDisplayed());

        //Click upload
        List<WebElement> startUploadButton= driver.findElements(By.cssSelector("table button.start"));
        for (WebElement startButton:startUploadButton){
            startButton.click();
            Thread.sleep(1000);
        }

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+anh1+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+anh2+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+anh3+"']")).isDisplayed());
    }

    @Test
    public void TC_02(){

    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
