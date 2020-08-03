
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Initializations;

public class SocialPosts implements Initializations {
    private WebDriver driver;

    public SocialPosts(WebDriver driver) {
	this.driver = driver;
    }

    // Goto administration --> suggested posts
    public String socialPostPublishAndVerify() throws InterruptedException {

	Thread.sleep(SLEEP_WAIT_2000);
	WebElement clickNewLibraryPostLink = driver.findElement(socialHeaderLink);

	// Wait for elements to be visible
	WebDriverWait waitForLibraryPostModal = new WebDriverWait(driver, 2000);
	clickNewLibraryPostLink.click();

	// Click on the social posts button
	WebElement clickSocialPostLink = driver.findElement(socialPostLink);
	clickSocialPostLink.click();

	// Wait for the email campaign link to be visible
	waitForLibraryPostModal.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".composition-area")));

	WebElement libraryPostComposition = driver.findElement(libraryPostModalComposition);

	// Append a random integer to the text so it's not a duplicate suggested post
	libraryPostComposition.sendKeys("User suggested post" + suggestedPostRandomInteger);

	// Click on the social networks checkbox
	WebElement getSocialNetworksLink = driver.findElement(socialPostLinkedInCheckbox);
	getSocialNetworksLink.click();
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement getSuggestButton = driver.findElement(socialPostPublishButton);
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
	return null;
    }

    // Click on the email campaign button --> dynamic email campaign
    public Boolean verifySocialLibraryPost() throws InterruptedException {

	WebElement clickSocialHeaderLink = driver.findElement(socialHeaderLink);
	clickSocialHeaderLink.click();
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement getContentLinkDropDown = driver.findElement(contentLinkDropDown);

	if (getContentLinkDropDown.isDisplayed()) {
	    // Need to click the content link
	    getContentLinkDropDown.click();
	    Thread.sleep(SLEEP_WAIT_2000);
	}

	WebElement getPostsLinkDropDown = driver.findElement(postsLinkDropDown);
	getPostsLinkDropDown.click();
	Thread.sleep(SLEEP_WAIT_4000);

	WebElement getUserSuggestedPostTileMessage = driver.findElement(userSuggestedPostTileMessage);
	String userSuggestedPostMessage = getUserSuggestedPostTileMessage.getText();
	
	if (userSuggestedPostMessage.contains("suggested post")) {
	    return true;
	}

	return false;
    }
}