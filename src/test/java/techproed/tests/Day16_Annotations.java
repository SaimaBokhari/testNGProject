package techproed.tests;

import org.testng.annotations.*;

public class Day16_Annotations {
/*
suite > test > group > class > method

@Test : creates test case
@Before and @After  : 10 before and after annotations. They're used to control FLOW
and DESIGN of the tests
@Ignore : to skip a test case
@Test(enabled = false) .. only in TestNG.. STRONGER THAN Ignore
@Test (priority = given number) : prioritise / orders the test case execution
NOTE: The test that has no priority parameter, will be run first by default as if (priority = 0)

TestNG test cases runs in alphabetical order by default, but we can prioritise if we want.
We can also use negative numbers in our priority parameter.
-3, 0, (Test with no priority), 1,3,5 etc...

We should use priority when there are multiple test cases in the same class.

REMEMBER: This priority is not about "the most important test case/the highest priority test", this priority is about the order in which
we want to run the tests.


 */

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTestt() {
        System.out.println("After Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }


    @Test (priority = 2)
    public void test1(){
        System.out.println("test1");
    }

    @Ignore
    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test(enabled = false)
    public void test3(){
        System.out.println("test3");
    }

    @Test (priority = 3)
    public void test4(){
        System.out.println("test4");
    }

    @Test (priority = 1)
    public void test5(){
        System.out.println("test5");
    }

    @Test
    public void test6(){
        System.out.println("test6");
    }

}
