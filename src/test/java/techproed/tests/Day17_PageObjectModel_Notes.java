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
> It holds the test data: url, username, password, browser etc.
   e.g. instead of Driver.getDriver().get("https://www.techproeducation.com"); we use driver.get(url) in test classes
> WE basically define key and value pairs in config file and call them in the test classes
> used to STORE IMPORTANT DATA
   e.g.
         > url = https://www.techproeducation.com
         > browser = chrome
         > username = manager
         > password = pass
         > name = Ali

   Used by not only for testers but also for developers.
   We use JAVA to read this file.
> This file makes the CODE dynamic (e.g we need to change,  just change config url)
> Keeps Test classes clean
> Static block is used to instantiate Properties file



 */

}
