<%@include file="taglib_includes.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<script type="text/javascript" src="js/resources.js"></script>
<title>Show All Resources</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="css/mm_restaurant1.css" type="text/css" />
</head>
<body bgcolor="#FFFFFF">
<table bgcolor="#FFFFFF" width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr bgcolor="#99ccff">
    <td width="15" nowrap="nowrap">&nbsp;</td>
    <td width="745" height="60" colspan="2" class="logo" nowrap="nowrap"><br />
      SUN LIFE Project ManagementApplication<span class="tagline">| Ebix Software Inc. </span></td>
    <td width="100%">&nbsp;</td>
  </tr>
  <tr bgcolor="#0066cc">
    <td width="15" nowrap="nowrap">&nbsp;</td>
    <td height="36" colspan="2" id="navigation" nowrap="nowrap" class="navText"><a href="viewTheHome.do">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="viewAllAllocations.do">ALLOCATIONS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="viewAllTracks.do">TRACKS</a>&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp; <a href="javascript:;">REQUESTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="createReport.do">REPORTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;">FEEDBACK</a></td>
    <td>&nbsp;</td>
  </tr>
  <tr bgcolor="#ffffff">
    <td width="15" height="230" valign="top"><img src="images/mm_spacer.gif" alt="" width="15" height="1" border="0" /></td>
    <td width="35" valign="top"><img src="images/mm_spacer.gif" alt="" width="35" height="1" border="0" /></td>
    <td width="710" valign="top"><br />
        <form action="searchResources.do" method="post">
          <table style="border-collapse: collapse;" border="0" bordercolor="#006699" width="500">
            <tr>
              <td>Resource Name</td>
              <td><input type="text" name="name"/>
                &nbsp;&nbsp;
                <input name="submit" type="submit" value="Search"/>
                &nbsp;&nbsp;
                <input name="button" type="button" onclick="javascript:newResource()" value="New Resource"/>
              </td>
            </tr>
          </table>
        </form>
      <table style="border-collapse: collapse;" border="1" bordercolor="#006699" width="500">
          <tr bgcolor="lightblue">
            <th>Id</th>
            <th>Name</th>
            <th>Emp ID</th>
            <th>Mobile</th>
            <th></th>
          </tr>
          <c:if test="${empty SEARCH_RESOURCES_RESULTS_KEY}">
            <tr>
              <td colspan="4">No Results found</td>
            </tr>
          </c:if>
          <c:if test="${! empty SEARCH_RESOURCES_RESULTS_KEY}">
            <c:forEach var="resource" items="${SEARCH_RESOURCES_RESULTS_KEY}">
              <tr>
                <td><c:out value="${resource.id}"></c:out></td>
                <td><c:out value="${resource.name}"></c:out></td>
                <td><c:out value="${resource.empid}"></c:out></td>
                <td><c:out value="${resource.mobile}"></c:out></td>
                <td>&nbsp;<a href="updateResource.do?id=${resource.id}">Edit</a> &nbsp;&nbsp;<a href="javascript:deleteResource('deleteResource.do?id=${resource.id}');">Delete</a> </td>
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


	<tr>
	<td width="17">&nbsp;</td>
	<td width="165">&nbsp;</td>
	<td width="50">&nbsp;</td>
	<td width="545">&nbsp;</td>
	<td width="4">&nbsp;</td>
	<td width="329">&nbsp;</td>
	</tr>
</table>
</body>
</html>
