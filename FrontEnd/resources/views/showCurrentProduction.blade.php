@extends('master')

@section('content')
<title>Current Production</title>

<script type="text/javascript" src="{{ mix('js/app.js') }}"></script>
<h1>Current Production</h1>

<table border="1">
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


<script type="text/javascript" src="{{ asset('js/prod.js') }}"></script>
@endsection
