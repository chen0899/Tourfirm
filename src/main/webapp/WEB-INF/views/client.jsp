<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div class="container mt-5">

    <a class="btn btn-outline-info ml-3" data-toggle="collapse" href="#clientadd" role="button" aria-expanded="false"
       aria-controls="collapseAdd">
        Create Client
    </a>

    <div class="collapse col-ml-3" id="clientadd">
        <div class="form-group mt-3 ">
            <div class="form-row">
                <div class="form-group" style="width: 80%; margin-left: 2%">
                    <form method="post" action="/save-client">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Firstname</label>
                            <input type="text" class="form-control col-sm-4" name="firstName"/>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Lastname</label>
                            <input type="text" class="form-control col-sm-4" name="lastName"/>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Email</label>
                            <input type="email" class="form-control col-sm-4" name="email"/>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Phone</label>
                            <input type="text" class="form-control col-sm-4" name="phone"/>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Country from</label>
                            <input type="text" class="form-control col-sm-4" name="countryName"/>
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
                        <form method="post" action="delete-client/${client.id}">
                            <button type="submit"  class ="btn btn-outline-danger" class="ml-3" >Delete</button>
                        </form>
                    </td>
                    <td>
                        <form m ethod="post" action="update-form-client/${client.id}">
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
