package week4.day1;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver objcrmdriver = new ChromeDriver();
		objcrmdriver.get("http://leaftaps.com/opentaps/control/login");
		objcrmdriver.manage().window().maximize();
		objcrmdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement usrnme =  objcrmdriver.findElement(By.xpath("//input[@id='username']"));
		usrnme.sendKeys("demoSalesManager");
		objcrmdriver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		objcrmdriver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		objcrmdriver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		objcrmdriver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		objcrmdriver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();
		System.out.println(objcrmdriver.getTitle());
		//1st icon
		objcrmdriver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> windowHandles = objcrmdriver.getWindowHandles();
		List<String> newWindow=new LinkedList<String>(windowHandles);
		objcrmdriver.switchTo().window(newWindow.get(1));
		objcrmdriver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		
		objcrmdriver.switchTo().window(newWindow.get(0));
		//2nd icon
		//objcrmdriver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		//objcrmdriver.switchTo().window(newWindow.get(1));
		
		//objcrmdriver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[2]//a[@class='linktext']")).click();
		
		objcrmdriver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();
		Alert alert = objcrmdriver.switchTo().alert();
		alert.accept();
		System.out.println(objcrmdriver.getTitle());
		
		
		
		

	}

}
