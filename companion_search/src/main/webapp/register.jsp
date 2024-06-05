<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="css/register.css">
</head>
<body>
<div class="register-form">
    <h2>Реєстрація</h2>
    <form method="post" action="user">
        <input type="hidden" name="action" value="register">
        <input type="text" name="name" placeholder="Ім'я" required>
        <input type="text" name="surname" placeholder="Прізвище" required>
        <input type="email" name="email" placeholder="е-mail" required>
        <input type="password" name="password" placeholder="Пароль" required>
        <input type="text" name="phone" placeholder="Номер телефону" required>
        <input type="submit" value="Register">
    </form>
    <p>Є акаунт? <a href="login.jsp">Вхід</a></p>
</div>
</body>
</html>
