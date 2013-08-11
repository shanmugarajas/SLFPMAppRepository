<%@include file="taglib_includes.jsp" %>

<html>
<head>
	<script type="text/javascript" src="js/resources.js"></script>
	<title><spring:message code="App.Title"></spring:message> </title>
</head>
<body style="font-family: Arial; font-size:smaller;">

<table  bgcolor="lightblue" width="750" height="500" align="center" style="border-collapse: collapse;" border="1" bordercolor="#006699" >
	<tr>
		<td align="center"><h3>Add Resource</h3></td>
	</tr>
	<tr valign="top" align="center">
    <td align="center">
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
