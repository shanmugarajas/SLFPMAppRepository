<%@include file="taglib_includes.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<script type="text/javascript" src="js/resources.js"></script>
<title>Reports Selector</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui-1.10.3.custom.js"></script>
<script src="js/jquery-ui-1.10.3.custom.min.js"></script>
<link rel="stylesheet" href="css/mm_restaurant1.css" type="text/css" />
<link rel="stylesheet" href="css/jquery-ui-1.9.2.custom.css" type="text/css" />
<link rel="stylesheet" href="css/jquery-ui-1.9.2.custom.min.css" type="text/css" />
<script>
  $(function() {
    $( "#menu" ).menu();
  });
</script>
<style>
  .ui-menu { width: 200px; }
</style>
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
      &nbsp;&nbsp;&nbsp; <a href="viewAllAllocations.do">ALLOCATIONS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="viewAllRequests.do">REQUESTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="createReport.do">REPORTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<c:url value='j_spring_security_logout'/>">Click here to logout</a></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
  <table>
  <ul id="menu">
  		<li><a href="createReport.do">Resources Report</a></li>
  		<li class="ui-state-disabled"><a href="createReport.do">Allocations Report</a></li>
  		<li class="ui-state-disabled"><a href="createReport.do">Requests Report</a></li>
	</ul>
  </table>	
  </tr>
</table>

</body>
</html>