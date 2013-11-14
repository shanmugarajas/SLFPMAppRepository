<%@include file="taglib_includes.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<script type="text/javascript" src="js/resources.js"></script>
<title>Resources View</title>
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
    <td height="36" colspan="2" id="navigation" nowrap="nowrap" class="navText"><a href="connect/facebook.do">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="viewAllAllocations.do">ALLOCATIONS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="viewAllTracks.do">TRACKS</a>&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp; <a href="viewAllRequests.do">REQUESTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="createReport.do">REPORTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;">FEEDBACK</a></td>
    <td>&nbsp;</td>
  </tr>
 </table>

<table  bgcolor="#FFFFFF" width="750" height="500" align="left" style="border-collapse: collapse;" border="1" bordercolor="#FFFFFF" >
	<tr>
		<td align="left" style="FONT-SIZE: medium; FONT-FAMILY: 'Calibri';">Add Resource</td>
	</tr>
  <tr valign="top" align="left">
    <td align="left">
 		<form:form action="saveResource.do" method="post" commandName="newResource">
	    	
				<table width="500" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2">	
					<tr>
						<td width="100" align="right">Name</td>
						<td width="150">
						<form:input path="name"/></td>
						<td align="left">
						<form:errors path="name" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
					<tr>
						<td width="100" align="right">DOJ SunLife</td>
						<td><form:input path="dojslf"/></td>
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
					<tr>
						<td colspan="3" align="center">
						<input type="submit" name="" value="Save">
						&nbsp;&nbsp;
						<input type="reset" name="" value="Reset">
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
