<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container mt-5">
    <form action="/update-visa" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Visa id</label>
            <input type="text" class="form-control col-sm-4" name="id" value="${visa.id}" readonly/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Start date</label>
            <input type="date" class="form-control col-sm-4" name="startDate" value="${visa.startDate}" required/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">End Date</label>
            <input type="date" class="form-control col-sm-4" name="endDate" value="${visa.endDate}" required/>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Country</label>
            <%--                            <input type="text" class="form-control col-sm-4" name="roomType"/>--%>
            <select name="countryName" class="form-control col-sm-4" required>
                <option hidden value="${visa.country.countryName}">${visa.country.countryName}</option>
                <c:forEach  var="country" items="${countryList}" >
                    <option value="${country.getCountryName()}">${country.getCountryName()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Client</label>
            <%--                            <input type="text" class="form-control col-sm-4" name="roomType"/>--%>
            <select name="clientName" class="form-control col-sm-4" required>
                <option hidden value="${visa.client.lastName}">${visa.client.lastName}</option>
                <c:forEach  var="client" items="${clientList}" >
                    <option value="${client.getLastName()}">${client.getLastName()}</option>
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