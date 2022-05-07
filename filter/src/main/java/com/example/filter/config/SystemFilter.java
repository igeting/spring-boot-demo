package com.example.filter.config;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "systemFilter", urlPatterns = "/*")
public class SystemFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //todo
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
