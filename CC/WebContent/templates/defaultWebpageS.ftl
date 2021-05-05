<#include "header.ftl">

<b>Welcome to our little demonstration on the CC Webapp</b><br><br>

<form method="POST" action="staffmembergui?action=AddAppointment">
	<fieldset id="AddAppointment">
		<legend>Required Information</legend>
		<div>
			<label>name</label>
			<input type="text" name="name"required>
	    </div>
	    
		<div>
			<label>Start Time</label>
			<input type="text" name="startTime" id="datepicker1"required>
	    </div>

		<div>
			<label>End Time</label>
			<input type="text" name="endTime" id="datepicker2"required>
	    </div>
	    
         <div>
			<label>description</label>
			<input type="text" name="description"required>
	    </div>
		
		<div>
			<label>Street</label>
			<input type="text" name="street"required>
	    </div>
	    
	    <div>
			<label>Town</label>
			<input type="text" name="town"required>
	    </div>

	</fieldset>
	<button type="submit" id="submit">Submit</button>
</form>
<#include "footer.ftl">