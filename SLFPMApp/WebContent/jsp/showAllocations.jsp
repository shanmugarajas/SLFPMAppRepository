<%@include file="taglib_includes.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<script type="text/javascript" src="js/resources.js"></script>
<title>Allocations view</title>
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
    <td height="36" colspan="2" id="navigation" nowrap="nowrap" class="navText"><a href="viewTheHome.do">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="viewAllResources.do">RESOURCES</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="viewAllTracks.do">TRACKS</a>&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp; <a href="javascript:;">REQUESTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="createReport.do">REPORTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;">FEEDBACK</a></td>
    <td>&nbsp;</td>
  </tr>
  <tr bgcolor="#ffffff">
    <td width="15" height="230" valign="top"><img src="images/mm_spacer.gif" alt="" width="15" height="1" border="0" /></td>
    
    <td width="710" valign="top"><br />
       <form action="searchAllocations.do" method="post">
          <table style="border-collapse: collapse;" border="0" bordercolor="#006699" width="500">
            <tr>
              <td>Allocated Project</td>
              <td><input type="text" name="ProjectModule"/>
                &nbsp;&nbsp;
                <input name="submit" type="submit" value="Search"/>
                &nbsp;&nbsp;
                <input name="button" type="button" onclick="javascript:newAllocation()" value="New Allocation"/>
              </td>
            </tr>
          </table>
        </form>
      <table style="border-collapse: collapse;" border="1" bordercolor="#006699" width="500">
          <tr bgcolor="E0E0D1">
            <th>ID</th>
            <th>Resource</th>
            <th>Track</th>
            <th>ACF2ID</th>
            <th>VPNToken</th>
            <th>BillingStatus</th>
            <th>ProjStartDate</th>
            <th>ProjEndDate</th>
            <th>PercentAllocation</th>
            <th>ProjectModule</th>
            <th>SunLifeLead</th>
            <th>Role</th>
            <th></th>
          </tr>
          <c:if test="${empty SEARCH_ALLOCATIONS_RESULTS_KEY}">
            <tr>
              <td colspan="4">No Results found</td>
            </tr>
          </c:if>
          <c:if test="${! empty SEARCH_ALLOCATIONS_RESULTS_KEY}">
            <c:forEach var="allocation" items="${SEARCH_ALLOCATIONS_RESULTS_KEY}">
            <tr>
                
                <td><c:out value="${allocation.id}"></c:out></td>
				<td><c:out value="${allocation.resource.name}"></c:out></td>
				<td><c:out value="${allocation.track.name}"></c:out></td>
				<td><c:out value="${allocation.ACF2ID}"></c:out></td>
				<td><c:out value="${allocation.VPNToken}"></c:out></td>
				<td><c:out value="${allocation.billingStatus}"></c:out></td>
				<td><c:out value="${allocation.projStartDate}"></c:out></td>
				<td><c:out value="${allocation.projEndDate}"></c:out></td>
				<td><c:out value="${allocation.percentAllocation}"></c:out></td>
				<td><c:out value="${allocation.projectModule}"></c:out></td>
				<td><c:out value="${allocation.sunLifeLead}"></c:out></td>
				<td><c:out value="${allocation.role}"></c:out></td>
				<td>&nbsp;<a href="updateAllocation.do?id=${allocation.id}">Edit</a> &nbsp;&nbsp;<a href="javascript:deleteAllocation('deleteAllocation.do?id=${allocation.id}');">Delete</a> </td>				
              </tr>
            </c:forEach>
          </c:if>
      </table></td>
      

  <td>&nbsp;</td>
  	<tr bgcolor="#ffffff">
	<td colspan="6"><img src="images/mm_spacer.gif" alt="" width="1" height="1" border="0" /></td>
	</tr>

	<tr>
	<td colspan="6">&nbsp;</td>
	</tr>


	<tr bgcolor="#003399">
	<td colspan="6"><img src="images/mm_spacer.gif" alt="" width="1" height="1" border="0" /></td>
	</tr>

	<tr>
	<td colspan="6"><img src="images/mm_spacer.gif" alt="" width="1" height="2" border="0" /></td>
	</tr>

	<tr bgcolor="#003399">
	<td colspan="6"><img src="images/mm_spacer.gif" alt="" width="1" height="1" border="0" /></td>
	</tr>


	
</table>
</body>
</html>