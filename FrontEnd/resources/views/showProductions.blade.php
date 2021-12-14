@extends("master")

@section('content')
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" type="text/css" href="{{'/css/showProductions.css'}}">

        <title>Document</title>
    </head>

    <title>Show production</title>




    <div class = "productions">
        <h3> List of productions</h3>
        <table border="1" class="table">
            <tr>
                <th>Batch Id</th>
                <th>Machine Status</th>
                <th>Beer Type</th>
                <th>Production Size</th>
                <th>Sucessfull Products</th>
                <th>Defect Products</th>
                <th>Production Date</th>
                <th>Show Production</th>
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
