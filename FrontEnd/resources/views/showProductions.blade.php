<html>
<header>
    <title>Show production</title>
</header>

<body>
<h1>SHow productions</h1>

<form action="">
    <button>
        <input type="button" value="Go back!" onclick="history.back()">
    </button>

    <button>
        <input type="button" value="Home" onclick="{{route("home")}}">
    </button>
</form>{{--<a href="{{route('Home')}}">Back</a>--}}

</body>
</html>
