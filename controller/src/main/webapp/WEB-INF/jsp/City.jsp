<%--
  Created by IntelliJ IDEA.
  User: karlo
  Date: 16.04.2019
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>City</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
</head>
<body>
<div id="header">
    <jsp:include page="common/header.jsp"/>
</div>
<div class="container mt-5">
    <div class="row">
        <div class="col-lg-6">
            <form>
                <table class="table table-bordered" width="200px;">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>City name</th>
                        <th>Country name</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="city" items="${cityList}" varStatus="rowCounter">
                        <tr>
                            <td>${city.getId()}</td>
                            <td>${city.getCityName()}</td>
                            <td>${city.getCountry().getCountryName()}</td>
                        </tr>

                    </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>

        <div class="col-lg-5">
            <div class="row">
                <div>
                    <h3>Delete City by ID</h3>
                    <form action="city" method="post">
                        <div class="form-row">
                            <div class="col">
                                <input type="text" name="cityiddel" class="form-control" placeholder="city id">
                            </div>
                            <div class="form-group">
                                <input type="submit" class="btn btn-danger" name="todo" value="Delete">
                            </div>

                        </div>
                    </form>
                </div>

                <div>
                    <h3>Update City</h3>
                    <form action="city" method="post">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col">
                                    <input type="text" name="cityID" class="form-control" placeholder="city id">
                                </div>
                                <div class="col">
                                    <input type="text" name="cityName" class="form-control" placeholder="city name">
                                </div>
                                <div class="col">
                                    <input type="text" name="cityCountry" class="form-control"
                                           placeholder="country name">
                                </div>
                            </div>
                            <div class="form-row" style="margin-top: 10px;">
                                <input type="submit" class="form-control btn btn-success" name="todo" value="Update">
                            </div>
                        </div>
                    </form>
                </div>
                <div>
                    <h3>Create City</h3>
                    <form action="city" method="post">
                        <div class="form-row">
                            <div class="col">
                                <input type="text" name="cityName" class="form-control" placeholder="city name">
                            </div>
                            <div class="col">
                                <input type="text" name="cityCountry" class="form-control" placeholder="country name">
                            </div>
                        </div>
                        <div class="form-row" style="margin-top: 10px;">
                            <input type="submit" class=" form-control btn btn-info" name="todo" value="Create">
                        </div>

                    </form>
                </div>
            </div>
            <div class="row">

                <div>
                    <form>
                        <table class="table table-bordered" width="200px;">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Hotel name</th>
                                <th>City name</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="hotel" items="${hotelList}" varStatus="rowCounter">
                                <tr>
                                    <td>${hotel.getId()}</td>
                                    <td>${hotel.getHotelName()}</td>
                                    <td>${hotel.getCity().getCityName()}</td>
                                </tr>

                            </c:forEach>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>
