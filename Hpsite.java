package basicSeleniumPrograms;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Hpsite {
 
		public static void main(String[] args) throws InterruptedException {
			 //Launching Chromebrowser
			 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			 
			//To disable notifications
				ChromeOptions options= new ChromeOptions();
				options.addArguments("--disable-notifications");
				 	 
			 
			 ChromeDriver driver=new ChromeDriver(options);
			 //Maximize the browser
			 driver.manage().window().maximize();
			 //Load the url
			 driver.get("https://store.hp.com/in-en/");
			 //Implicitly wait for 5 milliseconds
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 Thread.sleep(3000);
			 
			// driver.findElementByXPath("//span[@class='optly-modal-close close-icon']").click();
			 Thread.sleep(3000);
			 //Mouse over laptops
			 WebElement ele=driver.findElementByXPath("(//span[text()='Laptops'])[1]");
			 Actions over=new Actions(driver);
			 over.moveToElement(ele).perform();
			 Thread.sleep(5000);
			 //Selecting Pavilion
			 driver.findElementByXPath("(//span[text()='Pavilion'])[1]").click();
			 Thread.sleep(3000);
			 
			 driver.executeScript("window.scrollBy(0, 250)");
			 
			//Selecting the processor
			 driver.findElementByXPath("(//span[text()='Processor'])[2]").click();
			  
			 Thread.sleep(3000);
			 driver.findElementByXPath("(//input[@class='product-filter-checkbox'])[2]").click();
			 Thread.sleep(3000);
			 driver.executeScript("window.scrollBy(0, 550)");
			
			  driver.findElementByXPath("//span[text()='More than 1 TB']").click();
			  driver.executeScript("window.scrollBy(0, 750)");
			  Thread.sleep(3000);
			 
			  //select low to high
				 driver.findElementByXPath("(//select[@id='sorter'])[1]").click();
				 driver.findElementByXPath("(//option[@value='bv_average_overall_rating_asc'])[1]").click();
				 Thread.sleep(3000);
			 

				 //get the first product name and price
				 String name=driver.findElementByXPath("(//a[@class='product-item-link'])[1]").getText();
				 System.out.println("System Name :" +name);
				 
				 String price=driver.findElementByXPath("(//span[@class='price'])[2]").getText();
				 System.out.println("System price :" +price );
				// driver.findElementByXPath("//button[@class='optanon-alert-box-close banner-close-button']");
				 driver.executeScript("window.scrollBy(0, 950)");
				 driver.findElementByXPath("//div[@class='inside_closeButton fonticon icon-hclose']").click();
				 
			
				 //Add to cart
				 driver.findElementByXPath("(//span[text()='Add To Cart'])[1]").click();
				 
				 driver.executeScript("window.scrollBy(0, 1350)");
				 Thread.sleep(3000);
				 //View and Edit cart
				 driver.findElementByXPath("//a[@class='action showcart']").click();
				 
				 Thread.sleep(3000);
				 driver.findElementByXPath("//a[@class='action primary viewcart']").click();
				 
				 driver.findElementByXPath("//input[@placeholder='Pincode']").sendKeys("600125");
				 
				 driver.findElementByXPath("//button[@class='primary standard_delivery-button']").click();
				 
				 //check the availability for pincode
				 String msg =driver.findElementByXPath("//span[@class='available']").getText();
				 System.out.println(msg);
				 String total=driver.findElementByXPath("(//span[@class='price'])[7]").getText();
				 System.out.println(total);
				 int s=0;
				 if (price.equalsIgnoreCase(total))
				 {
				      System.out.println("Both the product price and order total are same");
				      s=1;
				 }
				 else
					  System.out.println("Both the product price and order total are not same");
				 if (s==1)
				 {
					 driver.findElementByXPath("( //span[text()='Proceed to Checkout'])[1]").click();
				      Thread.sleep(3000);
				      driver.executeScript("window.scrollBy(0, 250)");
				      driver.findElementByXPath("(//span[text()='Place Order'])[4]").click();
				      String message = driver.findElementByXPath("//div[@class='message notice']").getText();
				      System.out.println(message);
				 }
				 driver.close();
				 
				 
				
				 
					 
				
			
				 
			
		}		
			

}
