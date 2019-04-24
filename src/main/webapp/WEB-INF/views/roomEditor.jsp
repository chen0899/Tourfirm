<div class="container mt-5">
    <form action="/update-room" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Room id</label>
            <input type="text" class="form-control col-sm-4" name="id" value="${room.id}" readonly/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Room number</label>
            <input type="text" class="form-control col-sm-4" name="roomNumber" value="${room.roomNumber}" required/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Count of places</label>
            <input type="text" class="form-control col-sm-4" name="numberOfPlaces" value="${room.numberOfPlaces}" required/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Hotel name</label>
            <input type="text" class="form-control col-sm-4" name="hotel" value="${room.hotel.hotelName}" readonly/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Room type</label>
            <input type="text" class="form-control col-sm-4" name="roomType" value="${room.roomType.type}" required/>
        </div>
        <div class="form-group row text-right">
            <button class="btn btn-outline-success col-sm-4" style="margin-left: 16.7%" type="submit" name="update">
                Update
            </button>
        </div>
    </form>
</div>
