
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utilities.Initializations;

public class AdminComposeProhibitedEmailAndVerify extends Utilities implements Initializations {

    private WebDriver driver;

    public AdminComposeProhibitedEmailAndVerify(WebDriver driver) {
	this.driver = driver;
    }

    // Verify Administration New Email form
    public boolean verifyNewEmailForm() throws InterruptedException {

	Thread.sleep(SLEEP_WAIT_2000);

	WebElement getNewEmailButton = driver.findElement(newEmailButton);

	if (getNewEmailButton.isDisplayed()) {
	    getNewEmailButton.click();
	    Thread.sleep(SLEEP_WAIT_2000);
	    return true;
	}
	return false;

    }

    // Fill out the new email form subject and notes sections with overflow text
    public Boolean composeProhibitedEmailOnAdmin() throws InterruptedException {

	WebElement composeEmailSubject = driver.findElement(By.cssSelector(".subject-bar .form-control"));
	composeEmailSubject.sendKeys("Hearsay Systems Testing - Prohibited Email");

	WebElement editLinkButton = driver.findElement(clickEditLinkButton);
	editLinkButton.click();

	WebElement fillLinkText = driver.findElement(linkText);
	fillLinkText.sendKeys(" Prohibited ");

	WebElement fillWebAddressText = driver.findElement(webAddress);
	fillWebAddressText.sendKeys(" http://www.prohibited.com ");

	WebElement clickInsertLink = driver.findElement(insertLink);
	clickInsertLink.click();

	// Select a specific tag from the selector
	Select modificationRuleDropdown = new Select(driver.findElement(By.name("modification_rule")));
	modificationRuleDropdown.selectByVisibleText("Prohibited");

	WebElement composeEmailSuggest = driver.findElement(composeEmailSuggestButton);
	Thread.sleep(SLEEP_WAIT_2000);
	// Click on the Suggest button to submit the form
	composeEmailSuggest.click();
	Thread.sleep(SLEEP_WAIT_2000);

	return true;
    }

    // Click to goto the user mail page and verify the notes form field
    public Boolean verifyProhibitedEmailOnUser() throws InterruptedException {

	// Click on the mail link to verify user suggested post
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement clickOnMailLink = driver.findElement(mailHeaderLink);
	clickOnMailLink.click();
	Thread.sleep(SLEEP_WAIT_4000);

	WebElement clickComposeEmailButton = driver.findElement(composeEmailButton);
	clickComposeEmailButton.click();

	Thread.sleep(SLEEP_WAIT_4000);
	// waitForLinkText("Prohibited");
	WebElement clickOnEmailTile = driver.findElement(By.linkText("Prohibited"));
	clickOnEmailTile.click();

	Thread.sleep(SLEEP_WAIT_2000);

	// Enter a contact in the new email popover
	WebElement recipientField = driver.findElement(By.cssSelector(".recipients-search > form input"));

	// enter contact name into form field
	recipientField.sendKeys(emailContactName);

	// tab to select contact
	recipientField.sendKeys(Keys.TAB);
	Thread.sleep(SLEEP_WAIT_2000);

	// get the element for the selected contact
	WebElement getContact = driver.findElement(selectContact);
	getContact.sendKeys("\n");

	WebElement getSubjectField = driver.findElement(getSubject);
	getSubjectField.click();

	// Get the web link
	WebElement clickWebLink = driver.findElement(getWebLink);
	clickWebLink.click();
	String getPageText = driver.getPageSource();

	// Verify if the popup contains certain text - if so, then return false
	if (getPageText.contains("Go To Link:") || getPageText.contains("Edit")) {
	    return false;
	}
	return true;
    }
}
