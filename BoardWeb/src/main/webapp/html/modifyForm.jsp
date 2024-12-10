<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>글 수정 화면(modifyForm.jsp)</h3>


<form action="boardList.do" method="post">
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="25" rows="3" name="content"></textarea>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="수정등록"></td>
		</tr>

	</table>
	
</form>




<jsp:include page="../includes/footer.jsp"></jsp:include>