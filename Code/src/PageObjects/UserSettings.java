
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Initializations;

public class UserSettings implements Initializations {
    private WebDriver driver;

    public UserSettings(WebDriver driver) {
	this.driver = driver;
    }

    // Click on the email campaign button --> dynamic email campaign
    public boolean verifyUserSettings() throws InterruptedException {

	// click social header link
	WebElement clickSocialHeaderLink = driver.findElement(socialHeaderLink);
	clickSocialHeaderLink.click();
	Thread.sleep(SLEEP_WAIT_2000);

	WebDriverWait waitForContainer = new WebDriverWait(driver, 5000);

	// Wait for the page to be visible
	waitForContainer.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#recommended-action-container")));

	// get the user profile drop down
	WebElement getUserProfileDropDown = driver.findElement(profileDropDown);

	// click the workspace settings link
	getUserProfileDropDown.click();
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement getUserSettingsLinkDropDown = driver.findElement(userSettingsLinkDropDown);
	getUserSettingsLinkDropDown.click();

	Thread.sleep(SLEEP_WAIT_2000);

	// verify the workspace settings page
	String getUserSettingsPageText = driver.getPageSource();
	String expectedPageText = "User Settings";

	// return true if the page text matches
	if (getUserSettingsPageText.contains(expectedPageText)) {
	    return true;
	}
	return false;

    }
}