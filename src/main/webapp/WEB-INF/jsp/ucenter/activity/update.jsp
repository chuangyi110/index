<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<div id="updateDialog" class="crudDialog">
	<form id="updateForm" method="post">
		<div class="form-group">
			<label for="ativityId">编号</label>
			<input id="ativityId" type="text" class="form-control" name="ativityId" maxlength="20" value="${cpyActivity.activityId}">
		</div>
		<label for="beginTime">活动开始时间:</label>
		<div class="form-group input-append date" id="beginTime" name="beginTime" >
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
		<div>
			<!--折扣start-->
			<c:if test="${cpyActivity.activityTypeId==1}">
				<div class="form-group discount atype">
							<label for="discount">折扣(请输入数字 例如：75 核计7.5折)</label>
							<input id="discount" type="text" class="form-control" name="discount" maxlength="2" value="${cpyActivity.discount}">
						</div>
			</c:if>
			<!--折扣end-->
			<!--满送 start-->
			<c:if test="${cpyActivity.activityTypeId==2}">
				<div class="form-group sendFull atype">
								<label for="sendFull">满送(请输入数字 例如：5 核计买5送1)</label>
								<input id="sendFull" type="text" class="form-control" name="sendFull" maxlength="2" value="${cpyActivity.sendFull}">
							</div>
				<div class="radio sendFull atype">
					<div class="radio radio-inline radio-success">
						<input id="status_1" type="radio" name="sendFullType" value="0" onchange="sendFullTypeCheck($(this))" <c:if test="${cpyActivity.sendFullType==0}">checked</c:if>>
						<label for="status_1">送本产品</label>
					</div>
					<div class="radio radio-inline">
						<input id="status_0" type="radio" name="sendFullType" value="1" onchange="sendFullTypeCheck($(this))" <c:if test="${cpyActivity.sendFullType==1}">checked</c:if>>
						<label for="status_0">其他产品</label>
					</div>
				</div>
				<div class="form-group sendFull atype sendFullOtherGoodsId">
							<span class="type">
								<select id="sendFullOtherGoodsId" name="sendFullOtherGoodsId" style="width: 100%;" value="">
									<c:forEach var="cpyGoods" items="${cpyGoods}">
										<option value="${cpyGoods.goodsId}">${cpyGoods.name}</option>
									</c:forEach>
								</select>
							</span>
						</div>
			</c:if>
			<!--满送end-->
			<!--满减start-->
			<c:if test="${cpyActivity.activityTypeId==3}">
				<div class="radio moneyOff atype">
								<div class="radio radio-inline radio-success">
									<input id="moneyOff_0" type="radio" name="moneyOffType" value="0" <c:if test="${cpyActivity.moneyOffType==0}">checked</c:if>>
									<label for="moneyOff_0">满立减</label>
								</div>
								<div class="radio radio-inline">
									<input id="moneyOff_1" type="radio" name="moneyOffType" value="1" <c:if test="${cpyActivity.moneyOffType==1}">checked</c:if>>
									<label for="moneyOff_1">每满减</label>
								</div>
							</div>
				<div class="form-group moneyOff atype">
					<label for="moneyOffPrerequisite">满减条件(单位分)</label>
					<input id="moneyOffPrerequisite" type="text" class="form-control" name="moneyOffPrerequisite" maxlength="7" value="${cpyActivity.moneyOffPrerequisite}">
				</div>
				<div class="form-group moneyOff atype">
				<label for="moneyOff">满减数额(单位分)</label>
				<input id="moneyOff" type="text" class="form-control" name="moneyOff" maxlength="7" value="${cpyActivity.moneyOff}">
			</div>
			</c:if>
			<!--满减end-->
		</div>
		<div class="form-group text-right dialog-buttons">
			<a class="waves-effect waves-button" href="javascript:;" onclick="createSubmit();">保存</a>
			<a class="waves-effect waves-button" href="javascript:;" onclick="createDialog.close();">取消</a>
		</div>
	</form>
</div>
<script>
	$("select").select2();
    //$("#sendFullOtherGoodsId").val(${cpyActivity.sendFullOtherGoodsId}).trigger('change');
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
var beginTime = formatDateTimeYMDHM(${cpyActivity.beginTime});
console.log(beginTime);
var endTime = formatDateTimeYMDHM(${cpyActivity.endTime});
$("#beginTime input").val(beginTime);
$("#endTime input").val(endTime);
function createSubmit() {
    $.ajax({
        type: 'post',
        url: '${basePath}/ucenter/activity/update/${cpyActivity.activityId}',
        data: $('#updateForm').serialize(),
        beforeSend: function() {
            beginTime = Date.parse($("#beginTime").data("datetimepicker").getDate()).toString();
            endTime = Date.parse($("#endTime").data("datetimepicker").getDate()).toString();
            this.data = this.data+'&beginTime='+beginTime+'&endTime='+endTime;
            if ($('#name').val() == '') {
                $('#name').focus();
                return false;
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
				updateDialog.close();
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
            url:'${basePath}/ucenter/activity/goods/'+${cpyActivity.companyId},
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
</script>