<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
	<tiles:put name="title" value="フィード 会員登録" />
	<tiles:put name="content" type="string">
		<!--main start-->
		<div id="main">
			<!--content start-->
			<div id="login">
				<h3>会員登録</h3>
				<div class="box_out">
					<html:errors/>
					<div class="box_in">
						<div id="form">
							<s:form>
								<table>
									<tr>
										<td width="25%" class="td_head">ID&nbsp;<span class="chui">(必須)</span></td>
										<td width="75%" class="td_odd">
											<html:errors property="loginId"/>
											<html:text property="loginId" size="30" maxlength="50" />
										</td>
									</tr>
									<tr>
										<td class="td_head">パスワード&nbsp;<span class="chui">(必須)</span></td>
										<td class="td_odd">
											<html:errors property="password"/>
											<html:password property="password" size="30" maxlength="50" />
										</td>
									</tr>
									<tr>
										<td class="td_head">パスワード(確認)&nbsp;<span class="chui">(必須)</span></td>
										<td class="td_odd">
											<html:errors property="passwordConfirm"/>
											<html:password property="passwordConfirm" size="30" maxlength="50" />
										</td>
									</tr>
									<tr>
										<td class="td_head">名前&nbsp;<span class="chui">(必須)</span></td>
										<td class="td_odd">
											<html:errors property="name"/>
											<html:text property="name" size="30" maxlength="20" />
										</td>
									</tr>
									<tr>
										<td class="td_head">メールアドレス&nbsp;<span class="chui">(必須)</span></td>
										<td class="td_odd">
											<html:errors property="mailaddress"/>
											<html:text property="mailaddress" size="30" maxlength="100" />
										</td>
									</tr>
									<tr>
										<td class="td_head">生年月日</td>
										<td class="td_odd">
											<html:errors property="year"/>
											<html:errors property="month"/>
											<html:errors property="day"/>
											<html:text property="year" size="4" maxlength="4" />年<html:text property="month" size="2" maxlength="2" />月<html:text property="day" size="2" maxlength="2" />日
										</td>
									</tr>
									<tr>
										<td class="td_head">性別</td>
										<td class="td_odd">
											<html:errors property="gender"/>
											<html:radio property="gender" value="0" />男性
											<html:radio property="gender" value="1" />女性
										</td>
									</tr>
									<tr>
										<td class="td_head">住所</td>
										<td class="td_odd">
											<html:errors property="prefectureId"/>
											<html:select property="prefectureId">
												<html:option value="">▼住所を選択する</html:option>
												<c:forEach var="address" items="${registerDto.addressItems}">
													<html:option value="${f:h(address.prefectureId)}">${f:h(address.prefecture)}</html:option>
												</c:forEach>
											</html:select>
										</td>
									</tr>
									<tr>
										<td class="td_head">職業</td>
										<td class="td_odd">
											<html:errors property="jobId"/>
											<html:select property="jobId">
												<html:option value="">▼職業を選択する</html:option>
												<c:forEach var="job" items="${registerDto.jobItems}">
													<html:option value="${f:h(job.jobId)}">${f:h(job.job)}</html:option>
												</c:forEach>
											</html:select>
										</td>
									</tr>
								</table><br />
								<div align="center">
									<s:submit property="confirm">登録内容確認</s:submit>
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