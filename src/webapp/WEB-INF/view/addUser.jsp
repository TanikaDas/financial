<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>
	<form action="/addUser" method="post">
		<table>
			<tr>
				<td>User Id</td>
				<td><input type="text" name="userId" required="required"></td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="userName" required="required"></td>
			</tr>
		</table>
		<input type="submit" value="Submit">
	</form>
</body>
</html>