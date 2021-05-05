<#include "header.ftl">

<b>Welcome to our little demonstration on the CC Webapp</b>

<table id="Group">
	<tr> 
		
		<th>Group Name</th>
		<th>Member Name</th>
	</tr>
	<#list Calendar as c>
	<tr>
		
		<td>${c.name}</td>
		<td>${c.memberslist}</td>
	</tr>
	</#list>
</table>
<#include "footer.ftl">