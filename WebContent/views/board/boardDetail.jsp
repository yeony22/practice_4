<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<style>
	h1 {
		text-align: center;
	}
	
</style>
<body>
	<jsp:include page="../common/header.jsp"/>
	<jsp:include page="../common/nav.jsp"/>
	<h1>게시글 상세 조회</h1>
	<table>
		<tr>
			<td>글 제목</td>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td></td>
			<td>조회수</td>
			<td></td>
		</tr>
			<td>내용</td>
			<td colspan="3"></td>
	</table>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>