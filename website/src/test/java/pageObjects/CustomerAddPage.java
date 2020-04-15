package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CustomerAddPage {
	
	public WebDriver ldriver;
	
	public CustomerAddPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver,this);
	}
	
	//Object identification properties of Add New Customer Page
	By lnkCustomers_Menu = By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
	By linkCustomers_MenuItem = By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]");
	By btnAddNew = By.xpath("//a[@class='btn bg-blue']");
	By txtEmail = By.xpath("//input[@id='Email']");
	By btnSavCont = By.xpath("//button[@name='save']");	
	
	
	//This is to get the page title
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	//Actions Methods for Above - This is to add new customer
	public void ClickonCustomerMenu() {
		ldriver.findElement(lnkCustomers_Menu).click();
	}
	
	public void ClickonCustomerMenuItem() {
		ldriver.findElement(linkCustomers_MenuItem).click();
	}
	
	public void ClickonbtnAddNew() {
		ldriver.findElement(btnAddNew).click();
	}
	
	public void SetEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void ClickSaveBtn() {
		ldriver.findElement(btnSavCont).click();
	}
 
}
