<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container mt-5">
    <form action="/update-city" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">City id</label>
            <input type="text" class="form-control col-sm-4" name="id" value="${city.id}" readonly/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">City name</label>
            <input type="text" class="form-control col-sm-4" name="cityName" value="${city.cityName}" required />
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Country name</label>
            <select name="countryName" class="form-control col-sm-4" required>
                <c:forEach  var="countryName" items="${countryList}" >
                    <option value="${countryName.getCountryName()}">${countryName.getCountryName()}</option>
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
