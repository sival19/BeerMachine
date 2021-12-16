@extends('master')
@section('content')
    <html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" type="text/css" href="{{'/css/showProductions.css'}}">
        <title>Document</title>
    </head>
    <body>
       <div class = "productions">
        <h3> Batch ID: {{$production->id}}</h3>
        <table border="1" class="table">
            <tr>
                <th>Beer Type</th>
                <th>Production Size</th>
                <th>Sucessfull Products</th>
                <th>Defect Products</th>
                <th>Production Date</th>
            </tr>

            <tr>
                <td>{{$production->beer_type}}</td>
                <td>{{$production->production_size}}</td>
                <td>{{$production->succeeded_count}}</td>
                <td>{{$production->failed_count}}</td>
                <td>{{$production->created_at}}</td>
            </tr>
        </table>
    </div>

    <div class="items">
        {{ $chart->container() }}
    </div>

    <script src="{{ $chart->cdn() }}"></script>
    {{ $chart->script() }}
    </body>
    </html>
@endsection
