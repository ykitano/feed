<%@page pageEncoding="UTF-8"%>
<html>
	<head>
		<title><tiles:getAsString name="title" /></title>
		<link rel="stylesheet" type="text/css" href="${f:url('/css/style.css')}" />
		<script type="text/javascript" src="${f:url('/js/jquery.js')}"></script>
		<script type="text/javascript" src="${f:url('/js/script.js')}"></script>
		<script type="text/javascript" src="${f:url('/js/feed.js')}"></script>
	</head>
	<body onload="nowTime()">
		<tiles:insert page="header.jsp" />
		<tiles:insert attribute="content" />
		<tiles:insert page="footer.jsp" />
	</body>
</html>