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
    <a href="{{route("show_production-link")}}">See a production</a>
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
                        console.log(data);
                        let table = $('#getRequestData');
                        for (i in data) {
                            let td = $("<td></td>").appendTo(table);
                            td.(data[i].id);
                        }
                    }
                });
            }
        });
    </script>

    <table border="1">
        <tr>
            <th>Production ID</th>
            <th>Created at</th>
        </tr>
        <tr class="getRequestData">
        </tr>

    </table>

@endsection
