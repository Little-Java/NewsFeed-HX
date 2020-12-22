layui.extend({
	admin: '../js/admin'
});

layui.use(['table', 'jquery','form', 'admin'], function() {
	var table = layui.table,
		$ = layui.jquery,
		form = layui.form,
		admin = layui.admin;

	table.render({
		elem: '#articleList',
		cellMinWidth: 80,
		cols: [
			[{
				type: 'checkbox'
			}, {
				field: 'sbId',title: '栏目序号',sort: true
			}, {
				field: 'sbName',title: '栏目名称',sort: true
			}, {
				field: 'sbIndex',title: '栏目标识',sort: true
			}]
		],
		/*data: [{
			"id": "1",
			"title": "WeAdmin的第一个版本在不断地抽空完善学习中",
			"date": "2018-02-03",
			"category": "官方动态",
			"sort": "1",
			"recommend": "checked",
			"top": "checked"
		}, {
			"id": "2",
			"title": "WeAdmin的测试数据一二三四五六七",
			"date": "2018-02-03",
			"category": "新闻资讯",
			"sort": "1",
			"recommend": "",
			"top": "checked"
		}],*/
		event: true,
		page: true
	});
	/*
	 *数据表格中form表单元素是动态插入,所以需要更新渲染下
	 * http://www.layui.com/doc/modules/form.html#render
	 * */
	$(function(){
		form.render();
	});
	
	var active = {
		getCheckData: function() { //获取选中数据
			var checkStatus = table.checkStatus('articleList'),
				data = checkStatus.data;
			//console.log(data);
			//layer.alert(JSON.stringify(data));
			if(data.length > 0) {
				layer.confirm('确认要删除吗？' + JSON.stringify(data), function(index) {
					layer.msg('删除成功', {
						icon: 1
					});
					//找到所有被选中的，发异步进行删除
					$(".layui-table-body .layui-form-checked").parents('tr').remove();
				});
			} else {
				layer.msg("请先选择需要删除的文章！");
			}

		},
		Recommend: function() {
			var checkStatus = table.checkStatus('articleList'),
				data = checkStatus.data;
			if(data.length > 0) {
				layer.msg("您点击了推荐操作");
				for(var i = 0; i < data.length; i++) {
					console.log("a:" + data[i].recommend);
					data[i].recommend = "checked";
					console.log("aa:" + data[i].recommend);
					form.render();
				}

			} else {
				console.log("b");
				layer.msg("请先选择");
			}

			//$(".layui-table-body .layui-form-checked").parents('tr').children().children('input[name="zzz"]').attr("checked","checked");
		},
		Top: function() {
			layer.msg("您点击了置顶操作");
		},
		Review: function() {
			layer.msg("您点击了审核操作");
		}

	};

	$('.demoTable .layui-btn').on('click', function() {
		var type = $(this).data('type');
		active[type] ? active[type].call(this) : '';
	});

	/*用户-删除*/
	window.member_del = function(obj, id) {
		layer.confirm('确认要删除吗？', function(index) {
			//发异步删除数据
			$(obj).parents("tr").remove();
			layer.msg('已删除!', {
				icon: 1,
				time: 1000
			});
		});
	}

});

function delAll(argument) {
	var data = tableCheck.getData();
	layer.confirm('确认要删除吗？' + data, function(index) {
		//捉到所有被选中的，发异步进行删除
		layer.msg('删除成功', {
			icon: 1
		});
		$(".layui-form-checked").not('.header').parents('tr').remove();
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

var settingss = {
	callback: {
		onClick: zTreeOnClick
	},
	data: {
		simpleData: {
			enable: true,  //true 、 false 分别表示 使用 、 不使用 简单数据模式
			idKey: "sbId",  //节点数据中保存唯一标识的属性名称
			pIdKey: "parentId",    //节点数据中保存其父节点唯一标识的属性名称
			rootPId: -1  //用于修正根节点父节点数据，即 pIdKey 指定的属性值
		},
		key: {
			name: "sbName"  //zTree 节点数据保存节点名称的属性名称  默认值："name"
		}
	},
	check:{
		enable : false,  //true 、 false 分别表示 显示 、不显示 复选框或单选框
		nocheckInherit : true  //当父节点设置 nocheck = true 时，设置子节点是否自动继承 nocheck = true
	}
};

$(document).ready(function(){
	zTreeObj = $.fn.zTree.init($("#treeDemo"), settingss, getData()); //初始化树
	zTreeObj.expandAll(false);   //true 节点全部展开、false节点收缩
});

function getData(){
	var data = [];
	var path = myFunction();
	$.ajax({
		url: path+"/subject/querySubjectTree",    //后台数据请求地址
		type: "post",
		async:false,
		success: function(resut){
			data = resut.result;
		}
	});
	return data;
};

// layui.use(['tree', 'util'], function() {
//     var tree = layui.tree;
//     var util = layui.util;
//     tree.render({
//         elem: '#treeDemo',
//         data: getData(),
//         id: 'treeId',
//         showCheckbox: false,     //是否显示复选框
//         onlyIconControl: true
//     });
// })

//数据
// var zNodes = [
//     //注意，数据中的 menuName 必须与 settingss 中key 中定义的name一致，否则找不到
//     {
//         sbName:"父节点1",
//         open:true,
//         children:[{
//             sbName:"子节点1",
//             children:[{
//                 sbName:"子节点1"
//             }, {
//                 sbName:"子节点2"
//             }]
//         }, {
//             sbName:"子节点2"
//         }]
//     }, {sbName:"父节点2", open:true, children:[
//             {sbName:"子节点3"}, {sbName:"子节点4"}]}
// ];
//
// zTreeObj = $.fn.zTree.init($("#treeDemo"), settingss, zNodes); //初始化树
// zTreeObj.expandAll(true);    //true 节点全部展开、false节点收缩

function zTreeOnClick(event, treeId, treeNode) {
	console.log(11111,treeNode)
	var sbId = treeNode.sbId
	console.log(22222,sbId)
	layui.use('table', function () {
		var table = layui.table;
		var path = myFunction();
		$.ajax({
			type: "post",
			url: path+'/subject/getSubjectListById?sbId='+sbId,
			success: function (res) {
				console.log(res)
				var tableList = res.result
				table.render({
					elem: '#articleList',
					cellMinWidth: 80,
					data: tableList,
					cols: [
						[ {
							field: 'sbId',title: '栏目序号',sort: true
						}, {
							field: 'sbName',title: '栏目名称',sort: true
						}, {
							field: 'sbIndex',title: '栏目标识',sort: true
						}]
					],
				})
			}
		})
		//监听工具条
		table.on('tool(demo)', function(obj){
			var data = obj.data;
			if(obj.event === 'detail'){
				// layer.msg('ID：'+ data.acId + ' 的查看操作');
				console.log(data.acText)
				//示范一个公告层
				layer.open({
					type: 1,
					title: false, //不显示标题栏
					closeBtn: false,
					area: '900px;',
					shade: 0.8,
					id: 'LAY_layuipro', //设定一个id，防止重复弹出
					btn: ['关闭'],
					btnAlign: 'c',
					moveType: 1, //拖拽模式，0或者1
					content: data.acText
				});
			}  else if(obj.event === 'send'){
				$.ajax({
					type: "post",
					url: '<%=request.getContextPath()%>/kafka/addMessage?acId='+ data.acId,
					success: function (res) {

					}
				});
			}
		});
	});
};