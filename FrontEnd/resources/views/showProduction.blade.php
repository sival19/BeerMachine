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
    <title>Show production</title>

    <h1>Show production</h1>

    <label>{{$production->production_size}}</label>

    <div class="items">
        {{ $chart->container() }}
        THE MOST AWSOME GRAPH! GOES HERE!!!
    </div>

    <script src="{{ $chart->cdn() }}"></script>
    {{ $chart->script() }}
    </body>
    </html>
@endsection
