<%@page pageEncoding="UTF-8"%>
	<!--foot start-->
	<div id="foot">
		<ul>
			<c:forEach var="menu" items="${memberDto.menuItems}">
					<li><a href="${f:url(f:h(menu.url))}">${f:h(menu.title)}</a></li>
				</c:forEach>
		</ul>
	</div>
	<!--/foot end-->
	<address>Copyright(C) フィード All Rights Reserved.</address>
</div>
<!--/base end-->