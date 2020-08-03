package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.AdminHierarchy;
import PageObjects.BasePage;
import PageObjects.SignInPage;

public class AdminHierarchyTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;
    // private AdminHierarchy adminHierarchy;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyAdminHierarchyPage(String username, String password) throws InterruptedException {
	System.out.println("Admin hierarchy page");

	driver = getDriver();
	BasePage basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	AdminHierarchy adminHierarchy = new AdminHierarchy(driver);
	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// verify the hierarchy link, page, and workspace and hierarchy manager buttons
	System.out.println("Admin hierarchy: verifying the navigation bar");
	Assert.assertTrue(adminHierarchy.verifyNavBar());
	Assert.assertTrue(adminHierarchy.verifySecondaryNavBar());
	Assert.assertTrue(adminHierarchy.clickOnHierarchyLink(), "Hierarchy link doesn't exist");

	System.out.println("Admin hierarchy: verifying hierarchy page and buttons");
	Assert.assertTrue(adminHierarchy.getHierarchyPage());
	Assert.assertTrue(adminHierarchy.getHierarchyButton());

    }

    public void verifyHierarchyButtonAndSearchUserLink(String username, String password) throws InterruptedException {

	BasePage basePage = new BasePage(driver);
	SignInPage signInPage = basePage.clickSignInBtn();

	AdminHierarchy adminHierarchy = new AdminHierarchy(driver);
	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	System.out.println("Admin hierarchy: verifying the hierarcy page workspace button");
	Assert.assertTrue(adminHierarchy.getHierarchyWorkspaceButton());

	System.out.println("Admin hierarchy: verifying hierarchy page search users link");
	Assert.assertTrue(adminHierarchy.getSearchUsersLink());

	// driver.close();

    }

    @AfterClass
    public void tearDown() {
	driver.quit();
    }
}
