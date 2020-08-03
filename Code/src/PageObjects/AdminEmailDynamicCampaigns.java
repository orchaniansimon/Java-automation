
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Initializations;

public class AdminEmailDynamicCampaigns extends Utilities implements Initializations {
    private WebDriver driver;

    public AdminEmailDynamicCampaigns(WebDriver driver) {
	this.driver = driver;
    }

    // Goto Create link --> Email Campaigns
    public String getEmailCampaignsPage() throws InterruptedException {

	Thread.sleep(SLEEP_WAIT_2000);
	WebElement clickCreateLink = driver.findElement(createLink);

	// Wait for elements to be visible
	WebDriverWait waitForEmailCampaignsLink = new WebDriverWait(driver, 15);

	if (clickCreateLink.isDisplayed()) {
	    clickCreateLink.click();
	    Thread.sleep(SLEEP_WAIT_2000);

	    // Wait for the email campaign link to be visible
	    waitForEmailCampaignsLink.until(ExpectedConditions
		    .visibilityOfElementLocated(By.cssSelector(".subnav__list-item.open > ul > li:nth-child(10) > a")));
	    WebElement emailCampaignDropdownLink = driver.findElement(emailCampaignLink);

	    if (emailCampaignDropdownLink.isDisplayed()) {
		emailCampaignDropdownLink.click();
		// Wait for the hierarchy page to be visible
		Thread.sleep(SLEEP_WAIT_4000);

		// Verify that the Pause button shows up
		WebElement verifyDeleteButton = driver.findElement(deleteButtonLink);

		if (verifyDeleteButton.isDisplayed()) {
		    String getDeleteButton = verifyDeleteButton.getText();

		    return getDeleteButton;
		} else
		    System.out.println("Element not found");
	    }
	}
	return null;
    }

    // Click on the email campaign button --> dynamic email campaign
    public boolean createNewDynamicEmailCampaign() throws InterruptedException {

	driver.navigate().to(emailCampaignsPage);
	Thread.sleep(SLEEP_WAIT_4000);

	WebElement newEmailCampaignButton = driver.findElement(By.cssSelector(".btn.btn-default.pull-right"));

	// Wait for elements to be visible
	WebDriverWait waitForEmailCampaignsModal = new WebDriverWait(driver, 15);

	if (newEmailCampaignButton.isDisplayed()) {
	    newEmailCampaignButton.click();

	    // Wait for the email campaign link to be visible
	    Thread.sleep(SLEEP_WAIT_2000);

	    WebElement emailDynamicCampaignsDropdownLink = driver.findElement(emailDynamicCampaignLink);

	    if (emailDynamicCampaignsDropdownLink.isDisplayed()) {
		emailDynamicCampaignsDropdownLink.click();
		// Wait for the hierarchy page to be visible
		waitForEmailCampaignsModal.until(ExpectedConditions
			.visibilityOfElementLocated(By.cssSelector(".grail-modal > div > div > div > div.modal-body")));
	    } else
		System.out.println("Element not found");
	}

	// Fill out the new email campaign form title and desc

	WebElement composeDynamicEmailTitle = driver.findElement(By.cssSelector("#mail-campaign-name-input"));
	composeDynamicEmailTitle.sendKeys("Hearsay Systems Testing");

	WebElement composeDynamicEmailDesc = driver.findElement(emailDynamicDesc);
	composeDynamicEmailDesc.sendKeys("Hearsay Systems");

	// Click on the save button
	WebElement clickOnSaveButton = driver.findElement(emailDynamicSaveButton);
	clickOnSaveButton.click();

	// Wait for the campaigns detail page
	Thread.sleep(SLEEP_WAIT_2000);

	// Verify the campaign details page
	WebElement verifyEmailDynamicComposeButton = driver.findElement(emailDynamicComposeButton);

	if (verifyEmailDynamicComposeButton.isDisplayed()) {
	    verifyEmailDynamicComposeButton.click();

	    // Compose the email form
	    WebElement composeEmailFormSubject = driver.findElement(By.cssSelector(".subject-bar.clearfix > input"));
	    composeEmailFormSubject.sendKeys("Hearsay Systems Compose Email Subject");

	    WebElement composeEmailFormBody = driver.findElement(By.cssSelector(".public-DraftEditor-content"));
	    composeEmailFormBody.sendKeys("Hearsay Systems Compose Body");

	    // Click on the schedule link
	    WebElement composeEmailScheduleLink = driver.findElement(emailScheduleLink);

	    if (composeEmailScheduleLink.isDisplayed()) {
		composeEmailScheduleLink.click();
		Thread.sleep(SLEEP_WAIT_4000);
	    }
	}

	// Activate the email
	WebElement verifyActivateButton = driver.findElement(activeButtonLink);

	// Wait for the campaigns page
	verifyActivateButton.click();

	WebElement verifyYesActivateButton = driver.findElement(activeYesButtonLink);
	verifyYesActivateButton.click();
	Thread.sleep(SLEEP_WAIT_2000);

	// Verify that the Pause button shows up
	WebElement verifyPauseButton = driver.findElement(pauseButtonLink);
	String getPauseButton = verifyPauseButton.getText();

	WebElement getcheckLiveStatusPostActivate = driver.findElement(checkLiveStatusPostActivate);

	// Need to click the content link
	String liveStatusText = getcheckLiveStatusPostActivate.getText();

	if (getPauseButton.contains("Pause") && liveStatusText.contains("Live")) {
	    return true;
	}
	return false;
    }

    // Click to goto the user mail page and verify email campaign
    public boolean verifyDynamicEmailCampaignOnUser() throws InterruptedException {

	// Click on the mail link to verify user suggested post
	WebElement clickOnMailLink = driver.findElement(headerMailLink);
	clickOnMailLink.click();

	Thread.sleep(SLEEP_WAIT_2000);
	WebElement clickOnCampaignsLink = driver.findElement(headerCampaignsLink);
	clickOnCampaignsLink.click();

	// Wait for the campaigns page
	waitForCssElement(".group-campaign-container");

	String getPageText = driver.getPageSource();
	Boolean emailCampaigns = getPageText.contains("Hearsay");

	return emailCampaigns;
    }
}
