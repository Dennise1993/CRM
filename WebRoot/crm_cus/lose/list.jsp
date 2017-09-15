<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title>客户开发计划</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="js/javascript.js"></script>
<script type="text/javascript" src="datepicker/WdatePicker.js">
	
</script>
<script type="text/javascript">
    //实现页面跳转
	function a(title) {
		var temp = document.getElementById("subs").value;
		window.location.href = title + "?pageindex=" + temp+"&cstlo.name=<s:property value='cstlo.name'/>&cstlo.userid=<s:property value='cstlo.userid'/>&cstlo.status=<s:property value='cstlo.status'/>";
	}
    //表单提交
	function check() {
		var biao = document.getElementById("biao");
		biao.submit();
	}
	//跳转到确认流失和暂缓流失
	function hoho(uri,adm){
	  window.location.href=uri+"?cstLost.lstId="+adm
	}
</script>
</head>

<body>
	<div style="padding:5px;">
		<div class="txt" style="padding-top:3px;">
			当前位置：客户开发计划&nbsp;&gt;&nbsp;客户流失管理&nbsp;&gt;&nbsp;流失信息
			<hr class="hr1" />
		</div>
		<div class="operation_button">
			<a href="#" title="查询" onclick="check()">查询</a>
		</div>
		<!-- 以表单的形式进行提交信息 -->
		<s:form id="biao" action="ScstQuery" method="post">
			<div class="search_input">
				<ul class="txt">
					<li>客户名称： <s:textfield name="cstlo.name" type="text" size="30" />
					</li>
					<li>客户经理： <s:select list="cslist" name="cstlo.userid"
							listKey="usrId" listValue="usrName" headerKey="" headerValue="全部"></s:select>
					</li>
					<li>状态： <s:select list="map" name="cstlo.status" listKey="key"
							listValue="value" headerKey="" headerValue="全部"></s:select></li>
				</ul>
			</div>
		</s:form>
		<div>
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="table_list">
				<thead>
					<tr>
						<th width="5%">编号</th>
						<th width="10%">客户名称</th>
						<th width="15%">客户经理</th>
						<th width="20%">上次下单时间</th>
						<th width="20%">确认流失时间</th>
						<th width="10%">状态</th>
						<th width="20%">操作</th>
					</tr>
				</thead>
				<tbody>
					<!-- 循环显示 -->

					<s:iterator value="loslist">
						<tr>
							<td><s:property value="lstId" />
							</td>
							<td><s:property value="cstCustomer.custName" />
							</td>
							<td><s:property value="sysUser.usrName" />
							</td>
							<td><s:date name="lstLastOrderDate" format="yyyy-MM-dd" />
							</td>
							<td><s:date name="lstLostDate" format="yyyy-MM-dd" />
							</td>
							<td><s:if test="lstStatus==1">预警</s:if>
								<s:if test="lstStatus==2">暂缓流失</s:if>
								<s:if test="lstStatus==3">已流失</s:if>
							</td>
							<td>
							<s:if test="#session.LOGIN_USER.hasRightsByName('确认客户流失')">
							<img title="确认流失" src="images/shield.ico"
								class="op_button" onclick="hoho('ScstSure','<s:property value="lstId" />')" /> 
						     <img title="暂缓流失" src="images/clock.ico" class="op_button"
								onclick="hoho('ScstRespite','<s:property value="lstId" />')" />
							</s:if>	
								</td>
						
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
		<!-- 模糊级联查询的分页显示 -->
		<s:if test="temp==1">
			<div class="position">
				第
				<s:property value="pageindex" />
				页/共
				<s:property value="allpage" />
				页 <a href="ScstQuery?pageindex=1&cstlo.name=<s:property value='cstlo.name'/>&cstlo.userid=<s:property value='cstlo.userid'/>&cstlo.status=<s:property value='cstlo.status'/>" title="首页">&laquo;首页</a> 
				  <a	href="ScstQuery?pageindex=<s:property value='pageindex-1'/>&cstlo.name=<s:property value='cstlo.name'/>&cstlo.userid=<s:property value='cstlo.userid'/>&cstlo.status=<s:property value='cstlo.status'/>" title="上一页">
					&laquo; 上一页</a>
				<!-- 循环遍历集合 -->
				<s:iterator begin="1" end="4" step="1" status="p">
					<s:if test="#p.count+pageindex-1<=allpage">
						<a
							href="ScstQuery?pageindex=<s:property value='#p.count+pageindex-1'/>&cstlo.name=<s:property value='cstlo.name'/>&cstlo.userid=<s:property value='cstlo.userid'/>&cstlo.status=<s:property value='cstlo.status'/>"
							<s:if test="#p.count+pageindex-1==pageindex"> class="number current" </s:if>
							<s:else>class="number"</s:else> title="1"><s:property
								value="#p.count+pageindex-1" />
						</a>
						<s:if test="#p.count+pageindex-1==allpage"></s:if>
					</s:if>
				</s:iterator>
				<a href="ScstQuery?pageindex=<s:property value='pageindex+1'/>&cstlo.name=<s:property value='cstlo.name'/>&cstlo.userid=<s:property value='cstlo.userid'/>&cstlo.status=<s:property value='cstlo.status'/>"
					title="下一页">下一页&raquo;</a> <a
					href="ScstQuery?pageindex=<s:property value='allpage'/>&cstlo.name=<s:property value='cstlo.name'/>&cstlo.userid=<s:property value='cstlo.userid'/>&cstlo.status=<s:property value='cstlo.status'/>" title="末页">末页&raquo;</a>
				<!-- 输入框跳转 -->
				转到&nbsp;<input id="subs" type="text" name="impor" size="2" />&nbsp;页<a
					href="#" onclick="a('ScstQuery')">GO</a>
			</div>
		</s:if>
		<!-- 首页显示模块的分页显示 -->
		<s:else>
			<div class="position">
				第
				<s:property value="pageindex" />
				页/共
				<s:property value="allpage" />
				页 <a href="ScstLostShow?pageindex=1" title="首页">&laquo;首页</a> <a
					href="ScstLostShow?pageindex=<s:property value='pageindex-1'/>"
					title="上一页">&laquo; 上一页</a>
				<!-- 循环遍历集合 -->
				<s:iterator begin="1" end="4" step="1" status="p">
					<s:if test="#p.count+pageindex-1<=allpage">
						<a
							href="ScstLostShow?pageindex=<s:property value='#p.count+pageindex-1'/>"
							<s:if test="#p.count+pageindex-1==pageindex"> class="number current" </s:if>
							<s:else>class="number"</s:else> title="1"><s:property
								value="#p.count+pageindex-1" />
						</a>
						<s:if test="#p.count+pageindex-1==allpage"></s:if>
					</s:if>
				</s:iterator>
				<a href="ScstLostShow?pageindex=<s:property value='pageindex+1'/>"
					title="下一页">下一页&raquo;</a> <a
					href="ScustomerShow?pageindex=<s:property value='allpage'/>"
					title="末页">末页&raquo;</a>
				<!-- 输入框跳转 -->
				转到&nbsp;<input id="subs" type="text" name="impor" size="2" />&nbsp;页<a
					href="#" onclick="a('ScstLostShow')">GO</a>
			</div>
		</s:else>
	</div>
</body>
</html>
