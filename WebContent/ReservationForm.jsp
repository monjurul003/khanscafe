<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!doctype html>
<html lan="eng">


<head>
<title>Reservation</title>
<link rel="stylesheet" type="text/css" href="Style2.css">
</head>



<body>

<div>
	<header>
	
	<div class="img-1-position">
	<img class="img-1" src="images/logo.jpg" alt="Logo"></img>
	</div>

	<nav class="nav-main">
	 <ul class="nav-ul">
      <li class="nav-li"><a class="nav-a" href="AboutUs.html">About Us</a></li>
	  <li class="nav-li"><a class="nav-a" href="Menu.html">Menu</a></li>
	  <li class="nav-li"><a class="nav-a" href="ReservationForm.jsp">Reservation</a></li>
	  <li class="nav-li"><a class="nav-a" href="ContactUs.html">Contact Us</a></li>
	  </ul>	  
	</nav>	

	</header>
</div>


<div>
<fieldset class="f1">


<div >
<form class="form-res" action="ReservationFormReceived.jsp" method="post" name="reservation">

<div>
Date & Time:<input class="input1 input4" type="date" name="date_form" required ></input><br>
<small style="font-family:  Arial ; font-size: 0.8rem; color: white;">
Please click on arrow to open calendar.</small><br>

<small style="font-family:  Arial ; font-size: 0.8rem; color: white;">
Open hours 11:00-23:00 : </small>
<input class="input1 input5" type="time" name="time_form" min="11:00" max="23:00" required ></input>
<small style="font-family:  Arial ; font-size: 0.8rem; color: white;">
Please put time in 24 hour format. </small><br>


Name: <input class="input1" type="text" name="name_form" required></input><br>
Number of Persons: <input class="input1 input3" type="number" name="numOfPersons_form"  min="1" max="100" required></input>
<p style="font-family:  Arial ; font-size: 0.8rem; color: white;">
The maximum capacity is 100.</p><br>
Phone:   <input class="input1" type="tel" name="phone_form" required></input><br>
E-mail:<input class="input1" type="email" name="email_form" required></input><br>
Comments\Allergies:<br>
<textarea class="input2" type="text" name="comments_form" cols="40"></textarea><br>
<input class="button" type="submit"  value="Reserve">
<input class="button" type="reset" value="Clean form" >
</div>


</form>
</div>

<div class="form-res1">
If you need any help to reserve, we will be<br>
happy to assist by phone (204) 123-4567
</div>

</fieldset>
</div>


<div>
<footer>
Created by Jenny Ischakov <br>
<a href="mailto:jenny.ischakov@gmail.com" target="_blank" >jenny.ischakov@gmail.com</a>
<br>
</footer>
</div>


</body>














</html>