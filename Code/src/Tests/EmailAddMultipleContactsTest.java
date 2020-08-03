package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.SignInPage;
import PageObjects.EmailAddMultipleContacts;

public class EmailAddMultipleContactsTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyCreateContactViaSocialTab(String username, String password) throws InterruptedException {
	System.out.println("Compose email, add multiple contacts and verify");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	EmailAddMultipleContacts emailAddMultipleContacts = new EmailAddMultipleContacts(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Check the email form
	System.out.println("Compose email, add contact, preview email and verify variables");
	Assert.assertTrue(emailAddMultipleContacts.composeEmailAddMultipleContacts());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
