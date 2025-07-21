package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_16_Relative_Locator {
    WebDriver driver;
    @BeforeClass
    public void beforeclass(){
        driver = new EdgeDriver();
        driver.get("https://www.nopcommerce.com/en/register?returnUrl=%2Fen%2Flogin");
    }

    @Test
    public void TC01(){

        //Remember me text
        WebElement rememBerText = driver.findElement(RelativeLocator.with(By.tagName("label"))
                .above(By.cssSelector("button.blue-button"))
                .below(By.id("Password"))
                .toRightOf(By.id("RememberMe"))
                .toLeftOf(By.xpath("//a[text()='Forgot username or password?']")));
        System.out.println(rememBerText.getText());
    }

    @Test
    public void TC02(){
        driver.findElement(By.xpath("//input[@id ='FirstName']"));
        driver.findElement(By.xpath("//input[@id ='LastName']"));
        driver.findElement(By.xpath("//input[@id ='Email']"));
        driver.findElement(By.xpath("//input[@id ='ConfirmEmail']"));
        driver.findElement(By.xpath("//input[@id ='Username']"));
        driver.findElement(By.xpath("//input[@id='check-availability-button']"));
        driver.findElement(By.xpath("//select[@id='CountryId']"));
        driver.findElement(By.xpath("//select[@id='TimeZoneId']"));
        driver.findElement(By.xpath("//input[@id='Password']"));
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        driver.findElement(By.xpath("//select[@id='Details_CompanyIndustryId']"));
        driver.findElement(By.xpath("//select[@id='Details_CompanyRoleId']"));
        driver.findElement(By.xpath("//select[@id='Details_CompanySizeId']"));
        driver.findElement(By.xpath("//input[@id='Details_CompanyWebsiteUrl']"));
        driver.findElement(By.xpath("//input[@id='register-button']"));



    }

       @AfterClass
    public void afterclass(){
        driver.quit();
    }
}
