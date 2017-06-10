package org.jimmutable.adpanda;

import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
    public static void main( String[] args ) throws Exception
    {
        Properties p = new Properties();
        
        p.setProperty("access_token", "bar");
        p.setProperty("baz", "bar");
        
        p.storeToXML(System.out, "Hello World");
    }
}
