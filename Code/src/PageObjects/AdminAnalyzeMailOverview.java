
package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Initializations;

public class AdminAnalyzeMailOverview implements Initializations {
    private WebDriver driver;

    public AdminAnalyzeMailOverview(WebDriver driver) {
	this.driver = driver;
    }

    // Goto administration --> suggested posts
    public Boolean verifyAdminAnalyzeMailOverview() throws InterruptedException {

	// Get all elements in the menu for Create
	WebElement getClickAnalyzeDropDown = driver.findElement(clickAnalyzeDropDown);
	getClickAnalyzeDropDown.click();
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement getClickAnalyzeMailOverviewLink = driver.findElement(clickAnalyzeMailOverviewLink);
	getClickAnalyzeMailOverviewLink.click();
	Thread.sleep(SLEEP_WAIT_2000);

	String getMailOverviewPageSource = driver.getPageSource();
	String expectedTextSent = "Emails Sent";
	String expectedTextOpened = "Opened";
	String expectedTextClicked = "Clicked";
	String expectedTextWorkspace = "Workspace";

	// Convert list in array by calling toArray() method and match against what
	// should be there
	if (getMailOverviewPageSource.contains(expectedTextWorkspace)
		&& getMailOverviewPageSource.contains(expectedTextSent)
		&& getMailOverviewPageSource.contains(expectedTextClicked)
		&& getMailOverviewPageSource.contains(expectedTextOpened)) {
	    return true;

	}
	return false;

    }

    }

