<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<jsp:include page="../common/nav.jsp"/>
	
	<form>
		<table border="1">
			<tr>
				<td>글 제목</td>
				<td>카테고리</td>
				<td colspan="2">제목</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>이름</td>
				<td>비밀번호</td>
				<td>비번</td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3">본문</td>
			</tr>
		</table>
		<button type="submit">등록</button>
		<button type="button">조회</button>
	</form>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>