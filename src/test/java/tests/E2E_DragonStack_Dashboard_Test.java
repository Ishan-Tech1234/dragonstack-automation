package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.E2E_DragonStack_Dashboard;

public class E2E_DragonStack_Dashboard_Test extends BaseTest {
    @Test
    public void E2E_DashboardTest(){
        E2E_DragonStack_Dashboard page = new E2E_DragonStack_Dashboard(driver);
        page.authenticateUser();
        page.clickButtonCreateDragon();
        boolean createdDragonSuccessfully = page.createDragonSuccessfull();
        Assert.assertTrue(createdDragonSuccessfully,"Dragon creation successfull");
        page.clickLogoutButton();
    }
}
