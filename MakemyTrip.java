package basicSeleniumPrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MakemyTrip {
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
			 driver.get("https://www.makemytrip.com/");
			 //Implicitly wait for 5 milliseconds
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			 
			 //Select the hotels
			 driver.findElementByXPath("//span[@class='chNavIcon appendBottom2 chSprite chHotels']").click();
			 Thread.sleep(3000);
			 
			 //choose city as Goa
			 driver.findElementByXPath("//span[@data-cy='hotelCityLabel']").click();
			 Thread.sleep(3000);
			 driver.findElementByXPath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']").sendKeys("Goa,India",Keys.TAB);
			 
			 
			 driver.findElementByXPath("//input[@id='checkin']").click();
				Thread.sleep(3000);
				
				//selecting from date and To date
				driver.findElementByXPath("(//div[text()='15'])[2]").click();
				driver.findElementByXPath("(//div[text()='20'])[2]").click();
				
				//selecting guest and rooms
				driver.findElementByXPath("//input[@class='hsw_inputField guests font20']").click();
				driver.findElementByXPath("(//li[@class='selected'])[1]").click();
				driver.findElementByXPath("//li[@data-cy='children-1']").click();
				Thread.sleep(1000);
				driver.findElementByXPath("//option[@data-cy='childAgeValue-12']").click();
				driver.findElementByXPath("//button[@class='primaryBtn btnApply']").click();
				//click Apply button
				driver.findElementByXPath("//button[@id='hsw_search_button']").click();
				
				driver.findElementByXPath("//body[@class='bodyFixed overlayWholeBlack']").click();
			
				 
				//Selecting Baga
				driver.findElementByXPath("//label[text()='Baga']").click();
				//selecting 5star
				driver.findElementByXPath("//label[text()='5 Star']").click();
				Thread.sleep(3000);
				driver.findElementByXPath("//span[@id='htl_id_seo_201411041933454748']").click();
				
				//Goto newly opened window  and print the hotel name
				 
				 Set<String> winSet = driver.getWindowHandles();
				 List<String> winLis=new ArrayList<String>(winSet);
				 driver.switchTo().window(winLis.get(1));
				 
				 String hotel=driver.findElementByXPath("//h1[@class='txtHeading font22 latoBlack blackText']").getText();
				 System.out.println("Hote name is : "+hotel);
				
				 //Click More options
				 driver.findElementByXPath("//span[@class='latoBold font10 blueText pointer']").click();
				
				 
				 Set<String> winSet1 = driver.getWindowHandles();
				 List<String> winLis1=new ArrayList<String>(winSet1);
				 driver.switchTo().window(winLis1.get(1));
				 Thread.sleep(3000);
				 
				 //Select 3 months plan
				 driver.findElementByXPath("(//span[@class='latoBold font12 pointer makeFlex hrtlCenter right blueText'])[1]").click();
				 driver.findElementByXPath("//span[@class='close']").click();
				 
				 Set<String> winSet2 = driver.getWindowHandles();
				 List<String> winLis2=new ArrayList<String>(winSet2);
				 driver.switchTo().window(winLis2.get(1));
				 
				 
				 //click Book my show
				 driver.findElementByXPath("//a[text()='BOOK THIS NOW']").click();
				 
				 //get the total amount
				 String amount=driver.findElementByXPath("//span[@class='latoBlack font16']").getText();
				 System.out.println("Total Payable Amount :"+amount);
				 
				 //close
				 driver.quit();
				 
				 
				 

		}
	}


