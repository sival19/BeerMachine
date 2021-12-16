@extends('master')
@section('content')
    <!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="{{'/css/charts.css'}}">
    <title>Document</title>
</head>
<body>


<div class="graphs">
    <div class="graph">
        {{ $chart2->container() }}

    </div>
</div>
<div class="graphs">
    <div class="graph">
        {{ $chart->container() }}

    </div>
</div>
<div class="graphs">
    <div class="graph">
        {{ $chart3->container() }}

    </div>
</div>
<div class="graphs">
    <div class="graph">
        {{ $chart4->container() }}

    </div>

</div>
<div class="graphs">
    <div class="graph">
        {{ $chart5->container() }}

    </div>
</div>

<div class="graphs">


    <div class="graph">
        {{ $chart6->container() }}
    </div>
</div>


<script src="{{ $chart->cdn() }}"></script>
<script src="{{ $chart2->cdn() }}"></script>
<script src="{{ $chart3->cdn() }}"></script>
<script src="{{ $chart4->cdn() }}"></script>
<script src="{{ $chart5->cdn() }}"></script>
<script src="{{ $chart6->cdn() }}"></script>
{{ $chart->script() }}
{{ $chart2->script() }}
{{ $chart3->script() }}
{{ $chart4->script() }}
{{ $chart5->script() }}
{{ $chart6->script() }}
</body>
</html>
@endsection
