<%@page import="com.healthbridge.entity.Doctor"%>
<%@page import="com.healthbridge.DAO.DoctorDao"%>
<%@page import="com.healthbridge.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.healthbridge.db.DBConnect"%>
<%@page import="com.healthbridge.DAO.AppointmentDao"%>
<%@page import="com.healthbridge.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <%@include file="component/allcss.jsp" %>
    <style>
        .paint-card {
            box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
        }
        .backImg {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/hospital.jpg");
	height:100%;
	width:100%;
	background-size: cover;
	background-repeat: no-repeat;
}
    </style>
</head>
<body>
    <%@include file="component/navbar.jsp"%>
    <c:if test="${empty userObj}">
        <c:redirect url="user_login.jsp"></c:redirect>
    </c:if>
    <div class="container-fulid backImg p-5">
        <p class="text-center fs-2 text-white"></p>
    </div>
    <div class="container p-3">
        <div class="row">
            <div class="col-md-9">
                <div class="card paint-card">
                    <div class="card-body">
                        <p class="fs-4 fw-bold text-center text-success">Appointment List</p>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Full Name</th>
                                    <th scope="col">Gender</th>
                                    <th scope="col">Age</th>
                                    <th scope="col">Appointment Date</th>
                                    <th scope="col">Diseases</th>
                                    <th scope="col">Doctor Name</th>
                                    <th scope="col">Status</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                            
                            	User user=(User)session.getAttribute("userObj");
                            	int user_id=user.getId();
                            	AppointmentDao dao=new AppointmentDao(DBConnect.getConnection());
                            	List<Appointment> list=dao.getAppointmentOfUser(user_id);
                            	for(Appointment ap:list)
                            	{
                            		%>
                            		<tr>
                                	<td><%=ap.getFullName()%></td>
                                	<td><%=ap.getGender() %></td>
                                	<td><%=ap.getAge() %></td>
                                	<td><%=ap.getAppoinDate() %></td>
                                	<td><%=ap.getDiseases() %></td>
                                	<td>
                                	<%
                                	int id=ap.getDoctorId();
                                	DoctorDao dao2=new DoctorDao(DBConnect.getConnection());
                                	Doctor d=dao2.getDoctorById(id);
                                	%>
                                	<%=d.getFullName() %>(<%=d.getSpecialist() %>)
                                	</td>
                                	
                                	<td>
                                	
                                	<% 
                                	if("pending".equals(ap.getStatus()))
                                			{%>
                                		<a href="#" class="btn btn-sm btn-warning">PENDING</a>
                                		<%}
                                	else
                                	{%>
                                		<a href="#" class="btn btn-sm btn-success"><%=ap.getStatus()%></a>
                                	<%
                                	}
                                	
                                	
                                	%>
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

            <div class="col-md-3 p-3">
                <img alt="" src="img/doct.jpg" height="500px" width="360px">
            </div>
        </div>
    </div>
</body>
</html>
