package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.Initializations;

public class ComposeSearchSendEmail extends Utilities implements Initializations {
    private WebDriver driver;

    public ComposeSearchSendEmail(WebDriver driver) {
	this.driver = driver;
    }

    // Goto Email library page
    public Boolean verifyComposeSearchSendEmail() throws InterruptedException {

	Thread.sleep(SLEEP_WAIT_4000);
	WebElement getMailLink = driver.findElement(mailHeaderLink);
	getMailLink.click();

	Thread.sleep(SLEEP_WAIT_2000);

	WebElement clickComposeEmailButton = driver.findElement(composeEmailButton);
	clickComposeEmailButton.click();
	Thread.sleep(SLEEP_WAIT_2000);

	// waitForLinkText("Google");
	
	//Search for an email and click to enter details
	WebElement mailLibrarySearchFilter = driver.findElement(emailLibrarySearchFilter);
	Assert.assertTrue(mailLibrarySearchFilter.isDisplayed());
	
	//Search for an existing email and click it 
	mailLibrarySearchFilter.sendKeys("Hearsay");
	Thread.sleep(SLEEP_WAIT_4000);
	WebElement getExistingEmail = driver.findElement(composeExistingEmailMailPage);
	getExistingEmail.click();
	Thread.sleep(SLEEP_WAIT_2000);
	
	//Fill out the contact
	WebElement recipientField = driver.findElement(By.cssSelector("recipients-search > form input"));
	recipientField.sendKeys(emailContactName);
	recipientField.sendKeys(Keys.TAB);
	
	Thread.sleep(SLEEP_WAIT_2000);

	// get the element for the selected contact
	WebElement getContact = driver.findElement(selectContact);

	// enter to choose the contact
	getContact.sendKeys("\n");

	WebElement getComposeOwnEmailSubjectField = driver.findElement(composeOwnEmailSubjectField);
	getComposeOwnEmailSubjectField.sendKeys("Automation");

	//Verify the font size and rte link
	WebElement getFontSizeIcon = driver.findElement(fontSizeIcon);
	WebElement getRTELinkIcon = driver.findElement(RTELinkIcon);
	
	Assert.assertTrue(getFontSizeIcon.isDisplayed());
	Assert.assertTrue(getRTELinkIcon.isDisplayed());
	
	//Click to send the email
	WebElement getSendButton = driver.findElement(clickSendButton);
	getSendButton.click();
	Thread.sleep(SLEEP_WAIT_2000);

	driver.navigate().refresh();
	Thread.sleep(SLEEP_WAIT_2000);
	
	return true;
	
    }
}




