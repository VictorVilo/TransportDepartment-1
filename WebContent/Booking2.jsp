<!DOCTYPE html>
<html lang="en">
<head>
	<title>Booking</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/png" href="logo.png"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	
	<script>  
function validateform(){  
	
var departureDate = document.bookings.departureDate.value;  	
var returnDate = document.bookings.returnDate.value; 
var destination = document.bookings.destination.value;  
var passengers = document.bookings.passengers.value;  
var names = document.bookings.names.value;  
var faculty = document.bookings.faculty.value; 
var department = document.bookings.department.value;  

  
if (departureDate==null || departureDate=="" ){  
  alert("Some Fields are Empty");  
  return false;  
  
}else if (returnDate==null || returnDate=="" ){  
	  alert("Some Fields are Empty");  
	  return false; 
	  
}else if (destination==null || destination=="" ){  
	  alert("Some Fields are Empty");  
	  return false; 
	  
}else if (passengers==null || passengers=="" ){  
	  alert("Some Fields are Empty");  
	  return false; 
	  	  
}else if (names==null || names=="" ){  
	  alert("Some Fields are Empty");  
	  return false; 
	  
}else if (faculty==null || faculty=="" ){  
	  alert("Some Fields are Empty");  
	  return false; 
	  
}else if (faculty=="SCIENCE" && department!="Computer Science"){  
	  alert("The department is NOT in the Faculty of Science");  
	  return false;
	  
}else if (faculty=="FASS" && department!="Peace, Security & Social Studies"){  
	  alert("The department is NOT in FASS");  
	  return false;
	  
}else if (faculty=="FEDCOS" && department!="Psychology"){  
	  alert("The department is NOT in FEDCOS");  
	  return false;
	  
}else if (faculty=="FERD" && department!="NARE"){  
	  alert("The department is NOT in FERD");  
	  return false;
	  
}else if (department==null || department=="" ){  
	  alert("Some Fields are Empty");  
	  return false; 
}  
return true;
}
</script>  

</head>

<body>

<jsp:include page="NavBar2.jsp"></jsp:include>
<form name="bookings" method="post" action="bookings2" onsubmit="return validateform()" > 
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('background.jpg');">
			<div class="wrap-login100">
				<form class="login100-form validate-form">
					<span class="login100-form-logo">
						<i class="zmdi zmdi-landscape"></i>
					</span>

					<span class="login100-form-title p-b-34 p-t-27">
						Trip Booking
					</span>

					
			
				<div class="form-group">
				<label class="control-table" for="departureDate">Departure Date</label>
					<input type="date" name="departureDate" class="form-control" placeholder="Departure Date">
				</div>	
			
				<div class="form-group">
				<label class="control-table" for="returnDate">Return Date</label>
					<input type="date" name="returnDate" class="form-control" placeholder="Return Date">
				</div>
				
				<div class="form-group">
					<input type="text" name="destination" class="form-control" placeholder="Destination">
				</div>	
				
				<div class="form-group">
					<input type="text" name="passengers" class="form-control" placeholder="No. of Students">
				</div>	
				
				<div class="form-group">
				<textArea class="form-control" name="names" cols="40" rows="5" placeholder="Names of Accompanying Staff"></textArea>
				</div>
				
				<div class="form-group">
					<label class="control-table" for="faculty">Faculty</label>
					<select id="faculty" name="faculty" class="form-control" >
					<option>SCIENCE</option>
					<option>FASS</option>
					<option>FEDCOS</option>
					<option>FERD</option>
					</select>
				</div>	
				
				<div class="form-group">
					<label class="control-table" for="department">Department</label>
					<select id="department" name="department" class="form-control" >
					<option>Computer Science</option>
					<option>Peace, Security & Social Studies</option>
					<option>Psychology</option>
					<option>NARE</option>
					</select>
				</div>	

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Submit
						</button>
					</div>

				</form>
			</div>
		</div>
	</div>
	</form>

	<div id="dropDownSelect1"></div>
	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<script src="js/main.js"></script>

</body>
</html>