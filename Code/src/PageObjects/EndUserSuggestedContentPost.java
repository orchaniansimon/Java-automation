
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Initializations;

public class EndUserSuggestedContentPost implements Initializations {
    private WebDriver driver;

    public EndUserSuggestedContentPost(WebDriver driver) {
	this.driver = driver;
    }

    // Goto administration --> suggested posts
    public String clickOnNewLibraryPostLink() throws InterruptedException {

	Thread.sleep(SLEEP_WAIT_2000);
	WebElement clickNewLibraryPostLink = driver.findElement(libraryPostLink);

	// Wait for elements to be visible
	WebDriverWait waitForLibraryPostModal = new WebDriverWait(driver, 2000);

	if (clickNewLibraryPostLink.isDisplayed()) {
	    clickNewLibraryPostLink.click();

	    // Wait for the email campaign link to be visible
	    waitForLibraryPostModal.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".composition-area")));

	    WebElement libraryPostComposition = driver.findElement(libraryPostModalComposition);

	    // Append a random integer to the text so it's not a duplicate suggested post
	    libraryPostComposition.sendKeys("User suggested post" + suggestedPostRandomInteger);

	    // Click on the social networks link
	    WebElement getSocialNetworksLink = driver.findElement(socialNetworksLink);
	    getSocialNetworksLink.click();
	    Thread.sleep(SLEEP_WAIT_2000);

	    // Uncheck Instagram
	    WebElement uncheckInstagramLink = driver.findElement(instagramLink);
	    uncheckInstagramLink.click();

	    WebElement getSuggestButton = driver.findElement(suggestButtonLink);
	    getSuggestButton.click();
	    Thread.sleep(SLEEP_WAIT_2000);

	    WebElement getAlertInfo = driver.findElement(alertInfoText);
	    WebElement getCloseLinkOnModal = driver.findElement(clickToCloseModalLink);

	    if (getAlertInfo.isDisplayed()) {
		String confirmContentSuggested = getAlertInfo.getText();
		getCloseLinkOnModal.click();
		return confirmContentSuggested;
	    } else
		System.out.println("Element not found");
	}
	return null;
    }

    // Click on the email campaign button --> dynamic email campaign
    public String verifyUserSuggestedPost() throws InterruptedException {

	WebElement clickSocialHeaderLink = driver.findElement(socialHeaderLink);
	clickSocialHeaderLink.click();

	Thread.sleep(SLEEP_WAIT_2000);

	WebElement getContentLinkDropDown = driver.findElement(contentLinkDropDown);

	if (getContentLinkDropDown.isDisplayed()) {
	    // Need to click the content link
	    getContentLinkDropDown.click();
	    Thread.sleep(SLEEP_WAIT_2000);

	    WebElement getPostsLinkDropDown = driver.findElement(postsLinkDropDown);
	    getPostsLinkDropDown.click();
	    Thread.sleep(SLEEP_WAIT_4000);

	    WebElement getUserSuggestedPostTileMessage = driver.findElement(userSuggestedPostTileMessage);
	    String userSuggestedPostMessage = getUserSuggestedPostTileMessage.getText();

	    return userSuggestedPostMessage;
	}
	return null;
    }

    // Fill out the new email campaign form title and desc
    public Boolean verifyUserSuggestedPostPublish() throws InterruptedException {

	// Click to goto the published posts and get the count of them
	WebElement getClickSideNavPublishedLinkFirstVisit = driver.findElement(clickSideNavPublishedLink);
	getClickSideNavPublishedLinkFirstVisit.click();
	Thread.sleep(SLEEP_WAIT_4000);

	// Get the number of published posts then parse it to an integer
	WebElement getNumberOfPublishedPosts = driver.findElement(numberOfPublishedPosts);
	String numberOfPostsFirstVisit = getNumberOfPublishedPosts.getText();
	int firstResult = Integer.parseInt(numberOfPostsFirstVisit.substring(0, 3));

	// Go back to the user suggested posts page
	WebElement getSideNavSuggestedPostLink = driver.findElement(clickSideNavSuggestedPostLink);
	getSideNavSuggestedPostLink.click();
	Thread.sleep(SLEEP_WAIT_4000);

	// Click the first tile on user view suggested posts
	WebElement getUserSuggestedPostTile = driver.findElement(clickUserSuggestedPostTile);
	getUserSuggestedPostTile.click();
	Thread.sleep(SLEEP_WAIT_4000);

	// Get and click on the publish button on the modal
	WebElement getUserSuggestedPostPublishButton = driver.findElement(clickUserSuggestedPostPublishButton);
	getUserSuggestedPostPublishButton.click();
	Thread.sleep(SLEEP_WAIT_4000);

	// Close modal for post publish success
	WebElement getCloseModalPostPublishSuccess = driver.findElement(closeModalPostPublishSuccess);
	getCloseModalPostPublishSuccess.click();

	// Click to go back to published posts
	WebElement getClickSideNavPublishedLink = driver.findElement(clickSideNavPublishedLink);
	getClickSideNavPublishedLink.click();
	Thread.sleep(SLEEP_WAIT_4000);

	// Get the number of published posts and parse it to an integer
	WebElement getNumberOfPublishedPostsSecondVisit = driver.findElement(numberOfPublishedPosts);
	String numberOfPostsSecondVisit = getNumberOfPublishedPostsSecondVisit.getText();
	int secondResult = Integer.parseInt(numberOfPostsSecondVisit.substring(0, 3));
	System.out.println("Verified suggested posts = " + (secondResult == firstResult + 1));

	// Verify that the published posts increased by one
	// Boolean resultsMatch = true;
	if (secondResult == firstResult + 1) {
	    return true;
	}
	return false;
    }

}
