<%@include file="taglib_includes.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Resources View</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sun, 13 Oct 2013 00:00:00 GMT">
<script src="../../../../../SLFPMApp/js/jquery-1.9.1.js"></script>
<script src="../../../../../SLFPMApp/js/resources.js"></script>
<script src="../../../../../SLFPMApp/js/jquery-ui-1.10.3.custom.js"></script>
<script src="../../../../../SLFPMApp/js/jquery-ui-1.10.3.custom.min.js"></script>
<link rel="stylesheet" href="../../../../../SLFPMApp/css/mm_restaurant1.css" type="text/css" />
<%
int totalPages=0;
int pageNumber=0;
String nextPage = "";
String prevPage = "";

if(request.getParameter("page") != null) {
session.setAttribute("page", request.getParameter("page"));
pageNumber = Integer.parseInt(request.getParameter("page"));
} else {
session.setAttribute("page", "1");
}
nextPage = (pageNumber +1) + "";
prevPage = (pageNumber -1) + "";
String myUrl = "viewAllAllocations.do?page=" + nextPage;
pageContext.setAttribute("myUrl", myUrl);
%>
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
  <td height="36" colspan="2" id="navigation" nowrap="nowrap" class="navText"><a href="${pageContext.request.contextPath}/connect/facebook.do">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/connect/viewAllAllocations.do">ALLOCATIONS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/viewAllTracks.do">TRACKS</a>&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/viewAllRequests.do">REQUESTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/createReport.do">REPORTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/j_spring_security_logout">Click here to logout</a></td>
    <td>&nbsp;</td>
  </tr>
  <tr bgcolor="#ffffff">
    <td width="15" height="230" valign="top"><img src="images/mm_spacer.gif" alt="" width="15" height="1" border="0" /></td>
    
    <td width="710" valign="top" halign="left"><br />
        <form action="searchResources.do" method="post">
          <table style="border-collapse: collapse;" border="0" bordercolor="#006699" width="710">
            <tr width="710">
              <td>Resource Name</td>
              <td><input type="text" name="name"/>
                &nbsp;&nbsp;
                <input name="submit" type="submit" value="Search"/>
                &nbsp;&nbsp;
                <input name="button" type="button" onclick="javascript:newResource()" value="New Resource"/>
              </td>
              <td colspan="1"></td>
				<td colspan="2">
					<%
					pageNumber = Integer.parseInt(session.getAttribute("page").toString());
					System.out.println("Current page number: " + pageNumber);
					if (pageNumber > 1)
					{
					prevPage = (pageNumber -1) + "";
					myUrl = "viewAllResources.do?page=" + prevPage;
					pageContext.setAttribute("myUrl", myUrl);
					%>
					<a href="${pageScope.myUrl}">Prev Page</a>
					<%
					}
					%>	
					
				</td>
				<td colspan = "1">Page <%=Integer.parseInt(session.getAttribute("page").toString())%> of ${NUM_PAGES}</td>
				<td colspan="2">
					<c:set var="numPages" value="${NUM_PAGES}"></c:set>
					<%
					pageNumber = Integer.parseInt(session.getAttribute("page").toString());
					totalPages = Integer.parseInt(pageContext.getAttribute("numPages").toString());
					System.out.println("Total pages: " + totalPages);
					if (pageNumber < totalPages)
					{
					pageNumber = Integer.parseInt(session.getAttribute("page").toString());
					nextPage = (pageNumber +1) + "";
					myUrl = "viewAllResources.do?page=" + nextPage;
					pageContext.setAttribute("myUrl", myUrl);
					%>
					<a href="${pageScope.myUrl}">Next Page</a>
					<%
					}
					%>
				</td>
            </tr>
          </table>
        </form>
      <table style="border-collapse: collapse;" align="left" border="1" bordercolor="#006699" width="500">
          <tr bgcolor="E0E0D1">
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
