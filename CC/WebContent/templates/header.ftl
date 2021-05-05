<!DOCTYPE HTML>
<html lang='de' dir='ltr'>
<head>
	<meta charset="utf-8" />
	<title>Collaborative Calendar - ${pagetitle}</title>
	<link type="text/css" href="css/style.css" rel="stylesheet" media="screen" />
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
  	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  	<script>
  		$(function() {
    		$( "#datepicker2" ).datepicker(
    		{
    			minDate:'today',
    			
    		});
 
  			$("#datepicker1").datepicker({
  				minDate:'today',
    			onSelect: function (dateValue, inst) {
        			$("#datepicker2").datepicker("option", "minDate", dateValue)
    			}
			});
		});
  	</script>
</head>
<body>
<div id="wrapper">
	<div id="logo">Collaborative Calendar<br>Software Engineering Example</div>
    <ul id="navigation">
    	<li><a href="index" title="Index">View Homesite</a></li>
	<#if navtype == "AccessGroup">
    	<li><a href="groupmembergui?page=defaultwebpage" title="AccessGroup">Access Group</a></li>	
	<#elseif navtype == "AddAppointment">
		<li><a href="staffmembergui?page=AddAppointment" title="AddAppointment">Add Appointment</a></li>
	<#elseif navtype == "Answerpageserv">
		<li><a href="Answerpageserv?page=Answer" title="Answerapp">Answer app</a></li>
	<#elseif navtype == "finalizeAppointment">
		<li><a href="finalize?page=finalizedappointment" title="finalizeAppointment">finalized appointment</a></li>
	<#else>
    	<li><a href="staffmembergui" title="Add Appointment">Add Appointment</a></li>
		<li><a href="groupmembergui" title="Access Group">Access Group</a></li>
		<li><a href="Answerpageserv" title="Answer app">Answer app</a></li>
		<li><a href="finalize" title="finalize Appointment">finalized appointment</a></li>
	</#if>
    </ul>
	<div id="content">