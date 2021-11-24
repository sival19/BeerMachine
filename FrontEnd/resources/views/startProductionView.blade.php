<html>
<head>
    <title>
Current Production
    </title>
</head>

<body>
<a href="{{route("home")}}">Back</a>

<script type="text/javascript" src="{{ mix('js/app.js') }}"></script>
<center>
<h1>Start a Production</h1>

<br>
<form method="" action="/createProduction">
@csrf
    <div class="mb-3">
        <label for="productType" class="form-label">Select type of beer</label><br>
        <select type="text" name="Production Type" class="form-control name" id="productType" required>
            <option value="0">Pilsner</option>
            <option value="1">Wheat</option>
            <option value="2">IPA</option>
            <option value="3">Stout</option>
            <option value="4">Ale</option>
            <option value="5">Alchol Free</option>
        </select>
    </div> <br>

    <div class="mb-3">
        <label for="productionAmount" class="form-label">Enter desired amount of beer to produce</label><br>
        <input type="number" name="Production Amount" class="form-control name" id="productionAmount" placeholder="1000" required>
    </div><br>
    <div class="mb-3">
        <label for="machineSpeed" class="form-label">Enter desired machine speed</label><br>
        <input type="number" name="Machine Speed" class="form-control name" id="machineSpeed" placeholder="50" required>
    </div><br>


    <div class="">
        <button type="button">Create Production</button>
        <button type="button">Reset</button>
        <button type="button">Clear</button>
    </div>
</form>

</center>
<script type="text/javascript" src="{{ asset('js/prod.js') }}"></script>

</body>
</html>
