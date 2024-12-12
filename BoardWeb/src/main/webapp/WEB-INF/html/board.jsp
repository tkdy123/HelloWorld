<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<!-- board.jsp 원래 있던 부분. -->
<h3>글상세화면(board.jsp)</h3>

<form action="modifyForm.do">
<input type="hidden" name="board_no" value="${board.boardNo }">
<input type="hidden" name="searchCondition" value="${searchCondition }">
<input type="hidden" name="keyword" value="${keyword }">
<input type="hidden" name="page" value="${page }">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${board.boardNo }</td>
			<th>작성자</th>
			<td>${board.writer }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea rows="5" class="form-control" name="content" readonly>${board.content }</textarea></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td>${board.creationDate }</td>
			<th>조회수</th>
			<td>${board.viewCnt }</td>
		</tr>
		<tr>
		<!-- // 로그인 상태 => 권한에 따라 활성화/비활성화.
		// 로그인 상태 아니면 => 권한없음. -->
		
		<c:choose>
		<c:when test="${logId ne null && board.writer eq logId }">
			<td colspan="4" align="center"><input type="submit" class="btn btn-warning" value="수정화면"></td>		
		</c:when>
		<c:otherwise>
			<td colspan="4" align="center"><input type="submit" class="btn btn-warning" value="수정화면" disabled></td>
		</c:otherwise>		
		</c:choose>
		</tr>
	</table>
</form>
<!-- board.jsp 원래 있던 부분. -->
<jsp:include page="../includes/footer.jsp"></jsp:include>