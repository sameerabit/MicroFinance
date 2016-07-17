<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form:form method="post" action="item/add" commandName="item" rolle="form">

    <form:label path="name"></form:label>
    <form:input path="name"></form:input>

    <div class="form-group">
        <form:select path="user.id">
            <form:option value="" label="- Select -"/>
            <form:options items="${users}" itemValue="id" itemLabel="email" />
        </form:select>
    </div>

    <button name="add" value="Add">Add</button>

</form:form>
