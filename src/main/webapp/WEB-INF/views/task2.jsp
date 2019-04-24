<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>

    <div class="form-group mt-3 ">
        <div class="form-row">
            <div class="form-group" style="width: 80%; margin-left: 2%">
                <form method="get" action="/task2-out">
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">City name</label>
                        <input type="text" class="form-control col-sm-4" name="cityName"/>
                    </div>
                    <div class="form-group row text-right">
                        <button class="btn btn-outline-info col-sm-4" style="margin-left: 16.7%" type="submit"
                                name="update">
                            Enter
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>


</body>
</html>
