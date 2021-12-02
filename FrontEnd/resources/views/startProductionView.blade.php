<html>
<head>
    <title>
Current Production
    </title>
    <link rel="stylesheet" type="text/css" href="{{'/css/start.css'}}">
</head>

<body>
<a href="{{route("home")}}">Back</a>

<script type="text/javascript" src="{{ mix('js/app.js') }}"></script>

<h1>Start a Production</h1>

<div class="createProductionForm">
<form method="post" action="/beginProduction">
@csrf
        <label for="productType" class="form-label">Select type of beer</label>
        <select type="text" name="type" class="form-control name" id="productType" required>
            <option value="0.0">Pilsner</option>
            <option value="1.0">Wheat</option>
            <option value="2.0">IPA</option>
            <option value="3.0">Stout</option>
            <option value="4.0">Ale</option>
            <option value="5.0">Alcohol Free</option>
        </select>

        <label for="productionAmount" class="form-label">Enter desired amount of beer to produce</label>
        <input type="number" name="amount" class="form-control name" id="productionAmount" placeholder="1000" required>
        <label for="machineSpeed" name="machineSpeed" class="form-label">Enter desired machine speed</label>
        <input type="number" name="machineSpeed" class="form-control name" id="machineSpeed" placeholder="50" required>
    <button type="submit">Create Production</button>
</form>

</div>


<script type="text/javascript" src="{{ asset('js/prod.js') }}"></script>

</body>
</html>
