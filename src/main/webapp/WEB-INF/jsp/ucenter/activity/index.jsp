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
	<title>活动管理</title>
	<jsp:include page="/static/inc/head.jsp" flush="true"/>
	<link href="${basePath}/static/upms/plugins/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
</head>
<body>
<div id="main">
	<div id="toolbar" style="">
		<shiro:hasPermission name="ucenter:activity:create"><a class="waves-effect waves-button" href="javascript:;" onclick="createAction()"><i class="zmdi zmdi-plus"></i> 新增活动</a></shiro:hasPermission>
		<shiro:hasPermission name="ucenter:activity:update"><a class="waves-effect waves-button" href="javascript:;" onclick="updateAction()"><i class="zmdi zmdi-edit"></i> 编辑活动</a></shiro:hasPermission>
		<shiro:hasPermission name="ucenter:activity:delete"><a class="waves-effect waves-button" href="javascript:;" onclick="stopAction()"><i class="zmdi zmdi-play"></i>/<i class="zmdi zmdi-pause"></i> 开始/暂停活动</a></shiro:hasPermission>
        <span class="">
			<select id="activitytype" name="activitytype" class="select2">
				<option value="0">请选择类别</option>
				<c:forEach var="cpyActivityType" items="${cpyActivityTypes}">
                    <option value="${cpyActivityType.activityTypeId}">${cpyActivityType.activityType}</option>
                </c:forEach>
			</select>
		</span>
    </div>
	<table id="table"></table>
</div>
<jsp:include page="/static/inc/footer.jsp" flush="true"/>
<script src="${basePath}/static/upms/plugins/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
<script src="${basePath}/static/upms/plugins/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
var $table = $('#table');
//console.log($table);
$(function() {
    // bootstrap table初始化
    $table.bootstrapTable({
        url: '${basePath}/ucenter/activity/list',
        height: getHeight(),
        striped: true,
        search: true,
        queryParams:function (params) {
            //console.log(params);
            return{
                "offset":params.offset,
                "limit":params.limit,
                "search":params.search,
                "sort":params.sort,
                "order":params.order,
                "activitytype":$("#activitytype").val()
            }
        },
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
            {field: 'activityId', title: '编号', sortable: true, align: 'center'},
            {field: 'companyId', title: '公司Id'},
            {field: 'goodsId', title: '产品Id'},
            {field: 'activityTypeId', title: '活动类别',formatter:'ativityType'},
            {field: 'activityRules', title: '规则'},
            {field: 'beginTime', title: '开始时间',formatter:'timeFormatter'},
            {field: 'endTime', title: '结束时间',formatter:'timeFormatter'},
            {field: 'activityStatus', title: '活动状态',formatter:'activityStatusFormatter'},
            {field: 'discount', title: '折扣',formatter:'discountFormatter'},
            {field: 'sendFull', title: '满送'},
            {field: 'sendFullType', title: '满送类型',formatter:'sendFullTypeFormatter'},
            {field: 'sendFullOtherGoodsId', title: '满送其他产品Id'},
            {field: 'moneyOffType', title: '满减类型 0为满立减/1为每满立减',formatter:'moneyOffTypeFormatter'},
			{field: 'moneyOffPrerequisite', title: '满减条件(单位元)',formatter:'changeFormatter'},
			{field: 'moneyOff', title: '满减数额(单位元)',formatter:'changeFormatter'},
            {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: false}
        ]
    });
});
// 格式化操作按钮
function actionFormatter(value, row, index) {
    return [
        '<a class="update" href="javascript:;" onclick="updateAction()" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
        '<a class="delete" href="javascript:;" onclick="stopAction()" data-toggle="tooltip" title="Remove"><i class="zmdi zmdi-play"></i>/<i class="zmdi zmdi-pause"></i></a>'
    ].join('');
}
function ativityType(value,row,index){
    if (value == 1) {
        return '折扣';
    }
    if (value == 2) {
        return '满送';
    }
    if (value == 3) {
        return '满减';
    }
    return '-';
}
//折扣格式化
function discountFormatter(value,row,index){
    if(value!=null){
        return value+'折';
	}
	return '-';
}
//满送类型格式化
function sendFullTypeFormatter(v,r,i){
    if(v==0){
        return '送本产品';
	}
	if(v==1){
        return '送其他产品';
	}
	return '-';
}
//活动状态格式化
function activityStatusFormatter(v,r,i){
    if(v==0){
        return '正常';
	}
	if(v==1){
        return '暂停';
	}
	return '-';


}
//时间格式化
function timeFormatter(value,row,index){
    return formatDateTimeYMDHM(value);
}
//金额单位转换分——元
function changeFormatter(v,r,i){
    if(v==null){
        return '-'
	}
    return v/100+'元';
}
//满减类型格式化
function moneyOffTypeFormatter(v,r,i){
    if(v==0){
        return '满立减';
	}
	if(v==1){
     	return '每满减';
	}
	return '-'
}
// 新增
var createDialog;
function createAction() {
	createDialog = $.dialog({
		animationSpeed: 300,
		title: '新增类别',
		content: 'url:${basePath}/ucenter/activity/create',
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
			content: 'url:${basePath}/ucenter/activity/update/' + rows[0].activityId,
			onContentReady: function () {
				initMaterialInput();
            }
		});
	}
}
// 删除
var deleteDialog;
function stopAction() {
	var rows = $table.bootstrapTable('getSelections');
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
			content: '确认暂停吗？',
			buttons: {
				confirm: {
					text: '确认',
					btnClass: 'waves-effect waves-button',
					action: function () {

						$.ajax({
							type: 'get',
							url: '${basePath}/ucenter/activity/status/' + rows[0].activityId,
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
											content: result.data.errorMsg,
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