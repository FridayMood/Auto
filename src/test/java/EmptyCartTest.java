import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class EmptyCartTest {
    private WebDriver driver;
    @Test
    public void emptyCartForNotLoggedInUserTest()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments ("--incognito");
        chromeOptions.addArguments ("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.xpath("//a[@href='./shopping_cart.py']")).click();
        String errorMessage = driver.findElement(By.xpath("//span[@class = 'error_message']")).getText();
        Assert.assertEquals(errorMessage, "Oops, error. You must log in");
    }

    @AfterClass
    public void closeBrowser()
    {
        driver.quit();
    }
}