<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   --%>

<h1>Add Student</h1>
<form:form method="post" action="save">
	<table>

		<tr>
			<td>Name :</td>
			<td><form:input path="name" /></td>
		</tr>

		<tr>
			<td>Address :</td>
			<td><form:input path="address" /></td>
		</tr>
		<tr>
			<td>Contact_no :</td>
			<td><form:input path="contact_no" /></td>
		</tr>
		<tr>
			<td>Gender :</td>
			<td><form:input path="gender" /></td>			
		</tr>
		 <tr>    
          <td>Email :</td>    
          <td><form:input path="email" /></td>
            
         </tr>
         <tr>    
          <td>Date Of Birth :</td>    
          <td><form:input path="dateofbirth" /></td>  
         </tr>
         <tr>    
          <td>Cource :</td>    
          <td><form:input path="cource" /></td>  
         </tr>   

		<tr>
			<td></td>
			<td><input type="submit" value="Save" /></td>
		</tr>
	</table>
</form:form>

</head>
</html>
