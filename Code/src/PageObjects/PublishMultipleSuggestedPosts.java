package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Initializations;

public class PublishMultipleSuggestedPosts extends Utilities implements Initializations {
    private WebDriver driver;

    public PublishMultipleSuggestedPosts(WebDriver driver) {
	this.driver = driver;
    }

    // Click on the email campaign button --> dynamic email campaign
    public void publishMultipleEndUserSuggestedPosts() throws InterruptedException {

	Thread.sleep(SLEEP_WAIT_2000);
	WebElement clickSocialHeaderLink = driver.findElement(socialHeaderLink);
	clickSocialHeaderLink.click();
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement getContentLinkDropDown = driver.findElement(contentLinkDropDown);
	// Need to click the content link
	getContentLinkDropDown.click();

	WebElement getPostsLinkDropDown = driver.findElement(postsLinkDropDown);
	getPostsLinkDropDown.click();
	Thread.sleep(SLEEP_WAIT_4000);

	// Click the first tile on user view suggested posts
	WebElement getUserSuggestedPostTile = driver.findElement(clickUserSuggestedPostTile);
	getUserSuggestedPostTile.click();
	Thread.sleep(SLEEP_WAIT_2000);

	// Get and click on the publish button on the modal
	WebElement getUserSuggestedPostPublishButton = driver.findElement(clickUserSuggestedPostPublishButton);
	getUserSuggestedPostPublishButton.click();
	Thread.sleep(SLEEP_WAIT_2000);
	// waitForCssElement(".alert.alert-success");

	// Close modal for post publish success
	WebElement getCloseModalPostPublishSuccess = driver.findElement(closeModalPostPublishSuccess);
	getCloseModalPostPublishSuccess.click();

    }


}
