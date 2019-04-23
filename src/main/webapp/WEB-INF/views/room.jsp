<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<div class="container mt-5">

    <a class="btn btn-outline-info ml-3" data-toggle="collapse" href="#roomadd" role="button" aria-expanded="false"
       aria-controls="collapseAdd">
        Create Room
    </a>

    <div class="collapse col-ml-3" id="roomadd">
        <div class="form-group mt-3 ">
            <div class="form-row">
                <div class="form-group" style="width: 80%; margin-left: 2%">
                    <form method="post" action="/room-save">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Room number</label>
                            <input type="text" class="form-control col-sm-4" name="roomNumber"/>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Count of places</label>
                            <input type="text" class="form-control col-sm-4" name="numberOfPlaces"/>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Hotel name</label>
                            <input type="text" class="form-control col-sm-4" name="hotel"
                                   value="${hotel.hotelName}" readonly/>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Room type</label>
                            <select name="roomType" class="form-control col-sm-4">
                                <option hidden>Select</option>
                                <c:forEach var="type" items="${typesList}">
                                    <option value="${type.getType()}">${type.getType()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <input hidden value="${hotel.getId()}" name="hotelId">
                        <div class="form-group row text-right">
                            <button class="btn btn-outline-info col-sm-4" style="margin-left: 16.7%" type="submit"
                                    name="update">
                                Add
                            </button>
                        </div>
                    </form>
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
                        <div class="row">
                            <div class="col align-middle">
                                <form method="post" action="/delete/${room.id}">
                                    <input hidden value="${room.hotel.getId()}" name="hotelId">
                                    <button type="submit" class="btn btn-outline-danger">Delete</button>
                                </form>
                            </div>
                            <div class="col align-middle">
                                <form method="post" action="/update-room/${room.id}">
                                    <button type="submit" class="btn btn-outline-success">Edit</button>
                                </form>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
