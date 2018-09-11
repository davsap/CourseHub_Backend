package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.CorsFilter;

/**
 * Servlet Filter implementation class CORSFilter
 */
//@WebFilter("/*")
public class CORSFilter  extends CorsFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CORSFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		((HttpServletResponse)servletResponse).addHeader("Access-Control-Allow-Origin","*");
		((HttpServletResponse)servletResponse).addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		((HttpServletResponse)servletResponse).addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
		((HttpServletResponse)servletResponse).addHeader("Access-Control-Max-Age", "3600");
		super.doFilter(servletRequest, servletResponse, filterChain);
	
	}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
