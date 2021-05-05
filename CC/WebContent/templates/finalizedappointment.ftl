<#include "header.ftl">

<b>Welcome to our little demonstration on the CC Webapp</b>
<p><i>this is the list of the available appointments for participation</i></p>
<table id="FinalizedAppointment">
	<tr> 
		
		<th>name</th>
		<th>start time</th>
		<th>end time</th>
		<th>description</th>
		<th>street</th>
		<th>town</th>
		<th>participants</th>
		<th>deadline of participation</th>
	</tr>
	<#list Fappointments as fap>
	<tr>
		
		<td>${fap.name}</td>
		<td>${fap.startTime}</td>
		<td>${fap.endTime}</td>
		<td>${fap.description}</td>
		<td>${fap.street}</td>
		<td>${fap.town}</td>
		<td>${fap.participants}</td>
		<td>${fap.deadline}</td>
	</tr>
	
	
	</#list>
</table>

<#include "footer.ftl">