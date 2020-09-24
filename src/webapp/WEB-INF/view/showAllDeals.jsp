<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show All Deals</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Count</th>
			<th>Lender</th>
			<th>Borrower</th>
			<th>Rate(%)</th>
			<th>Amount(Rs)</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Duration(days)</th>
			<th>Booking Date</th>
			<th>Final Amount(Rs)</th>
			<th>Broker</th>
		</tr>
		<c:set var="count" value="1" scope="page"/>
		<c:forEach items="${allDeals}" var="deal">
			<tr>
				<td><c:out value="${count}"/></td>
				<td><c:out value="${deal.lenderId}" /></td>
				<td><c:out value="${deal.borrowerId}" /></td>
				<td><c:out value="${deal.rate}" /></td>
				<td><c:out value="${deal.amount}" /></td>
				<td><c:out value="${deal.startDate}" /></td>
				<td><c:out value="${deal.endDate}" /></td>
				<td><c:out value="${deal.durationInDays}" /></td>
				<td><c:out value="${deal.bookingDate}" /></td>
				<td><c:out value="${deal.finalAmount}" /></td>
				<td><c:out value="${deal.brokerId}" /></td>
			</tr>
			<c:set var="count" value="${count+1}" />
		</c:forEach>
	</table>
</body>
</html>