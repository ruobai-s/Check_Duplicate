$(function () {
    $('#file_submit').click(function (event) {
        console.log(new FormData($('#file_form')[0]));
        $.cors("http://101.37.174.206:8099/api/Add/Form",{
            type: "post",
            data: new FormData($('#file_form')[0]),
            processData: false,
            contentType: false,
            dataType:"json",
            success:function (data) {
                var td = "<button type='button' name='id' class='urls downloads' value="+data.id+">点此下载</button>";
                $('#download_address tr td:last').append(td);
                down();
            },

        })
    });
    $('#text_submit').click(function (event) {
        console.log($('#text_title').val()+""+$('#text_content').val());
        $.ajax({
            type: "post",
            url: "/redirect?name="+$('#text_title').val()+"&text="+$('#text_content').val(),
            data: JSON.stringify({'name':$('#text_title').val(),'text':$('#text_content').val()}),
            processData: false,
            contentType: "application/json; charset=utf-8",
            dataType:"json",
            success:function (data) {
                var td =
                    "<button type='button' name='id' class='urls downloads' value="+data.url+">点此下载</button>";
                $('#download_address tr td:last').append(td);
                down();
            },
        })
    });
    function down(obj){
        $('.downloads').click(function () {
            console.log(this);
            // console.log(this.prev().val());
            var url = "http://mooc1-1.chaoxing.com/ueditorupload/read?objectId="+$(this).val()+'&fileOriName=查重报告';
            console.log($(this).val());
            window.open(url);
        })
    }
})