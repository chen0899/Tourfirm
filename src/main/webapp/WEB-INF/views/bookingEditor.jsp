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
            <label class="col-sm-2 col-form-label">Client id</label>
            <input type="text" class="form-control col-sm-4" name="clientId" value="${booking.getClient().getId()}" required/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Room id</label>
            <input type="text" class="form-control col-sm-4" name="roomId" value="${booking.getRoom().getId()}" required/>
        </div>
        <div class="form-group row text-right">
            <button class="btn btn-outline-success col-sm-4" style="margin-left: 16.7%" type="submit" name="update">
                Update
            </button>
        </div>
    </form>
</div>
