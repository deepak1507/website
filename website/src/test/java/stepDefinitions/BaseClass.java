package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.CustomerAddPage;
import pageObjects.CustomerSearchPage;
import pageObjects.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public CustomerAddPage addCust;
	public CustomerSearchPage srhCust;
	public static Logger logger;
	public Properties configProp;
	
	//This is to generate random string
	public static String randomstring() {
		String generatedStrg = RandomStringUtils.randomAlphabetic(5);
		return (generatedStrg);
		
	}
}
