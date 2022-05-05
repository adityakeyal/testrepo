package com.javatpoint.springbootdevtoolsexample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
public class SpringBootDevtoolsExampleApplication 
{
public static void main(String[] args) 
{
SpringApplication.run(SpringBootDevtoolsExampleApplication.class, args);
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



}

