<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<title>客户开发计划</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/javascript.js"></script>
<style>
	body{ margin:0;
		  padding:0}
	.role{  margin:0px 30px 0px 0px; 
			float:left; }
	.right{
		display:none;
		}		
	.overflow{
		padding-left:30px;
		display:block;}	
</style>
<script type="text/javascript">
	function rightChange(id){
			var div = document.getElementById(id);
			div.className = "overflow";
		}
    function preserve(){
     var dan=document.getElementById("dan");
     var name=document.getElementById("name").value;
     var adr=document.getElementById("adr").value;
      if(name!=null &&name!=""){
          if(adr!=null &&adr!=""){
             dan.submit();
          }else{
          alert("地区不能为空！！！");
          }     
        }else{
       alert("客户名称不能为空？？？？");
      }
    }		
</script>
</head>

<body style="width:1366px">
<div style="padding:5px;">
<!-- 利用表单传递数据 -->
  <form  id="dan" action="ScstpreserveTomer?tomer.custNo=<s:property value='tomer.custNo'/>" method="post">
  <div class="txt" style="padding-top:3px;" >当前位置：客户开发计划&nbsp;&gt;&nbsp;客户信息管理&nbsp;&gt;&nbsp;<a href="ScustomerShow">客户信息</a>&nbsp;&gt;&nbsp;编辑客户信息
    <hr class="hr1" />
  </div>
  <div class="operation_button"> 
  <a href="#" title="返回" onclick="back()">返回</a>
  <a href="#" title="保存" onclick="preserve()">保存</a>
   </div>
  <table border="0" cellpadding="0" cellspacing="0" class="table_show txt">
        <tr>
          <td width="100" align="center">客户编号：</td>
          <td width="200"><s:property value="tomer.custNo"/></td>
          <td width="100" align="center">客户名称：</td>
          <td width="200"><input id="name" name="tomer.custName" type="text" value="<s:property value='tomer.custName'/>"/></td>
        </tr>
  </table>
  <div class="out_bg">
    <div class="in_bg">
      <table border="0" cellpadding="0" cellspacing="0" class="table_list">
        <tr>
          <td width="126">地区</td>
          <td width="411"><input id="adr" name="tomer.custRegion" type="text" value="<s:property value='tomer.custRegion'/>"/></td>
          <td width="126">客户经理</td>
          <td width="442"><s:select  list="syslist" name="jingli" listKey="usrId" listValue="usrName"></s:select> </td>      
        </tr>
      </table>
      </div>
     <div class="in_bg">
      <table border="0" cellpadding="0" cellspacing="0" class="table_list">
        <tr>
          <td width="126">客户等级</td>
          <td width="411"><s:select  list="baslist" name="dengji" listKey="dictId" listValue="dictItem" ></s:select></td>
          <td width="126">客户满意度</td>
          <td width="442"><s:select  list="map" name="tomer.custSatisfy" listKey="key" listValue="value" ></s:select></td>
        </tr>
      </table>
      </div>
      </div>
     <div class="out_bg">
     <div class="in_bg">
      <table border="0" cellpadding="0" cellspacing="0" class="table_list">
        <tr>
          <td width="126">客户信用度</td>
          <td width="411"><s:select  list="map" name="tomer.custCredit" listKey="key" listValue="value" ></s:select></td>
          <td width="126">地址</td>
          <td width="442"><input name="tomer.custAddress" type="text" value="<s:property value='tomer.custAddress'/>" /></td>
        </tr>
       </table>
      </div>
     <div class="in_bg">
      <table border="0" cellpadding="0" cellspacing="0" class="table_list">
        <tr>
          <td width="126">邮政编码</td>
          <td width="411"><input name="tomer.custZip" type="text" value="<s:property value='tomer.custZip'/>" /></td>
          <td width="126">电话</td>
          <td width="442"><input name="tomer.custTel" type="text" value="<s:property value='tomer.custTel'/>" /></td>
        </tr>
       </table>
      </div>
      </div>
     <div class="out_bg">
     <div class="in_bg">
      <table border="0" cellpadding="0" cellspacing="0" class="table_list">
        <tr>
          <td width="126">传真</td>
          <td width="411"><input name="tomer.custFax" type="text" value="<s:property value='tomer.custFax'/>" /></td>
          <td width="126">网址</td>
          <td width="442"><input name="tomer.custWebsite" type="text" value="<s:property value='tomer.custWebsite'/>" /></td>
        </tr>
    </table>
      </div> 
  </div>
  </form>
  </div>
   
</body>
</html>
