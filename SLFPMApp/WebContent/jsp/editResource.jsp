<%@include file="taglib_includes.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Resources View</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<script src="../../../../../SLFPMApp/js/jquery-1.9.1.js"></script>
<script src="../../../../../SLFPMApp/js/resources.js"></script>
 <script src="../../../../../SLFPMApp/js/jquery-ui-1.10.3.custom.js"></script>
 <script src="../../../../../SLFPMApp/js/jquery-ui-1.10.3.custom.min.js"></script>
 <link rel="stylesheet" href="../../../../../SLFPMApp/css/mm_restaurant1.css" type="text/css" />
<script>
$(function()
{
	$("#datepicker").datepicker({dateFormat: 'dd-mm-yy'});
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
    <td height="36" colspan="2" id="navigation" nowrap="nowrap" class="navText"><a href="${pageContext.request.contextPath}/connect/facebook.do">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/viewAllAllocations.do">ALLOCATIONS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/viewAllTracks.do">TRACKS</a>&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/viewAllRequests.do">REQUESTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/createReport.do">REPORTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<security:authentication property="principal.username"></security:authentication>: &nbsp;<a href="${pageContext.request.contextPath}/connect/logout.do">Click here to logout</td>
    <td>&nbsp;</td>
  </tr>
 </table>

<table  bgcolor="#FFFFFF" width="750" height="500" align="left" style="border-collapse: collapse;" border="1" bordercolor="#FFFFFF" >
	<tr>
		<td align="left" style="FONT-SIZE: medium; FONT-FAMILY: 'Calibri';">Edit Resource</td>
	</tr>
  <tr valign="top" align="left">
    <td align="left">
 		<form:form action="updateResource.do" method="post" commandName="editResource">
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
						<form:input path="name"/></td>
						<td align="left">
						<form:errors path="name" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
					<tr>
						<td width="100" align="right">Date of Joining SLF</td>
						<td><form:input path="dojslf" id="datepicker"/></td>
						<td align="left"><form:errors path="dojslf" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Emp Status</td>
						<td>						
							<form:select path="empstatus">
					            <form:option value="A" label="Active"/>
					            <form:option value="I" label="Inactive"/>
					        </form:select>						
						</td>
						<td>
						</td>						
					</tr>
					<tr>
						<td width="100" align="right">Emp ID</td>
						<td><form:input path="empid"/></td>
						<td align="left">
						<form:errors path="empid" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Email</td>
						<td><form:input path="email"/></td>
						<td align="left"><form:errors path="email" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Mobile</td>
						<td><form:input path="mobile"/></td>
						<td align="left">
						<form:errors path="mobile" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr valign="bottom">
						<td colspan="3" align="center">
						<security:authorize ifAnyGranted="ROLE_ADMIN">
						<input type="button"  value="Delete" onclick="javascript:deleteResource('deleteResource.do?id=${editResource.id}');">
						</security:authorize>
						&nbsp;&nbsp;
						<input type="submit" name="" value="Save">						
						<security:authorize ifAnyGranted="ROLE_ADMIN">
						<input type="button"  value="Back" onclick="javascript:go('viewAllResources.do');">
						</security:authorize>
						&nbsp;&nbsp;
						<security:authorize ifAnyGranted="ROLE_USER">
						<input type="button"  value="Back" onclick="javascript:go('viewMyResources.do');">
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
