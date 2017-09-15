<link href="images/skin.css" rel="stylesheet" type="text/css" />
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>
<script type="text/javascript">     
	function countDown(secs,surl){     
	 var jumpTo = document.getElementById('jumpTo');
	 jumpTo.innerHTML=secs;  
	 if(--secs>0){     
	     setTimeout("countDown("+secs+",'"+surl+"')",1000);     
	 }else{       
         location.href=surl;     
     }     
 }     
</script> 
<body>
<div id="regLogin" class="wrap">
	<div class="dialog">
		<div class="box">
			<h4>操作失败</h4>

				<div class="infos">
				   <div style="text-align:center">系统发生内部错误,<span id="jumpTo">5</span>秒后自动跳转
						  <script type="text/javascript">countDown(5,'userAction/login.jsp');</script></div>
					<div style="text-align:center">如果浏览器没有跳转，请点击 <a href="userAction/login.jsp" style="font: 20px">返回</a></div>
				</div>
			
		</div>
	</div>
</div>
</body>
