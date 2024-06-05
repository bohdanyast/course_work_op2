<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
    <link rel="stylesheet" href="css/user.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
</div>
<br><br>
<div class="user-info">
    <div class="info">
        <p><strong>${user.name} ${user.surname}'s</strong> info:</p>
        <p><strong>e-mail:</strong> ${user.email}</p>
        <p><strong>Телефон:</strong> ${user.phone}</p>
        <button><a href="create_trip.jsp">+ Нова подорож</a></button>
    </div>
</div>


<div class="user-trips">
    <h2 align="center">Ваші подорожі</h2>
    <c:forEach items="${trips}" var="trip">
        <div class="trip-container">
            <div class="trip-details">
                <h3>${trip.dateTime}</h3>
                <h3>${trip.driver.name} ${trip.driver.surname}</h3>
            </div>
            <div class="trip-details">
                <div class="start-end">
                    <span>${trip.startLocation}</span>
                </div>
                <div class="start-end">
                    <span class="arrow">&#8595;</span>
                </div>
                <div class="start-end">
                    <span>${trip.endLocation}</span>
                </div>
            </div>
            <div class="trip-details">
                <h3>${trip.carNumber}</h3>
                <h3>₴${trip.cost} | Місць: ${trip.availableSeats}</h3>
            </div>
            <div>
                <a style="text-decoration: none; color: white"
                   href="${pageContext.request.contextPath}/trip?action=update&id=${trip.id}">
                    <i class="fa fa-pencil" style="font-size:24px; color: dodgerblue"></i>
                </a>
                <a style="text-decoration: none; color: white"
                   href="${pageContext.request.contextPath}/trip?action=delete&id=${trip.id}">
                    <i class="fa fa-times" style="font-size:24px; color: red"></i>
                </a>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
