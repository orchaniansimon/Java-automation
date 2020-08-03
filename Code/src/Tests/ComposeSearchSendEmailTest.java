package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.ComposeSearchSendEmail;
import PageObjects.SignInPage;

public class ComposeSearchSendEmailTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyConnectAccountsTest(String username, String password) throws InterruptedException {
	System.out.println("Compose, Search, and Send email verification");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	ComposeSearchSendEmail composeSearchSendEmail = new ComposeSearchSendEmail(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Check the email form
	System.out.println("Connect Accounts and verify - V2");
	Assert.assertTrue(composeSearchSendEmail.verifyComposeSearchSendEmail());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
