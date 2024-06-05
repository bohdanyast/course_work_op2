<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Trips</title>
</head>
<link rel="stylesheet" href="css/trips.css">
<link rel="stylesheet" href="css/style.css">
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
    <div class="search-form">
        <h1>Всі наявні поїздки</h1>
        <form method="get" action="trip">
            <input type="text" name="startLocation" placeholder="Початкова точка">
            <input type="text" name="endLocation" placeholder="Кінцева точка">
            <input type="submit" value="Пошук">
        </form>
    </div>
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
        </div>
    </c:forEach>

</body>
</html>
