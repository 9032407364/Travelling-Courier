package com.travelingcourier.feign;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class AuthFilter implements Filter {

    @Autowired
    private AuthClient authClient;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest1 = (HttpServletRequest) request;
        System.out.println(httpRequest1.getRequestURI());


            System.out.println("verify stage-1");
            HttpServletRequest httpRequest = (HttpServletRequest) request;

            String token = httpRequest.getHeader("Authorization");
        /*if(adminClient.valid(token)){System.out.println("naveen");}
        System.out.println(token);*/
        /*if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            System.out.println(token);

            if(!token.equals(adminClient.getAuthResponse().getToken())) {HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);return;
            }
        }*/
            if (authClient.valid(token)) {
                System.out.println("VAlid Token!!!!!!!!!");
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setHeader("Authorization",token);
            } else {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

        chain.doFilter(request, response);
    }
}
