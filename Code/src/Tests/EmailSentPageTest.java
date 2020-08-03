package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.EmailSentPage;
import PageObjects.SignInPage;

public class EmailSentPageTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyEmailSettings(String username, String password) throws Exception {
	System.out.println("Email sent page and verification");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	EmailSentPage emailSentPage = new EmailSentPage(driver);
	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Check the email form
	System.out.println("Email sent page verification");
	Assert.assertTrue(emailSentPage.verifyEmailSentPage());

	driver.close();
    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
