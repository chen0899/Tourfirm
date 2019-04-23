<div class="container mt-5">
    <form action="/update-client" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Client id</label>
            <input type="text" class="form-control col-sm-4" name="id" value="${client.id}" readonly/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Firstname</label>
            <input type="text" class="form-control col-sm-4" name="firstName" value="${client.firstName}"/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Lastname</label>
            <input type="text" class="form-control col-sm-4" name="lastName" value="${client.lastName}"/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Email</label>
            <input type="email" class="form-control col-sm-4" name="email" value="${client.email}"/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Phone</label>
            <input type="text" class="form-control col-sm-4" name="phone" value="${client.phone}"/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Country from</label>
            <select name="countryName" class="form-control col-sm-4">
                <option hidden ></option>
                <c:forEach  var="countryName" items="${countryNameList}" >
                    <option value="${countryName.getCountryName()}">${countryName.getCountryName()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group row text-right">
            <button class="btn btn-outline-success col-sm-4" style="margin-left: 16.7%" type="submit" name="update">
                Update
            </button>
        </div>
    </form>
</div>
