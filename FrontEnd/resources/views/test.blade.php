<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<form action="/clearButton" method="post">
    @csrf
    <label for="clear"></label>
    <input type="number" name="clearValue" step="0.0" placeholder="machineSpeed">
    <button type="submit">Submit</button>

</form>

</body>
</html>
