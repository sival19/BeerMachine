let channel = window.pusher.subscribe('my-channel');

const yeastBar = document.querySelector('#yeast-bar');

const animateYeastBar = () => {
    channel.bind('yeastAmount', function(data) {console.log(data.message.value);});
    let maxInv = 35000;

    // console.log(currentInv)

}

animateYeastBar();



channel.bind('production.produced', function(data) {document.getElementById('production.produced').innerHTML = data.message.value.value;});
channel.bind('production.Defective', function(data) {document.getElementById('production.Defective').innerHTML = data.message.value;});
channel.bind('production.Good', function(data) {document.getElementById('production.Good').innerHTML = data.message.value.value;});

channel.bind('sensor.Humidity', function(data) {document.getElementById('sensor.Humidity').innerHTML = data.message.value;});
channel.bind('sensor.Temperature', function(data) {document.getElementById('sensor.Temperature').innerHTML = data.message.value;});
channel.bind('sensor.Vibration', function(data) {document.getElementById('sensor.Vibration').innerHTML = data.message.value;});

channel.bind('state.current', function(data) {document.getElementById('state.current').innerHTML = data.message.value;});
channel.bind('state.read', function(data) {document.getElementById('state.current').innerHTML = data.message.value;});

