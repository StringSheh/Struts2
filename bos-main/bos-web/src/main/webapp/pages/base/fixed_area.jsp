<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>定区管理</title>
<!-- 导入easyui的文件  5个  第一个必须是jquery -->
<script type="text/javascript" src="../../js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../js/easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="../../js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../js/easyui/themes/icon.css">
<script type="text/javascript" src="../../js/form.js"></script>
<script type="text/javascript" src="../../js/crud.js"></script>

</head>
<body>
	<!-- 搜索表单 -->
	<form id="searchForm" action="">
		定区名称：<input type="text" name="fixedAreaName"/>
		联系电话：<input type="text" name="telephone"/>
		<a id="searchBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>  
	</form>
	
	<!-- 工具条 -->
	<div id="toolbar">
		<a id="addBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">增加</a>  
		<a id="editBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>  
		<a id="deleteBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>  
	</div>
	
	<!-- 列表展示 -->
	<table id="list"></table>
	
	
	<!-- 编辑表单 -->
	<div id="editWin" class="easyui-window" data-options="title:'定区添加修改',closed:true" style="width:600px;top:20px;left:200px">
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
							<td>定区名称</td>
							<td>
								<input type="text" name="fixedAreaName" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>负责的快递员</td>
							<td>
							<select id="courierId" name="courier.id" class="easyui-combobox"
							 data-options="url:'../../courier/list.action',valueField:'id',textField:'name'" style="width: 200px;"></select>
							</td>
						</tr>
						<tr>
							<td>联系电话</td>
							<td>
								<input name="telephone" class="easyui-validatebox" required="true"/>
							</td>
						</tr>
					</table>
		  </form>
		  </div>
		  
	</div>

	<script type="text/javascript">
		//当前模块的名称空间
		var action = "fixedArea";
	
		//当前模块展示列 shift+alt+A
		//列字段
		var columns = [ [ {
			field : 'id',
			title : '编号',
			width : 80,
			align : 'center',
			checkbox:true
		},{
			field : 'fixedAreaName',
			title : '定区名称',
			width : 120,
			align : 'center'
		}, {
			field : 'courier',
			title : '负责人',
			width : 120,
			align : 'center',
			formatter:function(value,row,index){
				if(value!=null){
					return value.name;
				}else{
					return "";
				}
			}
		}, {
			field : 'telephone',
			title : '联系电话',
			width : 120,
			align : 'center'
		} ] ];
		
		//覆盖方法
		function loadEditForm(row){
			$("#courierId").combobox("setValue",row.courier.id);
		}
	</script>

</body>
</html>