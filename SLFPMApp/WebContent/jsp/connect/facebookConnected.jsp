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

System.out.println("profileInfoname: " + session.getAttribute("profileInfoname"));


if (session.getAttribute("profileInfo") != null)
	{
	session.setAttribute("sessionProfileInfoname", request.getAttribute("profileInfoname"));
	session.setAttribute("sessionProfileInfoid", request.getAttribute("profileInfoid"));
	System.out.println("sessionProfileInfoname: " + session.getAttribute("sessionProfileInfoname"));
	}

if (session.getAttribute("profileLink") != null)
	session.setAttribute("sessionProfileLink", request.getAttribute("profileLink"));


%>
</head>
<body bgcolor="#FFFFFF" onload="loadProfile();">
<script>
function loadProfile()
{
   $("#profile").submit(); 
   $("#friends").submit();
     
}
function loadFriends()
{
   $("#friends").submit();  
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

<% 	String profileInfoid =  (String) session.getAttribute("sessionProfileInfoid");
	String profileInfoname =  (String) session.getAttribute("sessionProfileInfoname");
	String profileLink = (String) session.getAttribute("sessionProfileLink");
%>	
	<tr>
	<table border="0" cellspacing="0" cellpadding="0" width="220">
			<tr>  
				<td width="15" nowrap="nowrap">&nbsp;</td>
				<td>       		
		  			<c:url var="imgurl" value="http://graph.facebook.com/${profileInfo.id}/picture" />
		   			<img src="${imgurl}" alt="anotherimage" />
		   		</td>
		    </tr>
		    <tr>
		    	<td width="15" nowrap="nowrap">&nbsp;</td>
				<td width="170" class="smallText">
					<p style="color:Black;font-size: medium;font-family: 'Calibri';">
					Hi! ${profileInfoname}</p>
					<form id="disconnect" action="../../../../../SLFPMApp/connect/facebook.do"  method="post">
						<button type="submit" text="disconnect">Disconnect</button>	
						<input type="hidden" name="_method" value="delete" />
					</form>		
					<form id="profile" action="../../../../../SLFPMApp/connect/fb/profile/100007063864816/CAAIZBYcaG76oBAJWvv9EAxHkmG6NHqEXE0jCVZClPICdBpoZANX0ZB4kFrYft4MbzgJjebLs8PgLqOOgkmUwWGb2Ngise6LIj0rPV7wJMADY10v7yaksoK60FuZACAVEqfNjlJ20kkNLzc1Mgp4iTZCcWvSoWjEqe8Ngh1yD0JZCHGnEGwD1SYF9K7vKuo32GQZD.do"  method="get";  return false;></form>		
					<form id="friends" action="../../../../../SLFPMApp/connect/fb/friends/100007063864816/CAAIZBYcaG76oBAJWvv9EAxHkmG6NHqEXE0jCVZClPICdBpoZANX0ZB4kFrYft4MbzgJjebLs8PgLqOOgkmUwWGb2Ngise6LIj0rPV7wJMADY10v7yaksoK60FuZACAVEqfNjlJ20kkNLzc1Mgp4iTZCcWvSoWjEqe8Ngh1yD0JZCHGnEGwD1SYF9K7vKuo32GQZD.do"  method="get";  return false;></form>					
				</td>
			</tr>		
		    <tr height="15" nowrap="nowrap">&nbsp;</tr>
		</table>
		<table border="0" cellspacing="0" cellpadding="0" width="350">
		    <td width="200">	
				<tr><b><u>List of Friends</u></b></tr>	
				<tr height="15" nowrap="nowrap">&nbsp;</tr>
					<c:forEach items="${friendsList}" var="friend">
						<tr>
							<td><c:out value="${friend}" /></td>
						</tr>
					</c:forEach>
				</tr>
			</td>
		</table>
	</tr>
</table> 
</body>
</html>

