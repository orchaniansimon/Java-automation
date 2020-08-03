
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Initializations;

public class AdminEmailRelativeCampaigns extends Utilities implements Initializations {
    private WebDriver driver;

    public AdminEmailRelativeCampaigns(WebDriver driver) {
	this.driver = driver;
    }

    // Goto Create link --> Email Campaigns
    public String getEmailCampaignsPage() throws InterruptedException {

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

		// Wait for the campaigns modal
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

    // Click on the email campaign button --> Relative email campaign
    public boolean createNewRelativeEmailCampaign() throws InterruptedException {

	// Goto email campaigns page
	driver.navigate().to(emailCampaignsPage);
	// waitForCssElement(".enterprise-campaigns");
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement newEmailCampaignButton = driver.findElement(By.cssSelector(".btn.btn-default.pull-right"));

	// Wait for elements to be visible
	WebDriverWait waitForEmailCampaignsModal = new WebDriverWait(driver, 15);

	if (newEmailCampaignButton.isDisplayed()) {
	    newEmailCampaignButton.click();

	    // Wait for the email campaign link to be visible
	    Thread.sleep(SLEEP_WAIT_2000);

	    WebElement emailRelativeCampaignsDropdownLink = driver.findElement(emailRelativeCampaignLink);

	    if (emailRelativeCampaignsDropdownLink.isDisplayed()) {
		emailRelativeCampaignsDropdownLink.click();
		// Wait for the hierarchy page to be visible
		waitForEmailCampaignsModal.until(ExpectedConditions
			.visibilityOfElementLocated(By.cssSelector(".grail-modal > div > div > div > div.modal-body")));
	    } else
		System.out.println("Element not found");
	}

	// Fill out the new email campaign form title and desc
	WebElement composeRelativeEmailTitle = driver.findElement(By.cssSelector("#mail-campaign-name-input"));

	composeRelativeEmailTitle.sendKeys("Hearsay Systems Testing");

	WebElement composeRelativeEmailDesc = driver.findElement(emailRelativeDesc);
	composeRelativeEmailDesc.sendKeys("Hearsay Systems");

	// Click on the save button
	WebElement clickOnSaveButton = driver.findElement(emailRelativeSaveButton);
	clickOnSaveButton.click();

	// Wait for the campaigns detail page
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement verifyEmailRelativeComposeButton = driver.findElement(emailRelativeComposeButton);

	if (verifyEmailRelativeComposeButton.isDisplayed()) {
	    verifyEmailRelativeComposeButton.click();

	    // Compose the email form
	    WebElement composeEmailFormSubject = driver.findElement(By.cssSelector(".subject-bar.clearfix > input"));
	    composeEmailFormSubject.sendKeys("Hearsay Systems Compose Email Subject");

	    WebElement composeEmailFormBody = driver.findElement(By.cssSelector(".public-DraftEditor-content"));
	    composeEmailFormBody.sendKeys("Hearsay Systems Compose Body");

	    WebElement composeEmailScheduleDate = driver.findElement(emailScheduleDateForm);
	    composeEmailScheduleDate.sendKeys("2");

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
	// Verify that the expire button shows up
	WebElement verifyExpireButton = driver.findElement(expireButtonLink);
	WebElement verifyLiveStatus = driver.findElement(checkLiveStatusPostActivate);

	String getExpireButton = verifyExpireButton.getText();
	String liveStatusText = verifyLiveStatus.getText();

	if (liveStatusText.contains("Live") && getExpireButton.contains("Expire")) {
	    return true;
	}
	return false;
    }

    // Click to goto the user mail page and verify email campaign
    public boolean verifyRelativeEmailCampaignOnUser() throws InterruptedException {

	// Click on the mail link to verify user suggested post
	WebElement clickOnMailLink = driver.findElement(headerMailLink);
	clickOnMailLink.click();

	Thread.sleep(SLEEP_WAIT_2000);
	WebElement clickOnCampaignsLink = driver.findElement(headerCampaignsLink);
	clickOnCampaignsLink.click();

	// Wait for campaigns page
	Thread.sleep(SLEEP_WAIT_2000);

	String getPageText = driver.getPageSource();
	Boolean emailCampaigns = getPageText.contains("Hearsay");

	return emailCampaigns;
    }

}
