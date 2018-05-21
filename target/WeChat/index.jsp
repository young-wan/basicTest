<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="./jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="./jquery.form.js"></script>
    <title>Excel导入测试</title>
    <script type="text/javascript">

        //JS校验form表单信息
        function checkData(){
            var fileDir = $("#upfile").val();
            var suffix = fileDir.substr(fileDir.lastIndexOf("."));
            if("" == fileDir){
                alert("选择需要导入的Excel文件！");
                return false;
            }
            if(".xls" != suffix && ".xlsx" != suffix ){
                alert("选择Excel格式的文件导入！");
                return false;
            }
            return true;
        }
    </script>
</head>

<body>
<div>1.通过简单的form表单提交方式，进行文件的上 </div>
<form method="POST"  enctype="multipart/form-data" id="form1" action="excel/upload">
    <table>
        <tr>
            <td>上传文件: </td>
            <td> <input id="upfile" type="file" name="upfile"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交" onclick="return checkData()"></td>
        </tr>
    </table>
</form>

</body>
</html>