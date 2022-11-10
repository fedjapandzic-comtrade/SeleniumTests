import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumCaseTwo {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait;

    @BeforeTest
    public void open_browser(){
        driver.get("https://www.saucedemo.com/");
        wait= new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Test(priority = 0)
    public void login(){
        WebElement username = driver.findElement(By.name("user-name"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement button = driver.findElement(By.name("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        button.click();
    }

    @Test(priority = 1)
    public void clickOnProduct(){
        driver.findElement(By.className("inventory_item_img")).click();
    }

    @Test(priority = 2)
    public void verifyInfoOfProduct(){
        String title = driver.findElement(By.className("inventory_details_name")).getText();
        String description = driver.findElement(By.className("inventory_details_desc")).getText();
        String price = driver.findElement(By.className("inventory_details_price")).getText();

        assertEquals("Sauce Labs Backpack",title);
        assertEquals("carry.allTheThings() with the sleek, " +
                "streamlined Sly Pack that melds uncompromising style " +
                "with unequaled laptop and tablet protection.", description);
        assertEquals("$29.99",price);
    }

    @Test(priority = 3)
    public void clickOnAddToCart(){
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
    }

    @Test(priority = 4)
    public void clickOnBackToProducts(){
        driver.findElement(By.name("back-to-products")).click();
    }

    @Test(priority = 5)
    public void addFleeceJacketToCart(){
        driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket")).click();
    }

    @Test(priority = 6)
    public void openShoppingCartPage(){
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @Test(priority = 7)
    public void clickOnCheckout(){
        driver.findElement(By.name("checkout")).click();
    }

    @Test(priority = 8)
    public void fillInputFields(){
        WebElement firstName = driver.findElement(By.name("firstName"));
        WebElement lastName = driver.findElement(By.name("lastName"));
        WebElement postalCode = driver.findElement(By.name("postalCode"));

        firstName.sendKeys("Firstname");
        lastName.sendKeys("Lastname");
        postalCode.sendKeys("Zipcode");
    }

    @Test(priority = 9)
    public void clickContinueButton(){
        driver.findElement(By.name("continue")).click();
    }

    @Test(priority = 10)
    public void clickOnFinish(){
        driver.findElement(By.name("finish")).click();
    }

    @Test(priority = 11)
    public void checkPageResponse(){
        String title = driver.findElement(By.className("complete-header")).getText();
        assertEquals("THANK YOU FOR YOUR ORDER",title);
    }

    @Test(priority = 12)
    public void logout(){
        WebElement burgerMenu = driver.findElement(By.className("bm-burger-button"));
        burgerMenu.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        logoutButton.click();
    }
}
