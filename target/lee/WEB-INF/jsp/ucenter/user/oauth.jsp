<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<div id="oauthDialog" class="crudDialog">
	<form id="oauthForm" method="post">
		<c:forEach var="UcenterOauthDto" items="${UcenterOauthDto}">
			<div class="form-group">
				<p for="ucenterOauths_${UcenterOauthDto.userOauthId}">${UcenterOauthDto.oauthName}</p>
			</div>
			<div class="radio">
				<div class="radio radio-inline radio-info">
					<input id="ucenterOauths_${UcenterOauthDto.userOauthId}_0" type="radio"
						   name="ucenterOauths_${UcenterOauthDto.userOauthId}" value="0" <c:if test="${UcenterOauthDto.status==0}">checked</c:if>>
					<label for="ucenterOauths_${UcenterOauthDto.userOauthId}_0">正常</label>
				</div>
				<div class="radio radio-inline radio-danger">
					<input id="ucenterOauths_${UcenterOauthDto.userOauthId}_1" type="radio"
						   name="ucenterOauths_${UcenterOauthDto.userOauthId}" value="1" <c:if test="${UcenterOauthDto.status==1}">checked</c:if>>
					<label for="ucenterOauths_${UcenterOauthDto.userOauthId}_1">锁定</label>
				</div>
			</div>
			<hr>
			<div class="form-group text-right dialog-buttons">
				<a class="waves-effect waves-button" href="javascript:;" onclick="createSubmit(${UcenterOauthDto.userOauthId});">保存</a>
				<a class="waves-effect waves-button" href="javascript:;" onclick="updateDialog.close();">取消</a>
			</div>
		</c:forEach>

	</form>
</div>
<script>
function createSubmit(val) {
    var name = "input[name=ucenterOauths_"+val+"]:checked";
    var status = $(""+name).val();
    console.log(status);
    $.ajax({
        type: 'post',
        url: '${basePath}/ucenter/user/oauth/${UcenterOauthDto[0].userId}',
        // data: $('#oauthForm').serialize(),
		data:{userOauthId:val,status:status},
        beforeSend: function() {
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
                oAuthDialog.close();
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