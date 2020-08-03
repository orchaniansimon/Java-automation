package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.EmailLibrary;
import PageObjects.SignInPage;

public class EmailLibraryTest extends TestBaseSetup {
    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyEmailLibrary(String username, String password) throws InterruptedException {
	System.out.println("Email Library page");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	EmailLibrary emailLibrary = new EmailLibrary(driver);
	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// verify the hierarchy link, page, and workspace and hierarchy manager buttons
	Assert.assertTrue(emailLibrary.verifyNavBar());
	Assert.assertTrue(emailLibrary.verifySecondaryNavBar());

	// verify the link, page, tiles, and filter link
	Assert.assertTrue(emailLibrary.clickOnEmailLibraryLink(), "Hierarchy link doesn't exist");
	Assert.assertTrue(emailLibrary.getEmailLibraryPage());
	Assert.assertTrue(emailLibrary.getEmailLibraryTiles());
	Assert.assertTrue(emailLibrary.getEmailLibraryFilterLink());

	Assert.assertTrue(emailLibrary.clickEmailLibraryTile());

	System.out.println("Email Library: vverifying the email library tile composer overlay");
	Assert.assertTrue(emailLibrary.verifyEmailTileComposerOverlay());

	System.out.println("Email Library: verifying the email library tile notes container");
	Assert.assertTrue(emailLibrary.verifyEmailTileNotesContainer());

	System.out.println("Email Library: verifying the email library recipient form field");
	Assert.assertTrue(emailLibrary.verifyRecipientFormField());

	System.out.println("Email Library: verifying the email library contact name");
	Assert.assertTrue(emailLibrary.setContactName());

	System.out.println("Email Library: verifying the email sent");
	Assert.assertTrue(emailLibrary.sendNewEmail());

	driver.close();
    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }

}
