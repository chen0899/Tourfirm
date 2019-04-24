<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>


<h3>All countries </h3>
<form class="mt-3">
    <table class="table table-bordered text-center">
        <thead>
        <tr>
            <th style="width: 20%">Id</th>
            <th>Country name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="country" items="${countryList}" varStatus="rowCounter">
            <tr>
                <td class="align-middle">${country.getId()}</td>
                <td class="align-middle">${country.getCountryName()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>

<h3>All cities </h3>
<form class="mt-3">
    <table class="table table-bordered text-center">
        <thead>
        <tr>
            <th style="width: 20%">Id</th>
            <th>City name</th>
            <th>Country name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="city" items="${cityList}" varStatus="rowCounter">
            <tr>
                <td class="align-middle">${city.getId()}</td>
                <td class="align-middle">${city.getCityName()}</td>
                <td class="align-middle">${city.getCountry().getCountryName()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>
