package org.hometask.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/admin/*")
public class FilterAdminServlet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String role = (String) req.getSession().getAttribute("role");
        if (role==null) {
            resp.sendRedirect("/");
        } else {
            switch (role){
                case ("admin"):chain.doFilter(request, response);
                break;
                case ("user"):resp.sendRedirect("/");
            }
        }
    }
}
