<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<title>客户开发计划</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="js/javascript.js"></script> 
<script type="text/javascript" src="datepicker/WdatePicker.js"> </script>
<script type="text/javascript" >
    //分页显示传递信息
   function a(title){
    var temp= document.getElementById("subs").value;
    window.location.href=title+"?pageindex="+temp;
   }
   //查看明细
   function check(temp){
   
    window.location.href="Scstcare?order.odrId="+temp; 
   }
 </script>

</head>

<body>
<div style="padding:5px;">
  <div class="txt" style="padding-top:3px;" >当前位置：客户开发计划&nbsp;&gt;&nbsp;客户信息管理&nbsp;&gt;&nbsp;历史订单
    <hr class="hr1" />
  </div>
  <div class="operation_button">
    <a href="#" title="返回" onclick="back()">返回</a>
  </div>
  <table border="0" cellpadding="0" cellspacing="0" class="table_show txt">
        <tr>
          <td width="100" align="center">客户编号：</td>
          <td width="200"><s:property value="ast"/></td>
          <td width="100" align="center">客户名称：</td>
          <td width="200"><s:property value="gongname"/></td>
        </tr>
  </table>
  <div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
      <thead>
        <tr>
          <th width="5%"><input type="checkbox" class="check-all"/></th>
          <th width="15%">订单编号</th>
          <th width="15%">日期</th>
          <th width="30%">送货地址</th>
          <th width="10%">状态</th>
          <th width="20%">操作</th>
        </tr>
      </thead>
      <tbody>
         
       <s:iterator value="ordlist" >
        <tr>
          <td><input type="checkbox" /></td>
          <td><s:property value="odrId" /></td>
          <td><s:date name="odrDate" format="yyyy-MM-dd" /></td>
          <td><s:property value="odrAddr" /></td>
           <td><s:if test="odrStatus==6">已回款</s:if><s:if test="odrStatus==5">已发货</s:if></td>
          <td><img title="查看明细" src="images/document.ico" class="op_button" onclick="check('<s:property value="odrId" />')" /></td>
        </tr>
        </s:iterator>
      </tbody>
    </table>
  </div>
  <div class="position"> 
  
  第<s:property value="pageindex"/>页/共<s:property value="allpage"/>页 
  <a href="ScusOrder?pageindex=1&ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>" title="首页">&laquo;首页</a> 
  <a href="ScusOrder?pageindex=<s:property value='pageindex-1'/>&ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>" title="上一页">&laquo; 上一页</a>
    <!-- 循环遍历集合 -->
     <s:iterator  begin="1" end="4" step="1" status="p">
        <s:if test="#p.count+pageindex-1<=allpage">
          <a href="ScusOrder?pageindex=<s:property value='#p.count+pageindex-1'/>&ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>"  <s:if test="#p.count+pageindex-1==pageindex"> class="number current" </s:if> <s:else>class="number"</s:else> title="1"><s:property value="#p.count+pageindex-1"/></a>
        <s:if test="#p.count+pageindex-1==allpage"></s:if>
       </s:if>
    </s:iterator>
  <a href="ScusOrder?pageindex=<s:property value='pageindex+1'/>&ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>" title="下一页">下一页&raquo;</a>
  <a href="ScusOrder?pageindex=<s:property value='allpage'/>&ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>" title="末页">末页&raquo;</a> 
  <!-- 输入框跳转 -->
  转到&nbsp;<input id="subs" type="text" name="impor"  size="2" />&nbsp;页<a href="#" onclick="a('ScusOrder')" >GO</a>
  
  </div>
</div>
</body>
</html>
