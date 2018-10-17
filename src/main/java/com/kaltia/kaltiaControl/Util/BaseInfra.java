package com.kaltia.kaltiaControl.Util;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class BaseInfra {
	
	public static Properties PROPS = loadProperties();
	
	public static Properties loadProperties() {
        Properties props = new Properties();
        //FileInputStream fis=null;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fis = classLoader.getResourceAsStream("KaltiaControl.properties");
        
        try {
          //fis = new FileInputStream("../../props/error.properties");
          //  fis = new FileInputStream("/opt/vun/tect2/properties/globals.properties");// properties QA
            props.load(fis);
        } catch (FileNotFoundException fnfException) {
            fnfException.printStackTrace();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return props;
    }
 

}
