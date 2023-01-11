package techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //This class reads the configuration.properties file
    //Create Properties instance
    private static Properties properties;
    static {
        //path of the configuration file
        String path="configuration.properties";
        try {
            //Opening configuration.properties file using FileInputStream
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
            //close the file
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Following method will get the key from properties file,
    //And return the value as String
    //We create this method to read the file
    public static String getProperty(String key){
        String value=properties.getProperty(key);
        return value;
    }
    //TEST IF LOGIC WORKS
//    public static void main(String[] args) {
//        System.out.println(properties.getProperty("browser"));
//    }
}

/*
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
> Static block is used in ConfigReader class to instantiate Properties file
 */
// static block works first whenever the class loads