<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div class="container mt-5">

    <a class="btn btn-outline-info ml-3" data-toggle="collapse" href="#bookingadd" role="button" aria-expanded="false"
       aria-controls="collapseAdd">
        Create Booking
    </a>

    <div class="collapse col-ml-3" id="bookingadd">
        <div class="form-group mt-3 ">
            <div class="form-row">
                <div class="form-group" style="width: 80%; margin-left: 2%">
                    <form method="post" action="/save-booking">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Start date</label>
                            <input type="date" class="form-control col-sm-4" name="startDate" required/>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">End date</label>
                            <input type="date" class="form-control col-sm-4" name="endDate" required/>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Client lastName</label>
                            <select name="clientId" class="form-control col-sm-4">
                                <option hidden>Select</option>
                                <c:forEach var="client" items="${clientList}">
                                    <option value="${client.getId()}">${client.getLastName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Room id</label>
                            <select name="roomId" class="form-control col-sm-4">
                                <option hidden></option>
                                <c:forEach var="room" items="${roomList}">
                                    <option value="${room.getId()}">${room.getId()}</option>
                                </c:forEach>
                            </select>
                        </div>
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
                <th>Id</th>
                <th>Start date</th>
                <th>End date</th>
                <th>Client last name</th>
                <th>Room id</th>
                <th style="width: 30%" colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="booking" items="${bookingList}" varStatus="rowCounter">
                <tr>
                    <td class="align-middle">${booking.getId()}</td>
                    <td class="align-middle">${booking.getStartDate()}</td>
                    <td class="align-middle">${booking.getEndDate()}</td>
                    <td class="align-middle">${booking.getClient().getLastName()}</td>
                    <td class="align-middle">${booking.getRoom().getId()}</td>
                    <td class="align-middle">
                        <form method="post" action="delete-booking/${booking.id}">
                            <button type="submit" class="btn btn-outline-danger">Delete</button>
                        </form>
                    </td>
                    <td class="align-middle">
                        <form method="post" action="/update-form-booking/${booking.id}">
                            <button type="submit" class="btn btn-outline-success">Edit</button>
                        </form>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
