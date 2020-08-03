package PageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Initializations;

public class EmailPreviewCheckVariables implements Initializations {
    private WebDriver driver;

    public EmailPreviewCheckVariables(WebDriver driver) {
	this.driver = driver;
    }

    // Goto administration --> suggested posts
    public boolean composeEmailCheckVariables() throws InterruptedException {

	WebElement clickSocialHeaderLink = driver.findElement(mailHeaderLink);
	clickSocialHeaderLink.click();
	Thread.sleep(SLEEP_WAIT_2000);

	// Click load more button to get complete count of contacts
	WebElement getComposeEmailButton = driver.findElement(composeEmailButton);
	getComposeEmailButton.click();
	Thread.sleep(SLEEP_WAIT_4000);
	WebElement clickWriteOwnEmailPanel = driver.findElement(writeExistingEmailPanel);
	clickWriteOwnEmailPanel.click();

	// Enter a contact in the new email popover
	WebElement recipientField = driver.findElement(By.cssSelector(".recipients-search > form input"));

	// enter contact name into form field
	recipientField.sendKeys(emailContactName);

	// tab to select contact
	recipientField.sendKeys(Keys.TAB);
	Thread.sleep(SLEEP_WAIT_2000);

	// get the element for the selected contact
	WebElement getContact = driver.findElement(selectContact);

	// enter to choose the contact
	getContact.sendKeys("\n");

	WebElement getContactName = driver.findElement(contactEmailRecipientName);
	String contactName = getContactName.getText();

	// Split the string to get the first name
	String[] fullName = contactName.split("\\s+");

	WebElement getContactEmail = driver.findElement(contactEmailRecipientEmail);
	String contactEmail = getContactEmail.getText();
	System.out.println("Contact email = " + contactEmail);

	// get the contacts email
	WebElement getComposeOwnEmailSubjectField = driver.findElement(composeOwnEmailSubjectField);
	getComposeOwnEmailSubjectField.sendKeys("Automation");
	Thread.sleep(SLEEP_WAIT_2000);

	// click on the preview email button
	WebElement getPreviewEmailButton = driver.findElement(By.cssSelector(".right-buttons > button:nth-child(1)"));
	getPreviewEmailButton.click();
	Thread.sleep(SLEEP_WAIT_2000);

	// get the text of the variables
	WebElement getVariables = driver.findElement(By.cssSelector("td > p:nth-child(1)"));
	String variablesText = getVariables.getText();
	System.out.println("Variables text = " + variablesText);

	// verify that the variables match the contact name & email
	if (variablesText.contains(fullName[0]) && variablesText.contains(fullName[1])
		&& variablesText.contains(contactEmail)) {
	    return true;
	}
	return false;

    }

}

