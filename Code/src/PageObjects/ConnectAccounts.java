
package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Initializations;


public class ConnectAccounts extends Utilities implements Initializations {
    private WebDriver driver;

    public ConnectAccounts(WebDriver driver) {
	this.driver = driver;
    }

    
    // Goto administration --> suggested posts
    public boolean verifyConnectAccounts() throws InterruptedException {

	Thread.sleep(SLEEP_WAIT_2000);
	WebElement clickSocialHeaderLink = driver.findElement(socialHeaderLink);

	clickSocialHeaderLink.click();
	
	Thread.sleep(SLEEP_WAIT_2000);
	
	//Click the profile link
	WebElement getUserProfileDropDown = driver.findElement(profileDropDown);
	getUserProfileDropDown.click();

	WebElement getclickConnectAccounts = driver.findElement(clickConnectAccounts);
	getclickConnectAccounts.click();

	
	waitForCssElement("#social-accounts-section");

	// Get the buttons for the different accounts
	WebElement getconnectInstagramButton = driver.findElement(connectInstagramButton);
	WebElement getconnectLinkedInButton = driver.findElement(connectLinkedInButton);
	WebElement getconnectFacebookButton = driver.findElement(connectFacebookButton);
	WebElement getconnectTwitterButton = driver.findElement(connectTwitterButton);

	// Get the text for the account buttons to match against
	String verifyConnectInstagramButton = getconnectInstagramButton.getText();
	String verifyConnectLinkedInButton = getconnectLinkedInButton.getText();
	String verifyConnectFacebookButton = getconnectFacebookButton.getText();
	String verifyConnectTwitterButton = getconnectTwitterButton.getText();

	
	// Verify that page source contains edited email
	if (verifyConnectInstagramButton.contains(verifyConnectInstagramButton)
		&& verifyConnectLinkedInButton.contains(verifyConnectLinkedInButton)
		&& verifyConnectFacebookButton.contains(verifyConnectFacebookButton)
		&& verifyConnectTwitterButton.contains(verifyConnectTwitterButton)) {
	    
	    return true;
	}
	return false;
    }


}
