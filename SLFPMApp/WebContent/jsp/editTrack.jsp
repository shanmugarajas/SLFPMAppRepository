<%@include file="taglib_includes.jsp" %>

<html>
<head>
	<script type="text/javascript" src="js/resources.js"></script>
	<title><spring:message code="App.Title"></spring:message> </title>
</head>
<body style="font-family: Arial; font-size:smaller;">

<table  bgcolor="lightblue" width="750" height="500" align="center" style="border-collapse: collapse;" border="1" bordercolor="#006699" >
	<tr>
		<td align="center"><h3>Edit Track</h3></td>
	</tr>
  <tr valign="top" align="center">
    <td align="center">
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
