<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>通用产品类型管理</title>
	<jsp:include page="/static/inc/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
	<div id="toolbar" style="">
		<shiro:hasPermission name="ucenter:goodstype:create"><a class="waves-effect waves-button" href="javascript:;" onclick="createAction()"><i class="zmdi zmdi-plus"></i> 新增通用产品类别</a></shiro:hasPermission>
		<shiro:hasPermission name="ucenter:goodstype:update"><a class="waves-effect waves-button" href="javascript:;" onclick="updateAction()"><i class="zmdi zmdi-edit"></i> 编辑通用产品类别</a></shiro:hasPermission>
		<shiro:hasPermission name="ucenter:goodstype:delete"><a class="waves-effect waves-button" href="javascript:;" onclick="deleteAction()"><i class="zmdi zmdi-close"></i> 删除类别</a></shiro:hasPermission>
	</div>
	<table id="table"></table>
</div>
<jsp:include page="/static/inc/footer.jsp" flush="true"/>
<script>
var $table = $('#table');
//console.log($table);
$(function() {
    // bootstrap table初始化
    $table.bootstrapTable({
        url: '${basePath}/ucenter/goodstype/list/0',
        height: getHeight(),
        striped: true,
        search: true,
        showRefresh: true,
        showColumns: true,
        minimumCountColumns: 2,
        clickToSelect: true,
        detailView: true,
        pagination: true,
        paginationLoop: false,
        sidePagination: 'server',
        silentSort: false,
        smartDisplay: false,
        escape: true,
        searchOnEnterKey: true,
        idField: 'id',
        maintainSelected: true,
        toolbar: '#toolbar',
        columns: [
            {field: 'ck', checkbox: true},
            {field: 'goodsTypeId', title: '编号', sortable: true, align: 'center'},
            {field: 'pid', title: '父类编号', sortable: true, align: 'center'},
            {field: 'name', title: '类别'},
            {field: 'remark', title: '备注'},
            {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: false}
        ],
        onExpandRow: function (index, row, $detail) {
            InitSubTable(index, row, $detail);
        }
    });
});
// 格式化操作按钮
function actionFormatter(value, row, index) {
    return [
        '<a class="update" href="javascript:;" onclick="updateAction()" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
        '<a class="delete" href="javascript:;" onclick="deleteAction()" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
    ].join('');
}
InitSubTable = function (index, row, $detail) {
    //console.log("initsubTable");
    var parentid = row.goodsTypeId;
    var cur_table = $detail.html('<table></table>').find('table');
    $(cur_table).bootstrapTable({
        url: '${basePath}/ucenter/goodstype/list/'+parentid,
        striped: true,
        search: true,
        showRefresh: true,
        showColumns: true,
        minimumCountColumns: 2,
        clickToSelect: true,
        detailView: true,
        pagination: true,
        paginationLoop: false,
        sidePagination: 'server',
        silentSort: false,
        smartDisplay: false,
        escape: true,
        searchOnEnterKey: true,
        idField: 'id',
        maintainSelected: true,
        columns: [
            {field: 'ck', checkbox: true},
            {field: 'goodsTypeId', title: '编号', sortable: true, align: 'center'},
            {field: 'pid', title: '父类编号', sortable: true, align: 'center'},
            {field: 'name', title: '类别'},
            {field: 'remark', title: '备注'},
            {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: false}
        ],
        onExpandRow: function (index, row, $detail) {
            InitSubTable(index, row, $detail);
        }
    });
};
// 新增
var createDialog;
function createAction() {
	createDialog = $.dialog({
		animationSpeed: 300,
		title: '新增类别',
		content: 'url:${basePath}/ucenter/goodstype/create',
		onContentReady: function () {
            initMaterialInput();
		}
	});
}
// 编辑
var updateDialog;
function updateAction() {
    //console.log($(this));
	var rows = $("table").bootstrapTable('getSelections');
	console.log(rows);
	if (rows.length != 1) {
		$.confirm({
			title: false,
			content: '请选择一条记录！',
			autoClose: 'cancel|3000',
			backgroundDismiss: true,
			buttons: {
				cancel: {
					text: '取消',
					btnClass: 'waves-effect waves-button'
				}
			}
		});
	} else {
		updateDialog = $.dialog({
			animationSpeed: 300,
			title: '编辑类别',
			content: 'url:${basePath}/ucenter/goodstype/update/' + rows[0].goodsTypeId,
			onContentReady: function () {
				initMaterialInput();
            }
		});
	}
}
// 删除
var deleteDialog;
function deleteAction() {
	var rows = $("table").bootstrapTable('getSelections');
	if (rows.length != 1) {
		$.confirm({
			title: false,
			content: '请选择一条记录！',
			autoClose: 'cancel|3000',
			backgroundDismiss: true,
			buttons: {
				cancel: {
					text: '取消',
					btnClass: 'waves-effect waves-button'
				}
			}
		});
	} else {
		deleteDialog = $.confirm({
			type: 'red',
			animationSpeed: 300,
			title: false,
			content: '确认删除改类别吗？',
			buttons: {
				confirm: {
					text: '确认',
					btnClass: 'waves-effect waves-button',
					action: function () {

						$.ajax({
							type: 'get',
							url: '${basePath}/ucenter/goodstype/delete/' + rows[0].goodsTypeId,
							success: function(result) {
								if (result.code != 1) {
									if (result.data instanceof Array) {
										$.each(result.data, function(index, value) {
											$.confirm({
												theme: 'dark',
												animation: 'rotateX',
												closeAnimation: 'rotateX',
												title: false,
												content: value.errorMsg,
												buttons: {
													confirm: {
														text: '确认',
														btnClass: 'waves-effect waves-button waves-light'
													}
												}
											});
										});
									} else {
										$.confirm({
											theme: 'dark',
											animation: 'rotateX',
											closeAnimation: 'rotateX',
											title: false,
											content: result.data,
											buttons: {
												confirm: {
													text: '确认',
													btnClass: 'waves-effect waves-button waves-light'
												}
											}
										});
									}
								} else {
									deleteDialog.close();
									$table.bootstrapTable('refresh');
								}
							},
							error: function(XMLHttpRequest, textStatus, errorThrown) {
								$.confirm({
									theme: 'dark',
									animation: 'rotateX',
									closeAnimation: 'rotateX',
									title: false,
									content: textStatus,
									buttons: {
										confirm: {
											text: '确认',
											btnClass: 'waves-effect waves-button waves-light'
										}
									}
								});
							}
						});
					}
				},
				cancel: {
					text: '取消',
					btnClass: 'waves-effect waves-button'
				}
			}
		});
	}
}
</script>
</body>
</html>