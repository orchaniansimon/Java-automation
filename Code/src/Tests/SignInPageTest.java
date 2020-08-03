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

public class SignInPageTest extends TestBaseSetup {
    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @Test
    @Parameters({ "stagingUsername", "stagingPassword" })
    public void verifySignInFunction(String username, String password) {
	System.out.println("Sign In page");

	driver = getDriver();
	basePage = new BasePage(driver);
	signInPage = basePage.clickSignInBtn();
	Assert.assertTrue(signInPage.verifySignInPageTitle(), "Sign In page title doesn't match");
	Assert.assertTrue(signInPage.verifySignInPageText(), "Page text not matching");
	Assert.assertTrue(signInPage.verifyLinkedInUrl());
	Assert.assertTrue(signInPage.verifySignIn(username, password), "Unable to sign in");

	driver.close();

    }

    @AfterTest
    public void tearDown() {
	driver.quit();
    }

}
