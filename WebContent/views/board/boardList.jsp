<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.dto.*" %>
<%
    ArrayList<BoardDTO> list = (ArrayList<BoardDTO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<jsp:include page="../common/nav.jsp"/>
	<section style="text-align: center;">
	<h1>게시글 목록 화면</h1>
		<table style="margin-left: 10px;" boarder="1" style="diplay:inline-block">
			<tr>
				<th>글 번호</th>
				<th width ="200">제목</th>
				<th width ="100">작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<% for(BoardDTO b : list) { %>
			<tr onclick="location.href='${pageContext.request.contextPath}/boardSelectOne.do?boardNo=<%= b.getBoardNo() %>';">
				<td><%= b.getBoardNo() %></td>
				<td><%="[" + b.getCaName() + "]" + b.getBoardTitle() %></td>
				<td><%= b.getBoardDate() %></td>
				<td><%= b.getReadCount() %></td>
			</tr>
			<% } %>				
		</table>
		
	</section>
	<jsp:include page="../common/footer.jsp"/>
			
</body>
</html>