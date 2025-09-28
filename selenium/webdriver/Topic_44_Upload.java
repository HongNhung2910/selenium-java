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
    String MountainFile="moutain.png";
    String RiverFile="River.png";
    String TreeFile="Tree.png";

    String uploadMountainPath= uploadFilePath+MountainFile;
    String uploadRiverPath= uploadFilePath+RiverFile;
    String uploadTreePath= uploadFilePath+TreeFile;

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
        driver.findElement(uploadFile).sendKeys(uploadMountainPath);
        driver.findElement(uploadFile).sendKeys(uploadRiverPath);
        driver.findElement(uploadFile).sendKeys(uploadTreePath);
        Thread.sleep(4000);

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+MountainFile+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+RiverFile+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+TreeFile+"']")).isDisplayed());

        //Click upload
        List<WebElement> startUploadButton= driver.findElements(By.cssSelector("table button.start"));
        for (WebElement startButton:startUploadButton){
            startButton.click();
            Thread.sleep(1000);
        }

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+MountainFile+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+RiverFile+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+TreeFile+"']")).isDisplayed());
    }

    @Test
    public void TC_01_Multiple_File() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadFile= By.cssSelector("input[type='file']");

        //Tải file
        driver.findElement(uploadFile).sendKeys(uploadMountainPath +"\n"+ uploadRiverPath + "\n"+ uploadTreePath);
        Thread.sleep(4000);

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+MountainFile+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+RiverFile+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+TreeFile+"']")).isDisplayed());

        //Click upload
        List<WebElement> startUploadButton= driver.findElements(By.cssSelector("table button.start"));
        for (WebElement startButton:startUploadButton){
            startButton.click();
            Thread.sleep(1000);
        }

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+MountainFile+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+RiverFile+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+TreeFile+"']")).isDisplayed());
    }

    @Test
    public void TC_02(){

    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
