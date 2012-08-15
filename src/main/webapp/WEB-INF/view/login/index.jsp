<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
	<tiles:put name="title" value="フィード ログイン" />
	<tiles:put name="content" type="string">
		<!--main start-->
			<div id="main">
				<!--content start-->
				<div id="login">
					<h3>ログイン</h3>
					<div class="box_out">
						<html:errors/>
						<div class="box_in">
							<div id="form">
								<s:form>
									<table>
										<tr>
											<td width="25%" class="td_head">ID</td>
											<td width="75%" class="td_odd">
												<html:errors property="id"/>
												<html:text property="id" size="40" maxlength="50" />
											</td>
										</tr>
										<tr>
											<td class="td_head">パスワード</td>
											<td class="td_odd">
												<html:errors property="password"/>
												<html:password property="password" size="40" maxlength="50" />
											</td>
										</tr>
									</table><br />
									<div align="center">
										<s:submit property="login">ログイン</s:submit>
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