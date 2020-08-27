//package com.example.demo.cofig;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler{
//
//	@Override
//	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//			AuthenticationException exception) throws IOException, ServletException {
//		response.setStatus(HttpStatus.FORBIDDEN.value());
//		response.sendRedirect("/api/authFailure");
////	    Map<String, Object> data = new HashMap<>();
////	    data.put("timestamp", new Date());
////	    data.put("status",HttpStatus.FORBIDDEN.value());
////	    data.put("message", "Access Denied");
////	    data.put("path", request.getRequestURL().toString());
//	}
//
//}
