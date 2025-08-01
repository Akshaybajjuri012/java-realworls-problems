<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head><title>No JSTL</title></head>
<body>
    <h3>Your Selected Frameworks:</h3>
    <ul>
        <%
            java.util.List<String> frameworks = (java.util.List<String>) request.getAttribute("frameworks");
            if (frameworks != null) {
                for (String fw : frameworks) {
        %>
                    <li><%= fw %></li>
        <%
                }
            } else {
        %>
         <li>No frameworks selected.</li>
        <%
            }
        %>
    </ul>
</body>
</html>