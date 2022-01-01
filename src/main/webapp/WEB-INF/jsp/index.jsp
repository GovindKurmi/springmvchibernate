<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>employee</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"/>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
 <div class="container">
  <div class="col-md-offset-2 col-md-7">
   <h2 class="text-center">Add Employee</h2>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Add Employee</div>
    </div>
    <div class="panel-body">
     <form:form action="savedata" cssClass="form-horizontal"
      method="post" modelAttribute="employee">

      <!-- need to associate this data with customer id -->
      <form:hidden path="id" />

      <div class="form-group">
       <label for="name" class="col-md-3 control-label"> Name</label>
       <div class="col-md-9">
        <form:input path="name" cssClass="form-control" />
       </div>
      </div>
      <div class="form-group">
       <label for="email" class="col-md-3 control-label"> Email</label>
       <div class="col-md-9">
        <form:input path="email" cssClass="form-control" />
       </div>
      </div>

      <div class="form-group">
       <label for="address" class="col-md-3 control-label">Address</label>
       <div class="col-md-9">
        <form:input path="address" cssClass="form-control" />
       </div>
      </div>
      
        <div class="form-group">
       <label for="salary" class="col-md-3 control-label">Salary</label>
       <div class="col-md-9">
        <form:input path="salary" cssClass="form-control" />
       </div>
      </div>

      <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9">
        <form:button cssClass="btn btn-primary">Submit</form:button>
       </div>
      </div>

     </form:form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>