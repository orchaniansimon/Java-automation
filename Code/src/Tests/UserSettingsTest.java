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
import PageObjects.UserSettings;

public class UserSettingsTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyUserSettings(String username, String password) throws InterruptedException {
	System.out.println("User profile user settings link and page verification");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	UserSettings userSettings_NYL = new UserSettings(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Check the email form
	System.out.println("User profile user settings link: User settings page verification ");
	Assert.assertTrue(userSettings_NYL.verifyUserSettings());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
