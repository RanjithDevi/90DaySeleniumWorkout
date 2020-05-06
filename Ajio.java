package basicSeleniumPrograms;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Ajio {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Launching Chromebrowser
			 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			 System.setProperty("webdriver.chrome.silentOutput", "true");
		//To disable notifications
			 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			 ChromeOptions options= new ChromeOptions();
			 options.addArguments("--disable-notifications");
			 options.addArguments("--incognito");
			 capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			 
			 ChromeDriver driver=new ChromeDriver(options);
			 JavascriptExecutor js =  (JavascriptExecutor) driver;
						 
		//Maximize the browser
			 driver.manage().window().maximize();
		//Load the url
			 driver.get("https://www.ajio.com/shop/sale ");
		//Implicitly wait for 5 milliseconds
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 driver.findElementByXPath("//button[text()='Allow Location']").click();
			 
		//Accept alert
			 //Alert alert=driver.switchTo().alert();
			// driver.findElementByXPath("//button[text()='Allow']").click();
				//alert.accept();
			 Thread.sleep(3000);
			driver.findElementByXPath("//input[@class='react-autosuggest__input react-autosuggest__input--open']").sendKeys("Bags",Keys.ENTER);
			Thread.sleep(3000);
			driver.findElementByXPath("//div[@class='five-grid']").click();
			Thread.sleep(1000);
			
			//Selecting Whats new
			  WebElement sortElement =driver.findElementByXPath("//div[@class='filter-dropdown']//select[1]");
			  Thread.sleep(1000);
		 	  Select sortDD = new Select(sortElement);
			  sortDD.selectByVisibleText("What's New");
			  
			//Selecting the price
			  WebElement prices= driver.findElementByXPath("//span[text()='price']");
			  js.executeScript("arguments[0].click()", prices);
			  Thread.sleep(1000);
			  driver.findElementByXPath("//input[@name='minPrice']").sendKeys("2000",Keys.TAB);
			  driver.findElementByXPath("//input[@name='maxPrice']").sendKeys("5000");
			  Thread.sleep(500);
			  driver.findElementByXPath("//button[@class='rilrtl-button ic-toparw']").click();
			  Thread.sleep(1000);
			  
			  driver.findElementByXPath("//div[text()='Ferrari LS Shoulder Bag']").click();
			  Thread.sleep(3000);
			
			  //Showing the product in next page
			  Set<String> winSet = driver.getWindowHandles();
			  List<String> winLis=new ArrayList<String>(winSet);
			 driver.switchTo().window(winLis.get(1));

			 //Checking th ecoupon code
			 String price=driver.findElementByXPath("//div[@class='prod-sp']").getText().replaceAll("\\D","").trim();
			 System.out.println("Price of the product is :"+price);
			 int amount=Integer.parseInt(price);
			 int discount = 0;
			 //Finding the discount value
			 if (amount>2690)
				discount=amount-2141;
			    System.out.println("Discount amount is : "+discount);
			driver.findElementByXPath("//span[text()='Enter pin-code to know estimated delivery date.']").click();
			Thread.sleep(500);
		  //Checking the pincode
			driver.findElementByXPath("//input[@class='edd-pincode-modal-text']").sendKeys("560043");
			Thread.sleep(1000);
			driver.findElementByXPath("//button[text()='CONFIRM PINCODE']").click();
			Thread.sleep(1000);
			System.out.println(driver.findElementByXPath("//ul[@class='edd-message-success-details']//li[1]").getText());
		//Checking the other information
			driver.findElementByXPath("//div[text()='Other information']").click();
			Thread.sleep(2000);
			System.out.println("Customer Care Address");
			String address = driver.findElementByXPath("(//li[@class='detail-list mandatory-info']//span[@class='other-info'])[6]").getText();
			System.out.println(address);
			Thread.sleep(1000);
			driver.findElementByXPath("//span[text()='ADD TO BAG']").click();
			Thread.sleep(2000);
		
			String  total = driver.findElementByXPath("//div[@class='prod-sp']").getText().replaceAll("\\D","").trim();
			 System.out.println("Total price of the product is :"+total);
			 int amounttot=Integer.parseInt(total);
			 String coupon = driver.findElementByXPath("(//div[@class='promo-title'])[1]").getText();
			 System.out.println(coupon);
			//Goto Bag
				WebElement gobag = driver.findElementByXPath("//span[text()='GO TO BAG']");
				js.executeScript("arguments[0].click()", gobag);
		 
				Thread.sleep(4000);
			
			 driver.findElementByXPath("//input[@class='coupon-code-input-vhr-not-apld  ']").sendKeys("EPIC");
			 driver.findElementByXPath("//button[text()='Apply']").click();
			 Thread.sleep(3000);
			 String round=driver.findElementByXPath("(//span[@class='price-value discount-price'])[2]").getText().trim();
			 String roundsub=round.substring(4,10);
			 float roundno=Float.parseFloat(roundsub);
			 int discountround=Math.round(roundno);
			// Calculating whether displayed discount and calculated discount are same
			 System.out.println("Rounded Discount Price is : " +discountround);
			 if (discount == discountround)
			    System.out.println("Both the calculated discount and the displayed discount are the same");
			 else
				 System.out.println("Both the calculated discount and the displayed discount are not the same");
			 Thread.sleep(1000);
			//Deleting the product
			 driver.findElementByXPath("//div[text()='Delete']").click();
			//closing all the browsers
			 driver.quit();


			
		 

	}

}
