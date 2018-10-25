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
		<div class="form-group type_" >
			<span class="type">
				<select id="cpyCompanyTypes" name="cpyCompanyTypes">
					<option value="0">请选择顶级分类</option>
					<c:forEach var="cpyGoodsTypes" items="${cpyGoodsTypes}">
						<option value="${cpyGoodsTypes.goodsTypeId}">${cpyGoodsTypes.name}</option>
					</c:forEach>
				</select>
			</span>
			<a class="waves-effect waves-button" href="javascript:;" onclick="addSelect($(this))"><i class="glyphicon glyphicon-plus icon-plus"></i></a>
		</div>
		<div class="form-group">
			<label for="name">名称</label>
			<input id="name" type="text" class="form-control" name="name" maxlength="20">
		</div>
		<div class="form-group text-right dialog-buttons">
			<a class="waves-effect waves-button" href="javascript:;" onclick="createSubmit();">保存</a>
			<a class="waves-effect waves-button" href="javascript:;" onclick="createDialog.close();">取消</a>
		</div>
	</form>
</div>
<script>
$("select").select2();

//存储所有子 select id
var listSelect = new Array();
//添加子节点 $obj jquery点击对象
function addSelect($obj){
    //获取点击父级
	var parent = $obj.parent();
	//获取点击事件前面的select value
	var parentid = $obj.prev().find("select").val();
	//判断上级未选择的话返回
	if(0==parentid){
        $.confirm({
            title: false,
            content: '请选择类别后点击添加！',
            autoClose: 'cancel|3000',
            backgroundDismiss: true,
            buttons: {
                cancel: {
                    text: '取消',
                    btnClass: 'waves-effect waves-button'
                }
            }
        });
        return;
	};
	var id_class_name = "type"+parentid;
	listSelect.push(id_class_name);
	var div =   '<div class="form-group type_" >'+
					'<span class="'+id_class_name+'">'+
						'<select id ="'+id_class_name+'" name="'+id_class_name+'">'+
						'<option value="0">请选择上级</option>'+
					'</select>'+
					'</span>'+
					'<a class="waves-effect waves-button" href="javascript:;" onclick="addSelect($(this))">' +
						'<i class="glyphicon glyphicon-plus icon-plus"></i>' +
					'</a>'+
					'<a class="waves-effect waves-button" href="javascript:;" onclick="closeSelect($(this))">' +
						'<i class="glyphicon glyphicon-minus icon-minus"></i>' +
					'</a>'+
				'</div>';
	parent.after(div);
    $("select").select2();
    //加载子select
	$.ajax({
		type:'get',
		url:'${basePath}/ucenter/goodstype/list/'+parentid,
		data:{limit:10000},
		success:function(result) {
            var datas = [{id: 0, text: '请选择上级分类'}];
            for (var i = 0; i < result.rows.length; i ++) {
                var data = {};
                data.id = result.rows[i].goodsTypeId;
                data.text = result.rows[i].name;
                datas.push(data);
            }
            var $select = parent.next().find("select");
            $select.empty();
            $select.select2({
                data : datas
            });
    	}
	});
    $("select").change(function(){
        //选择到父节点
        var $obj = $(this).parents(".type_");
        //显示增删按钮
        $obj.find("a").show();
        //删除节点
        $obj.next(".type_").remove();
    });
	//“+”隐藏
    $obj.hide();
    //“-”隐藏
    $obj.next().hide();
	//console.log(listSelect);
}
//删除子节点
function closeSelect($obj){
	//获取点击父级
    var $parent = $obj.parent();
    //显示上一级增删按钮
	$parent.prev().find("a").show();
	//删除节点
	$parent.remove();
    listSelect.splice(-1,1);
    //console.log(listSelect);
}

function createSubmit() {
    var pid = $("form div select").last().val();
	//var typeName = $("#typeName");
    //console.log(pid);
    if(!$("form div select").last().is($("form div select").first())){
        if(0==pid){
            $.confirm({
                title: false,
                content: '请选择类别后点击保存，如果想保存在上一级请删除未选择的层！',
                autoClose: 'cancel|3000',
                backgroundDismiss: true,
                buttons: {
                    cancel: {
                        text: '取消',
                        btnClass: 'waves-effect waves-button'
                    }
                }
            });
            return;
        }
	};
    $.ajax({
        type: 'post',
        url: '${basePath}/ucenter/goodstype/create',
        data: {pid:pid,name:$("#name").val()},
        beforeSend: function() {
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