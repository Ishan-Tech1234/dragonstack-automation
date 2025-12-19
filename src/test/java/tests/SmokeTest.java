package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void openApplicationTest() throws InterruptedException {
        System.out.println("Dragonstack opened successfully");
            Thread.sleep(5000);
    }
}

