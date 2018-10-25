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
		<div class="form-group">
			<label for="companyName">名称</label>
			<input id="companyName" type="text" class="form-control" name="companyName" maxlength="20">
		</div>
		<%--<div class="form-group">--%>
			<%--<span class="type">--%>
				<%--<select id="companyTypeId" name="companyTypeId" multiple="multiple">--%>
					<%--<option value="0">经营类型</option>--%>
					<%--<c:forEach var="cpyCompanyTypes" items="${cpyCompanyTypes}" >--%>
						<%--<option value="${cpyCompanyTypes.id}">${cpyCompanyTypes.typeName}</option>--%>
					<%--</c:forEach>--%>
				<%--</select>--%>
			<%--</span>--%>
		<%--</div>--%>
		<%--<div class="form-group">--%>
			<%--<label for="description">描述</label>--%>
			<%--<input id="description" type="text" class="form-control" name="description" maxlength="300">--%>
		<%--</div>--%>
		<div class="row">
			<div class="col-lg-8 form-group">
				<label for="companyAvatar">头像</label>
				<input id="companyAvatar" type="text" class="form-control" name="companyAvatar" maxlength="150">
			</div>
			<div class="col-lg-4">
				<div id="picker">上传头像</div>
			</div>
		</div>
		<div class="form-group">
			<span class="type">
				<select id="contry" name="contry" disabled style="width:200px">
					<option value="1">中国</option>
				</select>
			</span>
		</div>
		<div class="form-group">
			<span class="type4 type5 type6">
				<select id="cre_provincesId" name="provincesId">
					<option value="0">请选择所属省份</option>
					<c:forEach var="proProvinces" items="${proProvinces}">
						<option value="${proProvinces.provinceid}">${proProvinces.province}</option>
					</c:forEach>
				</select>
			</span>
			<span class="type5" hidden>
				<select id="cre_citiesId" name="citiesId">
					<option value="0">请选择上级</option>
				</select>
			</span>
			<span class="type6" hidden>
				<select id="cre_areasId" name="areasId" >
					<option value="0">请选择上级</option>
				</select>
			</span>
		</div>
		<div class="form-group">
			<label for="address">详细地址</label>
			<input id="address" type="text" class="form-control" name="address" maxlength="300">
		</div>
		<div class="form-group">
			<label for="tel">电话</label>
			<input id="tel" type="text" class="form-control" name="tel" maxlength="20">
		</div>
		<div class="form-group">
			<label for="fax">传真</label>
			<input id="fax" type="text" class="form-control" name="fax" maxlength="20">
		</div>
		<div class="form-group">
			<label for="email">电子邮箱</label>
			<input id="email" type="text" class="form-control" name="email" maxlength="20">
		</div>
		<div class="form-group text-right dialog-buttons">
			<a class="waves-effect waves-button" href="javascript:;" onclick="createSubmit();">保存</a>
			<a class="waves-effect waves-button" href="javascript:;" onclick="createDialog.close();">取消</a>
		</div>
	</form>
</div>
<script>
var cre_provinceId = 0;
var cre_citiyId = 0;
$("select").select2();
var $cre_city = $('#cre_citiesId');
var $cre_area = $('#cre_areasId');
$("#companyTypeId").select2({
    placeholder:"经营类型",
	width:200
});
$("#cre_provincesId").change(function () {
    console.log(cre_provinceId);
    cre_provinceId = $(this).val();
	$(".type5").show();
    cre_cities($cre_city,cre_provinceId);

});
$cre_city.change(function () {
    cre_citiyId = $(this).val();
    $(".type6").show();
    cre_areas($cre_area,cre_citiyId);
});
//切换省属市
function cre_cities($city,provinceId){
    if(cre_provinceId!=0){
        getCityList($city,provinceId);
	}
}
//切换市属区县
function cre_areas($area,cityId) {
	if(cre_citiyId!=0){
        getAreaList($area,cityId);
    }
}



function createSubmit() {
    $.ajax({
        type: 'post',
        url: '${basePath}/ucenter/company/create',
        data: $('#createForm').serialize(),
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