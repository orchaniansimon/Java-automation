package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;
import PageObjects.EditNewContact_V2;
import PageObjects.SignInPage;

public class EditNewContactTest_V2 extends TestBaseSetup {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifyEditContactViaSocialTab(String username, String password) throws InterruptedException {
	System.out.println("Edit new contact via Social tab and verify");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();

	EditNewContact_V2 editNewContact_V2 = new EditNewContact_V2(driver);

	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	// Check the email form
	System.out.println("Edit new contact with name, phone, email and verify - V2");
	Assert.assertTrue(editNewContact_V2.verifyEditNewContacts_V2());

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }
}
