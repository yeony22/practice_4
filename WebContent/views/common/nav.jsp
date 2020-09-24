<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.link {
		padding: 5px;
		color: black;
		font-weight:bolder;
		text-decoration: none;
	}
</style>
<nav style="width: 100%; margin-top: 10px;">
	<div style="color: black">
		<a class="link" href="${pageContext.request.contextPath}/index.jsp">Home</a>
		<a class="link" href="${pageContext.request.contextPath}/boardInsertForm.do">게시글 등록</a>
		<a class="link" href="${pageContext.request.contextPath}/boardList.do">게시글 목록 조회</a>
	</div>
</nav>
<hr width="100%" color="navy">