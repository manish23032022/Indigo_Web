package CA40_41_POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.WebDriverUtility;

public class CA40_41_EventGrading_page {
	
	 private WebDriver driver;
	    private WebDriverUtility webUtil;

	    public CA40_41_EventGrading_page(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        this.webUtil = new WebDriverUtility();
	    }
	    


	    @FindBy(xpath = "//input[@id='RegNo']")
	    private WebElement registrationInputField;
	    

	    @FindBy(xpath = "//select[@id='LOCATION']")
	    private WebElement locationDrop;
	    

	    @FindBy(xpath = "//select[@id='type']")
	    private WebElement airoplaneDrop;
	   
	    
	    
	    
	    @FindBy(id = "schDate")
	    private WebElement scheduleDateField;

	    @FindBy(id = "SIMULATORLEVEL")
	    private WebElement simulatorDropdown;

	    @FindBy(id = "SEATOCCUPIED")
	    private WebElement seatDropdown;

	    @FindBy(xpath = "//button[@data-id='TYPEOFTEST']")
	    private WebElement typeOfCheckDropdown;
	    
	    private String optionXpath = "//span[normalize-space()='%s']";

	   

	    @FindBy(id = "ONOFFTIME")
	    private WebElement takeOffTime;

	    @FindBy(id = "OFFLANDINGTIME")
	    private WebElement landingTime;

	    @FindBy(id = "time")
	    private WebElement durationField;

	    @FindBy(id = "crewstatus")
	    private WebElement crewStatusDropdown;

	    @FindBy(xpath = "//h2[contains(text(),'DAY/NIGHT: ')]/parent::div/following-sibling::div//label[@for='DAY']")
	    private WebElement Day;
	    

	    @FindBy(xpath = "//button[@id='eventGrading' and contains(.,'Next')]")
	    private WebElement saveAndNextBtn;

	    /** Search and click HPFD Grade Button  
	     * @throws InterruptedException */
	    public void enterGradingDetailsInGeneralInfo(String regNum,String... values) throws InterruptedException {
	    	
	       
	        webUtil.safeType(driver, registrationInputField, regNum);
	        webUtil.selectByIndex(airoplaneDrop, 0);
	        webUtil.selectByIndex(locationDrop, 1);
	        webUtil.selectByIndex(simulatorDropdown, 1);
	        webUtil.selectByValue(seatDropdown, "LHS");
	        webUtil.selectMultiDropdown(driver, typeOfCheckDropdown, optionXpath, values);
	        webUtil.selectByIndex(crewStatusDropdown, 2);
	        webUtil.safeClick(driver, Day);
	        webUtil.safeClick(driver, saveAndNextBtn);
	        Thread.sleep(3000);
	        
	        
	    }
	    

	    @FindBy(xpath = "//div[@id='accordion']/div[@class='panel panel-default']")
	    private List<WebElement> allPlusBtn;
	    public void enterGradeUnderTaskGrade() throws InterruptedException {
	    	
		       for(WebElement eachPlus : allPlusBtn) {
		    	// Find the specific trigger button within this panel
		           WebElement singlePlusBtn = eachPlus.findElement(By.xpath(".//a[@data-toggle='collapse']"));
		    	   webUtil.jsClickAndScrollDown(driver, singlePlusBtn);
		    	   webUtil.sleep(1000);
		    	   List<WebElement> yesButtonsOfCurrentPanel =
		                   eachPlus.findElements(By.xpath(".//label[contains(normalize-space(),'YES')]"));

		           for (WebElement singleYesBtn : yesButtonsOfCurrentPanel) {
		               webUtil.jsClickAndScrollUp(driver, singleYesBtn);
		               webUtil.sleep(500);
		           }
		       }
		       webUtil.safeClick(driver, saveAndNextBtn);
	        
	        
	        
	    }
	    

}
