<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/member_layout.jsp" flush="true">
	<tiles:put name="title" value="フィード登録" />
	<tiles:put name="content" type="string">
		<!--main start-->
		<div id="main">
			<!--content start-->
			<div id="content3">
				<h2>フィード登録<br><span>ファイル(URLリスト)を選択し、フィードを登録します。</span></h2><br>
				<html:errors/>
				<html:messages id="m" message="true">
					${f:h(m)}<br><br>
				</html:messages>
				<s:form enctype="multipart/form-data">
					<input type="file" name="formFile" size="100" /><br><br>
					<s:submit property="register">登録</s:submit><br><br>
				</s:form>
			</div>
			<!--/content end-->
		</div>
		<!--/main end-->
	</tiles:put>
</tiles:insert>