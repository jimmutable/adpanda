package org.jimmutable.adpanda.facebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

// Examples can be found in the GIT hub repository: https://github.com/facebook/facebook-java-ads-sdk

public class APISecrets 
{
	static private Properties secrets = null;
	
	static private File getSimpleFileProperties()
	{
		return new File(System.getProperty("user.home") + File.separator + "facebook_api_secrets.txt");
	}
	
	
	static public enum Key
	{
		ACCESS_TOKEN("fb_access_token"),
		APP_ID("fb_app_id"),
		APP_SECRET("fb_app_secret"),
		AD_ACCOUNT_ID("fb_add_account_id");
		
		private String code;
		
		private Key(String code)
		{
			this.code = code.toLowerCase().trim();
		}
		
		public String toString() { return code; }
		
		public String getSimpleCode() { return code; }
	}
	
	
	static public void printStubPropertiesFile() throws Exception
	{
		System.out.println("# This is the digital panda Facebook API Secrets File");
		System.out.println("#");
		System.out.println("# The contents of this file should *never* be incorporated into your source code");
		System.out.println("# Why? There are bots that scour the internet looking for these API keys/access tokens");
		System.out.println("#");
		System.out.println("# Place this file in your home directory.  On windows, to locate your home directory, echo %HOMEPATH%");
		System.out.println("#");
		System.out.println("# This file is read by java.util.Properties");
		System.out.println();
		
		
		
		
		System.out.println(String.format("%s=[facebook app id]", Key.APP_ID));
		System.out.println(String.format("%s=[facebook app secret]", Key.APP_SECRET));
		System.out.println();
		
		
		System.out.println("# How to create this token");
		System.out.println("# 1.)  Go to developers.facebook.com");
		System.out.println("# 2.)  In the upper right, click on My Apps, then click on Digital Panda");
		System.out.println("# 3.)  In the left bar, click Marketing API, then TOOLS");
		System.out.println("# 4.)  Check off ads_management and ads_read");
		System.out.println("# 5.)  Click the get token button");
		System.out.println();
		
		System.out.println(String.format("%s=[facebook access token here]", Key.ACCESS_TOKEN));
		System.out.println();
		
		
		System.out.println(String.format("%s=[facebook ad account id]", Key.AD_ACCOUNT_ID));
		System.out.println();
	}
	
	synchronized static public String getSecret(Key key, String default_value)
	{
		if ( secrets == null )
		{
			secrets = new Properties();
			
			try
			{
				secrets.load(new FileReader(getSimpleFileProperties()));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Unable to read the api secrets file "+getSimpleFileProperties().getAbsolutePath());
				return default_value;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		String ret = secrets.getProperty(key.getSimpleCode());
		if ( ret == null ) return default_value;
		return ret;
	}
	
	static public void main(String args[]) throws Exception
	{
		printStubPropertiesFile();
	}
}
