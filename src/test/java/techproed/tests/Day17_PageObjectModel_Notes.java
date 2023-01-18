package techproed.tests;

public class Day17_PageObjectModel_Notes {
    /*

Page Object Model (POM)

1) Set up the folders:
     a. Tests
     b. Pages
     c. Utilities
2) Set up classes
     >  Reusable classes
3) Set up Files
     a. Configuration files
     b. Report files

In POM, we create a  Driver class - Singleton Driver

> We create Driver class in our utilities package to create and initialise driver.
> The Driver class will return ONE SINGLE STATIC DRIVER that is being shared in all classes.
> Driver class makes the driver reusable across all classes in the project.
> When ever Singleton Driver class instantiated, this Driver class will return the
  same Driver again and again. This is called SINGLETON DESIGN PATTERN.
> Why is it good? We don;t need to use system.getProperty, webDriverManager etc.
  So it is similar to TestBase class in JUnit.

Question: Where do you use 'static' keyword in your framework?
Answer: In my Driver Class. Our Driver is static, so it can be shared across the framework
(or so driver instance can be used globally in the framework.)


In POM, we create Properties File

> Properties is a file with .properties extension
> It holds the test data: url, username, password, browser etc. even the invalid that can be used in the tests
   e.g. instead of Driver.getDriver().get("https://www.techproeducation.com"); again and again in each test class,
    we, store url=https://www.techproeducation.com in properties file, then we just use driver.get(url) in test classes.

> Create a File on project level >New>File>configuration.properties
> WE basically define key and value pairs in config file and call them in the test classes
> used to STORE IMPORTANT DATA
   e.g.
         > url = https://www.techproeducation.com
         > browser = chrome
         > username = manager
         > password = pass
         > name = Ali

   Used not only by testers but also by developers.
   We use JAVA to read this file.
> This file makes the CODE dynamic (e.g we need to change,  just change config url)
> Keeps Test classes clean
> Static block is used to instantiate Properties file
> We create a ConfigReader class to read the DATA from files (key=value structure)

In POM, Page classes are created to locate and save webElements for once and make the
reusable to be used in the test classes.
Page Factory is used to instantiate the Page element and calling the driver

REUSABLE METHODS:
Same as JUnit.. in functionality
But the difference is in TestNG reusable methods in  a different class in utility package
Benefits:
saves time, clean test classes, avoid repetition, reduces mistakes, focus on test cases rather than creating more codes,
easy to debug, easy maintenance

PAGES are used to locate and store WEBELEMENTS


Benefits of POM:
> Easy to debug
> Clean coding
> Avoids repetition


Excel Automation:
> Apache poi library is used to work with Microsoft Files (put it in your pom.xml)
> Workbook > Sheet > Row > Cell

Excel Utils
> Reusable Methods (Recommended)
> Getting the list of data as List or Map or Array
> Getting the number of rows, columns, or writing on the Excel file
> That data will be used in the test classes
> This type of testing is called DATA DRIVEN TESTING. (Testing the application with multiple external data (coming from Excel)
> Coz Data generates new test cases

Test Data:
> Where do you get your testing data?
  BA(through FRD,BRD) , Test Lead, Tech Lead, Manual Tester, Developers
> How do you use the data in test cases?
  I always try to use data dynamically. Some data sources are:
     > External Files (Excel, Config.properties, Json, Xml etc.)
     > Database
     > API
     > Faker

Remember Config.properties sheet should only store most important data.

DATA PROVIDER:

> It's a functionality of TestNG ONLY.
> Used to provide data for the Test Cases. (like an external source Excel, however it's in the same class by using @DataProvider annotation before the method)
> The return type is 2D Array.
> There are 2 parameters we can pass.
   (OPTIONAL)
     > name : used for assigning custom method name
     > parallel : used for parallel testing
> DataProvider is used outside the Test annotation

TestNG xml file:
xml files are used for configuration, or custom setting or to add dependencies etc.
In TestNG, we use xml files to customise test groups/cases (specific test classes/groups, methods or packages etc.)
We can even include / exclude methods from the group of tests that we want to run
 SUITE > TEST > PACKAGE > GROUPS > CLASSES > METHODS > INCLUDE OR EXCLUDE

This kind of files can be used in other frameworks as well, but it won't work the same way as it does in TestNG

> Use Group annotation in test methods and configure xml file
> Running parallel test cases

TestNG xml file looks similar to html file, but they're actually different
https://testng.org/doc/documentation-main.html#testng-xml
XML FILE serves as another way of grouping the tests/classes/packages etc.  that we want to run
It runs in random order.


 */

}
