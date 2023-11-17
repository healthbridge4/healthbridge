<%@page import="com.healthbridge.DAO.DoctorDao"%>
<%@page import="com.healthbridge.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.healthbridge.db.DBConnect"%>
<%@page import="com.healthbridge.DAO.AppointmentDao"%>
<%@page import="com.healthbridge.entity.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/allcss.jsp" %>
<style>
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%@include file="admin_navbar.jsp" %>
<c:if test="${empty adminObj }">
<c:redirect url="../admin_login.jsp"></c:redirect>
</c:if>
<div class="container p-3">
<div class="row">

<div class="col-md-12">
		<div class="card paint-card">
			<div class="card-body">
				<p class="fs-3 text-center">Patient Details</p>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Gender</th>
							<th scope="col">Age</th>
							<th scope="col">Appointment Date</th>
							<th scope="col">Email</th>
							<th scope="col">Mob No</th>
							<th scope="col">Diseases</th>
							<th scope="col">Doctor Name</th>
							<th scope="address">Address</th>
							<th scope="col">status</th>
						</tr>
					</thead>
					<tbody>
					<% 
						
						AppointmentDao dao=new AppointmentDao(DBConnect.getConnection());
						List<Appointment> list=dao.getAllAppointment();
						for(Appointment ap:list)
						{
					%>
						<tr>
						<td><%=ap.getFullName() %></td>
						<td><%=ap.getGender() %></td>
						<td><%=ap.getAge() %></td>
						<td><%=ap.getAppoinDate()%></td>
						<td><%=ap.getEmail()%></td>
						<td><%=ap.getMobile()%></td>
						<td><%=ap.getDiseases() %></td>
						<td>
						<% 
						int did=ap.getDoctorId();
						DoctorDao dao2=new DoctorDao(DBConnect.getConnection());
						Doctor doctor=dao2.getDoctorById(did);
						%>
						<%=doctor.getFullName() %>
						</td>
						<td><%=ap.getAddress() %></td>
						<td><%=ap.getStatus() %></td>						
					</tr>
					<%
						}
					
					%>
					
					
					
					</tbody>
				</table>

			</div>
		</div>
	</div>
</div>
</div>
</body>
</html>