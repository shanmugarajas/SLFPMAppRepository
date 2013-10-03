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
    <td height="36" colspan="2" id="navigation" nowrap="nowrap" class="navText"><a href="viewTheHome.do">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="viewAllAllocations.do">ALLOCATIONS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="viewAllTracks.do">TRACKS</a>&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp; <a href="javascript:;">REQUESTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="createReport.do">REPORTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;">FEEDBACK</a></td>
    <td>&nbsp;</td>
  </tr>
 </table>

<table  bgcolor="#FFFFFF" width="750" height="500" align="left" style="border-collapse: collapse;" border="1" bordercolor="#FFFFFF" >
	<tr>
		<td align="left" style="FONT-SIZE: medium; FONT-FAMILY: 'Calibri';">Add Allocation</td>
	</tr>
  <tr valign="top" align="left">
    <td align="left">
 		<form:form action="saveAllocation.do" method="post" commandName="newAllocation">
	    	
				<table width="500" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2">	
					<tr>
						<td width="100" align="right">Resource Name</td>
						<td width="150">
							<select name="mapResData">
							<c:if test="${! empty DROPDOWN_RESOURCES_RESULTS_KEY}">
            					<c:forEach var="resource" items="${DROPDOWN_RESOURCES_RESULTS_KEY}">
							         <option value="${resource.id}">${resource.name}</option>
							    </c:forEach>
							    </c:if>
							</select>
      					</td>
						
					</tr>
					
					<tr>
						<td width="100" align="right">Track Name</td>
						<td>
						<select name="mapTrkData">
							<c:if test="${! empty DROPDOWN_TRACKS_RESULTS_KEY}">
            					<c:forEach var="track" items="${DROPDOWN_TRACKS_RESULTS_KEY}">
							         <option value="${track.id}">${track.name}</option>
							    </c:forEach>
							    </c:if>
							</select>
						</td>
						
					</tr>
					
					<tr>
						<td width="100" align="right">ACF2 ID</td>
						<td width="150">
						<form:input path="acf2id"/></td>
						<td align="left">
						<form:errors path="acf2id" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
					<tr>
						<td width="100" align="right">VPN Token</td>
						<td width="150">
						<form:input path="vpntoken"/></td>
						<td align="left">
						<form:errors path="vpntoken" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
					<tr>
						<td width="100" align="right">VPN Token</td>
						<td width="150">
						<form:input path="vpnexpiry"/></td>
						<td align="left">
						<form:errors path="vpnexpiry" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
					<tr>
						<td width="100" align="right">Billing Status</td>
						<td width="150">
						<form:input path="billingstatus"/></td>
						<td align="left">
						<form:errors path="billingstatus" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
					<tr>
						<td width="100" align="right">Project Start Date</td>
						<td width="150">
						<form:input path="projstartdate"/></td>
						<td align="left">
						<form:errors path="projstartdate" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
					<tr>
						<td width="100" align="right">Project End Date</td>
						<td width="150">
						<form:input path="projenddate"/></td>
						<td align="left">
						<form:errors path="projenddate" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
					<tr>
						<td width="100" align="right">Percent Allocation</td>
						<td width="150">
						<form:input path="percentallocation"/></td>
						<td align="left">
						<form:errors path="percentallocation" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
					<tr>
						<td width="100" align="right">Project Module</td>
						<td width="150">
						<form:input path="projectmodule"/></td>
						<td align="left">
						<form:errors path="projectmodule" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
					<tr>
						<td width="100" align="right">SunLife Lead</td>
						<td width="150">
						<form:input path="Sunlifelead"/></td>
						<td align="left">
						<form:errors path="Sunlifelead" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
					<tr>
						<td width="100" align="right">Role</td>
						<td width="150">
						<form:input path="role"/></td>
						<td align="left">
						<form:errors path="role" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
					<tr>
						<td colspan="3" align="center">
						<input type="submit" name="" value="Save">
						&nbsp;&nbsp;
						<input type="reset" name="" value="Reset">
						&nbsp;&nbsp;
						<input type="button"  value="Back" onclick="javascript:go('viewAllAllocations.do');">
						</td>
					</tr>					
				</table>			
		</form:form>
    </td>    
  </tr>
</table>
</body>
</html>
