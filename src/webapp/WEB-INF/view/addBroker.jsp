<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Broker</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>
	<div id="navigation"></div>
	<script>
		$(function() {
			$("#navigation").load("nav.html");
		});
	</script>
	<script>
		$.get("nav.html", function(data) {
			$("#navigation").replaceWith(data);
		});
	</script>
	<form action="/addBroker" method="post">
		<table>
			<tr>
				<td>Broker Id</td>
				<td><input type="text" name="brokerId" required="required"></td>
			</tr>
			<tr>
				<td>Broker Name</td>
				<td><input type="text" name="brokerName" required="required"></td>
			</tr>
		</table>
		<input type="submit" value="Submit">
	</form>
</body>
</html>