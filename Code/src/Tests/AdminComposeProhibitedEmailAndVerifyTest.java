package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.AdminComposeProhibitedEmailAndVerify;
import PageObjects.BasePage;
import PageObjects.SignInPage;

public class AdminComposeProhibitedEmailAndVerifyTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyAdminEmailwithNotes(String username, String password) throws InterruptedException {
	System.out.println("Admin / User Prohibited Email verification");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	AdminComposeProhibitedEmailAndVerify adminComposeProhibitedEmailAndVerify = new AdminComposeProhibitedEmailAndVerify(driver);
	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Check the email form
	Assert.assertTrue(adminComposeProhibitedEmailAndVerify.verifyNewEmailForm());

	// Open email form again
	System.out.println("Admin User: Compose prohibited email");
	Assert.assertTrue(adminComposeProhibitedEmailAndVerify.composeProhibitedEmailOnAdmin());

	// Verify email notes on user
	System.out.println("Agent: Verify prohibited email");
	Assert.assertFalse(adminComposeProhibitedEmailAndVerify.verifyProhibitedEmailOnUser());

	driver.close();
    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
