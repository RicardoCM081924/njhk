layui.config({
    base: '../../layuiadmin/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'table',  'element', 'laydate', 'layer', 'form', 'carousel'] , function () {
    var $ = layui.$,
        table = layui.table,
        admin = layui.admin,
        element = layui.element,
        laydate = layui.laydate,
        layer = layui.layer,
        form = layui.form,
        carousel = layui.carousel;

    var result;
    $.ajax({
        url: '../../getRollingLayMessage',
        dataType: 'json',
        async: false,
        success: function (obj) {
            result = obj;
            console.log("result是"+result);
        }
    });

    //每一层碾压情况信息
    rollingLayMessage();

    function rollingLayMessage(){
        var firLay = result[0];
        var SecLay = result[1];
        var ThirdLay = result[2];
        var FourthLay = result[3];
        var FifthLay = result[4];
        var SixthLay = result[5];

        $("#time-1").html(firLay.substr(5,10));
        $("#time-2").html(SecLay.substr(5,10));
        $("#time-3").html(ThirdLay.substr(5,10));
        $("#time-4").html(FourthLay.substr(5,10));
        $("#time-5").html(FifthLay.substr(5,10));
        $("#time-6").html(SixthLay.substr(5,10));

        $("#content-1").html(firLay);
        $("#content-2").html(SecLay);
        $("#content-3").html(ThirdLay);
        $("#content-4").html(FourthLay);
        $("#content-5").html(FifthLay);
        $("#content-6").html(SixthLay);
    }

    var width_window = $(window).width() * 0.7;
    var height_window = $(window).height() * 0.7;

    var overview_carousel = carousel.render({
        elem: '#carousel'
        , width: width_window
        , height: height_window
        , arrow: 'hover' //箭头显示方式
        , anim: 'default' //切换动画方式
        , interval: '3000'
    });
    
    $(function () {
        new Swiper(".swiper-container", {
            //默认功能属性
            speed: 2000
            , slidesPerView: 3
            , spaceBetween: 0
            , slidesPerGroup: 3
            , loop: true
            , autoplay: {
                delay:6000
            }
            //分页索引
            , pagination: {
                el: ".swiper-pagination"
                , clickable: true
            }
            //分页按钮
            , navigation: {
                nextEl: ".swiper-button-next"
                , prevEl: ".swiper-button-prev"
            }

        });
    })






});