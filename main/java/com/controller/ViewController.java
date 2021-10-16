package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;

import com.model.dao.BlogDAO;
import com.model.dto.Blog;


/**
 * 게시글 보기 
 *
 */
public class ViewController extends HttpServlet {
	
	private static final long serialVersionUID = 2407700498643200315L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		RequestDispatcher rd = request.getRequestDispatcher("/blog/view.jsp");
		rd.include(request, response);
	}
}