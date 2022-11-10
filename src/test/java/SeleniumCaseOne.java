import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumCaseOne{
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait;



    @BeforeTest
    public void open_browser(){
        driver.get("https://www.saucedemo.com/");
        wait= new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement username = driver.findElement(By.name("user-name"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement button = driver.findElement(By.name("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        button.click();
    }

    @AfterTest
    public void close(){
        wait= new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement burgerMenu = driver.findElement(By.className("bm-burger-button"));
        burgerMenu.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        logoutButton.click();
        driver.quit();
    }

    @Test(priority = 1)
    public void headerExists(){
        WebElement title = driver.findElement(By.className("header_secondary_container"));
        Assert.assertTrue(title.isDisplayed());
    }

    @Test(priority = 2)
    public void shoppingCartExists(){
        boolean shoppingCart = driver.findElement(By.className("shopping_cart_link")).isDisplayed();
    }

    @Test (priority = 3)
    public void burgerMenuExists(){
        WebElement burgerMenu = driver.findElement(By.className("bm-burger-button"));
        String cssValueLeftMargin = burgerMenu.getCssValue("left");
        String cssValueTopMargin = burgerMenu.getCssValue("top");
        assertEquals("15px", cssValueLeftMargin);
        assertEquals("20px", cssValueTopMargin);
    }

    @Test (priority = 4)
    public void linksExist(){
        WebElement twitterLink = driver.findElement(By.xpath("//a[@href='https://twitter.com/saucelabs']"));
        WebElement facebookLink = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/saucelabs']"));
        WebElement linkedinLink = driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/sauce-labs/']"));
        Assert.assertTrue(twitterLink.isDisplayed());
        Assert.assertTrue(facebookLink.isDisplayed());
        Assert.assertTrue(linkedinLink.isDisplayed());
    }


}
