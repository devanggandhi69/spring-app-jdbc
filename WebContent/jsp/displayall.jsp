<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- <table width="100%" border="1"> -->
	<!-- 		<tr> -->
	<!-- 			<th>ID</th> -->
	<!-- 			<th>First Name</th> -->
	<!-- 			<th>Last Name</th> -->
	<!-- 			<th>Address</th> -->
	<!-- 			<th colspan="2">Action</th> -->
	<!-- 		</tr> -->

	<%-- 		<c:forEach items="{listUser}" var="user"></c:forEach> --%>
	<!-- 		<tr> -->
	<%-- 			<td>${user.id }</td> --%>
	<%-- 			<td>${user.firstname }</td> --%>
	<%-- 			<td>${user.lastname }</td> --%>
	<%-- 			<td>${user.address }</td> --%>
	<%-- 			<td><spring:url value="/update/${user.id} " var="updateURL"></spring:url> --%>
	<%-- 				<a href="${updateURL }">Update</a></td> --%>
	<%-- 			<td><spring:url value="/delete/${user.id} " var="deleteURL"></spring:url> --%>
	<%-- 				<a href="${updateURL }">Delete</a></td> --%>
	<!-- 		</tr> -->
	<!-- 	</table> -->

	<form method="post" action="/DynamicWebAppWorkingDB/er">
		<div align="center">
			<fieldset>
				<table border="3px">
					<tbody>
						<tr>
							<th>ID</th>
							<th>First Name</th>
							<th>Middle Name</th>
							<th>Last Name</th>
							<th>Address</th>
							<th>City</th>
							<th>State</th>
							<th>Country</th>
							<th>Phone</th>
							<th>Bank Name</th>
							<th>Account Number</th>
							<th>SSN</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
						<c:forEach items="{threePageBean}" var="threePageBean">
							<tr>
								<td><c:out value="${threePageBean.id}"></c:out></td>
								<td><c:out value="${threePageBean.firstname}"></c:out></td>
								<td><c:out value="${threePageBean.middlename}"></c:out></td>
								<td><c:out value="${threePageBean.lastname}"></c:out></td>
								<td><c:out value="${threePageBean.address}"></c:out></td>
								<td><c:out value="${threePageBean.city}"></c:out></td>
								<td><c:out value="${threePageBean.state}"></c:out></td>
								<td><c:out value="${threePageBean.country}"></c:out></td>
								<td><c:out value="${threePageBean.phone}"></c:out></td>
								<td><c:out value="${threePageBean.bankname}"></c:out></td>
								<td><c:out value="${threePageBean.accountno}"></c:out></td>
								<td><c:out value="${threePageBean.ssn}"></c:out></td>
								<td><button id="edit" name="buttonEdit" value="${threePageBean.id}">Edit</button></td>
								<td><button id="delete" name="buttonDelete"
										value="${threePageBean.id}">Delete</button></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</fieldset>

		</div>
	</form>
</body>
</html>