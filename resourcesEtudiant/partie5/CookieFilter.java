package org.epsi.b3.simplewebapp.filter;

import org.epsi.b3.simplewebapp.user.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
@Component
public class CookieFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(CookieFilter.class.getName());

    @Autowired
    private UserManager userManager;
 
    public CookieFilter() {
    }
 
    @Override
    public void init(FilterConfig fConfig) {
 
    }
 
    @Override
    public void destroy() {
 
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        /*
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
 
	// To retrieve / store cookies :
	// request.getCookies()
	//
	// new Cookie(...)
	// response.addCookie(...)
	
	// To retrieve / store information in the session :
	// session.getAttribute(...)
	// session.setAttribute(...)
        */

        chain.doFilter(request, response);
    }
 
}
