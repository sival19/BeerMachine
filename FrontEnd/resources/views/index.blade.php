@extends('master')

@section('content')
    <html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Document</title>

        <link rel="stylesheet" type="text/css" href="{{'/css/progressBars.css'}}">
    </head>
    <body>

    <div class="progressBars">


        <div class="progressBar">

            <div class="barlyBar">100</div>
        </div>
        <div class="progressBar">
            <div class="hopsBar">100</div>
        </div>
        <div class="progressBar">
            <div class="maltBar">100</div>
        </div>
        <div class="progressBar">
            <div class="wheatBar">100</div>
        </div>
        <div class="progressBar">
            <div class="yeastBar">100</div>
        </div>
    </div>

    </body>
    </html>
@endsection
