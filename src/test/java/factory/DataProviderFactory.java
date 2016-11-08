package factory;

import dataprovider.ConfigDatProvider;
import dataprovider.ExcelDataProvider;

public class DataProviderFactory 
{
	public static ConfigDatProvider getConfig()
	{
		return new ConfigDatProvider();
	}

	public static ExcelDataProvider getExcel()
	{
		return new ExcelDataProvider();
	}
}
