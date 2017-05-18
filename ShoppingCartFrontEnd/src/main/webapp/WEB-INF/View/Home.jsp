 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- --------------------------------------------RESOURCES------------------------------------- -->

<link rel="stylesheet" href="resources/css/bootstrap.css">
<script src="resources/js/jquery-3.2.0.js"></script>
<script src="resources/js/bootstrap.js"></script>


</head>


<!-- ----------------------------------------------BODY---------------------------------------- -->
<body>

	<center>
		<h2>MY SHOPPING CART.....</h2>
	</center>
	${message}
 <a href="LoginPage"><span class="glyphicon glyphicon-user"></span>Login</a>
	
	
	<a href="RegistrationPage"><span class="glyphicon glyphicon-registration-mark">Registration</span></a>
	
	<a href="AboutUsPage">About Us</a>
 <a href="MenuPage">Menu</a>
	<hr color="blue">
 
	
	 <%-- <jsp:include page="Menu.jsp"></jsp:include> 
	 --%>
<!-- -----------------------------------------------Start ADMIN ------------------------------------------ -->

	<c:if test="${isAdmin=='true'}">
		<jsp:include page="admin/AdminHome.jsp"></jsp:include>
	</c:if>

	<c:if test="${isAdminClickedCategories=='true' }">
		<jsp:include page="admin/Category.jsp"></jsp:include>
	</c:if>

	<c:if test="${isAdminClickedSuppliers=='true'}">
		<jsp:include page="admin/Supplier.jsp"></jsp:include>
	</c:if>

	<c:if test="${isAdminClickedProducts=='true'}">
		<jsp:include page="admin/Product.jsp"></jsp:include>
	</c:if>

<!-- --------------------------------------------End ADMIN ------------------------------------------------------>

	


	<c:if test="${isUserClickedLogin=='true'}">
		<jsp:include page="Login.jsp"></jsp:include>
	</c:if>
	
	
	

	<c:if test="${isUserClickedRegister=='true' }">
		<jsp:include page="Registration.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserClickedMenu=='true' }">
		<jsp:include page="Menu.jsp"></jsp:include>
	</c:if>

</body>
</html> 