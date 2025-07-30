package com.ruoyi.framework.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class HttpMethodLoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (request instanceof HttpServletRequest) {
            HttpServletRequest req = (HttpServletRequest) request;
            String method = req.getMethod();
            String uri = req.getRequestURI();
            String ip = request.getRemoteAddr();

            if ("PROPFIND".equalsIgnoreCase(method)) {
                System.out.println("🚨 [PROPFIND DETECTED] Method: " + method + " | URI: " + uri + " | IP: " + ip);
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
