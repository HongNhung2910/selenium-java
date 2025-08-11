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

public class Topic_28_Custom_Dropdown_PartII {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC01_JQuery() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        selectItemInSelectableDropdown("//span[@id='speed-button']","//ul[@id='speed-menu']/li/div","Faster");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']/span[@class='ui-selectmenu-text']")).getText(),"Faster");

        selectItemInSelectableDropdown("//span[@id='number-button']","//ul[@id='number-menu']/li","5");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(),"5");

        selectItemInSelectableDropdown("//span[@id='salutation-button']","//ul[@id='salutation-menu']/li[@class='ui-menu-item']","Mrs.");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='salutation-button']/span[@class='ui-selectmenu-text']")).getText(),"Mrs.");

    }

    @Test
    public void TC02_ReactJS() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        selectItemInSelectableDropdown("//div[@class='ui fluid selection dropdown']","//div[@class='visible menu transition']/div/span","Christian");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ui fluid selection dropdown']")).getText(),"Christian");

        selectItemInSelectableDropdown("//div[@class='ui fluid selection dropdown']","//div[@class='visible menu transition']/div/span","Jenny Hess");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ui fluid selection dropdown']")).getText(),"Jenny Hess");

    }

    @Test
    public void TC03_VueJS() throws InterruptedException {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectItemInSelectableDropdown("//li[@class='dropdown-toggle']","//ul[@class='dropdown-menu']/li/a","First Option");
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(),"First Option");

        selectItemInSelectableDropdown("//li[@class='dropdown-toggle']","//ul[@class='dropdown-menu']/li/a","Third Option");
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(),"Third Option");

    }

    @Test
    public void TC04_Editable() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

        selectItemEditableDropdown("//input[@class='search']","//div[@class='visible menu transition']//span","Albania");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"Albania");

        selectItemEditableDropdown("//input[@class='search']","//div[@class='visible menu transition']//span","Bahamas");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"Bahamas");

    }

    @Test
    public void TC05_FinPeace() throws InterruptedException {
        driver.get("https://sps.finpeace.vn/tools/sktccn");
        Thread.sleep(5000);
        selectItemEditableDropdown("//input[@id='job_id']","//div[@id='job_id_list']/following-sibling::div[@class='rc-virtual-list']//div[@class='ant-select-item-option-content']","Công nghệ thông tin");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@title='Nghề nghiệp']/parent::div/following-sibling::div//span[@class='ant-select-selection-item']")).getText(),"Công nghệ thông tin");

        selectItemEditableDropdown("//input[@id='gender']","//div[@id='gender_list']/following-sibling::div[@class='rc-virtual-list']//div[@class='ant-select-item-option-content']","Nữ");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@title='Giới tính']/parent::div/following-sibling::div//span[@class='ant-select-selection-item']")).getText(),"Nữ");

        selectItemEditableDropdown("//input[@id='married_status']","//div[@id='married_status_list']/following-sibling::div[@class='rc-virtual-list']//div[@class='ant-select-item-option-content']","Kết hôn, đã có con");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@title='Tình trạng hôn nhân']/parent::div/following-sibling::div//span[@class='ant-select-selection-item']")).getText(),"Kết hôn, đã có con");
    }


    private void selectItemInSelectableDropdown(String parentXpath, String childXpath, String expectedTextItem) throws InterruptedException {
        driver.findElement(By.xpath(parentXpath)).click();
        List <WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath(childXpath)));

        for (WebElement temp : allItems){
            //String textItem = temp.getText();
            if(temp.getText().equals(expectedTextItem)){
                temp.click();
                Thread.sleep(5000);
                break;
            }
        }
    }

    private void selectItemEditableDropdown(String editableXpath, String childXpath, String expectedTextItem) throws InterruptedException {
        driver.findElement(By.xpath(editableXpath)).clear();
        driver.findElement(By.xpath(editableXpath)).sendKeys(expectedTextItem);
        Thread.sleep(3000);
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath(childXpath)));

        for (WebElement temp : allItems){
            //String textItem = temp.getText();
            if(temp.getText().equals(expectedTextItem)){
                temp.click();
                Thread.sleep(5000);
                break;
            }
        }
    }


    @AfterClass
    public void afterClass(){

        driver.quit();
    }

}
