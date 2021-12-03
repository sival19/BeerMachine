<!doctype html>
<html>
<head>
    <title>Beer Machine</title>
    <link rel="stylesheet" type="text/css" href="{{'/css/master.css'}}">
</head>

<body>

<!--Navigation bar-->
<nav>
    <ul>
        <li><a href="{{route("home")}}">Home</a></li>
        <li><a href="{{route("production.start")}}">Start Production</a></li>
        <li><a href="{{route("show_productions-link")}}">Show Productions</a></li>
    </ul>
</nav>
@yield('content')
</body>
</html>