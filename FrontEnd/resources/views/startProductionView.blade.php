@extends('master')
@section('content')
    <head>
        <title>Current Production</title>

        <link rel="stylesheet" type="text/css" href="{{'/css/start.css'}}">
        <link rel="stylesheet" type="text/css" href="{{'/css/showProduction.css'}}">

        <script type="text/javascript" src="{{ mix('js/app.js') }}"></script>
    </head>


<div class="createProductionForm">
    <h1>Start a Production</h1>
    <form method="post" action="/beginProduction">
        @csrf
        <p>
        <span>
            <label for="productType" class="form-label">Select type of beer</label>
        </span>
            <span>
                <select type="text" name="type" class="form-control name" id="productType" required>
            <option value="0.0">Pilsner</option>
            <option value="1.0">Wheat</option>
            <option value="2.0">IPA</option>
            <option value="3.0">Stout</option>
            <option value="4.0">Ale</option>
            <option value="5.0">Alcohol Free</option>
            </select>
            </span>
        </p>
        <p>
        <span>
            <label for="productionAmount" class="form-label">Enter desired amount of beer to produce</label>
        </span>
            <span>
                <input type="number" name="amount" class="form-control name" id="productionAmount" placeholder="1000"
                       required>
            </span>
        </p>
        <p>
        <span>
            <label for="machineSpeed" name="machineSpeed" class="form-label">Enter desired machine speed</label>
        </span>
            <span>
        <input type="number" name="machineSpeed" class="form-control name" id="machineSpeed" placeholder="50" required>
    </span>
        </p>


        <button class="start" type="submit">Start Production</button>
        <button class="reset" type="submit">Reset</button>

    </form>

</div>

<div class="showProduction">
    <p><strong>Data from production</strong></p>
    <table border="1" class="table">
        <tr>
        <tr>
            <td>Product Count</td>
            <td>Good Products</td>
            <td>Defect Products</td>
        </tr>
        <td id="production.produced"></td>
        <td id="production.Good"></td>
        <td id="production.Defective"></td>
        </tr>

        <td>Temperature</td>
        <td>Humidity</td>
        <td>Vibration</td>
        <tr>
            <td id="sensor.Temperature"></td>
            <td id="sensor.Humidity"></td>
            <td id="sensor.Vibration"></td>
        </tr>
    </table>
    <br>
</div>

<script type="text/javascript" src="{{ asset('js/prod.js') }}"></script>
<script type="text/javascript" src="{{ mix('js/app.js') }}"></script>

@endsection
