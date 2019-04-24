<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div class="container mt-5">
    <form class="mt-3">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Id</th>
                <th>Start date</th>
                <th>End date</th>
                <th>Country</th>
                <th>Client</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="visa" items="${visaList}" varStatus="rowCounter">
                <tr>
                    <td class="align-middle">${visa.getId()}</td>
                    <td class="align-middle">${visa.getStartDate()}</td>
                    <td class="align-middle">${visa.getEndDate()}</td>
                    <td class="align-middle">${visa.getCountry().getCountryName()}</td>
                    <td class="align-middle">${visa.getClient().getFirstName()} ${visa.getClient().getLastName()} </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
