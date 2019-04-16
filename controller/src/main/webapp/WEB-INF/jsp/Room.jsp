<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Rooms</title>
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

    <a class="btn btn-info" data-toggle="collapse" href="#roomadd" role="button" aria-expanded="false"
       aria-controls="collapseAdd">
        Create Room
    </a>

    <div class="collapse" id="roomadd">
        <div class="form-group mt-3 ">
            <div class="form-row">
                <div class="form-group">
                    <form method="post" action="save-room">
                        <tr>
                            <input type="text" name="roomNumber" placeholder="Number of room">
                            <input type="text" name="countPlace" placeholder="Count places">
                            <input type="text" name="hotelName" placeholder="Hotel">
                            <input type="text" name="roomType" placeholder="Room type">
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
                <th>Number of room</th>
                <th>Count places</th>
                <th>Hotel</th>
                <th>Room type</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="room" items="${roomList}" varStatus="rowCounter">
                <tr>
                    <td>${room.getId()}</td>
                    <td>${room.getRoomNumber()}</td>
                    <td>${room.getNumberOfPlaces()}</td>
                    <td>${room.hotel.getHotelName()}</td>
                    <td>${room.roomType.getType()}</td>
                    <td>
                        <form action="room" method="post">
                            <button class="btn btn-danger" type="submit" name="delete" value="${room.id}">delete
                            </button>
                        </form>
                        <form action="" method="get">
                            <button class="btn btn-success" type="submit" name="edit" value="${room.id}">Edit
                            </button>
                        </form>
                    </td>
                </tr>


            </c:forEach>
            </tbody>
        </table>
    </form>


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
