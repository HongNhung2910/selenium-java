package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;




public class Topic_25_Textbox_TextArea {
    WebDriver driver;
    String  firstName, lastName, emailAdress, password,fullName, employeeID, passportNumber, passportComment;
    @BeforeClass
    public void beforeClass(){
        FirefoxOptions options=new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        driver= new FirefoxDriver(options);

        firstName="Marry";
        lastName="May";
        fullName=firstName+" "+lastName;
        emailAdress="Marry"+ new Random().nextInt(9999)+"@gmail.com";
        password="May@123456";
        passportNumber="432765098";
        passportComment="Input passport Number";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01()
    {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
      //  driver.findElement(By.cssSelector("input#middlename")).sendKeys();
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAdress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);

        driver.findElement(By.cssSelector("button[title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Thank you for registering with Main Website Store.");
        String contactInfo=driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAdress));

        driver.findElement(By.xpath("//h3[text()='Contact Information']/following-sibling::a")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("input#firstname")).getDomAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#lastname")).getDomAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#email")).getDomAttribute("value"),emailAdress);

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//h2/a[@title='Samsung Galaxy']")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();

        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("textarea#review_field")).sendKeys("Thank you\nfor registering ");
        driver.findElement(By.cssSelector("input#summary_field")).sendKeys("Good");
        driver.findElement(By.cssSelector("input#nickname_field")).sendKeys(fullName);

        driver.findElement(By.xpath("//button[@title='Submit Review']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Your review has been accepted for moderation.");


    }

    @Test
    public void TC_02() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //Login
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        //Đợi loading icon biến mất
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div[class='oxd-loading-spinner']"))));
        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());

        //CLick vào PIM
        driver.findElement(By.xpath("//span[text()='PIM']/parent::a")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='PIM']")).isDisplayed());

        //Click vào tab Add Employee
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        Assert.assertTrue(isLoadingIconDisplay());//đợi loading xong

        //Tạo employee
        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(lastName);
        employeeID= driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getDomProperty("value");
        System.out.println(employeeID);

        driver.findElement(By.xpath("//p[text()='Create Login Details']/following-sibling::div/label/span")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys(emailAdress);
        driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys(password);

        //CLick btn Save
        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
        Thread.sleep(2000);

       // Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Successfully Saved']")).isDisplayed());
        Assert.assertTrue(isLoadingIconDisplay());

        Assert.assertTrue(isLoadingIconDisplay());
        //Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Personal Details']")).isDisplayed());

        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName']")).getDomProperty("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName']")).getDomProperty("value"),lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getDomProperty("value"),employeeID);

        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Assert.assertTrue(isLoadingIconDisplay());

        driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button[contains(string(),'Add')]")).click();
        driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys(passportNumber);
        driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).sendKeys(passportComment);

        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Successfully Saved']")).isDisplayed());
        Assert.assertTrue(isLoadingIconDisplay());

        //CLick icon sửa

        //Verify data
       // Assert.assertTrue(driver.findElement(By.xpath("//div[text()=Passport]/parent::div/following-sibling::div/div[text()='"+passportNumber+"']")).isDisplayed());

        driver.findElement(By.cssSelector("i.oxd-icon.bi-pencil-fill")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getDomProperty("value"),passportNumber);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getDomProperty("value"),passportComment);

        //logout
        driver.findElement(By.cssSelector("li.oxd-userdropdown")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        //Login
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(emailAdress);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        //CLick vào My info
        driver.findElement(By.xpath("//span[text()='My info']/parent::a")).click();
        Assert.assertTrue(isLoadingIconDisplay());

        //Kiểm tra data
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName']")).getDomProperty("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName']")).getDomProperty("value"),lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getDomProperty("value"),employeeID);
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).isEnabled());

        //Click tab Immigration
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Assert.assertTrue(isLoadingIconDisplay());

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()=Passport]/parent::div/following-sibling::div/div[text()='"+passportNumber+"']")).isDisplayed());



    }

    private Boolean isLoadingIconDisplay() {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
                .invisibilityOfAllElements(driver.findElements(By.cssSelector("div[class='oxd-loading-spinner']"))));
    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }
}
