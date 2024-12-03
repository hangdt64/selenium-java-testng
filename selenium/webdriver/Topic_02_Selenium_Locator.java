package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {

    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/register");
    }


    @Test
    public void TC_01_ID() throws InterruptedException {
        driver.findElement(By.id("small-searchterms")).sendKeys("Macbook");
        Thread.sleep(3000);

        driver.findElement(By.id("FirstName")).sendKeys("Automation");
        Thread.sleep(3000);

    }

    @Test
    public void TC_02_Class() {
        // Nó ko lấy hết toàn bộ giá trị nếu có khoảng trắng
        // Giá trị có khoảng trắng, lấy phần nào là duy nhất
        driver.findElement(By.className("register-next-step-button")).click();
        Thread.sleep(3000);

    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("DateOfBirthDay"));
        driver.findElement(By.name("DateOfBirthMonth"));
        driver.findElement(By.name("DateOfBirthYear"));
    }

    @Test
    public void TC_04_LinkText() {
        // Chỉ làm việc vs element là link và có text
        // Link có thẻ a và thuộc tính href
        // Phải lấy hết toàn bộ text
        driver.findElement(By.linkText("Register"));
        driver.findElement(By.linkText("Log in"));
        driver.findElement(By.linkText("Wishlist"));
    }

    @Test
    public void TC_05_Partial_Link_Text() {
        // Chỉ làm việc vs element là link
        // Có thể thể lấy toàn bộ hoặc 1 phần
        driver.findElement(By.partialLinkText("Register"));
        driver.findElement(By.partialLinkText("downloads"));

    }
 @Test
 public void TC_06_Tagname() {
        // Tên thẻ html
     // Tìm tất cả các element giống nhau (thẻ của component giống nhau)
     // Tất cả các textbox/checkbox/radio/link/button/...
     driver.findElement(By.tagName("button"));

     driver.findElement(By.tagName("input"));

     driver.findElement(By.tagName("label"));
 }

 @Test
 public void TC_07_Css() {
        driver.findElement(By.cssSelector("input#Company"));
     driver.findElement(By.cssSelector("#Company"));
     driver.findElement(By.cssSelector("input[id='Company']"));
     driver.findElement(By.cssSelector("button.register-next-step-button"));
     driver.findElement(By.cssSelector("button[class='button-1 register-next-step-button']"));
     driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"));
     driver.findElement(By.cssSelector("a[href*='register?']"));
     driver.findElement(By.cssSelector("a[href='/register?returnUrl=%2F%3Fgp%3D1%26js%3D1%26uuid%3D1733143984.0071392973%26other_args%3DeyJ1cmkiOiAiLyIsICJhcmdzIjogIiIsICJyZWZlcmVyIjogIiIsICJhY2NlcHQiOiAidGV4dC9odG1sLGFwcGxpY2F0aW9uL3hodG1sK3htbCxhcHBsaWNhdGlvbi94bWw7cT0wLjksKi8qO3E9MC44In0%3D']"));
     driver.findElement(By.cssSelector("input"));

    }

    @Test
    public void TC_08_Xpath() {
        driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        driver.findElement(By.xpath("//input[@id='Password']"));
        driver.findElement(By.xpath("//input[@id='Company']"));

        driver.findElement(By.xpath("//button[@class='button-1 register-next-step-button']"));
        driver.findElement(By.xpath("//button[contains(@class,'register-next-step-button')]"));

        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));

        driver.findElement(By.xpath("//a[text()='Register']"));
        driver.findElement(By.xpath("//a[contains(text(),'Register')]"));

        driver.findElement(By.xpath("//a"));
        driver.findElement(By.xpath("//button"));
        driver.findElement(By.xpath("//input"));

    }
    @AfterClass
    public void cleanbrowser() {
        driver.quit();
    }
}