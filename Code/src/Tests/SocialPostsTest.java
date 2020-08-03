package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.SocialPosts;
import PageObjects.SignInPage;

public class SocialPostsTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyEndUserSuggestedPost(String username, String password) throws InterruptedException {
	System.out.println("Social Post publish and verification");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	SocialPosts socialPosts = new SocialPosts(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Check the email form
	System.out.println("Suggested Post: verifying new library post link");
	Assert.assertEquals(socialPosts.socialPostPublishAndVerify(), "Content was successfully suggested.");

	System.out.println("Suggested Post: verifying the user suggested post page");
	Assert.assertTrue(socialPosts.verifySocialLibraryPost());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
