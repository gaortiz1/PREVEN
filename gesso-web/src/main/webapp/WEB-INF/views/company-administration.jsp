<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
	<form:form class="form-search-company" role="form">
		
	
		<table id="tableCompanies" class="table table-striped table-bordered table-hover">
                  <thead>
                      <tr>
                          <th><spring:message code="page.label.company.nombreComercial"/> </th>
                          <th><spring:message code="page.label.cuidad"/></th>
                          <th><spring:message code="page.label.company.type.company"/></th>
                          <th><spring:message code="page.label.company.sector.productor"/></th>
                          <th><spring:message code="gobal.label.edit"/></th>
                      </tr>
                  </thead>
                  <tbody>
                      <c:forEach items="${companies}" var="company">
                          <tr>
                              <td>${company.name}</td>
                              <td>${company.geopoliticalDivision.name}</td>
                              <td>${company.typeCompany.name}</td>
                              <td>${company.catalogSectorProductivo.name}</td>
                              <td>
							<a href="#/edit-company/${company.id}" role="button" class="blue"> Edit </a>
                              </td>
                          </tr>
                      </c:forEach>
                  </tbody>
              </table>
	</form:form>
	</div><!-- PAGE CONTENT ENDS -->							
</div><!-- /.col -->
					