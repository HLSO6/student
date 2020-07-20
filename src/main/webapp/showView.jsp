<%--
  Created by IntelliJ IDEA.
  User: lu
  Date: 2020/7/19
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生信息管理与分析系统</title>
    <script type="text/javascript" src="static/js/echarts.min.js"></script>
    <script src="static/bootstrap/js/jquery-3.5.1.js" type="text/javascript">
    </script>
    <link rel="stylesheet" type="text/css" href="static/bootstrap/css/bootstrap.css"/>
    <script src="static/bootstrap/js/bootstrap.js" type="text/javascript">
    </script>
    <!-- 引入CSS样式 -->
    <style type="text/css">
        strong{
            font-size: 50px;
            font-weight: bolder;
            color: #FF6666;
        }
    </style>
</head>
<body>
<%--分数线统计--%>
<div class="jumbotron">
    <div class="container">
        <h1><span class="glyphicon glyphicon-signal"></span> 学生数据统计<small>2018年高考数据概述</small></h1>
        <h2><span class="glyphicon glyphicon-cloud"></span> 高考数据分析</h2>
        <p class="lead" style="color: #999999;">
            2018年北京各地共有
            <strong>${scoreLine['t']}</strong>名学生参加了本次高考;<br />
            一本线(550分)<strong>${scoreLine['f']}</strong>人,过二本线(450分)<strong>${scoreLine['s']}</strong>人,
            过专科线(250分)有<strong>${scoreLine['z']}</strong>人,落榜有<strong>${scoreLine['o']}</strong>人;
        </p>
        <h2><span class="glyphicon glyphicon-cloud"></span> 详细内容请看统计图表</h2>

    </div>
</div>


<%--创建图表绘制区域--%>
<%--统计各个区域参加考试人数--%>
<h3><span class="glyphicon glyphicon-stats"></span>  图表1:各个区域参加考试人数</h3>
<div id="main" style="width: 1200px;height: 400px">
</div>
<script type="text/javascript">
    $.post("findAreaStudents",null,function (data) {
        //基于准备好的dom，初始化echarts实例
        var myChart=echarts.init(document.getElementById("main"));

        //指定图表的配置和数据
        var option = {
            //提示框，鼠标悬浮交互时的信息提示
            tooltip: {
                //触发类型，默认（'item'）数据触发，可选为：'item' | 'axis'
                trigger: 'axis'
            },
            //图例，每个图表最多仅有一个图例
            legend: {
                //显示策略，可选为：true（显示） | false（隐藏），默认值为true
                show: true,
                //水平安放位置，默认为全图居中，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
                x: 'center',
                //垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
                y: 'top',
                //legend的data: 用于设置图例，data内的字符串数组需要与sereis数组内每一个series的name值对应
                data: ['参考人数']
            },
            xAxis: {
                type: 'category',
                data: data[0]
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                name : '参考人数',
                data: data[1],
                type: 'bar',
                //系列中的数据标注内容
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                showBackground: true,
                backgroundStyle: {
                    color: 'rgba(220, 220, 220, 0.8)'
                },
                //系列中的数据标线内容
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            }]
        };
        //使用指定的数据项和数据显示图表
        myChart.setOption(option);
    },"json")


</script>
<%--统计各个区域各个分数线人数--%>
<h3><span class="glyphicon glyphicon-stats"></span>  图表2:各个区域各个分数线人数</h3>
<div id="main1" style="width: 1200px;height: 400px">
</div>
<script type="text/javascript">
    $.post("findAreaStudentsByLine",null,function (data) {
        //基于准备好的dom，初始化echarts实例
        var myChart=echarts.init(document.getElementById("main1"));

        //指定图表的配置和数据
        var  option = {
            backgroundColor:'#323a5e',
            tooltip: {
                trigger: 'axis',
                axisPointer: { // 坐标轴指示器，坐标轴触发有效
                    type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            grid: {
                left: '2%',
                right: '4%',
                bottom: '14%',
                top:'16%',
                containLabel: true
            },
            legend: {
                data: ['考试总人数', '一本人数', '二本人数','专科人数','落榜人数'],
                right: 10,
                top:12,
                textStyle: {
                    color: "#fff"
                },
                itemWidth: 12,
                itemHeight: 10,
                // itemGap: 35
            },
            xAxis: {
                type: 'category',
                data: data[0],
                axisLine: {
                    lineStyle: {
                        color: 'white'

                    }
                },
                axisLabel: {
                    // interval: 0,
                    // rotate: 40,
                    textStyle: {
                        fontFamily: 'Microsoft YaHei'
                    }
                },
            },

            yAxis: {
                type: 'value',
                max:'4000',
                axisLine: {
                    show: false,
                    lineStyle: {
                        color: 'white'
                    }
                },
                splitLine: {
                    show: true,
                    lineStyle: {
                        color: 'rgba(255,255,255,0.3)'
                    }
                },
                axisLabel: {}
            },
            "dataZoom": [{
                "show": true,
                "height": 12,
                "xAxisIndex": [
                    0
                ],
                bottom:'8%',
                "start": 10,
                "end": 90,
                handleIcon: 'path://M306.1,413c0,2.2-1.8,4-4,4h-59.8c-2.2,0-4-1.8-4-4V200.8c0-2.2,1.8-4,4-4h59.8c2.2,0,4,1.8,4,4V413z',
                handleSize: '110%',
                handleStyle:{
                    color:"#d3dee5",

                },
                textStyle:{
                    color:"#fff"},
                borderColor:"#90979c"
            }, {
                "type": "inside",
                "show": true,
                "height": 15,
                "start": 1,
                "end": 35
            }],
            series: [{
                name: '考试总人数',
                type: 'bar',
                barWidth: '10%',
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#fccb05'
                        }, {
                            offset: 1,
                            color: '#f5804d'
                        }]),
                        barBorderRadius: 12,
                    },
                },
                data: data[1]
            },
                {
                    name: '一本人数',
                    type: 'bar',
                    barWidth: '10%',
                    itemStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: '#8bd46e'
                            }, {
                                offset: 1,
                                color: '#09bcb7'
                            }]),
                            barBorderRadius: 11,
                        }

                    },
                    data: data[2]
                },
                {
                    name: '二本人数',
                    type: 'bar',
                    barWidth: '10%',
                    itemStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: '#248ff7'
                            }, {
                                offset: 1,
                                color: '#6851f1'
                            }]),
                            barBorderRadius: 11,
                        }
                    },
                    data: data[3]
                },
                {
                    name: '专科人数',
                    type: 'bar',
                    barWidth: '10%',
                    itemStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: '#248ff7'
                            }, {
                                offset: 1,
                                color: '#6851f1'
                            }]),
                            barBorderRadius: 11,
                        }
                    },
                    data: data[4]
                },
                {
                    name: '落榜人数',
                    type: 'bar',
                    barWidth: '10%',
                    itemStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: '#248ff7'
                            }, {
                                offset: 1,
                                color: '#6851f1'
                            }]),
                            barBorderRadius: 11,
                        }
                    },
                    data: data[5]
                }]
        };



        //使用指定的数据项和数据显示图表
        myChart.setOption(option);
    },"json")


</script>
<h3><span class="glyphicon glyphicon-stats"></span>  图表3:各录取线占比情况</h3>
<div id="main2" style="width: 1200px;height: 400px">
</div>
<script type="text/javascript">
    $.post("findAreaStudents",null,function (data) {
        //基于准备好的dom，初始化echarts实例
        var myChart=echarts.init(document.getElementById("main2"));

        //指定图表的配置和数据
       var option = {
            title: {
                text: '各录取线占比情况',
                // subtext: '',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: '{a} <br/>{b} : {c} ({d}%)'
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['一本录取', '二本录取', '专科录取', '未录取']
            },
            series: [
                {
                    name: '访问来源',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    data: [
                        {value: ${scoreLine['t']}, name: '一本录取'},
                        {value: ${scoreLine['s']}, name: '二本录取'},
                        {value: ${scoreLine['z']}, name: '专科录取'},
                        {value: ${scoreLine['o']}, name: '未录取'},
                    ],
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };


        //使用指定的数据项和数据显示图表
        myChart.setOption(option);
    },"json")


</script>
<h3>
    <C:set var="bzb" value="${(scoreLine['f']+scoreLine['s'])*100/scoreLine['t']}" />
    <span class="glyphicon glyphicon-stats"></span>  图表4:综合评定2018年北京市高考情况(本科录取率${bzb}%)判定为:
    <C:if test="${bzb >=0 && bzb <= 33}">
        <strong style="color: red;">C级(较差)</strong>
    </C:if>
    <C:if test="${bzb >=34 && bzb <= 67}">
        <strong style="color: blue;">B级(中等)</strong>
    </C:if>
    <C:if test="${bzb >=68 && bzb <= 100}">
        <strong style="color: green;">A级(良好)</strong>
    </C:if>
</h3>
<div id="main3" style="width: 1200px;height: 400px">
</div>
<script type="text/javascript">
    $.post("findAreaStudents",null,function (data) {
        //基于准备好的dom，初始化echarts实例
        var myChart=echarts.init(document.getElementById("main3"));

        //指定图表的配置和数据
        var option = {
            tooltip: {
                formatter: '{a} <br/>{b} : {c}%'
            },
            toolbox: {
                feature: {
                    restore: {},
                    saveAsImage: {},
                    dataZoom:{}
                }
            },
            series: [
                {
                    name: '本科占比',
                    type: 'gauge',
                    detail: {formatter: '{value}%'},
                    data: [{value: ${bzb}, name: '本科占比'}]
                }
            ]
        };


        //使用指定的数据项和数据显示图表
        myChart.setOption(option);
    },"json")


</script>
</body>
</html>
