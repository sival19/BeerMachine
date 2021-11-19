<html>
<header>
    <title>Show production</title>
</header>

<body>
<h1>Show productions</h1>

<script type="text/javascript" src="{{ mix('js/app.js') }}"></script>



<form>
{{--    <a href="{{route("home")}}">Back</a>--}}

    <button>
        <a href="javascript:history.back()">Go Back</a>
    </button>

    <br>
    <label>ProductCount:</label>
    <input type="text" name="code" value="" id="beerProdCount">

    <br>
    <label>Prod:</label>
    <input type="text" name="code" value="" id="beer">
</form>

<form>
    <br>
    <h3> See a specific production:</h3>
    <a href="{{route("show_production-link")}}">See a production</a>
</form>

<script type="text/javascript" src="{{ asset('js/prod.js') }}"></script>
</body>
</html>
