import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Checkboxes {
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
    public void verifyFirstCheckboxIsUnchecked()
    {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        Boolean isSelectedDefault = checkbox1.isSelected();
        Assert.assertEquals(isSelectedDefault, false);
        checkbox1.click();
        Boolean isSelectedAfterClick = checkbox1.isSelected();
        Assert.assertEquals(isSelectedAfterClick, true);
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        Boolean isSelected2Default = checkbox2.isSelected();
        Assert.assertEquals(isSelected2Default, true);
        checkbox2.click();
        Boolean isSelected2AfterClick = checkbox2.isSelected();
        Assert.assertEquals(isSelected2AfterClick, false);

    }

   @AfterClass
   public void closeBrowser()
    {
      driver.quit();
   }
    }
