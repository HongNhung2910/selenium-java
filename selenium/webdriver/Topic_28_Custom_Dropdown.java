package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_28_Custom_Dropdown {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_OrangeHRM1() throws InterruptedException {
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
        Assert.assertTrue(isLoadingIconDisplay());
        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='PIM']")).isDisplayed());

        //Chọn 1 giá trị trong Employment Status
        //1-Click vào element
        driver.findElement(By.xpath("//label[text()='Employment Status']/parent::div/following-sibling::div/div")).click();

        //2- Lưu vào list để chọn
        List<WebElement> allItems_employmentStatus = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                "//label[text()='Employment Status']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span")));
        //3-Vòng lặp duyệt qua các element
        for (WebElement temp:allItems_employmentStatus){
            String textItem= temp.getText();
            System.out.println(textItem);
            if (textItem.equals("Freelance")){
                temp.click();
                Thread.sleep(2000);
                break;
            }
        }

        //Chọn 1 giá trị trong Include
        //1-Click vào element
        driver.findElement(By.xpath("//label[text()='Include']/parent::div/following-sibling::div/div")).click();

        //2- Lưu vào list để chọn
        List<WebElement> allItems_include = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                "//label[text()='Include']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span")));

        //3-Vòng lặp duyệt qua các element
        for (WebElement temp:allItems_include){
            String textItem= temp.getText();
            System.out.println(textItem);
            if (textItem.equals("Past Employees Only")){
                temp.click();
                Thread.sleep(2000);
                break;
            }
        }

        //Chọn 1 giá trị trong Job Title
        //1-Click vào element Job Title
        driver.findElement(By.xpath("//label[text()='Job Title']/parent::div/following-sibling::div/div")).click();

        //2- Lưu vào list để chọn
        List<WebElement> allItems_jobTitle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                "//label[text()='Job Title']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span")));
        //3-Vòng lặp duyệt qua các element
        for (WebElement temp:allItems_jobTitle){
            String textItem= temp.getText();
            System.out.println(textItem);
            if (textItem.equals("Chief Financial Officer")){
                temp.click();
                Thread.sleep(2000);
                break;
            }
        }

        //Chọn 1 giá trị trong Sub Unit
        //1-Click vào element
        driver.findElement(By.xpath("//label[text()='Sub Unit']/parent::div/following-sibling::div/div")).click();

        //2- Lưu vào list để chọn
        List<WebElement> allItems_subUnit = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                "//label[text()='Sub Unit']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span")));
        //3-Vòng lặp duyệt qua các element
        for (WebElement temp:allItems_subUnit){
            String textItem= temp.getText();
            System.out.println(textItem);
            if (textItem.equals("Administration")){
                temp.click();
                Thread.sleep(2000);
                break;
            }
        }

    }


    @Test
    public void TC_02_OrangeHRM2() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        //Đợi loading icon biến mất
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div[class='oxd-loading-spinner']"))));
        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());

        //CLick vào PIM
        driver.findElement(By.xpath("//span[text()='PIM']/parent::a")).click();
        Assert.assertTrue(isLoadingIconDisplay());
        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='PIM']")).isDisplayed());

        //Chọn emloyed status
        selectItemDropdown("//label[text()='Employment Status']/parent::div/following-sibling::div/div",
                "//label[text()='Employment Status']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span",
                "Full-Time Contract");
        List<WebElement> allItems;

        //Chọn inlude
        selectItemDropdown("//label[text()='Include']/parent::div/following-sibling::div/div",
                "//label[text()='Include']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span",
                "Past Employees Only");

        //Chọn Job title
        selectItemDropdown("//label[text()='Job Title']/parent::div/following-sibling::div/div",
                "//label[text()='Job Title']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span",
                "Chief Executive Officer");

        //Chọn sub Unit
        selectItemDropdown("//label[text()='Sub Unit']/parent::div/following-sibling::div/div",
                "//label[text()='Sub Unit']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span",
                "Administration");

        //Verify dữ liệu đã chọn
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employment Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']"))
                .getText(),"Full-Time Contract");

        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Include']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']"))
                .getText(),"Past Employees Only");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Job Title']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']"))
                .getText(),"Chief Executive Officer");
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Sub Unit']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']"))
                .getText(),"Administration");



    }

    private Boolean isLoadingIconDisplay() {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
                .invisibilityOfAllElements(driver.findElements(By.cssSelector("div[class='oxd-loading-spinner']"))));
    }

    public void selectItemDropdown(String parentLocator, String childLocator, String expectedTextItem) throws InterruptedException {
        driver.findElement(By.xpath(parentLocator)).click();

        //2- Lưu vào list để chọn
        List<WebElement> allItems_include = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childLocator)));

        //3-Vòng lặp duyệt qua các element
        for (WebElement temp:allItems_include){
              if (temp.getText().equals(expectedTextItem)){
                temp.click();
                Thread.sleep(2000);
                break;
            }
        }
    }

    @AfterClass
    public void afterClass(){

        driver.quit();
    }
}
