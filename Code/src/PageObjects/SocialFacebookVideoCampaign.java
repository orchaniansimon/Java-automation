
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.Initializations;

public class SocialFacebookVideoCampaign implements Initializations {
    private WebDriver driver;

    public SocialFacebookVideoCampaign(WebDriver driver) {
	this.driver = driver;
    }

    // Click on the email campaign button --> dynamic email campaign
    public Boolean verifyFacebookVideoCampaign() throws InterruptedException {

	WebElement clickSocialHeaderLink = driver.findElement(socialHeaderLink);
	clickSocialHeaderLink.click();
	Thread.sleep(SLEEP_WAIT_2000);

	WebElement getContentLinkDropDown = driver.findElement(contentLinkDropDown);
	WebElement getCampaignLinkDropDown = driver.findElement(socialContentCampaignsLink);

	if (getContentLinkDropDown.isDisplayed()) {
	    // Need to click the content link then campaigns link
	    getContentLinkDropDown.click();
	    Thread.sleep(SLEEP_WAIT_2000);
	    getCampaignLinkDropDown.click();
	    Thread.sleep(SLEEP_WAIT_2000);
	}

	// Verify the Social Campaigns page
	WebElement getPostsLinkDropDown = driver.findElement(socialFacebookVideoCampaignsPage);
	Assert.assertTrue(getPostsLinkDropDown.isDisplayed());

	// Get the campaigns link and click it to open drawer
	WebElement getCampaignLink = driver.findElement(clickCampaignsLink);
	getCampaignLink.click();

	WebElement getSocialFacebookVideoCampaignDrawer = driver.findElement(socialFacebookVideoCampaignDrawer);

	if (getSocialFacebookVideoCampaignDrawer.isDisplayed()) {
	    return true;
	}

	return false;
    }
}
