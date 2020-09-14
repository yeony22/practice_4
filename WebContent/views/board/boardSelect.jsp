<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<form action="${PageContext.Request.ContextPath}/boardSelect.do">
		<table>
			<tr>
				<td>글 번호 : </td>
				<td><input type="text" id="cano"></td>
			</tr>
		</table>
		<button type="submit">조회</button>
	</form>	
</body>
</html>