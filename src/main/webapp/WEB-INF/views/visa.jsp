<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div class="container mt-5">

    <a class="btn btn-outline-info ml-3" data-toggle="collapse" href="#visaadd" role="button" aria-expanded="false"
       aria-controls="collapseAdd">
        Create Visa
    </a>

    <div class="collapse col-ml-3" id="visaadd">
        <div class="form-group mt-3 ">
            <div class="form-row">
                <div class="form-group" style="width: 80%; margin-left: 2%">
                    <form method="post" action="/visa-save">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Start date</label>
                            <input type="date" class="form-control col-sm-4" name="startDate"/>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">End Date</label>
                            <input type="date" class="form-control col-sm-4" name="endDate"/>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Country</label>
                            <%--                            <input type="text" class="form-control col-sm-4" name="roomType"/>--%>
                            <select name="country" class="form-control col-sm-4">
                                <option hidden>Select</option>
                                <c:forEach var="country" items="${countryList}">
                                    <option value="${country.getCountryName()}">${country.getCountryName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Client</label>
                            <%--                            <input type="text" class="form-control col-sm-4" name="roomType"/>--%>
                            <select name="client" class="form-control col-sm-4">
                                <option hidden>Select</option>
                                <c:forEach var="client" items="${clientList}">
                                    <option value="${client.getLastName()}">${client.getLastName()}</option>
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
                <th>Start date</th>
                <th>End date</th>
                <th>Country</th>
                <th>Client</th>
                <th style="width: 30%" colspan="2">Action</th>
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
                    <td class="align-middle">
                        <form method="post" action="delete-visa/${visa.id}">
                            <button type="submit" class="btn btn-outline-danger">Delete</button>
                        </form>
                    </td>
                    <td class="align-middle">
                        <form method="post" action="/update-visa/${visa.id}">
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
