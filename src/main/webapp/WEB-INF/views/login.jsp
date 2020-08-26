<%@ include file="common/tags.jspf" %>

<html>
<head>
    <title>Please log in!</title>
    <%@ include file="common/csss.jspf" %>
</head>

<body>
<h2>Hi there!</h2>

<span style="color: red;">${errorMessage}</span>

<form method="post">
    Name: <input type="text" name="name"/> <br/>
    Password: <input type="password" name="password"/> <br/>
    <input type="submit"/>
</form>

</body>

</html>
