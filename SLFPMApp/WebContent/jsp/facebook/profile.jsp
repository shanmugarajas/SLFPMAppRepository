<%@include file="taglib_includes.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1"> 
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->

<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<script src="../../../../../SLFPMApp/js/jquery-1.9.1.js"></script>
<script src="../../../../../SLFPMApp/js/resources.js"></script>
 <script src="../../../../../SLFPMApp/js/jquery-ui-1.10.3.custom.js"></script>
 <script src="../../../../../SLFPMApp/js/jquery-ui-1.10.3.custom.min.js"></script>
 <link rel="stylesheet" href="../../../../../SLFPMApp/css/mm_restaurant1.css" type="text/css" />
 
<%
String savedProviderUserId = "";
savedProviderUserId = (String) session.getAttribute("providerUserId");
String savedProfileInfoName = "";
savedProfileInfoName = (String) session.getAttribute("profileInfoName");
System.out.println("In profile page savedProviderUserId:" + savedProviderUserId);
System.out.println("In profile page savedProfileInfoName:" + savedProfileInfoName);
String userName = "";
userName = request.getUserPrincipal().getName();
session.setAttribute("user", userName);
%>

</head>
<body bgcolor="#FFFFFF">
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=631539616903082";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

<div id="fb-root"></div>

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
<div id="mainbody">

	<tr>
			<td width="15" nowrap="nowrap">&nbsp;</td>
				<td>
						<table border="0" cellspacing="0" cellpadding="0" width="220">
							<tr>  
								<td width="15" nowrap="nowrap">&nbsp;</td>
								<td>       		
					  				<c:url var="imgurl" value="http://graph.facebook.com/${providerUserId}/picture" />
					   				<img src="${imgurl}" alt="anotherimage" />
					   			</td>
					   			<td>
					   				<div class="fb-like" data-href="https://developers.facebook.com/docs/plugins/" data-layout="button" data-action="like" data-show-faces="true" data-share="true"></div>
					   			</td>
								
					    	</tr>
					    	<%
					    	String showProfileInfoName = (String) request.getAttribute("profileInfoName");
					    	System.out.println("In profile page, request show name: " + showProfileInfoName);
					    	%>
					    	<tr>
							    	<td width="15" nowrap="nowrap">&nbsp;</td>
									<td width="170" class="smallText">
										<p style="font-size: small;font-family: 'Calibri';">
										Welcome! <%= (String) request.getAttribute("profileInfoName") %></p>
										<form id="disconnect" action="../../../../../SLFPMApp/connect/facebook.do"  method="post">
											<button type="submit" text="disconnect">Disconnect</button>	
											<input type="hidden" name="_method" value="delete" />
										</form>	
										<br>
										<br>
										<u>Friends List</u>
										<br>
										<c:forEach items="${friendsList}" var="friend">
										<c:out value="${friend}" />
										</c:forEach>
											
									</td>
							</tr>			
						</table>
					</td>
	</tr>
	</div>
</table>

</body>
</html>

