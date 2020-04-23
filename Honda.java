package basicSeleniumPrograms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Honda {
 
		public static void main(String[] args) throws InterruptedException {
			//Launching Chromebrowser
				 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				 System.setProperty("webdriver.chrome.silentOutput", "true");
			//To disable notifications
				 ChromeOptions options= new ChromeOptions();
				 options.addArguments("--disable-notifications");
				 ChromeDriver driver=new ChromeDriver(options);
				 
			//Maximize the browser
				 driver.manage().window().maximize();
				 //Load the url
				 driver.get("https://www.honda2wheelersindia.com/");
				 //Implicitly wait for 5 milliseconds
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 Thread.sleep(3000);
				 driver.findElementByXPath("//button[@class='close']").click();
				 Thread.sleep(3000);
			//click on scooters
				 driver.findElementByXPath("//a[@id='link_Scooter']").click();
			//click on duo
				 driver.findElementByXPath("(//div[@class='owl-item'])[4]").click();
				 Thread.sleep(2000);
			//Click on Specifications
				 driver.findElementByXPath("//a[text()='Specifications']").click();
				 Thread.sleep(3000);
				 
				//Mouse Hover on Engine
				 WebElement engine=driver.findElementByXPath("//a[text()='ENGINE']");
				 Actions over=new Actions(driver);
				 over.moveToElement(engine).perform();
				 Thread.sleep(3000);
				 String diodisp=driver.findElementByXPath("//span[text()='Displacement']/ following-sibling::span").getText();
				 System.out.println("Dio Displacement is : "+diodisp);
				 diodisp = diodisp.replaceAll("\\D","");
				 diodisp=diodisp.substring(0, 3);
				 int dio=Integer.parseInt(diodisp);
				 Thread.sleep(2000);
				 
				//click on scooters
				 driver.findElementByXPath("//a[@id='link_Scooter']").click();
				//click on Activa 125
				 driver.findElementByXPath("(//div[@class='owl-item'])[6]").click();
				 Thread.sleep(3000);
				 //click on specifications
				 driver.findElementByXPath("//a[text()='Specifications']").click();
				 Thread.sleep(3000);
				 
				//Mouse Hover on Engine
				 WebElement engine1=driver.findElementByXPath("//a[text()='ENGINE']");
				 Actions over1=new Actions(driver);
				 over1.moveToElement(engine1).perform();
				 Thread.sleep(3000);
				 
				 String actdisp=driver.findElementByXPath("//span[text()='Displacement']/ following-sibling::span").getText();
				 System.out.println("Activa Displacement is : "+actdisp);
				 actdisp = actdisp.replaceAll("\\D","");
				 int act=Integer.parseInt(actdisp);
				 Thread.sleep(2000);
				 
				 if (dio<act)
					 System.out.println("Activa 125 has a better displacement than Dio");
				 else
					 System.out.println("Dio has a better displacement than Activa");
				 
				 driver.findElementByXPath("(//a[text()='FAQ'])[1]").click();
				 Thread.sleep(3000);
				 driver.findElementByXPath("//a[text()='Activa 125 BS-VI']").click();
				 
				 WebElement vehprice = driver.findElementByXPath("//a[text()=' Vehicle Price']");
				 vehprice.click();
				 Thread.sleep(3000);

				 //Check Activa 125 BS-VI selected and click submit
				 if (vehprice.isEnabled()) {
				 	driver.findElementByXPath("//button[@id='submit6']").click();
				 
				 Thread.sleep(2000);
				 driver.findElementByXPath("(//i[@class='fa fa-angle-right'])[6]").click();
				 driver.findElementByXPath("//a[text()='Click here to know the price of Activa 125 BS-VI.']").click();
				 
				 Set<String> winSet = driver.getWindowHandles();
				 List<String> winLis=new ArrayList<String>(winSet);
				 driver.switchTo().window(winLis.get(1));
				 
				 driver.findElementByXPath("(//select[@class='form-control'])[1]").click();
				 Thread.sleep(3000);
				 driver.findElementByXPath("//option[text()='Tamil Nadu']").click();
				 Thread.sleep(2000);
				 
				 
				 WebElement state = driver.findElementById("StateID");
				 Select select = new Select(state);
				 select.selectByVisibleText("Tamil Nadu");

				 //Select the city as Chennai
				 WebElement city = driver.findElementById("CityID");
				 Select select1 = new Select(city);
				 select1.selectByVisibleText("Chennai");
				 //click Search
				 driver.findElementByXPath("//button[text()='Search']").click();
				 //Print the 3 models available in chennai
				 			 
				 for (int i=1;i<4;i++)
				 {
				     String size = driver.findElementByXPath("//tbody[@style='background-color:white']/tr["+i+"]").getText();
					 System.out.println(size.replace("Chennai",""));
				  }
				
				 //close the browsers
				 driver.quit();
 
				 

	}

		}
}
