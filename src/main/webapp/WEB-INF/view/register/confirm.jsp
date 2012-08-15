<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
	<tiles:put name="title" value="フィード 会員登録" />
	<tiles:put name="content" type="string">
		<!--main start-->
		<div id="main">
			<!--content start-->
			<div id="login">
				<h3>会員登録 確認画面</h3>
				<div class="box_out">
					<div class="box_in">
						<div id="form">
							<s:form>
								<table>
									<tr>
										<td width="25%" class="td_head">ID</td>
										<td width="75%" class="td_odd">${f:h(loginId)}</td>
									</tr>
									<tr>
										<td class="td_head">名前</td>
										<td class="td_odd">${f:h(name)}</td>
									</tr>
									<tr>
										<td class="td_head">メールアドレス</td>
										<td class="td_odd">${f:h(mailaddress)}</td>
									</tr>
									<tr>
										<td class="td_head">生年月日</td>
										<td class="td_odd">${f:h(birthday)}</td>
									</tr>
									<tr>
										<td class="td_head">性別</td>
										<td class="td_odd">${f:h(strGender)}</td>
									</tr>
									<tr>
										<td class="td_head">住所</td>
										<td class="td_odd">${f:h(prefecture)}</td>
									</tr>
									<tr>
										<td class="td_head">職業</td>
										<td class="td_odd">${f:h(job)}</td>
									</tr>
								</table><br />
								<div align="center">
									<s:submit property="reinput">戻る</s:submit>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<s:submit property="register">登録</s:submit>
								</div>
							</s:form>
						</div>
					</div>
				</div>
			</div>
			<!--/content end-->
		</div>
		<!--/main end-->
	</tiles:put>
</tiles:insert>