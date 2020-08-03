package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import PageObjects.BasePage;

public class BasePageTest extends TestBaseSetup {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
	driver = getDriver();
    }

    @Test
    public void verifyHomePage() {
	System.out.println("Home page");
	BasePage basePage = new BasePage(driver);
	Assert.assertTrue(basePage.verifyBasePageTitle(), "Home page title doesn't match");
    }

    @Test
    public void verifyLinkedInButtons() {
	BasePage basePage = new BasePage(driver);
	Assert.assertTrue(basePage.verifyLinkedInButton());
    }

    @Test
    public void verifyFacebookButtons() {
	BasePage basePage = new BasePage(driver);
	Assert.assertTrue(basePage.verifyFacebookButton());
    }

    @AfterClass
    public void tearDown() {
	driver.quit();
    }

}