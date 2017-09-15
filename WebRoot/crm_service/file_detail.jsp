<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title>服务管理</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/javascript.js"></script>
<style type="text/css">
input {
	background: #F8F9FA;
	border-left: 0px;
	border-top: 0px;
	border-right: 0px;
	border-bottom: 1px
}
</style>

</head>


<body>
	<div style="padding:5px;">
		<div class="txt" style="padding-top:3px;">
			当前位置：客户服务管理&nbsp;&gt;&nbsp;<a href="filing">服务归档列表</a>&nbsp;&gt;&nbsp;归档明细
			<hr class="hr1" />
		</div>
		<div class="operation_button">
			<a href="#" title="返回" onclick="back()">返回</a>
		</div>
		<div class="out_bg">
			<div class="in_bg">
				<table border="0" cellpadding="0" cellspacing="0"
					class="table_input txt">
					<tr>
						<td width="126">编号</td>
						<td width="411"><input name="svrId" type="text"
							value="<s:property value='cstService.svrId'/>"
							readonly="readonly" />
						</td>
						<td width="126">服务类型</td>
						<td width="442"><input name="basDict1" type="text"
							value="<s:property value='cstService.basDict.dictItem'/>"
							readonly="readonly" />
						</td>
					</tr>
					<tr>
						<td>概要</td>
						<td colspan="3"><input name="svrTitle" type="text"
							value="<s:property value='cstService.svrTitle'/>"
							readonly="readonly" />
						</td>
					</tr>
					<tr>
						<td>客户</td>
						<td><input name="cstCustomer1" type="text"
							value="<s:property value='cstService.cstCustomer.custName'/>"
							readonly="readonly" />
						</td>
						<td>状态</td>
						<td>已处理</td>
					</tr>
					<tr>
						<td>服务请求</td>
						<td colspan="3"><input name="svrRequest" type="text"
							value="<s:property value='cstService.svrRequest'/>"
							readonly="readonly" />
						</td>
					</tr>
					<tr>
						<td>创建人</td>
						<td><input name="sysUserBySvrCreateId1" type="text"
							value="<s:property value='cstService.sysUserBySvrCreateId.usrName'/>"
							readonly="readonly" />
						</td>
						<td>创建时间</td>
						<td><input name="svrCreateDate" type="text"
							value="<s:property value='cstService.svrCreateDate'/>"
							readonly="readonly" />
						</td>
					</tr>
					<tr>
						<td>分配给</td>
						<td><input name="sysUserBySvrDueId1" type="text"
							value="<s:property value='cstService.sysUserBySvrDueId.usrName'/>"
							readonly="readonly" />
						</td>
						<td>分配时间</td>
						<td><input name="svrDueDate" type="text"
							value="<s:property value='cstService.svrDueDate'/>"
							readonly="readonly" />
						</td>
					</tr>
					<tr>
						<td valign="top">服务处理</td>
						<td colspan="3"><input name="svrDeal" type="text"
							value="<s:property value='cstService.svrDeal'/>"
							readonly="readonly" />
						</td>
					</tr>
					<tr>
						<td>处理人</td>
						<td><input type="text"
							value="<s:property value='cstService.sysUserBySvrDueId.usrName'/>"
							readonly="readonly" />
						</td>
						<td>处理时间</td>
						<td><input name="svrDealDate" type="text"
							value="<s:property value='cstService.svrDealDate'/>"
							readonly="readonly" />
						</td>
					</tr>
					<tr>
						<td>处理结果</td>
						<td><input name="svrDealDate" type="text"
							value="<s:property value='cstService.svrResult'/>"
							readonly="readonly" /></td>
						<td>满意度</td>
						<td>
						<s:if test="cstService.svrSatisfy==5">☆☆☆☆☆</s:if>
						<s:elseif test="cstService.svrSatisfy==4">☆☆☆☆</s:elseif>
						<s:elseif test="cstService.svrSatisfy==3">☆☆☆</s:elseif>
						<s:elseif test="cstService.svrSatisfy==2">☆☆</s:elseif>
						<s:elseif test="cstService.svrSatisfy==1">☆</s:elseif>
						<s:else>☆☆☆</s:else>
						
						
						
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
