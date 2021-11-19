let channel = window.pusher.subscribe('my-channel');
channel.bind('my-event', function(data) {document.getElementById('beerProdCount').value = data.message.value.value;});

channel.bind('new-event', function(data) {document.getElementById('beer').value = data.message.value;});
