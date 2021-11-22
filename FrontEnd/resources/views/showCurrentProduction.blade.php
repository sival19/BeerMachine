<html>
<header>
    <title>Show current production test</title>
</header>

<body>
<a href="{{route("home")}}">Back</a>

<script type="text/javascript" src="{{ mix('js/app.js') }}"></script>
<h1>Current Production</h1>

{{--<div id="production">--}}
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
    {{--    <label>ProductCount:</label>--}}
    {{--    <input type="text" name="code" value="" id="production.produced">--}}

    {{--    <br>--}}
    {{--    <label>Defect Products:</label>--}}
    {{--    <input type="text" name="code" value="" id="production.Defective">--}}

    {{--    <br>--}}
    {{--    <label>Good Products:</label>--}}
    {{--    <input type="text" name="code" value="" id="production.Good">--}}
{{--</div>--}}

{{--<div id="sensors">--}}
{{--    <br>--}}
{{--    <label>Temperature:</label>--}}
{{--    <input type="text" name="code" value="" id="sensor.Temperature">--}}

{{--    <br>--}}
{{--    <label>Humidity:</label>--}}
{{--    <input type="text" name="code" value="" id="sensor.Humidity">--}}

{{--    <br>--}}
{{--    <label>Vibration:</label>--}}
{{--    <input type="text" name="code" value="" id="sensor.Vibration">--}}
{{--</div>--}}


<script type="text/javascript" src="{{ asset('js/prod.js') }}"></script>

</body>
</html>
