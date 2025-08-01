<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>User Information</title>
</head>
<body>
    <h2>User Information</h2>
    <form action="UserServlet" method="post">
        <table>
            <tr><td>User Name</td><td><input type="text" name="username"/></td></tr>
            <tr><td>Password</td><td><input type="password" name="password"/></td></tr>
            <tr><td>Address</td><td><textarea name="address"></textarea></td></tr>
            <tr><td>Subscribe Newsletter</td><td><input type="checkbox" name="subscribe"/></td></tr>
            <tr>
                <td>Favorite Web Frameworks</td>
                <td>
                    <input type="checkbox" name="framework" value="Spring MVC"/>Spring MVC
                    <input type="checkbox" name="framework" value="Struts 1"/>Struts 1
                    <input type="checkbox" name="framework" value="Struts 2"/>Struts 2
                    <input type="checkbox" name="framework" value="Apache Wicket"/>Apache Wicket
                </td>
            </tr>
            <tr>
                <td>Gender</td>
                <td>
                    <input type="radio" name="gender" value="Male"/>Male
                    <input type="radio" name="gender" value="Female"/>Female
                </td>
            </tr>
            <tr>
                <td>Favorite Number</td>
                <td>
                    <input type="radio" name="favnum" value="0"/>0
                    <input type="radio" name="favnum" value="1"/>1
                    <input type="radio" name="favnum" value="2"/>2
                    <input type="radio" name="favnum" value="3"/>3
                    <input type="radio" name="favnum" value="4"/>4
                </td>
            </tr>
            <tr><td colspan="2"><input type="submit" value="Submit"/></td></tr>
        </table>
    </form>
</body>
</html>
