package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiFrameExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver objcrmdriver = new ChromeDriver();
		objcrmdriver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		objcrmdriver.manage().window().maximize();
		objcrmdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement pframe1 = objcrmdriver.findElement(By.xpath("//iframe[@id='frame1']"));
		//parent iframe
		objcrmdriver.switchTo().frame(pframe1);
		objcrmdriver.findElement(By.xpath("//input[1]")).sendKeys("Basic iframe");
		//child iframe
		WebElement cframe1 = objcrmdriver.findElement(By.xpath("//iframe[@id='frame3']"));
		objcrmdriver.switchTo().frame(cframe1);
		objcrmdriver.findElement(By.xpath("//input[@type='checkbox']")).click();
		objcrmdriver.switchTo().defaultContent();
		WebElement Aframe1 = objcrmdriver.findElement(By.xpath("//iframe[@id='frame2']"));
		objcrmdriver.switchTo().frame(Aframe1);
		objcrmdriver.findElement(By.xpath("//option[text()='Baby Cat']")).click();
		objcrmdriver.switchTo().defaultContent();

	}

}
