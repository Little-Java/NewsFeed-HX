layui.extend({
	admin: '../js/admin'
});

layui.use('table', function () {
	var table = layui.table;
	var path = myFunction();
	$.ajax({
		type: "post",
		url: path+'/user/queryUserList',
		success: function (res) {
			console.log(res)
			var tableList = res.result
			table.render({
				elem: '#userList',
				cellMinWidth: 80,
				data: tableList,
				page: true,
				cols: [
					[{
						field: 'usId', title: '用户ID', sort: true
					}, {
						field: 'usName', title: '用户名', templet: '#usernameTpl'
					}, {
						field: 'usAccounts', title: '登录名', sort: true
					}, {
						field: 'createUser', title: '创建人', sort: true
					}]
				],
			})
		}
	})
});

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