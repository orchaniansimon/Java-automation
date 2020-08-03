package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.CreateContact_V1;
import PageObjects.SignInPage;

public class CreateContactTest_V1 extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyCreateContactViaSocialTab(String username, String password) throws InterruptedException {
	System.out.println("Admin / User Suggested Post with summarized link verification");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	CreateContact_V1 createContact_NYL = new CreateContact_V1(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Check the email form
	System.out.println("Create Contact via Mail Tab and verify on Social Tab");
	Assert.assertTrue(createContact_NYL.verifyAddNewContacts());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
