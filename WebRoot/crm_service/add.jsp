<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>u

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>服务管理</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/javascript.js"></script>
<script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>

<script type="text/javascript">
	function check() {
		//alert("服务请求不能为空");
		var temp = document.getElementById("serviceRequest").value;
		// alert(temp);
		if (temp == "") {
			alert("服务请求不能为空，提交失败");
			return false;

		}
		alert("提交成功");
		return true;
	}
</script>
</head>

<body>
	<div style="padding:5px;">
		<div class="txt" style="padding-top:3px;">
			当前位置：客户服务管理&nbsp;&gt;&nbsp;服务创建
			<hr class="hr1" />
		</div>
		<div class="operation_button"></div>
		<s:form action="addaction" method="post" onSubmit="return check()">
			<div class="out_bg">
				<div class="in_bg">
					<table border="0" cellpadding="0" cellspacing="0"
						class="table_input txt">
						<tr>
							<td width="126">编号</td>
							<td width="411"><input name="svrId" type="text"
								value="<s:property value='svrId'/>" readonly="readonly"
								style="background: #999" />
							</td>
							<td width="126">创建人</td>
							<td width="442"><input type="text" value="<s:property value='sysUserBySvrCreateId.usrName'/>"
								readonly="readonly" style="background: #999" />
							</td>
						</tr>
						<tr>
							<td>创建时间</td>
							<td><input type="text" name="svrCreateDate"
								value="<s:property value='svrCreateDate'/>" readonly="readonly"
								style="background: #999" /></td>
							<td>状态</td>
							<td>新创建</td>
						</tr>
						<tr>
							<td>客户</td>
							<td><s:select name="tcustomer" list="customer"
									listKey="custNo" listValue="custName">
								</s:select>
							</td>
							<td>服务类型</td>

							<td><s:select name="pid" list="serviceType" listKey="dictId"
									listValue="dictItem">
								</s:select>
							</td>
						</tr>
						<tr>
							<td valign="top">服务标题</td>
							<td><input name="svrTitle" id="svrTitle"></input></td>
						</tr>
						<tr>
							<td valign="top">服务请求</td>
							<td><textarea rows="6" cols="36" name="svrRequest"
									id="serviceRequest"></textarea></td>
							<td></td>
							<td></td>
						</tr>

					</table>
					<input type="submit" name="submit" value="立即发布" style="background: #73B400;color: #FFFFFF "/>
				</div>
				
			</div>
			
		</s:form>
	</div>
	
</body>

</html>
