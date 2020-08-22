package o1_SeleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class oo51_KeysActions {

	public static void main(String[] args) {
	
//Following line required since Selenium 3.0 : 
	      
			System.setProperty("webdriver.chrome.driver","/Users/bobit/Documents/Drivers/chromedriver"); 
		    WebDriver driver = new ChromeDriver();
		    String URL = "https://demoqa.com/text-box";
	     
//Open the browser	
	      driver.get(URL);
	     
// It is always advisable to Maximize the window before performing DragNDrop action 
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS); 
	    
//Find web elements
	      WebElement userName = driver.findElement(By.id("userName"));
	      WebElement currAddr = driver.findElement(By.id("currentAddress"));
	      WebElement perAddr = driver.findElement(By.id("permanentAddress")); 
	      WebElement submitButton = driver.findElement(By.id("submit"));
	    
//Instantiate Actions class
	     Actions actions = new Actions(driver);
	     actions.sendKeys(userName,"Mr.Jones").perform();

//Enter current address 
	     actions.click(currAddr).sendKeys("1205 OAK STREET,OLD FORGE,NEW YORK,11240").perform();

//Copy current address 
	     actions.keyDown(currAddr,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform(); 
	     actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(perAddr,Keys.CONTROL).perform();

//Paste current address in permanent address text field
	     actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

//Click on Submit button
	     submitButton.click();

// Accept the Alert 
	//		     driver.switchTo().alert().accept();
	//		     System.out.println("Submit Alert Accepted");

// Close the main window 
	    driver.close(); 

	}

}
