<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div class="container mt-5">

    <a class="btn btn-outline-info ml-3" data-toggle="collapse" href="#clientadd" role="button" aria-expanded="false"
       aria-controls="collapseAdd">
        Create Client
    </a>

    <div class="collapse ml-3" id="clientadd">
        <div class="form-group mt-3 ">
            <div class="form-row">
                <div class="form-group">
                    <form method="post" action="save-client">
                        <input  type="text" name="firstName" placeholder="Firstname">
                        <input  type="text" name="lastName" placeholder="LastName">
                        <input  type="email" name="email" placeholder="E-mail">
                        <input  type="text" name="phone" placeholder="Phone">
                        <input  type="text" name="countryName" placeholder="Country from">
                        <button type="submit" class="btn btn-info ml-2">ADD</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <form class="mt-3">
        <table class="table table-bordered text-center">
            <thead>
            <tr>
                <th>Id</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Country from</th>
                <th style="width: 30%">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="client" items="${clientList}" varStatus="rowCounter">
                <tr>
                    <td>${client.getId()}</td>
                    <td>${client.getFirstName()}</td>
                    <td>${client.getLastName()}</td>
                    <td>${client.getEmail()}</td>
                    <td>${client.getPhone()}</td>
                    <td>${client.getCountry().getCountryName()}</td>
                    <td class="align-middle">
                        <form method="post">
                            <button type="submit" class="btn btn-outline-success">Edit</button>
                        </form>
                        <form method="post" action="delete-client/${client.id}">
                            <button type="submit"  class ="btn btn-outline-danger" class="ml-3" >Delete</button>
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
