package fvm.control.filter;
/*
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;*/

//@WebFilter(servletNames = { "Faces Servlet" })
public class JPAFilter /*implements Filter*/ {
	/*

	private EntityManagerFactory factory;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.factory = Persistence.createEntityManagerFactory("FVM");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		EntityManager manager = factory.createEntityManager();
		request.setAttribute("EntityManager", manager);
		
		//manager.getTransaction().begin();
		
		chain.doFilter(request, response);
		
		

	}

	@Override
	public void destroy() {
		this.factory.close();
	}
	*/

}
