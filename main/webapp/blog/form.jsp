<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.model.dto.Blog" %>
<%
	String siteURL = (String)request.getAttribute("siteURL");
	Blog blog = (Blog)request.getAttribute("blog");
	String action = (String)request.getAttribute("action");
%>
<c:set var="blog" value="<%=blog%>" />
<script src="<%=siteURL%>/resources/js/form.js"></script>
<form name='writeFrm' method="post" action="<%=action%>" target='ifrmHidden' autocomplete='off'>
	<c:if test="${blog != null}">
		<input type='hidden' name='idx' value="<c:out value='${blog.idx}' />" />
	</c:if>
	<dl>
		<dt>제목</dt>
		<dd>
			<input type="text" name="subject" value="<c:out value='${blog.subject}' />">
		</dd>
	</dl>
	<dl>
		<dt>작성자</dt>
		<dd>
			<input type="text" name="poster" value="<c:out value='${blog.poster}' />">
		</dd>
	</dl>
	<dl>
		<dt>내용</dt>
		<dd>
			<textarea id='content' name="content" ><c:out value="${board.content}" /></textarea>
			<script type="text/javascript">
			 CKEDITOR.replace('p_content'
			                , {height: 500                                                  
			                 });
			</script>

			<span class='addImage'>[이미지 추가]</span>
		</dd>
	</dl>
	<input type="reset" value="취소하기">
	<input type="submit" value="작성하기">
</form>
