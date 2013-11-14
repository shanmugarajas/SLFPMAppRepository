<%@include file="taglib_includes.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<script type="text/javascript" src="js/resources.js"></script>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sun, 13 Oct 2013 00:00:00 GMT">
<script src="../js/jquery-1.9.1.js"></script>
 <script src="../js/jquery-ui-1.10.3.custom.js"></script>
 <script src="../js/jquery-ui-1.10.3.custom.min.js"></script>
 <link rel="stylesheet" href="../css/mm_restaurant1.css" type="text/css" />
 <link rel="stylesheet" href="../css/jquery-ui-1.9.2.custom.css" type="text/css" />
  <link rel="stylesheet" href="../css/jquery-ui-1.9.2.custom.min.css" type="text/css" />
<%
String userName = request.getUserPrincipal().getName();
session.setAttribute("user", userName);
System.out.println("User 1:" + userName);
System.out.println("User 2:" + session.getAttribute("user"));
%>
<script>
$(function() {
    $( "#tabs" ).tabs();
  });
</script>
</head>
<body bgcolor="#FFFFFF">

<table bgcolor="#FFFFFF" width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr bgcolor="#99ccff">
    <td width="15" nowrap="nowrap">&nbsp;</td>
    <td width="745" height="60" colspan="2" class="logo" nowrap="nowrap"><br />
      Ebix iPM <span class="tagline"> | Ebix Software Inc. </span></td>
    <td width="100%">&nbsp;</td>
  </tr>
  <tr bgcolor="#0066cc">
    <td width="15" nowrap="nowrap">&nbsp;</td>
    <td height="36" colspan="2" id="navigation" nowrap="nowrap" class="navText"><security:authorize ifAnyGranted="ROLE_ADMIN, ROLE_OFFSHOREPM, ROLE_ONSITEPM"> <a href="viewAllResources.do"> </security:authorize> <security:authorize ifAnyGranted="ROLE_USER"> <a href="viewMyResources.do"> </security:authorize>RESOURCES</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<security:authorize ifAnyGranted="ROLE_ADMIN, ROLE_OFFSHOREPM, ROLE_ONSITEPM"> <a href="viewAllAllocations.do"> </security:authorize> <security:authorize ifAnyGranted="ROLE_USER"> <a href="viewMyAllocations.do"> </security:authorize>ALLOCATIONS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="viewAllTracks.do">TRACKS</a>&nbsp;&nbsp;
     &nbsp;&nbsp;&nbsp;&nbsp; <a href="fb/friends/100007063864816/CAAIZBYcaG76oBAJWvv9EAxHkmG6NHqEXE0jCVZClPICdBpoZANX0ZB4kFrYft4MbzgJjebLs8PgLqOOgkmUwWGb2Ngise6LIj0rPV7wJMADY10v7yaksoK60FuZACAVEqfNjlJ20kkNLzc1Mgp4iTZCcWvSoWjEqe8Ngh1yD0JZCHGnEGwD1SYF9K7vKuo32GQZD.do">FRIENDS </a> &nbsp;&nbsp;&nbsp; <a href="viewAllRequests.do">REQUESTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="fb/profile/100007063864816/CAAIZBYcaG76oBAJWvv9EAxHkmG6NHqEXE0jCVZClPICdBpoZANX0ZB4kFrYft4MbzgJjebLs8PgLqOOgkmUwWGb2Ngise6LIj0rPV7wJMADY10v7yaksoK60FuZACAVEqfNjlJ20kkNLzc1Mgp4iTZCcWvSoWjEqe8Ngh1yD0JZCHGnEGwD1SYF9K7vKuo32GQZD.do">PROFILE</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="showReports.do">REPORTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<security:authentication property="principal.username"></security:authentication>: &nbsp;<a href="<c:url value='j_spring_security_logout'/>">Click here to logout</a></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
  </tr>
	<tr bgcolor="#ffffff">
		<td colspan="6"><img src="../images/mm_spacer.gif" alt="" width="1" height="1" border="0" />
		</td>
	</tr>
	
	<tr>
		
		<table bgcolor="#ffffff" border="0" cellspacing="0" cellpadding="0" width="600">
			<td width="15" nowrap="nowrap">&nbsp;</td>
			<td colspan="2" valign="top" bgcolor="#ffffff">
				
				<img src="images/Ebix1.jpg" alt="" width="180" height="131" border="0" />
				
				<table border="0" cellspacing="0" cellpadding="0" width="180">
					<tr>
						<td width="9">&nbsp;</td>
						<td width="168" class="smallText" id="padding">
							<p style="color:Black;font-size: large;font-family: 'Calibri';">
							<b>	Connected to Facebook!</b>
				
								<form id="disconnect" action="facebook.do"  method="post">
									<button type="submit" text="disconnect">Disconnect</button>	
									<input type="hidden" name="_method" value="delete" />
								</form>		
						</td>
						<td width="10">
							&nbsp;
						</td>
					</tr>
				</table> 
				
			</td>
			<td width="15" nowrap="nowrap">&nbsp;</td>
			<td nowrap="nowrap" style=" width : 600px;">
				<p style="color:Black;font-size: large;font-family: 'Calibri';">
				<b>Introduction</b>
				</p>
				
				<p nowrap="nowrap" style="color:Black;FONT-FAMILY: 'Calibri'; FONT-SIZE: medium;">
					Ebix executes multiple support tracks for Sun Life in Coimbatore and Hyderabad.	
					<br/>		
					QPS (Quoting and Processing System) development track and Quality Testing are two of those support tracks. 
					<br/>
					Others include QPS related system/software development and maintenance activities.
					<br/>
					This application provides below management support for all the Offshore Sun Life activities at Ebix, India.	
				</p>
					<ol>
						<li style="color:Black;FONT-FAMILY: 'Calibri'; FONT-SIZE: small;">Details of Developers/Testers  at both Onsite and Offshore</li>
						<li style="color:Black;FONT-FAMILY: 'Calibri'; FONT-SIZE: small;">Sun Life sub projects status</li>
						<li style="color:Black;FONT-FAMILY: 'Calibri'; FONT-SIZE: small;">Invoices development and historical data</li>
						<li style="color:Black;FONT-FAMILY: 'Calibri'; FONT-SIZE: small;">Planning and tracking of activities to ramp up resources assigned to Sun Life projects </li>
					</ol>
				<br />		
			</td>
			</tr>
		</table>	
	</tr>
	 	
</table>

</body>
</html>

