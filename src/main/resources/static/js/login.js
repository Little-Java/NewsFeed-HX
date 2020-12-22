/**
 * 登录
 */
$(function(){
    layui.use(['form' ,'layer'], function() {
        var form = layui.form;
        var layer = layui.layer;
        form.on("submit(login)",function () {
            login();
            return false;
        });
        var path=window.location.href;
        if(path.indexOf("kickout")>0){
            layer.alert("您的账号已在别处登录；若不是您本人操作，请立即修改密码！",function(){
                window.location.href="/login";
            });
        }
    })
})

function login(){
    var username=$("#username").val();
    var password=$("#password").val();
    var path = myFunction();
    $.post(path+"/user/loginUser",$("#useLogin").serialize(),function(data){
        if(data.statusCode == 200){
            window.location.href="./index.html";
            // $.ajax(path+"/toMenu",function(){
            //
            // })
        }else{
            layer.alert(data.message,function(){
                layer.closeAll();//关闭所有弹框
            });
        }
        // if(data.statusCode != 200){
        //     layer.alert(data.message,function(){
        //         layer.closeAll();//关闭所有弹框
        //     });
        // }
    });
}

function myFunction()
{
    //获取当前网址，如： http://localhost:8082/hongxing/login.html
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： hongxing/login.html
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8082
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/hongxing
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    //得到了 http://localhost:8082/hongxing
    var realPath=localhostPaht+projectName;
    return realPath;
    //alert(realPath);
}