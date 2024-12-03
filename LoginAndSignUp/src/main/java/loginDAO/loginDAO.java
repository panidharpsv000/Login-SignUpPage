package loginDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import ModelObject.ModelObject;

public class loginDAO {
	String url="jdbc:mysql://localhost:3306/saitama";
	String user="root";
	String password="301112";
    private Connection generateCon()
    {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
			return  DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			return null;}
    }
	public boolean checkExists(ModelObject m1) {
		try
		{
			String query="SELECT COUNT(id) AS id FROM UserData WHERE id=? AND password=?";
		    Connection con=generateCon();
		    PreparedStatement st=con.prepareStatement(query);
		    st.setInt(1, m1.getId());
		    st.setString(2, m1.getPassword());
		    ResultSet rs=st.executeQuery();
		    rs.next();
		    if(rs.getInt("id")==1) return true;
		    else return false;
		}catch(Exception e) {
		return false;}
	}
	public void addData(ModelObject m1) {
		try
		{
			String query="INSERT INTO UserData VALUES(?,?,?)";
		    Connection con=generateCon();
		    PreparedStatement st=con.prepareStatement(query);
		    st.setInt(1, m1.getId());
		    st.setString(2, m1.getPassword());
		    st.setString(3, m1.getName());
		    int x=st.executeUpdate();
		    
		}catch(Exception e) {}
		
	}
	public String getName(int id)
	{
	   try
	   {
		   Connection con=generateCon();
		   String query="SELECT name FROM UserData WHERE id="+id;
		   Statement st=con.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   rs.next();
		   return rs.getString("name");
	   }catch(Exception e) {return ""; }
	}

}
