<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<div class="container mt-5">

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
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
