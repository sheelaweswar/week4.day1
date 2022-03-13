package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class W3schoolAssign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver objcrmdriver = new ChromeDriver();
		objcrmdriver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		objcrmdriver.manage().window().maximize();
		objcrmdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement frame = objcrmdriver.findElement(By.xpath("//div[@id='iframewrapper']/iframe"));
		objcrmdriver.switchTo().frame(frame);
		WebElement clkme1 =objcrmdriver.findElement(By.xpath("//button[text()='Try it']"));
		clkme1.click();
		Alert alert = objcrmdriver.switchTo().alert();
		String alertMessage = alert.getText();
		System.out.println(alertMessage);
		alert.accept();
		String text = objcrmdriver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println("Print the text:"+text);
		
	}
}
