<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container mt-5">
    <form action="/book-hotel-out" method="get">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Start date</label>
            <input type="date" class="form-control col-sm-4" name="startDate" required/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">End date</label>
            <input type="date" class="form-control col-sm-4" name="endDate" required/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Your id</label>
            <input type="text" class="form-control col-sm-4" name="clientId" required/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Hotel id</label>
            <input type="text" class="form-control col-sm-4" name="hotelId" required/>
        </div>
        <div class="form-group row text-right">
            <button class="btn btn-outline-success col-sm-4" style="margin-left: 16.7%" type="submit" name="book">
                Book
            </button>
        </div>
    </form>
</div>
