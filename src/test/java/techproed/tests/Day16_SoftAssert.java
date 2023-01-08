package techproed.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day16_SoftAssert {
    @Test
    public void softAssert(){

        SoftAssert softAssert = new SoftAssert(); // Create softAssert object

        System.out.println("Line 11code");
        softAssert.assertEquals(3,5);  // Fails but it doesn't stop the execution of the next test
        System.out.println("Line 13 code");
        softAssert.assertEquals("apple", "orange"); // Fails
        System.out.println("Line 15 code");
        softAssert.assertTrue(false);
        System.out.println("Line 19 code");
        softAssert.assertAll();  // Marking the test case as FAILED or PASSED
                                  // If we don't use / or forget to use assertAll() in the end, all tests will pass despite having failures at many steps

        // verification vs validation?
        // verification is on test level; validation is on system/application level.
        // check requirements ==> verification
        // check expected and actual match==>validation

    }
}
