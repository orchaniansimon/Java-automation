package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.EmailSettings;
import PageObjects.SignInPage;

public class EmailSettingsTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyEmailSettings(String username, String password) throws InterruptedException {
	System.out.println("User profile email settings link and page verification");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	EmailSettings emailSettings = new EmailSettings(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Check the email form
	System.out.println("User profile email settings link: Email settings page verification ");
	Assert.assertTrue(emailSettings.verifyUserEmailSettings());

	driver.close();
    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
