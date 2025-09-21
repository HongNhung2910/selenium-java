package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Topic_45_Wait_Part2_FindElement {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     }

    @Test
    public void TC_01_Find_Element(){
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Fregister");

        //Tìm element có 1 cái duy nhất
        System.out.println("Start Time: " + getDateTimeNow());
        driver.findElement(By.cssSelector("input#small-searchterms"));
        System.out.println("End Time: " + getDateTimeNow());

        //Tìm element có nhiều hơn 1,luôn lấy element đầu tiên để thao tác
        System.out.println("Start Time: " + getDateTimeNow());
        driver.findElement(By.cssSelector("input[type = 'email']")).sendKeys("nhung@gmail.com");
        System.out.println("End Time: " + getDateTimeNow());


        //Tìm element mà k thấy: Hết thời gian k thấy thì show exception
        System.out.println("Start Time: " + getDateTimeNow());
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
        System.out.println("End Time: " + getDateTimeNow());

    }

    @Test
    public void TC_02_Find_Elements(){
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Fregister");
        List<WebElement> elementList = null;

        //1 - Tìm element có duy nhất 1 cái
        System.out.println("Start Time: " + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input#small-searchterms"));
        System.out.println("Tổng số lượng element trong List: " + elementList.size());
        System.out.println("End Time: " + getDateTimeNow());

        //2 - Tìm element có nhiêu hơn 1 cái
        System.out.println("Start Time: " + getDateTimeNow());
        elementList = driver.findElements(By.xpath("//a[@href]"));
        System.out.println("End Time: " + getDateTimeNow());

        System.out.println("Tổng số lượng element trong List: " + elementList.size());
        for (WebElement element:elementList){
            System.out.println(element.getDomProperty("href"));
        }

        //3 - Nếu như không tìm thấy element nào
        System.out.println("Start Time: " + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input#FirstName"));
        System.out.println("Tổng số lượng element trong List: " + elementList.size());
        System.out.println("End Time: " + getDateTimeNow());

        //Chờ hết timeout: nếu không tìm thấy thì không đánh fail testcase, trả về 1 list rỗng = 0
    }

    private String getDateTimeNow(){
        return new Date().toString();
    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
