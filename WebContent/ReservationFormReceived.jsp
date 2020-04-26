<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!doctype html>
<html lan="eng">


<head>
<title>Reservation is received</title>
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


		
		<%@page 
		import="java.text.SimpleDateFormat" 
		import="java.util.Date" 
		import="java.sql.*" 
		import="java.util.Calendar"
		%>

		
<% 

// Get Parameters from Reservation Form
		String date_form_0 = request.getParameter("date_form");
System.out.println(date_form_0);
		//convert to Date format
		Date date_form = new SimpleDateFormat("yyyy-mm-dd").parse(date_form_0);  
		System.out.println(date_form);

		String time_form_0 = request.getParameter("time_form");
		//convert to Time format
		Date time_form = new SimpleDateFormat("HH:mm").parse(time_form_0);  

		
		String name_form = request.getParameter("name_form");

		String numOfPersons_form_0 = request.getParameter("numOfPersons_form");
		// conversion to int
		int numOfPersons_form = Integer.parseInt(numOfPersons_form_0);

		String phone_form = request.getParameter("phone_form");
		String email_form = request.getParameter("email_form");
		String comments_form = request.getParameter("comments_form");

		

// Insert to DB

	try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		try {
			// create a mysql database connection
			String url = "jdbc:mysql://localhost:3306/managementsystem?serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "jenny", "jenny");

			// create a sql date object so we can use it in our INSERT statement
			Calendar calendar = Calendar.getInstance();
			java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

			// the mysql insert statement 
 			String query = "insert into reservations (name_r, numOfPersons_r, phone_r, email_r, comments_r, date_created, reservation_date, reservation_time, status_r )"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";


			
			
			// create the mysql insert prepared statement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, name_form);
			preparedStmt.setInt(2, numOfPersons_form);
			preparedStmt.setString(3, phone_form);
			preparedStmt.setString(4, email_form);
			preparedStmt.setString(5, comments_form);
			preparedStmt.setDate(6, startDate);
			
	
			preparedStmt.setString(7, date_form_0);
			preparedStmt.setString(8, time_form_0);
			
			
			preparedStmt.setString(9, "New");

			// execute the prepared statement
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		
%>


<div>
<fieldset class="f1">
<div class="received-form-position">

We received the following details:<br>
<br>Date: <%= date_form_0 %> time: <%= time_form_0 %>
<br>Name: <%= name_form %>
<br>Number of Persons: <%= numOfPersons_form %>
<br>Phone: <%= phone_form %>
<br>E-mail: <%= email_form %>
<br>Comments\Allergies: <%= comments_form %><br>
<br>We will confirm your reservation by e-mail. 
<br>If you’ll not receive confirmation e-mail from us within 2 business day, 
please contact us by phone (204) - 1234567.


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