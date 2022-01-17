package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebsitePage {
    WebDriver driver;
	
	public Boolean findVideo() throws Exception {
        String refUrl = "https://edusoftlearning.com/success-stories/";		
        driver.get(refUrl);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"vid-1_html5_api\"]"));
        if (element.isDisplayed())
        {
        	System.out.println("Video is found.");
        	return true;
        }
        else 
        	return false;
	}
	
	public Boolean findText (String text) throws Exception {
        String refUrl = "https://edusoftlearning.com/success-stories/";		
        driver.get(refUrl);
        WebElement element = driver.findElement(By.xpath("//*[text()='" + text + "']"));
        if (element.isDisplayed())
        {
        	System.out.println("Text is found.");
        	return true;
        }
        else 
        	return false;
	}
	
	public void setDriver(WebDriver webdriver) {
        this.driver = webdriver;
	}
	
	public WebDriver getDriver() {
        return driver;
	}

}
