
package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Initializations;

public class AdminAnalyzeMailContent implements Initializations {
    private WebDriver driver;

    public AdminAnalyzeMailContent(WebDriver driver) {
	this.driver = driver;
    }

    // Goto administration --> suggested posts
    public Boolean verifyAdminAnalyzeMailContent() throws InterruptedException {

	// Get all elements in the menu for Create
	WebElement getClickAnalyzeDropDown = driver.findElement(clickAnalyzeDropDown);
	getClickAnalyzeDropDown.click();
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement getClickAnalyzeMailContentLink = driver.findElement(clickAnalyzeMailContentLink);
	getClickAnalyzeMailContentLink.click();
	Thread.sleep(SLEEP_WAIT_2000);

	String getMailOverviewPageSource = driver.getPageSource();
	String expectedText = "Mail Content";

	// Convert list in array by calling toArray() method and match against what
	// should be there
	if (getMailOverviewPageSource.contains(expectedText)) {
	    return true;
	}
	return false;
    }



    }


