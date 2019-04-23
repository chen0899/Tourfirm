<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div class="container mt-5">

    <a class="btn btn-outline-info ml-3" data-toggle="collapse" href="#countryadd" role="button" aria-expanded="false"
       aria-controls="collapseAdd">
        Create Country
    </a>

    <div class="collapse ml-3" id="countryadd">
        <div class="form-group mt-3 ">
            <div class="form-row">
                <div class="form-group">
                    <form method="post" action="save-country">
                        <tr>
                            <input type="text" name="countryName" placeholder="Country name">
                        </tr>
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
                <th style="width: 20%">Id</th>
                <th >Country name</th>
                <th style="width: 30%">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="country" items="${countryList}" varStatus="rowCounter">
                <tr>
                    <td class="align-middle">${country.getId()}</td>
                    <td class="align-middle">${country.countryName}</td>
                    <td class="align-middle">
                        <form method="post">
                            <button type="submit" class="btn btn-outline-success">Edit</button>
                        </form>
                        <form method="post" action="delete-country/${country.id}">
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
