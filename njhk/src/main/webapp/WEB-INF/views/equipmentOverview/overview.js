layui.config({
    base: '../../layuiadmin/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'form', 'upload', 'table', 'laydate',], function () {
    var $ = layui.$
        , form = layui.form
        , upload = layui.upload
        , table = layui.table
        , laydate = layui.laydate
    ;
    selectvehicletype();
    selectvehiclemodel();
    selectvehiclefactory();
    selectvehiclesim();

//页面加载完成后，加载高程下拉框
    function selectvehicletype() {
        $.ajax({
            url: "../../getVehicleType",
            type: "post",
            dataType: "json",
            success: function (result) {
                console.log(result);
                var role = document.getElementById("type");//add_role_name给select定义的id
                //console.log(result[0]);
                for (var i = 0; i < result.length; i++) {
                    if (result[i] != null) {
                        var option = document.createElement("option");    // 创建添加option属性
                        option.setAttribute("value", result[i]);                  // 给option的value添加值
                        option.innerText = result[i];             // 打印option对应的纯文本 （超级管理员、管理员）
                        role.appendChild(option);                          // 给select 添加option子标签
                        form.render('select');// 刷性select，显示出数据
                    }
                }
            }
        });
    };

    function selectvehiclemodel() {
        $.ajax({
            url: "../../getVehicleModel",
            type: "post",
            dataType: "json",
            success: function (result) {
                console.log(result);
                var role = document.getElementById("model");//add_role_name给select定义的id
                //console.log(result[0]);
                for (var i = 0; i < result.length; i++) {
                    if (result[i] != null) {
                        var option = document.createElement("option");    // 创建添加option属性
                        option.setAttribute("value", result[i]);                  // 给option的value添加值
                        option.innerText = result[i];             // 打印option对应的纯文本 （超级管理员、管理员）
                        role.appendChild(option);                          // 给select 添加option子标签
                        form.render('select');// 刷性select，显示出数据
                    }
                }
            }
        });
    };

    function selectvehiclefactory() {
        $.ajax({
            url: "../../getVehicleFactory",
            type: "post",
            dataType: "json",
            success: function (result) {
                console.log(result);
                var role = document.getElementById("factory");//add_role_name给select定义的id
                //console.log(result[0]);
                for (var i = 0; i < result.length; i++) {
                    if (result[i] != null) {
                        var option = document.createElement("option");    // 创建添加option属性
                        option.setAttribute("value", result[i]);                  // 给option的value添加值
                        option.innerText = result[i];             // 打印option对应的纯文本 （超级管理员、管理员）
                        role.appendChild(option);                          // 给select 添加option子标签
                        form.render('select');// 刷性select，显示出数据
                    }
                }
            }
        });
    };

    function selectvehiclesim() {
        $.ajax({
            url: "../../getVehicleSim",
            type: "post",
            dataType: "json",
            success: function (result) {
                console.log(result);
                var role = document.getElementById("sim");//add_role_name给select定义的id
                //console.log(result[0]);
                for (var i = 0; i < result.length; i++) {
                    if (result[i] != null) {
                        var option = document.createElement("option");    // 创建添加option属性
                        option.setAttribute("value", result[i]);                  // 给option的value添加值
                        option.innerText = result[i];             // 打印option对应的纯文本 （超级管理员、管理员）
                        role.appendChild(option);                          // 给select 添加option子标签
                        form.render('select');// 刷性select，显示出数据
                    }
                }
            }
        });
    };

    form.on('submit(level_select)', function () {
        getdensity();
    });

    form.on('submit(submit)', function () {
        routine_report_list();
    });

    function routine_report_list() {
        $("#showcard1").show();
        table.render({

            elem: '#vehicle_list'
            , url: '../../getVehicleBase'
            , where: {
                'type': $("#type").val(),
                'model': $("#model").val(),
                'id': $("#id").val(),
                'rackid': $("#rackid").val(),
                'type': $("#type").val(),
                'vendors': $("#factory").val(),
                'sim': $("#sim").val(),
                'vehicleowners': $("#username").val()
            }
            , cols: [[
                {field: 'vehicletype', align: 'center', width: '7%', title: '设别类型', unresize: true}
                , {field: 'vehiclemodel', align: 'center', width: '10%', title: '设备型号', unresize: true}
                , {field: 'vehicleid', align: 'center', width: '6%', title: '设备编号', sort: true, unresize: true}
                , {field: 'engineid', align: 'center', width: '5%', title: '吨位', unresize: true}
                , {field: 'rackid', align: 'center', width: '9%', title: '设别类型', unresize: true}
                , {field: 'gpsid', align: 'center', width: '7%', title: 'SIM卡号', unresize: true}
                , {field: 'vendors', align: 'center', width: '6%', title: '厂家', unresize: true}
                , {field: 'buyways', align: 'center', width: '16%', title: '工地名称', unresize: true}
                , {field: 'purchasedate', align: 'center', width: '6%', title: '购买日期', unresize: true}
                , {field: 'vehicleowners', align: 'center', width: '10%', title: '用户名称', unresize: true}
                , {field: 'onlinestate', align: 'center', width: '5%', title: '是否在线', unresize: true}
                , {field: 'rectime', align: 'center', width: '9%', title: '最后信息时间', unresize: true}
                , {field: 'right', align: 'center', toolbar: '#barDemo', title: '操作', unresize: true}
            ]]
        })


    }

    table.on('tool(bar)', function (obj) {

        var dat = obj.data.basetable_id;
        console.log(obj.data);

        if (obj.event == 'detail') {
            layer.open({
                type: 2
                , title: '设备详情'
                , content: 'vehicle_detail.html'
                , maxmin: true
                , area: ['99%', '99%']
                , btnAlign: 'c'
                , success: function (layero, index) {
                    var body = layer.getChildFrame('body', index);
                    body.find('input#routine_list').val(dat);
                    body.find('input#routing_staff').val(obj.data.routine_staff);
                    body.find('input#time').val(obj.data.routine_start_time);
                    // layer.close(index);
                }
            })


            //layer.alert('ID：' + data.id + ' 的查看操作'+data.routing_time);
        }
        // if(obj.event=='edit') {
        //     layer.alert('ID：' + obj.data.id + ' 的导出操作'+obj.data.routing_time);
        // }
    });

});

