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
			<label for="realname">姓名</label>
			<input id="realname" type="text" class="form-control" name="realname" maxlength="20" value="${ucenterUserDetails.realName}">
		</div>
		<div class="form-group">
			<label for="signature">个性签名</label>
			<input id="signature" type="text" class="form-control" name="signature" maxlength="150" value="${ucenterUserDetails.signature}">
		</div>
		<div class="form-group">
			<label for="birthday">出生日期</label>
			<input id="birthday" type="text" class="form-control" name="birthday" maxlength="20" value="${ucenterUserDetails.birthday}">
		</div>
		<div class="form-group">
			<label for="question">安全问题</label>
			<input id="question" type="text" class="form-control" name="question" maxlength="50" value="${ucenterUserDetails.question}">
		</div>
		<div class="form-group text-right dialog-buttons">
			<a class="waves-effect waves-button" href="javascript:;" onclick="createSubmit();">保存</a>
			<a class="waves-effect waves-button" href="javascript:;" onclick="updateDialog.close();">取消</a>
		</div>
	</form>
</div>
<script>
function createSubmit() {
    $.ajax({
        type: 'post',
        url: '${basePath}/ucenter/user/detailed/${ucenterUserDetails.userId}',
        data: $('#updateForm').serialize(),
        beforeSend: function() {
            if ($('#realname').val() == '') {
                $('#realname').focus();
                return false;
            }
            if ($('#birthday').val() == '') {
                $('#birthday').focus();
                return false;
            }
            if ($('#question').val() == '') {
                $('#question').focus();
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
                detailedDialog.close();
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