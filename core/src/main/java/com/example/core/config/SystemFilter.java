package com.example.core.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebFilter(urlPatterns = {"/api/*"}, filterName = "SystemFilter")
public class SystemFilter implements Filter {
    /**
     * 容器加载的时候调用
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init SystemFilter");
    }

    /**
     * 请求被拦截时调用
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter SystemFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String token = request.getHeader("token");
        if (Objects.nonNull(token)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect("index.html");
            return;
        }
    }

    /**
     * 容器被销毁时调用
     */
    @Override
    public void destroy() {
        System.out.println("destroy SystemFilter");
    }
}
