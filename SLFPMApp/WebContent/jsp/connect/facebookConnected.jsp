<%@include file="taglib_includes.jsp" %>

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
String savedAccessToken = "";
savedAccessToken = (String) session.getAttribute("accessToken");
%>

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
			    <td height="36" colspan="2" id="navigation" nowrap="nowrap" class="navText"><a href="${pageContext.request.contextPath}/connect/facebook.do">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/connect/viewAllResources.do">RESOURCES</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/viewAllTracks.do">TRACKS</a>&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/viewAllRequests.do">REQUESTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/createReport.do">REPORTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/connect/logout.do">Click here to logout</td>
			    <td>&nbsp;</td>
	</tr>
</table>
<div id="mainbody">
<form id="profileId" action="../../../SLFPMApp/connect/fb/getProfileIdintoSession.do"  method="get"></form>
</div>

<div id="loader">
	<table height="300" width="600">
		<tr width=100% align="center">
			<td height=100% align="center">
	  			<img src="../images/ajax-loader3.gif" />
	  		</td>
	  	</tr>
	</table>
</div>

<script type="text/javascript">
 $(document).ready( function(){
	 document.forms["profileId"].submit();
	 $( "#mainbody" ).hide();
	 $( "#loader" ).show();
	 });
 
 </script>
</body>
</html>

