package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignupPage;

import helper.uniqueCredentials;

public class SignupTest extends BaseTest {
    @Test
    public void signupTest(){
        SignupPage signupPage = new SignupPage(driver);
        String username = uniqueCredentials.uniqueCredential();
        String password = uniqueCredentials.uniqueCredential();
        signupPage.enterUsername(username);
        signupPage.enterPassword(password);
        signupPage.submitSignup();
        boolean buttongroupVisible = signupPage.isCreateDragonButtonVisible();
        boolean errormessageVisible = signupPage.isSignupErrorVisible();
        Assert.assertTrue(buttongroupVisible,"Create new Dragon Dashboard visible");
        Assert.assertFalse(errormessageVisible,"encountered error while signing in");
    }
}
