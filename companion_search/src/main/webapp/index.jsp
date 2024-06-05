<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Document</title>
    <style>
    </style>
</head>
<body>
<div class="main-and-menu">
    <div class="navbar">
        <div class="logo">
            <a href="index.jsp"><img src="images/logo.png" alt="Logo"></a>
        </div>
        <div class="signin-btn">
            <c:choose>
                <c:when test="${not empty user}">
                    <a href="${pageContext.request.contextPath}/user">${user.name} ${user.surname}</a>
                    <a href="logout">Вийти</a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/login.jsp">Увійти</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <br><br><br>

    <div class="plain-text">
        <h1>Подорожуймо разом!</h1>
        <br><br>
        <div class="buttons">
            <a href="${pageContext.request.contextPath}/trip">
                <div class="find"><i class="fa fa-search"></i> Знайти поїздку</div>
            </a>
        </div>
    </div>
</div>
<div class="why-to-use">
    <br><br>
    <h1>Чому саме Travcomp?</h1>
    <div class="container">
        <ul class="custom-list">
            <li>Лідер пасажирських попутних перевезень в Україні та Європі</li>
            <li>Небайдужа адміністрація сайту</li>
            <li>Швидко, зрозуміло</li>
            <li>Безліч варіантів</li>
        </ul>
    </div>

</div>
<div class="icons">
    <div class="row">
        <div class="box">
            <i class="fa fa-sign-in"></i>
            <span>Зареєструйтесь / ввійдіть на наш сайт</span>
        </div>
        <div class="box">
            <i class="fa fa-list"></i>
            <span>Оберіть поїздку, якщо ви пасажир за початковою і кінцевою точкою</span>
        </div>
        <div class="box">
            <i class="fa fa-plus-circle"></i>
            <span>Створіть поїздку мрії, якщо ви водій</span>
        </div>
        <div class="box">
            <i class="fa fa-users"></i>
            <span>Розділяйте і володарюйте, заощаджуючи компанією!</span>
        </div>
    </div>
</div>
<div class="footer"></div>
</body>
</html>
