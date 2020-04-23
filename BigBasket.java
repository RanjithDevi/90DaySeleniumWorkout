package basicSeleniumPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class BigBasket {

	public static void main(String[] args) throws InterruptedException {
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
		 driver.get("https://www.bigbasket.com/");
		 //Implicitly wait for 5 milliseconds
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Thread.sleep(3000);
		 driver.findElementByXPath("//span[@class='close-btn']").click();
		 Thread.sleep(3000);
		 
 //Mouse Hover on Shop by Category
		 WebElement category=driver.findElementByXPath("//a[@class='dropdown-toggle meganav-shop']");
		 Actions over=new Actions(driver);
		 over.moveToElement(category).perform();
		 Thread.sleep(3000);
		 
		 WebElement grains=driver.findElementByXPath("(//a[text()='Foodgrains, Oil & Masala'])[2]");
		 Actions over1=new Actions(driver);
		 over1.moveToElement(grains).perform();
		 Thread.sleep(3000);
		 
		 WebElement rice=driver.findElementByXPath("(//a[text()='Rice & Rice Products'])[2]");
		 Actions over2=new Actions(driver);
		 over2.moveToElement(rice).perform();
		 Thread.sleep(3000);   
		 
		 driver.findElementByXPath("(//a[text()='Boiled & Steam Rice'])[2]").click();
		 Thread.sleep(2000);
		 driver.findElementByXPath("(//span[text()='bb Royal'])[1]").click();
		 Thread.sleep(2000);
		 
		 String rice1 =driver.findElementByXPath("//a[text()='Ponni Boiled Rice - Super Premium']").getText();
		 System.out.println("Rice type Selected is : "+rice1);
		 if (rice1.equalsIgnoreCase("Ponni Boiled Rice - Super Premium"))
		 {
			 driver.findElementByXPath("(//i[@class='fa fa-caret-down'])[3]").click();
			 Thread.sleep(3000);
			 driver.findElementByXPath("(//a[@style='text-decoration: none;'])[9]").click();
			 
		 }
		 String riceprice=driver.findElementByXPath("(//span[@class='discnt-price'])[3]").getText();
		 System.out.println("Rice price is : " +riceprice);
		 driver.findElementByXPath("(//button[@class='btn btn-add col-xs-9'])[3]").click();
		 Thread.sleep(3000);
		 driver.findElementByXPath("//div[@class='toast-title']").click();
		 Thread.sleep(3000);
		 driver.findElementByXPath("(//input[@placeholder='Search for Products..'])[1]").sendKeys("Dal",Keys.ENTER);
		 Thread.sleep(3000);
		 
		 driver.findElementByXPath("(//i[@class='fa fa-caret-down'])[2]").click();
		 Thread.sleep(2000);
		 driver.findElementByXPath("(//span[text()='2 kg'])[3]").click();
		 String dalprice=driver.findElementByXPath("(//span[@class='discnt-price'])[3]").getText();
		 System.out.println("Toor Dal 2kg price is "+dalprice);
		 
		 driver.findElementByXPath("(//input[@ng-model='vm.startQuantity'])[3]").clear();
		 driver.findElementByXPath("(//input[@ng-model='vm.startQuantity'])[3]").sendKeys("2");
		 Thread.sleep(2000);
		 driver.findElementByXPath("(//button[@qa='add'])[3]").click();
		 Thread.sleep(3000);
		 
		 String addMsgDal = driver.findElementByXPath("//div[@class='toast-title']").getText();
			if (addMsgDal.equalsIgnoreCase("Successfully added Toor/Arhar Dal/Thuvaram Paruppu 2 kg to the basket")) {
				System.out.println("The meassage after adding dal into cart is " + addMsgDal);
			} else {
				System.out.println("Wrong message displayed" + addMsgDal);
			}
			driver.findElementByXPath("//button[@class='toast-close-button']").click();
		 //Mouse over on My basket
		 WebElement basket=driver.findElementByXPath("//span[@class='basket-content']");
		 Actions over3=new Actions(driver);
		 over3.moveToElement(basket).perform();
		 Thread.sleep(5000);
		
		 //Displaying both the items and the total in cart
		 String riceprices = driver.findElementByXPath("(//span[@qa='priceMB'])[1]").getText();
		 double ricep =Double.parseDouble(riceprices);
		 System.out.println("Price of first item : " +ricep);
		 String quantrice=driver.findElementByXPath("(//div[@class='product-qty ng-binding'])[1]").getText();
		 quantrice=quantrice.substring(0, 1);
		// System.out.println(quantrice);
		 double quanricep =Double.parseDouble(quantrice);
		 System.out.println("Quantity of first item  : " +quantrice);
		 String dalprices = driver.findElementByXPath("(//span[@qa='priceMB'])[2]").getText();
		 double dalp=Double.parseDouble(dalprices);
		 System.out.println("Price of second item : " +dalp);
		 String quantdal=driver.findElementByXPath("(//div[@class='product-qty ng-binding'])[2]").getText();
		 quantdal=quantdal.substring(0, 1);
		 double dalq=Double.parseDouble(quantdal);
		 System.out.println("Quantity of second item  : " +quantdal);
		 System.out.println(dalp*dalq);
		 String total=driver.findElementByXPath("//span[@qa='subTotalMB']").getText();
		 double totitems=Double.parseDouble(total);
		 System.out.println("Total Price of both the items : :"+totitems);
		 double tot=((ricep*quanricep)+(dalp*dalq));
		 System.out.println("Calculated total : "+tot);
		 //validating calculated and displayed total
		 if (tot==totitems)
			 System.out.println("Both the displayed total and the calculated total are same");
		 else
			 System.out.println("Both the displayed total and the calculated total are not same");
		 
		 
		 //Reducing the equantity of da to 1
		 driver.findElementByXPath("(//button[@ng-click='vm.decreamentQuantity(cartItem);'])[2]").click();
		 Thread.sleep(3000);
		 String updateprice= driver.findElementByXPath("(//span[@qa='priceMB'])[2]").getText();
		 double updateprice1=Double.parseDouble(updateprice);
		 System.out.println("Updated Price of sceond Item : "+updateprice);
		 String quantdal1=driver.findElementByXPath("(//div[@class='product-qty ng-binding'])[2]").getText();
		 quantdal1=quantdal1.substring(0,1);
		 double dalq1=Double.parseDouble(quantdal1);
		 System.out.println("Quantity of second item  : " +quantdal1);
		 //calculating the new total
		 double updatetot=((ricep*quanricep)+(dalp*dalq1));
		 System.out.println("Updated New total : "+updatetot);
		 
		 //close the browser
		 driver.quit();
		 
		 
		 

		 
	}

}
