package basicSeleniumPrograms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JustDial {

	 
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
				 driver.get("https://www.justdial.com/");
			//Implicitly wait for 5 milliseconds
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//Change location to chennai
				 driver.findElementByXPath("//input[@id='city']").click();
				 driver.findElementByXPath("//a[@id='Chennai']").click();
				 Thread.sleep(1000);
				 driver.findElementByXPath("//span[@id='hotkeys_text_6']").click();
				 Thread.sleep(500);
				 driver.findElementByXPath("(//span[@class='meditle lng_commn'])[1]").click();
				 Thread.sleep(500);
				 driver.findElementByXPath("(//span[@class='meditle1 lng_commn'])[5]").click();
				 Thread.sleep(500);
				 driver.findElementByXPath("(//span[text()='Hyundai Xcent'])[2]").click();
				 Thread.sleep(3000);
				 driver.findElementByXPath("//a[text()='Location']").click();
				 Thread.sleep(1000);
				 WebElement city = driver.findElementByXPath("//input[@name='sortbydist']");
				 Thread.sleep(1000);
				 //city.clear();
				 city.sendKeys("Porur");
				 driver.findElementByXPath("(//b[text()='Porur'])[1]").click();
				 Thread.sleep(1000);
				 List<String> sortedCompanyName = new ArrayList<String>();
				 List<WebElement> rating = driver.findElementsByXPath("(//span[@class='green-box'])");
				 List<WebElement> votes = driver.findElementsByXPath("//span[@class='green-box']/following-sibling::span[@class='rt_count lng_vote']");	
				 List<WebElement> companyNam=driver.findElementsByXPath("//span[@class='lng_cont_name']");
				 List<WebElement> phone=driver.findElementsByXPath("//p[@class='contact-info ']");
				
				 for (int i=0;i<rating.size();i++)
				 {
					 String rat=rating.get(i).getText();
					 Float ratfloat=Float.parseFloat(rat);
					 if (ratfloat>=4.5)
					 {
						    String vot=votes.get(i).getText();
						    String replacevot=vot.replaceAll("[^0-9]", ""); 
						    String vottrim=replacevot.trim();
						    int finalvotes=Integer.parseInt(vottrim);
						    if (finalvotes>=50)
						    {
						    	String name=companyNam.get(i).getText();
						    	System.out.println(name);
						    	sortedCompanyName.add(name);
						    	String phoneNo=phone.get(i).getText();
						    	System.out.println(phoneNo);
						    
						      }
					 }
				 }
					  
		
		 
				 
		
				 } 
			
				  
		}


