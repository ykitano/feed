<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
	<tiles:put name="title" value="フィード" />
	<tiles:put name="content" type="string">
		<!--main start-->
		<div id="main">
			<!--content start-->
			<div id="content">
				<div class="box02_left">
					<c:forEach var="feed" items="${feedList}" varStatus="s">
						<c:if test="${s.index % 2 == 0}">
							<h3>${feed.title}</h3>
							<div class="box_in">
								<c:forEach var="entry" items="${feed.entries}" end="4" varStatus="es">
									<p>・<a href="${entry.link}">${entry.title}</a> <fmt:formatDate value="${entry.publishedDate}" pattern="yyyy/MM/dd HH:mm"/></p>
								</c:forEach>
							</div>
						</c:if>
					</c:forEach>
				</div>
				<div class="box02_right">
					<c:forEach var="feed" items="${feedList}" varStatus="s">
						<c:if test="${s.index % 2 == 1}">
							<h3>${feed.title}</h3>
							<div class="box_in">
								<c:forEach var="entry" items="${feed.entries}" end="4" varStatus="es">
									<p>・<a href="${entry.link}">${entry.title}</a> <fmt:formatDate value="${entry.publishedDate}" pattern="yyyy/MM/dd HH:mm"/></p>
								</c:forEach>
							</div>
						</c:if>
					</c:forEach>
				</div>
				<div class="to_top">
					<a href="#"	onclick="backToTop(); return false"><img src="/feed/img/to_top.gif" alt="ページトップへ戻る" /></a>
				</div>
			</div>
			<!--/content end-->
			<!--side start-->
			<div id="side">
				<h3>購読数ランキング</h3>
				<div class="side_box">
					<div class="side_inbox">
						<ul class="side_menu">
							<c:forEach var="ranking" items="${rankingList}" varStatus="s">
								<li><a href="${ranking.url}">${s.count}:${ranking.title}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<!--/side end-->
		</div>
		<!--/main end-->
	</tiles:put>
</tiles:insert>