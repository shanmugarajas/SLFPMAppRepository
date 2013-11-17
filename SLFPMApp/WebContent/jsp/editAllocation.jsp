<%@include file="taglib_includes.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Allocations Edit</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<script src="../../../../../SLFPMApp/js/jquery-1.9.1.js"></script>
<script src="../../../../../SLFPMApp/js/resources.js"></script>
 <script src="../../../../../SLFPMApp/js/jquery-ui-1.10.3.custom.js"></script>
 <script src="../../../../../SLFPMApp/js/jquery-ui-1.10.3.custom.min.js"></script>
 <link rel="stylesheet" href="../../../../../SLFPMApp/css/mm_restaurant1.css" type="text/css" />

</head>
<body style="font-family: Arial; font-size:smaller;">
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
  <tr/>
</table>

<table  bgcolor="#FFFFFF" width="750" height="500" align="left" style="border-collapse: collapse;" border="1" bordercolor="#FFFFFF" >
	<tr>
		<td align="left" style="FONT-SIZE: medium; FONT-FAMILY: 'Calibri';">Edit Allocation</td>
	</tr>
  <tr valign="top" align="left">
    <td align="left">
 		<form:form action="updateAllocation.do" method="post" commandName="editAllocation">
				<table width="500" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2">					
					<tr>
						<td width="100" align="right">Id</td>
						<td width="150">
						<form:input path="id" readonly="true"/></td>
						<td align="left">
						<form:errors path="id" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Name</td>
						<td>
						<form:input path="resourceid" readonly="true"/></td>
						<td align="left">
						<form:errors path="resourceid" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
					<tr>
						<td width="100" align="right">Track Name</td>
						<td><form:input path="trackid" readonly="true"/></td>
						<td align="left"><form:errors path="trackid" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">ACF2ID</td>
						<td><form:input path="acf2id"/></td>
						<td align="left"><form:errors path="acf2id" cssStyle="color:red"></form:errors>  </td>						
						</td>
						<td>
						</td>						
					</tr>
					<tr>
						<td width="100" align="right">VPN Token</td>
						<td><form:input path="vpntoken"/></td>
						<td align="left">
						<form:errors path="vpntoken" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Billing Status</td>
						<td><form:input path="billingstatus"/></td>
						<td align="left">
						<form:errors path="billingstatus" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Project Start Date</td>
						<td><form:input path="projstartdate"/></td>
						<td align="left">
						<form:errors path="projstartdate" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Project End Date</td>
						<td><form:input path="projenddate"/></td>
						<td align="left">
						<form:errors path="projenddate" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Percent Allocation</td>
						<td><form:input path="percentallocation"/></td>
						<td align="left">
						<form:errors path="percentallocation" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Project Module</td>
						<td><form:input path="projectmodule"/></td>
						<td align="left">
						<form:errors path="projectmodule" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">SunLife Lead</td>
						<td><form:input path="sunlifelead"/></td>
						<td align="left">
						<form:errors path="sunlifelead" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Role</td>
						<td><form:input path="role"/></td>
						<td align="left">
						<form:errors path="role" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr valign="bottom">
						<td colspan="3" align="center">
						<security:authorize ifAnyGranted="ROLE_ADMIN">
						<input type="button"  value="Delete" onclick="javascript:deleteResource('deleteResource.do?id=${editResource.id}');">
						</security:authorize>
						&nbsp;&nbsp;
						<input type="submit" name="" value="Save">						
						&nbsp;&nbsp;
						<security:authorize ifAnyGranted="ROLE_ADMIN">
						<input type="button"  value="Back" onclick="javascript:go('viewAllAllocations.do');">
						</security:authorize>
						<security:authorize ifAnyGranted="ROLE_USER">
						<input type="button"  value="Back" onclick="javascript:go('viewMyAllocations.do');">
						</security:authorize>
						</td>
					</tr>
					
				</table>				
		</form:form>
    </td>    
  </tr>
</table>


</body>
</html>
