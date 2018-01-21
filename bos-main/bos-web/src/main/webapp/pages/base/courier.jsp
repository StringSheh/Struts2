<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>快递员管理</title>
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
		工号：<input type="text" name="courierNum"/>
		姓名：<input type="text" name="name"/>
		电话：<input type="text" name="telephone"/>
		取派标准：<select name="standard.id" class="easyui-combobox" 
								  data-options="url:'../../standard/list.action',valueField:'id',textField:'name'" style="width: 200px;"></select>
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
	<div id="editWin" class="easyui-window" data-options="title:'快递员编辑',closed:true" style="width:700px;top:50px;left:200px">
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
							<td>快递员工号</td>
							<td>
								<input type="text" name="courierNum" class="easyui-validatebox" required="true" />
							</td>
							<td>姓名</td>
							<td>
								<input type="text" name="name" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>手机</td>
							<td>
								<input type="text" name="telephone" class="easyui-validatebox" required="true" />
							</td>
							<td>所属单位</td>
							<td>
								<input type="text" name="company" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>查台密码</td>
							<td>
								<input type="text" name="checkPwd" class="easyui-validatebox" required="true" />
							</td>
							<td>PDA号码</td>
							<td>
								<input type="text" name="pda" class="easyui-validatebox" required="true" />
							</td>
						</tr>
						<tr>
							<td>取派标准</td>
							<td>
								<select id="standardId" name="standard.id" class="easyui-combobox" 
								  data-options="url:'../../standard/list.action',valueField:'id',textField:'name'" style="width: 200px;"></select>
							</td>
						</tr>
					</table>
		  </form>
		  </div>
	</div>

	<script type="text/javascript">
		//当前模块的名称空间
		var action = "courier";
	
		//当前模块展示列 shift+alt+A
		//列字段
		var columns = [ [ {
				field : 'id',
				checkbox : true,
			},{
				field : 'courierNum',
				title : '工号',
				width : 80,
				align : 'center'
			},{
				field : 'name',
				title : '姓名',
				width : 80,
				align : 'center'
			}, {
				field : 'telephone',
				title : '手机号',
				width : 120,
				align : 'center'
			}, {
				field : 'checkPwd',
				title : '查台密码',
				width : 120,
				align : 'center'
			}, {
				field : 'pda',
				title : 'PDA号',
				width : 120,
				align : 'center'
			}, {
				field : 'standard',
				title : '取派标准',
				width : 120,
				align : 'center',
				//格式化列
				/*
				  value: 当前单元格的值
				  row：当前行对象
				  index：当前行索引。从0开始
				*/
				formatter:function(value,row,index){
					if(value!=null){
						return value.name;
					}else{
						return "";
					}
				}
			}, {
				field : 'company',
				title : '所属单位',
				width : 200,
				align : 'center'
			} ] ];
		
		//回显下拉框的逻辑
		function loadEditForm(row){
			//回显快递员的收派标准的值
			//值：可以填写valueField或者textField的值，建议使用valueField
			$("#standardId").combobox("setValue",row.standard.id);
		}
	</script>

</body>
</html>