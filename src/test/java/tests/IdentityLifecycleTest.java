package tests;

import base.BaseTest;
import helper.uniqueCredentials;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loginpage;
import pages.SignupPage;

import java.util.UUID;

public class IdentityLifecycleTest extends BaseTest {
    @Test
    public void identityTest() {
        String username = uniqueCredentials.uniqueCredential();
        String password = uniqueCredentials.uniqueCredential();
        SignupPage signupPage = new SignupPage(driver);
        signupPage.enterUsername(username);
        signupPage.enterPassword(password);
        signupPage.submitSignup();
        boolean isCreateDragonVisible = signupPage.isCreateDragonButtonVisible();
        boolean isSignupErrorVisible = signupPage.isSignupErrorVisible();
        Assert.assertTrue(isCreateDragonVisible,"signup successfull create dragon button");
        Assert.assertFalse(isSignupErrorVisible,"error encountered while signup");
        signupPage.logoutButtonClick();
        boolean isLoginVisible = signupPage.isLoginVisible();
        Assert.assertTrue(isLoginVisible,"logout successfull");
        Loginpage loginPage = new Loginpage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.loginButtonClick();
        boolean isCreateDragonVisibleLogin = loginPage.isCreateDragonVisible();
        Assert.assertTrue(isCreateDragonVisibleLogin,"login successfull after login");
        loginPage.logoutButtonclick();
        boolean isLoginVisibleLogout = loginPage.isLoginButtonVisible();
        Assert.assertTrue(isLoginVisibleLogout,"logout successfull");
    }

}
