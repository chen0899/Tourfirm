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
                            <label class="col-sm-2 col-form-label">Client id</label>
                            <input type="text" class="form-control col-sm-4" name="clientId" required/>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Room id</label>
                            <input type="text" class="form-control col-sm-4" name="roomId" required/>
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
                <th>Client id</th>
                <th>Room id</th>
                <th style="width: 30%" colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="booking" items="${bookingList}" varStatus="rowCounter">
                <tr>
                    <td>${booking.getId()}</td>
                    <td>${booking.getStartDate()}</td>
                    <td>${booking.getEndDate()}</td>
                    <td>${booking.getClient().getId()}</td>
                    <td>${booking.getRoom().getId()}</td>
                    <td class="align-middle">
                        <div class="row">
                            <div class="col align-middle">
                                <form method="post" action="delete-booking/${booking.id}">
                                    <button type="submit" class="btn btn-outline-danger">Delete</button>
                                </form>
                            </div>
                            <div class="col align-middle">
                                <form method="post" action="/update-form-booking/${booking.id}">
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
