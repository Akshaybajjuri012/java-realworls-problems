<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Result</title></head>
<body>
    <h2>Congratulations, ${name}!</h2>
    <p>You passed with ${marks} marks.</p>

    <jsp:include page="footer.jsp" />
</body>
</html>