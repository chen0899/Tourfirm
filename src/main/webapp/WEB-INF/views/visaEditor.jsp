<div class="container mt-5">
    <form action="/update-visa" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Visa id</label>
            <input type="text" class="form-control col-sm-4" name="id" value="${visa.id}" readonly/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Start date</label>
            <input type="date" class="form-control col-sm-4" name="startDate" value="${visa.startDate}"/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">End Date</label>
            <input type="date" class="form-control col-sm-4" name="endDate" value="${visa.endDate}"/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Country</label>
            <input type="text" class="form-control col-sm-4" name="countryName" value="${visa.country.countryName}"/>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Client</label>
            <input type="text" class="form-control col-sm-4" name="clientName" value="${visa.client.lastName}"/>
        </div>
        <div class="form-group row text-right">
            <button class="btn btn-outline-success col-sm-4" style="margin-left: 16.7%" type="submit" name="update">
                Update
            </button>
        </div>
    </form>
</div>