/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2017-11-01 10:33:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages.base;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class area_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title>区域管理</title>\r\n");
      out.write("<!-- 导入easyui的文件  5个  第一个必须是jquery -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/easyui/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../js/easyui/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../js/easyui/themes/icon.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/form.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/crud.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/ajaxfileupload.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- 搜索表单 -->\r\n");
      out.write("\t<form id=\"searchForm\" action=\"../../area/excelExport.action\" method=\"post\">\r\n");
      out.write("\t\t省份：<input type=\"text\" name=\"province\"/>\r\n");
      out.write("\t\t城市：<input type=\"text\" name=\"city\"/>\r\n");
      out.write("\t\t区（县）：<input type=\"text\" name=\"district\"/>\r\n");
      out.write("\t\t<a id=\"searchBtn\" href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-search'\">搜索</a>  \r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 工具条 -->\r\n");
      out.write("\t<div id=\"toolbar\">\r\n");
      out.write("\t\t<a id=\"addBtn\" href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-add'\">增加</a>  \r\n");
      out.write("\t\t<a id=\"editBtn\" href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-edit'\">修改</a>  \r\n");
      out.write("\t\t<a id=\"deleteBtn\" href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">删除</a>  \r\n");
      out.write("\t\t<a id=\"excelImportBtn\" href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-reload'\">Excel导入</a>  \r\n");
      out.write("\t\t<a id=\"excelExportBtn\" href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-reload'\">Excel导出</a>  \r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 列表展示 -->\r\n");
      out.write("\t<table id=\"list\"></table>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 编辑表单 -->\r\n");
      out.write("\t<div id=\"editWin\" class=\"easyui-window\" data-options=\"title:'区域添加修改',closed:true\" style=\"width:600px;top:50px;left:200px\">\r\n");
      out.write("\t\t\t<!-- 按钮区域 -->\r\n");
      out.write("\t\t\t<div class=\"datagrid-toolbar\">\r\n");
      out.write("\t\t\t\t<a id=\"save\" class=\"easyui-linkbutton\" href=\"#\" icon=\"icon-save\">保存</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 编辑区域 -->\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t<form id=\"editForm\" method=\"post\">\r\n");
      out.write("\t\t\t<!--提供隐藏域 装载id -->\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"id\" />\r\n");
      out.write("\t\t\t<table class=\"table-edit\" width=\"80%\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>省</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"province\" class=\"easyui-validatebox\" required=\"true\" />\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>市</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"city\" class=\"easyui-validatebox\" required=\"true\" />\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>区</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"district\" class=\"easyui-validatebox\" required=\"true\" />\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>邮编</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"postcode\" class=\"easyui-validatebox\" required=\"true\" />\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>简码</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"shortcode\" class=\"easyui-validatebox\" required=\"true\" />\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>城市编码</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"citycode\" class=\"easyui-validatebox\" required=\"true\" />\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t  </form>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 批量导入窗口 -->\r\n");
      out.write("\t<div id=\"importWin\" class=\"easyui-window\"\r\n");
      out.write("\t\tdata-options=\"title:'区域信息导入',closed:true\"\r\n");
      out.write("\t\tstyle=\"width: 400px; top: 50px; left: 200px\">\r\n");
      out.write("\t\t<table class=\"table-edit\" width=\"80%\" align=\"center\">\r\n");
      out.write("\t\t\t<tr class=\"title\">\r\n");
      out.write("\t\t\t\t<td colspan=\"2\">区域信息导入</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>选择文件</td>\r\n");
      out.write("\t\t\t\t<td><input id=\"fileID\" type=\"file\" name=\"upload\" class=\"easyui-validatebox\" required=\"true\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\"><a id=\"startImport\" href=\"#\" class=\"easyui-linkbutton\">开始导入</a></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t//当前模块的名称空间\r\n");
      out.write("\t\tvar action = \"area\";\r\n");
      out.write("\t\r\n");
      out.write("\t\t//当前模块展示列 shift+alt+A\r\n");
      out.write("\t\tvar columns = [ [ {\r\n");
      out.write("\t\t\tfield : 'id',\r\n");
      out.write("\t\t\tcheckbox : true,\r\n");
      out.write("\t\t},{\r\n");
      out.write("\t\t\tfield : 'province',\r\n");
      out.write("\t\t\ttitle : '省',\r\n");
      out.write("\t\t\twidth : 120,\r\n");
      out.write("\t\t\talign : 'center'\r\n");
      out.write("\t\t}, {\r\n");
      out.write("\t\t\tfield : 'city',\r\n");
      out.write("\t\t\ttitle : '市',\r\n");
      out.write("\t\t\twidth : 120,\r\n");
      out.write("\t\t\talign : 'center'\r\n");
      out.write("\t\t}, {\r\n");
      out.write("\t\t\tfield : 'district',\r\n");
      out.write("\t\t\ttitle : '区',\r\n");
      out.write("\t\t\twidth : 120,\r\n");
      out.write("\t\t\talign : 'center'\r\n");
      out.write("\t\t}, {\r\n");
      out.write("\t\t\tfield : 'postcode',\r\n");
      out.write("\t\t\ttitle : '邮编',\r\n");
      out.write("\t\t\twidth : 120,\r\n");
      out.write("\t\t\talign : 'center'\r\n");
      out.write("\t\t}, {\r\n");
      out.write("\t\t\tfield : 'shortcode',\r\n");
      out.write("\t\t\ttitle : '简码',\r\n");
      out.write("\t\t\twidth : 120,\r\n");
      out.write("\t\t\talign : 'center'\r\n");
      out.write("\t\t}, {\r\n");
      out.write("\t\t\tfield : 'citycode',\r\n");
      out.write("\t\t\ttitle : '城市编码',\r\n");
      out.write("\t\t\twidth : 200,\r\n");
      out.write("\t\t\talign : 'center'\r\n");
      out.write("\t\t} ] ];\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//点击excel导入，弹出导入窗口\r\n");
      out.write("\t\t$(\"#excelImportBtn\").click(function(){\r\n");
      out.write("\t\t\t$(\"#importWin\").window(\"open\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//开始导入\r\n");
      out.write("\t\t$(\"#startImport\").click(function(){\r\n");
      out.write("\t\t\t//判断文件的格式是否正确\r\n");
      out.write("\t\t\t//获取文件名称\r\n");
      out.write("\t\t\tvar filename = $(\"#fileID\").val();\r\n");
      out.write("\t\t\t//判断后缀名称\r\n");
      out.write("\t\t\tvar reg = /^.+\\.(xls|xlsx)$/;\r\n");
      out.write("\t\t\tif(!reg.test(filename)){\r\n");
      out.write("\t\t\t\t$.messager.alert(\"提示\",\"文件格式有误\",\"warning\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//使用异步文件上传\r\n");
      out.write("\t\t\t$.ajaxFileUpload({\r\n");
      out.write("\t\t\t\t//url: 上传的url地址 \r\n");
      out.write("\t\t\t\turl:\"../../area/excelImport.action\",\r\n");
      out.write("\t\t\t\t//*fileElementId:  用户选择文件的<input type=\"file\"/>的id\r\n");
      out.write("\t\t\t\tfileElementId:\"fileID\",\r\n");
      out.write("\t\t\t\t//dataType:指定服务器返回的数据类型  \r\n");
      out.write("\t\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\t\t//success: 服务器成功返回的回调函数  200\r\n");
      out.write("\t\t\t\tsuccess:function(data){ //data:返回的数据，如果dataType:\"json\"，那么data是json对象类型\r\n");
      out.write("\t\t\t\t\tif(data.success){\r\n");
      out.write("\t\t\t\t\t\t//刷新datagrid\r\n");
      out.write("\t\t\t\t\t\t$(\"#list\").datagrid(\"reload\");\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t//关闭导入窗口\r\n");
      out.write("\t\t\t\t\t\t$(\"#importWin\").window(\"close\");\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert(\"提示\",\"excel导入成功\",\"info\");\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert(\"提示\",\"excel导入失败：\"+data.msg,\"error\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t//error:服务器返回失败    404 500\r\n");
      out.write("\t\t\t\terror:function(e){\r\n");
      out.write("\t\t\t\t\talert(e);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//导出区域excel文件\r\n");
      out.write("\t\t$(\"#excelExportBtn\").click(function(){\r\n");
      out.write("\t\t\t//提交搜索表单\r\n");
      out.write("\t\t\t$(\"#searchForm\").submit();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
