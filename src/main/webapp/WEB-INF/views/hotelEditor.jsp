<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container mt-5">
    <form  method="post" action="/update-hotel">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Hotel id</label>
            <input type="text" class="form-control col-sm-4" name="id" value="${hotel.id}" readonly/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Hotel name</label>
            <input type="text" class="form-control col-sm-4" name="hotelName" value="${hotel.hotelName}"/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Email</label>
            <input type="text" class="form-control col-sm-4" name="email" value="${hotel.email}"/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Phone</label>
            <input type="text" class="form-control col-sm-4" name="phone" value="${hotel.phone}"/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">City</label>
            <select name="city" class="form-control col-sm-4">
                <option hidden>${hotel.city.getCityName()}</option>
                <c:forEach var="city" items="${cityList}">
                    <option value="${city.id}">${city.getCityName()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Address</label>
            <input type="text" class="form-control col-sm-4" name="address" value="${hotel.address}"/>
        </div>
        <div class="form-group row text-right">
            <button class="btn btn-outline-success col-sm-4" style="margin-left: 16.7%" type="submit" name="update">
                Update
            </button>
        </div>
    </form>
</div>