package lalitUISeleniumFramework.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lalitUISeleniumFramework.abstractComponent.AbstractComponent;

public class CartItem extends AbstractComponent {
	
	WebDriver driver;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> productTitles;
	
	public CartItem(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
     
	
	public Boolean cartList(String elementSearch) {
//		List<WebElement> cartProducts = driver.findElements(cartProducts); 
		Boolean match = productTitles.stream().anyMatch(product->product.getText().equalsIgnoreCase(elementSearch));
		return match;
	}
	
	public CheckoutPage goToCheckout() {
		checkoutEle.click();
		return new CheckoutPage(driver);
		
	}
	
}
