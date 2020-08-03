package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Initializations;

public class EmailLibrary implements Initializations {
    private WebDriver driver;

    public EmailLibrary(WebDriver driver) {
	this.driver = driver;
    }

    public String getPageTitle() {
	String pageTitle = driver.getTitle();
	return pageTitle;
    }

    public boolean verifyPageTitle() {
	String expectedTitle = "Email Library";
	return getPageTitle().contains(expectedTitle);
    }

    public boolean verifyPageText() {
	String element = driver.getPageSource();
	String expectedPageText = "Email Library";
	return element.contains(expectedPageText);
    }

    public boolean verifyNavBar() {
	WebElement navBarHeader = driver.findElement(navigationHeader);
	if (navBarHeader.isDisplayed()) {
	    return true;
	}
	return false;
    }

    public boolean verifySecondaryNavBar() {
	WebElement secondaryNavBarHeader = driver.findElement(secondaryHeader);
	if (secondaryNavBarHeader.isDisplayed()) {
	    return true;
	}
	return false;
    }

    // Goto Email library page
    public boolean clickOnEmailLibraryLink() throws InterruptedException {

	WebElement mailLink = driver.findElement(mailHeaderLink);

	// Wait for elements to be visible
	WebDriverWait waitForLibraryLink = new WebDriverWait(driver, 15);

	if (mailLink.isDisplayed()) {
	    mailLink.click();

	    // Wait for element visibleWebDriverWait waitForLibraryLink = new
	    // WebDriverWait(driver, 15);
	    waitForLibraryLink.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#subnav-list > ul > li:nth-child(2) > a")));

	    // Click on the library link
	    WebElement emailLink = driver.findElement(emailLibraryLink);
	    emailLink.click();

	    WebDriverWait waitForTiles = new WebDriverWait(driver, 15);
	    waitForTiles.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grail-content-links-container.row > div:nth-child(2)")));
	}

	else
	    System.out.println("Element not found");
	return true;
    }

    public boolean getEmailLibraryPage() {
	WebElement emailPage = driver.findElement(emailLibraryPage);
	if (emailPage.isDisplayed()) {
	    return true;
	}
	return false;
    }
    
    public boolean getEmailLibraryPageSearchForm() {
	WebElement searchForm = driver.findElement(emailLibrarySearchFilter);
	if (searchForm.isDisplayed() ) {
	    return true;
	}
	 return false;
    }

    public boolean getEmailLibraryTiles() {
	WebElement emailTiles = driver.findElement(emailLibraryTiles);
	if (emailTiles.isDisplayed()) {
	    return true;
	}
	return false;
    }

    // Get the library filter link
    public boolean getEmailLibraryFilterLink() {
	WebElement emailLibraryFilter = driver.findElement(emailLibraryFilterButton);
	if (emailLibraryFilter.isDisplayed()) {
	    return true;
	}
	return false;
    }

    // Click on the email library tile
    public boolean clickEmailLibraryTile() throws InterruptedException {
	WebElement getLibraryTile = driver.findElement(libraryTile);

	if (getLibraryTile.isDisplayed()) {

	    getLibraryTile.click();
	    Thread.sleep(SLEEP_WAIT_4000);

	    return true;
	}
	return false;
    }

    // check the email tile composer
    public boolean verifyEmailTileComposerOverlay() {
	WebElement getTileComposerOverlay = driver.findElement(composerOverlay);
	if (getTileComposerOverlay.isDisplayed()) {
	    return true;
	}
	return false;
    }

    // verify the tile notes
    public boolean verifyEmailTileNotesContainer() {
	WebElement getNotesContainer = driver.findElement(notesContainer);
	if (getNotesContainer.isDisplayed()) {
	    return true;
	}
	return false;
    }

    // verify the recipient form field
    public boolean verifyRecipientFormField() {
	WebElement getRecipientFormField = driver.findElement(recipientFormField);
	if (getRecipientFormField.isDisplayed()) {
	    return true;
	}
	return false;
    }

    // Enter a contact in the new email popover
    public boolean setContactName() throws InterruptedException {
	WebElement recipientField = driver.findElement(By.cssSelector(".recipients-search > form input"));

	// enter contact name into form field
	recipientField.sendKeys(emailContactName);

	// tab to select contact
	recipientField.sendKeys(Keys.TAB);
	Thread.sleep(SLEEP_WAIT_4000);

	// get the element for the selected contact
	WebElement getContact = driver.findElement(selectContact);

	// enter to choose the contact
	getContact.sendKeys("\n");
	return true;
    }

    // Enter a contact in the new email popover
    public boolean sendNewEmail() throws InterruptedException {

	WebElement getSendButton = driver.findElement(clickSendButton);
	getSendButton.click();

	Thread.sleep(SLEEP_WAIT_2000);

	// Verify sent message
	WebElement getSentMessage = driver.findElement(sentMessage);
	String verifySentMessage = getSentMessage.getText();

	if (verifySentMessage.contains("Email send request")) {
	    return true;
	}
	return false;
    }
}
