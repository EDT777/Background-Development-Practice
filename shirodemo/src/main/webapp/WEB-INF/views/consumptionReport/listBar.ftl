<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="/js/plugins/echarts/echarts.common.min.js"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 1200px;height:600px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                crossStyle: {
                    color: '#999'
                }
            }
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data: ['总消费金额', '总优惠金额', '总实收金额','总订单数']
        },
        xAxis: [
            {
                type: 'category',
                data: ${xList},
                axisPointer: {
                    type: 'shadow'
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '金额',
                min: 0,
               // max: 250,
               //  interval: 5000,
                axisLabel: {
                    formatter: '{value} '
                }
            },
            {
                type: 'value',
                name: '数量',
                min: 0,
                // max: 25,
                //interval: 5,
                axisLabel: {
                    formatter: '{value} '
                }
            }
        ],
        series: [
            {
                name: '总消费金额',
                type: 'bar',
                data: ${totalList},
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            },
            {
                name: '总优惠金额',
                type: 'bar',
                data: ${discountList}
            },
            {
                name: '总实收金额',
                type: 'bar',
                data: ${payList}
            },
            {
                name: '总订单数',
                type: 'line',
                yAxisIndex: 1,
                data:  ${numberList}
            }
        ]
    };


    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>