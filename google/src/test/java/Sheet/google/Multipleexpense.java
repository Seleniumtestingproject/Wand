package Sheet.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Multipleexpense {


	public void millage(WebDriver driver){
		
		Select category=new Select(driver.findElement(By.xpath("//*[@id='detailItemList1.clientExpenseCategoryId']")));
		category.selectByValue("194236456");
		
		driver.findElement(By.xpath("//*[@id='detailItemList1.mileage']")).sendKeys("120");
	driver.findElement(By.xpath("//*[@id='detailItemList1.from']")).sendKeys("USA");

	driver.findElement(By.xpath("//*[@id='detailItemList1.destination']")).sendKeys("INDIA");

	//driver.findElement(By.xpath("//*[@id='detailItemList1.receiptReceived1']")).click();

	}
}

