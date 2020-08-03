package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.EndUserSuggestedContentPost;
import PageObjects.SignInPage;

public class EndUserSuggestedContentPostTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyEndUserSuggestedPost(String username, String password) throws InterruptedException {
	System.out.println("Admin / User Suggested Post verification");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	EndUserSuggestedContentPost endUserSuggestedContentPost = new EndUserSuggestedContentPost(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Check the email form
	System.out.println("Suggested Post: verifying new library post link");
	Assert.assertEquals(endUserSuggestedContentPost.clickOnNewLibraryPostLink(),
		"Content was successfully suggested.");

	System.out.println("Suggested Post: verifying the user suggested post page");
	Assert.assertTrue(endUserSuggestedContentPost.verifyUserSuggestedPost().contains("User suggested post"));

	System.out.println("Suggested Post: verifying the user suggested page post publish");
	Assert.assertTrue(endUserSuggestedContentPost.verifyUserSuggestedPostPublish());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
