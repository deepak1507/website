package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

public class CustomerSearchPage {
	
	public WebDriver ldriver;
	WaitHelper waitObj;
	
	public CustomerSearchPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		waitObj = new WaitHelper(ldriver);		
	}
	
	@FindBy(how = How.ID, using = "SearchEmail")
	@CacheLookup
	WebElement txtSrEmail;
	
	@FindBy(how = How.ID, using = "search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(xpath="//table[@id='customers-grid']")
	@CacheLookup
	WebElement resTable;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> resTableRow;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> resTableCol;
	
	//Action Methods for Search customer page
	public void setEmailTxt(String email) {
		//waitObj.WiatForElement(txtSrEmail, 30);
		txtSrEmail.clear();
		txtSrEmail.sendKeys(email);
	}
	
	public void clickSearchBtn() {
		btnSearch.click();
	}
	
	public int getNoOfRows() {
		return (resTableRow.size());		
	}
	
	public int getNoOfColumns() {
		return (resTableCol.size());		
	}
	
	public boolean searchCustomerByEmail(String email) {
		boolean flag = false;
		
		for(int i=1;i<=getNoOfRows();i++) {
			String emailId = resTable.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailId);
			if(emailId.equalsIgnoreCase(email)) {
				flag = true;
			}
		}
		
		return flag;
		
	}
}
