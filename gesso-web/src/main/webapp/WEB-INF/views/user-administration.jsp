<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:template>
	<jsp:attribute name="body">
		<form:form class="form-horizontal" role="form">

			<table id="membersTable" class="table table-striped table-bordered table-hover">
				<thead>
				<tr>
					<th><spring:message code="page.label.username"/> </th>
					<th><spring:message code="page.label.firstName"/></th>
					<th><spring:message code="page.label.lastName"/></th>
					<th><spring:message code="page.label.dateofbirth"/></th>
					<th><spring:message code="gobal.label.edit"/></th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${members}" var="member">
					<tr>
						<td>${member.usrNickName}</td>
						<td>${member.person.firstName}</td>
						<td>${member.person.lastName}</td>
						<td>${member.person.dateOfBirth}</td>
						<td>
							<a href="#modal-form" role="button" class="blue" onclick="editarUsuario(${member.usrId})"> Editar </a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</form:form>
	</jsp:attribute>
</t:template>