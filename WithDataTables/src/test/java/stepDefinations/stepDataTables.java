package stepDefinations;









import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.messages.Messages.GherkinDocument.Feature.Step.DataTable;

public class stepDataTables {
	
WebDriver driver;
	
	
	
	@Given("^User is on Home Page$")
	public void open_firefox_and_start_application() {
	    
		
	//	driver=new FirefoxDriver();
	    
      System.setProperty("webdriver.chrome.driver", "C:\\Project Work\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://facebook.com");
		System.out.println(" i am in GIVE tag ");
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("^User Navigate to LogIn Page$")
	 public void user_Navigate_to_LogIn_Page() throws Throwable {
	 //driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		
		System.out.println(" i am on facebook page and start to login my account");
	 }
	
//	@When("^I enter valid username and valid password$")
//	public void i_enter_valid_and_valid(String string, String string2) {
//	    // Write code here that turns the phrase above into concrete actions
//		System.out.println(" i am in when tag ");
//		driver.findElement(By.id("email")).sendKeys("schander.786@gmail.com");
//		driver.findElement(By.id("pass")).sendKeys("facebook@0786");
//	    throw new io.cucumber.java.PendingException();
	//	}

	@When("^User enters Credentials to LogIn$")
	 public void user_enters_testuser__and_Test(DataTable usercredentials) throws Throwable {
		
		System.out.println(" i am now login to the page......... ");
		
		List<List<String>> data = usercredentials.asLists();
		 driver.findElement(By.id("email")).sendKeys(data.get(0).get(0)); 
		     driver.findElement(By.id("pass")).sendKeys(data.get(0).get(1));
		     driver.findElement(By.id("loginbutton")).click();
			
		
	}
	
	@Then("^Message displayed Login Successfully$")
	public void user_should_able_to_login_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(" i am in Then tag ");
		driver.findElement(By.id("loginbutton")).click();
	    throw new io.cucumber.java.PendingException();
	}

	@When("^User LogOut from the Application$")
	 public void user_LogOut_from_the_Application() throws Throwable {
	 driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
	 }
	 
	 @Then("^Message displayed LogOut Successfully$")
	 public void message_displayed_LogOut_Successfully() throws Throwable {
	 System.out.println("LogOut Successfully");
	 }


}
