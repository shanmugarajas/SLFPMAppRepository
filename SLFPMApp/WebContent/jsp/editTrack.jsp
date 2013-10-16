<%@include file="taglib_includes.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<script type="text/javascript" src="js/resources.js"></script>
<title>Edit Track</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="css/mm_restaurant1.css" type="text/css" />
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
    <td height="36" colspan="2" id="navigation" nowrap="nowrap" class="navText"><a href="viewTheHome.do">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="viewAllResources.do">RESOURCES</a>&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp; <a href="viewAllAllocations.do">ALLOCATIONS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="viewAllRequests.do">REQUESTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="createReport.do">REPORTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;">FEEDBACK</a></td>
    <td>&nbsp;</td>
  </tr>
  </table>

<table  bgcolor="#FFFFFF" width="750" height="500" align="left" style="border-collapse: collapse;" border="1" bordercolor="#FFFFFF" >
	<tr>
		<td align="left" style="FONT-SIZE: medium; FONT-FAMILY: 'Calibri';">Edit Track</td>
	</tr>
  <tr valign="top" align="left">
    <td align="left">
 		<form:form action="updateTrack.do" method="post" commandName="editTrack">
 		
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
						<td width="100" align="right">Product</td>
						<td><form:input path="product"/></td>
						<td align="left"><form:errors path="product" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Location</td>
						<td><form:input path="location"/></td>
						<td align="left"><form:errors path="location" cssStyle="color:red"></form:errors>  </td>
						<td>
						</td>						
					</tr>
					<tr>
						<td width="100" align="right">Technology</td>
						<td><form:input path="technology"/></td>
						<td align="left">
						<form:errors path="technology" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Client Owner</td>
						<td><form:input path="clientowner"/></td>
						<td align="left"><form:errors path="clientowner" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Hourly Rate</td>
						<td><form:input path="hourlyrate"/></td>
						<td align="left">
						<form:errors path="hourlyrate" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr valign="bottom">
						<td colspan="3" align="center">
						<input type="button"  value="Delete" onclick="javascript:deleteTrack('deleteTrack.do?id=${editTrack.id}');">
						&nbsp;&nbsp;
						<input type="submit" name="" value="Save">						
						&nbsp;&nbsp;
						<input type="button"  value="Back" onclick="javascript:go('viewAllTracks.do');">
						</td>
					</tr>			
				</table>				
		</form:form>
    </td>    
  </tr>
</table>


</body>
</html>
