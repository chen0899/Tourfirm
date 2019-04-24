<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container mt-5">
    <form action="/update-room" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Room id</label>
            <input type="text" class="form-control col-sm-4" name="id" value="${room.id}" readonly/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Room number</label>
            <input type="number" min="1" class="form-control col-sm-4" name="roomNumber" value="${room.roomNumber}"
                   required/>
        </div>
        <div class="invalid-feedback d-block" style="margin-left: 12%; width: 42%">
            <c:if test="${not empty roomNumberError}">
                <div class="alert alert-danger text-center"><c:out value="${roomNumberError}"/></div>
            </c:if>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Count of places</label>
            <input type="text" min="1" max="10" class="form-control col-sm-4" name="numberOfPlaces"
                   value="${room.numberOfPlaces}" required/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Hotel name</label>
            <input type="text" class="form-control col-sm-4" name="hotel" value="${room.hotel.hotelName}" readonly/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Room type</label>
            <select name="roomType" class="form-control col-sm-4">
                <option hidden>${room.roomType.type}</option>
                <c:forEach var="type" items="${typesList}">
                    <option value="${type.getType()}">${type.getType()}</option>
                </c:forEach>
            </select>
        </div>
        <input hidden value="${room.hotel.getId()}" name="hotelId">
        <div class="form-group row text-right">
            <button class="btn btn-outline-success col-sm-4" style="margin-left: 16.7%" type="submit" name="update">
                Update
            </button>
        </div>
    </form>
</div>
