@extends("master")

@section('content')
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <title>Document</title>
    </head>

    <title>Show production</title>

    <h1>Show productions</h1>

    <br>
    <h3> See a specific production:</h3>
    <br>

    <script type="text/javascript">
        $(document).ready(function () {
            loadFile();
            function loadFile() {
                $.ajax({
                    url: 'getProductions',
                    type: 'GET',
                    datatype: 'json',
                    success: function (data) {
                        let getRequestData = $('#getRequestData');
                        let beerType = $('#beerType')
                        for (i in data) {
                            let tr = $("<tr></tr>").appendTo(getRequestData)

                            let batchID = $("<td></td>").appendTo(tr)
                            let machineID = $("<td></td>").appendTo(tr)
                            let beerType = $("<td></td>").appendTo(tr)
                            let productionSize = $("<td></td>").appendTo(tr)
                            let succeededCount = $("<td></td>").appendTo(tr)
                            let failedCount = $("<td></td>").appendTo(tr)
                            let createdAt = $("<td></td>").appendTo(tr)
                            let showProduction = $("<td></td>").appendTo(tr)

                            @foreach($productions as $production)
                            $("<a href='{{route("show_production-link", [$production->id])}}'>Show production</a>").appendTo(showProduction)
                            @endforeach
                            // link.appendTo(showProduction)


                            batchID.text(data[i].id)
                            machineID.text(data[i].machine_id)
                            beerType.text(data[i].beer_type)
                            productionSize.text(data[i].production_size)
                            succeededCount.text(data[i].succeeded_count)
                            failedCount.text(data[i].failed_count)
                            showProduction.text()

                            var dateString = data[i].created_at.toString()
                            var dateFormattedString = dateString.replace(".000000Z", "")
                            createdAt.text(dateFormattedString.replace("T", " "))





                            // batchID.empty()
                            // batchID.append(data[i].id)
                            // beerType.empty()
                            // beerType.append(data[i].beer_type)
                        }
                    }
                });
            }
        });
    </script>

    <table border="1" id="getRequestData">
        <tr>
            <th>Batch ID</th>
            <th>Machine status</th>
            <th>Beer Type</th>
            <th>Production Size</th>
            <th>Successfull Products</th>
            <th>Defect Products</th>
            <th>Production Date</th>
            <th>Show Production</th>


        </tr>

    </table>

@endsection
