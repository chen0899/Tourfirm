<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<div class="container mt-5">

    <a class="btn btn-outline-info ml-3" data-toggle="collapse" href="#addhotel" role="button" aria-expanded="false"
       aria-controls="collapseAdd">
        Add Hotel
    </a>

    <div class="collapse ml-3" id="addhotel">
        <div class="form-group mt-3 ">
            <div class="form-row">
                <div class="form-group style=" style=" width: 80%; margin-left: 0.5%">
                    <form method="post" action="hotel-save">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Hotel name</label>
                            <input type="text" class="form-control col-sm-4" name="hotelName" placeholder="Hotel name"/>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Email</label>
                            <input type="text" class="form-control col-sm-4" name="email" placeholder="Email"/>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Phone</label>
                            <input type="text" class="form-control col-sm-4" name="phone" placeholder="Phone"/>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">City</label>
                            <input type="text" class="form-control col-sm-4" name="city" placeholder="City"/>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Address</label>
                            <input type="text" class="form-control col-sm-4" name="address" placeholder="Address"/>
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
                <th style="width: 2%">Id</th>
                <th style="width: 13%">Hotel name</th>
                <th style="width: 14%">Email</th>
                <th style="width: 20%">Phone</th>
                <th style="width: 20%">City</th>
                <th style="width: 20%">Address</th>
                <th style="width: 20%" colspan="2">Action</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="hotel" items="${hotelList}" varStatus="rowCounter">
                <tr>
                    <td class="align-middle"><a href="rooms/${hotel.getId()}">${hotel.getId()}</a></td>
                    <td class="align-middle">${hotel.hotelName}</td>
                    <td class="align-middle">${hotel.email}</td>
                    <td class="align-middle">${hotel.phone}</td>
                    <td class="align-middle">${hotel.city.cityName}</td>
                    <td class="align-middle">${hotel.address}</td>
                    <td class="align-middle">
                        <form method="post" action="delete/${hotel.id}">
                            <button type="submit" class="btn btn-outline-danger">Delete</button>
                        </form>
                    </td>
                    <td class="align-middle">
                        <form method="post" action="update-hotel/${hotel.id}">
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