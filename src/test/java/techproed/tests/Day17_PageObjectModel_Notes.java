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
 */

}
