<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.dto.Blog" %>
<%@ page import="com.model.dao.BlogDAO" %>
<%@ page import="java.util.*" %>
<%

BlogDAO dao = new BlogDAO();
int p = 1;
if (request.getParameter("page") != null) {
	p = Integer.parseInt(request.getParameter("page").trim());
}
ArrayList<Blog> list = dao.getList(p, 5);
request.setAttribute("list", list);

%>
<c:set var="list" value="<%=list%>" />
<h1>블로그</h1>
<div id="blog_post">
<c:forEach var="blog" items="${list}">
	<div style="border: 1px solid black; padding: 10px; width: 610px; margin-bottom: 20px;">
		게시글 번호 :	<c:out value="${blog.idx}" /><br>
		제목 : <c:out value="${blog.subject}" /><br>
		작성자 : <c:out value="${blog.poster}" /><br>
		<div>
			${blog.content}
		</div>
	 </div>
</c:forEach>
 </div>
	<button id="button" type="button">다음 게시글 5개 보기</button>