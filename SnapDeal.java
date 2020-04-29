package basicSeleniumPrograms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal {

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
				 driver.get("https://www.snapdeal.com/ ");
			//Implicitly wait for 5 milliseconds
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 
			//Mouse Hover on Toys
				 WebElement toys=driver.findElementByXPath("(//span[@class='catText'])[8]");
				 Thread.sleep(3000);
				 Actions over=new Actions(driver);
				 over.moveToElement(toys).perform();
				 
			     driver.findElementByXPath("//span[text()='Educational Toys']").click();
			     Thread.sleep(1000);
			     driver.findElementByXPath("//label[@for='avgRating-4.0']").click();
			     Thread.sleep(1000);
			     driver.executeScript("window.scrollBy(0, 250)");
			     driver.findElementByXPath("//label[@for='discount-40%20-%2050']").click();
			     Thread.sleep(2000);
			     driver.findElementByXPath("//input[@placeholder='Enter your pincode']").sendKeys("600125");
			     driver.findElementByXPath("//button[text()='Check']").click();
			     Thread.sleep(1000);
			  //Quick view of first item
			     WebElement item=driver.findElementByXPath("//p[@class='product-title']");
				 Thread.sleep(3000);
				 Actions over1=new Actions(driver);
				 over1.moveToElement(item).perform();
				 Thread.sleep(2000);
			     driver.findElementByXPath("(//div[@class='clearfix row-disc']/div)[1]").click();
			     Thread.sleep(2000);
			     driver.findElementByXPath("//a[@class=' btn btn-theme-secondary prodDetailBtn']").click();
			     String price=driver.findElementByXPath("//span[@class='payBlkBig']").getText();
			     int priceint=Integer.parseInt(price);
			     System.out.println("Price of the item : "+priceint);
			     String delivery=driver.findElementByXPath("(//span[@class='availCharges'])[2]").getText();
			     String repdelivery=delivery.replaceAll("\\D", " ");
			     String trimdel=repdelivery.trim();
			     int delcharge=Integer.parseInt(trimdel);
			     System.out.println("Delivery Charge : " +delcharge);
			     int grandsecitem=delcharge+priceint;
			     System.out.println("calculated total for first item :" +grandsecitem);
			     driver.findElementByXPath("//span[text()='add to cart']").click();
			     Thread.sleep(1000);
			     String total = driver.findElementByXPath("(//span[@class='price'])[2]").getText();
			     String ftotal=total.replaceAll("\\D", " ");
			     String ttotal=ftotal.trim();
			     int finaltotal=Integer.parseInt(ttotal);
			     if (finaltotal == grandsecitem)
			       System.out.println("Both the calculated total and displayed total are same for first product");
			     else
			    	 System.out.println("Both the calculated total and displayed total are not same  for first product");
			     
			     System.out.println("Final Price of the product :" +finaltotal);
			  //Search for Sanitizer
			     driver.findElementByXPath("//input[@id='inputValEnter']").sendKeys("Sanitizer",Keys.ENTER);
			     Thread.sleep(2000);
			     driver.findElementByXPath("(//p[@class='product-title'])[1]").click();
			  //Opening new window for the product

				 Set<String> winSet = driver.getWindowHandles();
				 List<String> winLis=new ArrayList<String>(winSet);
				 driver.switchTo().window(winLis.get(1));
				 String sanprice=driver.findElementByXPath("//span[@class='payBlkBig']").getText();
				 String fsan=sanprice.replaceAll("\\D", " ");
			     String trimsan=fsan.trim();
			     int sanitprice=Integer.parseInt(trimsan);
			     System.out.println("Sanitizer Price : " +sanitprice);
			     String delssan=driver.findElementByXPath("(//span[@class='availCharges'])[2]").getText();
			     String fsani=delssan.replaceAll("\\D", " ");
			     String tsan=fsani.trim();
			     int finalsanit=Integer.parseInt(tsan);
			     System.out.println("Sanitizer Delivery charge : "+finalsanit);
			     int sectotal=finalsanit+sanitprice;
			     System.out.println("Calculated price of second item: "+sectotal);
			     //Add to Cart
				 
			     driver.findElementByXPath("(//span[text()='ADD TO CART'])[1]").click();
			     Thread.sleep(3000);
			     driver.findElementByXPath("//span[text()='Cart']").click();
			     Thread.sleep(2000);
			    
			   //Checking the calculated and displayed total for second product  
			     String sectotalp=driver.findElementByXPath("(//span[@class='item-subtotal-black'])[4]").getText();
			     String secprice=sectotalp.replaceAll("\\D", " ");
			     String secpricetrim=secprice.trim();
			     int secsanip=Integer.parseInt(secpricetrim);
			     System.out.println("Displayed price of second item : "+secsanip);
			     if (secsanip == sectotal)
			    	 System.out.println("Both the calculated total and displayed total are same for second product");
			     else
			    	 System.out.println("Both the calculated total and displayed total are not  same for second product");
			    
				 Thread.sleep(2000);
				 String lasttotal=driver.findElementByXPath("//input[@class='btn btn-xl rippleWhite cart-button']").getAttribute("value");
				  	 
				//Checking the total price for both the products
			     String ffprice=lasttotal.replaceAll("[^0-9]", "");
			     int floatprice=Integer.parseInt(ffprice);
			     System.out.println("Final Total of both the items :" +floatprice);
			     int  grandtotals=secsanip+finaltotal;
			     System.out.println("Calculated total for both the products : "+grandtotals);
			     if (floatprice == grandtotals)
			    	 System.out.println("Both the calculated total and displayed total are same for both product");
			     else
			    	 System.out.println("Both the calculated total and displayed total are not same for both product");
			     driver.quit();
			    
				 
			     
			     
			     
			      
	}
 		
 
}
