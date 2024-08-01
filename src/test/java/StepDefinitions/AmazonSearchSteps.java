package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AmazonSearchSteps{
	
	WebDriver driver = null;
	boolean result ;
	
	@Given("User launches the Amazon Portal {string}")
	public void user_launches_the_amazon_portal(String url) {
		String projectpath =System.getProperty("user.dir");
	    System.setProperty("webdriver.chrome.driver",projectpath+"/src/test/resources/drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get(url);
	}

	@Given("User clicks on search tab and enters {string}")
	public void user_clicks_on_search_tab_and_enters(String item) {
	    driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(item);
	}

	@When("clicks on Search Icon")
	public void clicks_on_search_icon() {
	    driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	}

	@Then("validate Iphone is displayed")
	public void validate_iphone_is_displayed() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[contains(text(),'Apple iPhone')])[1]"))));
			result =true;
		}
		catch (Exception e) {
			result= false;
		}
	    Assert.assertTrue("Iphone Product not visible",result);
	}
	
	@Then("closes the browser")
	public void closes_the_browser() {
	    driver.close();
	}
}