<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
   
<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8" />
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
   <meta name="description" content="" />
   <meta name="author" content="" />
   <title>Small Business - Start Bootstrap Template</title>
   <!-- Favicon-->
   <link rel="icon" type="image/x-icon" href="<c:url value='/template/web/assets/favicon.ico' />" />
   <!-- Core theme CSS (includes Bootstrap)-->
   <link href="<c:url value='/template/web/css/styles.css' />" rel="stylesheet" />
    <body>
    	<%@include file="/common/web/header.jsp" %>
		<dec:body />
		<%@include file="/common/web/footer.jsp" %>
    
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="<c:url value='/template/web/js/scripts.js' />" />
    </body>
</html>