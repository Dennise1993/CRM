<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title>新建销售机会</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/javascript.js"></script>
<script type="text/javascript">
	function savePlan() {

		var str = "";
		var chcId = document.getElementById("chcId").value;
		var chcSource = document.getElementById("chcSource").value;
		var chcCustName = document.getElementById("chcCustName").value;
		var chcRate = document.getElementById("chcRate").value;
		var chcTitle = document.getElementById("chcTitle").value;
		var chcLinkman = document.getElementById("chcLinkman").value;
		var chcMobile = document.getElementById("chcMobile").value;
		var chcDesc = document.getElementById("chcDesc").value;
		var chcCreateDate = document.getElementById("chcCreateDate").value;
		var chcDueDate = document.getElementById("chcDueDate").value;
		if (chcSource == null || chcSource == "") {
			str = str + " 机会来源";
		}
		if (chcCustName == null || chcCustName == "") {
			str = str + " 客户名称";
		}
		if (chcRate == null || chcRate == "") {
			str = str + " 成功机率";
		}
		if (chcTitle == null || chcTitle == "") {
			str = str + " 概要";
		}
		if (chcLinkman == null || chcLinkman == "") {
			str = str + " 联系人";
		}
		if (chcMobile == null || chcMobile == "") {
			str = str + " 联系人手机";
		}
		if (chcDesc == null || chcDesc == "") {
			str = str + " 机会描述";
		}
		if (chcCreateDate == null || chcCreateDate == "") {
			str = str + " 创建时间";
		}

		if (str != "") {
			str = str + "不能为空!";
			alert(str);
			return flase;
		} else {
			alert("保存成功!");
			document.forms[0].submit();
			//window.location.href("showUser.action");
		}
	}
</script>
</head>

<body>
	<div style="padding:5px;">
		<div class="txt" style="padding-top:3px;">
			当前位置：营销管理&nbsp;&gt;&nbsp;销售机会管理&nbsp;&gt;&nbsp;<a href="list.jsp">销售机会</a>&nbsp;&gt;&nbsp;修改销售机会
			<hr class="hr1" />
		</div>
		<div class="operation_button">
			<a href="#" title="返回" onclick="back()">返回</a> <a href="#"
				title="执行计划" onclick="return savePlan()">保存</a>
		</div>
		<div class="out_bg">
			<div class="in_bg">
				<s:form action="AddPlan.action" id="AddPlan" method="post">
					<table border="0" cellpadding="0" cellspacing="0"
						class="table_input txt">
						<tr>
							<td width="126" height="50">编号</td>
							<td width="411"><input id="chcId" type="text"
								disabled="disabled"
								value='<s:property value="salChance.chcId"/>' /></td>
							<td width="126">机会来源</td>
							<td width="442"><input id="chcSource" type="text"
								value='<s:property value="salChance.chcSource"/>' />
							</td>
						</tr>
						<tr>
							<td height="50">客户名称</td>
							<td><input id="chcCustName" type="text"
								value='<s:property value="salChance.chcCustName"/>' /></td>
							<td>成功几率</td>
							<td><input id="chcRate" type="text"
								value='<s:property value="salChance.chcRate"/>' /></td>
						</tr>
						<tr>
							<td height="50">概要</td>
							<td><input id="chcTitle" type="text"
								value='<s:property value="salChance.chcTitle"/>' /></td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td height="50">联系人</td>
							<td><input id="chcLinkman" type="text"
								value='<s:property value="salChance.chcLinkman"/>' /></td>
							<td>联系人电话</td>
							<td><input id="chcMobile" type="text"
								value='<s:property value="salChance.chcMobile"/>' /></td>
						</tr>
						<tr style="padding:0px;">
							<td valign="top">机会描述</td>
							<td><textarea rows="6" cols="36" id="chcDesc"
									value='<s:property value="salChance.chcDesc"/>' /> </textarea></td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td height="50">创建人</td>
							<td><input type="text" /></td>
							<td>创建时间</td>
							<td><input id="chcCreateDate" type="text"
								value='<s:date name="salChance.chcCreateDate" format="yyyy-MM-dd" />' /></td>
						</tr>
						<tr>
							<td height="50">指派给</td>
							<td><s:select name="users" list="users" listKey="usrId"
									listValue="usrName" />
							</td>
							<td>指派时间</td>
							<td><input id="chcDueDate" type="text" disabled="disabled"
								value='<s:property value="salChance.chcDueDate"/>' /></td>
						</tr>
					</table>
				</s:form>
				
			</div>
		</div>
	</div>
</body>
</html>
