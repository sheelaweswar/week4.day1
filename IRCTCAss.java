package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRCTCAss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver objcrmdriver = new ChromeDriver();
		objcrmdriver.get("https://www.irctc.co.in/");
		objcrmdriver.manage().window().maximize();
		objcrmdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		objcrmdriver.findElement(By.xpath("//button[text()='OK']")).click();
		objcrmdriver.findElement(By.xpath("//a[contains(text(),' FLIGHTS ')]")).click();
		Set<String> windowHandles = objcrmdriver.getWindowHandles();
		System.out.println(windowHandles);
		List<String> list=new ArrayList<String>(windowHandles);
		objcrmdriver.switchTo().window(list.get(1));
		System.out.println(objcrmdriver.getCurrentUrl());

		objcrmdriver.findElement(By.xpath("//button[text()='Allow']")).click();
		objcrmdriver.findElement(By.xpath("//a[text()='Contact Us']")).click();

		String cusemail = objcrmdriver.findElement(By.xpath("(//a[@class='dropdown-item'])[3]")).getText();


		System.out.println("printemail:"+cusemail);
		objcrmdriver.close();

	}

}
