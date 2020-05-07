package basicSeleniumPrograms;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Azure {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Launching Chromebrowser
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("download.default_directory","C:\\Users\\91755\\Downloads");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
			 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			 System.setProperty("webdriver.chrome.silentOutput", "true");
		//To disable notifications
			 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			// ChromeOptions options= new ChromeOptions();
			 options.addArguments("--disable-notifications");
			 options.addArguments("--incognito");
			 capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			 
			 ChromeDriver driver=new ChromeDriver(options);
			 JavascriptExecutor js =  (JavascriptExecutor) driver;
						 
		//Maximize the browser
			 driver.manage().window().maximize();
		//Load the url
			 driver.get("https://azure.microsoft.com/en-in/");
		//Implicitly wait for 5 milliseconds
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
	    //Click on Pricing
			 driver.findElementByXPath("//a[text()='Pricing']").click();
			 Thread.sleep(1000);
			 driver.findElementByXPath("(//a[@data-event='global-navigation-secondarynav-clicked-topmenu'])[2]").click();
			 Thread.sleep(2000);
			 driver.findElementByXPath("//button[text()='Containers']").click();
			 Thread.sleep(1000);
			 driver.findElementByXPath("(//span[text()='Container Instances'])[3]").click();
			 Thread.sleep(1000);
			 driver.findElementByXPath("//a[text()='View']").click();
			 
		//Selecting South India
			 WebElement sortElement = driver.findElementByClassName("select");
			 Select sortDD = new Select(sortElement);
			 sortDD.selectByVisibleText("South India");

			 WebElement duration=driver.findElementByXPath("(//input[@class='text-input numeric'])[2]");
			duration.clear();
			duration.sendKeys(Keys.BACK_SPACE,"180000",Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
			
			WebElement memory = driver.findElementByXPath("(//select[@class='select'])[3]");
			 Select mem = new Select(memory);
			 mem.selectByVisibleText("4.5 GB");
			 
			 driver.findElementByXPath("//button[@id='devtest-toggler']").click();
			 Thread.sleep(3000);
		 //Select rupee as currency 
			 WebElement selectrup = driver.findElementByXPath("//select[@class='select currency-dropdown']");
			 Select rup = new Select(selectrup);
			 rup.selectByValue("INR");
			 
			 String estimate=driver.findElementByXPath("(//div[@class='column large-3 text-right total']//span)[3]").getText();
			 System.out.println("Monthly Estimate : "+estimate);
			 
			 driver.findElementByXPath("//button[text()='Export']").click();
			 Thread.sleep(5000);
	     // Validate the file folder 
			 File file = new File("C:\\Users\\91755\\Downloads\\ExportedEstimate.xlsx");	
				if(file.exists()) {        
					System.out.println("Exported file1 exists for Container Instance  in the specified path");
				}
				Thread.sleep(5000);
				
		 //Click Example Scenarios
				WebElement eg=driver.findElementByXPath("//a[text()='Example Scenarios']");
				js.executeScript("arguments[0].click()", eg);
				Thread.sleep(1000);
				WebElement container = driver.findElementByXPath("(//button[@class='solution-architecture-item false'])[2]");
				js.executeScript("arguments[0].click()", container);
				
				Thread.sleep(1000);
			//Add the estimate
			    WebElement estima = driver.findElementByXPath("//button[@class='button button--secondary01 pull-right']");
			    js.executeScript("arguments[0].click()", estima);
			    System.out.println("Estimate is added");
			    Thread.sleep(1000);
			   
			    //Select rupee as currency 
				 WebElement selectrupee = driver.findElementByXPath("//select[@class='select currency-dropdown']");
				 Select rupi = new Select(selectrupee);
				 rupi.selectByValue("INR");
				 Thread.sleep(3000);
				 
			//Click Show Dev/Test Pricing 
				 WebElement toggle = driver.findElementByXPath("//button[@id='devtest-toggler']");
				 js.executeScript("arguments[0].click()", toggle);
				 Thread.sleep(3000);
			
			//Export the estimate
				 WebElement expt=driver.findElementByXPath("//button[text()='Export']");
				 js.executeScript("arguments[0].click()", expt);
				 
				 Thread.sleep(5000);

				 //Checking then folder location
				 File file1 = new File("C:\\Users\\91755\\Downloads\\ExportedEstimate (1).xlsx");	
					if(file1.exists()) {        
						System.out.println("Estimated Export file2 exists for Container Instance  in the specified path");
					}
					Thread.sleep(3000);
			 

			 

	}

}
