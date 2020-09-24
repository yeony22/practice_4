<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.dto.*" %>
<%
    ArrayList<CategoryDTO> list = (ArrayList<CategoryDTO>)request.getAttribute("list");
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
	
	<h1>게시글 등록 화면</h1>
	<form action="${pageContext.request.contextPath }/boardInsert.do" method="post">
		<table style="margin-left: 10px;"  boarder="1">
			<tr>
				<th>글 제목</th>
				<td colspan="3">
					<select name="caNo">
						<% for(CategoryDTO c : list) { %>
							<option value="<%= c.getCano() %>">
							<%=c.getCaName() %>
							</option>
							<% } %>
					</select>
				<input type="text" name="boardTitle" id="boardTitle" required />
				</td>
			</tr>
			<tr>	
				<th>작성자</th>
				<td><input type="text" name="boardWriter" id="boardWriter" required /></td>
			
				<th>비밀번호</th>
				<td><input type="password" name="boardPwd" /></td>
			</tr>	
			<tr>
				<th>내용</th>
				<td colspan="3"><textarea name="boardContent"></textarea></td>
			</tr>
		</table>
		
		<div style="padding: 10px 0 0 90px;">
			<button type="submit">등록</button>
			<button type="button" onclick="location.href='${pageContext.request.contextPath}/boardList.do';">조회</button>
		</div>
	</form>
	
	<jsp:include page="../common/footer.jsp"/>
	
	<script>
		function fn_validate(e){
				if(document.querySelector("#boardTitle").value == "") {
				aleret("게시글 제목을 입력하세요.")
				return false;
			}
			if(document.querySelector("#boardWriter").value == "") {
				alert("작성자를 입력하세요.")
				return false;
			}
			alert("게시글 등록이 완료되었습니다.");
			
			return true;
		}
		
	</script>
</body>
</html>