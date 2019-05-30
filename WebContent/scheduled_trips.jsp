<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*" %>
<%@ page import="com.samson.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bookings</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">


  <!-- Custom fonts for this template-->
  <link href="dash/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="dash/css/sb-admin-2.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.min.css">




</head>

<body id="page-top">

	
<jsp:include page="dashboardup.jsp"></jsp:include>

<div class="row">
		<div class="col-md-8">
			<h2 style="color:green" ><font><strong>Scheduled trips</strong></font></h2>
		</div>
		<div class="col-md-4 text-right">
			<form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search" action="" method="get">
            <div class="input-group">
              <input type="text" class="form-control" name="search" placeholder="Search here..." aria-label="Search" aria-describedby="basic-addon2">
              <div class="input-group-append">
                <button class="btn btn-primary" type="button">
                  <i class="fas fa-search fa-sm"></i>
                </button>
              </div>
            </div>
          </form>

		</div>
	</div>
	
	<br>
	<div>
			<%
				String url="jdbc:mysql://localhost:3306/group_project";
				String dbname = "root";
				String pass = "";
				String search = request.getParameter("search");
				String query;
				
				if(search != null){
					query = "select * from scheduled_trips where destination like '%"+search+"%' or departure_date like '%"+search+"%' or return_date like '%"+search+"%' or no_of_students like '%"+search+"%' or faculty like '%"+search+"%' or department like '%"+search+"%'";
				}
				else {
					query = "select * from scheduled_trips";
				}
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
				} catch(Exception e){
					e.printStackTrace();
				}
				
				Connection connection = null;
				Statement statement = null;
				ResultSet rs = null;
				
			%>

			<table class="table table-hover table-bordered" align="center" >
			<tr>
				
			</tr>
			<thead>
				<tr >
					<th scope="col">S/NO</th>
					<th scope="col">Destination</th>
					<th scope="col">departure Date</th>
					<th scope="col">Return Data</th>
					<th scope="col">Passengers</th>
					<th scope="col">Faculty</th>
					<th scope="col">Department</th>
					<th class="text-right">Actions</th>
				</tr>
			</thead>
			
			<%
				try{
					//create a connection
					Connection con = DriverManager.getConnection(url, dbname, pass);
					//create a statement
					statement = con.createStatement();
					
					rs = statement.executeQuery(query);
					int i=1;
					while(rs.next()){
						%>
						<tbody>
							<tr>
							<td><%= i++ %></td>
							<td><%= rs.getString("destination")%></td>
							<td><%= rs.getString("departure_date")%></td>
							<td><%= rs.getString("return_date")%></td>
							<td><%= rs.getInt("no_of_students")%></td>
							<td><%= rs.getString("faculty")%></td>
							<td><%= rs.getString("department") %></td>
							
							<td class="text-right">
								<button name="edit"  class="btn btn-primary" data-toggle="modal" data-target="#edit_modal<%= rs.getInt("id")%>" style="width:80px;">Edit</button>
								<button name="delete"  data-toggle="modal" data-target="#delete_modal<%= rs.getInt("id")%>" class="btn btn-danger" style="width:80px;" >Delete</button>
							</td>
						</tr>
						
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="modal modal-danger " id="edit_modal<%= rs.getInt("id")%>" tabindex="-1">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title pull-left">Edit trip details</h4>
								<button class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
							<form action="EditTrip" method="POST">
								<input type="hidden" name="id" value='<%=rs.getInt("id") %>'/>
								<div class="form-group">
								 		<label for="destination">Destination</label>
									 	<input type="text" id="destination" class="form-control" name="destination" value="<%= rs.getString("destination")%>">
									</div>
									<div class="form-group">
										<label for="departure_date">Departure date</label>
										<input type="date" id="departure_date" class="form-control" name="departure_date" value="<%= rs.getString("departure_date")%>">
									</div>
									<div class="form-group">
										<label for="return_date">Return date</label>
										<input type="date" id="return_date" class="form-control" name="return_date" value="<%= rs.getString("return_date")%>">
									</div>
									<div class="form-group">
										 <label for="passengers">Number of passengers</label>
										 <input type="number" id="passengers" class="form-control" name="passengers" value="<%= rs.getInt("no_of_students")%>">
									</div>
								<div class="form-group">
								<label for="faculty">Faculty</label>
									<select id="faculty" name="faculty" class="form-control">
										<option selected><%= rs.getString("faculty")%></option>
										<option>Science</option>
										<option>Education</option>
										<option>Veterinary medicine</option>
										<option>Health Sciences</option>
										<option>Agriculture</option>
									</select>
								</div>
								<div class="form-group">
								<label for="department">Department</label>
								<select id="department" name="department" class="form-control">
									<option><%= rs.getString("department") %></option>
									<option>Computer Science</option>
									<option>Molecular biology</option>
									<option>Food and nutrition</option>
									<option>Mathematics</option>
									<option>Physics</option>
								</select>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
									<button type="submit" class="btn btn-warning">Update</button>
								</div>
							</form>
									
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
						
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="modal modal-danger " id="delete_modal<%= rs.getInt("id")%>" tabindex="-1">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title pull-left">Delete trip details</h4>
								<button class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
							<form action="DeleteTrip" method="POST">
								<input type="hidden" name="id" value='<%=rs.getInt("id") %>'/>
								<div class="form-group">
									<p>Are you sure you want to delete?</p>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
									<button type="submit" class="btn btn-warning">Yes, Delete</button>
								</div>
							</form>
									
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>			
						</tbody>
						
						<% 
					}
				} catch(Exception e){
					e.printStackTrace();
				}
			%>

</table>



</div>

		
<jsp:include page="dashboarddown.jsp"></jsp:include>

</body>
</html>