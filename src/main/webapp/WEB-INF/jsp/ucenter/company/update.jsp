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
			<label for="companyName">名称</label>
			<input id="companyName" type="text" class="form-control" name="companyName" maxlength="20" value="${cpyCompany.companyName}">
		</div>
		<div class="row">
			<div class="col-lg-8 form-group">
				<label for="companyAvatar">头像</label>
				<input id="companyAvatar" type="text" class="form-control" name="companyAvatar" maxlength="150" value="${cpyCompany.companyAvatar}">
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
			<span class="type7 type8 type9">
				<select id="up_provincesId" name="provincesId">
					<option value="0">请选择所属省份</option>
					<c:forEach var="proProvinces" items="${proProvinces}">
						<option value="${proProvinces.provinceid}">${proProvinces.province}</option>
					</c:forEach>
				</select>
			</span>
			<span class="type8">
				<select id="up_citiesId" name="citiesId">
					<option value="0">请选择上级</option>
					<c:forEach var="proCites" items="${proCites}">
						<option value="${proCites.cityid}">${proCites.city}</option>
					</c:forEach>
				</select>
			</span>
			<span class="type9">
				<select id="up_areasId" name="areasId" >
					<option value="0">请选择上级</option>
					<c:forEach var="proAreas" items="${proAreas}">
						<option value="${proAreas.areaid}">${proAreas.area}</option>
					</c:forEach>
				</select>
			</span>
		</div>
		<div class="form-group">
			<label for="address">详细地址</label>
			<input id="address" type="text" class="form-control" name="address" maxlength="300" value="${cpyCompany.address}">
		</div>
		<div class="form-group">
			<label for="tel">电话</label>
			<input id="tel" type="text" class="form-control" name="tel" maxlength="20" value="${cpyCompany.tel}">
		</div>
		<div class="form-group">
			<label for="fax">传真</label>
			<input id="fax" type="text" class="form-control" name="fax" maxlength="20" value="${cpyCompany.fax}">
		</div>
		<div class="form-group">
			<label for="email">电子邮箱</label>
			<input id="email" type="text" class="form-control" name="email" maxlength="20" value="${cpyCompany.email}">
		</div>
		<div class="form-group text-right dialog-buttons">
			<a class="waves-effect waves-button" href="javascript:;" onclick="createSubmit();">保存</a>
			<a class="waves-effect waves-button" href="javascript:;" onclick="updateDialog.close();">取消</a>
		</div>
	</form>
</div>
<script>
$("select").select2();
$("#up_provincesId").val(${cpyCompany.provincesId}).select2();
$("#up_citiesId").val(${cpyCompany.citiesId}).select2();
$("#up_areasId").val(${cpyCompany.areasId}).select2();
function createSubmit() {
    $.ajax({
        type: 'post',
        url: '${basePath}/ucenter/company/update/${cpyCompany.companyId}',
        data: $('#updateForm').serialize(),
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
</script>