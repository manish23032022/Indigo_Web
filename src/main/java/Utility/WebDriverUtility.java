package Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

/**
 * WebDriverUtility - Central utility class for common Selenium WebDriver actions
 * Author: Manish
 */
public class WebDriverUtility {

    private static final int DEFAULT_TIMEOUT = 20;

    /** Implicit wait for page load */
    public void waitForPageToLoad(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    /** Explicit wait for element visibility */
    public WebElement waitForElementVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /** Explicit wait for element to be clickable — returns WebElement */
    public WebElement waitForElementClickable(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /** Explicit wait for WebElement to be clickable — returns WebElement */
    public WebElement waitForElementClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

   
      

    public void safeClick(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }


    /** Sleep utility */
    public void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /** Safe type into element */
    public void safeType(WebDriver driver, WebElement element, String value) {
        waitForElementVisible(driver, element);
        element.clear();
        element.sendKeys(value);
    }

   

    /** Wait and type into element */
    public void waitAndType(WebDriver driver, WebElement element, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
        visibleElement.clear();
        visibleElement.sendKeys(value);
    }

    /** Select dropdown by visible text */
    public void selectByVisibleText(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }

    /** Select dropdown by value */
    public void selectByValue(WebElement element, String value) {
        new Select(element).selectByValue(value);
    }

    /** Select dropdown by index */
    public void selectByIndex(WebElement element, int index) {
        new Select(element).selectByIndex(index);
    }
    
    public void selectMultiDropdown(WebDriver driver,WebElement dropdownBtn,String optionXpath,String... values) {
           waitForElementClickable(driver, dropdownBtn).click();

           for (String value : values) {

        	   String dynamicXpath = String.format(optionXpath, value);

        	   WebElement option = new WebDriverWait(driver, Duration.ofSeconds(10))
        			   .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXpath)));

        	   if (!option.getAttribute("class").contains("selected")) {
        		   				option.click();
        		   				System.out.println("Selected → " + value);
        	   }
           }

           dropdownBtn.click();
    }
    
    
    public void scrollToCenter(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block: 'center'});", element
        );
    }
    

    /** Select dynamic value safely */
    public boolean selectDynamicValue(WebElement element, String text) {
        Select sel = new Select(element);
        List<WebElement> options = sel.getOptions();
        for (WebElement opt : options) {
            if (opt.getText().trim().equalsIgnoreCase(text.trim())) {
                sel.selectByVisibleText(opt.getText());
                return true;
            }
        }
        return false;
    }

    /** Switch to frame by index */
    public void switchToFrame(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }

    /** Switch to frame by name or ID */
    public void switchToFrame(WebDriver driver, String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    /** Switch to frame by WebElement */
    public void switchToFrame(WebDriver driver, WebElement element) {
        driver.switchTo().frame(element);
    }

    /** Accept alert */
    public void acceptAlert(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.alertIsPresent()).accept();
    }

    /** Dismiss alert */
    public void dismissAlert(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    /** Switch to window by partial URL */
    public void switchToWindowByURL(WebDriver driver, String partialURL) {
        Set<String> windows = driver.getWindowHandles();
        for (String win : windows) {
            driver.switchTo().window(win);
            if (driver.getCurrentUrl().contains(partialURL)) {
                break;
            }
        }
    }

    /** Switch to window by partial title */
    public void switchToWindowByTitle(WebDriver driver, String partialTitle) {
        Set<String> windows = driver.getWindowHandles();
        for (String win : windows) {
            driver.switchTo().window(win);
            if (driver.getTitle().contains(partialTitle)) {
                break;
            }
        }
    }

    /** Mouse hover */
    public void mouseHover(WebDriver driver, WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    /** Mouse hover with offset */
    public void mouseHover(WebDriver driver, WebElement element, int xOffset, int yOffset) {
        new Actions(driver).moveToElement(element, xOffset, yOffset).perform();
    }

    /** Double click */
    public void doubleClick(WebDriver driver, WebElement element) {
        new Actions(driver).doubleClick(element).perform();
    }

    /** Right click */
    public void rightClick(WebDriver driver, WebElement element) {
        new Actions(driver).contextClick(element).perform();
    }

    /** Drag and drop */
    public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        new Actions(driver).dragAndDrop(source, target).perform();
    }

    /** Drag and drop by offset */
    public void dragAndDropByOffset(WebDriver driver, WebElement source, int xOffset, int yOffset) {
        new Actions(driver).dragAndDropBy(source, xOffset, yOffset).perform();
    }

    /** Scroll into view */
    public void scrollDownToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }
    
    public void scrollUpToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /** Click using JavaScript */
    public void jsClickAndScrollDown(WebDriver driver, WebElement element) {
        scrollDownToElement(driver, element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    
    /** Click using JavaScript */
    public void jsClickAndScrollUp(WebDriver driver, WebElement element) {
        scrollUpToElement(driver, element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    /** Take screenshot */
    public void takeScreenshot(WebDriver driver, String testName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("./screenshots/" + testName + ".png"));
    }
}
