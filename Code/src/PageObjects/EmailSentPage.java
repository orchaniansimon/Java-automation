
package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Initializations;

public class EmailSentPage extends Utilities implements Initializations {
    private WebDriver driver;

    public EmailSentPage(WebDriver driver) {
	this.driver = driver;
    }

    // Click on the email campaign button --> dynamic email campaign
    public boolean verifyEmailSentPage() throws InterruptedException {

	// go to the email sent page directly
	driver.navigate().to(emailSentPage);

	// Need to change to wait for css afterwards
	Thread.sleep(SLEEP_WAIT_2000);

	// get page source & set text values for the email sent page
	String getEmailSentPageText = driver.getPageSource();
	String expectedPageText = "Recipient";
	String errorText = "Error Code";

	// return true if the page text matches
	if (!getEmailSentPageText.contains(errorText) && getEmailSentPageText.contains(expectedPageText)) {
	    return true;
	}
	return false;

    }

   
}
