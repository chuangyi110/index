<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<div id="createDialog" class="crudDialog">
	<form id="createForm" method="post">
		<label for="companyId">选择公司:</label>
		<div class="form-group">
			<span class="type">
				<select id="companyId" name="companyId" style="width: 100%;">
					<option value="0">选择公司</option>
					<c:forEach var="cpyCompany" items="${cpyCompanies}" >
						<option value="${cpyCompany.companyId}">${cpyCompany.companyName}</option>
					</c:forEach>
				</select>
			</span>
		</div>
		<label for="goodsId">选择产品:</label>
		<div class="form-group">
			<span class="type">
				<select id="goodsId" name="goodsId" multiple="multiple" style="width: 100%;">
					<option value="0">产品</option>
					<option value="99999">全部</option>
				</select>
			</span>
		</div>
		<label for="beginTime">活动开始时间:</label>
		<div class="form-group input-append date" id="beginTime" name="beginTime">
			<input class="span2 form-control" size="16" type="text">
			<span class="add-on"><i class="icon-remove"></i></span>
			<span class="add-on"><i class="icon-th"></i></span>
		</div>
		<label for="endTime">活动开始时间:</label>
		<div class="form-group input-append date" id="endTime" name="endTime">
			<input class="span2 form-control" size="16" type="text">
			<span class="add-on"><i class="icon-remove"></i></span>
			<span class="add-on"><i class="icon-th"></i></span>
		</div>
		<label for="activityTypeId">请选择活动类别:</label>
		<div class="form-group">
			<span class="type">
				<select id="activityTypeId" name="activityTypeId" class="select2" style="width: 100%;">
					<option value="0">请选择类别</option>
					<c:forEach var="cpyActivityType" items="${cpyActivityTypes}">
						<option value="${cpyActivityType.activityTypeId}">${cpyActivityType.activityType}</option>
					</c:forEach>
				</select>
			</span>
		</div>
		<div>
			<!--折扣start-->
			<div class="form-group discount atype">
				<label for="discount">折扣(请输入数字 例如：75 核计7.5折)</label>
				<input id="discount" type="text" class="form-control" name="discount" maxlength="2">
			</div>
			<!--折扣end-->
			<!--满送 start-->
			<div class="form-group sendFull atype">
				<label for="sendFull">满送(请输入数字 例如：5 核计买5送1)</label>
				<input id="sendFull" type="text" class="form-control" name="sendFull" maxlength="2">
			</div>
			<div class="radio sendFull atype">
				<div class="radio radio-inline radio-success">
					<input id="status_1" type="radio" name="sendFullType" value="0" onchange="sendFullTypeCheck($(this))" checked>
					<label for="status_1">送本产品</label>
				</div>
				<div class="radio radio-inline">
					<input id="status_0" type="radio" name="sendFullType" value="1" onchange="sendFullTypeCheck($(this))">
					<label for="status_0">其他产品</label>
				</div>
			</div>
			<div class="form-group sendFull atype sendFullOtherGoodsId">
				<span class="type">
					<select id="sendFullOtherGoodsId" name="sendFullOtherGoodsId" style="width: 100%;">
						<option value="0">产品</option>
					</select>
				</span>
			</div>
			<!--满送end-->
			<!--满减start-->
			<div class="radio moneyOff atype">
				<div class="radio radio-inline radio-success">
					<input id="moneyOff_0" type="radio" name="moneyOffType" value="0" checked>
					<label for="moneyOff_0">满立减</label>
				</div>
				<div class="radio radio-inline">
					<input id="moneyOff_1" type="radio" name="moneyOffType" value="1">
					<label for="moneyOff_1">每满减</label>
				</div>
			</div>
			<div class="form-group moneyOff atype">
				<label for="moneyOffPrerequisite">满减条件(单位分)</label>
				<input id="moneyOffPrerequisite" type="text" class="form-control" name="moneyOffPrerequisite" maxlength="7">
			</div>
			<div class="form-group moneyOff atype">
				<label for="moneyOff">满减数额(单位分)</label>
				<input id="moneyOff" type="text" class="form-control" name="moneyOff" maxlength="7">
			</div>
			<!--满减end-->
		</div>
		<div class="form-group">
			<label for="activityRules">活动规则描述</label>
			<input id="activityRules" type="text" class="form-control" name="activityRules" maxlength="300">
		</div>
		<div class="form-group text-right dialog-buttons">
			<a class="waves-effect waves-button" href="javascript:;" onclick="createSubmit();">保存</a>
			<a class="waves-effect waves-button" href="javascript:;" onclick="createDialog.close();">取消</a>
		</div>
	</form>
</div>
<script>
$("select").select2();
$('.atype').hide();
var $activityTypeId = $('#activityTypeId');
var $companyId = $("#companyId");
$companyId.change(function () {
    findgoodsbycompanyid($("#goodsId"));
})
$activityTypeId.change(function () {
	 switch ($(this).val()){
		 case '0':
			 $('.atype').hide();
			 break;
		 case '1':
			 $('.atype').hide();
			 $('.discount').show();
			 break;
		 case '2':
			 $('.atype').hide();
			 $('.sendFull').show();
			 $('.sendFullOtherGoodsId').hide();
			 break;
		 case '3':
			 $('.atype').hide();
			 $('.moneyOff').show();
	 }
});
//初始化时间栏
$(".date").datetimepicker({
	format:'yyyy-mm-dd hh:ii',
    language:'zh-CN',
    startDate : "2015-02-14 10:00",//可以被选择的最早时间
    endDate : "2023-02-14 10:00",//可以被选择的最晚时间
	todayHighlight: true,
    startView : 2,//点开插件后显示的界面。0、小时1、天2、月3、年4、十年，默认值2
    forceParse: true,
    showMeridian: true,
    initialDate : "2018-05-14 10:00",//初始化的时间
    autoclose: true//选择后自动关闭
});

/*满送类别发生变化时触发，本产品时无特效，其他产品时添加产品选择栏*/
function sendFullTypeCheck($this) {
    var type = $this.val();
    if(type==1){
        $('.sendFullOtherGoodsId').show();
        findgoodsbycompanyid($("#sendFullOtherGoodsId"));
	}else{
        $('.sendFullOtherGoodsId').hide();
    }
}
function findgoodsbycompanyid($obj){
    $.ajax({
        type:'post',
        url:'${basePath}/ucenter/activity/goods/'+$("#companyId").val(),
        data:{},
        success:function (result) {
            var datas = [];
            for (var i = 0; i < result.rows.length; i ++) {
                var data = {};
                data.id = result.rows[i].goodsId;
                data.text = result.rows[i].name;
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
    });
}
function createSubmit() {
    $.ajax({
        type: 'post',
        url: '${basePath}/ucenter/activity/create',
        data: $('#createForm').serialize(),
        beforeSend: function() {
            console.log(this.data);
            var beginTime = Date.parse($("#beginTime").data("datetimepicker").getDate()).toString();
            var endTime = Date.parse($("#endTime").data("datetimepicker").getDate()).toString();
            this.data = this.data+'&beginTime='+beginTime+'&endTime='+endTime;
            console.log(this.data);
            if($('#activityName').val() == '') {
                $('#activityName').focus();
                return false;
            }
            if($('#companyId').val()==0){
                $('#companyId').focus();
                return false;
            }
            if($('#goodsId').val()==null){
                $('#goodsId').focus();
                return false;
            }
            if(beginTime>endTime){
                $.confirm({
                    theme: 'dark',
                    animation: 'rotateX',
                    closeAnimation: 'rotateX',
                    title: false,
                    content: '截至日期小于开始日期，请输入正确起止时间',
                    buttons: {
                        confirm: {
                            text: '确认',
                            btnClass: 'waves-effect waves-button waves-light'
                        }
                    }
                });
                return false;
            }
			switch ($activityTypeId.val()){
				case '0':
                    $activityTypeId.focus();
					return false;
				case '1':
                    if((parseInt($('#discount').val())|0)==0){
                        $('#discount').focus();
                        return false;
                    }
                    break;
				case '2':
				    console.log((parseInt($('#sendFull').val())|0)==0);
                    if((parseInt($('#sendFull').val())|0)==0){
                        $('#sendFull').focus();
                        return false;
                    }
					if($("input[name='sendFullType']:checked").val()==1){
						if($("#sendFullOtherGoodsId").val()==0){
							return false;
                        }
                    }
					break;
				case '3':
                    if((parseInt($('#moneyOffPrerequisite').val())|0)==0){
                        $('#moneyOffPrerequisite').focus();
                        return false;
                    };
                    if((parseInt($('#moneyOff').val())|0)==0){
                        $('#moneyOff').focus();
                        return false;
                    }

			}
        },
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
                createDialog.close();
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



</script>