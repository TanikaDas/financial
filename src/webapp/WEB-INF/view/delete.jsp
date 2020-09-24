<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Broker</title>
</head>
<body>
	<h3>Delete Broker has a CASCADING effect. It will delete all
		associated users. And when users get deleted, it deletes all
		associated deals.</h3>
	<form action="/deleteBroker" method="post">
		<table>
			<tr>
				<td>Broker Id</td>
				<td><input type="text" name="brokerId" required="required"></td>
			</tr>
		</table>
		<input type="submit" value="Submit">
	</form>
</body>
</html>