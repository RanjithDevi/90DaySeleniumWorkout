package basicSeleniumPrograms;

 
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

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
		 driver.get("https://www.myntra.com/");
		 //Implicitly wait for 5 milliseconds
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 
		 //Mouse Hover on Women
		 WebElement ele=driver.findElementByXPath("(//a[text()='Women'])[1]");
		 Thread.sleep(3000);
		 Actions over=new Actions(driver);
		 over.moveToElement(ele).perform();
		 over.moveToElement(driver.findElementByXPath("//a[text()='Jackets & Coats']")).click().perform();
		 Thread.sleep(3000);
		 
		 //Getting the Total number of Jackets and Coats
		 String count;
		 int total;
		 count=driver.findElementByXPath("//span[@class='title-count']").getText();
		 count=count.replaceAll("\\D", "");
		 total=Integer.parseInt(count);
		 System.out.println("Total number of items : "+total);
		 
		 //Total number of coats
		 String coats;
		 int coatstotal;
		 coats=driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
		 coats=coats.replaceAll("\\D", "");
		 coatstotal=Integer.parseInt(coats);
		 System.out.println("Total number of Coats: "+coatstotal);
		
		 //Total number of jackets
		 String jackets;
		 int jacktotal;
		 jackets=driver.findElementByXPath("(//span[@class='categories-num'])[1]").getText();
		 jackets=jackets.replaceAll("\\D", "");
		 jacktotal=Integer.parseInt(jackets);
		 System.out.println("Total number of Jackets: "+jacktotal);
		 
		 //Checking whether the total number of coats and jackets matches the sum of individual coats and jackets
		 int dress=coatstotal+jacktotal;
		 System.out.println("Total Number of Dress = "+dress);
		 if (dress==total)
			 System.out.println("The total number of coats and jackets matches the sum of individual coats and jackets");
		 else
			 System.out.println("The total number of coats and jackets doesnot match the sum of individual coats and jackets");
		 
		 //Check the coats
		 driver.findElementByXPath("(//label[@class='common-customCheckbox vertical-filters-label'])[2]").click();
		 Thread.sleep(2000);
		
		 //Click + more options in brand
		 driver.findElementByXPath("//div[@class='brand-more']").click();
		 
		 driver.findElementByXPath("//input[@class='FilterDirectory-searchInput']").sendKeys("Mango");
		 Thread.sleep(3000);
		 driver.findElementByXPath("//label[@class=' common-customCheckbox']//div[1]").click();
		 
		 driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		 Thread.sleep(3000);
		
		 
		 //Check if all the brands are of MANGO
		 int s=0;
		 List<WebElement> brand=driver.findElementsByXPath("(//h3[@class='product-brand'])");
		 for (WebElement eachBrand : brand)
		 {
			 
			 String name=eachBrand.getText();
			 if (name.equalsIgnoreCase("MANGO"))
					 s=s+1;
		 }
		 System.out.println("Total number of Mango Coat items : " +s);
			 if (s==brand.size())
				 System.out.println("All the products are of brand Mango");
			 else
				 System.out.println("All the products are not of brand Mango");
			 
			 
			 //sort by better discount
			 WebElement sort=driver.findElementByXPath("//div[@class='sort-sortBy']");
			 Actions  over1= new Actions(driver);
			 over1.moveToElement(sort).perform();
			
			 	 
			 Thread.sleep(2000);
			 driver.findElementByXPath("//label[text()='Better Discount']").click();
			 Thread.sleep(3000);
			 
			 //Price of First displayed Item
			 List<WebElement> price=driver.findElementsByXPath("(//span[@class='product-discountedPrice'])[1]");
			 String firstprice=price.get(0).getText();
			 firstprice=firstprice.replaceAll("\\D", "");
			 int firstitem=Integer.parseInt(firstprice);
			 System.out.println(firstitem);
			 Thread.sleep(3000);

			 //Mouse Hover on first item
			 WebElement sizeOfFirst = driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]");
			 Actions builder2 = new Actions(driver);
			 builder2.moveToElement(sizeOfFirst).perform();
			 
			 //click Wish list
			 driver.findElementByXPath("(//span[@class='product-actionsButton product-wishlist product-prelaunchBtn'])[1]").click();
			
			 //close the driver
			 driver.close();
			 
			
		
	}
}
