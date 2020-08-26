<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>

<head>
    <title>Todo's for ${name}</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <table class="table table-striped">
        <caption style="caption-side:top;">Your TODOs</caption>
        <thead>
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Completed?</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.desc}</td>
                <td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
                <td>${todo.done}</td>
                <td><a type="button" class="btn btn-success" href="/update-todo?id=${todo.id}">Update</a></td>
                <td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td>
                <div><a class="button" href="/add-todo">Add a Todo</a></div>
            </td>
        </tr>
        </tfoot>
    </table>
</div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</body>

</html>
