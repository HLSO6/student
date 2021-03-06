<%--
  Created by IntelliJ IDEA.
  User: lu
  Date: 2020/7/17
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息管理与分析系统</title>
    <script src="static/bootstrap/js/jquery-3.5.1.js" type="text/javascript">
    </script>
    <link rel="stylesheet" type="text/css" href="static/bootstrap/css/bootstrap.css"/>
    <script src="static/bootstrap/js/bootstrap.js" type="text/javascript">
    </script>

    <%--  页面加载时，把区域异步加载了 ，Ajax --%>
    <script type="text/javascript">
        $(document).ready(function () {
            loadAreas();
        });

        //加载地区信息
        function loadAreas() {
            var area = $("#areaSelect");
            var str = "<option>请选择---</option>";

            $.post("findAllAreas",null,function (data) {
                // console.log(data);
                for (let i = 0; i < data.length; i++) {
                    str += "<option value='"+data[i].aid+"'>" + data[i].aname+"</option>";
                }
                //拼接到area
                area.html(str);
            },"json");

        }
        function loadSchool(id) {
            var area = $("#scSelect");
            var str;
            $.post("findSchoolsById",{id:$("#areaSelect").val()},function (data) {
                // console.log(data);
                for (let i = 0; i < data.length; i++) {
                    str += "<option value='"+data[i].scid+"'>" + data[i].scname+"</option>";
                }
                //拼接到area
                area.html(str);
            },"json");
        }
    </script>
</head>
<body>
<div>
    <div  class="page-header">
        <h1>添加考试信息</h1>
    </div>

    <form action="insertStudent" method="get">
        <table class="table table-hover">
            <tr>
                <th style="text-align: right">考生姓名：</th>
                <td>
                    <input class="form-control" required type="text" placeholder="请输入考生姓名"
                           name="sname"/>
                </td>
                <th style="text-align: right">考生性别:</th>
                <td>
                    <select name="sex" required class="form-control">
                        <option value="">请选择</option>
                        <option value="1">男</option>
                        <option value="0">女</option>
                    </select>
                </td>
                <th style="text-align: right">出生日期:</th>
                <td>
                    <input class="form-control" required name="birthday" type="date"/>
                </td>
            </tr>
            <tr>
                <th style="text-align: right">准考证号:</th>
                <td>
                    <input name="examnum" class="form-control" required type="text" placeholder="请输入准考证号"/>
                </td>
                <th style="text-align: right">考生考区:</th>
                <td>
                    <div class="form-inline">
                        <select class="form-control" id="areaSelect" required onchange="loadSchool()"></select>
                        <select class="form-control" id="scSelect" name="scid" required>
                            <option>请选择---</option>
                        </select>
                    </div>

                </td>
                <th style="text-align: right">语文成绩:</th>
                <td>
                    <input class="form-control" name="scoreMap['语文']" type="text" placeholder="请输入语文成绩">
                </td>
            </tr>
            <tr>
                <th style="text-align: right">数学成绩:</th>
                <td>
                    <input class="form-control" name="scoreMap['数学']" type="text" placeholder="请输入数学成绩">
                </td>
                <th style="text-align: right">英语成绩:</th>
                <td>
                    <input class="form-control" name="scoreMap['英语']" type="text" placeholder="请输入英语成绩">
                </td>
                <th style="text-align: right">综合成绩:</th>
                <td>
                    <input class="form-control" name="scoreMap['综合']" type="text" placeholder="请输入综合成绩">
                </td>
            </tr>
            <tr>
                <th colspan="6" style="text-align: center">
                    <button type="submit" class="btn btn-success">
                        <span class="glyphicon glyphicon-ok"></span>确定
                    </button>
                    <button type="reset" class="btn btn-danger" onclick="javascript:history.go(-1);">
                        <span class="glyphicon glyphicon-remove"></span>取消
                    </button>
                </th>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
