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
String savedProviderUserId = (String) request.getAttribute("providerUserId");
String savedProfileInfoName = (String) request.getAttribute("profileInfoName");
session.setAttribute("sessionProfileInfoid", savedProviderUserId);
session.setAttribute("sessionProfileInfoName", savedProfileInfoName);
System.out.println("Request variable savedProviderUserId:" + savedProviderUserId);
String userName = request.getUserPrincipal().getName();
session.setAttribute("user", userName);
%>
</head>
<body bgcolor="#FFFFFF" onload="loadProfile();">
<script>
function loadProfile()
{
   $("#profile").submit();
   $("#friends").submit(); 
}
</script>

<form id="profileId" action="../../../SLFPMApp/connect/fb/getProfileIdintoSession.do"  method="get" return false;></form>

<table bgcolor="#FFFFFF" width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr bgcolor="#99ccff">
			    <td width="15" nowrap="nowrap">&nbsp;</td>
			    <td width="745" height="60" colspan="2" class="logo" nowrap="nowrap"><br />
			      Ebix iPM <span class="tagline"> | Ebix Software Inc. </span></td>
			    <td width="100%">&nbsp;</td>
	</tr>
	<tr bgcolor="#0066cc">
			    <td width="15" nowrap="nowrap">&nbsp;</td>
			    <td height="36" colspan="2" id="navigation" nowrap="nowrap" class="navText"><a href="${pageContext.request.contextPath}/connect/facebook.do">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/connect/viewAllResources.do">RESOURCES</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/viewAllTracks.do">TRACKS</a>&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/viewAllRequests.do">REQUESTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/createReport.do">REPORTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<security:authentication property="principal.username"></security:authentication>: &nbsp;<a href="${pageContext.request.contextPath}/connect/logout.do">Click here to logout</td>
			    <td>&nbsp;</td>
	</tr>

			<% 	String profileInfoid =  (String) session.getAttribute("savedProviderUserId");
				String profileInfoname =  (String) session.getAttribute("savedProfileInfoName");
			%>	
	<tr>
			<td width="15" nowrap="nowrap">&nbsp;</td>
				<td>
						<table border="0" cellspacing="0" cellpadding="0" width="220">
							<tr>  
								<td width="15" nowrap="nowrap">&nbsp;</td>
								<td>       		
					  				<c:url var="imgurl" value="http://graph.facebook.com/695769702/picture" />
					   				<img src="${imgurl}" alt="anotherimage" />
					   			</td>
					    	</tr>
					    	<tr>
							    	<td width="15" nowrap="nowrap">&nbsp;</td>
									<td width="170" class="smallText">
										<p style="font-size: small;font-family: 'Calibri';">
										Hi! ${profileInfoname}</p>
										<form id="disconnect" action="../../../../../SLFPMApp/connect/facebook.do"  method="post">
											<button type="submit" text="disconnect">Disconnect</button>	
											<input type="hidden" name="_method" value="delete" />
										</form>	
										<br>
										<br>
										<u>Friends List</u><br>
										<c:forEach items="${friendsList}" var="friend">
										<c:out value="${friend}" />
										</c:forEach>
										<%
										System.out.println("For graph.facebook.com savedProviderUserId:" + savedProviderUserId);
										%>	
										<form id="profile" action="../../../../../SLFPMApp/connect/fb/profile/695769702/CAAIZBYcaG76oBALygvZBNkS2BTGnQIhb5hgtTq6BwA5lqG81JxQFpbp4ZA7qKMZB6u3Oxk1rHdnFIomODLobytZCOzmJdGXep1XLY8ZCFz1YwUd5B9rtZAFRZBUTzV6OdRNb5ZBpsemlHvxLxzYfV4jz67z4e1xDZBrpIZAJYQs1ChIPAbd3r9TqFxZADFPpB3dre4MZD.do"  method="get";  return false;></form>		
										<form id="friends" action="../../../../../SLFPMApp/connect/fb/friends/695769702/CAAIZBYcaG76oBALygvZBNkS2BTGnQIhb5hgtTq6BwA5lqG81JxQFpbp4ZA7qKMZB6u3Oxk1rHdnFIomODLobytZCOzmJdGXep1XLY8ZCFz1YwUd5B9rtZAFRZBUTzV6OdRNb5ZBpsemlHvxLxzYfV4jz67z4e1xDZBrpIZAJYQs1ChIPAbd3r9TqFxZADFPpB3dre4MZD.do"  method="get";  return false;></form>					
									</td>
							</tr>			
						</table>
					</td>
	</tr>
</table> 
</body>
</html>

