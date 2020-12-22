layui.extend({
	admin: '../js/admin'
});

layui.use('table', function () {
	var table = layui.table;
	var path = myFunction();
	$.ajax({
		type: "post",
		url: path+'/topic/getTopicAll',
		success: function (res) {
			var tableList = res.result
			table.render({
				elem: '#topicList',
				cellMinWidth: 80,
				data: tableList,
				page: true,
				cols: [
					[{
						field: 'topicId', title: '专题ID', sort: true
					}, {
						field: 'topicName', title: '专题名称', sort: true
					}, {
						field: 'typeId', title: '站点类型', sort: true
					}, {
						field: 'rootSubjectName', title: '根栏目名称', sort: true
					}]
				],
				done:function(res, curr, count){  //res 接口返回的信息
					$("[data-field = 'typeId']").children().each(function(){
						if($(this).text() == '1'){
							$(this).text("站点");
						}else if($(this).text() == '2'){
							$(this).text("专题");
						}
					})
				}
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