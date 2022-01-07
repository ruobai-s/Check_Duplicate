$(function () {
    zuo_list_checked();
    zuo_hua();
    refresh();
})

//左导航栏点击变色
function zuo_list_checked() {
    $("#zuo-list li").click(function () {
        for(let i=0;i<$("#zuo-list li").length;i++){
            if(this!=$("#zuo-list li")[i])
                $($("#zuo-list li")[i]).css("backgroundColor","#001529");
            else
            {
                $($("#zuo-list li")[i]).css("backgroundColor","#1890FF");
                switch_you(i);
            }

        }
    });
}
//左导航栏缩小
function zuo_hua() {
    let num=0;
    $("#zuo-btn").click(function () {
        num++;
        if(num%2==1)
        {
            $(".zuo-title").hide();
            $(".zuo-core").removeClass("col-sm-2").addClass("col-sm-1");
            $(".you-core").addClass("col-sm-11").removeClass("col-sm-10");
            $(this).addClass("icon-fold-right").removeClass("icon-shouqi");
        }
        else
        {
            $(".zuo-core").addClass("col-sm-2").removeClass("col-sm-1");
            $(".you-core").addClass("col-sm-10").removeClass("col-sm-11");
            $(this).removeClass("icon-fold-right").addClass("icon-shouqi");
            $(".zuo-title").show();
        }
    });
}
// 切换右边界面
function switch_you(index){
    for(let i=0;i<$(".you-center").length;i++){
        if(index==i)
            $($(".you-center")[i]).addClass("show").removeClass("hidden");
        else
            $($(".you-center")[i]).removeClass("show").addClass("hidden");
    }
}
function refresh(){
    $("#refresh").click(function () {
        $("#refresh").addClass("rotate");
        window.location.reload();
    });
}