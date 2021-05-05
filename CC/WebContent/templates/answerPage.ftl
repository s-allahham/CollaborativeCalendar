<#include "header.ftl">

<b>Welcome to our little demonstration on the CC Webapp</b>
<p><i>this is the list of the available appointments for participation</i></p>
<form method="POST" action="Answerpageserv?action=participate">
<table id="Appointment">
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
	<#list appointments as ap>
	<tr>
		
		<td>${ap.name}</td>
		<td>${ap.startTime}</td>
		<td>${ap.endTime}</td>
		<td>${ap.description}</td>
		<td>${ap.street}</td>
		<td>${ap.town}</td>
		<td>${ap.participants}</td>
		<td>${ap.deadline}</td>
	</tr>
	
	
	</#list>
</table>

		<div>
			<label>choose an Appointmnet's name </label>
			<input type="text" name="name" id="name">
	    </div>
<button type="submit" id="Submit" name="Submit" value="Submit">participation</button>
<#include "footer.ftl">