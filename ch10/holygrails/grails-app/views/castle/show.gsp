
<%@ page import="mjg.Castle" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'castle.label', default: 'Castle')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-castle" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-castle" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list castle">
			
				<g:if test="${castleInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="castle.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${castleInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${castleInstance?.city}">
				<li class="fieldcontain">
					<span id="city-label" class="property-label"><g:message code="castle.city.label" default="City" /></span>
					
						<span class="property-value" aria-labelledby="city-label"><g:fieldValue bean="${castleInstance}" field="city"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${castleInstance?.state}">
				<li class="fieldcontain">
					<span id="state-label" class="property-label"><g:message code="castle.state.label" default="State" /></span>
					
						<span class="property-value" aria-labelledby="state-label"><g:fieldValue bean="${castleInstance}" field="state"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${castleInstance?.latitude}">
				<li class="fieldcontain">
					<span id="latitude-label" class="property-label"><g:message code="castle.latitude.label" default="Latitude" /></span>
					
						<span class="property-value" aria-labelledby="latitude-label"><g:fieldValue bean="${castleInstance}" field="latitude"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${castleInstance?.longitude}">
				<li class="fieldcontain">
					<span id="longitude-label" class="property-label"><g:message code="castle.longitude.label" default="Longitude" /></span>
					
						<span class="property-value" aria-labelledby="longitude-label"><g:fieldValue bean="${castleInstance}" field="longitude"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${castleInstance?.knights}">
				<li class="fieldcontain">
					<span id="knights-label" class="property-label"><g:message code="castle.knights.label" default="Knights" /></span>
					
						<g:each in="${castleInstance.knights}" var="k">
						<span class="property-value" aria-labelledby="knights-label"><g:link controller="knight" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${castleInstance?.id}" />
					<g:link class="edit" action="edit" id="${castleInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
