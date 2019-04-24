<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container mt-5">
    <form action="/update-booking" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Booking id</label>
            <input type="text" class="form-control col-sm-4" name="id" value="${booking.id}" readonly/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Start date</label>
            <input type="date" class="form-control col-sm-4" name="startDate" value="${booking.getStartDate()}" required/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">End date</label>
            <input type="date" class="form-control col-sm-4" name="endDate" value="${booking.getEndDate()}" required/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Client lastName</label>
            <select name="clientId" class="form-control col-sm-4">
                <option hidden>${booking.getClient().getLastName()}</option>
                <c:forEach var="client" items="${clientList}">
                    <option value="${client.getId()}">${client.getLastName()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Room id</label>
            <select name="roomId" class="form-control col-sm-4">
                <option hidden>${booking.getRoom().getId()}</option>
                <c:forEach var="room" items="${roomList}">
                    <option value="${room.getId()}">${room.getId()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row text-right">
            <button class="btn btn-outline-success col-sm-4" style="margin-left: 16.7%" type="submit" name="update">
                Update
            </button>
        </div>
    </form>
</div>
