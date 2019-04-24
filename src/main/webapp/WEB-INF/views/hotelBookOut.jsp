<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
    <form class="mt-3">
        <table class="table table-bordered text-center">
            <thead>
            <tr>
                <th style="width: 2%">Id</th>
                <th style="width: 13%">Room number</th>
                <th style="width: 14%">Count places</th>
                <th style="width: 20%">Hotel</th>
                <th style="width: 20%">Room type</th>
                <th style="width: 20%" colspan="2">Action</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="room" items="${roomList}" varStatus="rowCounter">
                <tr>
                    <td class="align-middle">${room.getId()}</td>
                    <td class="align-middle">${room.getRoomNumber()}</td>
                    <td class="align-middle">${room.getNumberOfPlaces()}</td>
                    <td class="align-middle">${room.hotel.getHotelName()}</td>
                    <td class="align-middle">${room.roomType.getType()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
