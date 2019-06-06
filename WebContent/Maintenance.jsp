<!DOCTYPE html>
<html lang="en">
<head>
	<title>Service & Maintenance</title>
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
	
var serviceDate = document.maintenance.serviceDate.value;  	
var plate = document.maintenance.plate.value; 
var currentReading = document.maintenance.currentReading.value;  
var nextReading = document.maintenance.nextReading.value;  
var parts = document.maintenance.parts.value;  
var cost = document.maintenance.cost.value;  
  
if (plate==null || plate=="" ){  
  alert("Some Fields are Empty");  
  return false;  
  
}else if (serviceDate==null || serviceDate=="" ){  
	  alert("Some Fields are Empty");  
	  return false; 
	  
}else if (currentReading==null || currentReading=="" ){  
	  alert("Some Fields are Empty");  
	  return false; 
	  
}else if (nextReading==null || nextReading=="" ){  
	  alert("Some Fields are Empty");  
	  return false; 
	  	  
}else if (parts==null || parts=="" ){  
	  alert("Some Fields are Empty");  
	  return false; 
	  
}else if (cost==null || cost=="" ){  
	  alert("Some Fields are Empty");  
	  return false; 
}  
return true;
}
</script>  

	
</head>
<body>

<jsp:include page="NavBar2.jsp"></jsp:include>
<form name="maintenance" method="post" action="maintenance" onsubmit="return validateform()" > 

	<div class="limiter">
		<div class="container-login100" style="background-image: url('background.jpg');">
			<div class="wrap-login100">
				<form class="login100-form validate-form">
					<span class="login100-form-logo">
						<i class="zmdi zmdi-landscape"></i>
					</span>
					
					<span class="login100-form-title p-b-34 p-t-27">
						Service & Maintenance
					</span>
					
					<div class="form-group">
					<label for="serviceDate">Service Date</label>
					<input type="date" name="serviceDate" class="form-control">
				</div>

					<div class="form-group">
					<input type="text" name="plate" class="form-control" placeholder="Plate No.">
				</div>	
							
				<div class="form-group">
					<input type="text" name="currentReading" class="form-control" placeholder="Current Milleage Reading">
				</div>
				
				<div class="form-group">
					<input type="text" name="nextReading" class="form-control" placeholder="Next Service Milleage Reading">
				</div>	
				
				<div class="form-group">
				<textArea class="form-control" name="parts" cols="40" rows="5" placeholder="Parts"></textArea>
				</div>
				
				<div class="form-group">
					<input type="text" name="cost" class="form-control" placeholder="Total Cost">
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
	
	<script src="js/jquery-3.4.1.min.js"></script>
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