<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>消息中心</title>
<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
<link id="easyuiTheme" rel="stylesheet" type="text/css"
	href="js/easyui/themes/default/easyui.css">
	
<!-- 导入portal的资源 -->
<script type="text/javascript"
	src="js/easyui/ext/jquery.portal.js"></script>
<link rel="stylesheet" type="text/css" href="js/easyui/ext/portal.css">
</head>
<body>

	<!-- 1.设计一个div放门户 -->
	<div id="pp" style="width:1000px;height:500px;">   
	    <div style="width:50%"></div>   
	    <div style="width:50%"></div>   
	</div> 
	
	<script type="text/javascript">
		$(function(){
			$("#pp").portal({
				//去掉边框
				border:false
			});
			
			//定义四个面板内容
			var panels = [
				{    
				    title: '公共栏',    
				    height:220,    
				    closable: true,    
				    collapsible: true,
				    href:"pages/portal/gonggao.html"
				} ,
				{    
				    title: '代办事宜',    
				    height:220,    
				    closable: true,    
				    collapsible: true  ,
				    href:"pages/portal/daiban.html"
				},
				{    
				    title: '预警信息',    
				    height:220,    
				    closable: true,    
				    collapsible: true  ,
				    href:"pages/portal/yujing.html"
				},
				{    
				    title: '系统BUG反馈',    
				    height:220,    
				    closable: true,    
				    collapsible: true ,
				    href:"pages/portal/bug.html"
				}
			];
			
			for(var i=0;i<panels.length;i++){
				//创建一个面板    
				var p = $('<div></div>').appendTo('body');    
				p.panel(panels[i]);    
				     
				//把面板追加到portal    
				$('#pp').portal('add', {    
				    panel: p,   
				    //columnIndex: 追加的列索引  0：代表第1列
				    columnIndex: i%2    
				});  
			}
			
		});
	</script> 


</body>
</html>