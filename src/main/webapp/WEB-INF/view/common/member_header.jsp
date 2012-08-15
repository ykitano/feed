<%@page pageEncoding="UTF-8"%>
<!--base start-->
<div id="base">
	<!--head start-->
	<div id="head">
		<h1><input type="text" name="clock" size="23"></h1>
		<a href="${f:url('/home')}" title="フィード　トップページへ"><img src="${f:url('/img/logo.gif')}" id="logo" /></a>
		<ul id="h_list">
			<li>${memberDto.name} 様</li>
			<li><a href="${f:url('/logout')}">ログアウト</a></li>
		</ul>
		<div id="navi_b">
			<ul id='nav'>
				<c:forEach var="menu" items="${memberDto.menuItems}" varStatus="s">
					<li><a href="${f:url(menu.url)}">${f:h(menu.title)}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<!--/head end-->