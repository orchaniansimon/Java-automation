
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Initializations;

public class AdminEmailWithNotes extends Utilities implements Initializations {
    private WebDriver driver;

    // Get the notes text elements
    String notesFillout = "Hi There, This is a test for checking the mail notes feature for Hearsay Systems";
    String notesFilloutOverflow = "A a B b C c D d E e F f G g H h I i J j K k L l M m N n O o P p Q q R r S s T t U u V v W w X x Y y Z z"
	    + "A a B b C c D d E e F f G g H h I i J j K k L l M m N n O o P p Q q R r S s T t U u V v W w X x Y y Z z"
	    + "A a B b C c D d E e F f G g H h I i J j K k L l M m N n O o P p Q q R r S s T t U u V v W w X x Y y Z z"
	    + "A a B b C c D d E e F f G g H h I i J j K k L l M m N n O o P p Q q R r S s T t U u V v W w X x Y y Z z"
	    + "A a B b C c D d E e F f G g H h I i J j K k L l M m N n O o P p Q q R r S s T t U u V v W w X x Y y Z z";

    public By notesOverflowText = By.cssSelector(".labelled-textarea--character-limit-warning");

    public AdminEmailWithNotes(WebDriver driver) {
	this.driver = driver;
    }

    public String getPageTitle() {
	String pageTitle = driver.getTitle();
	return pageTitle;
    }

    public boolean verifyPageTitle() {
	String expectedTitle = "Hearsay";
	return getPageTitle().contains(expectedTitle);
    }

    public boolean verifyPageText() {
	String element = driver.getPageSource();
	String expectedPageText = "Suggested Posts";
	return element.contains(expectedPageText);
    }

    public boolean verifyNavBar() {
	WebElement navBarHeader = driver.findElement(adminLink);

	if (navBarHeader.isDisplayed()) {
	    return true;
	}
	return false;
    }

    public boolean verifySecondaryNavBar() {
	WebElement secondaryNavBarHeader = driver.findElement(secondaryNavigationBar);

	if (secondaryNavBarHeader.isDisplayed()) {
	    return true;
	}
	return false;
    }

    // Verify Administration New Email form
    // click on new email button
    public boolean verifyNewEmailForm() throws InterruptedException {

	Thread.sleep(SLEEP_WAIT_2000);
	WebElement getNewEmailButton = driver.findElement(newEmailButton);
	WebDriverWait waitForComposeEmailForm = new WebDriverWait(driver, 4000);
	if (getNewEmailButton.isDisplayed()) {
	    getNewEmailButton.click();

	    // Wait for css
	    Thread.sleep(SLEEP_WAIT_2000);
	    // Wait for the hierarchy link to be visible
	    waitForComposeEmailForm.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(" .sidebar")));
	    return true;
	}
	return false;
    }

    // Fill out the new email form subject and notes sections with overflow text
    public String composeEmailFormFilloutOverflow() throws InterruptedException {
	WebElement composeEmailSubject = driver.findElement(By.cssSelector(".subject-bar .form-control"));

	composeEmailSubject.sendKeys("Hearsay Systems Testing");
	WebElement composeEmailNotesOverflowText = driver.findElement(composeEmailNotesText);
	composeEmailNotesOverflowText.sendKeys(notesFilloutOverflow);

	WebElement getNotesOverflowText = driver.findElement(notesOverflowText);
	String saveOverflowText = getNotesOverflowText.getText().substring(0, 22);

	WebElement getEmailFormCancelButton = driver.findElement(emailFormCancelButton);
	getEmailFormCancelButton.click();

	return saveOverflowText;
    }

    // Fill out the new email form subject & notes section
    public boolean composeEmailFormFillout() throws InterruptedException {
	WebElement composeEmailSubject = driver.findElement(By.cssSelector(".subject-bar .form-control"));

	composeEmailSubject.sendKeys("Hearsay Systems Testing");

	WebElement composeEmailNotes = driver.findElement(composeEmailNotesText);
	composeEmailNotes.sendKeys(notesFillout);

	WebElement composeEmailSuggest = driver.findElement(composeEmailSuggestButton);

	// Click on the contact info
	WebElement clickOnContactInfo = driver.findElement(contactInfoLink);

	if (clickOnContactInfo.isDisplayed()) {
	    clickOnContactInfo.click();

	    // Click on add to message for first name
	    WebElement clickOnAddToMessage = driver.findElement(addToMessageFirstName);
	    clickOnAddToMessage.click();

	    // Click on contact info for email
	    WebElement clickOnEmailInfo = driver.findElement(contactEmailLink);
	    clickOnEmailInfo.click();

	    // Click on the add to message for email link
	    WebElement clickOnAddToMessageForEmail = driver.findElement(addToMessageEmail);
	    clickOnAddToMessageForEmail.click();
	}

	// Click on the Suggest button to submit the form
	composeEmailSuggest.click();

	Thread.sleep(SLEEP_WAIT_2000);
	return true;
    }

    // Click to goto the user mail page and verify the notes form field
    public String verifySuggestedEmailPostedOnUser() throws InterruptedException {

	// Click on the mail link to verify user suggested post
	Thread.sleep(SLEEP_WAIT_2000);
	WebElement clickOnMailLink = driver.findElement(mailHeaderLink);
	clickOnMailLink.click();

	// Click on the email library page
	EmailLibrary clickLibraryLink = new EmailLibrary(driver);
	clickLibraryLink.clickOnEmailLibraryLink();

	// Click on the library tile to verify
	WebElement clickOnLibraryTile = driver.findElement(verifyLibraryTileForNotes);
	clickOnLibraryTile.click();
	Thread.sleep(SLEEP_WAIT_2000);

	// get the notes on the email library tile and return the text
	WebElement getTileNotes = driver.findElement(verifyNotesText);
	System.out.println(getTileNotes.getText());
	return getTileNotes.getText();
    }

}
