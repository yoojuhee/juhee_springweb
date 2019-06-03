
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>편지</title>
<script type="text/javascript">
	function confirmDelete() {
		if (confirm("삭제하시겠습니까?"))
			return true;
		else
			return false;
	}
</script>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<h2>글 보기</h2>	
	<p>
		<span>${letter.letterId }</span> | <span style="font-weight: bold;">${letter.title }</span>
	</p>
	<p>
		<span>${letter.cdate }</span>
	</p>
	<p>
		 <span>${letter.senderId }</span> | <span>${letter.senderName }</span>
	</p>	
	<hr />
	<p>
		 <span>${letter.receiverId }</span> | <span>${letter.receiverName }</span>
	</p>	
	<hr />
	<p>${letter.contentHtml }</p>
	<hr />
	<p>		
		<a href="./app/letter/delete?letterId=${letter.letterId }&senderId=${letter.senderId }
		&receiverId=${letter.receiverId }"	onclick="return confirmDelete();">글삭제</a>
	</p>
</body>
</html>

  