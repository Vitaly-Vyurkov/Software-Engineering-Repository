package Application;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
    WebDriver driver;// = new ChromeDriver();
	
	public void logging (String login, String password) throws Exception {
        String refUrl = "https://protonmail.com/";		
        driver.get(refUrl);
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[8]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(login + Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password + Keys.ENTER);
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/main/div[2]/form/button"));
        if (element.isEnabled()) {element.click();};
        Thread.sleep(35000);
        System.out.println("Logging to email account is performed.");
	}
	
	public void setDriver(WebDriver webdriver) {
        this.driver = webdriver;
	}
	
	public WebDriver getDriver() {
        return driver;
	}

}
