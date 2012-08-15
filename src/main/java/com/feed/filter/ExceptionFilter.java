package com.feed.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.seasar.framework.log.Logger;

import com.feed.exception.NoLoginException;

/**
 * 例外をキャッチして画面遷移するクラスです。
 * 
 * @author ykitano
 */
public class ExceptionFilter implements Filter {

    private static final Logger logger = Logger
	    .getLogger(ExceptionFilter.class);

    private ServletContext context;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain filterChain) throws IOException, ServletException {

	try {
	    filterChain.doFilter(request, response);
	} catch (NoLoginException le) {
	    logger.error(le);

	    RequestDispatcher dispatcher = context
		    .getRequestDispatcher("/login.do");

	    dispatcher.forward(request, response);

	} catch (Exception ex) {
	    logger.error("エラーが発生しました。", ex);

	    RequestDispatcher dispatcher = context
		    .getRequestDispatcher("/WEB-INF/view/error/error.jsp");

	    dispatcher.forward(request, response);
	}

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
	this.context = config.getServletContext();
    }

    @Override
    public void destroy() {
    }

}
