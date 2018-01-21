<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>区域管理</title>
<!-- 导入easyui的文件  5个  第一个必须是jquery -->
<script type="text/javascript" src="../../js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../js/easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="../../js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../js/easyui/themes/icon.css">
<script type="text/javascript" src="../../js/form.js"></script>
<script type="text/javascript" src="../../js/crud.js"></script>
<script type="text/javascript" src="../../js/ajaxfileupload.js"></script>

</head>
<body>
	<!-- 搜索表单 -->
	<form id="searchForm" action="../../area/excelExport.action" method="post">
		省份：<input type="text" name="province"/>
		城市：<input type="text" name="city"/>
		区（县）：<input type="text" name="district"/>
		<a id="searchBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>  
	</form>
	
	<!-- 工具条 -->
	<div id="toolbar">
		<a id="addBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">增加</a>  
		<a id="editBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>  
		<a id="deleteBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>  
		<a id="excelImportBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">Excel导入</a>  
		<a id="excelExportBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">Excel导出</a>  
	</div>
	
	<!-- 列表展示 -->
	<table id="list"></table>
	
	
	<!-- 编辑表单 -->
	<div id="editWin" class="easyui-window" data-options="title:'区域添加修改',closed:true" style="width:600px;top:50px;left:200px">
			<!-- 按钮区域 -->
			<div class="datagrid-toolbar">
				<a id="save" class="easyui-linkbutton" href="#" icon="icon-save">保存</a>
			</div>
			<!-- 编辑区域 -->
			<div>
			<form id="editForm" method="post">
			<!--提供隐藏域 装载id -->
			<input type="hidden" name="id" />
			<table class="table-edit" width="80%" align="center">
						<tr>
							<td>省</td>
							<td>
								<input type="text" name="province" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>市</td>
							<td>
								<input type="text" name="city" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>区</td>
							<td>
								<input type="text" name="district" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>邮编</td>
							<td>
								<input type="text" name="postcode" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>简码</td>
							<td>
								<input type="text" name="shortcode" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>城市编码</td>
							<td>
								<input type="text" name="citycode" class="easyui-validatebox" required="true" />
							</td>
						</tr>
					</table>
		  </form>
		  </div>
	</div>
	
	<!-- 批量导入窗口 -->
	<div id="importWin" class="easyui-window"
		data-options="title:'区域信息导入',closed:true"
		style="width: 400px; top: 50px; left: 200px">
		<table class="table-edit" width="80%" align="center">
			<tr class="title">
				<td colspan="2">区域信息导入</td>
			</tr>
			<tr>
				<td>选择文件</td>
				<td><input id="fileID" type="file" name="upload" class="easyui-validatebox" required="true" /></td>
			</tr>
			<tr>
				<td colspan="2"><a id="startImport" href="#" class="easyui-linkbutton">开始导入</a></td>
			</tr>
		</table>
	</div>

	<script type="text/javascript">
		//当前模块的名称空间
		var action = "area";
	
		//当前模块展示列 shift+alt+A
		var columns = [ [ {
			field : 'id',
			checkbox : true,
		},{
			field : 'province',
			title : '省',
			width : 120,
			align : 'center'
		}, {
			field : 'city',
			title : '市',
			width : 120,
			align : 'center'
		}, {
			field : 'district',
			title : '区',
			width : 120,
			align : 'center'
		}, {
			field : 'postcode',
			title : '邮编',
			width : 120,
			align : 'center'
		}, {
			field : 'shortcode',
			title : '简码',
			width : 120,
			align : 'center'
		}, {
			field : 'citycode',
			title : '城市编码',
			width : 200,
			align : 'center'
		} ] ];
		
		
		//点击excel导入，弹出导入窗口
		$("#excelImportBtn").click(function(){
			$("#importWin").window("open");
		});
		
		//开始导入
		$("#startImport").click(function(){
			//判断文件的格式是否正确
			//获取文件名称
			var filename = $("#fileID").val();
			//判断后缀名称
			var reg = /^.+\.(xls|xlsx)$/;
			if(!reg.test(filename)){
				$.messager.alert("提示","文件格式有误","warning");
				return;
			}
			
			//使用异步文件上传
			$.ajaxFileUpload({
				//url: 上传的url地址 
				url:"../../area/excelImport.action",
				//*fileElementId:  用户选择文件的<input type="file"/>的id
				fileElementId:"fileID",
				//dataType:指定服务器返回的数据类型  
				dataType:"json",
				//success: 服务器成功返回的回调函数  200
				success:function(data){ //data:返回的数据，如果dataType:"json"，那么data是json对象类型
					if(data.success){
						//刷新datagrid
						$("#list").datagrid("reload");
						
						//关闭导入窗口
						$("#importWin").window("close");
						
						$.messager.alert("提示","excel导入成功","info");
					}else{
						$.messager.alert("提示","excel导入失败："+data.msg,"error");
					}
				},
				//error:服务器返回失败    404 500
				error:function(e){
					alert(e);
				}
			});
			
		});
		
		//导出区域excel文件
		$("#excelExportBtn").click(function(){
			//提交搜索表单
			$("#searchForm").submit();
		});
	</script>


</body>
</html>