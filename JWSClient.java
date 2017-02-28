import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class COMP5527JWS {
	public boolean postMessage(String uid, String pw, String loc, String msg)
	{
		if(checkUserExist(uid, pw))
			return insertMessage(uid, loc, msg);
		else
			return false;
	}
	public String getMessage(String uid, String pw, String loc)
	{
		if(checkUserExist(uid,pw))
			return retrieveMessage(uid, loc);
		else
			return "";
	}
	protected static final String NEWS_FILE_PATH = "/usr/local/tomcat/webapps/axis2/dailyNews.xml";
	protected static File fNewsXML;
	protected static Connection conn = null;
	
	public long getDailyNewsLastUpdateTime()
	{
		long lastModified = getNewsXMLFile().lastModified();
		return lastModified;
	}
	
	protected File getNewsXMLFile()
	{
		if(fNewsXML == null)
			fNewsXML  = new File(NEWS_FILE_PATH);
		return fNewsXML;
	}
	
	public COMP5527JWS()
	{
		getNewsXMLFile();	
	}
	
	public static void main(String[] args)
	{
		//for testing purpose
		COMP5527JWS comp = new COMP5527JWS();
		System.out.println(comp.getDailyNewsLastUpdateTime());
		System.out.println(comp.checkUserExist("1","abc"));
		System.out.println(comp.postMessage("3", "comp5527", "22.302339,114.176488", "Hello Marcus"));
		System.out.println(comp.getMessage("3", "comp5527", "22.302339,114.176488"));
	}
	
	protected Statement openConn()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/COMP5527","root","");
			return conn.createStatement();
		} 
		catch (Exception e) 
		{ 
			printErr(e);
			return null;
		}
	}
	protected void releaseResource()
	{
		try {
			if(conn!=null)
			{
				conn.close();
				conn = null;
			}
		}
		catch (SQLException e) { printErr(e); }
	}

	protected String retrieveMessage(String uid, String loc)
	{
		try{
			String[] _loc = loc.split(",");
			double lat = Double.parseDouble(_loc[0]);
			double lng = Double.parseDouble(_loc[1]);
			
			String sql = "SELECT display_name, content, timestamp "+
			"FROM `COMP5527`.`Message` msg, `COMP5527`.`User` usr WHERE "+
			"msg.User_uid = usr.uid AND "+
			"(loc_lat between "+(lat-0.01)+" AND "+(lat+0.01)+") AND "+
			"(loc_lng BETWEEN "+(lng-0.01)+" AND "+(lng+0.01)+") AND "+
			"(timestamp > Date_Sub(now(), INTERVAL 30 MINUTE)) LIMIT 10";
			
			Statement statement = openConn();
			ResultSet rs = statement.executeQuery(sql);
			if(rs.first())
			{
				String result = "<xml>";
				result += "<message><user>"+rs.getString("display_name")+"</user>";
				result += "<time>"+rs.getTime("timestamp")+"</time>";
				result += "<content>"+rs.getString("content")+"</content></message>";
				
				while(rs.next())
				{
					result += "<message><user>"+rs.getString("display_name")+"</user>";
					result += "<time>"+rs.getTime("timestamp")+"</time>";
					result += "<content>"+rs.getString("content")+"</content></message>";
				}
				
				result = result + "</xml>";
				return result;
			}
			else
				return "";
		}
		catch (Exception e)
		{
			printErr(e);
			releaseResource(); 
			return "";
		}
	}
	protected boolean insertMessage(String uid, String loc, String msg)
	{
		try{
			String[] _loc = loc.split(",");
			double lat = Double.parseDouble(_loc[0]);
			double lng = Double.parseDouble(_loc[1]);
			String sql = "INSERT INTO `COMP5527`.`Message`" +
			" (`mid`,`content`,`timestamp`,`User_uid`,`loc_lat`,`loc_lng`) " +
			"VALUES ( null, '"+msg+"', now(), "+uid+", "+lat+" , "+lng+")";
			
			printErr(sql);
			Statement statement = openConn();
			boolean result = statement.execute(sql);
			if(result==false)//result is an update count
			{
				if(statement.getUpdateCount()==1)
				{
					releaseResource();
					return true;
				}
				else
					return false;
			}
			else
			{
				releaseResource();
				return false;
			}
		}
		catch (Exception e) 
		{
			printErr(e); 
			releaseResource(); 
			return false;
		}
	}
	protected boolean checkUserExist(String usr, String pw)
	{
		try {
			ResultSet rs = openConn().executeQuery("SELECT * FROM User WHERE uid="+usr+" AND password='"+pw+"'");
			boolean exist = rs.first();
			releaseResource();
			return exist;
		} 
		catch (Exception e) { 
			printErr(e); 
			return false;
		}
	}
	
	protected void printErr(Exception err)
	{
		
		try {
			PrintWriter pw = new PrintWriter(new File("/Users/ferryto/Desktop/err.txt"));
			err.printStackTrace(pw);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	protected void printErr(String err)
	{
		try {
			PrintWriter pw = new PrintWriter(new File("/Users/ferryto/Desktop/str.txt"));
			pw.write(err);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
