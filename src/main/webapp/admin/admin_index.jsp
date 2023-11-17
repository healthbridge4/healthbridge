<%@page import="java.util.List"%>
<%@page import="com.healthbridge.db.DBConnect"%>
<%@page import="com.healthbridge.DAO.GetAllCount"%>
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
<c:redirect url="../admin_login.jsp"> </c:redirect>
</c:if>
	<div class="container p-5">
		<p class="text-center fs-3">Admin Dashboard</p>
		<c:if test="${not empty msg_specialist }">
						<p class="text-center text-danger fs-5">${msg_specialist}</p>
						<c:remove var="msg_specialist"/>
						</c:if>
			
			<%
			GetAllCount gac=new GetAllCount(DBConnect.getConnection());
			List<Integer> list=gac.GetTotalCount();
			int[]count=new int[4];
			int j=0;
			for(Integer i : list)
			{
				count[j]=i;
				j++;
				
			}


			%>
		<div class="row">
			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fas fa-user-md fa-3x"></i><br>
						<p class="fs-4 text-center">
							Doctor <br><%=count[0]%>
						</p>
					</div>
				</div>
			</div>



			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fas fa-user-circle fa-3x"></i><br>
						<p class="fs-4 text-center">
							User <br><%=count[1] %>
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="far fa-calendar-check fa-3x"></i><br>
						<p class="fs-4 text-center">
							Total Appointment <br><%=count[2] %>
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-4 mt-2">

				<div class="card paint-card " data-bs-toggle="modal"
					data-bs-target="#exampleModal">
					<div class="card-body text-center text-success">
						<i class="far fa-calendar-check fa-3x"></i><br>
						<p class="fs-4 text-center">
							Specialist <br><%=count[3] %>
						</p>
					</div>
				</div>

			</div>

		</div>
	</div>
	<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Specialist</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="../addSpecialist" method="post">
        <div class="form-group">
        <label>Enter Specialist Name</label>
        <input type="text" name="specName" class="form_control">
        </div>
        
        <div class="text-center mt-3">
        <button type="submit" class="btn btn-primary">Add</button>
        </div>
        
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>
</body>
</html>