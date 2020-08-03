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

public class ContactsSocialComposeWriteYourOwnEmail implements Initializations {
    private WebDriver driver;

    public ContactsSocialComposeWriteYourOwnEmail(WebDriver driver) {
	this.driver = driver;
    }

    // Goto administration --> suggested posts
    public boolean composeEmail() throws InterruptedException {

	WebElement clickSocialHeaderLink = driver.findElement(socialHeaderLink);
	clickSocialHeaderLink.click();
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement getSocialContactsLink = driver.findElement(socialContactsLink);

	// Need to click the content link
	getSocialContactsLink.click();
	Thread.sleep(SLEEP_WAIT_4000);

	// Click load more button to get complete count of contacts
	WebElement getComposeEmailButton = driver.findElement(socialComposeEmailButton);
	getComposeEmailButton.click();
	Thread.sleep(SLEEP_WAIT_4000);

	WebElement clickWriteOwnEmailPanel = driver.findElement(writeOwnEmailPanel);
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

	WebElement getComposeOwnEmailSubjectField = driver.findElement(composeOwnEmailSubjectField);
	getComposeOwnEmailSubjectField.sendKeys("Automation");

	WebElement getFontSizeIcon = driver.findElement(fontSizeIcon);
	WebElement getRTELinkIcon = driver.findElement(RTELinkIcon);

	Assert.assertTrue(getFontSizeIcon.isDisplayed());
	Assert.assertTrue(getRTELinkIcon.isDisplayed());

	WebElement getSendButton = driver.findElement(clickSendButton);
	getSendButton.click();
	Thread.sleep(SLEEP_WAIT_2000);

	return true;
    }

}
