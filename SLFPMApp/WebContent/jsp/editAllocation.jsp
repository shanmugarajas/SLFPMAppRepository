<%@include file="taglib_includes.jsp" %>

<html>
<head>
	<script type="text/javascript" src="js/resources.js"></script>
	<title><spring:message code="App.Title"></spring:message> </title>
</head>
<body style="font-family: Arial; font-size:smaller;">

<table  bgcolor="lightblue" width="750" height="500" align="center" style="border-collapse: collapse;" border="1" bordercolor="#006699" >
	<tr>
		<td align="center"><h3>Edit Allocation</h3></td>
	</tr>
  <tr valign="top" align="center">
    <td align="center">
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
