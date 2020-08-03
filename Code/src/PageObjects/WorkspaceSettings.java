
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Initializations;

public class WorkspaceSettings extends Utilities implements Initializations {
    private WebDriver driver;

    private By workspaceSettingsLinkDropDown = By.cssSelector(".open > ul > li:nth-child(3) > ul > li:nth-child(2) > a");

    public WorkspaceSettings(WebDriver driver) {
	this.driver = driver;
    }

    // Click on the email campaign button --> dynamic email campaign
    public boolean verifyUserWorkspaceSettings() throws InterruptedException {

	// click social header link
	WebElement clickSocialHeaderLink = driver.findElement(socialHeaderLink);
	clickSocialHeaderLink.click();
	Thread.sleep(SLEEP_WAIT_4000);

	// get the user profile drop down
	WebElement getUserProfileDropDown = driver.findElement(profileDropDown);

	// click the workspace settings link
	getUserProfileDropDown.click();
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement getWorkspaceSettingsLinkDropDown = driver.findElement(workspaceSettingsLinkDropDown);
	getWorkspaceSettingsLinkDropDown.click();

	Thread.sleep(SLEEP_WAIT_2000);

	// verify the workspace settings page
	String getWorkspaceSettingsPageText = driver.getPageSource();
	String expectedPageText = "Workspace Settings";

	// return true if the page text matches
	if (getWorkspaceSettingsPageText.contains(expectedPageText)) {
	    return true;
	}
	return false;

    }

}
