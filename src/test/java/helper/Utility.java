package helper;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility 
{
	public static ResultSet executeSQLQuery(String query)
	{
		Connection conn = null;
		ResultSet rs = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://183.82.118.175:3306/qtpdb01","qttester","qttester");
			
			Statement smt = conn.createStatement();
			
			rs = smt.executeQuery(query);			
			
		} 
		catch (Exception e) 
		{
			System.out.println("Exception is "+e.getMessage());		
		}
		/*finally
        {
        	 try 
        	 {
        		 if(conn != null)
  	             conn.close();
        	 }
	         catch(SQLException e) {
	         e.printStackTrace();
	         } 
        }*/
		
		return rs;
	}
	
	
	public static String captureScreenShot(WebDriver driver, String screenShotName)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		Date dt = new Date();
		
		SimpleDateFormat ft = new SimpleDateFormat("ddMMyyyy hhmm");
		
		String destination = System.getProperty("user.dir")+"/ScreenShots/"+screenShotName+"_"+ft.format(dt)+".png";
		
		try 
		{
			FileUtils.copyFile(src, new File(destination));
		} catch (Exception e) {
			System.out.println("Failed to capture screenshot -"+e.getMessage());
		}
		
		return destination;
	}
	
	public static String captureScreenShot(String screenShotName)
	{
		String destination=null;
		try 
		{
			BufferedImage image;
		
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			
			Date dt = new Date();
			
			SimpleDateFormat ft = new SimpleDateFormat("ddMMyyyy hhmm");

			destination = System.getProperty("user.dir")+screenShotName+"_"+ft.format(dt)+".png";
			
			ImageIO.write(image, "png", new File(destination)); 
		} 
		 catch (Exception e) 
		{
			System.out.println("Exception while capturing screenshot "+e.getMessage());
		}	    	
		
		return destination;
	}

}
