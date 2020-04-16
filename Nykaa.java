package basicSeleniumPrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

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
		 driver.get("https://www.nykaa.com/");
		 //Implicitly wait for 5 milliseconds
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 //Mouse Hover on Brands
		 
		 WebElement brand=driver.findElementByXPath("//a[text()='brands']");
		 Thread.sleep(3000);
		 Actions over=new Actions(driver);
		 over.moveToElement(brand).perform();
		 
		 //Mouse Hover on Popular
		 
		 WebElement popular=driver.findElementByXPath("//a[text()='Popular']");
		 Thread.sleep(3000);
		 Actions over1=new Actions(driver);
		 over1.moveToElement(popular).perform();
		
		 driver.findElementByXPath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']").click();
		 
		 //Goto newly opened window and check title
		 
		 Set<String> winSet = driver.getWindowHandles();
		 List<String> winLis=new ArrayList<String>(winSet);
		 driver.switchTo().window(winLis.get(1));
		 
		 String title=driver.getTitle();
		 System.out.println("The title of the page is  : "+title);
		 if (title.equalsIgnoreCase("Buy L'Oreal Paris products online at best price on Nykaa | Nykaa"))
			 System.out.println("The title matches");
		 else
			 System.out.println("The title doesn't match");
		 Thread.sleep(3000);
		 
		 
		 //click sort by and select customer top rated
		 
		 driver.findElementByXPath("//span[@class='value']").click();
		 Thread.sleep(3000);
		 driver.findElementByXPath("//span[text()='customer top rated']").click();
		 Thread.sleep(3000);
		 
		 //click on category and select Shampoo
		 driver.findElementByXPath("//div[text()='Category']").click();
		 Thread.sleep(3000);
		 driver.findElementByXPath("(//label[@class='control control--checkbox'])[30]").click();
		 Thread.sleep(3000);
		 
		 //Check whether Shampoo is selected
		 String text=driver.findElementByXPath("//ul[@class='pull-left applied-filter-lists']").getText();
		 System.out.println("The selected item is  : "+text);
		 if (text.contains("Shampoo"))
			 System.out.println("Shampoo is selected as expected");
		 else
			 System.out.println("Shampoo is not selected as expected");
		 Thread.sleep(3000);
		 
		 //select Loreal Shampoo
		 driver.findElementByXPath("(//img[@class='listing-img'])[4]").click();
		 
		 
		 Set<String> winSet1 = driver.getWindowHandles();
		 List<String> winLis1=new ArrayList<String>(winSet1);
		 driver.switchTo().window(winLis1.get(2));
		 Thread.sleep(3000);
		 
		 driver.findElementByXPath("(//span[@class='size-pallets'])[2]").click();
		 
		 //print MRP
		 String price =driver.findElementByXPath("(//span[@class='post-card__content-price-offer'])[1]").getText();
		 System.out.println("MRP of the L'Oreal Paris Colour Protect Shampoo is : " +price);
		 
		 
		 //Add to cart
		 driver.findElementByXPath("( //button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  '])[1]").click();
		 Thread.sleep(3000);
		 
		 driver.findElementByXPath("//div[@class='AddBagIcon']").click();
		 
		 //print Grand total
		 
		 System.out.println("Grand Total : "+driver.findElementByXPath("(//div[@class='value'])[4]").getText()); 
		// System.out.println("Grand Total : "+total);
		 
		 //Add to cart
		 driver.findElementByXPath("//button[@class='btn full fill no-radius proceed ']").click(); 
		 Thread.sleep(3000);
		 driver.findElementByXPath("//button[@class='btn full big']").click();
		 
		 //Capture the error
	     System.out.println(driver.findElementByXPath("//div[text()='Please expect delay in shipments because of the national lockdown']").getText());
	     
	     //Close all the windows
	     driver.quit();
	 
		 
		 

	 
		
		 
	}

}
