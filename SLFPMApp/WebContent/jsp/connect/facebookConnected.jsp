<%@include file="taglib_includes.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->

<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sun, 13 Oct 2013 00:00:00 GMT">
<script src="../../../../../SLFPMApp/js/jquery-1.9.1.js"></script>
<script src="../../../../../SLFPMApp/js/resources.js"></script>
 <script src="../../../../../SLFPMApp/js/jquery-ui-1.10.3.custom.js"></script>
 <script src="../../../../../SLFPMApp/js/jquery-ui-1.10.3.custom.min.js"></script>
 <link rel="stylesheet" href="../../../../../SLFPMApp/css/mm_restaurant1.css" type="text/css" />
 
<%
String userName = request.getUserPrincipal().getName();
session.setAttribute("user", userName);

System.out.println("profileLink: " + session.getAttribute("profileLink"));
System.out.println("sessionProfileLink: " + session.getAttribute("sessionProfileLink"));

if (session.getAttribute("profileInfo") != null)
	session.setAttribute("sessionProfileInfo", request.getAttribute("profileInfo"));
if (session.getAttribute("profileLink") != null)
	session.setAttribute("sessionProfileLink", request.getAttribute("profileLink"));
%>
</head>
<body bgcolor="#FFFFFF" onload="loadProfile()";>
<script>
function loadProfile()
{
   $("#profile").submit();   
}
function loadFriends()
{
   $("#friends").submit();  
}
function loadForms()
{
  loadProfile();
  loadFriends(); 
}
</script>

<table bgcolor="#FFFFFF" width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr bgcolor="#99ccff">
    <td width="15" nowrap="nowrap">&nbsp;</td>
    <td width="745" height="60" colspan="2" class="logo" nowrap="nowrap"><br />
      Ebix iPM <span class="tagline"> | Ebix Software Inc. </span></td>
    <td width="100%">&nbsp;</td>
  </tr>
  <tr bgcolor="#0066cc">
    <td width="15" nowrap="nowrap">&nbsp;</td>
    <td height="36" colspan="2" id="navigation" nowrap="nowrap" class="navText"><security:authorize ifAnyGranted="ROLE_ADMIN, ROLE_OFFSHOREPM, ROLE_ONSITEPM"> <a href="${pageContext.request.contextPath}/viewAllResources.do"> </security:authorize> <security:authorize ifAnyGranted="ROLE_USER"> <a href="${pageContext.request.contextPath}/viewMyResources.do"> </security:authorize>RESOURCES</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<security:authorize ifAnyGranted="ROLE_ADMIN, ROLE_OFFSHOREPM, ROLE_ONSITEPM"> <a href="${pageContext.request.contextPath}/viewAllAllocations.do"> </security:authorize> <security:authorize ifAnyGranted="ROLE_USER"> <a href="viewMyAllocations.do"> </security:authorize>ALLOCATIONS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/viewAllTracks.do">TRACKS</a>&nbsp;&nbsp;
     &nbsp;&nbsp;&nbsp;&nbsp; <a href="fb/friends/100007063864816/CAAIZBYcaG76oBAJWvv9EAxHkmG6NHqEXE0jCVZClPICdBpoZANX0ZB4kFrYft4MbzgJjebLs8PgLqOOgkmUwWGb2Ngise6LIj0rPV7wJMADY10v7yaksoK60FuZACAVEqfNjlJ20kkNLzc1Mgp4iTZCcWvSoWjEqe8Ngh1yD0JZCHGnEGwD1SYF9K7vKuo32GQZD.do">FRIENDS </a> &nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/viewAllRequests.do">REQUESTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="fb/profile/100007063864816/CAAIZBYcaG76oBAJWvv9EAxHkmG6NHqEXE0jCVZClPICdBpoZANX0ZB4kFrYft4MbzgJjebLs8PgLqOOgkmUwWGb2Ngise6LIj0rPV7wJMADY10v7yaksoK60FuZACAVEqfNjlJ20kkNLzc1Mgp4iTZCcWvSoWjEqe8Ngh1yD0JZCHGnEGwD1SYF9K7vKuo32GQZD.do">PROFILE</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/showReports.do">REPORTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<security:authentication property="principal.username"></security:authentication>: &nbsp;<a href="${pageContext.request.contextPath}/logout.do">Click here to logout</a></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
  </tr>
	<tr bgcolor="#ffffff">
		
		</td>
	</tr>
	
	<tr>
		
		<table bgcolor="#ffffff" border="0" cellspacing="0" cellpadding="0" width="600">
			<td width="15" nowrap="nowrap">&nbsp;</td>
			<td colspan="2" valign="top" bgcolor="#ffffff">
				
				
				
				<table border="0" cellspacing="0" cellpadding="0" width="180">
					<tr>
						<td width="200" class="smallText" id="padding">
							<p style="color:Black;font-size: large;font-family: 'Calibri';">
							<b>	Connected to Facebook!</b>
								<form id="disconnect" action="../../../../../SLFPMApp/connect/facebook.do"  method="post">
									<button type="submit" text="disconnect">Disconnect</button>	
									<input type="hidden" name="_method" value="delete" />
								</form>								
						</td>
						
						<td width="10">
							&nbsp;
						</td>
					</tr>
					<tr>
						<td width="200" class="smallText" id="padding">
							<p style="color:Black;font-size: large;font-family: 'Calibri';">
							<b>	Show Facebook Profile!</b>
								<form id="profile" action="../../../../../SLFPMApp/connect/fb/profile/100007063864816/CAAIZBYcaG76oBAJWvv9EAxHkmG6NHqEXE0jCVZClPICdBpoZANX0ZB4kFrYft4MbzgJjebLs8PgLqOOgkmUwWGb2Ngise6LIj0rPV7wJMADY10v7yaksoK60FuZACAVEqfNjlJ20kkNLzc1Mgp4iTZCcWvSoWjEqe8Ngh1yD0JZCHGnEGwD1SYF9K7vKuo32GQZD.do"  method="get";  return false;>
								
								</form>					
						</td>
					</tr>
					<tr>
						<td width="200" class="smallText" id="padding">
							<p style="color:Black;font-size: large;font-family: 'Calibri';">
							<b>	List Facebook Friends!</b>
								<form id="friends" action="../../../../../SLFPMApp/connect/fb/friends/100007063864816/CAAIZBYcaG76oBAJWvv9EAxHkmG6NHqEXE0jCVZClPICdBpoZANX0ZB4kFrYft4MbzgJjebLs8PgLqOOgkmUwWGb2Ngise6LIj0rPV7wJMADY10v7yaksoK60FuZACAVEqfNjlJ20kkNLzc1Mgp4iTZCcWvSoWjEqe8Ngh1yD0JZCHGnEGwD1SYF9K7vKuo32GQZD.do"  method="get";  return false;>	
								</form>					
						</td>
					</tr>
				</table> 
				
			</td>
			<td width="15" nowrap="nowrap">&nbsp;</td>
			<td nowrap="nowrap" style=" width : 600px;">
				<table colspan=2 align=center border=1>
	     <th colspan=2>
	         Profile Details
	     </th>
	     <tr>
	         <td> <b> Pic </b></td>
	          <td align=center>
	          <c:url var="imgurl" value="http://graph.facebook.com/${profileInfo.id}/picture" />
	          <img src="${imgurl}" alt="anotherimage" />
	        
	         </td>
	     </tr>
	     <tr>
	        <td> <b> Url </b></td>
	        <td>${profileLink}</td>
	     </tr>
	      <tr>
	        <td> <b> id </b></td>
	        <td>${profileInfo.id}</td>
	     </tr>
	      <tr>
	        <td> <b> Name </b></td>
	        <td>${profileInfo.name}</td>
	     </tr>
	
	</table>	
			</td>
			
			<td width="15" nowrap="nowrap">&nbsp;</td>
			<td nowrap="nowrap" style=" width : 600px;">
	<table style="border: 1px solid; width: 50%; text-align:center">
	<thead style="background:#d3dce3">
		<tr>
			<th>Friend Id's</th>	
		</tr>
	</thead>
	<tbody style="background:#ccc">
	<c:forEach items="${friendsList}" var="friend">
			<tr>
				<td><c:out value="${friend}" /></td>
			</tr>
	</c:forEach>
		
	</tbody>
</table>
			</td>
			</tr>
		</table>	
	</tr>
	 	
</table>

</body>


</html>

