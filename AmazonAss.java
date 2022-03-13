package week4.day1;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAss {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver objcrmdriver = new ChromeDriver();
		objcrmdriver.get("https://www.amazon.in/");
		objcrmdriver.manage().window().maximize();
		objcrmdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		objcrmdriver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro ",Keys.ENTER);
		String price = objcrmdriver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		objcrmdriver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Set<String> windowHandles = objcrmdriver.getWindowHandles();
		List<String> newWindow=new LinkedList<String>(windowHandles);
		objcrmdriver.switchTo().window(newWindow.get(1));
		System.out.println(objcrmdriver.findElement(By.xpath("(//span[@id='acrCustomerReviewText'])[1]")).getText());
		System.out.println(price);
		objcrmdriver.findElement(By.xpath("(//img[@class='imgSwatch'])[1]")).click();
		Thread.sleep(3000);
		objcrmdriver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		objcrmdriver.switchTo().window(newWindow.get(1));
		Thread.sleep(3000);
		String cart = objcrmdriver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println("cart:"+cart);
		//String strPrice = price.replaceAll(",","").replaceAll("\\?","");
		//String strCart = cart.replaceAll(",","").replaceAll("\\?","");
		//System.out.println("strPrice:"+strPrice);
		//System.out.println("strCart:"+strCart);
		//if(Float.parseFloat(strPrice) == Float.parseFloat(strCart)) {
		if(price.equals(cart)) {
			System.out.println("Matching");
		}else {
			System.out.println("Not Matching");
		}
	}
}
