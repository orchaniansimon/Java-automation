package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.CheckOrgsTabsPermissions;
import PageObjects.SignInPage;

public class CheckOrgsTabsPermissionsTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyOrgsTabsPermissionsTest(String username, String password) throws InterruptedException {
	System.out.println("Check Tabs visibility between Orgs and verify");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	CheckOrgsTabsPermissions checkOrgsTabsPermissions = new CheckOrgsTabsPermissions(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Check the email form
	System.out.println("Check Orgs Tabs Permissions - Admin");
	Assert.assertTrue(checkOrgsTabsPermissions.verifyAdminMainNavTabsOrg1479());
	Assert.assertTrue(checkOrgsTabsPermissions.verifyAdminMainNavTabsOrg1());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
