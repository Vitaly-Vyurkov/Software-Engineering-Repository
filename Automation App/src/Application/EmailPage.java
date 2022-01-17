package Application;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmailPage {
	WebDriver driver;
	
	public void sendingEmail (String email, String subject, String text) throws Exception {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/button")).click();
        driver.findElement(By.xpath("//*[starts-with(@id, 'to-composer')]")).sendKeys(email + Keys.ENTER);
        driver.findElement(By.xpath("//*[starts-with(@id, 'subject-composer')]")).sendKeys(subject + Keys.TAB + text);
		driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div/footer/div/div[1]/button/span")).click();
        System.out.println("Sending of email is performed.");
	}
	public void setDriver(WebDriver webdriver) {
		this.driver = webdriver;
	}
	
	public WebDriver getDriver() {
        return driver;
	}
}
