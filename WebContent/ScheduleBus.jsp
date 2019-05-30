<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bus details</title>
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
<link href="js/modaljs.js">

<!--This script is used for user to confirm before deletion of a record -->
<script language="javascript">
  function deleteRecord(id){
    var doIt = confirm('Do you want to delete the record?');
    if(doIt){
      var f = document.form;
      f.method = "post";
      f.action = 'DeleteBus?id='+id;
      f.submit();
    } else{
      
    }
  }
</script>
</head>
<body id="page-top">

<jsp:include page="dashboardup.jsp"></jsp:include>

	<div>
			<%
				String url="jdbc:mysql://localhost:3306/group_project";
				String dbname = "root";
				String pass = "";
				String search = request.getParameter("search");
				String query;
				
					query = "select * from buses";
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
				} catch(Exception e){
					e.printStackTrace();
				}
				
				Connection connection = null;
				Statement statement = null;
				ResultSet rs = null;
				
			%>

			<table class="table table-hover table-bordered" align="center" cellpadding="5" cellspacing="5" border="1">
			<h2 class="text-center" style="color:green" ><font><strong>Available vehicles</strong></font></h2>
			<tr>
				
			</tr>
			<thead>
				<tr >
					<th scope="col">S/No</th>
					<th scope="col">Capacity</th>
					<th scope="col">Number Plate</th>
					<th scope="col">Condition</th>
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
							<td><%= i++%></td>
							<td><%= rs.getInt("capacity")%></td>
							<td><%= rs.getString("number_plate")%></td>
							<td><%= rs.getString("bus_condition")%></td>
							<td class="text-right">
							<%
							String condition =  rs.getString("bus_condition");
							
							if(condition.equals("Bad")){
							%>
							 <button name="reject"  data-toggle="modal" data-target="#reject_modal<%= rs.getInt("id")%>" class="btn btn-success" style="width:80px;" >Reserve</button>
							<%
							} else{
							%>
							<button name="Reserve"  data-toggle="modal" data-target="#reserve_modal<%= rs.getInt("id")%>" class="btn btn-success" style="width:80px;" >Reserve</button>
							<%
							}
							%>
							</td>
						</tr>
						<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="modal" id="reserve_modal<%= rs.getInt("id")%>" tabindex="-1">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title pull-left">Reserve bus</h4>
								<button class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
								<form action="ReserveBus" method = "POST">
								<input type="hidden" name="id" value='<%=rs.getInt("id") %>'/>
								<div class="form-group">
								<label for="trip_Date">Enter the date:</label>
								<input type="Date" name="trip_date" class="form-control" />
								</div>
								<div class="modal-footer">
											<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
											<input type="submit" class="btn btn-success" value="Update"></input>
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
				<div class="modal" id="reject_modal<%= rs.getInt("id")%>" tabindex="-1">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title pull-left">Reserve not possible</h4>
								<button class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
								<p>The bus is in bad condition. It can not be reserved for a trip!!</p>
								<div class="modal-footer">
											<button type="button" class="btn btn-danger" data-dismiss="modal">Ok</button>
								</div>	
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