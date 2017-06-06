package cs544.hap2_b;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet Filter implementation class OpenSessionInViewFilter
 */
public class OpenSessionInViewFilter implements Filter {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		Transaction tx = null;
		try {
			tx= sf.getCurrentSession().beginTransaction();
			chain.doFilter(request, response);
			tx.commit();
		} catch (RuntimeException e) {
			try {
				System.out.println("Printing");
				e.printStackTrace();
				tx.rollback();
			} catch (Exception ex) {
				System.out.println("Couldn't Roll Back"+ex);
			}
			throw e;
		}
		
		/*System.out.println("receiving request");
		chain.doFilter(request, response);
		System.out.println("sending response");*/
	}

	public void destroy() {
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
