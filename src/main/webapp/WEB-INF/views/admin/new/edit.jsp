<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new"/>
<c:url var ="NewURL" value="/admin-new"/>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa bài viết</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                        <form:form id="formSubmit" modelAttribute="model">
                            <div class="form-group">
                                <label for="categoryCode" class="col-sm-3 control-label no-padding-right">Thể loại</label>
                                <div class="col-sm-9">
                                    <form:select cssClass="form-control" id="categoryCode" name="categoryCode" path="categoryCode">
									    <form:option value=""> --SELECT--</form:option>
									    <form:options items="${categories}" ></form:options>
                                    </form:select>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label for="title" id="title" class="col-sm-3 control-label no-padding-right">Tên bài viết</label>
                                <div class="col-sm-9">
                                    <form:input type="text" cssClass="form-control" id="title" name="title" path="title" />
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label for="thumbnail" class="col-sm-3 control-label no-padding-right">Hình đại diện</label>
                                <div class="col-sm-9">
                                    <form:input type="file" cssClass="form-control" id="thumbnail" name="thumbnail" path="thumbnail" />
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label for="shortDescription" class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
                                <div class="col-sm-9">
                                    <form:textarea rows="5" cols="10" cssClass="form-control" id="shortDescription" name="shortDescription" path="shortDescription"></form:textarea>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label for="content" class="col-sm-3 control-label no-padding-right">Nội dung</label>
                                <div class="col-sm-9">                                 
                                    <form:textarea rows="5" cols="10" cssClass="form-control" id="content" name="content" path="content"></form:textarea>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                               <div class="col-sm-12 text-align-center">
                               		<c:if test="${not empty model.id}">
		                               <input type="button" class="btn btn-white btn-primary btn-bold" value="Sửa bài viết" id="btnAddOrUpdateNew"/>
                               		</c:if>
                               		<c:if test="${empty model.id}">
		                               <input type="button" class="btn btn-white btn-primary btn-bold" value="Thêm bài viết" id="btnAddOrUpdateNew"/>
                               		</c:if>                               		
	                               <input type="button" class="btn btn-white btn-danger btn-bold" value="Hủy" id="btnReset"/>
                               </div>								
                            </div>
                        </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
	$("#btnAddOrUpdateNew").click(function(e) {
		e.preventDefault();
		var formSubmit = $("#formSubmit").serializeArray();
		console.log(formSubmit);
	});
</script>
</body>
</html>
