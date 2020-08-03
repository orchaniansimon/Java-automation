package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.CreateMultipleSuggestedPosts;
import PageObjects.SignInPage;

public class CreateMultipleSuggestedPostsTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;
    int totalNumberOfSuggestedPosts = 2;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyCreateMultipleSuggestedPosts(String username, String password) throws InterruptedException {
	System.out.println("Admin / User Suggested Post verification");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	CreateMultipleSuggestedPosts createMultipleSuggestedPosts = new CreateMultipleSuggestedPosts(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Create multiple suggested posts
	System.out.println("Create multiple suggested posts:");

	for (int numberOfCreatedPosts = 1; numberOfCreatedPosts <= totalNumberOfSuggestedPosts; numberOfCreatedPosts++) {
	    createMultipleSuggestedPosts.clickOnNewLibraryPostLink();
	    System.out.println("Created " + numberOfCreatedPosts + " suggested posts");
	}

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
