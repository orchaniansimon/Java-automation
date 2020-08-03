
package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Initializations;

public class EmailSettings extends Utilities implements Initializations {
    private WebDriver driver;

    public EmailSettings(WebDriver driver) {
	this.driver = driver;
    }

    // Click on the email campaign button --> dynamic email campaign
    public boolean verifyUserEmailSettings() throws InterruptedException {

	// click social header link
	WebElement clickSocialHeaderLink = driver.findElement(socialHeaderLink);
	clickSocialHeaderLink.click();

	// Wait for css
	Thread.sleep(SLEEP_WAIT_2000);

	// get the user profile drop down
	WebElement getUserProfileDropDown = driver.findElement(profileDropDown);

	// click the workspace settings link
	getUserProfileDropDown.click();
	Thread.sleep(SLEEP_WAIT_4000);

	WebElement getWorkspaceSettingsLinkDropDown = driver.findElement(workspaceSettingsLinkDropDown);
	getWorkspaceSettingsLinkDropDown.click();

	Thread.sleep(SLEEP_WAIT_4000);

	WebElement getEmailSettingsLink = driver.findElement(emailSettingsLink);
	getEmailSettingsLink.click();
	Thread.sleep(SLEEP_WAIT_4000);

	// verify the email settings page
	String getEmailSettingsPageText = driver.getPageSource();
	String expectedPageText = "Mail Settings";
	String expectedEmailText = "Email Address";

	// return true if the page text matches
	if (getEmailSettingsPageText.contains(expectedPageText) && getEmailSettingsPageText.contains(".com")
		&& getEmailSettingsPageText.contains(expectedEmailText)) {
	    return true;
	}
	return false;
    }
}
