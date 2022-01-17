package Application;

import java.time.Duration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationApp {
	WebDriver driver = new ChromeDriver();     
    String text = "Monica Gonzalez"; 
	
    @BeforeEach
    void startUp(){
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    
	@Test
	public void findTextAndVideo() throws Exception{
    WebsitePage websitePage = new WebsitePage();
    websitePage.setDriver(driver);
    Boolean findVideo = websitePage.findVideo();
    Boolean findText = websitePage.findText(text);
	Assert.assertEquals(findVideo && findText, true);
	System.out.println("Test is passed.");		
	driver.close();
	}
	/*
	public static void main (String[] args) throws Exception {   
		AutomationApplication.run();
			}
			*/
}
