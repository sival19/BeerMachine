@extends('master')
@section('content')
    <head>
        <title>Current Production</title>

        <link rel="stylesheet" type="text/css" href="{{'/css/start.css'}}">
        <link rel="stylesheet" type="text/css" href="{{'/css/showProduction.css'}}">

        <script type="text/javascript" src="{{'js/changeSpeed.js'}}"></script>
        <script type="text/javascript" src="{{ mix('js/app.js') }}"></script>
        <meta charset="utf-8">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" type="text/css" href="{{'/css/progressBars.css'}}">
    </head>




    <div class="inventoryBars">
        <p><strong>Inventory</strong></p>
        <label for="yeast-bar">Yeast</label>
        <div class="bar" id="yeast-bar">
        </div>
        <label for="hops-bar">Hops</label>
        <div class="bar" id="hops-bar">
        </div>
        <label for="malt-bar">Malt</label>
        <div class="bar" id="malt-bar">
        </div>
        <label for="wheat-bar">Wheat</label>
        <div class="bar" id="wheat-bar">
        </div>
        <label for="barley-bar">Barley</label>
        <div class="bar" id="barley-bar">
        </div>
    </div>



    <div class="createProductionForm">
        <h1 class="h1-start_a_production">Start a production</h1>
        <form method="post" action="/beginProduction">
            @csrf
            <p>
        <span>
            <label for="productType" class="form-label">Select type of beer:</label>
        </span>
                <span>
                    <select type="text" name="type" class="form-control name" id="productType" required
                            onchange="changeSpeed(event)">
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
                       id="productionAmount" min="1" value="100"
                       required>
            </span>
            </p>
            <p>
        <span>
            <label for="machineSpeed" name="machineSpeed" class="form-label">Enter desired machine speed, the speed inserted is the optimal based on OEE</label>
        </span>
                <span>
        <input type="number" name="machineSpeed" class="form-control name" id="machineSpeed" min="1"  value="486" max="600"
               required>
    </span>
            </p>
            <button class="start_production submit1 all_four_buttons">Start production</button>
            <button class="clear submit1 all_four_buttons" formaction="/clearButton" value="5" name="clearValue"
                    formnovalidate>Clear
            </button>
            <button class="reset submit2 all_four_buttons" formaction="/resetButton" value="1" name="resetValue"
                    formnovalidate>Reset
            </button>
            <button class="abort submit2 all_four_buttons" formaction="/abortButton" value="4" name="abortValue"
                    formnovalidate>Abort
            </button>
            <button class="stop submit2 all_four_buttons" formaction="/stopButton" value="3" name="stopValue"
                    formnovalidate>Stop
            </button>

        </form>


    </div>

    <div class="maintenance">
        <p class="maintenanceP"><strong>Maintenance</strong></p>
        <div class="maintenanceBar" id="maintenanceBar"></div>
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
        <p><strong>Machine State</strong></p>

        <table border="1" class="table">
            <tr>
                <td id="state.current">15</td>
                <td id="stateString" class="tableStateString">
                    <label id="getStateData">3</label>
                </td>
            </tr>
        </table>
    </div>

    <script>
        $(document).ready(function () {
            loadFile();

            function loadFile() {
                $.ajax({
                    url: 'getState',
                    type: 'GET',
                    datatype: 'json',
                    success: function (data) {
                        // console.log(data);
                        let label = $('#getStateData');

                        // var currentVal = state.valueOf()
                        // console.log(currentVal)
                        for (i in data) {
                            if (parseInt(document.getElementById('state.current').innerHTML.valueOf()) === parseInt(data[i].id)) {
                                var state = parseInt(document.getElementById('state.current').innerHTML.valueOf());

                                if (state <= 11) {
                                    state = state;
                                } else if (state >= 15) {
                                    state = state - 3
                                }

                                label.empty()
                                label.append(data[state].status);
                                loadFile()

                            }
                        }
                    }
                });
            }
        });
    </script>

    <script type="text/javascript" src="{{ asset('js/prod.js') }}"></script>
    <script type="text/javascript" src="{{ mix('js/app.js') }}"></script>

@endsection
