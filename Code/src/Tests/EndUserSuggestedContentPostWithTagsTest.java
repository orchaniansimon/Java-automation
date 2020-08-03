package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.EndUserSuggestedContentPostWithTags;
import PageObjects.SignInPage;

public class EndUserSuggestedContentPostWithTagsTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyEndUserSuggestedPostWithTags(String username, String password) throws InterruptedException {
	System.out.println("Admin / User Suggested Post with tags and publish post verification");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	EndUserSuggestedContentPostWithTags endUserSuggestedContentPostWithTags = new EndUserSuggestedContentPostWithTags(
		driver);

	// Verify sign in
	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Verify the library post link and content
	System.out.println("Suggested Post with tags: verifying the new library post link");
	Assert.assertEquals(endUserSuggestedContentPostWithTags.clickOnNewLibraryPostLink(),
		"Content was successfully suggested.");

	// Verify the user suggested post with tags
	System.out.println("Suggested Post with tags: verifying the user suggested post with tags");
	Assert.assertTrue(
		endUserSuggestedContentPostWithTags.verifyUserSuggestedPostWithTags().contains("User suggested post"));

	// Verify the user suggested post with tags count
	System.out.println("Suggested Post with tags: verifying the suggested post count with tags");
	Assert.assertTrue(endUserSuggestedContentPostWithTags.verifyUserSuggestedPostCountWithTags());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
