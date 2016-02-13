<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid" style="background-color:#F44336;color:#fff;height:100px;">
	<h3>Detection SQL injection through removing attributes</h3>
</div>

<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="197">
	<ul class="nav navbar-nav">
		<li class="${param.page == 'boardPage' ? 'active' : '' }"><a href="./boardPage.do">Home</a></li>
		<li><a><span class="glyphicon glyphicon-user">${sessionScope.id }</span></a></li>
		<li><a href="./logout.do">Logout</a></li>
		<li><a><span class="glyphicon glyphicon-ok-circle"></span></a></li>
	</ul>
</nav>