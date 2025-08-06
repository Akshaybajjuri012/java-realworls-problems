<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head><title>Enrollment Form</title></head>
<body>
<h2>Enrollment Form</h2>

<form:form method="post" modelAttribute="student">

    First Name: <form:input path="firstName" />
    <form:errors path="firstName" cssClass="error"/><br>

    Last Name: <form:input path="lastName" />
    <form:errors path="lastName" cssClass="error"/><br>

    Gender:
    <form:radiobutton path="gender" value="Male"/> Male
    <form:radiobutton path="gender" value="Female"/> Female
    <form:errors path="gender" cssClass="error"/><br>

    Date of Birth: <form:input path="dob" />
    <form:errors path="dob" cssClass="error"/><br>

    Email: <form:input path="email" />
    <form:errors path="email" cssClass="error"/><br>

    Section:
    <form:select path="section">
        <form:option value="" label="--Select--" />
        <form:option value="Graduate" />
        <form:option value="Post Graduate" />
        <form:option value="Research" />
    </form:select>
    <form:errors path="section" cssClass="error"/><br>

    Country:
    <form:select path="country">
        <form:option value="" label="--Select--" />
        <form:option value="USA" />
        <form:option value="CANADA" />
        <form:option value="UK" />
    </form:select>
    <form:errors path="country" cssClass="error"/><br>

    First Attempt?
    <form:checkbox path="firstAttempt" /><br>

    Subjects:
    <form:checkbox path="subjects" value="Physics"/> Physics
    <form:checkbox path="subjects" value="Chemistry"/> Chemistry
    <form:checkbox path="subjects" value="Life Science"/> Life Science
    <form:checkbox path="subjects" value="Political Science"/> Political Science
    <form:errors path="subjects" cssClass="error"/><br>

    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
