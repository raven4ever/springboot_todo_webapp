<html>

<head>
    <title>Please log in!</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<h2>Hi there!</h2>

<span style="color: red;">${errorMessage}</span>

<form method="post">
    Name: <input type="text" name="name"/> <br/>
    Password: <input type="password" name="password" /> <br/>
    <input type="submit"/>
</form>

</body>

</html>
