<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Trip</title>
    <link rel="stylesheet" href="css/create_trip.css">
</head>
<body>
<div class="create-trip">
    <h3>Cтворити нову поїздку</h3>
    <form action="trip" method="post">
        <input type="hidden" name="action" value="create">
        <label for="startLocation">Початкова точка:</label>
        <input type="text" id="startLocation" name="startLocation" required><br>
        <label for="endLocation">Кінцева точка:</label>
        <input type="text" id="endLocation" name="endLocation" required><br>
        <label for="dateTime">Дата + час:</label>
        <input type="datetime-local" id="dateTime" name="dateTime" required><br>
        <label for="carNumber">Номер машини:</label>
        <input type="text" id="carNumber" name="carNumber" required><br>
        <label for="availableSeats">К-сть місць:</label>
        <input type="number" id="availableSeats" name="availableSeats" min="1" required><br>
        <label for="cost">Вартість:</label>
        <input type="number" id="cost" name="cost" min="1" required><br>
        <input type="submit" value="Створити">
    </form>
</div>

</body>
</html>
