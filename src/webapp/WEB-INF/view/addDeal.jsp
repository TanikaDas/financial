<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Deal</title>
</head>
<body>
	<form action="/addDeal" method="post">
		<table>
			<tr>
				<td>Borrower Id</td>
				<td><input type="text" name="borrowerId" required="required"></td>
			</tr>
			<tr>
				<td>Lender Id</td>
				<td><input type="text" name="lenderId" required="required"></td>
			</tr>
			<tr>
				<td>Rate</td>
				<td><input type="number" step="0.01" min="0.00" max="100" name="rate" required="required"></td>
			</tr>
			<tr>
				<td>Amount</td>
				<td><input type="number" name="amount" required="required"></td>
			</tr>
			<tr>
				<td>Start Date</td>
				<td><input type="date" name="startDate" required="required"></td>
			</tr>
			<tr>
				<td>End Date</td>
				<td><input type="date" name="endDate" required="required"></td>
			</tr>
		</table>
		<input type="submit" value="Submit">
	</form>
</body>
</html>