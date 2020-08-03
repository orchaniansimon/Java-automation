package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.SocialFacebookVideoCampaign;
import PageObjects.SignInPage;

public class SocialFacebookVideoCampaignTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyEndUserSuggestedPost(String username, String password) throws InterruptedException {
	System.out.println("Social Facebook video campaign and verification");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	SocialFacebookVideoCampaign socialFacebookVideoCampaign = new SocialFacebookVideoCampaign(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	System.out.println("Social campaigns: verify facebook video on drawer");
	Assert.assertTrue(socialFacebookVideoCampaign.verifyFacebookVideoCampaign());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}

