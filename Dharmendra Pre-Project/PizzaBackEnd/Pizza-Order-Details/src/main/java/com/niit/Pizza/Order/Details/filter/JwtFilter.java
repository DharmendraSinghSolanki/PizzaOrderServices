package com.niit.Pizza.Order.Details.filter;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//This class extends GenericFilterBean,
// which is a class provided by Spring Framework for creating custom servlet filters.
// It overrides the doFilter method from the GenericFilterBean class.
// The doFilter method is called by the servlet container when a request is made to the web application.
public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse= (HttpServletResponse) servletResponse;
        String authHeader=httpServletRequest.getHeader("Authorization");
        System.out.println("Auth Header "+authHeader);
        ServletOutputStream servletOutputStream= servletResponse.getOutputStream();
        if (authHeader==null || !authHeader.startsWith("Bearer"))
        {
            //invalid user
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            servletOutputStream.print("Invalid token or missing token");
            servletOutputStream.close();
        }
        else
        {
            // valid User
            String jwtToken=authHeader.substring(7);
            System.out.println("Jwt Token "+jwtToken);
            String username= Jwts.parser().setSigningKey("securityKey").parseClaimsJws(jwtToken).getBody().getSubject();
            httpServletRequest.setAttribute("First name", username);
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

}
// JWTs from the "Authorization" header, validate them, and set user information as a request attribute.
// It provides a means to secure endpoints and authenticate users based on JWTs in a web application.
//After successfully parsing the JWT, the code extracts the subject (usually representing the user)
// from the JWT's claims and sets it as a request attribute with the name "First name."