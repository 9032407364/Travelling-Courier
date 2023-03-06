package com.travelingcourier.traveler.feign;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyFilter implements Filter {

    @Autowired
    private AuthClient authClient;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {


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
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        chain.doFilter(request, response);
    }
}
