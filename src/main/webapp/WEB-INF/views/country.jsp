<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div class="container mt-5">

    <a class="btn btn-info" data-toggle="collapse" href="#countryadd" role="button" aria-expanded="false"
       aria-controls="collapseAdd">
        Create Country
    </a>

    <div class="collapse" id="countryadd">
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
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Id</th>
                <th>Country name</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="country" items="${countryList}" varStatus="rowCounter">
                <tr>
                    <td>${country.getId()}</td>
                    <td>${country.countryName}</td>
                    <td>
                        <form action="room" method="post">
                            <button class="btn btn-danger" type="submit" name="delete" value="${room.id}">delete
                            </button>
                        </form>
                        <form action="update-room" method="get">
                            <button class="btn btn-warning" type="submit" name="edit" value="${room.id}">Edit
                            </button>
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
