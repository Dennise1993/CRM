<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<title>营销管理</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/javascript.js"></script>
<script type="text/javascript" >
	function savePlan(){
	 var time=document.getElementById("planTime").value;
	//var tudo=document.getElementById("planTudo").value;
	alert("计划保存成功");
	 window.location.href("sal-showDev.action");
	}
</script>
</head>

<body>
<div style="padding:5px;">
  <div class="txt" style="padding-top:3px;" >当前位置：营销管理&nbsp;&gt;&nbsp;客户开发计划&nbsp;&gt;&nbsp;<a href="list.jsp">开发计划</a>&nbsp;&gt;&nbsp;制定计划
    <hr class="hr1" />
  </div>
  <div class="operation_button">
  	<a href="#" title="返回" onclick="back()">返回</a>
    <a href="#" title="保存" onclick="savePlan()">保存</a>
  </div>
  <div class="out_bg">
    <div class="in_bg">
      <table border="0" cellpadding="0" cellspacing="0" class="table_input txt">
        <tr>
          <td width="126" height="50">编号</td>
          <td width="411"><s:property value="sal.chcId"/></td>
          <td width="126">机会来源</td>
          <td width="442"><s:property value="sal.chcSource"/></td>
        </tr>
        <tr>
          <td height="50">客户名称</td>
          <td><s:property value="sal.chcCustName"/></td>
          <td>成功几率</td>
          <td><s:property value="sal.rate"/>%</td>
        </tr>
        <tr>
          <td height="50">概要</td>
          <td><s:property value="sal.chcTitle"/></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td height="50">联系人</td>
          <td><s:property value="sal.chcLinkman"/></td>
          <td>联系人电话</td>
          <td><s:property value="sal.chcMobile"/></td>
        </tr>
        <tr style="padding:0px;">
          <td valign="top">机会描述</td>
          <td><s:property value="sal.chcDesc"/></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td height="50">创建人</td>
          <td><s:property value="sal.sysUserByChcCreateId.usrName"/></td>
          <td>创建时间</td>
          <td><s:property value="sal.chcCreateDate"/></td>
        </tr>
         <tr>
          <td height="50">指派给</td>
          <td><s:property value="sal.sysUserByChcDueId.usrName"/></td>
          <td>指派时间</td>
          <td><s:property value="sal.chcDueDate"/></td>
        </tr>
      </table>
    </div>
  </div>
  <div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
      <thead>
        <tr>
          <th width="10%">日期</th>
          <th width="30%">计划项</th>
          <th width="10%">操作</th>
          <th width="15%">执行结果</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td id="planTime"><%
          String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
          out.print(time);
          %>
          </td>
          <td>
          	<input size="100" id="planTudo"  />
          </td>
          <td><input type="button" value="保存计划" onclick="savePlan()" /></td>
          <td>制定计划中</td>
        </tr>
        </tbody>
      </table>
      </div>
</div>
</body>
</html>
