<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div class="container mt-5">

    <a class="btn btn-info" data-toggle="collapse" href="#cityadd" role="button" aria-expanded="false"
       aria-controls="collapseAdd">
        Create City
    </a>

    <div class="collapse col-ml-3" id="cityadd">
        <div class="form-group mt-3 ">
            <div class="form-row">
                <div class="form-group" style="width: 80%; margin-left: 2%">
                    <form method="post" action="/save-city">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">City name</label>
                            <input type="text" class="form-control col-sm-4" name="cityName"/>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Country name</label>
                            <select name="countryName" class="form-control col-sm-4">
                                <option hidden>Select</option>
                                <c:forEach var="countryName" items="${countryNameList}">
                                    <option value="${countryName.getCountryName()}">${countryName.getCountryName()}</option>
                                </c:forEach>
                            </select>
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
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Id</th>
                <th>City Name</th>
                <th>Country Name</th>
                <th style="width: 30%" colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="city" items="${cityList}" varStatus="rowCounter">
                <td class="align-middle">${city.getId()}</td>
                <td class="align-middle">${city.getCityName()}</td>
                <td class="align-middle">${city.getCountry().getCountryName()}</td>
                <td class="align-middle">
                    <form method="post" action="delete/${city.id}">
                        <button type="submit" class="btn btn-outline-danger">Delete</button>
                    </form>
                </td>
                <td class="align-middle">
                    <form method="post" action="/update-form-city/${city.id}">
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
