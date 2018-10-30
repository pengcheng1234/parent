<%--
  Created by IntelliJ IDEA.
  User: lipengcheng6
  Date: 2018/7/24
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/default/easyui.css">
    <base href="<%=request.getContextPath()%>/">
    <script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.min.js"></script>
    <title>数据统计界面</title>
</head>
<body class="easyui-layout" fit="true" >
<div data-options="region:'center'" sytle="background:#fffffff">
    <div id="toolbarVarieties" class="datagrid-toolbar" sytle="background-color:white">
        <form id="form" action = "/LPC/varieties/exportExcel" method="post">
            <input name="colcom" id="colcom" type="hidden"/>
            <table align="center" style="margin-top:10px;">
                <tr style="margin:10px auto;"  align="center" >
                    <td align="right">名称：</td>
                    <td><input class="easyui-validatebox" id="name" name="name" type="text"/></td>
                    <td align="right">别名：</td>
                    <td><input class="easyui-validatebox" id="otherName" name="otherName" type="text"/></td>
                    <td align="right">单位：</td>
                    <td><input class="easyui-numberbox" id="unit" name="unit" type="text"/></td>
                    <td align="right">货架号：</td>
                    <td><input class="easyui-numberbox" id="shelvesNo" name="shelvesNo" type="text"/></td>
                    <td align="right">批号：</td>
                    <td><input class="easyui-validatebox" id="coding" name="coding" type="text"/></td>
                    <td><a class="easyui-linkbutton"  plain="false" onclick="searchDate()" href="javascript:void(0)">查询</a></td>
                    <td><a class="easyui-linkbutton"  plain="false" onclick="clearDate()" href="javascript:void(0)">清空</a></td>
                </tr>
            </table>
            </form>
    </div>
    <table id="dgVarieties"
           data-options="
				fit: true,
				border: false,
				rownumbers: true,
				animate: true,
				collapsible: false,
				fitColumns: true,
        		loadMsg:'数据加载中...',
				toolbar:'#toolbarVarieties',
				autoRowHeight: false,
				idField :'id',
				singleSelect: true,
				checkOnSelect: true,
				selectOnCheck: false,
				pagination:true,
				pageSize:dataOptions.pageSize,
				pageList:dataOptions.pageList,
				striped:true">
        <thead>
        <tr>
            <th data-options="field:'id', halign:'center'" width="220">表主键</th>
            <%--<th data-options="field:'id', halign:'center'" width="220">表主键</th>--%>
            <%--<th data-options="field:'name', halign:'center'" width="60">名称</th>--%>
            <%--<th data-options="field:'otherName', halign:'center'" width="60">别名</th>--%>
            <%--<th data-options="field:'remaining', halign:'center'" width="80">余量</th>--%>
            <%--<th data-options="field:'unit', halign:'center'" width="50">单位 </th>--%>
            <%--<th data-options="field:'coding', halign:'center'" width="80">批号</th>--%>
            <%--<th data-options="field:'standard', halign:'center'" width="80">规格</th>--%>
            <%--<th data-options="field:'address', halign:'center'" width="50">产地</th>--%>
            <%--<th data-options="field:'oriPrice', halign:'center'" width="80">进价</th>--%>
            <%--<th data-options="field:'wholesalePrice', halign:'center'" width="80">批发售价</th>--%>
            <%--<th data-options="field:'prescriptionPrice', halign:'center'" width="80">抓方售价</th>--%>
            <%--<th data-options="field:'zyyPrice', halign:'center'" width="80">中医院售价</th>--%>
            <%--<th data-options="field:'tyyyPrice', halign:'center'" width="90">同益医院售价</th>--%>
            <%--<th data-options="field:'wphPrice', halign:'center'" width="80">王普华售价</th>--%>
            <%--<th data-options="field:'ctPrice', halign:'center'" width="80">城坦售价</th>--%>
            <%--<th data-options="field:'shelvesNo', halign:'center'" width="80">货架号</th>--%>
            <%--<th data-options="field:'remark', halign:'center',formatter:toshow" width="80">备注</th>--%>
            <%--<th data-options="field:'createDate', halign:'center',formatter:formatTime" width="80">创建时间</th>--%>
        </tr>
        </thead>
    </table>
</div>
</div>




<script type="text/javascript">
    var url;
    $(function() {
        $("#importDialog").dialog('close');
        clearDate();
        url='${url}';
        var contextPath='${pageContext.request.contextPath}'; //就是/LPC
    });

    //添加页面
    function add(){
        addPage = new CommonDialog("insert","600","450",'/LPC/management/Varieties/varietiesAdd.jsp',"添加品种",false,true,false);
        addPage.show();
    }

    //查询数据
    function searchDate(){
        $('#dgVarieties').datagrid({
            url:'/LPC/varieties/getVarietiesData',
            queryParams: {param : JSON.stringify(serializeObject($('#form').form()))}
        });
        $('#dgVarieties').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
    }

    //编辑
    function edit(){
        var rows = $('#dgVarieties').datagrid('getChecked');
        if(rows.length !== 1){
            $.messager.alert("提示","请选择一条数据编辑！");
            return false;
        }
        editPage = new CommonDialog("edit","600","450",'Edit/'+rows[0].id,"编辑品种",false,true,false);
        editPage.show();
    }

    //清空查询条件
    function clearDate(){
        $('#form').form().find('input').val('');
        searchDate();
    }
    //关闭窗口
    function closeDialog(dialogId){
        $(dialogId).dialog('close');
    }
    //重新加载数据
    function reloadData(){
        $('#dgVarieties').datagrid('reload',{});
        $('#dgVarieties').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
        $.messager.show({
            title : '提示',
            msg : '保存成功！'
        });
    }

    //格式化时间
    function formatTime(value){
        if(value==null){
            return "";
        }
        return "<div title='"+new Date(value).format("yyyy-MM-dd hh:mm:ss")+"'>"+new Date(value).format("yyyy-MM-dd hh:mm:ss")+"</div>";
    }

    function toshow(value){
        return "<div title='"+value+"'>"+value+"</div>";
    }
</script>
</body>
</html>
