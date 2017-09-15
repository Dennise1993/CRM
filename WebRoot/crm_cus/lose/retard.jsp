<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<title>客户开发计划</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/javascript.js"></script>
<script type="text/javascript">
   //保存路径
   function saveon(){
   var tee=document.getElementById("cat").value;
    if(tee!=null&& tee!=""){
    
     window.location.href="ScstUpdaDefer?cstLost.lstId=<s:property value='cstLost.lstId'/>&cstLost.lstDelay="+tee;
    }else{
        alert("追加暂缓措施不能为空!!!!!");
    }
   }
   
   
   //跳转到确认流失和暂缓流失
	function hoho(uri,adm){
	  window.location.href=uri+"?cstLost.lstId="+adm
	}
</script>
</head>

<body>
<div style="padding:5px;">
  <div class="txt" style="padding-top:3px;" >当前位置：客户开发计划&nbsp;&gt;&nbsp;客户流失管理&nbsp;&gt;&nbsp;<a href="list.jsp">流失信息</a>&nbsp;&gt;&nbsp;暂缓流失
    <hr class="hr1" />
  </div>
  <div class="operation_button">
  	<a href="#" title="返回" onclick="back()">返回</a>
    <a href="#" title="确认流失" onclick="hoho('ScstSure','<s:property value="lstId" />')">确认流失</a>
    <a href="#" title="保存" onclick="saveon();">保存</a>
  </div>
  <div class="out_bg">
    <div class="in_bg">
      <table border="0" cellpadding="0" cellspacing="0" class="table_input txt">
        <tr>
          <td width="126">编号</td>
          <td width="411"><s:property value="cstLost.lstId"/></td>
          <td width="126">客户</td>
          <td width="442"><s:property value="cstLost.cstCustomer.custName"/></td>
        </tr>
        <tr>
          <td>客户经理</td>
          <td><s:property value="cstLost.sysUser.usrName"/></td>
          <td>上次下单时间</td>
          <td><s:date name="cstLost.lstLastOrderDate" format="yyyy-MM-dd"/></td>
        </tr>
        <tr>
          <td>暂缓措施</td>
          <td colspan="3"><s:property value="cstLost.lstDelay"/></td>
        </tr>
        <tr>
          <td valign="top">追加暂缓措施</td>
          <td><textarea id="cat" rows="6" cols="36" ></textarea></td>
          <td></td>
          <td></td>
        </tr>
      </table>
    </div>
  </div>
</div>
</body>
</html>
