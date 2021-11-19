<html>
<header>
    <title>Show production</title>
</header>

<body>
<h1>Show productions</h1>
<h2>Test</h2>

<script type="text/javascript" src="{{ mix('js/app.js') }}"></script>



<form>
    <a href="{{route("home")}}">Back</a>

    <button>
        <a href="javascript:history.back()">Go Back</a>
    </button>

    <br>
    <label>ProductCount:</label>
    <input type="text" name="code" value="" id="beerProdCount">


</form>

<script type="text/javascript" src="{{ asset('js/prod.js') }}"></script>
</body>
</html>
