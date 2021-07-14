package met.web.app;

import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class CustomerBean implements java.io.Serializable{

    private String custId;

	private String password;

	private String email;

	private double credit;

	public final String getId(){return custId;}

	public String getCustId() {return custId;}
	public void setCustId(String value){ custId=value;}

	public String getPassword() {return password;}
	public void setPassword(String value){ password = value;}

	public String getEmail() {return email;}
	public void setEmail(String value){ email=value;}

	public double getCredit() {return credit;}
	public void setCredit(double value) { credit = value;}

	public boolean authenticate(String customerId, String password){
	      try{
			  Context naming = (Context) new InitialContext().lookup("java:comp/env");
	           DataSource ds = (DataSource)naming.lookup("java:jdbc/SalesDB");
	           try(Connection con = ds.getConnection()){
	                PreparedStatement pstmt = con.prepareStatement("select count(cust_id) from customers where cust_id=? and pwd=?");
	                pstmt.setString(1, customerId);
	                pstmt.setString(2, password);
	                ResultSet rs = pstmt.executeQuery();
	                rs.next();
	                int count = rs.getInt(1);
	                rs.close();
	                pstmt.close();
	                if(count > 0){
       				custId = customerId;
	                    return true;
	                }
					custId = null;
					return false;
					}
				}catch(Exception e){
				    throw new RuntimeException(e);
			   }
		}

	public boolean Register(){
		try{
	           Context naming = (Context) new InitialContext().lookup("java:comp/env");
	           DataSource ds = (DataSource)naming.lookup("jdbc/SalesDB");
	           try(Connection con = ds.getConnection()){
	                PreparedStatement pstmt = con.prepareStatement("insert into customers values (?, ?, ?, ?)");
	                pstmt.setString(1, custId);
	                pstmt.setString(2, password);
					pstmt.setString(3, email);
					pstmt.setDouble(4, credit);
	                int count = pstmt.executeUpdate();
	                pstmt.close();
	                if(count > 0){
	                    return true;
	                }
					return false;
					}
				}catch(Exception e){
				    throw new RuntimeException(e);
			   }	
			}
}
