package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.AdminEmailWithNotes;
import PageObjects.BasePage;
import PageObjects.SignInPage;

public class AdminEmailWithNotesTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;
    // private AdminHierarchy adminHierarchy;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyAdminEmailwithNotes(String username, String password) throws InterruptedException {
	System.out.println("Admin / User Email Notes verification");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	AdminEmailWithNotes adminEmailWithNotes = new AdminEmailWithNotes(driver);
	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// verify the hierarchy link, page, and workspace and hierarchy manager buttons

	// Check the email form
	Assert.assertTrue(adminEmailWithNotes.verifyNewEmailForm());

	// Fill out notes with overflow text > 300 characters
	System.out.println("Email Notes: verifying email form with overflow text");
	Assert.assertEquals(adminEmailWithNotes.composeEmailFormFilloutOverflow(), notesOverflowText);

	// Open email form again
	System.out.println("Email Notes: check new email form");
	Assert.assertTrue(adminEmailWithNotes.verifyNewEmailForm());

	// Fill out notes with text
	System.out.println("Email Notes: verifying email form with notes and contact information");
	Assert.assertTrue(adminEmailWithNotes.composeEmailFormFillout());

	// Verify email notes on user
	System.out.println("Email Notes: verifying email form on the user view");
	Assert.assertEquals(adminEmailWithNotes.verifySuggestedEmailPostedOnUser(), notesText);

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
