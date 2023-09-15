package StepDefinition;

import io.cucumber.java.cy_gb.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.security.Key;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BestBuySearchPage {
    WebDriver driver=new ChromeDriver();
//to perform Scroll on application using Selenium


    private static By searchInput= By.xpath("//*[@id='gh-search-input']");
    private static By iphone13ProMax=By.xpath("//a[text()='Apple - Pre-Owned iPhone 13 Pro 5G 128GB (Unlocked) - Graphite']");

    private static By iphone13Model=By.xpath("//span[text()='A2483-GRY']");
    private static By iphone13Price=By.xpath("//span[text()='$879.99']");
    private static By addToCart=By.xpath("//button[@class='c-button c-button-primary c-button-lg c-button-block c-button-icon c-button-icon-leading add-to-cart-button']");
    private static By goToCart=By.xpath("//a[(text()='Go to Cart')]");
    private static By orderSummary=By.xpath("//*[@id='cartApp']/div[2]/div/div[1]/div/div[1]/div[1]/section[2]/div/div");

    @Given("Best-buy URL loads successfully")
    public void bestbuy_url_loads_successfully() {
          driver.navigate().to("https://www.bestbuy.com/");
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Waits until the page loads
        JavascriptExecutor js = (JavascriptExecutor) driver;
    }

    @When("User enters {string} on search bar and click the search icon.")
    public void user_enters_on_search_bar_and_click_the_search_icon(String string) {
        driver.findElement(searchInput).sendKeys(string);

        driver.findElement(searchInput).sendKeys(Keys.RETURN);
    }


    @Then("Searched product description {string} model {string} price {string} should be validated")
    public void searched_product_description_model_price_should_be_validated(String descriptionExpected, String modelExpected, String priceExpected) {
//Assert all details are being displayed
        Assertions.assertTrue(driver.findElement(iphone13ProMax).isDisplayed());
        Assertions.assertTrue(driver.findElement(iphone13Model).isDisplayed());
        Assertions.assertTrue(driver.findElement(iphone13Price).isDisplayed());

    }
    @When("Add to the cart the specific Iphone mode {string}")
    public void add_to_the_cart_the_specific_iphone_mode(String specificPhone) {
          By specifiedPhone=By.xpath("//a[text()='"+specificPhone+"']");
        driver.findElement(specifiedPhone).click();
        //scroll closer to the element
        WebElement scrollToAddToCart=driver.findElement(By.xpath("//strong[text()='Get it tomorrow']"));
        Actions actions=new Actions(driver);

        actions.scrollToElement(scrollToAddToCart).perform();

        //Then click on it
        driver.findElement(addToCart).click();
    }

    @When("Click on go to the cart")
    public void click_on_go_to_the_cart() {
        driver.findElement(goToCart).click();
    }

    @Then("Verify {string} and {string} displayed")
    public void verify_and_displayed(String orderSumm, String checkout) {
        //Assert order summery and checkout appears on checkout page
        Assertions.assertTrue((driver.findElement(orderSummary).getText().contains(orderSumm)) && (driver.findElement(orderSummary).getText().contains(checkout)));
    }


}
