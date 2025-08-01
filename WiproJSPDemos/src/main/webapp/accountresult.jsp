<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bank.AccountBean" %>
<%
    AccountBean acc = new AccountBean();
    acc.setAccountNo(request.getParameter("accountNo"));
    acc.setName(request.getParameter("name"));
    acc.setBalance(Double.parseDouble(request.getParameter("balance")));
    session.setAttribute("type", request.getParameter("type"));
    request.setAttribute("account", acc);
%>
<html>
<head><title>Account Summary</title></head>
<body>
    <h2>Account Summary</h2>
    Account No: ${account.accountNo}<br/>
    Name: ${account.name}<br/>
    Balance: ${account.balance}<br/>
    Account Type (from session): ${sessionScope.type}<br/>

    <p>
        Balance Status:
        ${account.balance >= 1000 ? "Sufficient" : "Insufficient"}
    </p>
</body>
</html>