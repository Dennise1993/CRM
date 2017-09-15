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
   //编辑数据
   function linkon(loca,tea){
     window.location.href=loca+"?cstlinkman.lkmId="+tea+"&ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>";
   }
   function newadd(){
     window.location.href="Scstzhuan?ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>";
   }
</script>
</head>
  
<body>
<div style="padding:5px;">
  <div class="txt" style="padding-top:3px;" >当前位置：客户开发计划&nbsp;&gt;&nbsp;客户信息管理&nbsp;&gt;&nbsp;<a href="ScustomerShow">客户信息</a>&nbsp;&gt;&nbsp;联系人
    <hr class="hr1" />
  </div>
  <div class="operation_button">
    <a href="#" title="返回" onclick="back()">返回</a>
    <a href="#" title="新建" onclick="newadd()">新建</a>
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
          <th width="10%">姓名</th>
          <th width="5%">性别</th>
          <th width="15%">职位</th>
          <th width="20%">办公电话</th>
          <th width="15%">手机</th>
          <th width="15%">备注</th>
          <th width="15%">操作</th>
        </tr>
      </thead>
      <tbody>
         
        <s:iterator value="linlist">
        <tr>
          <td><input type="checkbox" /></td>
          <td><s:property value="lkmName"/></td>
          <td><s:property value="lkmSex"/></td>
          <td><s:property value="lkmPostion"/></td>
          <td><s:property value="lkmTel"/></td>
          <td><s:property value="lkmMobile"/></td>
          <td></td>
          <td>
          <img title="编辑" src="images/hammer_screwdriver.png" class="op_button" onclick="linkon('Scstoneshow','<s:property value="lkmId"/>')" />
          <img title="删除" src="images/cross.png" class="op_button close" class="op_button" onclick="linkon('Scstonedelete','<s:property value="lkmId"/>')" />
          </td>
        </tr>
        </s:iterator>
   
      </tbody>
    </table>
  </div>
  <div class="position"> 
  
  第<s:property value="pageindex"/>页/共<s:property value="allpage"/>页 
  <a href="ScuslinkShow?pageindex=1&ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>" title="首页">&laquo;首页</a> 
  <a href="ScuslinkShow?pageindex=<s:property value='pageindex-1'/>&ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>" title="上一页">&laquo; 上一页</a>
    <!-- 循环遍历集合 -->
     <s:iterator  begin="1" end="4" step="1" status="p">
        <s:if test="#p.count+pageindex-1<=allpage">
          <a href="ScuslinkShow?pageindex=<s:property value='#p.count+pageindex-1'/>&ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>"  <s:if test="#p.count+pageindex-1==pageindex"> class="number current" </s:if> <s:else>class="number"</s:else> title="1"><s:property value="#p.count+pageindex-1"/></a>
        <s:if test="#p.count+pageindex-1==allpage"></s:if>
       </s:if>
    </s:iterator>
  <a href="ScuslinkShow?pageindex=<s:property value='pageindex+1'/>&ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>" title="下一页">下一页&raquo;</a>
  <a href="ScuslinkShow?pageindex=<s:property value='allpage'/>&ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>" title="末页">末页&raquo;</a> 
  <!-- 输入框跳转 -->
  转到&nbsp;<input id="subs" type="text" name="impor"  size="2" />&nbsp;页<a href="#" onclick="a('ScuslinkShow')" >GO</a>
  
  </div>
</div>
</body>
</html>
