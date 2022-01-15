package Application;

import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationApplication {
		WebDriver driver = new ChromeDriver();     
        String text = "Monica Gonzalez";     
        
        @BeforeTest
        public void webdriverSetup() {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
        
        @Test
        public void findingTextAndVideo() throws Exception{
        WebsitePage websitePage = new WebsitePage();
        websitePage.setDriver(driver);
        Boolean findVideo = websitePage.findVideo();
        Boolean findText = websitePage.findText(text);
		Assert.assertEquals(findVideo && findText, true);
		System.out.println("Test is passed.");		
		driver.close();
        }
    }
