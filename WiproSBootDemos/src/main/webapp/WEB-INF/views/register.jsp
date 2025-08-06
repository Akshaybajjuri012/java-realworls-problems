<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
    <h2>Spring MVC Form Demo - Registration</h2>

    <form:form method="POST" modelAttribute="user" action="/register">
        <p>User Name: <form:input path="userName" /></p>
        <p>Password: <form:password path="password" /></p>
        <p>E-mail: <form:input path="email" /></p>
        <p>Birthday (mm/dd/yyyy): <form:input path="birthday" /></p>
        <p>Profession: 
            <form:select path="profession">
                <form:option value="Developer" label="Developer" />
                <form:option value="Designer" label="Designer" />
                <form:option value="Tester" label="Tester" />
            </form:select>
        </p>
        <input type="submit" value="Register" />
    </form:form>
</body>
</html>
