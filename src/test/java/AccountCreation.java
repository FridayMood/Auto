import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class AccountCreation {
    private WebDriver driver;
    @Test
    public void accountCreationTest()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments ("--incognito");
        chromeOptions.addArguments ("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.xpath("//input[@name = 'zip_code']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
        driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys("Ivan");
        driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys("Petrov");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("aaa@gmail.com");
        driver.findElement(By.xpath("//input[@name = 'password1']")).sendKeys("12345d$");
        driver.findElement(By.xpath("//input[@name = 'password2']")).sendKeys("12345d$");
        driver.findElement(By.xpath("//input[@value = 'Register']")).click();
        String confirmationMessage = driver.findElement(By.xpath("//span[@class = 'confirmation_message']")).getText();
        Assert.assertEquals(confirmationMessage, "Account is created!");
    }

    @AfterClass
    public void closeBrowser()
    {
        driver.quit();
    }
}
