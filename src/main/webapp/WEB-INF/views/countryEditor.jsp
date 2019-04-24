<div class="container mt-5">
    <form action="/update-country" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Country id</label>
            <input type="text" class="form-control col-sm-4" name="id" value="${country.id}" readonly/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Country name</label>
            <input type="text" class="form-control col-sm-4" name="countryName" value="${country.countryName}" required/>
        </div>
        <div class="form-group row text-right">
            <button class="btn btn-outline-success col-sm-4" style="margin-left: 16.7%" type="submit" name="update">
                Update
            </button>
        </div>
    </form>
</div>
