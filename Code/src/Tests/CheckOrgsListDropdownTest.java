package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.CheckOrgsListDropdown;
import PageObjects.SignInPage;

public class CheckOrgsListDropdownTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyWorkspaceDropdownTest(String username, String password) throws InterruptedException {
	System.out.println("Check the orgs list drop down choices and verify");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	CheckOrgsListDropdown checkOrgsListDropdown = new CheckOrgsListDropdown(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Check the email form
	System.out.println("Check Workspace Dropdown - Admin & Social");
	Assert.assertTrue(checkOrgsListDropdown.verifyAdminWorkspaceDropdown());
	Assert.assertTrue(checkOrgsListDropdown.verifySocialWorkspaceDropdown());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
