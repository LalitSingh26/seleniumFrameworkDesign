package lalitUISeleniumFramework.abstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lalitUISeleniumFramework.SeleniumFrameworkDesign.CartItem;

public class AbstractComponent {
	 WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;

	public void waitForElement(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	public void waitForWebElement(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOf(findBy));
		
		}
	
	public void waitForElementToDisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.invisibilityOf(ele));
		 
	}
	
	public CartItem goToCartPage() {
		cartHeader.click();
		CartItem cartItem = new CartItem(driver);
		return cartItem;
		 
	}
	
}
