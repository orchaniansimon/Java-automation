
package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Initializations;

public class EndUserSuggestedContentPostWithSummarizedLink implements Initializations {
    private WebDriver driver;

    // Get the email dynamic links
    private By libraryPostLink = By.cssSelector("#createnew > div > div");
    private By libraryPostModalComposition = By.cssSelector(".composition-border > textarea");
    private By socialNetworksLink = By.cssSelector("#social-networks-subtitle");
    private By instagramLink = By.cssSelector("#instagram");
    private By suggestButtonLink = By.cssSelector(".publisher-buttons > div > div > .post-submit-button");

    private By alertInfoText = By.cssSelector(".modal-body > div > div");
    private By clickToCloseModalLink = By.cssSelector(".publisher-buttons > button");
    private By contentLinkDropDown = By.cssSelector("#subnav-list > ul > li:nth-child(2)");

    private By socialHeaderLink = By.cssSelector("li:nth-child(2) > a > .main-nav__product-name");
    private By postsLinkDropDown = By.cssSelector(".open > ul > li:nth-child(1)");
    private By userSuggestedPostTileMessage = By.cssSelector("div:nth-child(1) > div > .panel-body > .message");
    private By clickUserSuggestedPostTile = By.cssSelector("div:nth-child(1) > div > .panel-body > .message");

    private By clickUserSuggestedPostPublishButton = By.cssSelector(".publisher-buttons > div > div > button");
    private By alertForPublishedPost = By.cssSelector(".alert.alert-success");
    private By closeModalPostPublishSuccess = By.cssSelector(".publisher-buttons > button");
    private By clickSideNavPublishedLink = By.cssSelector("div:nth-child(5) > a");
    private By clickSideNavSuggestedPostLink = By.cssSelector("#side_nav_selection_Category > div:nth-child(2) > a");
    private By numberOfPublishedPosts = By.cssSelector("#content-number > h1");

    public EndUserSuggestedContentPostWithSummarizedLink(WebDriver driver) {
	this.driver = driver;
    }

    // Goto administration --> suggested posts
    public String clickOnNewLibraryPostLink(String summarizedLinkURL) throws InterruptedException {

	Thread.sleep(SLEEP_WAIT_4000);
	WebElement clickNewLibraryPostLink = driver.findElement(libraryPostLink);

	// Wait for elements to be visible
	WebDriverWait waitForLibraryPostModal = new WebDriverWait(driver, 2000);

	if (clickNewLibraryPostLink.isDisplayed()) {
	    clickNewLibraryPostLink.click();
	    
	    Thread.sleep(SLEEP_WAIT_2000);

	    // Wait for the email campaign link to be visible
	    waitForLibraryPostModal.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".composition-area")));

	    WebElement libraryPostComposition = driver.findElement(libraryPostModalComposition);

	    // Append a random integer to the text so it's not a duplicate suggested post
	    libraryPostComposition.sendKeys("User suggested post" + suggestedPostRandomInteger + "\n");

	    // Click on the social networks link
	    WebElement getSocialNetworksLink = driver.findElement(socialNetworksLink);
	    getSocialNetworksLink.click();
	    
	    Thread.sleep(SLEEP_WAIT_2000);

	    //Uncheck Instagram
	    WebElement uncheckInstagramLink = driver.findElement(instagramLink);
	    uncheckInstagramLink.click();

	    // Get all elements in the menu for Create
	    List<WebElement> allElements = driver.findElements(By.cssSelector(".subnav__list-item.open > ul"));
	    
	    // Iterate through the elements and get the text values
	    for (WebElement getElement : allElements) {
		System.out.println(getElement.getText());
	    }

	    // Fill in a summarized link via parameters
	    libraryPostComposition.sendKeys(summarizedLinkURL + "\n");

	    WebElement getSuggestButton = driver.findElement(suggestButtonLink);
	    getSuggestButton.click();
	    Thread.sleep(SLEEP_WAIT_2000);

	    WebElement getAlertInfo = driver.findElement(alertInfoText);
	    WebElement getCloseLinkOnModal = driver.findElement(clickToCloseModalLink);

	    if (getAlertInfo.isDisplayed()) 
	    {
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

	WebDriverWait waitForContainer = new WebDriverWait(driver, 5000);
	// Wait for the email campaign link to be visible
	waitForContainer.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#recommended-action-container")));

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
	Thread.sleep(SLEEP_WAIT_2000);

	WebDriverWait waitForSuggestedPostsPage = new WebDriverWait(driver, 10000);
	// Wait for the email campaign link to be visible
	waitForSuggestedPostsPage.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#mainContent")));

	// Get the number of published posts then parse it to an integer
	WebElement getNumberOfPublishedPosts = driver.findElement(numberOfPublishedPosts);
	String numberOfPostsFirstVisit = getNumberOfPublishedPosts.getText();
	int firstResult = Integer.parseInt(numberOfPostsFirstVisit.substring(0, 2));

	// Go back to the user suggested posts page
	WebElement getSideNavSuggestedPostLink = driver.findElement(clickSideNavSuggestedPostLink);
	getSideNavSuggestedPostLink.click();

	Thread.sleep(SLEEP_WAIT_2000);
	driver.navigate().refresh();
	Thread.sleep(SLEEP_WAIT_4000);

	// Click the first tile on user view suggested posts
	WebElement getUserSuggestedPostTile = driver.findElement(clickUserSuggestedPostTile);
	getUserSuggestedPostTile.click();
	Thread.sleep(SLEEP_WAIT_4000);

	WebDriverWait waitForModalContainer = new WebDriverWait(driver, 8000);
	// Wait for the email campaign link to be visible
	waitForModalContainer.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".composition-area")));

	// Get and click on the publish button on the modal
	WebElement getUserSuggestedPostPublishButton = driver.findElement(clickUserSuggestedPostPublishButton);
	getUserSuggestedPostPublishButton.click();
	Thread.sleep(SLEEP_WAIT_4000);

	WebDriverWait waitForPublishStatusMessage = new WebDriverWait(driver, 10000);
	// Wait for the email campaign link to be visible
	waitForPublishStatusMessage.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".asset-publish-status-message > a")));

	// Get the alert success text
	WebElement getAlertForPublishedPost = driver.findElement(alertForPublishedPost);
	String postPublishSuccess = getAlertForPublishedPost.getText();

	// Close modal for post publish success
	WebElement getCloseModalPostPublishSuccess = driver.findElement(closeModalPostPublishSuccess);
	getCloseModalPostPublishSuccess.click();

	// Click to go back to published posts
	WebElement getClickSideNavPublishedLink = driver.findElement(clickSideNavPublishedLink);
	getClickSideNavPublishedLink.click();
	Thread.sleep(SLEEP_WAIT_2000);

	// Get the number of published posts and parse it to an integer
	WebElement getNumberOfPublishedPostsSecondVisit = driver.findElement(numberOfPublishedPosts);
	String numberOfPostsSecondVisit = getNumberOfPublishedPostsSecondVisit.getText();
	int secondResult = Integer.parseInt(numberOfPostsSecondVisit.substring(0, 2));

	// Verify that the published posts increased by one
	Boolean resultsMatch = true;
	if (firstResult + 1 == secondResult) {
	    return resultsMatch;
	}
	return null;
    }

}
