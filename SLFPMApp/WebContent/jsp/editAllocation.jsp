<%@include file="taglib_includes.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<script type="text/javascript" src="js/resources.js"></script>
<title>Allocations Edit</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="css/mm_restaurant1.css" type="text/css" />
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
    <td height="36" colspan="2" id="navigation" nowrap="nowrap" class="navText"><a href="viewTheHome.do">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="viewAllResources.do">RESOURCES</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="viewAllTracks.do">TRACKS</a>&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp; <a href="javascript:;">REQUESTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="createReport.do">REPORTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;">FEEDBACK</a></td>
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
						<form:input path="resource.name" readonly="true"/></td>
						<td align="left">
						<form:errors path="resource.name" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
					<tr>
						<td width="100" align="right">Track Name</td>
						<td><form:input path="track.name" readonly="true"/></td>
						<td align="left"><form:errors path="track.name" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">ACF2ID</td>
						<td><form:input path="ACF2ID"/></td>
						<td align="left"><form:errors path="ACF2ID" cssStyle="color:red"></form:errors>  </td>						
						</td>
						<td>
						</td>						
					</tr>
					<tr>
						<td width="100" align="right">VPN Token</td>
						<td><form:input path="VPNToken"/></td>
						<td align="left">
						<form:errors path="VPNToken" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Billing Status</td>
						<td><form:input path="BillingStatus"/></td>
						<td align="left">
						<form:errors path="BillingStatus" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Project Start Date</td>
						<td><form:input path="ProjStartDate"/></td>
						<td align="left">
						<form:errors path="ProjStartDate" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Project End Date</td>
						<td><form:input path="ProjEndDate"/></td>
						<td align="left">
						<form:errors path="ProjEndDate" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Percent Allocation</td>
						<td><form:input path="PercentAllocation"/></td>
						<td align="left">
						<form:errors path="PercentAllocation" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Project Module</td>
						<td><form:input path="ProjectModule"/></td>
						<td align="left">
						<form:errors path="ProjectModule" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">SunLife Lead</td>
						<td><form:input path="SunLifeLead"/></td>
						<td align="left">
						<form:errors path="SunLifeLead" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Role</td>
						<td><form:input path="Role"/></td>
						<td align="left">
						<form:errors path="Role" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr valign="bottom">
						<td colspan="3" align="center">
						<input type="button"  value="Delete" onclick="javascript:deleteResource('deleteResource.do?id=${editResource.id}');">
						&nbsp;&nbsp;
						<input type="submit" name="" value="Save">						
						&nbsp;&nbsp;
						<input type="button"  value="Back" onclick="javascript:go('viewAllResources.do');">
						</td>
					</tr>
					
				</table>				
		</form:form>
    </td>    
  </tr>
</table>


</body>
</html>
