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
<%@include file="doctor_navbar.jsp" %>
<c:if test="${empty doctObj }">
<c:redirect url="../doctor_login.jsp"></c:redirect>
</c:if>
<div class="container p-3">
<div class="row">

<div class="col-md-12">
		<div class="card paint-card">
			<div class="card-body">
				<p class="fs-3 text-center">Patient Details</p>
				<c:if test="${not empty comment_status}">
							<p class="fs-4 text-center text-danger">${comment_status}</p>
							<c:remove var="comment_status" scope="session" />
						</c:if>
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
							<th scope="col">status</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
					<% 
						Doctor doctor=(Doctor)session.getAttribute("doctObj");
						int id=doctor.getId();
						AppointmentDao dao=new AppointmentDao(DBConnect.getConnection());
						List<Appointment> list=dao.getAppointmentOfDoctor(id);
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
						<td><%=ap.getStatus() %></td>	
						<td>
						<a href="comment.jsp?id=<%=ap.getId() %>" class="btn btn-success btn-sm">Comment</a>
						
						
						
						</td>					
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