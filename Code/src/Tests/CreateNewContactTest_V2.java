package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.CreateNewContact_V2;
import PageObjects.SignInPage;

public class CreateNewContactTest_V2 extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyCreateContactViaSocialTab(String username, String password) throws InterruptedException {
	System.out.println("Create new contact via Social tab and verify");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	CreateNewContact_V2 createNewContact_V2 = new CreateNewContact_V2(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Check the email form
	System.out.println("Create new contact with name, phone, email and verify - V2");
	Assert.assertTrue(createNewContact_V2.verifyCreateNewContacts_V2());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
