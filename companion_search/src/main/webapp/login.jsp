<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="login-form">
    <h2>Увійти</h2>
    <form method="post" action="user">
        <input type="hidden" name="action" value="login">
        <input type="email" name="email" placeholder="e-mail" required>
        <input type="password" name="password" placeholder="Ваш пароль" required>
        <input type="submit" value="Увійти">
    </form>
    <c:if test="${not empty param.error}">
        <p class="error">${param.error}</p>
    </c:if>
    <p>Не маєте акаунт? <a href="register.jsp">Реєстрація</a></p>
</div>
</body>
</html>
