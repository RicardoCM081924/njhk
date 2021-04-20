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

    selectvehiclemodel();

//页面加载完成后，加载高程下拉框
    function selectvehiclemodel() {
        var $ = layui.$;
        var form = layui.form;
        $.ajax({
            url: "../../getVehicleModel",
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
                        form.render('select', "type");// 刷性type，显示出数据
                    }
                }
            }
        });
    };

    function selectvehiclemodel() {
        var $ = layui.$;
        var form = layui.form;
        $.ajax({
            url: "../../getVehicleModel",
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
                        form.render('select');// 刷性type，显示出数据
                    }
                }
            }
        });
    };

    function getdensity() {
        var $ = layui.$;
        $.ajax({
            url: "../../getChosenDensity",
            type: "get",
            data: {level: $("#level").val()},
            dataType: "json",
            success: function (result) {
                for (let i = 0; i < result.length; i++) {
                    result[i] = Object.values(result[i]);//将对象转为数组
                }
                showdensity(result, $("#level").val());
            }
        });
    };

    form.on('submit(level_select)', function () {
        getdensity();
    });
});

