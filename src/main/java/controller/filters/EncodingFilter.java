package controller.filters;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if(request.getCharacterEncoding() == null || response.getCharacterEncoding() == null){
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
