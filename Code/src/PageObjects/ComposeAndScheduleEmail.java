package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Initializations;

public class ComposeAndScheduleEmail extends Utilities implements Initializations {
    private WebDriver driver;

    public ComposeAndScheduleEmail(WebDriver driver) {
	this.driver = driver;
    }

    // Goto Email library page
    public Boolean verifyComposeScheduleEmail() throws InterruptedException {

	Thread.sleep(SLEEP_WAIT_4000);
	WebElement getMailLink = driver.findElement(mailHeaderLink);
	getMailLink.click();

	Thread.sleep(SLEEP_WAIT_2000);

	WebElement clickScheduledLink = driver.findElement(ScheduledLink);
	clickScheduledLink.click();
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement clickComposeEmailButton = driver.findElement(composeEmailButton);
	clickComposeEmailButton.click();
	Thread.sleep(SLEEP_WAIT_2000);

	// waitForLinkText("Google");

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

	WebElement getClickScheduleButton = driver.findElement(clickScheduleButton);
	getClickScheduleButton.click();

	WebElement getClickScheduleAllButton = driver.findElement(clickScheduleAllButton);
	getClickScheduleAllButton.click();
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement getClickScheduledEmailOkButton = driver.findElement(clickScheduledEmailOkButton);
	getClickScheduledEmailOkButton.click();

	driver.navigate().refresh();
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement getClickUnscheduleEmailButton = driver.findElement(clickUnscheduleEmailButton);
	String unScheduleText = getClickUnscheduleEmailButton.getText();
	if (unScheduleText.contains("Unschedule"));
	{
	    return true;
	}
    }

    // Enter a contact in the new email popover
    public Boolean unScheduleEmail() throws InterruptedException {

	driver.navigate().to(scheduleEmailURL);
	Thread.sleep(SLEEP_WAIT_2000);
	WebDriverWait waitForScheduledEmail = new WebDriverWait(driver, 25);
	waitForScheduledEmail.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#scheduled-emails > main")));

	WebElement getClickUnscheduleEmailButton = driver.findElement(clickUnscheduleEmailButton);
	getClickUnscheduleEmailButton.click();
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement getUnScheduleButtonConfirm = driver.findElement(unScheduleButtonConfirm);
	getUnScheduleButtonConfirm.click();

	String scheduledEmailsPage = driver.getPageSource();
	if (scheduledEmailsPage.contains(noScheduledEmailsText));
	{
	    return true;
	}

    }

    public void method1() {
	// TODO Auto-generated method stub
    }

    public void method2() {
	// TODO Auto-generated method stub
    }
}

