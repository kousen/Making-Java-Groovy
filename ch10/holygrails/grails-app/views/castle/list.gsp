
<%@ page import="mjg.Castle" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'castle.label', default: 'Castle')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<gvisualization:apiImport />
	</head>
	<body>
		<a href="#list-castle" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<gvisualization:map elementId="map" 
		  columns="${mapColumns}"  data="${mapData}" showTip="${true}"/>
        <div id="map" style="width: 100%;"></div>
		<div id="list-castle" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'castle.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="city" title="${message(code: 'castle.city.label', default: 'City')}" />
					
						<g:sortableColumn property="state" title="${message(code: 'castle.state.label', default: 'State')}" />
					
						<g:sortableColumn property="latitude" title="${message(code: 'castle.latitude.label', default: 'Latitude')}" />
					
						<g:sortableColumn property="longitude" title="${message(code: 'castle.longitude.label', default: 'Longitude')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${castleInstanceList}" status="i" var="castleInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${castleInstance.id}">${fieldValue(bean: castleInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: castleInstance, field: "city")}</td>
					
						<td>${fieldValue(bean: castleInstance, field: "state")}</td>
					
						<td>${fieldValue(bean: castleInstance, field: "latitude")}</td>
					
						<td>${fieldValue(bean: castleInstance, field: "longitude")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${castleInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
