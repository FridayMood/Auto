import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
        @Test
        public void verifyRegistrationPageTest()
        {
           System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
 ChromeOptions chromeOptions = new ChromeOptions();
 chromeOptions.addArguments ("--incognito");
            chromeOptions.addArguments ("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(chromeOptions);
            driver.get("https://www.sharelane.com/cgi-bin/register.py");
            driver.findElement(By.xpath("//input[@name = 'zip_code']")).sendKeys("12345");
            driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
            driver.findElement(By.xpath("//input[@value = 'Register']")).click();
            String errorMessage = driver.findElement(By.xpath("//span[@class = 'error_message']")).getText();
            Assert.assertEquals(errorMessage, "Oops, error on page. Some of your fields have invalid data or email was previously used");
        }

        @AfterClass
    public void closeBrowser()
        {
            driver.quit();
        }
    }
