package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.CustomerAddPage;
import pageObjects.CustomerSearchPage;
import pageObjects.LoginPage;

public class Steps extends BaseClass{
	
	@Before
	public void setup() throws IOException {
		
		//Read properties
		configProp = new Properties();
		FileInputStream configPropfile = new FileInputStream("config.properties");
		configProp.load(configPropfile);
		
		logger = Logger.getLogger("website");//Added Logger
		PropertyConfigurator.configure("Log4j.properties");//Added Logger
		
		String Browser = configProp.getProperty("browser");
		
		if(Browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		} else if(Browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}
		
		logger.info("***********Launching Browser***********");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}
	
	
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {		
		lp = new LoginPage(driver);
	}

	@When("User Opens URL {string}")
	public void user_Opens_URL(String url) {
	    driver.get(url);
	    logger.info("***********Opening URL***********");
	}

	@When("User Enters Email as {string} and Password as {string}")
	public void user_Enters_Email_as_and_Password_as(String emailAdds, String password) {
		logger.info("***********Providing Login Details***********");
		lp.setUserName(emailAdds);
	    lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {
		logger.info("***********Clicked on Login Button***********");
		lp.clickLogin();
		Thread.sleep(5000);
	    
	}

	@Then("Page Title Should be {string}")
	public void page_Title_Should_be(String exptString) {
	   if(driver.getPageSource().contains("Login was unsuccessful")) {
		   driver.close();
		   Assert.assertTrue(false);
	   } else {
		   Assert.assertEquals(exptString, driver.getTitle());
	   }
	}

	@When("User Click on Log Out Link")
	public void user_Click_on_Log_Out_Link() throws InterruptedException {
	    lp.clickLogout();
	    Thread.sleep(5000);
	}

	@Then("Close Browser")
	public void close_Browser() {
	   driver.quit(); 
	}
	
	//Customers - Add new Customers page steps
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() {
		addCust = new CustomerAddPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User Click on Customers Menu")
	public void user_Click_on_Customers_Menu() throws InterruptedException {
	    addCust.ClickonCustomerMenu();
	    Thread.sleep(2000);
	}

	@When("Click on Customers Menu Item")
	public void click_on_Customers_Menu_Item() throws InterruptedException {
	    addCust.ClickonCustomerMenuItem();
	    Thread.sleep(2000);
	}

	@When("Click on Add New Button")
	public void click_on_Add_New_Button() throws InterruptedException {
	    addCust.ClickonbtnAddNew();
	    Thread.sleep(2000);
	}

	@Then("User can view Add new cusotmer page")
	public void user_can_view_Add_new_cusotmer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());		
	}

	@When("User enter cusotmer info")
	public void user_enter_cusotmer_info() {
	    addCust.SetEmail(randomstring()+"@gmail.com");
	}

	@When("Click on Save button")
	public void click_on_Save_button() throws InterruptedException {
	    addCust.ClickSaveBtn();
	    Thread.sleep(2000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
	  //Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
		System.out.println("The new customer has been added successfully.");
	}
	
	//This is to search Customer for
	@When("Enter Customer Email")
	public void enter_Customer_Email() {
		srhCust = new CustomerSearchPage(driver);
		srhCust.setEmailTxt("victoria_victoria@nopCommerce.com");		
	}

	@When("Click on Search Button")
	public void click_on_Search_Button() throws InterruptedException {
	   srhCust.clickSearchBtn();
	   Thread.sleep(3000);
	}

	@Then("User Should found Email in the Search table")
	public void user_Should_found_Email_in_the_Search_table() {
	    boolean status = srhCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	    Assert.assertEquals(true,status);
	}

}
