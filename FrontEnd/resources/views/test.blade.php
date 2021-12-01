<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<form action="/beginProduction" method="post">
    @csrf
    <label for="machineSpeed"></label>
    <input type="number" name="machineSpeed" step="0.0" placeholder="machineSpeed">
    <input type="number" name="amount" step="0.0" placeholder="amount">
    <input type="number" name="type" step="0.0" placeholder="type">

    <button type="submit">Submit</button>

</form>

</body>
</html>
