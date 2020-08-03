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
import PageObjects.WorkspaceSettings;

public class WorkspaceSettingsTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyWorkspaceSettings(String username, String password) throws InterruptedException {
	System.out.println("User profile workspace settings link and page verification");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	WorkspaceSettings workspaceSettingsTest = new WorkspaceSettings(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Check the email form
	System.out.println("User profile workspace settings link: Workspace settings page verification ");
	Assert.assertTrue(workspaceSettingsTest.verifyUserWorkspaceSettings());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
