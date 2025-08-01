<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>User Registration Form</title>
    <style>
        h2 {
            text-align: center;
        }

        .center-table {
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>
    <h2>User Registration</h2>
    <form action="RegisterServlet" method="post">
        <table class="center-table">
            <tr><td>Full name:</td><td><input type="text" name="fullname" /></td></tr>
            <tr><td>E-mail:</td><td><input type="email" name="email" /></td></tr>
            <tr><td>Password:</td><td><input type="password" name="password" /></td></tr>
            <tr><td>Birthday (yyyy-mm-dd):</td><td><input type="date" name="birthday" /></td></tr>
            <tr><td>Gender:</td>
                <td>
                  <input type="radio" name="gender" value="Male" />Male
                    <input type="radio" name="gender" value="Female" />Female
                </td>
            </tr>
            <tr><td>Profession:</td>
                <td>
                    <select name="profession">
                        <option>Developer</option>
                        <option>Designer</option>
                        <option>Manager</option>
                    </select>
                </td>
            </tr>
            <tr><td>Married?</td><td><input type="checkbox" name="married" /></td></tr>
            <tr><td>Note:</td><td><textarea name="note"></textarea></td></tr>
            <tr><td colspan="2" align="center"><input type="submit" value="Register" /></td></tr>
        </table>
         </form>
</body>
</html>