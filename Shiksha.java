package basicSeleniumPrograms;

 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shiksha {

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
				 driver.get("https://studyabroad.shiksha.com/");
			//Implicitly wait for 5 milliseconds
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 JavascriptExecutor js =  (JavascriptExecutor) driver;	
				 Thread.sleep(1000);
				 WebDriverWait wait = new WebDriverWait(driver, 30);
			//Mouse Hover on Colleges
				 
				 WebElement brand=driver.findElementByXPath("(//label[@class='menuTab-div fnt-wt melabel'])[3]");
				 Thread.sleep(1000);
				 Actions over=new Actions(driver);
				 over.moveToElement(brand).perform();
				 Thread.sleep(2000);
				 driver.findElementByXPath("//a[text()='MS in Computer Science &Engg']").click();
				  
				 
				WebElement GRE = driver.findElementByXPath("//p[text()='GRE']");
				js.executeScript("arguments[0].click()", GRE);
				wait.until(ExpectedConditions.elementToBeClickable(By.name("examsScore[]")));
				Select score = new Select(driver.findElement(By.name("examsScore[]")));
				score.selectByVisibleText("284 & below");
				js.executeScript("arguments[0].click()", score);
				
				WebElement lakhs=driver.findElementByXPath("//p[text()='Max 10 Lakhs']");
				js.executeScript("arguments[0].click()", lakhs);
				Thread.sleep(500);
				
				Thread.sleep(2000);
				WebElement USA= driver.findElement(By.xpath("//a[text()='USA']//parent::p//preceding-sibling::span"));
				 js.executeScript("arguments[0].click()", USA);
				 Thread.sleep(2000);
				 
				 WebElement sortByLow = driver.findElementById("categorySorter");
				 Select sort = new Select(sortByLow);
				 sort.selectByVisibleText("Low to high 1st year total fees");
				 Thread.sleep(2000);
				 
				 List<WebElement> colleges=driver.findElementsByXPath("//div[@class='tuple-title']");
				 List<Double> collegeFee = new ArrayList<Double>();
				 for (int i=1;i<=colleges.size();i++)
				 {
					 if (driver.findElementsByXPath(
							 "(//div[contains(@id,'categoryPageListing_tupleId')])[" + i + "]//span[@class='tick-mark']")
							 .size() == 3) 
					 {
							 
						 collegeFee.add(Double.parseDouble(driver.findElementByXPath("(//div[@class='detail-col flLt']"
						 		+ "/p[contains(text(),'Rs')])[" + i + "]").getText().replaceAll("[^0-9\\s.]+|\\.(?!\\d)", "")));
					 }
				 }
				 Thread.sleep(1000);
				 Collections.sort(collegeFee);
				 driver.findElementByXPath("(//div[@class='detail-col flLt'])/p[contains(text(),'" + collegeFee.get(0)
					+ "')]/ancestor::div[@class='clearwidth']/"
					+ "following-sibling::div[@class='compare-box flRt customInputs']//span").click();
				 
				 driver.findElementByXPath("//a[text()=' Texas Southern University']").click();
				Thread.sleep(500);

			     driver.findElementByXPath("//strong[text()='Compare Colleges >']").click();
			     Thread.sleep(3000);
			     
			   //Clicking 2021
			     driver.findElementByXPath("(//span[@class='common-sprite'])[2]").click();
			     Thread.sleep(500);
			     driver.findElementByXPath("(//div[@class='input'])[1]").click();
			     Thread.sleep(1000);
			     driver.findElementByXPath("(//span[@class='common-sprite'])[7]").click();
			     Thread.sleep(1000);
			     driver.findElementByXPath("//a[@class='ok-btn']");
			     Thread.sleep(1000);
			     
			     //clicking MAsters
			     driver.findElementByXPath("(//span[@class='common-sprite'])[5]").click();
			     Thread.sleep(2000);
			     
			     WebElement course=driver.findElementByXPath("//div[text()='Preferred Course']");
			     js.executeScript("arguments[0].click()", course);
			     Thread.sleep(1000);
			     driver.findElementByXPath("//li[text()='MS']").click();
			     Thread.sleep(1000);
			     
			     
			     //WebElementdriver.findElementByXPath("//div[@class='input'][3]").click();
			     Thread.sleep(1000);
			     WebElement special = driver.findElementByXPath("//div[text()='All specializations']");
			     js.executeScript("arguments[0].click()", special);
			     Thread.sleep(1000);
			     driver.findElementByXPath("//li[text()='Computer Science & Engineering']").click();
			     Thread.sleep(1000);
			     driver.findElementByXPath("//a[@class='button-style big-button ']").click();
			     
			     //capturing error messages
			     List<WebElement> errorMsgs = driver
							.findElementsByXPath("//div[@class='input-helper']//div[contains(text(),'Please')]");
					System.out.println("Error messages for mandatory fields are displayed below :");
					for (int i = 0; i < errorMsgs.size(); i++) {
						String errorMsgText = errorMsgs.get(i).getText();
						if (errorMsgText.length() > 0) {
							System.out.println(errorMsgText);
						}
					}
					driver.close();
				}
		 
			 

	}


