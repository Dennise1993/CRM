<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title>服务管理</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="js/javascript.js"></script>
<script type="text/javascript" src="datepicker/WdatePicker.js">
	
</script>
<script type="text/javascript">


	function gain() {
		var name = document.getElementById("clientname").value;
		var service = document.getElementById("sertype").value;
		var date = document.getElementById("date").value;
		//alert("vague?name=" + name + "&service=" + service + "&date=" + date);
		window.location.href = "vagueByUser?name=" + name + "&service="
				+ service + "&date=" + date;

	}
</script>

</head>

<body>
	<div style="padding:5px;">
		<div class="txt" style="padding-top:3px;">
			当前位置：客户服务管理&nbsp;&gt;&nbsp;服务处理列表
			<hr class="hr1" />
		</div>
		<div class="operation_button">
			<a href="javascript:toPage(1)" title="查询">查询</a>
		</div>
		<s:form action="dealSeivice.action">
		<div class="search_input">
			<ul class="txt">
				<li>客户名称：<s:textfield name="name"/></li>
				<li>服务类型：
				<%-- <s:textfield name="vague.service"/> --%>
				  <s:select  name="sertype" list="serviceType"
						listKey="dictId" listValue="dictItem" headerValue="全部" headerKey=""></s:select> </li>
				<li>创建日期： 
				<input id="date" name="date" type="text" size="30"
					onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" /></li>
			</ul>
		</div>
		</s:form>
		<div>
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="table_list">
				<thead>
					<tr>
						<th width="10%">编号</th>
						<th width="10%">客户名称</th>
						<th width="25%">概要</th>
						<th width="10%">服务类型</th>
						<th width="10%">创建人</th>
						<th width="15%">创建日期</th>
						<th width="10%">操作</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="recordList" status="p">
						<tr>
							<td id="updid"><s:property value="svrId" />
							</td>
							<td><a href="#"><s:property value="cstCustomer.custName" />
							</a>
							</td>
							<td><h4
									style="white-space:nowrap; overflow:hidden; text-overlow:ellipsis; width:300px;">
									<s:property value="svrRequest" />
								</h4></td>
							<td><s:property value="basDict.dictItem" />
							</td>
							<td><s:property value="sysUserBySvrCreateId.usrName" />
							</td>
							<td><s:date name="svrCreateDate" format="yyyy-MM-dd " />
							</td>
							<td><img title="操作" src="images/gear.ico"
								class="op_button" onclick="to('dispose?updat=<s:property value="svrId" />')" />
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
	<%@ include file="/public/pageView.jspf" %>
</body>
</html>
