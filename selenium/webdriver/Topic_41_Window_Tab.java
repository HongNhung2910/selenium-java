package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_41_Window_Tab {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_GitHub() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        //Lấy ra ID hiện tại của tab
        String githubWindowID=driver.getWindowHandle();
        System.out.println(githubWindowID);

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        sleepInSecond(3);

        switchToWindowByID(githubWindowID);

        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("Automation Testing");
        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys(Keys.ENTER);
        sleepInSecond(3);

        String googleWindowID= driver.getWindowHandle();
        switchToWindowByID(googleWindowID);

        driver.findElement(By.xpath("//a[text()='FACEBOOK']"));
        sleepInSecond(3);
        switchToWindowByTitle("Facebook");

        switchToWindowByTitle("Selenium WebDriver");
        sleepInSecond(2);

        driver.findElement(By.xpath("//a[text()='LAZADA']")).click();
        sleepInSecond(2);

        closeAllWindowWithoutParent(githubWindowID);
    }

    @Test
    public void TC_02_TechPanda() throws InterruptedException {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        sleepInSecond(3);

        driver.findElement(By.xpath("//a[text()='IPhone']/parent::h2" +
                "/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2" +
                "/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();

        driver.findElement(By.cssSelector("button[title='Compare']")).click();
        sleepInSecond(2);

        switchToWindowByTitle("Products Comparison List");

        driver.findElement(By.xpath("//span[text()='Close Window']")).click();
        sleepInSecond(2);

        switchToWindowByTitle("Mobile");

        driver.findElement(By.xpath("//a[text()='Clear All']")).click();

        driver.switchTo().alert().accept();
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"The comparison list was cleared.");
    }

    @Test
    public void TC_03_Cambridge() throws InterruptedException {
        driver.get("https://dictionary.cambridge.org/vi/");

        String homeWindowID = driver.getWindowHandle();

        driver.findElement(By.xpath("//header[@id='header']//span[text()='Đăng nhập']")).click();
        sleepInSecond(3);

        switchToWindowByTitle("Login");
        driver.findElement(By.cssSelector("input[value='Log in']")).click();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("span[id *='login-form-loginID']")).getText(),"This field is required");
        Assert.assertEquals(driver.findElement(By.cssSelector("span[id *='login-form-password']")).getText(),"This field is required");

        closeAllWindowWithoutParent(homeWindowID);

        String keyword="Selenium";

        driver.findElement(By.cssSelector("input#searchword")).sendKeys(keyword);
        driver.findElement(By.cssSelector("input#searchword")).sendKeys(Keys.ENTER);
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(@class,'uk')]/preceding-sibling::div[@class='di-title']/span/span")).getText(), keyword.toLowerCase());
    }

    @Test
    public void TC_04_Harvard() throws InterruptedException {
        driver.get("https://courses.dce.harvard.edu/");

        String homePageWindowID = driver.getWindowHandle();
        driver.findElement(By.cssSelector("a[data-action='login']")).click();
        sleepInSecond(4);

        switchToWindowByID(homePageWindowID);

        driver.findElement(By.xpath("//h1[text()='DCE Login Portal']")).isDisplayed();

        closeAllWindowWithoutParent(homePageWindowID);

        switchToWindowByTitle("DCE Course Search");

        Assert.assertTrue(driver.findElement(By.cssSelector("div.activescreen")).isDisplayed());

        driver.findElement(By.cssSelector("button[class*='button--cancel']")).click();
        sleepInSecond(2);

        driver.findElement(By.cssSelector("input#crit-keyword")).sendKeys("Data Science: An Artificial Ecosystem");
        new Select(driver.findElement(By.cssSelector("select#crit-srcdb"))).selectByVisibleText("Harvard Summer School 2025");
        new Select(driver.findElement(By.cssSelector("select#crit-session"))).selectByVisibleText("Harvard College");
        new Select(driver.findElement(By.cssSelector("select#crit-session"))).selectByVisibleText("Full Term");

        driver.findElement(By.cssSelector("button#search-button")).click();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("span.result__headline span.result__title")).getText(),"Data Science: An Artificial Ecosystem");
    }

    @Test
    public void TC_05_Selenium_4x() throws InterruptedException {
       driver.get("https://demo.nopcommerce.com/");

       driver.switchTo().newWindow(WindowType.TAB).get("https://admin-demo.nopcommerce.com");

        switchToWindowByTitle("Home page title");
        sleepInSecond(2);
    }

    private void sleepInSecond(long timeInSecond) throws InterruptedException {
        try{
            Thread.sleep(timeInSecond *1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    private void switchToWindowByID(String windowID){
        Set<String> allWindowIDs = driver.getWindowHandles();

        for (String id : allWindowIDs){
            if (!id.equals(windowID)){
                driver.switchTo().window(id);
                break;
            }
        }
    }

    private void switchToWindowByTitle(String expectedPageTitle) throws InterruptedException {
        Set<String> allWindowIDs = driver.getWindowHandles();

        for (String id : allWindowIDs){
            driver.switchTo().window(id);
            sleepInSecond(1);
            if (driver.getTitle().contains(expectedPageTitle)){
                break;
            }
        }
    }

    private void closeAllWindowWithoutParent(String windowID){
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs){
            if (!id.equals(windowID)){
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(windowID);
    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
