package Sheet.google;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.CustomElementCollection;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.util.ServiceException;

public class Google {
	
	
	
	static WebDriver driver;

@Test

public void test() throws Throwable{

// TODO Auto-generated method stub
		
		
		
		
		SpreadsheetService service = new SpreadsheetService("UserInfo");

		String sheetUrl =
		"https://spreadsheets.google.com/feeds/list/1EbXMTF-2YsOsm30DjJxqFcNeCDTjUl6pQfM5GyPyPPY/default/public/values";

		// Use this String as url
		URL url = new URL(sheetUrl);

		// Get Feed of Spreadsheet url
		ListFeed lf = service.getFeed(url, ListFeed.class);

		//Iterate over feed to get cell value
		for (ListEntry le : lf.getEntries()) {
		CustomElementCollection cec = le.getCustomElements();
		//Pass column name to access it's cell values
		
		String url1 = cec.getValue("URL");
		String username = cec.getValue("Username");
		System.out.println(username);
		
		System.out.println(url1);
		String password=cec.getValue("Password");
		String ENGfield =cec.getValue("ENG");
		
		String travel  =cec.getValue("Type");
		String  type=cec.getValue("category");
		String mulipleexpense =cec.getValue("Multipleexpense");
		String  client=cec.getValue("Client");
		
		String datacreate=cec.getValue("Datafor");

		String dataforsuporman=cec.getValue("Expensefor");


	
	String os=System.getProperty("os.name").toLowerCase();

		System.out.println(os);

		if(os.contains("mac")){

		System.setProperty("webdriver.chrome.driver", System.getProperty("WebDriver.chrome.driver", "/Users/vinodc/Downloads/chromedriver"));
		 driver= new ChromeDriver();
		 

		}

		
		driver.manage().window().maximize();
		
		if(url1.contains("prodtest2")){
			

			
			driver.get("https://prodtest2.prounlimited.com");
			
			
			
		}
		
		else if(url1.contains("qastage2"))
		{
			
			driver.get("https://qastaging2.dev.pro-unlimited.com/");
	
		}
	
		WebDriverWait wait=new WebDriverWait(driver, 150);

		
		
		driver.findElement(By.xpath("//*[@id='usernamefield']")).sendKeys(username);

			driver.findElement(By.xpath("//*[@id='passwordfield']")).sendKeys(password);
			
			//Click on subit button
			
			driver.findElement(By.xpath("/html/body/div[1]/main/form/button")).click();
			
			//Select client
			Thread.sleep(2000);

			Select a=new Select(driver.findElement(By.xpath("//*[@id='banner_loginpanel']/span[4]/select")));
	a.selectByVisibleText(client);

	Thread.sleep(3000);
	//Tap on exit configuration
	driver.findElement(By.xpath("//*[@id='banner']/div[2]/div[2]/span/a")).click();
////*[@id='banner']/div[2]/div[2]/span/a
	
	//Check data is for expense
	
	if(datacreate.contains("Expense")){
		
		
		
		
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/nav/ul/li[5]/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[13]/div[6]/div[3]/a")).click();
		driver.findElement(By.xpath("//*[@id='requisitionNumber']")).sendKeys(ENGfield);

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[13]/table/tbody/tr[1]/td/form/div/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/input[3]")).click();

		String date=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[13]/table/tbody/tr[1]/td/form/table/tbody/tr[1]/td[9]/div")).getText();

		Select a1=new Select(driver.findElement(By.xpath("//*[@id='billingType']")));

		a1.selectByValue("Expense");

		if(travel.contains("Travel")){
			
			Thread.sleep(3000);
			
		driver.findElement(By.xpath("//*[@id='addBillingItemCommand']/div[3]/table[2]/tbody/tr/td/input")).click();


		driver.findElement(By.xpath("//*[@id='tripInfo.duration']")).sendKeys("5");

		driver.findElement(By.xpath("//*[@id='tripInfo.destinationCountry']")).sendKeys("usa");


		driver.findElement(By.xpath("//*[@id='tripInfo.purpose']")).sendKeys("Business purpose for wand testing");

		driver.findElement(By.xpath("//*[@id='tripInfo.date']")).sendKeys(date);

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[13]/table/tbody/tr[1]/td/form/div[2]/table[2]/tbody/tr/td[2]/input")).click();

		if(type.contains("Auto")){
			

		Select category=new Select(driver.findElement(By.xpath("//*[@id='detailItemList0.clientExpenseCategoryId']")));


		category.selectByVisibleText("Auto");


		Select name= new Select(driver.findElement(By.xpath("//*[@id='AutoSelect_0_']")));
		name.selectByValue("Rental");

		driver.findElement(By.xpath("//*[@id='detailItemList0.name']")).sendKeys("Test");
		Common data1=new Common();
		data1.expensedetail(driver);
		
		
		
		if(dataforsuporman.contains("Manager")){
			
			
			
			driver.findElement(By.xpath("//*[@id='detailItemList0.receiptReceived1']")).click();
			
			
			
		}
		
		
		
		if(mulipleexpense.contains("Yes")){
			
			
			//Multipleexpense travel= new Multipleexpense();
			
			driver.findElement(By.cssSelector(".graybutton")).click();
			driver.findElement(By.xpath("//*[@id='detailItemList1.date']")).sendKeys(date);
			
			Thread.sleep(2000);
			Select category2=new Select(driver.findElement(By.id("detailItemList1.clientExpenseCategoryId")));
			category2.selectByValue("194236439");

			Select name1= new Select(driver.findElement(By.xpath("//*[@id='AutoSelect_1_']")));
			name1.selectByValue("Rental");

			driver.findElement(By.xpath("//*[@id='detailItemList1.name']")).sendKeys("Test");
			Common a11= new Common();
			
			if(dataforsuporman.contains("Manager")){
				
				driver.findElement(By.xpath("//*[@id='detailItemList1.receiptReceived1']")).click();
				


			}	
			
			
			
			a11.expensedetailmultiple(driver);

			

driver.findElement(By.xpath("//input[@type='submit']")).click();

		}
		


		
		else{
			
			Thread.sleep(2000);

			
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			
		}

		}
		
		

		if(type.contains("millage")){
			
			Select category=new Select(driver.findElement(By.xpath("//*[@id='detailItemList0.clientExpenseCategoryId']")));
			category.selectByValue("194236456");
			
			driver.findElement(By.xpath("//*[@id='detailItemList0.mileage']")).sendKeys("120");
		
			driver.findElement(By.xpath("//*[@id='detailItemList0.from']")).sendKeys("USA");

		driver.findElement(By.xpath("//*[@id='detailItemList0.destination']")).sendKeys("INDIA");
		
		
		if(dataforsuporman.contains("Manager")){
			
			driver.findElement(By.xpath("//*[@id='detailItemList0.receiptReceived1']")).click();
			
			
			
				
				
			}
			
		
		


		if(mulipleexpense.contains("Yes")){
			driver.findElement(By.cssSelector(".graybutton")).click();
			driver.findElement(By.xpath("//*[@id='detailItemList1.date']")).sendKeys(date);

			Multipleexpense travel1= new Multipleexpense();
			
travel1.millage(driver);

if(dataforsuporman.contains("Manager")){
	
	driver.findElement(By.xpath("//*[@id='detailItemList1.receiptReceived1']")).click();
	}


			driver.findElement(By.xpath("/html/body/div/div/div[2]/div[13]/table/tbody/tr[1]/td/form/table[3]/tbody/tr[4]/td/div/table/tbody/tr[1]/td[3]/div/input")).click();


		}
		
		
		else
		{
			
			driver.findElement(By.xpath("/html/body/div/div/div[2]/div[13]/table/tbody/tr[1]/td/form/table[3]/tbody/tr[4]/td/div/table/tbody/tr[1]/td[3]/div/input")).click();

		
		}
		}
		
		if(type.contains("Communication")){
			
			
			
			Select category3=new Select(driver.findElement(By.xpath("//*[@id='detailItemList0.clientExpenseCategoryId']")));
			category3.selectByVisibleText("Communications");
			
			Select comtype=new Select(driver.findElement(By.xpath("	//*[@id='detailItemList0.communicationType']")));
			comtype.selectByVisibleText("Modem");
			
			

			Select freq=new Select(driver.findElement(By.xpath("//*[@id='detailItemList0.freq']")));
			freq.selectByVisibleText("Daily");
			
			Common com=new Common();
			
			com.expensedetail(driver);

			
			if(dataforsuporman.contains("Manager")){
				
				driver.findElement(By.xpath("//*[@id='detailItemList0.receiptReceived1']")).click();
				}
			
			
			if(mulipleexpense.contains("Yes")){
				
				
				driver.findElement(By.cssSelector(".graybutton")).click();
				driver.findElement(By.xpath("//*[@id='detailItemList1.date']")).sendKeys(date);
				

				Select category4=new Select(driver.findElement(By.xpath("//*[@id='detailItemList1.clientExpenseCategoryId']")));
				category4.selectByValue("194236457");
				
				Select comtype1=new Select(driver.findElement(By.xpath("//*[@id='detailItemList1.communicationType']")));
				comtype1.selectByVisibleText("Modem");
				

				Select freq1=new Select(driver.findElement(By.xpath("//*[@id='detailItemList1.freq']")));
				freq1.selectByVisibleText("Daily");
				
				Common com1=new Common();
				
				com1.expensedetailmultiple(driver);

				
				if(dataforsuporman.contains("Manager")){
					
					driver.findElement(By.xpath("//*[@id='detailItemList1.receiptReceived1']")).click();
					}
				
				
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div[13]/table/tbody/tr[1]/td/form/table[3]/tbody/tr[4]/td/div/table/tbody/tr[1]/td[3]/div/input")).click();


			}

			else
			{
				
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div[13]/table/tbody/tr[1]/td/form/table[3]/tbody/tr[4]/td/div/table/tbody/tr[1]/td[3]/div/input")).click();

			}
				
			
		}
		}
	
		else 
			
		{	
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='tripRelated1']")).click();
			
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[13]/table/tbody/tr[1]/td/form/div[3]/table[2]/tbody/tr/td/input")).click();

			if(type.contains("Communication")){
				
				driver.findElement(By.xpath("//*[@id='detailItemList0.date']")).sendKeys(date);

				
				Select category3=new Select(driver.findElement(By.xpath("//*[@id='detailItemList0.clientExpenseCategoryId']")));
				category3.selectByVisibleText("Communications");
				
				Select comtype=new Select(driver.findElement(By.xpath("	//*[@id='detailItemList0.communicationType']")));
				comtype.selectByVisibleText("Modem");
				
				

				Select freq=new Select(driver.findElement(By.xpath("//*[@id='detailItemList0.freq']")));
				freq.selectByVisibleText("Daily");
				
				driver.findElement(By.xpath("//*[@id='detailItemList0.purpose']")).sendKeys("qa testing wand mobile expense");
				
				Common com=new Common();
				
				com.expensedetail(driver);
				
if(dataforsuporman.contains("Manager")){
					
					driver.findElement(By.xpath("//*[@id='detailItemList0.receiptReceived1']")).click();
					}
				
				if(mulipleexpense.contains("Yes")){
					
					
					driver.findElement(By.cssSelector(".graybutton")).click();
					driver.findElement(By.xpath("//*[@id='detailItemList1.date']")).sendKeys(date);
					

					Select category4=new Select(driver.findElement(By.xpath("//*[@id='detailItemList1.clientExpenseCategoryId']")));
					category4.selectByValue("194236457");
					
					Select comtype1=new Select(driver.findElement(By.xpath("//*[@id='detailItemList1.communicationType']")));
					comtype1.selectByVisibleText("Modem");
					

					Select freq1=new Select(driver.findElement(By.xpath("//*[@id='detailItemList1.freq']")));
					freq1.selectByVisibleText("Daily");
					
					driver.findElement(By.xpath("//*[@id='detailItemList1.purpose']")).sendKeys("qa testing wand mobile expense");

					
					Common com1=new Common();
					
					com1.expensedetailmultiple(driver);
					
					
					if(dataforsuporman.contains("Manager")){
						
						driver.findElement(By.xpath("//*[@id='detailItemList1.receiptReceived1']")).click();
						}
					
					driver.findElement(By.xpath("/html/body/div/div/div[2]/div[13]/table/tbody/tr[1]/td/form/table[3]/tbody/tr[4]/td/div/table/tbody/tr[1]/td[3]/div/input")).click();


				}

				else
				{
					
					driver.findElement(By.xpath("/html/body/div/div/div[2]/div[13]/table/tbody/tr[1]/td/form/table[3]/tbody/tr[4]/td/div/table/tbody/tr[1]/td[3]/div/input")).click();

				}
					

		}
			}
			
		}
			
		
		
	else{
		//Request data
	
	
	
	
	//Select ENG option
	
	
	Select a1=new Select(driver.findElement(By.xpath("//*[@id='searchObject']")));
	a1.selectByValue("ENGAGEMENT");
//search ENG
	driver.findElement(By.id("searchText")).sendKeys(ENGfield);
	
	//click on search button
	
	driver.findElement(By.xpath("//*[@id='searchHeader']/div[3]/a/i")).click();
	//Tap on ENG
	
	Thread.sleep(2000);
	
driver.findElement(By.xpath("//*[@id='gridview-1028']/table/tbody/tr[2]/td[1]/div/a")).click();
	
//Swipe to reuse and click
JavascriptExecutor je = (JavascriptExecutor) driver;
WebElement el0=driver.findElement(By.xpath("//*[@id='nonSaveDiv']/form/table/tbody/tr/td[2]/input[3]"));

je.executeScript("arguments[0].scrollIntoView(true);",el0);

el0.click();

// swipe to skills 
WebElement el1=driver.findElement(By.xpath("//*[@id='skillAddLink']"));
je.executeScript("arguments[0].scrollIntoView(true);",el1);

//pass value to skills field

Thread.sleep(2000);
WebElement tap= driver.findElement(By.xpath("//*[@id='skillsIdCombo']"));

tap.sendKeys("java"); 
//Select skill

tap.sendKeys(Keys.ARROW_DOWN);

tap.sendKeys(Keys.ENTER);
	

//tap on add button 


driver.findElement(By.xpath("//*[@id='skillAddLink']")).click();
//select bid

Select bid=new Select(driver.findElement(By.xpath("//*[@id='customFields[5].valueSelect']")));
bid.selectByValue("No");


//Enter position


driver.findElement(By.xpath("//*[@id='requisition.initialHeadcount']")).clear();

driver.findElement(By.xpath("//*[@id='requisition.initialHeadcount']")).sendKeys("10");

//enter start date:

Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id='ext-gen1066']")).click();  
driver.findElement(By.xpath("//*[@id='ext-gen1113']/a/em/span")).click();
//driver.findElement(By.id("datefield-1010-inputEl")).sendKeys("04/01/2019");

Thread.sleep(2000);


driver.findElement(By.xpath("//*[@id='ext-gen1071']")).click();

driver.findElement(By.xpath("//*[@id='ext-gen1173']/a/em/span")).click();
Thread.sleep(2000);

WebElement el2=driver.findElement(By.xpath("//*[@id='ObjectGenInfo']/table/tbody/tr/td[2]/input[2]"));    //*[@id="ObjectGenInfo"]/table/tbody/tr/td[2]/input[2]
je.executeScript("arguments[0].scrollIntoView(true);",el2);

el2.click();

//scrol to submit button

WebElement el3=driver.findElement(By.xpath("//*[@id='submit']/input[2]"));
je.executeScript("arguments[0].scrollIntoView(true);",el3);

el3.click();


//click on approve button


driver.findElement(By.xpath("//*[@id='btnApprove']")).click();
}
	}
}
}

