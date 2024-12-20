package cuziArchitecture.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends ParentPage {
    WebDriver driver;

    @FindBy(css = ".mb-3")
    private List<WebElement> products;
    By productsBy = By.cssSelector(".mb-3");// gets list of all items available on the page
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");

    @FindBy(css = ".ng-animating")
    private WebElement spinner; // invisible wait background loading spinner

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getProductList() {
        elementWait(productsBy);
        return products;
    }

    public WebElement getProductName(String productName) {
        WebElement productList = getProductList().stream().filter(product -> // stream filters through page to get product name
                product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return productList;
    }

    public void addProductToCart(String productName) {
        System.out.println("gets product name");
        WebElement productList = getProductName(productName);
        System.out.println("adds product to cart");
        productList.findElement(addToCart).click();// filters products through a stream to find product you want to purchase
        System.out.println("item added");
        elementWait(toastMessage);
        elementDisappear(spinner);
    }
}
