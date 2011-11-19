<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="css/calendarview.css" />
		<style> 
      		body {
        		font-family: Trebuchet MS;
      		}
      		div.calendar {
        		max-width: 240px;
        		margin-left: auto;
        		margin-right: auto;
      		}
      		div.calendar table {
        		width: 100%;
      		}
      		div.dateField {
        		width: 140px;
        		padding: 6px;
        		-webkit-border-radius: 6px;
        		-moz-border-radius: 6px;
        		color: #555;
        		background-color: white;
        		margin-left: auto;
        		margin-right: auto;
        		text-align: center;
      		}
    	</style> 
    	
        <title>Groovy Baseball</title>
    </head>
    <body onload="initialize();" onunload="google.maps.Unload();">
    	<table>
    		<tr>
    			<td><a href="http://www.kousenit.com">
        			<img alt="Kousen IT logo" src="KousenIT_LoRes.jpg" 
        				align="middle" width="200px"/></a></td>
        		<td style="padding-left: 10px;">
        			<h1>Groovy Baseball</h1>
        			<h3>Select a date to see all games that day</h3>
        		</td>
    		</tr>
    	</table>
    	<hr style="color: red;" />
    	<p>Game data is available for seasons from 2005 to the present.</p>
    	<p>The baseball season runs from April to October each year.  
    	Preseason games are played in March, and the post-season, including
    	the World Series, often extends into November.</p>
    	<p>By default, the application starts with yesterday's games.</p>
       	<div id="map" style="width: 750px; height: 350px;"></div>
       	<table style="width: 600px;">
       		<tr>
       			<td style="width: 75%;">
       				<div id="output">Filling in game scores...</div>
	        		<div id="resultDiv"></div>
       			</td>
       			<td style="vertical-align: top; padding-top: 50px;">
       				<div style="background-color: #efefef; padding: 10px; 
        				-webkit-border-radius: 12px; 
        				-moz-border-radius: 12px; width: 200px;">
        				<form action="/" onsubmit="plotResults(); return false;">
       						<label for="date2">Date</label>
           					<input type="text" id="date2" name="date2" 
           						disabled="disabled" class="dateField"
           						onchange="plotResults();" />
       					</form>
        				<div id="calendar"></div>
       				</div>
       			</td>
       		</tr>
       	</table>
       	<script type="text/javascript" src="https://www.google.com/jsapi?key=ABQIAAAAF0RqRyWNd_7X3e0RobCNCBTwM0brOpm-All5BF6PoaKBxRWWERRUp8BqaOUOl7m4T_bw9zBspjgKPw"></script>
        <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
        <script type="text/javascript">
            google.load("prototype", "1.6.0.3");
        </script>
        <script type="text/javascript" src="js/calendarview.js"></script>
        <script type="text/javascript">
            var map;
            var markersArray = [];
            var results = "";
 
            // Call this function when the page has been loaded
            function initialize() {
            	var myOptions = {
            	    zoom: 4,
            	    center: new google.maps.LatLng(39.8333, -98.5833),
            	    zoomControl: true,
            	    scaleControl: true,
            	    mapTypeId: google.maps.MapTypeId.ROADMAP
            	};
            	
                map = new google.maps.Map($("map"), myOptions);
                Calendar.setup( {dateField: 'date2',parentElement: 'calendar'} );
                var today = new Date();
                $('date2').value = today.getFullYear() + "-" +
                    (today.getMonth() + 1) + "-" + (today.getDate() - 1);
                plotResults();
            }

            function plotResults() {
                results = "";
                var dateString = $F("date2");
                var fields = dateString.split("-");
                var date = new Date(fields[0],fields[1]-1,fields[2]);
                var day = date.getDate();
                var month = date.getMonth()+1;
                var year = date.getFullYear();

                new Ajax.Request('GamesService.groovy',{
                    method: 'get',
                    parameters: {year:year,
                        month:month,
                        day:day},
                    onSuccess: function(xhr) {
                        var output = $('output');
                        var resp = xhr.responseXML.getElementsByTagName('game');
                        clearMarkers();
                        markersArray = new Array();
                        for (var i = 0; i < resp.length; i++) {
                            var game = resp[i];
                            addMarker(game);
                        }
                        output.update("<h2>Games for " + date.toDateString() +"</h2>");
                        $('resultDiv').innerHTML = "<table border='1'>" + results + "</table>";
                    }
                });

                function addMarker(game) {
                    var outcome = game.attributes.getNamedItem('outcome').value;
                    var lat = game.attributes.getNamedItem('lat').value;
                    var lng = game.attributes.getNamedItem('lng').value;
                    var point = new google.maps.LatLng(lat,lng);
                    var marker = new google.maps.Marker({
                    	position: point,
                    	map: map,
                    	title: outcome
                    });
                    markersArray.push(marker);
                    results += "<tr><td>" + outcome + "</td></tr>";
                }
                
                function clearMarkers() {
                	if (markersArray.length > 0) {
                		for (i in markersArray) {
                			marker = markersArray.shift();
                			marker.setMap(null);
                			marker = null;
                		}
                	}
                }
            }
        </script>
    </body>
</html>
