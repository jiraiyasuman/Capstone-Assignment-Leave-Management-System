<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
       pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Allot Holidays</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js"
	type="text/javascript"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
	type="text/javascript"></script>
<link href="css/bootstrapmin.css" rel="stylesheet" type="text/css" />
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="Stylesheet" type="text/css" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link href="../css/newCss.css" rel="stylesheet" type="text/css" />
<link
	href="//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400"
	rel="stylesheet" type="text/css" />
<link href="//fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	crossorigin="anonymous"></script>
<link rel="shortcut icon" href="images/favicon.png">
<link rel="stylesheet" href="../css/sidebar.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
      <link rel="stylesheet" href="../css/form.css">
<style>
.dropbtn {
  background-color: orange;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: orange;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: orange;}
#footer {
	background-color: teal;
	padding-top: 30px;
	padding-bottom: 30px;
	margin-top: 30rem;
}

#footer p {
	text-align: center;
	color: white;
}
.sidebar {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: orange;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}
.sidebar :hover{
background-color: DarkOrange;
}
.sidebar a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0.3s;
}

.sidebar a:hover {
  color:DarkOrange;
}

.sidebar .closebtn {
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

.openbtn {
  font-size: 20px;
  cursor: pointer;
  background-color: orange;
  color: white;
  padding: 10px 15px;
  border: none;
}

.openbtn:hover {
  background-color: DarkOrange;
}

#main {
  transition: margin-left .5s;
  padding: 16px;
}

/* On smaller screens, where height is less than 450px, change the style of the sidenav (less padding and a smaller font size) */
@media screen and (max-height: 450px) {
  .sidebar {padding-top: 15px;}
  .sidebar a {font-size: 18px;}
}
.sidebar li .submenu{ 
	list-style: none; 
	margin: 0; 
	padding: 0; 
	padding-left: 1rem; 
	padding-right: 1rem;
	 background-color: orange;
}

.sidebar .nav-link {
    font-weight: 500;
    color: DarkRed;
	 background-color: orange;
}
*{
  box-sizing: border-box;
}

input[type=text], select, textarea,[type=number],input[type=email],input[type=password],input[type=date],input[type=datetime-local] {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

button[type=submit]:hover {
  background-color: #45a049;
}
button[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}
.openbtn{
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}
input[type=submit]:hover {
  background-color: #45a049;
}
.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 65%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}
#footer{
    background-color: teal;
    padding-top: 30px;
    padding-bottom: 30px;
	 margin-top:30rem;
  }
  #footer p{
    text-align: center;
    color: white;
}
.grid-form1{

  background: linear-gradient(135deg, #71b7e6, #9b59b6);
    width: 55%;
    margin-left: 15rem;
    height: 39rem;
}
.container{
	 background: linear-gradient(135deg, #71b7e6, #9b59b6);
    width: 75%;
    margin-left: 5rem;
    height: 39rem;
}

  @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
*{
 margin: 0;
 padding: 0;
 box-sizing: border-box;
 /* font-family: 'Poppins',sans-serif; */
}
body{
 height: 100%;
 width: 100%;

 background: linear-gradient(135deg, #71b7e6, #9b59b6);
}

body {
    margin: 0;
    font-family: "Lato", sans-serif;
  }
  
 /*  .sidebar {
    margin: 0;
    padding: 0;
    width: 150px;
    background-color: orange;
    position: fixed;
    height: 100%;
    overflow: auto;
  }
  
  .sidebar a {
    display: block;
    color: black;
    padding: 16px;
    text-decoration: none;
  }
   
  .sidebar a.active {
    background-color:none;
    background-color: #04AA6D;
    color: white;
  }
  
  .sidebar a:hover:not(.active) {
    background-color: #555;
    color: white;
  } */
  
  div.content {
    margin-left: 200px;
    padding: 1px 16px;
    height: 1000px;
  }
  
  @media screen and (max-width: 700px) {
    .sidebar {
      width: 100%;
      height: auto;
      position: relative;
    }
    .sidebar a {float: left;}
    div.content {margin-left: 0;}
  }
  
  @media screen and (max-width: 400px) {
    .sidebar a {
      text-align: center;
      float: none;
    }
  }
  div.sidebar{
    margin-top: -5rem;
  }


  body {
    margin: 0;
    font-family: "Lato", sans-serif;
  }
  
  /* .sidebar {
    margin: 0;
    padding: 0;
    width: 150px;
    background-color: orange;
    position: fixed;
    height: 100%;
    overflow: auto;
  }
  
  .sidebar a {
    display: block;
    color: black;
    padding: 16px;
    text-decoration: none;
  }
   
  .sidebar a.active {
    background-color:none;
    background-color: #04AA6D;
    color: white;
  }
  
  .sidebar a:hover:not(.active) {
    background-color: #555;
    color: white;
  } */
  
  div.content {
    margin-left: 200px;
    padding: 1px 16px;
    height: 1000px;
  }
  
  @media screen and (max-width: 700px) {
    .sidebar {
      width: 100%;
      height: auto;
      position: relative;
    }
    .sidebar a {float: left;}
    div.content {margin-left: 0;}
  }
  
  @media screen and (max-width: 400px) {
    .sidebar a {
      text-align: center;
      float: none;
    }
  }
  div.sidebar{
    margin-top: -5rem;
  }
  table, th, td {
  border: 1px solid;
  }
  table {
  width: 70%;
}

th {
  height: 70px;
}
table {
  width: 50%;
}
th, td {
  padding-top: 10px;
  padding-bottom: 20px;
  padding-left: 30px;
  padding-right: 40px;
}
table, th, td {
  border: 1px solid black;
  border-radius: 10px;
}
table th {
    background: orange;
    color: #fff;
    text-transform: uppercase;
}
#footer {
	background-color: linear-gradient(135deg, #71b7e6, #9b59b6);;
	padding-top: 30px;
	padding-bottom: 30px;
	margin-top: 20rem;
	width: 100%;
}

#footer p {
	text-align: center;
	color: white;
}
 table, th, td {
  border: 1px solid;
  }
  table {
  width: 70%;
}

th {
  height: 70px;
}
table {
  width: 50%;
}
th, td {
  padding-top: 10px;
  padding-bottom: 20px;
  padding-left: 30px;
  padding-right: 40px;
}
table, th, td {
  border: 1px solid black;
  border-radius: 10px;
}
table th {
    background: orange;
    color: #fff;
    text-transform: uppercase;
}
</style>
</head>
<body>
<div class="m-4">
  <nav
    class="navbar fixed-top navbar-expand-lg navbar-light bg-light p-4"
    style="background-color: #00abb3"
  >
    <div class="container-fluid">
      <a href="#" class="navbar-brand">
        <img
          src="../images/blackwater.jpg"
          height="28"
          alt=""
          style="height: 3rem; width: 13rem"
        />
      </a>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <div class="navbar-nav">
        </div>
         </div>
        <div class="dropdown">
  <button class="dropbtn"><i class="fa-solid fa-circle-user"><span class="material-icons">
account_circle
</span></i></button>
  <div class="dropdown-content">
  <a href="hr.jsp">Display Profile</a>
    <a href="pcHR.jsp">Change Password</a>
    <a href="http://localhost:8080/LMS/LogoutController">Logout</a>
  </div>
</div>
    </div>
  </nav>
</div>
<div id="mySidebar" class="sidebar" style= " margin-top: 6.5rem;">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
  <ul class="nav flex-column" id="nav_accordion">
	<li class="nav-item">
		<a class="nav-link" href="#"> Sidebar Menu </a>
	</li>
	<li class="nav-item">
		<a class="nav-link" href="homeHR.jsp"> Home </a>
	</li>
	<li class="nav-item has-submenu">
		<a class="nav-link" href="#"> Manage Project<i class="bi small bi-caret-down-fill"></i> </a>
		<ul class="submenu collapse">
			<li><a class="nav-link" href="project.jsp">Add Projects</a></li>
		    <li><a class="nav-link" href="projectDisplay.jsp">View Projects</a></li>
		</ul>
	</li>
	<li class="nav-item has-submenu">
		<a class="nav-link" href="#"> Manage Holiday List <i class="bi small bi-caret-down-fill"></i> </a>
		<ul class="submenu collapse">
			<li><a class="nav-link" href="holidayList.jsp">Add Holidays </a></li>
		    <li><a class="nav-link" href="displayHoliday.jsp">Display Holidays </a></li>
		</ul>
	</li>
	<li class="nav-item has-submenu">
		<a class="nav-link" href="#"> Manage Employee Details <i class="bi small bi-caret-down-fill"></i> </a>
		<ul class="submenu collapse">
			<li><a class="nav-link" href="registration.jsp">Add Employees</a></li>
		    <li><a class="nav-link" href="allot.jsp">Allot Holidays </a></li>
		    <li><a class="nav-link" href="registrationValidate.jsp">View Employees </a></li>
		    <li><a class="nav-link" href="delete.jsp">Delete Employees </a></li>
		</ul>
	</li>
	<li class="nav-item has-submenu">
		<a class="nav-link" href="#"> Leaves <i class="bi small bi-caret-down-fill"></i> </a>
		<ul class="submenu collapse">
			<li><a class="nav-link" href="applyLeaveHR.jsp">Add Leaves </a></li>
		</ul>
	</li>
	<li class="nav-item has-submenu">
		<a class="nav-link" href="#"> Manage Leaves <i class="bi small bi-caret-down-fill"></i> </a>
		<ul class="submenu collapse">
			<li><a class="nav-link" href="leaverecordHR.jsp">View Applied Leaves</a></li>
		    <li><a class="nav-link" href="myLeavesHR.jsp">Manage Applied Leaves</a></li>
		</ul>
	</li>
	<li class="nav-item">
		<a class="nav-link" href="contactUs.jsp"> Contact Us </a>
	</li>
</ul>
</div>

<div id="main" style= " margin-top: 6.5rem;">
  <button class="openbtn" onclick="openNav()"><span class="material-icons">
list
</span></button>  
</div>
<script>
function openNav() {
  document.getElementById("mySidebar").style.width = "300px";
  document.getElementById("main").style.marginLeft = "300px";
}

function closeNav() {
  document.getElementById("mySidebar").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
}
</script>
   <script type="text/javascript">

	document.addEventListener("DOMContentLoaded", function(){

		document.querySelectorAll('.sidebar .nav-link').forEach(function(element){

			element.addEventListener('click', function (e) {

				let nextEl = element.nextElementSibling;
				let parentEl  = element.parentElement;	

				if(nextEl) {
					e.preventDefault();	
					let mycollapse = new bootstrap.Collapse(nextEl);

			  		if(nextEl.classList.contains('show')){
			  			mycollapse.hide();
			  		} else {
			  			mycollapse.show();
			  			// find other submenus with class=show
			  			var opened_submenu = parentEl.parentElement.querySelector('.submenu.show');
			  			// if it exists, then close all of them
						if(opened_submenu){
							new bootstrap.Collapse(opened_submenu);
						}

			  		}
		  		}

			});
		})

	}); 
	// DOMContentLoaded  end
</script>
<div class="container" align="center">
<c:if test="${not empty succMsg }">
							<p class="text-center text-success fs-3" align="center">${successMessage18}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-5" align="center">${errorMessage18}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
      <h1><strong>Leave balance</strong></h1>
     
      <form action="http://localhost:8080/LMS/LeaveController" method="post">
      <div class="row">
      <div class="col-25">
      <label><strong>EMPLOYEE_ID</strong></label>
      </div>
      <div class="col-75">
      <input type="text" name="id" placeholder="Employee Id" required>
      </div>
     </div>
      <div class="row">
      <div class="col-25">
       <label><strong>SICK_LEAVE</strong></label>
      </div>
      <div class="col-75">
      <input type="number" name="sick" min="1" max="15" placeholder="Sick Leave" required>
      </div>
      </div>
      <div class="row">
      <div class="col-25">
       <label><strong>CASUAL_LEAVE</strong></label>
      </div>
      <div class="col-75">
       <input type="number" name="casual" min="1" max="15" required>
      </div>
      </div>
      <div class="row">
      <div class="col-25">
      <label><strong>PERSONAL_LEAVE</strong></label>
      </div>
      <div class="col-75">
       <input type="number" name="personal" min="1" max="15" required>
      </div>
      </div>
      <div class="row">
      <div class="col-25">
       <label><strong>MATERNITY_LEAVE</strong></label>
      </div>
      <div class="col-75">
        <input type="number" name="maternity" min="1" max="180" required>
      </div>
      </div>
      <div class="row">
      <div class="col-25">
      <label><strong>PATERNITY_LEAVE</strong></label>
      </div>
      <div class="col-75">
      <input type="number" name="paternity" min="1" max="30" required>
      </div>
      </div>
      <div class="row">
      <div class="col-25">
      <label><strong>ADOPTION_LEAVE</strong></label>
      </div>
      <div class="col-75">
       <input type="number" name="adoption" min="1" max="30" required>
      </div>
      </div>
      <div class="row">
      <div class="col-25">
       <label><strong>MARRIAGE_LEAVE</strong></label>
      </div>
      <div class="col-75">
       <input type="number" name="marriage" min="1" max="15" required>
      </div>
      </div>
      <div class="row">
      <div class="col-25">
       <input type="submit" value="submit" required>
      </div>
      </div>
    </form>
</div>
<section id="footer" style="background: linear-gradient(135deg, #71b7e6, #9b59b6);">
        <p>
			Privacy Policy <span>|</span> Privacy & Security <span>|</span>
			BlackWater Security Contractors <span>|</span> 
		</p>
		<p>© 2022 BlackWater Security Contractors . Designed by Suman Talukdar.  All rights reserved</p>
        </section>
</body>
</html>