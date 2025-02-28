package lalitUISeleniumFramework.SeleniumFrameworkDesign;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String elementSearch="ZARA COAT 3";
     WebDriverManager.chromedriver().setup();
     WebDriver driver= new ChromeDriver();
     driver.get("https://rahulshettyacademy.com/client");
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.manage().window().maximize();
     
     driver.findElement(By.id("userEmail")).sendKeys("lalitsingh@gmail.com");
     driver.findElement(By.id("userPassword")).sendKeys("Lalit@gmail1");
	 driver.findElement(By.id("login")).click();
	 
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	 
	 List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
	 
	 //in Css Selector if you want to find anything by tagname just give the tag for example I added "b" as I wanted it.
	 WebElement prod= products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().
			 equals(elementSearch)).findFirst().orElse(null);
	 
	 prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	 
	
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	 wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	 
	 driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	 
	List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection")); 
	 
	Boolean value = cartProducts.stream().anyMatch(cartproduct->cartproduct.findElement(By.cssSelector(".cartSection h3")).getText().equalsIgnoreCase(elementSearch));
	Assert.assertTrue(value);
	System.out.println(value);
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,700)");
	Thread.sleep(3000);
//	js.executeScript("document.querySelector('..totalRow button').scrollTop=5000");
	
//	WebElement element = driver.findElement(By.id(".totalRow button"));
//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//	element.click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow button")));
	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	Actions a =  new Actions(driver);
	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	
	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".btnn.action__submit")).click();
	
	String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	driver.close();
	
	}

}
