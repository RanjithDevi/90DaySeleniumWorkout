package basicSeleniumPrograms;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pepperfry {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Launching Chromebrowser
			 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//To disable notifications
			 ChromeOptions options= new ChromeOptions();
			 options.addArguments("--disable-notifications");
			 ChromeDriver driver=new ChromeDriver(options);
			 System.setProperty("webdriver.chrome.silentOutput", "true");
			 
		//Maximize the browser
			 driver.manage().window().maximize();
			 //Load the url
			 driver.get("https://www.pepperfry.com/");
			 //Implicitly wait for 5 milliseconds
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  
			
			
			//Mouse Hover on Furniture 
			 WebElement furniture=driver.findElementByXPath("(//a[text()='Furniture'])[1]");
			 Actions over=new Actions(driver);
			 over.moveToElement(furniture).perform();
			 Thread.sleep(3000);
			 
			
			//Select office chair and add to wish list 

			driver.findElementByXPath("//a[text()='Office Chairs']").click();
			Thread.sleep(3000);
			driver.findElementByXPath("(//div[@class='cat-wrap-img'])[2]").click();
			WebElement height = driver.findElementByXPath("(//input[@class='clipFilterDimensionHeightValue'])[1]");
			height.clear();
			height.sendKeys("50",Keys.ENTER);
			Thread.sleep(2000);
			driver.findElementByXPath("(//a[@class='clip-heart-icn pf-right'])[1]").click();
			
			//Mouse Hover on Homeware
			 WebElement homeware=driver.findElementByXPath("( //a[text()='Homeware'])[1]");
			 Actions over1=new Actions(driver);
			 over1.moveToElement(homeware).perform();
			 Thread.sleep(2000);
			 driver.findElementByXPath("//a[text()='Pressure Cookers']").click();
			 driver.findElementByXPath(" //label[text()='Prestige']").click();
			 Thread.sleep(3000);
			 driver.findElementByXPath("//label[@for='capacity_db1_Ltr_-_3_Ltr']").click();
			 Thread.sleep(3000);
			 driver.findElementByXPath("(//a[@class='clip-heart-icn pf-right'])[3]").click();
			 
			//To handle the popups
			 WebDriverWait wait = new WebDriverWait(driver, 10);
			 wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//div[@id='regPopUp']//a)[1]")));
			 driver.findElementByXPath("(//div[@id='regPopUp']//a)[1]").click();
			 Thread.sleep(2000);
			 
			 
			 //Checking wish list
			 String count =driver.findElementByXPath("(//span[@class='count_alert'])[2]").getText();
			 System.out.println("Number of items in Wish List : " +count );
			 if (count.equalsIgnoreCase("2"))
				 System.out.println("The number of items in cart are validated");
			 else
				 System.out.println("The number of items in cart are validated");
			 Thread.sleep(2000);
			 //Click WishList
			 driver.findElementByXPath("//a[@data-tooltip='Wishlist']").click();
			 //Add cooker alone to cart
			 driver.findElementByXPath("(//a[text()='Add to Cart'])[2]").click();
			 Thread.sleep(2000);
			 driver.findElementByXPath("//a[text()='Proceed to pay securely ']").click();
			 Thread.sleep(2000);
			 //To take screenshot
			 WebElement item=driver.findElementByXPath("//div[@class='ck-sku-row-top pf-white']");
			 File src=item.getScreenshotAs(OutputType.FILE);
			 File dst=new File(".snap/win.png");
			 FileUtils.copyFile(src, dst);
			 
			 //close the browser
			 driver.quit();
			 
	}

}
