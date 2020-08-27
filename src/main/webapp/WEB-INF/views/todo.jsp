<%@ include file="common/tags.jspf" %>

<html>
<head>
    <title>TODO</title>
    <%@ include file="common/csss.jspf" %>
</head>

<body>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <form:form method="post" modelAttribute="todo">
        <form:hidden path="id"/>
        <fieldset class="form-group">
            <form:label path="desc">Description</form:label>
            <form:input path="desc" type="text" class="form-control" required="required"/>
            <form:errors path="desc" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="targetDate">Target Date</form:label>
            <form:input path="targetDate" type="text" class="form-control" required="required"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>

        <c:choose>
            <c:when test="${isAddAction}">
                <button type="submit" class="btn btn-success">Add</button>
            </c:when>
            <c:otherwise>
                <fieldset class="form-group">
                    <form:label path="done">Is Completed?</form:label>
                    <form:checkbox path="done"/>
                </fieldset>

                <button type="submit" class="btn btn-success">Update</button>
            </c:otherwise>
        </c:choose>
    </form:form>
</div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script>
    $('#targetDate').datepicker({
        format: 'dd/mm/yyyy'
    });
</script>
</body>

</html>
