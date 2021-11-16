<html>
<header>
    <title>Show production</title>
</header>

<body>
<h1>Show productions</h1>

<h2>
    <script type="text/javascript" src="{{ mix('js/app.js') }}"></script>

</h2>


<form>
    <a href="{{route("home")}}">Back</a>

    <button>
        <a href="javascript:history.back()">Go Back</a>
    </button>



</form>

<script type="text/javascript">
    var channel = window.pusher.subscribe('my-channel');
    channel.bind('my-event', function(data) {
        console.log('Received my-event with message: ' + data.message);
        document.write(data.message.value);
    });


</script>
</body>
</html>
