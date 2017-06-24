<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

<title>List Customers</title>

<!-- reference our style sheet -->


</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Managers</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">
			<input type="button" value="Add Customer" class="add-button" onclick="window.location.href='showFormForAdd';return false;" />
			<!--  add our html table here -->

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
					<c:url var="updateCust" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td><a href="${updateCust}">Update</a>|<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false;">Delete</a>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>