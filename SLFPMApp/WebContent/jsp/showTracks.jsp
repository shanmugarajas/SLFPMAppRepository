<%@include file="taglib_includes.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<script type="text/javascript" src="js/resources.js"></script>
<title>Tracks View</title>
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
      &nbsp;&nbsp;&nbsp; <a href="viewAllAllocations.do">ALLOCATIONS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="javascript:;">REQUESTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="createReport.do">REPORTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;">FEEDBACK</a></td>
    <td>&nbsp;</td>
  </tr>
  <tr bgcolor="#ffffff">
    <td width="15" height="230" valign="top"><img src="images/mm_spacer.gif" alt="" width="15" height="1" border="0" /></td>
    
    <td width="710" valign="top"><br />
        <form action="searchTracks.do" method="post">
          <table style="border-collapse: collapse;" border="0" bordercolor="#006699" width="500">
            <tr>
              <td>Track Name</td>
              <td><input type="text" name="name"/>
                &nbsp;&nbsp;
                <input name="submit" type="submit" value="Search"/>
                &nbsp;&nbsp;
                <input name="button" type="button" onclick="javascript:newTrack()" value="New Track"/>
              </td>
            </tr>
          </table>
        </form>
      <table style="border-collapse: collapse;" border="1" bordercolor="#006699" width="500">
          <tr bgcolor="#FFE6C1">
            <th>Id</th>
            <th>Name</th>
            <th>Product</th>
            <th>Location</th>
            <th>Technology</th>
            <th>ClientOwner</th>
            <th>HourlyRate</th>
            <th></th>
          </tr>
          <c:if test="${empty SEARCH_TRACKS_RESULTS_KEY}">
            <tr>
              <td colspan="4">No Results found</td>
            </tr>
          </c:if>
          <c:if test="${! empty SEARCH_TRACKS_RESULTS_KEY}">
            <c:forEach var="track" items="${SEARCH_TRACKS_RESULTS_KEY}">
              <tr>
                <td><c:out value="${track.id}"></c:out></td>
                <td><c:out value="${track.name}"></c:out></td>
                <td><c:out value="${track.product}"></c:out></td>
                <td><c:out value="${track.location}"></c:out></td>
                 <td><c:out value="${track.technology}"></c:out></td>
                 <td><c:out value="${track.clientowner}"></c:out></td>
                 <td><c:out value="${track.hourlyrate}"></c:out></td>
                <td>&nbsp;<a href="updateTrack.do?id=${track.id}">Edit</a> &nbsp;&nbsp;<a href="javascript:deleteTrack('deleteTrack.do?id=${track.id}');">Delete</a> </td>
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