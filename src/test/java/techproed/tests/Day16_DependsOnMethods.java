package techproed.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Day16_DependsOnMethods {
/*
Normally the tests are independent of each other. However, we can make them dependent.
By using (dependsOnMethods = "whichever class we want to depend on")

(dependsOnMethods = "....") is used to connect the two tests. The test mentioned inside
this parameter, will run first. If it passes, the dependent test will also pass.
if independent test fails, dependent test doesn't execute.

 */
    @Test
    public void homePage(){
        System.out.println("I'm on the Home Page.");
    }

    @Test
    public void searchPage(){
        System.out.println("I'm on the search page");
        // assertTrue(false);
    }

    @Test (dependsOnMethods = "searchPage")
    public void checkOUtPage(){
        System.out.println("I'm on the checkout page");
    }

    /*
dependsOnMethods = "searchPage"  -> connecting checkOutPage to searchPage
searchPage will execute right before checkOutPage
If searchPage PASS -> executes checkoutPage
If searchPage FAIL -> SKIP checkoutPage
 */



}
