<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lu
  Date: 2020/7/9
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息管理与分析系统</title>
    <script type="text/javascript">
        function updateUser(id) {
            location.href = "findStudentById?id=" + id;
        }

        function deleteUser(id) {
            var a = confirm("确定删除吗？");
            if (a) {
                location.href = "deleteStudentById?sid=" + id;
            }

        }

        function gotoPage(id) {
            location.href = "findStudentsByPage?pageIndex=" + id;
        }

        function goIndex() {
            location.href = "index.jsp";
        }

        function goAdd() {
            location.href = "addStudent.jsp";
        }

        function gotoPageForId(id, start, end) {
            location.href = "showPage?pageId=" + id + "&flag=" + true + "&start=" + start + "&end=" + end;
        }


    </script>
    <script src="static/bootstrap/js/jquery-3.5.1.js" type="text/javascript">
    </script>
    <link rel="stylesheet" type="text/css" href="static/bootstrap/css/bootstrap.css"/>
    <script src="static/bootstrap/js/bootstrap.js" type="text/javascript">
    </script>

    <link rel="stylesheet" href="static/css/common.css">
    <style>
        .spancolor {
            border-radius: 3px;
            background: #4E6EF2;
            color: #fff;
        }
    </style>
</head>
<body>
<script type="text/javascript">
    $(function () {
        var pageIndex = ${pageIndex};
        var pageCount = ${pageCount};

        var spanId = "span" + pageIndex;
        // console.log(spanId);
        $("." + spanId).addClass("spancolor");

        if (pageIndex === 1) {
            $("#firstPage").attr('disabled', true);
            $("#prePage").attr('disabled', true);
        } else {
            $("#firstPage").attr('disabled', false);
            $("#prePage").attr('disabled', false);
        }

        if (pageIndex === pageCount) {
            $("#lastPage").attr('disabled', true);
            $("#nextPage").attr('disabled', true);
        } else {
            $("#lastPage").attr('disabled', false);
            $("#nextPage").attr('disabled', false);
        }
    })

</script>

<div style="margin: 0 20px">
    <div class="page-header">
        <h1>学生信息展示</h1>
        <button type="button" class="btn btn-primary" onclick="goIndex()">
            <span class="glyphicon glyphicon-arrow-left"></span>返回上一页
        </button>
        <button type="button" class="btn btn-primary" onclick="goAdd()">
            <span class="glyphicon glyphicon-plus"></span>添加学生信息
        </button>
    </div>

    <table class="table table-striped table-hover">
        <tr class="active">
            <th colspan="12">一共查询出数据${counts}条，每页展示${pageSize}条,
                一共分${pageCount}页，当前为第${pageIndex}页
            </th>
        </tr>
        <tr class="danger">
            <th>学生编号</th>
            <th>所属考区</th>
            <th>所属学校</th>
            <th>学生姓名</th>
            <th>学生性别</th>
            <th>出生日期</th>
            <th>准考证号</th>
            <th>语文成绩</th>
            <th>数学成绩</th>
            <th>英语成绩</th>
            <th>综合成绩</th>
            <th>操作</th>
        </tr>

        <C:forEach items="${students}" var="u" varStatus="vs">
            <tr>
                    <%--                <td>${vs.count}</td>--%>
                <td>${u.sid}</td>
                <td>${u.aname}</td>
                <td>${u.scname}</td>
                <td>${u.sname}</td>
                <td>
                    <C:if test="${u.sex==0}">
                        女
                    </C:if>
                    <C:if test="${u.sex==1}">
                        男
                    </C:if>
                </td>
                <td>${u.birthday}</td>
                <td>${u.examnum}</td>
                <td>${u.scoreMap["语文"]}</td>
                <td>${u.scoreMap["数学"]}</td>
                <td>${u.scoreMap["英语"]}</td>
                <td>${u.scoreMap["综合"]}</td>
                <td>
                    <button class="btn btn-warning" type="submit" onclick="updateUser(${u.sid})">
                        <span class="glyphicon glyphicon-plus"></span>
                        修改
                    </button>
                    <button class="btn btn-danger" type="submit" onclick="deleteUser(${u.sid})">
                        <span class="glyphicon glyphicon-minus"></span>
                        删除
                    </button>
                </td>
            </tr>

        </C:forEach>

    </table>
    <div class="footerd">


        <span style="margin-right: 3px">第${pageIndex}页</span>
        <button id="firstPage" class="btn btn-info" type="button" onclick="gotoPage(1)">
            <span class="glyphicon glyphicon-fast-backward"></span>
            首页
        </button>
        <button id="prePage" class="btn btn-success" type="button" onclick="gotoPage(${pageIndex-1})">
            <span class="glyphicon glyphicon-chevron-left"></span>
            上一页
        </button>

        <C:forEach var="i" begin="${pageIndex}" end="${pageIndex+3}">
            <span class="cv span${i}" onclick="gotoPage(${i})">${i}</span>
        </C:forEach>
        <button id="nextPage" class="btn btn-info" type="button" onclick="gotoPage(${pageIndex+1})">
            下一页
            <span class="glyphicon glyphicon-chevron-right"></span>
        </button>
        <button id="lastPage" class="btn btn-success" type="button" onclick="gotoPage(${pageCount})">
            尾页
            <span class="glyphicon glyphicon-fast-forward"></span>
        </button>

        <span style="margin-left: 3px">共${pageCount}页</span>

    </div>
</div>
</body>
</html>
