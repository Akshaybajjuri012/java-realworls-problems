<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Bank Account Form</title></head>
<body>
    <h2>Enter Bank Account Details</h2>
    <form action="accountresult.jsp" method="post">
        Account No: <input type="text" name="accountNo" /><br/>
        Name: <input type="text" name="name" /><br/>
        Balance: <input type="text" name="balance" /><br/>
        Account Type: <input type="text" name="type" /><br/>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>