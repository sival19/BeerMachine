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

{{--    <h1 class="h1">Incredients</h1>--}}

    <div class="progressBars">
        <h1 class="h1">Resources</h1>
        <div class="progressBar">
            <label class="label_progressbar" for="barlyBar">Barley:</label>
            <div class="barlyBar">100</div>
        </div>

        <div class="progressBar">
            <label class="label_progressbar" for="hopsBar">Hops:</label>
            <div class="hopsBar">100</div>
        </div>

        <div class="progressBar">
            <label class="label_progressbar" for="maltar">Malt:</label>
            <div class="maltBar">100</div>
        </div>

        <div class="progressBar">
            <label class="label_progressbar" for="wheatBar">Wheat:</label>
            <div class="wheatBar">100</div>
        </div>

        <div class="progressBar">
            <label class="label_progressbar" for="yeastBar">Yeast:</label>
            <div class="yeastBar">100</div>
        </div>

        <div class="progressBar">
            <label class="label_progressbar" for="maintenanceBar">Maintenance</label>
            <div class="maintenanceBar">100</div>
        </div>
    </div>

    </body>
    </html>
@endsection
