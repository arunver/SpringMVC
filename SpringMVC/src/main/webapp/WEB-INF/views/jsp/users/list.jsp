<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">


<body>

	<div class="container">

		<c:if test="${not empty msg}">
		    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" 
                                aria-label="Close">
				<span aria-hidden="true">�</span>
			</button>
			<strong>${msg}</strong>
		    </div>
		</c:if>

		<h1>All Users</h1>
		
		<h4>If not a user, please sign up:</h4>
		<a href="${pageContext.request.contextPath}/users/userForm"  class="btn btn-info" >Sign Up</a>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>framework</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="user" items="${users}">
			    <tr>
				<td>
					${user.id}
				</td>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td>
                                  <c:forEach var="framework" items="${user.framework}" 
                                                             varStatus="loop">
					${framework}
    				        <c:if test="${not loop.last}">,</c:if>
				  </c:forEach>
                                </td>
				<td>
				  <spring:url value="/users/${user.id}" var="userUrl" />
				  <spring:url value="/users/${user.id}/delete" var="deleteUrl" /> 
				  <spring:url value="/users/${user.id}/update" var="updateUrl" />

				  <button class="btn btn-info" 
                                          onclick="location.href='${userUrl}'">Query</button>
				  <button class="btn btn-primary" 
                                          onclick="location.href='${updateUrl}'">Update</button>
				  <button class="btn btn-danger" 
                                          onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                                </td>
			    </tr>
			</c:forEach>
		</table>

	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<spring:url value="/resources/core/js/hello.js" var="coreJs" />
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>

</body>
</html>