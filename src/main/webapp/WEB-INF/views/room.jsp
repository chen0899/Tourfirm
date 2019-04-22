<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<div class="container mt-5">

    <a class="btn btn-outline-info ml-3" data-toggle="collapse" href="#roomadd" role="button" aria-expanded="false"
       aria-controls="collapseAdd">
        Create Room
    </a>

    <div class="collapse ml-3" id="roomadd">
        <div class="form-group mt-3 ">
            <div class="form-row">
                <div class="form-group">
                    <form:form action="room" modelAttribute="dispatcher" >
                        <span>
                            <input type="text" name="roomNumber" placeholder="Number of room">
                            <input type="text" name="countPlace" placeholder="Count places">
                            <input type="text" name="hotelName" placeholder="Hotel">
                            <input type="text" name="roomType" placeholder="Room type">
                        <input type="submit" class="btn btn-outline-info ml-2" value="ADD"/>
                        </span>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

    <form class="mt-3">
        <table class="table table-bordered text-center">
            <thead>
            <tr>
                <th style="width: 2%">Id</th>
                <th style="width: 13%">Room number</th>
                <th style="width: 14%">Count places</th>
                <th style="width: 20%">Hotel</th>
                <th style="width: 20%">Room type</th>
                <th style="width: 20%">Action</th>
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
                    <td class="align-middle">
                        <a href="/room/${room.id}" class="btn btn-outline-success">Edit</a>
                        <a href="/room/delete/${room.id}" class="btn btn-outline-danger" class="ml-3">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>