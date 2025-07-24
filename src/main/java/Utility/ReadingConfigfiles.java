package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingConfigfiles {
public String getBrowsername() throws IOException
{
	FileInputStream fin=new FileInputStream("C:\\Users\\vijay\\eclipse-workspace\\Sampleframework\\Object reposiratory\\config.properties");
   Properties prop=new Properties();
   prop.load(fin);
   return prop.getProperty("Browser");
}
public String getLink() throws IOException
{
	FileInputStream fin=new FileInputStream("C:\\Users\\vijay\\eclipse-workspace\\Sampleframework\\Object reposiratory\\config.properties");
   Properties prop=new Properties();
   prop.load(fin);
   return prop.getProperty("URL");
}
}
