package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Initializations;

public class CreateMultipleSuggestedPosts implements Initializations {
    private WebDriver driver;

    public CreateMultipleSuggestedPosts(WebDriver driver) {
	this.driver = driver;
    }

    // Goto administration --> suggested posts
    public void clickOnNewLibraryPostLink() throws InterruptedException {

	Thread.sleep(SLEEP_WAIT_2000);
	WebElement clickNewLibraryPostLink = driver.findElement(libraryPostLink);

	// Wait for elements to be visible
	WebDriverWait waitForLibraryPostModal = new WebDriverWait(driver, 2000);

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

	WebElement getCloseLinkOnModal = driver.findElement(clickToCloseModalLink);

	getCloseLinkOnModal.click();
    }
}
