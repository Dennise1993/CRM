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
<script type="text/javascript">
    //分页显示传递信息
   function a(title){
    var temp= document.getElementById("subs").value;
    window.location.href=title+"?pageindex="+temp;
   }
   //编辑活动列表数据confirm("你确定要删除？") 
   function editor(tee){
    window.location.href="SeditoActive?ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>&cstact.atvId="+tee;
     
   }
   //删除活动列表数据
   function dele(tem){
     if(confirm("你确定要删除？")){
     window.location.href="SdeleteActive?ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>&cstact.atvId="+tem;
      }
   }
   //添加数据信息
   function addact(){
     window.location.href="Sadd?ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>";
   }
</script>
</head>

<body>
<div style="padding:5px;">
  <div class="txt" style="padding-top:3px;" >当前位置：客户开发计划&nbsp;&gt;&nbsp;客户信息管理&nbsp;&gt;&nbsp;<a href="ScustomerShow">客户信息</a>&nbsp;&gt;&nbsp;交往记录
    <hr class="hr1" />
  </div>
  <div class="operation_button">
    <a href="#" title="返回" onclick="back()">返回</a>
    <a href="#" title="新建" onclick="addact()">新建</a>
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
          <th width="15%">时间</th>
          <th width="20%">地点</th>
          <th width="25%">概要</th>
          <th width="20%">详细信息</th>
          <th width="15%">操作</th>
        </tr>
      </thead>
      <tbody>
        
        <!-- 循环显示CstActivity的信息 -->
        <s:iterator value="actlist">
        
        <tr>
          <td><input type="checkbox" /></td>
          <td><s:date name="atvDate" format="yyyy-MM-dd"/></td>
          <td><s:property value="atvPlace"/></td>
          <td><s:property value="atvTitle"/></td>
          <td><s:property value="atvDesc"/></td>
          <td>
            <img title="编辑" src="images/hammer_screwdriver.png" class="op_button" onclick="editor('<s:property value="atvId"/>')" />
            <img title="删除" src="images/cross.png" class="op_button" onclick="dele('<s:property value="atvId"/>')" />
          </td>
        </tr>
        </s:iterator>
        
      </tbody>
    </table>
  </div>
  <div class="position"> 
  
  第<s:property value="pageindex"/>页/共<s:property value="allpage"/>页 
  <a href="Scusactivity?pageindex=1&ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>" title="首页">&laquo;首页</a> 
  <a href="Scusactivity?pageindex=<s:property value='pageindex-1'/>&ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>" title="上一页">&laquo; 上一页</a>
    <!-- 循环遍历集合 -->
     <s:iterator  begin="1" end="4" step="1" status="p">
        <s:if test="#p.count+pageindex-1<=allpage">
          <a href="Scusactivity?pageindex=<s:property value='#p.count+pageindex-1'/>&ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>"  <s:if test="#p.count+pageindex-1==pageindex"> class="number current" </s:if> <s:else>class="number"</s:else> title="1"><s:property value="#p.count+pageindex-1"/></a>
        <s:if test="#p.count+pageindex-1==allpage"></s:if>
       </s:if>
    </s:iterator>
  <a href="Scusactivity?pageindex=<s:property value='pageindex+1'/>&ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>" title="下一页">下一页&raquo;</a>
  <a href="Scusactivity?pageindex=<s:property value='allpage'/>&ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>" title="末页">末页&raquo;</a> 
  <!-- 输入框跳转 -->
  转到&nbsp;<input id="subs" type="text" name="impor"  size="2" />&nbsp;页<a href="#" onclick="a('Scusactivity')" >GO</a>
  
  </div>
</div>
</body>
</html>
