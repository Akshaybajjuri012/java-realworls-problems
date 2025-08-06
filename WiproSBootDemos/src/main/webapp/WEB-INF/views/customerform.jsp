<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Customer Save Page</title>
</head>
<body>
    <h2>Customer Save Form</h2>

    <form:form method="POST" modelAttribute="customer" action="/customer/save">

        Name: <form:input path="name" />
        <form:errors path="name" /><br><br>

        Email: <form:input path="email" />
        <form:errors path="email" /><br><br>

        Age: <form:input path="age" />
        <form:errors path="age" /><br><br>

        Gender:
        <form:radiobutton path="gender" value="Male"/> Male
        <form:radiobutton path="gender" value="Female"/> Female
        <form:errors path="gender" /><br><br>

        Birthday: <form:input path="birthday" />
        <form:errors path="birthday" /><br><br>

        Phone: <form:input path="phone" />
        <form:errors path="phone" /><br><br>

        <input type="submit" value="Save Customer"/>
    </form:form>
</body>
</html>
