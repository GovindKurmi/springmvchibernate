<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>emp.net</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h2>CRM - Employee Manager</h2>
			<hr />
			<a href="/" class="btn btn-primary" type="button">Add Employee</a> <br />
			<br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Employee List</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>Name</th>
							<th>Email</th>
							<th>Address</th>
							<th>Salary</th>
						</tr>

						<!-- loop over and print our customers -->
						<c:forEach var="employee" items="${employee}">

							<!-- construct an "update" link with customer id -->
							<c:url var="updateLink" value="/employee/updateForm">
								<c:param name="id" value="${employee.id}" />
							</c:url>

							<!-- construct an "delete" link with customer id -->
							<c:url var="deleteLink" value="/employee/delete">
								<c:param name="id" value="${employee.id}" />
							</c:url>

							<tr>
								<td>${employee.name}</td>
								<td>${employee.email}</td>
								<td>${employee.address}</td>
								<td>${employee.salary}</td>


								<td>
									<!-- display the update link --> <a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
								</td>

							</tr>

						</c:forEach>

					</table>

				</div>
			</div>
		</div>

	</div>
</body>
</html>