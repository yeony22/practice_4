package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/*")
// ����ڰ� � ��û�̵� �̰��� ����
public class CharacterEncodingFilter implements Filter {

	final private String charset = "utf-8";
	FilterConfig config;
	
    public CharacterEncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("���� ����� �� �� �� ȣ��");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("�ش� ������ ���� ��û�� ���� �� ���� ȣ��");
		
		// ��½� �ѱ��� ������ �� �����ϱ� ���� ������ ���ӽø��� utf-8�� ����
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		System.out.println("���� ���� �� �� �� �� ȣ��");
		
		this.config = config;
	}

}
