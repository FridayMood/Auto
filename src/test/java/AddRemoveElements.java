import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AddRemoveElements {
        private WebDriver driver;

        @BeforeClass
        public void setUp()
        {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments ("--incognito");
            chromeOptions.addArguments ("--remote-allow-origins=*");
            driver = new ChromeDriver(chromeOptions);
        }
        @Test
        public void verifyAddRemoveFunctionality()
        {
            driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
            driver.findElement(By.xpath("//button[text()='Add Element']")).click();
            driver.findElement(By.xpath("//button[text()='Add Element']")).click();
            driver.findElement(By.xpath("//button[text()='Delete']")).click();
            List<WebElement> elements = driver.findElements(By.xpath("//button[text()='Delete']"));
            int actualElements = elements.size();
            Assert.assertEquals(actualElements, 1);
        }
       @AfterClass
       public void closeBrowser()
        {
            driver.quit();
        }

    }
