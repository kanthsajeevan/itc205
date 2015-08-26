package datamanagement;
import java.util.*;
import java.io.*;
public class AppProperties {
private static AppProperties instance_ = null;
private Properties properties;

public static AppProperties getInstance() {
//Incorrect lazy initialization of static field    
if (instance_ == null ) {
    instance_ = new AppProperties(); 
} 
return instance_;
}

private AppProperties() {
    properties = new Properties();
    try {
        properties.load(new FileInputStream("Properties.prop"));
        //Method may fail to clean up stream or resource
        //Method may fail to close stream
    } 
    catch (IOException e) {
        throw new RuntimeException("Could not read property file");
    }
}
    public Properties getProperties() {
        return properties;
    }
}
