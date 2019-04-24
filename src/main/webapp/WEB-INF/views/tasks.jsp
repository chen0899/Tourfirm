<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>         </h3>
<h3> Some statistics for tourfirm:</h3>
<ul>
    <li class="align-middle">
        <form method="get" action="/task1">
            <button type="submit" class="btn btn-outline-info ml-3">Show all cities and countries in this tourfirm!
            </button>
        </form>
    </li>

    <li class="align-middle">
        <form method="get" action="/task2">
            <button type="submit" class="btn btn-outline-info ml-3">Find hotels by city name</button>
        </form>
    </li>

    <li class="align-middle">
        <form method="get" action="/task3">
            <button type="submit" class="btn btn-outline-info ml-3">Find visa for client</button>
        </form>
    </li>

    <li class="align-middle">
        <form method="get" action="/task4">
            <button type="submit" class="btn btn-outline-info ml-3">Find visa by country name</button>
        </form>
    </li>

    <li class="align-middle">
        <form method="get" action="/book-hotel">
            <button type="submit" class="btn btn-outline-info ml-3">Book hotel</button>
        </form>
    </li>

</ul>
