<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <title>Document</title>
</head>
<body>
<script type="text/javascript">
    $(document).ready(function (){
        loadFile();
        function loadFile(){
            $.ajax({
                url: 'getState',
                type: 'GET',
                datatype: 'json',
                success: function (data){
                    console.log(data);
                    let ul = $('#getRequestData');
                    for (i in data){
                        let li = $("<li></li>").appendTo(ul);
                        li.text(data[i].status);
                    }
                }
            });
        }
    });
</script>

<ul id="getRequestData">


</ul>

</body>
</html>
