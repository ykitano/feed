<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/member_layout.jsp" flush="true">
	<tiles:put name="title" value="フィード 会員登録 登録完了" />
	<tiles:put name="content" type="string">
		<!--main start-->
		<div id="main">
			<div id="register_finish">
				<h3>会員登録 完了画面</h3>
				<div class="box_out">
					<div class="box_in">
						<p>会員登録が完了しました。</p><br>
						<p>フィード検索画面から購読したいフィードの登録が出来ます。
						登録されたフィードはトップページに一覧表示されます。</p><br>
						<p>設定画面ではトップページの細かい設定が出来ます。</p><br>
					</div>
				</div>
			</div>
		</div>
		<!--/main end-->
	</tiles:put>
</tiles:insert>