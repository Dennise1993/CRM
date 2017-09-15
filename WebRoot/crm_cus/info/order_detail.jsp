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
    window.location.href=title+"?pageindex="+temp+"&order.odrId=<s:property value='order.odrId'/>";
   }

</script>

</head>

<body>
<div style="padding:5px;">
  <div class="txt" style="padding-top:3px;" >当前位置：客户开发计划&nbsp;&gt;&nbsp;客户信息管理&nbsp;&gt;&nbsp;<a href="ScustomerShow">历史订单</a>&nbsp;&gt;&nbsp;订单明细
    <hr class="hr1" />
  </div>
  <div class="operation_button">
    <a href="#" title="返回" onclick="back()">返回</a>
  </div>
  <table border="0" cellpadding="0" cellspacing="0" class="table_show txt">
        <tr>
        
          <td width="100" align="center">订单编号：</td>
          <td width="200"><s:property value="order.odrId"/></td>
          <td width="100" align="center">日期：</td>
          <td width="200"><s:date name="order.odrDate" format="yyyy-MM-dd"/></td>
        </tr>
        <tr>
          <td width="100" align="center">送货地址：</td>
          <td width="200"><s:property value="order.odrAddr"/></td>
          <td width="100" align="center">总金额（元）：</td>
          <td width="200"><s:property value="allmone"/></td>
        </tr>
        <tr>
          <td width="100" align="center">状态：</td>
          <td width="200"><s:if test="order.odrStatus==6">已回款</s:if><s:if test="order.odrStatus==5">已发货</s:if></td>
          <td width="100" align="center"></td>
          <td width="200"></td>
        </tr>
  </table>
  <div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
      <thead>
        <tr>
          <th width="30%">商品</th>
          <th width="10%">数量</th>
          <th width="20%">单位</th>
          <th width="20%">单价（元）</th>
          <th width="20%">金额（元）</th>
        </tr>
      </thead>
      <tbody>
        <s:iterator value="linlist">
        <tr>
          <td> <s:property value="product.prodName"/></td> 
          <td><s:property value="oddCount"/></td>
          <td><s:property value="oddUnit"/></td>
          <td><s:property value="product.prodPrice"/></td>
          <td><s:property value="product.prodPrice*oddCount"/></td>
        </tr>
         </s:iterator>
      </tbody>
    </table>
  </div>
  <div class="position"> 
  
  第<s:property value="pageindex"/>页/共<s:property value="allpage"/>页 
  <a href="Scstcare?pageindex=1&order.odrId=<s:property value='order.odrId'/>" title="首页">&laquo;首页</a> 
  <a href="Scstcare?pageindex=<s:property value='pageindex-1'/>&order.odrId=<s:property value='order.odrId'/>" title="上一页">&laquo; 上一页</a>
    <!-- 循环遍历集合 -->
     <s:iterator  begin="1" end="4" step="1" status="p">
        <s:if test="#p.count+pageindex-1<=allpage">
          <a href="Scstcare?pageindex=<s:property value='#p.count+pageindex-1'/>&order.odrId=<s:property value='order.odrId'/>"  <s:if test="#p.count+pageindex-1==pageindex"> class="number current" </s:if> <s:else>class="number"</s:else> title="1"><s:property value="#p.count+pageindex-1"/></a>
        <s:if test="#p.count+pageindex-1==allpage"></s:if>
       </s:if>
    </s:iterator>
  <a href="Scstcare?pageindex=<s:property value='pageindex+1'/>&order.odrId=<s:property value='order.odrId'/>" title="下一页">下一页&raquo;</a>
  <a href="Scstcare?pageindex=<s:property value='allpage'/>&order.odrId=<s:property value='order.odrId'/>" title="末页">末页&raquo;</a> 
  <!-- 输入框跳转 -->
  转到&nbsp;<input id="subs" type="text" name="impor"  size="2" />&nbsp;页<a href="#" onclick="a('Scstcare')" >GO</a>
  
  </div>
</div>
</body>
</html>
