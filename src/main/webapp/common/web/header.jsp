<%@page import="com.robocon321.util.SecurityUtil"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
     <div class="container px-5">
         <a class="navbar-brand" href="#!">Start Bootstrap</a>
         <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
         <div class="collapse navbar-collapse" id="navbarSupportedContent">
             <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                 <li class="nav-item"><a class="nav-link active" aria-current="page" href="<c:url value='/trang-chu' />">Home</a></li>
                 <security:authorize access="isAnonymous()">
	                 <li class="nav-item"><a class="nav-link" href="<c:url value='/dang-nhap' />">Đăng nhập</a></li>
	                 <li class="nav-item"><a class="nav-link" href="#">Đăng kí</a></li>                 
                 </security:authorize>
                 <security:authorize access="isAuthenticated()">
	                 <li class="nav-item"><a class="nav-link" href="#!">Welcome <%= SecurityUtil.getPrincipal().getFullname() %></a></li>
	                 <li class="nav-item"><a class="nav-link" href="#!">Thoát</a></li>                 
                 </security:authorize>
             </ul>
         </div>
     </div>
 </nav>
