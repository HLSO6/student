<%--
  Created by IntelliJ IDEA.
  User: lu
  Date: 2020/7/9
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生信息管理与分析系统</title>
    <script type="text/javascript">
        function stuManager() {
            location.href = "findStudentsByPage";
        }
        function gotoView() {
            location.href = "showView";
        }
    </script>
    <script src="static/bootstrap/js/jquery-3.5.1.js" type="text/javascript">
    </script>
    <link rel="stylesheet" type="text/css" href="static/bootstrap/css/bootstrap.css"/>
    <script src="static/bootstrap/js/bootstrap.js" type="text/javascript">
    </script>
    <script type="text/javascript" src="static/js/echarts.min.js"></script>
</head>
<body>
<div class="jumbotron">
    <div class="container">
        <h1 style="margin-left: 15px">欢迎使用学生信息管理与分析系统</h1>
        <p>请选择一个您要操作的功能吧！</p>

        <button class="btn btn-primary" type="submit" onclick="stuManager()">
            <span class="glyphicon glyphicon-user"></span>
            展示学员信息
        </button>
        <button class="btn btn-success" type="submit" onclick="gotoView()">
            <span class="glyphicon glyphicon-signal"></span>
            学员数据统计
        </button>
    </div>
</div>
</body>
</html>
