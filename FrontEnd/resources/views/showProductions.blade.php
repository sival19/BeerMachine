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

    <div class = "productions">
        <table border="1">
            <tr>
                <td>Batch Id</td>
                <td>Machine Status</td>
                <td>Beer Type</td>
                <td>Production Size</td>
                <td>Sucessfull Products</td>
                <td>Defect Products</td>
                <td>Production Date</td>
                <td>Show Production</td>
            </tr>

            @foreach($productions as $production)
                <tr>
                    <td>{{$production->id}}</td>
                    <td>{{$production->machine_id}}</td>
                    <td>{{$production->beer_type}}</td>
                    <td>{{$production->production_size}}</td>
                    <td>{{$production->succeeded_count}}</td>
                    <td>{{$production->failed_count}}</td>
                    <td>{{$production->created_at}}</td>
                    <td><a class="show" href="{{ route('show_production-link', [$production->id]) }}">Show production</a>
                    </td>
                </tr>
            @endforeach
        </table>
    </div>

@endsection
