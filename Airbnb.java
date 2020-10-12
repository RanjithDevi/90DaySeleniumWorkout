package basicSeleniumPrograms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.iterators.EntrySetMapIterator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Airbnb {

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
			 driver.get("https://www.airbnb.co.in/");
		//Implicitly wait for 5 milliseconds
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  
		//Give the input details to search
		    WebElement ok= driver.findElementByXPath("//button[@class='optanon-allow-all accept-cookies-button']");
		    js.executeScript("arguments[0].click()", ok);
			Thread.sleep(3000);
			 driver.findElementByXPath("//input[@id='bigsearch-query-attached-query']").sendKeys("Coorg");
			 driver.findElementByXPath("//div[text()='Coorg, Karnataka']").click();
			 
			 Thread.sleep(2000);
		
		//Selecting the dates
			 driver.findElementByXPath("(//div[text()='1'])[3]").click();
			 Thread.sleep(1000);
			 driver.findElementByXPath("(//div[text()='5'])[3]").click();
			 Thread.sleep(1000);
			 driver.findElementByXPath("//div[text()='Guests']").click();
			 Thread.sleep(1000);
		//Selecting the number of adults and children
			 WebElement adult = driver.findElementByXPath("(//button[@class='_11yg8kv'])[2]");
			 adult.click();
			 adult.click();
			 adult.click();
			 adult.click();
			 adult.click();
			 adult.click();
			 WebElement child=driver.findElementByXPath("(//button[@class='_11yg8kv'])[4]");
			 child.click();
			 child.click();
			 child.click();
			 Thread.sleep(1000);
			 driver.findElementByXPath("//button[@type='submit']").click();
		//Clicking the cancellation policy
			 driver.findElementByXPath("(//span[text()='Cancellation flexibility'])[1]").click();
			 Thread.sleep(1000);
			 driver.findElementByXPath("//button[@id='filterItem-switch-flexible_cancellation-true']").click();
			 driver.findElementByXPath("//button[text()='Save']").click();
		//Selecting type of place
			 driver.findElementByXPath("(//span[text()='Type of place'])[1]").click();
			 Thread.sleep(1000);
			 driver.findElementByXPath("(//span[@class='_167krry'])[1]").click();
			 Thread.sleep(500);
			 driver.findElementByXPath("//button[@id='filter-panel-save-button']").click();
			 Thread.sleep(500);
		//Selecting the price range
			 driver.findElementByXPath("//span[text()='Price']").click();
			 Thread.sleep(1000);
			 WebElement  min=driver.findElementByXPath("//input[@id='price_filter_min']");
			 Actions over=new Actions(driver);
			 over.doubleClick(min).sendKeys("3000").perform();
			 Thread.sleep(500);
			 WebElement max=driver.findElementByXPath("//input[@id='price_filter_max']");
			 max.click();
			 max.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END),"5000");
			 Thread.sleep(500);
			 driver.findElementByXPath("//button[text()='Save']").click();
			 
			 driver.findElementByXPath("(//span[text()='More filters'])[1]").click();
			 Thread.sleep(500);
			 
			 //Selecting bathrooms and bedrooms
			 WebElement bed=driver.findElementByXPath("(//button[@class='_11yg8kv'])[4]");
			 Thread.sleep(500);
			 bed.click();
			 bed.click();
			 bed.click();
			 WebElement bath=driver.findElementByXPath("(//button[@class='_11yg8kv'])[6]");
			 Thread.sleep(500);
			 bath.click();
			 bath.click();
			 bath.click();
			 Thread.sleep(1000);
			 driver.findElementByXPath("//div[text()='Kitchen']").click();
			 Thread.sleep(500);
			 driver.findElementByXPath("//div[text()='Free parking on premises']").click();
			 Thread.sleep(500);
			 driver.findElementByXPath("//div[text()='House']").click();
			 Thread.sleep(500);
			 driver.findElementByXPath("//div[text()='English']").click();
			 Thread.sleep(500);
			 String stays = driver.findElementByXPath("//button[@class='_2i58o3a']").getText().replaceAll("\\D", "");
			 int nostays=Integer.parseInt(stays);
			 if (nostays>=1)
			 {
			      driver.findElementByXPath("//button[contains(text(),'Show')]").click();
			     
			 }
			 else
			 {
				 System.out.println("There are no stays available");
			 }
			   Thread.sleep(2000);
	           driver.findElementByXPath("//a[@aria-label='Prahari Nivas, the complete house']").click();
	           Thread.sleep(5000);
	           
	         //Slecting the ammenities in the Hotel
	        Set<String> allWindows = driver.getWindowHandles();
	   		List<String> allLists = new ArrayList<String>(allWindows);
	   		driver.switchTo().window(allLists.get(1));
	   		Thread.sleep(8000);
	  		 
			driver.executeScript("window.scrollBy(0, 1250)");
			WebElement show = driver.findElementByXPath("(//div[@class='_1p3joamp']//button)[1]");
			js.executeScript("arguments[0].click()", show);
			Thread.sleep(8000);
			/*WebElement eleShowAll = driver.findElementByXPath("(//button[@class='_b0ybw8s'])[5]");
			js.executeScript("arguments[0].click()", eleShowAll);

			 
	  		//driver.findElementByXPath("//div[@class='_1tv4hg3']//a[@class='_1v4ygly5']");
	  		//driver.findElementByXPath("(//div[@class='_1p3joamp']//button)[1]\"))");
			Thread.sleep(2000);*/
			 List<WebElement> include= driver.findElementsByXPath("//div[@class='_vzrbjl']//del");
			 System.out.println("The following Aminities are not included");
			 for (WebElement eachinclude : include) {
				 System.out.println(eachinclude.getText());
			 }
	  		 Thread.sleep(1000);
	  	 //Finding the checkin, checkout date and number of guests
			 String  checkin=driver.findElementByXPath("(//div[@class='_7eq2v2']/following-sibling::div)[1]").getText();
			 Thread.sleep(1000);
			 String checkout=driver.findElementByXPath("(//div[@class='_ykxqsm'])[2]").getText();
			 driver.findElementByXPath("(//span[@class='_e296pg'])[3]").click();
			 Thread.sleep(2000);
			 System.out.println("Checkin Date is : "+checkin);
			 System.out.println("Checkout Date is : "+checkout);
			 String guests=driver.findElementByXPath("(//div[@class='_1ir6ymk'])").getText();
			 System.out.println("Numer of guests : " +guests);
			 if (checkin.equalsIgnoreCase("06/01/2020"))
				 System.out.println("checkIn details are correct");
			 else
				 System.out.println("checkIn details are incorrect");
			 
			 if (checkout.equalsIgnoreCase("06/05/2020"))
				 System.out.println("checkOut details are correct");
			 else
				 System.out.println("checkOut details are incorrect");
			 if (guests.equalsIgnoreCase("9 guests"))
				 System.out.println("Guest details are correct");
			 else
				 System.out.println("Guest details are incorrect");
		//Printing the bedroom and bed arrangement details
			 Map<String, String> maps = new LinkedHashMap<String, String>();
			 List<WebElement> Bedroom=driver.findElementsByXPath("(//div[@class='_p03egf']/following-sibling::div)[1]");
			 List<WebElement> Bed=driver.findElementsByXPath("(//div[@class='_p03egf']/following-sibling::div)[2]");
			 for (int j = 1; j <= Bedroom.size(); j++) {
			 {
				 String mapbedroom=Bedroom.get(j).getText();
				 String mapbed=Bed.get(j).getText();
				 maps.put(mapbedroom, mapbed);
				 
			 }
			 for (Entry<String, String> each : maps.entrySet()) {
					System.out.println(each.getKey() + " ---------- " + each.getValue());
			}
			 
			 }	 
			  
	}		 
			 
			 
	}
	   

