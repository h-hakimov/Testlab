
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class BrowserActions {
    
    private WebDriver driver;
    
    public void init(){
        WebDriverManager.chromedriver().version("77.0.3865.40").setup();
        driver = new ChromeDriver();
    }
    
    public void moveToUrl(String url){
        driver.navigate().to(url);
    }
    
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
    
    public void click(String xpath){
        driver.findElement(By.xpath(xpath)).click();
        try {
            Thread.sleep(500L);
        } catch (InterruptedException ex) {
            Logger.getLogger(BrowserActions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setValue(String xpath, String value){
        driver.findElement(By.xpath(xpath)).sendKeys(value);
        try {
            Thread.sleep(500L);
        } catch (InterruptedException ex) {
            Logger.getLogger(BrowserActions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean checkElementVisible(String xpath){
        return isVisible(By.xpath(xpath));
    }
    
    public void screenshot(){
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screenshot.png"));
        } catch (IOException ex) {
            Logger.getLogger(BrowserActions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean isVisible(By by){
        try{
            driver.findElement(by);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException ex){
            return false;
        }
    }
}
