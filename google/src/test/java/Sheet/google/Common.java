package Sheet.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Common {

	
	
WebDriver driver;
	
	
	public void expensedetail(WebDriver driver) throws Throwable{
		
		driver.findElement(By.name("detailItemList[0].amount")).clear();

		
		driver.findElement(By.name("detailItemList[0].amount")).sendKeys("20");
		
		driver.findElement(By.xpath("//*[@id='detailItemList0.payAmount']")).clear();
		
		driver.findElement(By.xpath("//*[@id='detailItemList0.payAmount']")).sendKeys("10");

		
	
//driver.findElement(By.xpath("//*[@id='detailItemList0.receiptReceived1']")).click();

	}
	
	
	public void expensedetailmultiple(WebDriver driver) throws Throwable{
		
		driver.findElement(By.name("detailItemList[1].amount")).clear();

		
		driver.findElement(By.name("detailItemList[1].amount")).sendKeys("20");
		
		driver.findElement(By.xpath("//*[@id='detailItemList1.payAmount']")).clear();
		
		Thread.sleep(2000);
		
	driver.findElement(By.id("detailItemList1.payAmount")).sendKeys("10");
	
//driver.findElement(By.xpath("//*[@id='detailItemList1.receiptReceived1']")).click();

	
	

}
}


	
	
	
	

