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

    <div class="collapse ml-3 <c:if test="${notEmpty == 'notEmpty'}">show</c:if> " id="addhotel">
        <div class="form-group mt-3 ">
            <div class="form-row">
                <div class="form-group style=" style=" width: 80%; margin-left: 0.5%">
                    <form method="post" action="/save-hotel">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Hotel name</label>
                            <input type="text" class="form-control col-sm-4" name="hotelName" placeholder="Hotel name"
                                   <c:if test="${not empty notEmpty}">value="${hotel.hotelName}"</c:if>required/>
                        </div>
                        <div class="invalid-feedback d-block" style="margin-left: 12%; width: 42%">
                            <c:if test="${not empty nameError}">
                                <div class="alert alert-danger text-center"><c:out value="${nameError}"/></div>
                            </c:if>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Email</label>
                            <input type="email" class="form-control col-sm-4" name="email" placeholder="Email"
                                   <c:if test="${not empty notEmpty}">value="${hotel.email}"</c:if>required/>
                        </div>
                        <div class="invalid-feedback d-block" style="margin-left: 12%; width: 42%">
                            <c:if test="${not empty emailError}">
                                <div class="alert alert-danger text-center"><c:out value="${emailError}"/></div>
                            </c:if>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Phone</label>
                            <input type="text" class="form-control col-sm-4" name="phone" placeholder="Phone"
                                   <c:if test="${not empty notEmpty}">value="${hotel.phone}"</c:if>required/>
                        </div>
                        <div class="invalid-feedback d-block" style="margin-left: 12%; width: 42%">
                            <c:if test="${not empty phoneError}">
                                <div class="alert alert-danger text-center"><c:out value="${phoneError}"/></div>
                            </c:if>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">City</label>
                            <select name="city" class="form-control col-sm-4" required>
                                <option hidden>Select</option>
                                <c:forEach var="city" items="${cityList}">
                                    <option value="${city.id}">${city.getCityName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Address</label>
                            <input type="text" class="form-control col-sm-4" name="address" placeholder="Address"
                                    <c:if test="${not empty notEmpty}">value="${hotel.address}"</c:if>
                                   required/>
                        </div>
                        <div class="invalid-feedback d-block" style="margin-left: 12%; width: 42%">
                            <c:if test="${not empty addressError}">
                                <div class="alert alert-danger text-center"><c:out value="${addressError}"/></div>
                            </c:if>
                        </div>
                        <div class="form-group row text-right">
                            <button class="btn btn-outline-info col-sm-4" style="margin-left: 16.7%" type="submit"
                                    name="update"> Add
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
                <th style="width: 16%">Hotel name</th>
                <th style="width: 16%">Email</th>
                <th style="width: 15%">Phone</th>
                <th style="width: 17%">City</th>
                <th style="width: 17%">Address</th>
                <th style="width: 17%">Action</th>



            </tr>
            </thead>
            <tbody>
            <c:forEach var="hotel" items="${hotelList}" varStatus="rowCounter">
                <tr>
                    <td class="align-middle"><a href="room/${hotel.getId()}">${hotel.getId()}</a></td>
                    <td class="align-middle">${hotel.hotelName}</td>
                    <td class="align-middle">${hotel.email}</td>
                    <td class="align-middle">${hotel.phone}</td>
                    <td class="align-middle">${hotel.city.cityName}</td>
                    <td class="align-middle">${hotel.address}</td>
                    <td class="align-middle">
                        <div class="row">
                            <div class="col align-middle">
                                <form method="post" action="/delete-hotel/${hotel.id}">
                                    <button type="submit" class="btn btn-outline-danger">Delete</button>
                                </form>
                            </div>
                            <div class="col align-middle">
                                <form method="post" action="/update-hotel/${hotel.id}">
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
