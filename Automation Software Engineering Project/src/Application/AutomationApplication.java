package Application;

import java.time.Duration;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationApplication {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String login = "newukrainianemail";
        String password = "newpassword";
        String email = "VitalyV@i.ua";
        String subject = "New email";        
        String text = "Hi!";          
        
        HomePage homePage = new HomePage();
        homePage.setDriver(driver);
        homePage.logging(login, password);
        
        EmailPage emailPage = new EmailPage();
        emailPage.setDriver(homePage.getDriver());
        emailPage.sendingEmail(email, subject, text);
        driver = emailPage.getDriver();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[4]/nav/div/ul/li[3]/a/span/span[1]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'New email')]")).isDisplayed(), true);
		System.out.println("Test is passed.");		
		driver.close();
        
        /*
        String refUrl = "https://protonmail.com/";

        //Test 1. Opening the web page
        driver.get(refUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[8]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("newukrainianemail" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("newpassword" + Keys.ENTER);
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/main/div[2]/form/button"));
        if (element.isEnabled()) {element.click();};
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/button")).click();
        driver.findElement(By.xpath("//*[starts-with(@id, 'to-composer')]")).sendKeys("VitalyV@i.ua" + Keys.ENTER);
        driver.findElement(By.xpath("//*[starts-with(@id, 'subject-composer')]")).sendKeys("New email" + Keys.TAB + "Hi!");
		driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div/footer/div/div[1]/button/span")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[4]/nav/div/ul/li[3]/a/span/span[1]")).click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'New email')]")).isDisplayed(), true);
		System.out.println("Test is passed.");		
		driver.close();
		*/
    }
}
