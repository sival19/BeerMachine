@extends("master")

@section('content')
<title>Show production</title>

<h1>Show productions</h1>


    <button>
        <a href="javascript:history.back()">Go Back</a>
    </button>

    <br>
    <h3> See a specific production:</h3>
    <a href="{{route("show_production-link")}}">See a production</a>

@endsection
