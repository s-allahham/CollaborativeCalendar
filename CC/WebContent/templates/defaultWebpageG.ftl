<#include "header.ftl">

<b>Welcome to our little demonstration on the CC Webapp</b><br><br>

<form method="POST" action="groupmembergui?action=AccessGroup">
	<fieldset id="AccessGroup">
		<legend>Required Information</legend>

		<div>
			<label>Enter your Name</label>
			<input type="text" name="memberslist" id="memberslist">
	    </div>
	    
	</fieldset>
	<button type="submit" id="Submit" name="Submit" value="Submit">Submit!</button>
</form>
<#include "footer.ftl">




