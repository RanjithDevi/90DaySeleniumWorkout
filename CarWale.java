package basicSeleniumPrograms;

import java.io.IOException;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CarWale {

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
			 driver.get("https://www.carwale.com/");
		//Implicitly wait for 5 milliseconds
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 JavascriptExecutor js =  (JavascriptExecutor) driver;	
			 Thread.sleep(1000);
		//Click Used
			 driver.findElementByXPath("//li[@class='welcome-box__search-item js-welcome-box__list-item']").click();
			 driver.findElementByXPath("//input[@placeholder='Type to select city name, e.g. Mumbai']").sendKeys("Chennai,Tamil Nadu");
			 driver.findElementByXPath("//a[@cityname='chennai,tamilnadu']").click();
			 Thread.sleep(1000);
			 driver.findElementByXPath("//li[text()='8 Lakh']").click();
			 driver.findElementByXPath("(//li[text()='12 Lakh'])[2]").click();
			 Thread.sleep(1000);
			 driver.findElementByXPath("//button[@id='btnFindCar']").click();
			 Thread.sleep(1000);
		//Selecting car with photos
			 driver.executeScript("window.scrollBy(0, 450)");
			 driver.findElementByXPath("(//li[@class='us-sprite'])[1]").click();
			 Thread.sleep(1000);
		//Selecting Hyundai
			 WebElement Hyundai = driver.findElementByXPath("//span[text()=' Hyundai ']");
			 js.executeScript("arguments[0].click()", Hyundai);
			 Thread.sleep(1000);			 
		//Selecting Creta
			 WebElement creta = driver.findElementByXPath("(//li[@class='us-sprite rootLi'])[1]");
			 js.executeScript("arguments[0].click()", creta);
			 Thread.sleep(1000);
		//Selecting fuel type
			 WebElement petrol = driver.findElementByXPath("(//h3[@class='sub-values'])[6]");
			 js.executeScript("arguments[0].click()", petrol);
			 Thread.sleep(500);
			 WebElement fuel = driver.findElementByXPath("(//span[text()='Petrol'])[1]");
			 js.executeScript("arguments[0].click()", fuel);
		//Select low to highs
			 WebElement sortElement = driver.findElementById("sort");
			 Select sortDD = new Select(sortElement);
			 sortDD.selectByVisibleText("KM: Low to High");
			 List<WebElement> kmList = driver.findElementsByXPath("//span[@class='slkms vehicle-data__item']");
			  
			 List<Integer> intKms = new ArrayList<Integer>();
			 List<Integer> befsort = new ArrayList<Integer>();
			 Thread.sleep(1000);
			 for (int i=0;i<kmList.size();i++)
			 {
				  String putset=kmList.get(i).getText().replaceAll("\\D","").trim();
				  int kms=Integer.parseInt(putset);
				  intKms.add(kms);
				  befsort.add(kms);
				 
			 }	 
			Collections.sort(intKms);
			System.out.println("Before Sorting " +befsort);
			 System.out.println("After Sorting " +intKms);
			 Thread.sleep(1000);
			 if (befsort.equals(intKms))
			    System.out.println("Both the displayed list and sorted list of kms remains the same");
			 else
			 System.out.println("Both the displayed list and sorted list of kms are different");
			 
			 for (int i=1;i<2;i++)
			 {
				 System.out.println(intKms.get(0));
				 WebElement carlowkm=driver.findElementByXPath("(//span[@class='shortlist-icon--inactive shortlist'])[" +i+ "]");
				 js.executeScript("arguments[0].click()", carlowkm);
				 Thread.sleep(2000);
			 }
			 WebElement wishList = driver.findElementByXPath("//li[@data-action='ShortList&CompareWindow_Click']");
			 js.executeScript("arguments[0].click()", wishList);
				
			 WebElement moreDetails = driver.findElementByXPath("//a[text()='More details »']");
			 js.executeScript("arguments[0].click()", moreDetails);
			 
			 Thread.sleep(3000);
			 
			 Set<String> winSet = driver.getWindowHandles();
			 List<String> winLis=new ArrayList<String>(winSet);
			 driver.switchTo().window(winLis.get(1));
			 
			 Map<String,String> map = new LinkedHashMap<String, String>();
			 List<WebElement> overview =driver.findElementsByXPath("//div[@class='overview-list padding-bottom10']//div[@class='equal-width text-light-grey']");
			 List<WebElement> price =driver.findElementsByXPath("//div[@class='overview-list padding-bottom10']//div[@class='equal-width dark-text']");
			 for (int i=0;i<overview.size();i++)
			 {
								 
				 map.put(overview.get(i).getText(), price.get(i).getText());
			 }
			 for (Entry<String, String> each : map.entrySet()) {
					System.out.println(each.getKey() + " ---------- " + each.getValue());
				
			}
			 driver.close();
			 
		 
	}
}
