package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDatProvider 
{
	Properties pro;
	
	public ConfigDatProvider()
	{
		try 
		{
			pro = new Properties();
			pro.load(new FileInputStream(new File("E:\\Selenium-Workspace\\WorkSpace\\automation_framework\\Configuration\\config.properties")));
		} 
		catch (Exception e) 
		{
			System.out.println("Exception is "+e.getMessage());
		}		
	}
	
	public String getAppUrl()
	{
		return pro.getProperty("url");
	}
	
	public String getChromePath()
	{
		return pro.getProperty("chromePath");
	}
	
	public String getIEPath()
	{
		return pro.getProperty("IEPath");
	}
	
	public String getFFPath()
	{
		return pro.getProperty("FFPath");
	}

}
