package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.CheckTopNavMenuChoices;
import PageObjects.SignInPage;

public class CheckTopNavMenuChoicesTest extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyTopNavigationMenuChoices(String username, String password) throws InterruptedException {
	System.out.println("Admin check top navigation menu choices");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	CheckTopNavMenuChoices checkTopNavMenuChoices = new CheckTopNavMenuChoices(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	System.out.println("Admin check top nav menu choices: verifying the create menu options");
	Assert.assertTrue(checkTopNavMenuChoices.verifyCreateLinkMenuChoices());

	System.out.println("Admin check top nav menu choices: verifying the review menu options");
	Assert.assertTrue(checkTopNavMenuChoices.verifyReviewLinkMenuChoices());

	System.out.println("Admin check top nav menu choices: verifying the organization menu options");
	Assert.assertTrue(checkTopNavMenuChoices.verifyOrganizationLinkMenuChoices());

	System.out.println("Admin check top nav menu choices: verifying the settings menu options ");
	Assert.assertTrue(checkTopNavMenuChoices.verifySettingsLinkMenuChoices());

	System.out.println("Admin check top nav menu choices: verifying the settings menu options ");
	Assert.assertTrue(checkTopNavMenuChoices.verifyAnalyzeLinkMenuChoices());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
