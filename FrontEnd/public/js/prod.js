let channel = window.pusher.subscribe('my-channel');

const yeastBar = document.querySelector('#yeast-bar');
const hopsBar = document.querySelector('#hops-bar');
const maltBar = document.querySelector('#malt-bar');
const barleyBar = document.querySelector('#barley-bar');
const wheatBar = document.querySelector('#wheat-bar');
const maintenanceBar = document.querySelector('#maintenanceBar')

const animateYeastBar = () => {
    channel.bind('yeastAmount', function(data){
        let maxInv = 35000;
        let currentInv = data.message.value
        let yeastProgressWidth = (currentInv / maxInv) * 100;
        let yeastValue = Math.floor(yeastProgressWidth);
        yeastBar.innerHTML = currentInv;
        yeastBar.style.width = yeastValue * 3 + 'px';

    });}
const animateHopsBar = () => {
    channel.bind('hopsAmount', function(data){
        let maxInv = 35000;
        let currentInv = data.message.value
        let yeastProgressWidth = (currentInv / maxInv) * 100;
        let yeastValue = Math.floor(yeastProgressWidth);
        hopsBar.innerHTML = currentInv;
        hopsBar.style.width = yeastValue * 3 + 'px';

    });}
const animateMaltBar = () => {
    channel.bind('maltAmount', function(data){
        let maxInv = 35000;
        let currentInv = data.message.value
        let yeastProgressWidth = (currentInv / maxInv) * 100;
        let yeastValue = Math.floor(yeastProgressWidth);
        maltBar.innerHTML = currentInv;
        maltBar.style.width = yeastValue * 3 + 'px';

    });}
const animateBarleyBar = () => {
    channel.bind('barleyAmount', function(data){
        let maxInv = 35000;
        let currentInv = data.message.value
        let yeastProgressWidth = (currentInv / maxInv) * 100;
        let yeastValue = Math.floor(yeastProgressWidth);
        barleyBar.innerHTML = currentInv;
        barleyBar.style.width = yeastValue * 3 + 'px';

    });}
const animateWheatBar = () => {
    channel.bind('wheatAmount', function(data){
        let maxInv = 35000;
        let currentInv = data.message.value
        let yeastProgressWidth = (currentInv / maxInv) * 100;
        let yeastValue = Math.floor(yeastProgressWidth);
        wheatBar.innerHTML = currentInv;
        wheatBar.style.width = yeastValue * 3 + 'px';

    });}

const animateMaintenanceBar = () => {
    channel.bind('maintenance', function(data){
        let maintenanceTrigger = 30000;
        let currentMaintenanceCount = data.message.value.value;
        let maintenanceWidth = (currentMaintenanceCount / maintenanceTrigger) * 100;
        let maintValue = Math.floor(maintenanceWidth);
        maintenanceBar.innerHTML = currentMaintenanceCount + '/30000';
        maintenanceBar.style.height = maintValue * 4 + 'px';

    });}

animateMaintenanceBar();
animateHopsBar();
animateYeastBar();
animateWheatBar();
animateBarleyBar();
animateMaltBar();



channel.bind('production.produced', function(data) {document.getElementById('production.produced').innerHTML = data.message.value.value;});
channel.bind('production.Defective', function(data) {document.getElementById('production.Defective').innerHTML = data.message.value;});
channel.bind('production.Good', function(data) {document.getElementById('production.Good').innerHTML = data.message.value.value;});

channel.bind('sensor.Humidity', function(data) {document.getElementById('sensor.Humidity').innerHTML = data.message.value;});
channel.bind('sensor.Temperature', function(data) {document.getElementById('sensor.Temperature').innerHTML = data.message.value;});
channel.bind('sensor.Vibration', function(data) {document.getElementById('sensor.Vibration').innerHTML = data.message.value;});

channel.bind('state.current', function(data) {document.getElementById('state.current').innerHTML = data.message.value;});
channel.bind('state.read', function(data) {document.getElementById('state.current').innerHTML = data.message.value;});

