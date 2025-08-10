package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;


public class Topic_27_Default_Dropdown {
    WebDriver driver;
    Select select;
    @BeforeClass
    public void beforeClass(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01() throws InterruptedException {
        driver.get("https://www.facebook.com/r.php?entry_point=login");

     //Khởi tạo thư viện select
        select= new Select(driver.findElement(By.cssSelector("select#month")));

        //Chọn giá trị
        select.selectByIndex(3);
        Thread.sleep(2000);

        select.selectByValue("9");
        Thread.sleep(2000);
        select.selectByVisibleText("Dec");
        Thread.sleep(2000);
        select.selectByContainsVisibleText("Au");
       Thread.sleep(2000);

        //Kiem tra chọn thành công
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Dec");

        //Kiểm tra tổng số item
        Assert.assertEquals(select.getOptions().size(),12);

        //Kiểm tra có cho chọn nhiều không
        Assert.assertFalse(select.isMultiple());
    }

    @Test
    public void TC_02() throws InterruptedException {
        driver.get("https://rode.com/en/support/where-to-buy");
        new Select(driver.findElement(By.cssSelector("select#country"))).selectByVisibleText("Vietnam");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input#map_search_query")).sendKeys("HO CHI MINH");
        driver.findElement(By.xpath("//button[text()='Search']")).click();

        Assert.assertEquals(driver.findElements(By.xpath("//h3[text()='Dealers']/following-sibling::div/div")).size(),16);

        List <WebElement> dealers= driver.findElements(By.xpath("//h3[text()='Dealers']/following-sibling::div/div//h4"));
        for (WebElement temp: dealers){
            System.out.println(temp.getText());
        }

    }
    @AfterClass
    public void afterClass(){

        driver.quit();
    }
}
