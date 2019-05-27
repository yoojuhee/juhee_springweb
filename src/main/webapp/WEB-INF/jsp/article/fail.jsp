<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시판</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<h2>실패</h2>
	<p>
		<a>글 등록자가 아닙니다</a>
	</p>
	<p>
		<a href="./app/article/list">글 목록</a>
	</p>	
</body>
</html>