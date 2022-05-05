package com.javatpoint.springbootdevtoolsexample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5PasswordEncryptorImpl 
{
	
	public void envrypt() throws Exception{
		
	
byte[] barray= "test".getBytes(StandardCharsets.UTF_8);

		String restring = "";

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(barray);
		byte[] result = md.digest();

		System.out.println(result);
		
		
}

public void test(HttpServletResponse response){

		Cookie accessTokenCookie = new Cookie("access_token", "mysectret");
		
		accessTokenCookie.setHttpOnly(false);
		accessTokenCookie.setSecure(false);
		response.addCookie(accessTokenCookie);
		Cookie xsrfTokenCookie = new Cookie("XSRF-TOKEN","new secret");
		xsrfTokenCookie.setHttpOnly(false);
		response.addCookie(xsrfTokenCookie);
	
	
}

public void getUser(Connection con, String user) throws SQLException {

  Statement stmt1 = null;
  Statement stmt2 = null;
  PreparedStatement pstmt;
  try {
    stmt1 = con.createStatement();
    ResultSet rs1 = stmt1.executeQuery("GETDATE()"); // No issue; hardcoded query

    stmt2 = con.createStatement();
    ResultSet rs2 = stmt2.executeQuery("select FNAME, LNAME, SSN " +
                 "from USERS where UNAME=" + user);  // Sensitive

    pstmt = con.prepareStatement("select FNAME, LNAME, SSN " +
                 "from USERS where UNAME=" + user);  // Sensitive
    ResultSet rs3 = pstmt.executeQuery();

    //...
}catch(Exception ex){
	
}finally{
	
}

}







 private int getMaxWrongAttempts (Connection conn,String user) throws SQLException {
	 String QUERY_NUM_WRONG_ATTEMPT_VALIDATION= "select * from tablename where user = "+user;
    	ResultSet rs = null;
    	Statement st = null;
    	try{
    		st = conn.createStatement();
    		rs = st.executeQuery(QUERY_NUM_WRONG_ATTEMPT_VALIDATION);
    		if (rs.next())
    			return rs.getInt(1);
    		else // enterprise level config data missing, must throw error
    			throw new SQLException("Cannot populate number of wrong attempts from DB");
    	} finally {
    		//
    	}
    }
	
	
	
	}
