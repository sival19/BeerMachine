@extends('master')
@section('content')
    <head>
        <title>Current Production</title>

        <link rel="stylesheet" type="text/css" href="{{'/css/start.css'}}">
        <link rel="stylesheet" type="text/css" href="{{'/css/showProduction.css'}}">

        <script type="text/javascript" src="{{ mix('js/app.js') }}"></script>
    </head>

    <div class="createProductionForm">
        <h1 class="h1-start_a_production">Start a production</h1>
        <form method="post" action="/beginProduction">
            @csrf
            <p>
        <span>
            <label for="productType" class="form-label">Select type of beer:</label>
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
            <label for="productionAmount" class="form-label">Enter desired amount of beer to produce:</label>
        </span>
                <span>
                <input type="number" name="amount" onkeypress="return event.charCode !== 45" class="form-control name"
                       id="productionAmount" min="1" placeholder="1000"
                       required>
            </span>
            </p>
            <p>
        <span>
            <label for="machineSpeed" name="machineSpeed" class="form-label">Enter desired machine speed:</label>
        </span>
                <span>
        <input type="number" name="machineSpeed" class="form-control name" id="machineSpeed" min="0" placeholder="50"
               required>
    </span>
            </p>

            {{--            Work in progress--}}
            {{--            <div class="all_four_buttons">--}}
            {{--                <div class="submit1">--}}
            {{--                    <button type="submit">Start Production</button>--}}
            {{--                    <button type="submit">Clear</button>--}}
            {{--                </div>--}}

            {{--                <div class="submit2">--}}
            {{--                    <button type="submit">Reset</button>--}}
            {{--                    <button type="submit">Abort</button>--}}
            {{--                </div>--}}
            {{--            </div>--}}

            <button class="start_production submit1 all_four_buttons">Start production</button>
            <button class="clear submit1 all_four_buttons" formaction="/clearButton" value="5" name="clearValue">Clear</button>
            <button class="reset submit2 all_four_buttons" formaction="/resetButton" value="1" name="resetValue">Reset</button>
            <button class="abort submit2 all_four_buttons" formaction="/abortButton" value="4" name="abortValue">Abort</button>

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
    <table border="1" class="table">
        <tr>
        <tr>
            <td>Machine State</td>

        </tr>
        <td id="state.current"></td>
        </tr>
    </table>
    <div>

    </div>

    <script type="text/javascript" src="{{ asset('js/prod.js') }}"></script>
    <script type="text/javascript" src="{{ mix('js/app.js') }}"></script>

@endsection
