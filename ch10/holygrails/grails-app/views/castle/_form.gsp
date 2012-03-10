<%@ page import="mjg.Castle" %>



<div class="fieldcontain ${hasErrors(bean: castleInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="castle.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${castleInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: castleInstance, field: 'city', 'error')} required">
	<label for="city">
		<g:message code="castle.city.label" default="City" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="city" required="" value="${castleInstance?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: castleInstance, field: 'state', 'error')} required">
	<label for="state">
		<g:message code="castle.state.label" default="State" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="state" required="" value="${castleInstance?.state}"/>
</div>

<%--<div class="fieldcontain ${hasErrors(bean: castleInstance, field: 'latitude', 'error')} required">--%>
<%--	<label for="latitude">--%>
<%--		<g:message code="castle.latitude.label" default="Latitude" />--%>
<%--		<span class="required-indicator">*</span>--%>
<%--	</label>--%>
<%--	<g:field type="number" name="latitude" min="-90.0" max="90.0" required="" value="${fieldValue(bean: castleInstance, field: 'latitude')}"/>--%>
<%--</div>--%>
<%----%>
<%--<div class="fieldcontain ${hasErrors(bean: castleInstance, field: 'longitude', 'error')} required">--%>
<%--	<label for="longitude">--%>
<%--		<g:message code="castle.longitude.label" default="Longitude" />--%>
<%--		<span class="required-indicator">*</span>--%>
<%--	</label>--%>
<%--	<g:field type="number" name="longitude" required="" value="${fieldValue(bean: castleInstance, field: 'longitude')}"/>--%>
<%--</div>--%>
<%----%>
<div class="fieldcontain ${hasErrors(bean: castleInstance, field: 'knights', 'error')} ">
	<label for="knights">
		<g:message code="castle.knights.label" default="Knights" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${castleInstance?.knights?}" var="k">
    <li><g:link controller="knight" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="knight" action="create" params="['castle.id': castleInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'knight.label', default: 'Knight')])}</g:link>
</li>
</ul>

</div>

