<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#searchBtn").click(function(){
		self.location="${contextPath}/boardList"
						+"${pageMakerVO.makeSearchPageQuery(1)}"
						+"&searchType="
						+$("select option:selected").val()
						+"&keyword="
						+$("input['name=keyword']").val();
	});
});
</script>

<body>
	<div id="search">
		<form>
			<select name="searchType">
				<option value="title" <c:out value='${searchPageVO.searchType == "title"?"selected":""}'/>>제목</option>
				<option value="content" <c:out value='${searchPageVO.searchType == "content"?"selected":""}'/>>내용</option>
				<option value="writer" <c:out value='${searchPageVO.searchType == "writer"?"selected":""}'/>>글쓴이</option>
			</select>
			<input type="text" name="keyword" value="${searchPageVO.keyword}">
			<button id="searchBtn">검색</button>
		</form>
	</div>
	<div id="board">
		<table border=1>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>내용</td>
				<td>글쓴이</td>
				<td>등록일</td>
				<td>수정일</td>
				<td>조회수</td>
				<td>댓글수</td>
			</tr>
			<c:forEach items="${boardList}" var="bList">
				<tr>
					<td>${bList.bno}</td>
					<td>${bList.title}</td>
					<td>${bList.content}</td>
					<td>${bList.writer}</td>
					<td>${bList.regdate}</td>
					<td>${bList.moddate}</td>
					<td>${bList.viewcnt}</td>
					<td>${bList.replycnt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="pagination">
		<c:if test="${pageMakerVO.prev ne null && pageMakerVO.prev == true}">
			<a href="${contextPath}/boardList${pageMakerVO.makeSearchPageQuery(pageMakerVO.startPageMaker - 1)}"><</a>
		</c:if>
		<c:forEach var="idx" begin="${pageMakerVO.startPageMaker}" end="${pageMakerVO.endPageMaker}">
			<a href="${contextPath}/boardList${pageMakerVO.makeSearchPageQuery(idx)}">${idx}</a>
		</c:forEach>
		<c:if test="${pageMakerVO.next ne null && pageMakerVO.next == true}">
			<a href="${contextPath}/boardList${pageMakerVO.makeSearchPageQuery(pageMakerVO.endPageMaker + 1)}">></a>
		</c:if>
	</div>
</body>
</html>