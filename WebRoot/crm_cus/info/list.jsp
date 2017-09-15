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
   //首页显示模块和模糊级联查询的参数传递
   function a(title){
    var temp= document.getElementById("subs").value;
    window.location.href=title+"?pageindex="+temp+"&mana=<s:property value='mana'/>&rankid=<s:property value='rankid'/>&disc=<s:property value='disc'/>&client=<s:property value='client'/>";
   }
   //模糊级联查询通过get链接传递数据
   function gain(){
     var clie= document.getElementById("clie").value;//客户名称
    var manage= document.getElementById("manage").value;//客户经理编号
    var distri= document.getElementById("distri").value;//地区
    var rank= document.getElementById("rank").value;//客户等级编号
     window.location.href="ScustomerFaintly?client="+clie+"&disc="+distri+"&mana="+manage+"&rankid="+rank;
   }
   //联系人、交往、订单，编辑
   function link(str,ast,gongname){
      window.location.href=str+"?ast="+ast+"&gongname="+gongname;

   }
   function hoho(uri){
      window.location.href="ScstUpdatomer?tomer.custNo="+uri;

   }
   function deletecustomer(deluri){
      if(confirm("你确定要删除？") ){
       window.location.href="ScstDeletomer?tomer.custNo="+deluri;
      }
   }
</script>
</head>
     
<body>
<div style="padding:5px;">
  <div class="txt" style="padding-top:3px;" >当前位置：客户开发计划&nbsp;&gt;&nbsp;客户信息管理&nbsp;&gt;&nbsp;客户信息
    <hr class="hr1" />
  </div>
  <div class="operation_button"> <a href="#" title="查询" onclick="gain()">查询</a> </div>
  <div class="search_input">
    <ul class="txt">
      <li>客户名称：
        <input id="clie" name="clien" type="text"  size="30" />
      </li>
      <li>客户经理：   
       <s:select id="manage" list="syslist" name="man" listKey="usrId" listValue="usrName" headerValue="全部" headerKey=""></s:select>
      </li>
      <li>地区：
        <input id="distri" name="dis" type="text"  size="30" />
      </li>
      <li>客户等级：
      
       <s:select id="rank" list="baslist" name="rank" listKey="dictId" listValue="dictItem" headerValue="全部" headerKey=""></s:select>
     
      </li>
    </ul>
  </div>
  </div>
  <div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
      <thead>
        <tr>
          <th width="5%">序号</th>
          <th width="15%">客户编号</th>
          <th width="20%">客户名称</th>
          <th width="10%">地区</th>
          <th width="15%">客户经理</th>
          <th width="15%">客户等级</th>
          <th width="15%">操作</th>
        </tr>
      </thead>
      <tbody>
      
        <!-- iterator显示信息 -->
        <s:iterator value="cuslist" status="aa">
        <tr>
          <td><s:property value="#aa.index+1"/></td>
          <td><s:property value="custNo"/></td>
          <td><a href="#"><s:property value="custName"/></a></td>
          <td><s:property value="custRegion"/></td>
          <td><s:property value="sysUser.usrName"/></td>
          <td><s:property value="basDict.dictItem"/></td>
          <td>
              <s:if test="#session.LOGIN_USER.hasRightsByName('编辑客户信息')">
                <img title="删除" src="images/cross.png" class="op_button close" class="op_button" onclick="deletecustomer('<s:property value="custNo"/>')" />
                <img title="编辑" src="images/hammer_screwdriver.png" class="op_button" onclick="hoho('<s:property value="custNo"/>')" />
                <img title="联系人" src="images/user.ico" class="op_button" onclick="link('ScuslinkShow','<s:property value="custNo"/>','<s:property value="custName"/>')" />
                <img title="交往记录" src="images/bubble.ico" class="op_button" onclick="link('Scusactivity','<s:property value="custNo"/>','<s:property value="custName"/>')" />
                <img title="历史订单" src="images/document.ico" class="op_button" onclick="link('ScusOrder','<s:property value="custNo"/>','<s:property value="custName"/>')" />
              </s:if>
          </td>
        </tr>
        </s:iterator>
          
      </tbody>
    </table>
  </div>
   <!-- 模糊级联查询的分页显示 -->
  <s:if test="temp==1">
   <div class="position">
  第<s:property value="pageindex"/>页/共<s:property value="allpage"/>页 
  <a href="ScustomerFaintly?pageindex=1&mana=<s:property value='mana'/>&rankid=<s:property value='rankid'/>&disc=<s:property value='disc'/>&client=<s:property value='client'/>" title="首页">&laquo;首页</a> 
  <a href="ScustomerFaintly?pageindex=<s:property value='pageindex-1'/>&mana=<s:property value='mana'/>&rankid=<s:property value='rankid'/>&disc=<s:property value='disc'/>&client=<s:property value='client'/>" title="上一页">&laquo; 上一页</a>
    <!-- 循环遍历集合 -->
     <s:iterator  begin="1" end="4" step="1" status="p">
        <s:if test="#p.count+pageindex-1<=allpage">
          <a href="ScustomerFaintly?pageindex=<s:property value='#p.count+pageindex-1'/>&mana=<s:property value='mana'/>&rankid=<s:property value='rankid'/>&disc=<s:property value='disc'/>&client=<s:property value='client'/>"  <s:if test="#p.count+pageindex-1==pageindex"> class="number current" </s:if> <s:else>class="number"</s:else> title="1"><s:property value="#p.count+pageindex-1"/></a>
        <s:if test="#p.count+pageindex-1==allpage"></s:if>
       </s:if>
    </s:iterator>
  <a href="ScustomerFaintly?pageindex=<s:property value='pageindex+1'/>&mana=<s:property value='mana'/>&rankid=<s:property value='rankid'/>&disc=<s:property value='disc'/>&client=<s:property value='client'/>" title="下一页">下一页&raquo;</a>
  <a href="ScustomerFaintly?pageindex=<s:property value='allpage'/>&mana=<s:property value='mana'/>&rankid=<s:property value='rankid'/>&disc=<s:property value='disc'/>&client=<s:property value='client'/>" title="末页">末页&raquo;</a> 
  <!-- 输入框跳转 -->
  转到&nbsp;<input id="subs" type="text" name="impor"  size="2" />&nbsp;页<a href="#" onclick="a('ScustomerFaintly')" >GO</a>
  </div>
  </s:if>
   <!-- 首页显示模块的分页显示 -->
  <s:else>
   <div class="position">
  第<s:property value="pageindex"/>页/共<s:property value="allpage"/>页 
  <a href="ScustomerShow?pageindex=1" title="首页">&laquo;首页</a> 
  <a href="ScustomerShow?pageindex=<s:property value='pageindex-1'/>" title="上一页">&laquo; 上一页</a>
    <!-- 循环遍历集合 -->
     <s:iterator  begin="1" end="4" step="1" status="p">
        <s:if test="#p.count+pageindex-1<=allpage">
          <a href="ScustomerShow?pageindex=<s:property value='#p.count+pageindex-1'/>"  <s:if test="#p.count+pageindex-1==pageindex"> class="number current" </s:if> <s:else>class="number"</s:else> title="1"><s:property value="#p.count+pageindex-1"/></a>
        <s:if test="#p.count+pageindex-1==allpage"></s:if>
       </s:if>
    </s:iterator>
  <a href="ScustomerShow?pageindex=<s:property value='pageindex+1'/>" title="下一页">下一页&raquo;</a>
  <a href="ScustomerShow?pageindex=<s:property value='allpage'/>" title="末页">末页&raquo;</a> 
  <!-- 输入框跳转 -->
  转到&nbsp;<input id="subs" type="text" name="impor"  size="2" />&nbsp;页<a href="#" onclick="a('ScustomerShow')" >GO</a>
  </div>
  </s:else>
 

</body>
</html>
