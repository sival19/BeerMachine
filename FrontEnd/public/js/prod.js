let channel = window.pusher.subscribe('my-channel');
channel.bind('my-event', function(data) {document.getElementById('beerProdCount').value = data.message.value;});
