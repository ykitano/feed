<%@page pageEncoding="UTF-8"%>
<!--base start-->
<div id="base">
	<!--head start-->
	<div id="head">
		<h1><input type="text" name="clock" size="23"></h1>
		<a href="${f:url('/')}" title="フィード　トップページへ"><img src="${f:url('/img/logo.gif')}" id="logo" /></a>
		<ul id="h_list">
			<li><a href="${f:url('/register')}">会員登録</a></li>
			<li><a href="${f:url('/login')}">ログイン</a></li>
		</ul>
		<div id="navi_b">
			<ul id='nav'><!-- strong入れないといけない -->
				<c:forEach var="menu" items="${memberDto.menuItems}">
					<li><a href="${f:url(f:h(menu.url))}">${f:h(menu.title)}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<!--/head end-->