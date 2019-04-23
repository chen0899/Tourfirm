<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div class="container mt-5">

    <a class="btn btn-info" data-toggle="collapse" href="#cityadd" role="button" aria-expanded="false"
       aria-controls="collapseAdd">
        Create City
    </a>

    <div class="collapse" id="cityadd">
        <div class="form-group mt-3 ">
            <div class="form-row">
                <div class="form-group">
                    <form method="post" action="save-city">
                        <tr>
                            <input type="text" name="cityName" placeholder="city name">
                            <input type="text" name="countryName" placeholder="country name">

                        </tr>
                        <button type="submit" class="btn btn-info ml-2">ADD</button>
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
                <th>Action</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="city" items="${cityList}" varStatus="rowCounter">


                    <td>${city.getId()}</td>
                    <td>${city.getCityName()}</td>
                    <td>${city.getCountry().getCountryName()}</td>
                    <td>
                        <a href="city/delete/${city.getId()}">Delete</a>
                        <a href="city/update/${city.getId()}">Update</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>