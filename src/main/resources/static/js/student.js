layui.use('table', function(){
    var table = layui.table;
    table.render({
        elem: '#test'
        ,url:'/studentData'
        ,method:'post'
        ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        ,defaultToolbar: ['filter', 'exports', 'print']
        ,title: '用户数据表'
        ,totalRow: true
        ,cols: [
            [
                {type: 'checkbox', fixed: 'left'}
                ,{field:'sno', title:'学号',  fixed: 'left',sort:true ,unresize: true}
                ,{field:'name', title:'姓名',sort:true}
                ,{field:'sex', title:'性别', sort: true,toolbar:'#sexDemo'}
                ,{field:'college', title:'学院'}
                ,{field:'classroom', title:'行政班级',sort:true,edit:'text'}
                ,{field:'phone', title:'电话号码',edit:'text'}
                ,{field:'password', title:'密码',edit:'text'}
                ,{fixed:'right', title:'操作', toolbar: '#barDemo', width:150}
            ]
        ]
        ,page: true
    });
    //头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'getCheckData':
                var data = checkStatus.data;
                layer.alert(JSON.stringify(data));
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
                break;
            case 'isAll':
                layer.msg(checkStatus.isAll ? '全选': '未全选');
                break;
        };
    });
    //监听行工具事件
    table.on('tool(test)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                deleteStudent(data,index);
                layer.close(index);
            });
        } else if(obj.event === 'edit'){
            layer.confirm('真的修改'+data.sno+'信息吗',function(index){
                updateStudent(data,index,obj);
                layer.close(index);
            });
        }
    });
});
layui.use('layer',function () {
    var $ = layui.$,layer = layui.layer;
    $('#addStudentData').click(function () {
        addStudent();
    })
})
function addStudent(){
    var $ = layui.$,layer = layui.layer;
    layui.use('form', function(){
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function(data){
            $.ajax({
                url: "/addStudent",
                type: 'post',
                contentType: 'application/json;charset=utf-8',
                data:JSON.stringify(data.field),
                dataType: 'json',
                success: function (data) {
                    if (data===true){
                        document.getElementById("studentData").reset();
                        table_reload();
                    }else{
                        layer.msg("添加失败");
                    }
                }
            })
        });
    });
}
//表格重载
function table_reload() {
    var table = layui.table;
    layui.use('table',function () {
        layer.msg("修改成功",{icon:6},function () {
            table.reload('test');
        })
    })
}
function deleteStudent(data){
    $.ajax({
        url: "/deleteStudent",
        type: "DELETE",
        data:{sno:data.sno},    //这个是传给后台的值
        dataType: "json",
        success: function(data){
            layer.close(index);
            if (data='success') {
                //更新前台显示的值
                obj.update({
                    loan_limit: value
                });
                layer.msg("删除成功", {icon: 6});
            }else{
                layer.msg("删除失败", {icon: 6});
            }
        }
    });
}
function updateStudent(data,index,obj) {
    $.ajax({
        url: "/updateStudent",
        type: "PUT",
        data:{phone:data.phone,password:data.password,college:data.college,sno:data.sno},    //这个是传给后台的值
        dataType: "json",
        success: function(data){
            console.log(data);
            if (data='success') {
                //更新前台显示的值
                obj.update({
                    loan_limit: value
                });
                layer.msg("修改成功", {icon: 6});
            }else{
                layer.msg("修改失败", {icon: 6});
            }
        }
    });
}