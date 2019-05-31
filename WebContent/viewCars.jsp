<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cars details</title>
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

<script language="javascript">
  function deleteRecord(id){
    var doIt = confirm('Do you want to delete the record?');
    if(doIt){
      var f = document.form;
      f.method = "post";
      f.action = 'DeleteCar?id='+id;
      f.submit();
    } else{
      
    }
  }
</script>
</head>
<body id="page-top">

<jsp:include page="dashboardup.jsp"></jsp:include>

<div class="row">
		<div class="col-md-8">
			<h4 style="color:green" ><font><strong>Cars details</strong></font></h4>
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
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
				} catch(Exception e){
					e.printStackTrace();
				}
				PreparedStatement statement = null;
				ResultSet rs = null;
				
			%>

			
			<table class="table table-bordered table-striped table-hover">
			<tr>
				
			</tr>
			<thead>
				<tr >
					<th scope="col">S/No</th>
					<th scope="col">Number Plate</th>
					<th scope="col">Insurance company</th>
					<th scope="col">Premiums</th>
					<th scope="col">Condition</th>
					<th scope="col">Purchase Date</th>	
					<th scope="col">Assigned Driver</th>									
					<th class="text-right">Actions</th>
				</tr>
			</thead>
			
			<%
				try{
					
					//create a connection
					Connection con = DriverManager.getConnection(url, dbname, pass);
					//query to select only cars
					String search = request.getParameter("search");
					String query;
					
					if(search != null){
						query = "select * from cars where number_plate like '%"+search+"%' or insurance_company like '%"+search+"%' or premium like '%"+search+"%' or vehicle_condition like '%"+search+"%' or purchase_date like '%"+search+"%' or assigned_driver like '%"+search+"%'";
					} else {
						query = "select * from cars";
					}
					//create a statement
					statement = con.prepareStatement(query);
					rs = statement.executeQuery();
					int i = 1;
					
					while(rs.next()){
						
						%>
						<tbody>
							<tr>
							<td><%= i++ %></td>
							<td><%= rs.getString("number_plate")%></td>
							<td><%= rs.getString("insurance_company")%></td>
							<td><%= rs.getInt("premium")%></td>
							<td><%= rs.getString("vehicle_condition")%></td>
							<td><%= rs.getString("purchase_date") %></td>
							<td><%= rs.getString("assigned_driver") %></td>
							<td class="text-right">
								<button name="edit" id="<%= rs.getInt("id")%>" data-toggle="modal" data-target="#edit_modal<%= rs.getInt("id")%>" class="btn btn-success" style="width:80px;" >Edit</button>
								<button name="edit" id="<%= rs.getInt("id")%>" data-toggle="modal" data-target="#delete_modal<%= rs.getInt("id")%>" class="btn btn-danger" style="width:80px;" >Delete</button>
							</td>
						</tr>
						
						<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="modal" id="edit_modal<%= rs.getInt("id")%>" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				
					<h4 class="modal-title pull-left">Edit Car details</h4>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>

				<div class="modal-body">
				<form action="EditCar" method = "POST">
				<input type="hidden" name="id" value='<%=rs.getInt("id") %>'/>
			
				<div class="form-group">
					<label class="control-table" for="number_plate">Number Plate</label>
					<input type="text" name="number_plate" id="number_plate" class="form-control" value='<%=rs.getString("number_plate") %>'>
				</div>	
			
				<div class="form-group">
					<label class="control-table" for="insurance_company">Insurance Company</label>
					<input type="text" name="insurance_company" id="insurance_company" class="form-control" value='<%=rs.getString("insurance_company") %>'>
				</div>	
			
			<div class="form-group">
					<label class="control-table" for="premium">Premium amount per annum for insurance</label>
					<input type="number" name="premium" id="premium" class="form-control" value='<%=rs.getInt("premium") %>'>
			</div>
			<div class="form-group">
				<label for="condition">Condition</label>
				<select id="condition" name="condition" class="form-control" value='<%=rs.getString("vehicle_condition") %>'>
					<option>New</option>
					 <option>Good</option>
					 <option>Fair</option>
					 <option>Bad</option>
				</select>
			</div>
			<div class="form-group">
				<label for="purchase_date">Date of purchase</label>
				<input type="date" id="purchase_date" class="form-control" name="purchase_date" value='<%=rs.getString("purchase_date") %>'">
			</div>
			
			<div class="form-group">
				<label for="assigned_driver">Assigned Driver</label>
				<select id="assigned_driver" name="assigned_driver" class="form-control" value='<%=rs.getString("assigned_driver") %>'>
				<%
				
				String query2 = "select * from drivers_details";
				PreparedStatement statement2 = null;
				ResultSet rs2 = null;
				
			%>
			<%
				try{
					//create a statement
					statement2 = con.prepareStatement(query2);
					
					rs2 = statement2.executeQuery();
					
					while(rs2.next()){
						%>
						<option><%= rs2.getString("first_name")%></option>						
						<% 
					}
				} catch(Exception e){
					e.printStackTrace();
				}
			%>
					
				</select>
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
				<div class="modal modal-danger " id="delete_modal<%= rs.getInt("id")%>" tabindex="-1">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title pull-left">Delete bus details</h4>
								<button class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
							<form action="DeleteCar" method="POST">
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
<link href="js/modaljs.js">
</html>