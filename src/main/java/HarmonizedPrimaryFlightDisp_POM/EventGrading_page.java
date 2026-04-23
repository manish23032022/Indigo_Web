package HarmonizedPrimaryFlightDisp_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.WebDriverUtility;

public class EventGrading_page {
	
	 private WebDriver driver;
	    private WebDriverUtility webUtil;

	    public EventGrading_page(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        this.webUtil = new WebDriverUtility();
	    }

	    @FindBy(xpath = "//input[@id='RegNo']")
	    private WebElement registrationInputField;

	    @FindBy(xpath = "//select[@id='SEATOCCUPIED']")
	    private WebElement aircraftTypeDrop;

	    @FindBy(xpath = "//select[@id='LOCATION']")
	    private WebElement simulatorLoactionDrop;
	    

	    @FindBy(xpath = "//button[contains(text(),'Save')]")
	    private WebElement saveAndNextBtn;

	    /** Search and click HPFD Grade Button  */
	    public void enterRegAndselectAircraftType(String regNum) {
	        webUtil.safeType(driver, registrationInputField, regNum);
	        webUtil.selectByIndex(aircraftTypeDrop, 1);
	        webUtil.selectByIndex(simulatorLoactionDrop, 2);
	        
	    }
	    
	    public void clickSaveAndNextBtn() {
	        webUtil.safeClick(driver, saveAndNextBtn);
	       
	    }

}
