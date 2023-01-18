package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day21_DataProvider1 {
    /*
    What is Data Provider?
    > Data Provider is used to get list of multiple data.
    > We can get data from external file such as excel or json files.
    > Data Provider is an annotation of testNG ONLY.
    > Data Provider is used to get credentials from excel sheet as well.

    -------------------------------------------------------------------
    How do you get data in your testNG Framework?
    > In Data Provider method, I use @DataProvider annotation, in test method, I give the method name in the parameter.
    > I can also use external files like Excel to get data for test cases.
    --------------------------------------------------------------------
    Data Provider has 2 parameters:
    1. name : used to give custom name for Data Provider. (OPTIONAL) e.g.  @DataProvider(name = "my_smoke_data") this name will override the
                                                           method's name ..so we have to use this name .. see example Method1
    2. parallel : used to do parallel testing. Default is parallel = false. We can make parallel = true.
        We'll learn this later.

    > @DataProvider annotation works like a loop

     */

    // DATA PROVIDER METHOD
    @DataProvider(name = "my_smoke_data")
    public Object[][] customerData(){  // return type is 2D array
        // Test Data
        Object [][] customersCredentials = {
                {"sam.walker@bluerentalcars.com","c!fas_art"},
                {"kate.brown@bluerentalcars.com","tad1$Fas"},
                {"raj.khan@bluerentalcars.com","v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com","Nga^g6!"}
        };
        return customersCredentials;
    }

    // Test Method 1
    @Test(dataProvider = "my_smoke_data") // using customised name
    public void dataProviderTest1(String username, String password){
        System.out.println("Username: "+ username+ " | Password: "+ password);

    }

    // Test Method 2
    @Test(dataProvider = "customerData")  // adding name of the method from where we want to get data
    public void dataProviderTest2(String user, String pass){
        System.out.println(user+ " | "+pass);
    }

}
