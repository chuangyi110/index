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
	<title>注册公司管理</title>
	<jsp:include page="/static/inc/head.jsp" flush="true"/>
	<%--<script>--%>
        <%--$("select").select2();--%>
	<%--</script>--%>
</head>
<body>
<div id="main">
	<div id="toolbar">
		<shiro:hasPermission name="ucenter:company:create"><a class="waves-effect waves-button" href="javascript:;" onclick="createAction()"><i class="zmdi zmdi-plus"></i> 新增公司</a></shiro:hasPermission>
		<shiro:hasPermission name="ucenter:company:update"><a class="waves-effect waves-button" href="javascript:;" onclick="updateAction()"><i class="zmdi zmdi-edit"></i> 编辑公司</a></shiro:hasPermission>
		<shiro:hasPermission name="ucenter:company:delete"><a class="waves-effect waves-button" href="javascript:;" onclick="deleteAction()"><i class="zmdi zmdi-close"></i> 封停公司</a></shiro:hasPermission>
		<span class="type1 type2 type3">
			<select id="provincesId" name="provincesId" class="select2">
				<option value="0">请选择所属省份</option>
				<c:forEach var="proProvinces" items="${proProvinces}">
					<option value="${proProvinces.provinceid}">${proProvinces.province}</option>
				</c:forEach>
			</select>
		</span>
		<span class="type2" hidden>
			<select id="citiesId" name="citiesId">
				<option value="0">请选择上级</option>
			</select>
		</span>
		<span class="type3" hidden>
			<select id="areasId" name="areasId">
				<option value="0">请选择上级</option>
			</select>
		</span>
	</div>
	<table id="table"></table>
</div>
<jsp:include page="/static/inc/footer.jsp" flush="true"/>
<script>

var datapro = new Map();
var provinceId = 0;
var cityId = 0;
var areaId = 0;
datapro.set("provinceId",0);
datapro.set("cityId",0);
datapro.set("areaId",0);

var $ind_city = $('#citiesId');
var $ind_area = $('#areasId');
//监视省份变化
$("#provincesId").change(function () {
    provinceId = $(this).val();
    datapro.set("provinceId",provinceId);
    datapro.set("cityId",0);
    datapro.set("areaId",0);
    $(".type2").show();
    cities($ind_city,$ind_area);
    //console.log(datapro);
});
//监视市变化
$ind_city.change(function () {
    cityId = $(this).val();
    datapro.set("cityId",cityId);
    datapro.set("areaId",0);
    $(".type3").show();
    areas($ind_area);
    //console.log(datapro);
});
//监视区/县份变化
$ind_area.change(function () {
    areaId = $(this).val();
    datapro.set("areaId",areaId);
    //console.log(datapro);
});
function cities($ind_city,$ind_area){
    if(provinceId!=0){
        //重置区县位置
        $ind_area.val(0).select2();
        getCityList($ind_city,provinceId);
    }else{
        //重置位置
        $ind_city.val(0).select2();
        $ind_area.val(0).select2();
    }
}
function areas($ind_area) {
    if(cityId!=0){
        getAreaList($ind_area,cityId)
    }else{
        //重置区县位置
        $ind_area.val(0).select2();
    }
}

function getCityList($obj,provinceId){
    $.ajax({
        type:'post',
        url:'${basePath}/ucenter/company/city/list',
        data:{provinceId:provinceId,limit:10000},
        success:function (result) {
            var datas = [{id: 0, text: '请选择上级'}];
            for (var i = 0; i < result.rows.length; i ++) {
                var data = {};
                data.id = result.rows[i].cityid;
                data.text = result.rows[i].city;
                datas.push(data);
            }
            // console.log(datas);
            // console.log($obj);
            $obj.empty();
            $obj.select2({
                data : datas
            });
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
    })
}
function getAreaList($obj,cityId){
    $.ajax({
        type:'post',
        url:'${basePath}/ucenter/company/area/list',
        data:{cityId:cityId,limit:10000},
        success:function (result) {
            var datas = [{id: 0, text: '请选择上级'}];
            for (var i = 0; i < result.rows.length; i ++) {
                var data = {};
                data.id = result.rows[i].areaid;
                data.text = result.rows[i].area;
                datas.push(data);
            }
            $obj.empty();
            $obj.select2({
                data : datas
            });
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

    })
}

var $table = $('#table');
$(function() {
	// bootstrap table初始化
	$table.bootstrapTable({
		url: '${basePath}/ucenter/company/list',
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
                "provinceId":datapro.get("provinceId"),
				"cityId":datapro.get("cityId"),
				"areaId":datapro.get("areaId")
            }
        },
		showRefresh: true,
		showColumns: true,
		minimumCountColumns: 2,
		clickToSelect: true,
		detailView: true,
		detailFormatter: 'detailFormatter',
		pagination: true,
		paginationLoop: false,
		sidePagination: 'server',
		silentSort: false,
		smartDisplay: false,
		escape: true,
		searchOnEnterKey: true,
		idField: 'companyId',
		maintainSelected: true,
		toolbar: '#toolbar',
		columns: [
			{field: 'ck', checkbox: true},
			{field: 'companyId', title: '编号', sortable: true, align: 'center'},
			{field: 'companyName', title: '公司名称'},
            {field: 'contry', title: '国家',formatter:'contryFormatter'},
            {field: 'provincesId', title: '省'},
            {field: 'citiesId', title: '市'},
            {field: 'areasId', title: '区/县'},
            {field: 'address', title: '详细地址'},
            {field: 'tel', title: '联系电话'},
            {field: 'fax', title: '传真'},
            {field: 'email', title: '电子邮箱'},
            {field: 'companyStatus', title: '状态',formatter:'companyStatusFormatter'},
            {field: 'companyLicense', title: '公司执照'},
            {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: false}
		]
	});
});
// 格式化操作按钮
function actionFormatter(value, row, index) {
    return [
		'<a class="update" href="javascript:;" onclick="updateAction()" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
		'<a class="delete" href="javascript:;" onclick="deleteAction()" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
    ].join('');
}
//国家数字转换
function contryFormatter(value,row,index){
    if (value == 1) {
        return '中国';
    }
    return '-';
}
//状态数字转换
function companyStatusFormatter(value,row,index){
    if (value == 0) {
        return '正常';
    }
    if (value == 1) {
        return '打烊';
    }
    if (value == 2) {
        return '关闭';
    }
    if (value == 3) {
        return '封停';
    }
    return '-';
}
// 新增
var createDialog;
function createAction() {
	createDialog = $.dialog({
		animationSpeed: 300,
		title: '新增公司',
		content: 'url:${basePath}/ucenter/company/create',
		onContentReady: function () {
            initMaterialInput();
            initUploader();
		}
	});
}
// 编辑
var updateDialog;
function updateAction() {
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
		updateDialog = $.dialog({
			animationSpeed: 300,
			title: '编辑公司',
			content: 'url:${basePath}/ucenter/company/update/' + rows[0].companyId,
			onContentReady: function () {
				initMaterialInput();
                initUploader();
            }
		});
	}
}
// 删除
var deleteDialog;
function deleteAction() {
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
			content: '确认封停该公司吗？',
			buttons: {
				confirm: {
					text: '确认',
					btnClass: 'waves-effect waves-button',
					action: function () {

						$.ajax({
							type: 'get',
							url: '${basePath}/ucenter/company/delete/' + rows[0].companyId,
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


function initUploader() {
    //百度上传按钮
    var uploader = WebUploader.create({
        // swf文件路径
        swf: '${basePath}/static/upms/plugins/c-0.1.5/Uploader.swf',
        // 文件接收服务端
        method: 'POST',
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: {
            "id": '#picker',
            "multiple": false
        },
        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        resize: false,
        // 选完文件后，是否自动上传。
        auto: false,
        // 只允许选择图片文件
        accept: {
            title: '图片文件',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        }
    });
    uploader.on( 'fileQueued', function(file) {
        $.ajax({
            url: '${ZHENG_OSS_ALIYUN_OSS_POLICY}',
            type: 'GET',
            dataType: 'jsonp',
            jsonp: 'callback',
            success: function(result) {
                var suffix = get_suffix(file.name);
                var random_name = random_string();
                uploader.options.formData.key = result.dir + '/' + random_name + suffix;
                uploader.options.formData.policy = result.policy;
                uploader.options.formData.OSSAccessKeyId = result.OSSAccessKeyId;
                uploader.options.formData.success_action_status = 200;
                uploader.options.formData.callback = result.callback;
                uploader.options.formData.signature = result.signature;
                uploader.options.server = result.action;
                uploader.upload();
            },
            error: function(msg) {
                console.log(msg);
            }
        });
    });
    uploader.on( 'uploadSuccess', function(file, response) {
        $('#avatar').val(response.data.filename).focus();
    });
    uploader.on( 'uploadError', function(file) {
        console.log('uploadError', file);
    });
}
// 根据路径获取后缀
function get_suffix(filename) {
    var pos = filename.lastIndexOf('.');
    var suffix = '';
    if (pos != -1) {
        suffix = filename.substring(pos);
    }
    return suffix;
}
// 随机字符串
function random_string(len) {
    len = len || 32;
    var chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    var maxPos = chars.length;
    var pwd = '';
    for (i = 0; i < len; i++) {
        pwd += chars.charAt(Math.floor(Math.random() * maxPos));
    }
    return pwd;
}

</script>
</body>
</html>