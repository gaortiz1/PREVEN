<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
     
 
 
<h2>Person Manager</h2>
<form:form method="post" action="newPerson" >
 
    <table>
    <tbody><tr>
        <td><form:label path="firstname">First Name</form:label></td>
        <td><form:input path="firstname"></form:input></td> 
    </tr>
    <tr>
        <td><form:label path="lastname">Last Name</form:label></td>
        <td><form:input path="lastname"></form:input></td>
    </tr>
    <tr>
        <td><form:label path="lastname">Email</form:label></td>
        <td><form:input path="email"></form:input></td>
    </tr>
    <tr>
        <td><form:label path="lastname">Telephone</form:label></td>
        <td><form:input path="telephone"></form:input></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Add Contact">
        </td>
    </tr>
</tbody></table>    
     
</form:form>