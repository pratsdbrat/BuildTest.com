package BuildPackage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import static org.assertj.core.api.Assertions.*;

public class SeleniumWBA {

	public static void main(String[] args)throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.build.com/");
		
		driver.manage().window().maximize();
		
		
		JavascriptExecutor je = (JavascriptExecutor)driver;
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("search_txt")).sendKeys("Suede Kohler K-6626-6U");
		driver.findElement(By.xpath("//*[@id='site-search']/div/button")).click();
		
		WebElement element = driver.findElement(By.xpath("//*[@id='product']/div[4]/div[2]/div[2]/div[1]/div[2]/div[2]/div/ul/li[14]/div"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		
		driver.findElement(By.xpath("//*[@id='product']/div[4]/div[2]/div[2]/div[1]/div[2]/div[2]/div/ul/li[14]/div")).click();
		driver.findElement(By.xpath("//*[@id='add-to-cart-wrap']/button")).click();
		
		driver.findElement(By.xpath("//*[@id='page-content']/div[1]/div[1]/div[1]/div[2]/div/button")).click();
		driver.findElement(By.linkText("Last Search")).click();
		
		WebElement element1 = driver.findElement(By.xpath("//*[@id='product']/div[4]/div[2]/div[2]/div[1]/div[2]/div[2]/div/ul/li[7]/div"));
		je.executeScript("arguments[0].scrollIntoView(true);",element1);
		
		driver.findElement(By.xpath("//*[@id='product']/div[4]/div[2]/div[2]/div[1]/div[2]/div[2]/div/ul/li[7]/div")).click();
		driver.findElement(By.xpath("//*[@id='add-to-cart-wrap']/button")).click();
		
		driver.findElement(By.xpath("//*[@id='page-content']/div[1]/div[1]/div[1]/div[2]/div/button")).click();
		driver.findElement(By.linkText("Home")).click();
		
		driver.findElement(By.id("search_txt")).sendKeys("Kohler K-5180-ST");
		driver.findElement(By.xpath("//*[@id='site-search']/div/button")).click();
		
		WebElement element2 = driver.findElement(By.xpath("//*[@id='main-product-quantity']/div/input"));
		je.executeScript("arguments[0].scrollIntoView(true);",element2);
		
		driver.findElement(By.xpath("//*[@id='add-to-cart-wrap']/button")).click();
		
		//Quantity of 3rd item increased to 2
		
		driver.findElement(By.xpath("//*[@id='quantity-2826147']")).click();
		driver.findElement(By.xpath("//*[@id='quantity-2826147']")).sendKeys(Keys.UP);
		driver.findElement(By.xpath("//*[@id='cart']/tbody/tr[3]/td[3]/div/a[1]")).click();
		
		driver.findElement(By.xpath("//*[@id='checkoutbuttons']/fieldset[1]/a/span")).click();
		driver.findElement(By.xpath("//*[@id='guest-login']/button")).click();
		
		driver.findElement(By.id("shippingfirstname")).sendKeys("Pratik");
		driver.findElement(By.id("shippinglastname")).sendKeys("Bhayani");
		driver.findElement(By.id("shippingaddress1")).sendKeys("527 W Pomona Blvd");
		driver.findElement(By.id("shippingaddress2")).sendKeys("Unit B");
		driver.findElement(By.id("shippingpostalcode")).sendKeys("91754");
			
		Select select2 = new Select(driver.findElement(By.id("shippingstate_1")));
		select2.selectByVisibleText("California");
		
		driver.findElement(By.id("shippingphonenumber")).sendKeys("5628414895");
		driver.findElement(By.id("emailAddress")).sendKeys("bhayani009@gmail.com");
			
		driver.findElement(By.id("creditCardNumber")).sendKeys("4111111111111111");
		
		Select select3 = new Select(driver.findElement(By.id("creditCardMonth")));
		select3.selectByVisibleText("04");
		
		Select select4 = new Select(driver.findElement(By.id("creditCardYear")));
		select4.selectByVisibleText("2020");
				
		driver.findElement(By.id("creditcardname")).sendKeys("Pratik Bhayani");
		driver.findElement(By.id("creditCardCVV2")).sendKeys("653");
		
		driver.findElement(By.xpath("//*[@id='creditcard']/div[3]/input")).click();
		
		//Assertions in AssertJ
		
		WebElement element3 = driver.findElement(By.id("taxAmount"));
		String tax = element3.getText();		
		assertThat(tax).isEqualTo("$112.66");
		System.out.println("CA tax is correct");
		
		WebElement element4 = driver.findElement(By.id("grandtotalamount"));
		String grandtotal = element4.getText();
		assertThat(grandtotal).isEqualTo("$1,666.60");
		System.out.println("Grandtotal is correct");
			
		driver.quit();
			
			}

		}
