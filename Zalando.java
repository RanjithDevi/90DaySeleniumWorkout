package basicSeleniumPrograms;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Zalando {

	public static void main(String[] args) throws InterruptedException, IOException {
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
			 driver.get("https://www.zalando.com/ ");
		//Implicitly wait for 5 milliseconds
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
		//Print the alert message
			 Alert alert=driver.switchTo().alert();
			 Thread.sleep(2000);
			 String alerttext= alert.getText();
			 System.out.println("Alert Message : \t" +alerttext);
			 alert.accept();
		//Enter UK site
			 driver.findElementByXPath("//a[text()='Zalando.uk']").click();
			 Thread.sleep(2000);
			 
		//Select Women-->Clothing
			 driver.findElementByXPath("//button[@class='uc-btn uc-btn-primary']").click();
			 Thread.sleep(1000);
			 driver.findElementByXPath("//span[text()='Women']").click();
			 Thread.sleep(1000);
			// driver.findElementByXPath("//button[@class='uc-btn uc-btn-primary']").click();
			 driver.findElementByXPath("//span[text()='Clothing']").click();
			 Thread.sleep(2000);
			 driver.findElementByXPath("(//a[text()='Coats'])[3]").click();
			 Thread.sleep(2000);
			// driver.findElementByXPath("//button[@class='uc-btn uc-btn-primary']").click();
			 Thread.sleep(2000);
		//Selecting Material and length
			 driver.findElementByXPath("//span[text()='Material']").click();
			 driver.findElementByXPath("//span[text()='cotton (100%)']").click();
			 driver.findElementByXPath("//button[text()='Save']").click();
			 Thread.sleep(2000);
			 driver.findElementByXPath("//span[text()='Length']").click();
			 driver.findElementByXPath("//span[text()='thigh-length']").click();
			 driver.findElementByXPath("//button[text()='Save']").click();
			 Thread.sleep(2000);
			 driver.findElementByXPath("//div[text()='MANTEL - Parka - navy']").click();
		//Selecting olive coat
			 driver.findElementByXPath("(//img[@alt='olive'])[2]").click();
			 Thread.sleep(1000);
			 driver.findElementByXPath("//button[@id='picker-trigger']").click();
			 Thread.sleep(1000);
			 driver.findElementByXPath("//span[text()='M']").click();
			 String avail= driver.findElementByXPath("//h2[@class='A95iT1 pDVUjz nmA88J t23HxU x--xNS Y6OuCD gqlvDk']").getText();
			 System.out.println("The item is  "+avail);
			 if (avail.equalsIgnoreCase("Out of stock"))
			 {
				 driver.findElementByXPath("(//img[@alt='navy'])[2]").click();
				 Thread.sleep(1000);
				 driver.findElementByXPath("//button[@id='picker-trigger']").click();
				 Thread.sleep(2000);
				 driver.findElementByXPath("//span[text()='M']").click();
				 Thread.sleep(1000);
				 
			 }
			 else
			 {
				 driver.findElementByXPath("//span[text()='M']").click();
				 Thread.sleep(1000);
			 }
			//Check standard delivery is free or not
			 String delivery =driver.findElementByXPath("(//span[@class='AtOZbZ'])[2]").getText();
			 if (delivery.equalsIgnoreCase("Free"))
			 {
			  driver.findElementByXPath("//span[text()='Add to bag']").click();
			  Thread.sleep(2000);
			 }
			//Mouse Hover on the cart
			 WebElement engine=driver.findElementByXPath("//a[@class='z-navicat-header_navToolItemLink']");
			 Actions over=new Actions(driver);
			 over.moveToElement(engine).perform();
			  Thread.sleep(1000);
			  driver.findElementByXPath("//div[text()='Go to bag']").click();
			  String estdelivery = driver.findElementByXPath("(//span[@class='z-2-text z-2-text-body z-2-text-black'])[1]").getText();
			  System.out.println("Estimated delivery date : " +estdelivery);
			//Mouse Over on free delivery and returns
			  WebElement freedel=driver.findElementByXPath("(//span[@class='z-2-text z-2-text-body z-2-text-black'])[1]");
			  Actions over1=new Actions(driver);
			  over1.moveToElement(freedel).perform();
		      Thread.sleep(1000);
		     String tooltip= driver.findElementByXPath("//span[@title='*Free delivery for orders over £19.90. For orders below this, the delivery cost is £3.00']").getAttribute("title");
		     System.out.println(tooltip);
		     Thread.sleep(2000);
		     driver.findElementByXPath("//a[text()='Free delivery & returns*']").click();
		     Thread.sleep(3000);
		     WebElement chat=driver.findElementByXPath("//span[text()='Start chat']");
		     if (chat.isEnabled()==false)
		     {
		    	     System.out.println("Chat option is not enabled currently"); 
		     }
		     else
		     {
		    	     driver.findElementByXPath("//span[text()='Start chat']").click();
			    	 Thread.sleep(3000);
			   //Starting chat 
			    	 Set<String> allWindows = driver.getWindowHandles();
			 		List<String> allList = new ArrayList<String>(allWindows);
			 		driver.switchTo().window(allList.get(1));
					 Thread.sleep(3000);
					 
				//Giving chat information
					 driver.findElementByXPath("//input[@id='prechat_customer_name_id']").sendKeys("Devi");
					 driver.findElementByXPath("//input[@id='prechat_customer_email_id']").sendKeys("devi@gmail.com");
					 driver.findElementByXPath("//button[@id='prechat_submit']").click();
					 driver.findElementByXPath("//textarea[@id='liveAgentChatTextArea']").sendKeys("Hi");
					 driver.findElementByXPath("//button[text()='Send']").click();
					 Thread.sleep(2000);
					 String text=driver.findElementByXPath("(//span[@class='messageText'])[4]").getText();
					 System.out.println("The given text is : " +text);
		     }
		     
		            driver.quit();
		       
		     
	}
}
