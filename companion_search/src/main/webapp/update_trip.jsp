<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Trip</title>
    <link rel="stylesheet" href="css/update_trip.css">
</head>
<body>
<div class="update-trip">
    <h3>Оновити інформацію</h3>
    <form action="${pageContext.request.contextPath}/trip" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${trip.id}">
        <div>
            <label for="startLocation">Початкова точка:</label>
            <input type="text" id="startLocation" name="startLocation" value="${trip.startLocation}" required>
        </div>
        <div>
            <label for="endLocation">Кінцева точка:</label>
            <input type="text" id="endLocation" name="endLocation" value="${trip.endLocation}" required>
        </div>
        <div>
            <label for="dateTime">Дата + час:</label>
            <input type="datetime-local" id="dateTime" name="dateTime" value="${trip.dateTime.replace(' ', 'T')}" required>
        </div>
        <div>
            <label for="carNumber">Номер авто:</label>
            <input type="number" id="carNumber" name="carNumber" value="${trip.carNumber}" required>
        </div>
        <div>
            <label for="availableSeats">К-сть вільних місць:</label>
            <input type="number" id="availableSeats" name="availableSeats" value="${trip.availableSeats}" required>
        </div>
        <div>
            <label for="cost">Вартість:</label>
            <input type="number" id="cost" name="cost" value="${trip.cost}" required>
        </div>
        <div>
            <input type="submit" value="Оновити">
        </div>
    </form>
</div>
</body>
</html>
