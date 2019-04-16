<%--
  Created by IntelliJ IDEA.
  User: i.chen
  Date: 15.04.2019
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Client</title>
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
    <form>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Id</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Country from</th>
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
                    <td>${client.country.getCountryName()}</td>
                    <td>
                        <form action="client" method="post">
                            <button class="btn btn-danger" type="submit" name="delete" value="${client.id}">delete
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>

    <a class="btn btn-info" data-toggle="collapse" href="#clientadd" role="button" aria-expanded="false"
       aria-controls="collapseAdd">
        Create Client
    </a>

    <div class="collapse" id="clientadd">
        <div class="form-group mt-3 ">
            <div class="form-row">
                <div class="form-group">
                    <form method="post" action="save-client">
                        <tr>
                            <input  type="text" name="firstName" placeholder="Firstname">
                            <input  type="text" name="lastName" placeholder="LastName">
                            <input  type="email" name="email" placeholder="E-mail">
                            <input  type="text" name="phone" placeholder="Phone">
                            <input  type="text" name="countryName" placeholder="Country from">
                        </tr>
                        <button type="submit" class="btn btn-info ml-2">ADD</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <a class="btn btn-info" data-toggle="collapse" href="#clientupdate" role="button" aria-expanded="false"
       aria-controls="collapseAdd">
        Update Client
    </a>

    <div class="collapse" id="clientupdate">
        <div class="form-group mt-3 ">
            <div class="form-row">
                <div class="form-group">
                    <form method="post" action="update-client">
                        <tr>
                            <input type="text" name="id" placeholder="id">
                            <input  type="text" name="firstName" placeholder="Firstname">
                            <input  type="text" name="lastName" placeholder="LastName">
                            <input  type="email" name="email" placeholder="E-mail">
                            <input  type="text" name="phone" placeholder="Phone">
                            <input  type="text" name="countryName" placeholder="Country from">
                        </tr>
                        <button type="submit" class="btn btn-info ml-2">update</button>
                    </form>
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
