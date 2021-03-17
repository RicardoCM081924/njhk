layui.config({
    base: '../../layuiadmin/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'form', 'upload','table', 'laydate'], function () {
    var $ = layui.$
        , form = layui.form
        , upload = layui.upload
        , table = layui.table
        ,laydate=layui.laydate;
    var formSelects = layui.formSelects;


    //获取当前预警条件
    //密度预警条件
    $.ajax({
        url: "../../getDensityWarning",
        type: "post",
        dataType: "json",
        success: function (result) {
            $("#density").val(result);
        }
    });


    //监听表单提交
    //密度
    form.on('submit(formDensity)', function(data){
        var field = data.field;
        var newVal = field.density;
        // layer.msg(JSON.stringify(data.field));
        $.ajax({
            url:"../../getUserInfo"
            ,type:"post"
            ,dataType:"json"
            , success:function (result) {
                if (result[0].authority == 1) {
                    $.ajax({
                        url: "../../updateDensityWarning",
                        type: "post",
                        data: {'newVal': newVal},
                        dataType: "json",
                        success: function (result) {
                            if (result == 1) {
                                layer.msg("修改成功！");
                            } else {
                                layer.msg("请稍后再试！");
                            }
                        }
                    });
                } else {
                    layer.msg("对不起，您不具备修改权限，请与管理员联系！")
                }
            }
        });
        return false;
    });

    //Excel模板导出
    form.on('submit(download)', function(data){
        $.ajax({
            url:"../../getUserInfo"
            ,type:"post"
            ,dataType:"json"
            , success:function (result) {
                if (result[0].authority == 1) {
                    $.ajax({
                        url: "../../downloadExcelTem",
                        type: "post",
                        success: function (result) {
                            if (result == 1) {
                                layer.msg("导出成功！");
                            } else {
                                layer.msg("导出失败，请稍后再试！");
                            }
                        }
                    });
                } else {
                    layer.msg("对不起，您不具备修改权限，请与管理员联系！")
                }
            }
        });
        return false;
    });

    //数据导入
    var uploadInst = upload.render({
        elem: '#uploadExcel' //绑定元素
        ,url: '../../uploadExcel' //上传接口
        ,accept: 'file'
        ,exts: 'xlsx|xls'
        ,done: function(res){
            //上传完毕回调
            layer.msg("数据导入成功！");
        }
        ,error: function(){
            //请求异常回调
            layer.msg("数据导入失败，请稍后再试！");
        }
    });

    //图片显示
    form.on('submit(showPic)', function(data){
        $('#picture').show();

        var x;
        var y_min;
        var y_max;
        //级配预警条件
        $.ajax({
            url: "../../getGranularWarningxList",
            type: "post",
            dataType: "json",
            async : false,
            success: function (result) {
                console.log("x是"+result);
                x = result;
            }
        });
        $.ajax({
            url: "../../getGranularWarningyMinList",
            type: "post",
            dataType: "json",
            async : false,
            success: function (result) {
                console.log("y_min是"+result);
                y_min = result;
            }
        });
        $.ajax({
            url: "../../getGranularWarningyMaxList",
            type: "post",
            dataType: "json",
            async : false,
            success: function (result) {
                console.log("y_max是"+result);
                y_max = result;
            }
        });

        //把数据拼成Echarts的形式
        console.log("**********")
        var line1 = [],line2 = [];
        for (i = 0; i < x.length; i++) {
            // console.log(x[i]);
            // line1[i] = new Array(2);
            // line1[i][0] = x[i];
            // line1[i][1] = y_min[i];
            line1[i] = [x[i],y_min[i]];
            line2[i] = [x[i],y_max[i]];
            console.log(line1);
        }
        console.log("**********")

        // $("#picture_body").css("background-image", "url('../assets/img/07级配.jpg')");

        var htm = "级配预警区间图";
        $("#picture_header").html(htm);
        var mychart = echarts.init(document.getElementById('picture_body'));
        // 指定图表的配置项和数据
        var option = {
            title: {
                show: false,
                text: '级配预警区间图',
                x: 'center',
                textStyle:{
                    fontWeight:'normal'
                }
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: [ '上限', '下限'],
                textStyle: {
                    fontSize: 16
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
                show: true,
                feature: {
                    restore: {show: true, title:'重置'},
                    saveAsImage: {show: true}
                }
            },
            calculable: true,
            xAxis: {
                type: 'value',
                name: '粒径/mm'
            },
            yAxis: {
                type: 'value',
                name: '百分比/%'
            },
            series: [
                {
                    data: line1,
                    name: '下限',
                    type: 'line',
                    smooth: true
                },{
                    data: line2,
                    name: '上限',
                    type: 'line',
                    smooth: true
                }
            ]
        };
        // 使用刚指定的配置项和数据显示图表。
        mychart.setOption(option);

        return false;
    });

    //级配
    // form.on('submit(formGranular)', function(data){
    //     var field = data.field;
    //     var newVal_x = field.granular_x;
    //     var newVal_y_min = field.granular_y_min;
    //     var newVal_y_max = field.granular_y_max;
    //
    //     // layer.msg(JSON.stringify(data.field));
    //     $.ajax({
    //         url:"../../getUserInfo"
    //         ,type:"post"
    //         ,dataType:"json"
    //         , success:function (result) {
    //             if (result[0].authority == 1) {
    //                 $.ajax({
    //                     url: "../../updateGranularWarning",
    //                     type: "post",
    //                     data: {'newVal_x':newVal_x,
    //                         'newVal_y_min':newVal_y_min,
    //                         'newVal_y_max':newVal_y_max},
    //                     dataType: "json",
    //                     success: function (result) {
    //                         if (result == 1) {
    //                             layer.msg("修改成功！");
    //                         } else {
    //                             layer.msg("请稍后再试！");
    //                         }
    //                     }
    //                 });
    //             } else {
    //                 layer.msg("对不起，您不具备修改权限，请与管理员联系！")
    //             }
    //         }
    //     });
    //     return false;
    // });


});