package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.dao.BlogDAO;
import com.model.dto.Blog;

import javax.servlet.RequestDispatcher; 

public class WriteController extends HttpServlet {

	private static final long serialVersionUID = 4934981476431959947L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		req.setAttribute("action", "write");
	
		if (req.getParameter("idx") != null) {
		int idx = Integer.parseInt(req.getParameter("idx"));
		BlogDAO dao = new BlogDAO();
		Blog blog = dao.get(idx);
		req.setAttribute("blog", blog);
		}				
		RequestDispatcher rd = req.getRequestDispatcher("/blog/form.jsp");
		rd.include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		BlogDAO dao = new BlogDAO();

		int idx = dao.write(req);
		if (idx > 0) { // ��α� �ۼ� ���� -> ��α� ���� 
			out.print("<script>parent.location.href='view?idx="+ idx + "';</script>");
		} else { // ����
			out.print("<script>alert('��α� �ۼ� ����!');</script>");
		}
	}
}
