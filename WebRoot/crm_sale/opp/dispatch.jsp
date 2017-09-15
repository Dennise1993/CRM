<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title>营销管理</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/javascript.js"></script>
<script type="text/javascript">
	function saveEdit() {
		var str = "";
		if (str != "") {
			str = str + "不能为空!";
			alert(str);
			return flase;
		} else {
			alert("保存成功!");
			window.location.href("showUser.action");
		}
	}
</script>
</head>

<body>
	<div style="padding:5px;">
		<div class="txt" style="padding-top:3px;">
			当前位置：营销管理&nbsp;&gt;&nbsp;销售机会管理&nbsp;&gt;&nbsp;<a href="list.jsp">销售机会</a>&nbsp;&gt;&nbsp;指派销售机会
			<hr class="hr1" />
		</div>
		<div class="operation_button">
			<a href="#" title="返回" onclick="back()">返回</a> <a href="#" title="保存"
				onclick="return saveEdit()">保存</a>
		</div>
		<div class="out_bg">
			<div class="in_bg">
				<table border="0" cellpadding="0" cellspacing="0"
					class="table_input txt">
					<tr>
						<td width="126" height="50">编号</td>
						<td width="411"><s:property value="salChance.chcId" /></td>
						<td width="126">机会来源</td>
						<td width="442"><s:property value="salChance.chcSource" /></td>
					</tr>
					<tr>
						<td height="50">客户名称</td>
						<td><s:property value="salChance.chcCustName" />
						</td>
						<td>成功几率</td>
						<td><s:property value="salChance.chcRate" />
						</td>
					</tr>
					<tr>
						<td height="50">概要</td>
						<td><s:property value="salChance.chcTitle" />
						</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td height="50">联系人</td>
						<td><s:property value="salChance.chcLinkman" />
						</td>
						<td>联系人电话</td>
						<td><s:property value="salChance.chcMobile" />
						</td>
					</tr>
					<tr style="padding:0px;">
						<td valign="top">机会描述</td>
						<td><s:property value="salChance.chcDesc" />
						</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td height="50">创建人</td>
						<td>Mr.shi</td>
						<td>创建时间</td>
						<td>
						<%-- <s:property value="salChance.chcCreateDate" /> --%>
						<s:date name="salChance.chcCreateDate" format="yyyy-MM-dd" />
						</td>
					</tr>
					<tr>
						<td height="50">指派给</td>
						<td><s:select name="users" list="users" listKey="usrId"
								listValue="usrName" />
						</td>
						<td>指派时间</td>
						<td><input type="text" disabled="disabled"
							value='<s:property value="salChance.chcDueDate" />' /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
